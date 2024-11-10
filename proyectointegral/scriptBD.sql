-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sistemaclase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistemaclase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemaclase` DEFAULT CHARACTER SET utf8 ;
USE `sistemaclase` ;

-- -----------------------------------------------------
-- Table `sistemaclase`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`categorias` (
  `cat_id` INT NOT NULL AUTO_INCREMENT,
  `cat_nombre` VARCHAR(45) NOT NULL,
  `cat_descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cat_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaclase`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`cursos` (
  `cur_id` INT NOT NULL AUTO_INCREMENT,
  `cur_nombre` VARCHAR(45) NOT NULL,
  `cur_creditos` INT NOT NULL,
  `cur_costo` DECIMAL(8,2) NOT NULL,
  `cat_id` INT NOT NULL,
  PRIMARY KEY (`cur_id`),
  INDEX `fk_cursos_categorias_idx` (`cat_id` ASC),
  CONSTRAINT `fk_cursos_categorias`
    FOREIGN KEY (`cat_id`)
    REFERENCES `sistemaclase`.`categorias` (`cat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaclase`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`carrera` (
  `car_id` INT NOT NULL AUTO_INCREMENT,
  `car_nombre` VARCHAR(45) NOT NULL,
  `car_facultad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`car_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaclase`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`alumnos` (
  `alu_id` INT NOT NULL AUTO_INCREMENT,
  `alu_codigo` VARCHAR(45) NOT NULL,
  `alu_nombres` VARCHAR(45) NOT NULL,
  `alu_apellidos` VARCHAR(45) NOT NULL,
  `alu_correo` VARCHAR(45) NOT NULL,
  `alu_celular` VARCHAR(45) NOT NULL,
  `car_id` INT NOT NULL,
  PRIMARY KEY (`alu_id`),
  INDEX `fk_alumnos_carrera1_idx` (`car_id` ASC),
  CONSTRAINT `fk_alumnos_carrera1`
    FOREIGN KEY (`car_id`)
    REFERENCES `sistemaclase`.`carrera` (`car_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaclase`.`semestres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`semestres` (
  `sem_id` INT NOT NULL AUTO_INCREMENT,
  `sem_descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sem_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaclase`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`matricula` (
  `mat_id` INT NOT NULL AUTO_INCREMENT,
  `mat_fecha` DATETIME NOT NULL,
  `mat_costo` DECIMAL NOT NULL,
  `sem_id` INT NOT NULL,
  `alu_id` INT NOT NULL,
  PRIMARY KEY (`mat_id`),
  INDEX `fk_matricula_semestres1_idx` (`sem_id` ASC),
  INDEX `fk_matricula_alumnos1_idx` (`alu_id` ASC),
  CONSTRAINT `fk_matricula_semestres1`
    FOREIGN KEY (`sem_id`)
    REFERENCES `sistemaclase`.`semestres` (`sem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_alumnos1`
    FOREIGN KEY (`alu_id`)
    REFERENCES `sistemaclase`.`alumnos` (`alu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaclase`.`detalle_matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaclase`.`detalle_matricula` (
  `det_id` INT NOT NULL AUTO_INCREMENT,
  `cur_id` INT NOT NULL,
  `mat_id` INT NOT NULL,
  PRIMARY KEY (`det_id`),
  INDEX `fk_detalle_matricula_cursos1_idx` (`cur_id` ASC),
  INDEX `fk_detalle_matricula_matricula1_idx` (`mat_id` ASC),
  CONSTRAINT `fk_detalle_matricula_cursos1`
    FOREIGN KEY (`cur_id`)
    REFERENCES `sistemaclase`.`cursos` (`cur_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_matricula_matricula1`
    FOREIGN KEY (`mat_id`)
    REFERENCES `sistemaclase`.`matricula` (`mat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
