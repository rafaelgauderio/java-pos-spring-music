package com.utfpr.backend_categoria_musica_spring;

import com.utfpr.backend_categoria_musica_spring.entity.Musica;
import com.utfpr.backend_categoria_musica_spring.entity.Categoria;
import com.utfpr.backend_categoria_musica_spring.service.CategoriaService;
import com.utfpr.backend_categoria_musica_spring.service.MusicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendCategoriaMusicaSpringApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendCategoriaMusicaSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendCategoriaMusicaSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService categoriaService, MusicaService musicaService) {

		return (arg) -> {

			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("===========Listagem das Musicas");
			for (Musica nickname : musicaService.findAllMusics()) {
				log.info(nickname.toString());
			}

			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("===========Listagem das Categorias");
			for (Categoria nickname : categoriaService.findAllCategories()) {
				log.info(nickname.toString());
			}



			log.info("");
			log.info("");
			log.info("===========Encontrar Musica Luiza - JPQL");
			Musica musica01 = musicaService.findMusica("Luiza");
			log.info(musica01.toString());

			log.info("");
			log.info("");
			log.info("===========Encontrar Musica Gentileza - Palavras Chaves");
			Musica musica02 = musicaService.findMusica("Gentileza");
			log.info(musica02.toString());

			log.info("");
			log.info("");
			log.info("===========Encontrar Musica Vira-vira- Palavras Chaves");
			Musica musica03 = musicaService.findMusicaByKeyWord("Vira-vira");
			log.info(musica03.toString());

			log.info("");
			log.info("");
			log.info("===========Listagem Musicas com duracao maior que 300");
			for(Musica nickname : musicaService.listarMusicasComDuracaoMaiorQue(300))  {
				log.info(nickname.toString());
			}

			log.info("");
			log.info("");
			log.info("===========Listagem Musicas com duracao maior que 450");
			for(Musica nickname : musicaService.listarMusicasComDuracaoMaiorQue(450))  {
				log.info(nickname.toString());
			}

			log.info("");
			log.info("");
			log.info("===========Encontrar musica com MAIOR duracao");
			Musica musica04 = musicaService.findFirstMusicWithGreaterDuration();
			log.info(musica04.toString());

			log.info("");
			log.info("");
			log.info("===========Encontrar musica com MENOR duracao");
			Musica musica05 = musicaService.findFirstMusicaWithShorterDuration();
			log.info(musica05.toString());


		};
	}
}
