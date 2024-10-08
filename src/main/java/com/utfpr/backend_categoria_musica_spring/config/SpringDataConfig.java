package com.utfpr.backend_categoria_musica_spring.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories("com.utfpr.backend_categoria_musica_spring.repository")
@EnableTransactionManagement
public class SpringDataConfig {

    @Bean
    public DataSource dataSource () {

        HikariDataSource dataSource = new HikariDataSource();

        /*
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setJdbcUrl("jdbc:h2:mem:test");
        dataSource.setDriverClassName("org.h2.Driver");
        */
        dataSource.setUsername("root");
        dataSource.setPassword("hygie123*");
        dataSource.setJdbcUrl("jdbc:mariadb://127.0.0.1:3307/dml");
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");

        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory () {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter ();
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(false);

        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.utfpr.backend_categoria_musica_spring.entity");
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager () {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        transactionManager.setJpaDialect(new HibernateJpaDialect());

        return transactionManager;
    }


}


