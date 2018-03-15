/*
*****************************************************************************
*																			*
*			Titre :			sql_drugStudy.sql								*
*			Auteur:			Iain Frost										*
*			Date:			06 mars 2018									*
*			Description:	Contient les instructions pour construire 		*
*							la base de donnée pour le projet d'étude des	*
*							médicaments.									*
*																			*
*****************************************************************************
*/

CREATE DATABASE medicamentEtudeDB;

CREATE TABLE patient (
	id_patient INT NOT NULL UNIQUE AUTO_INCREMENT,
	nom_patient VARCHAR(32),
	prenom_patient VARCHAR(32),
	adresse_patient VARCHAR(256),
	date_naissance DATE,
	no_tel_maison VARCHAR(12),
	no_tel_mobile VARCHAR(12),
	no_tel_urgences VARCHAR(12),
	contact_urgences VARCHAR(32),
	email_patient VARCHAR(32),
	numero_assu_maladie VARCHAR(12),
	PRIMARY KEY(id_patient)
);

CREATE TABLE professionnel(
	no_professionnel INT NOT NULL UNIQUE AUTO_INCREMENT,
	nom_professionnel VARCHAR(32),
	prenom_professionnel VARCHAR(32),
	specialite VARCHAR(32),
	adresse_professionnel VARCHAR(256),
	no_tel_maison VARCHAR(12),
	no_tel_mobile VARCHAR(12),
	no_tel_bureau VARCHAR(12),
	no_pagette VARCHAR(12),/* padget ? */
	no_fax VARCHAR(12),
	email_professionnel VARCHAR(32),
	PRIMARY KEY(no_professionnel)
);

CREATE TABLE type_etude(
	id_type_etu INT NOT NULL UNIQUE AUTO_INCREMENT,
	nom_type VARCHAR(32),
	description_type TEXT,
	commentaire_type TEXT,
	PRIMARY KEY(id_type_etu)
);

CREATE TABLE etude(
	id_etude INT NOT NULL UNIQUE AUTO_INCREMENT,
	titre_etude VARCHAR(32),
	description_etude TEXT,
	date_debut DATE,
	date_fin DATE,
	id_type_etude INT,
	PRIMARY KEY(id_etude),
	FOREIGN KEY(id_type_etude)REFERENCES type_etude(id_type_etu)ON DELETE CASCADE
);

CREATE TABLE medicament(
	id_medicament INT NOT NULL UNIQUE AUTO_INCREMENT,
	nom_medicament VARCHAR(32),
	description_medicament TEXT,
	commentaire_medicament TEXT,
	PRIMARY KEY(id_medicament)
);

CREATE TABLE prescription(
	no_prescription INT NOT NULL UNIQUE AUTO_INCREMENT,
	posologie TEXT,
	commentaire TEXT,
	id_medicament INT,
	id_etude INT,
	PRIMARY KEY(no_prescription),
	FOREIGN KEY(id_medicament)REFERENCES medicament(id_medicament)ON DELETE CASCADE,
	FOREIGN KEY(id_etude) REFERENCES etude(id_etude)ON DELETE CASCADE
);

CREATE TABLE prise_medicament(
	id_prise_medicament INT NOT NULL UNIQUE AUTO_INCREMENT,
	date_prise_medicament TIMESTAMP,
	id_patient INT,
	id_prescription INT,
	PRIMARY KEY(id_prise_medicament),
	FOREIGN KEY(id_patient) REFERENCES patient(id_patient)ON DELETE CASCADE,
	FOREIGN KEY(id_prescription)REFERENCES prescription(no_prescription)ON DELETE CASCADE
);

CREATE TABLE TA_liste_patient(
	id_liste_patient INT NOT NULL UNIQUE AUTO_INCREMENT,
	id_etude INT,
	id_patient INT,
	PRIMARY KEY(id_liste_patient),
	FOREIGN KEY(id_etude) REFERENCES etude(id_etude)ON DELETE CASCADE,
	FOREIGN KEY(id_patient) REFERENCES patient(id_patient)ON DELETE CASCADE
);

CREATE TABLE TA_etude_professionel(
	id_ta_etu_prof INT NOT NULL UNIQUE AUTO_INCREMENT,
	id_etude INT,
	id_prof INT,
	PRIMARY KEY(id_ta_etu_prof),
	FOREIGN KEY(id_etude)  REFERENCES etude(id_etude)ON DELETE CASCADE,
	FOREIGN KEY(id_prof) REFERENCES professionnel(no_professionnel)ON DELETE CASCADE
);