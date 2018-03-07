
CREATE DATABASE medicamentEtudeDB;

CREATE TABLE patient (
	id_patient INT,
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

CREATE TABLE profesionnel(
	no_professionnel INT,
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

CREATE TABLE etude(
	id_etude INT,
	titre_etude VARCHAR(32),
	description_etude TEXT,
	date_debut DATE,
	date_fin DATE,
	id_type_etude INT,
	PRIMARY KEY(id_etude),
	FOREIGN KEY(id_type_etude)
);

CREATE TABLE medicament(
	id_medicament INT,
	nom_medicament VARCHAR(32),
	description_medicament TEXT,
	commentaire_medicament TEXT,
	PRIMARY KEY(id_medicament)
);

CREATE TABLE prescription(
	no_prescription INT,
	posologie TEXT,
	commentaire TEXT,
	id_medicament INT,
	id_professionel INT,
	PRIMARY KEY(no_prescription),
	FOREIGN KEY(id_medicament),
	FOREIGN KEY(id_professionel)
);

CREATE TABLE prise_medicament(
	id_prise_medicament INT,
	date_prise_medicament DATE,
	heure_prise_medicament TIMESTAMP,
	id_patient INT,
	id_prescription INT,
	PRIMARY KEY(id_prise_medicament),
	FOREIGN KEY(id_patient),
	FOREIGN KEY(id_prescription)
);

CREATE TABLE TA_liste_patient(
	id_liste_patient INT,
	id_etude INT,
	id_patient INT,
	PRIMARY KEY(id_liste_patient),
	FOREIGN KEY(id_etude),
	FOREIGN KEY(id_patient)
);

CREATE TABLE type_etude(
	id_type_etu INT,
	nom_type VARCHAR(32),
	description_type TEXT,
	commentaire_type TEXT,
	PRIMARY KEY(id_type_etu)

);

TA_etude_professionel(
	id_ta_etu_prof INT,
	id_etude INT,
	id_prof INT,
	PRIMARY KEY(id_ta_etu_prof),
	FOREIGN KEY(id_etude),
	FOREIGN KEY(id_prof)
);