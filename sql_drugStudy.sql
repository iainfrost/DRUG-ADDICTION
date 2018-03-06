
CREATE DATABASE drugStudy;

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