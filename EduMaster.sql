-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema schoolMaster_test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schoolMaster_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schoolMaster_test` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema schoolmaster_test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schoolmaster_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schoolmaster_test` DEFAULT CHARACTER SET utf8 ;
USE `schoolMaster_test` ;

-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cursoNome` VARCHAR(255) NOT NULL,
  `cursoDescricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `disciplinaNome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Curso_Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Curso_Disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `curso_id` INT NOT NULL,
  `disciplina_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Curso_Disciplina_fk0` (`curso_id` ASC) VISIBLE,
  INDEX `Curso_Disciplina_fk1` (`disciplina_id` ASC) VISIBLE,
  CONSTRAINT `Curso_Disciplina_fk0`
    FOREIGN KEY (`curso_id`)
    REFERENCES `schoolMaster_test`.`Curso` (`id`),
  CONSTRAINT `Curso_Disciplina_fk1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `schoolMaster_test`.`Disciplina` (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Instituicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Instituicao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `instituicaoNome` VARCHAR(255) NOT NULL,
  `instituicaoReceita` INT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Docente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `disciplina_id` INT NOT NULL,
  `instituicao_id` INT NOT NULL,
  `docentePNome` VARCHAR(255) NOT NULL,
  `docenteUNome` VARCHAR(255) NOT NULL,
  `docenteDN` DATE NOT NULL,
  `docenteEntrada` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Docente_fk0` (`disciplina_id` ASC) VISIBLE,
  INDEX `Docente_fk1` (`instituicao_id` ASC) VISIBLE,
  CONSTRAINT `Docente_fk0`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `schoolMaster_test`.`Disciplina` (`id`),
  CONSTRAINT `Docente_fk1`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `schoolMaster_test`.`Instituicao` (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Instituicao_Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Instituicao_Curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `instituicao_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Instituicao_Curso_fk0` (`instituicao_id` ASC) VISIBLE,
  INDEX `Instituicao_Curso_fk1` (`curso_id` ASC) VISIBLE,
  CONSTRAINT `Instituicao_Curso_fk0`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `schoolMaster_test`.`Instituicao` (`id`),
  CONSTRAINT `Instituicao_Curso_fk1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `schoolMaster_test`.`Curso` (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Propina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Propina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `propinaCodigo` INT NOT NULL,
  `propinaValor` INT NOT NULL,
  `propinaPaga` TINYINT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Aluno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `alunoPNome` VARCHAR(255) NOT NULL,
  `alunoUNome` VARCHAR(255) NOT NULL,
  `alunoCodigo` INT NOT NULL,
  `propina_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Aluno_fk0` (`propina_id` ASC) VISIBLE,
  CONSTRAINT `Aluno_fk0`
    FOREIGN KEY (`propina_id`)
    REFERENCES `schoolMaster_test`.`Propina` (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`Aluno_Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`Aluno_Curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aluno_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`instituicao_propina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`instituicao_propina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `instituicao_id` INT NOT NULL,
  `propina_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `instituicao_propina_fk0` (`instituicao_id` ASC) VISIBLE,
  INDEX `instituicao_propina_fk1` (`propina_id` ASC) VISIBLE,
  CONSTRAINT `instituicao_propina_fk0`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `schoolMaster_test`.`Instituicao` (`id`),
  CONSTRAINT `instituicao_propina_fk1`
    FOREIGN KEY (`propina_id`)
    REFERENCES `schoolMaster_test`.`Propina` (`id`));


-- -----------------------------------------------------
-- Table `schoolMaster_test`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolMaster_test`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NOT NULL,
  `UserPassword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

USE `schoolmaster_test` ;

-- -----------------------------------------------------
-- Table `schoolmaster_test`.`propina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`propina` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `propinaCodigo` INT(11) NOT NULL,
  `propinaValor` INT(11) NOT NULL,
  `propinaPaga` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`aluno` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `alunoPNome` VARCHAR(255) NOT NULL,
  `alunoUNome` VARCHAR(255) NOT NULL,
  `alunoCodigo` INT(11) NOT NULL,
  `propina_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Aluno_fk0` (`propina_id` ASC) VISIBLE,
  CONSTRAINT `Aluno_fk0`
    FOREIGN KEY (`propina_id`)
    REFERENCES `schoolmaster_test`.`propina` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cursoNome` VARCHAR(255) NOT NULL,
  `cursoDescricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`aluno_curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`aluno_curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `aluno_id` INT(11) NOT NULL,
  `curso_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `curso_id` (`curso_id` ASC) VISIBLE,
  INDEX `aluno_id` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `aluno_curso_ibfk_1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `schoolmaster_test`.`curso` (`id`),
  CONSTRAINT `aluno_curso_ibfk_2`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `schoolmaster_test`.`aluno` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`disciplina` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `disciplinaNome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`curso_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`curso_disciplina` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `curso_id` INT(11) NOT NULL,
  `disciplina_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Curso_Disciplina_fk0` (`curso_id` ASC) VISIBLE,
  INDEX `Curso_Disciplina_fk1` (`disciplina_id` ASC) VISIBLE,
  CONSTRAINT `Curso_Disciplina_fk0`
    FOREIGN KEY (`curso_id`)
    REFERENCES `schoolmaster_test`.`curso` (`id`),
  CONSTRAINT `Curso_Disciplina_fk1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `schoolmaster_test`.`disciplina` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`instituicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`instituicao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `instituicaoNome` VARCHAR(255) NOT NULL,
  `instituicaoReceita` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`docente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `disciplina_id` INT(11) NOT NULL,
  `instituicao_id` INT(11) NOT NULL,
  `docentePNome` VARCHAR(255) NOT NULL,
  `docenteUNome` VARCHAR(255) NOT NULL,
  `docenteDN` DATE NOT NULL,
  `docenteEntrada` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Docente_fk0` (`disciplina_id` ASC) VISIBLE,
  INDEX `Docente_fk1` (`instituicao_id` ASC) VISIBLE,
  CONSTRAINT `Docente_fk0`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `schoolmaster_test`.`disciplina` (`id`),
  CONSTRAINT `Docente_fk1`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `schoolmaster_test`.`instituicao` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`instituicao_curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`instituicao_curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `instituicao_id` INT(11) NOT NULL,
  `curso_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Instituicao_Curso_fk0` (`instituicao_id` ASC) VISIBLE,
  INDEX `Instituicao_Curso_fk1` (`curso_id` ASC) VISIBLE,
  CONSTRAINT `Instituicao_Curso_fk0`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `schoolmaster_test`.`instituicao` (`id`),
  CONSTRAINT `Instituicao_Curso_fk1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `schoolmaster_test`.`curso` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`instituicao_propina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`instituicao_propina` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `instituicao_id` INT(11) NOT NULL,
  `propina_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `instituicao_propina_fk0` (`instituicao_id` ASC) VISIBLE,
  INDEX `instituicao_propina_fk1` (`propina_id` ASC) VISIBLE,
  CONSTRAINT `instituicao_propina_fk0`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `schoolmaster_test`.`instituicao` (`id`),
  CONSTRAINT `instituicao_propina_fk1`
    FOREIGN KEY (`propina_id`)
    REFERENCES `schoolmaster_test`.`propina` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `schoolmaster_test`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolmaster_test`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NOT NULL,
  `UserPassword` VARCHAR(45) NOT NULL,
  `UserImage` BLOB NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
