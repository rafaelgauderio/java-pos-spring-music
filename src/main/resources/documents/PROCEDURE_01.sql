USE dml;

DELIMITER $$
CREATE PROCEDURE proc_add_music_duration(IN in_ammount INT)
BEGIN
	UPDATE musica
	SET duracao = duracao + in_ammount;
END$$
DELIMITER;


DELIMITER $$
CREATE PROCEDURE proc_sub_music_duration(IN in_ammount INT)
BEGIN
	UPDATE musica
	SET duracao = duracao - in_ammount;
END$$
DELIMITER;

/*
# apagar uma procedure
DROP PROCEDURE proc_sub_musica_duration

*/

SELECT musica.duracao
FROM musica
WHERE musica.cod_musica =1;

CALL proc_add_music_duration(40);

SELECT musica.duracao
FROM musica
WHERE musica.cod_musica =1;

CALL proc_sub_music_duration(200);

SELECT musica.duracao
FROM musica
WHERE musica.cod_musica =1;
