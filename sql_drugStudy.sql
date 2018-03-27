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
CREATE DATABASE medicamentetudedb;

USE medicamentetudedb;

CREATE TABLE patient  (
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

CREATE TABLE professionnel (
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

CREATE TABLE type_etude (
	id_type_etu INT NOT NULL UNIQUE AUTO_INCREMENT,
	nom_type VARCHAR(32),
	description_type TEXT,
	commentaire_type TEXT,
	PRIMARY KEY(id_type_etu)
);

CREATE TABLE etude (
	id_etude INT NOT NULL UNIQUE AUTO_INCREMENT,
	titre_etude VARCHAR(32),
	description_etude TEXT,
	date_debut DATE,
	date_fin DATE,
	id_type_etude INT,
	PRIMARY KEY(id_etude),
	FOREIGN KEY(id_type_etude)REFERENCES type_etude(id_type_etu)ON DELETE CASCADE
);

CREATE TABLE medicament (
	id_medicament INT NOT NULL UNIQUE AUTO_INCREMENT,
	nom_medicament VARCHAR(32),
	description_medicament TEXT,
	commentaire_medicament TEXT,
	PRIMARY KEY(id_medicament)
);

CREATE TABLE prescription (
	no_prescription INT NOT NULL UNIQUE AUTO_INCREMENT,
	posologie TEXT,
	commentaire TEXT,
	id_medicament INT,
	id_etude INT,
	PRIMARY KEY(no_prescription),
	FOREIGN KEY(id_medicament)REFERENCES medicament(id_medicament)ON DELETE CASCADE,
	FOREIGN KEY(id_etude) REFERENCES etude(id_etude)ON DELETE CASCADE
);

CREATE TABLE prise_medicament (
	id_prise_medicament INT NOT NULL UNIQUE AUTO_INCREMENT,
	date_prise_medicament DATE,
	id_patient INT,
	id_prescription INT,
	PRIMARY KEY(id_prise_medicament),
	FOREIGN KEY(id_patient) REFERENCES patient(id_patient)ON DELETE CASCADE,
	FOREIGN KEY(id_prescription)REFERENCES prescription(no_prescription)ON DELETE CASCADE
);

CREATE TABLE TA_liste_patient (
	id_liste_patient INT NOT NULL UNIQUE AUTO_INCREMENT,
	id_etude INT,
	id_patient INT,
	PRIMARY KEY(id_liste_patient),
	FOREIGN KEY(id_etude) REFERENCES etude(id_etude)ON DELETE CASCADE,
	FOREIGN KEY(id_patient) REFERENCES patient(id_patient)ON DELETE CASCADE
);

CREATE TABLE TA_etude_professionel (
	id_ta_etu_prof INT NOT NULL UNIQUE AUTO_INCREMENT,
	id_etude INT,
	id_prof INT,
	PRIMARY KEY(id_ta_etu_prof),
	FOREIGN KEY(id_etude)  REFERENCES etude(id_etude)ON DELETE CASCADE,
	FOREIGN KEY(id_prof) REFERENCES professionnel(no_professionnel)ON DELETE CASCADE
);

/* Ajout dans la table type d'études */

INSERT INTO type_etude (nom_type, description_type, commentaire_type)
	VALUES 	('Descriptive', "Décrivent des variables individuelles", NULL),
			('Analytique', "Analyse d'association entre 2 ou plusieurs variables", NULL),
			('Cas Témoin', "Sélectionn des sujets réalisés en fonction de l'issue", NULL),
			('Rapport de cas', "Description d'un cas intéresssant et inhabituel",  NULL);
 

	
/* Ajout dans la table étude */

INSERT INTO etude (titre_etude, description_etude, date_debut, date_fin, id_type_etude) 
	VALUES 	('Aspirine_1', "Premier test des aspirines", '2008-01-02', '2008-01-06', 1),
			('Aspirine_2', "Deuxième test des aspirines", '2010-04-12', '2010-04-23', 3),
			('Hydromorphone_1', "Premier test d'hydromorphone", '2012-03-21', '2012-04-12', 4),
			('Aspirine_3', "Troisième test des aspirines", '2015-05-01', '2015-06-30', 2),
			('Effexor_1', "Premier test d'effexor", '2017-01-02', '2017-02-02' , 3);

	
/* Ajout dans la table médicament */

INSERT INTO medicament (nom_medicament, description_medicament, commentaire_medicament) 
	VALUES 	('Aspirine', "Contre les maux de tête", NULL),
			('Hydromorphone', "Contre les douleurs graves", "Variante de morphine"),
			('Effexor', "Anti-dépresseur", NULL);
	


/* Ajout dans la table professionnel */

INSERT INTO professionnel (nom_professionnel, prenom_professionnel, specialite, adresse_professionnel, no_tel_maison, no_tel_mobile, no_tel_bureau, no_pagette, no_fax, email_professionnel) 
	VALUES 	('Bouleau', 'Martin', 'Neurologie', '124, rue des avions, Sherbrooke, QC CA', NULL, '819-124-3456', '819-124-7546', NULL, '819-124-7547', 'martinb@gmail.com'),
			('Morin', 'Gaston', 'Neuropsychiatrie', '344, rue des renards, Sherbrooke, QC CA', '819-344-6543', '819-450-3245', '819-564-2981', '819-578-4333', '819-564-2982', 'gastonm@gmail.com'),
			('Beaudoin', 'Alfred', 'Cardiologie', '1254, rue de la reine, Sherbrooke, QC CA', '819-654-3457', '567-345-3456', '819-901-9823', NULL, '819-901-9824', 'alfredb@gmail.com'),
			('Rose', 'Violet', 'Pneumologie', '756, rue du mouvement, Sherbrooke, QC CA', '819-721-4374', '321-345-6721', '819-520-6345', '819-091-2378', '819-520-6346', 'violetr@gmail.com');	

	
/* Ajout dans la table ta_etude_professionnel */

INSERT INTO ta_etude_professionel (id_etude, id_prof) 
	VALUES 	(1, 3),
			(1, 2),
			(3, 1),
			(2, 4),
			(4, 2),
			(5, 4);

/* Ajout dans la table patient */

INSERT INTO patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	VALUES 	('Gaven', 'Loup', '55, avenue des canidés, Sherbrooke, QC CA', '1997-11-12', '819-567-2345', '819-324-7891', '819-346-9087', 'Jean', 'raz.an@hotmail.com', 'GAVL97111200'),	
			('Dussault', 'Marie', '346, boulevard des papillons, Sherbrooke, QC CA', '1978-12-30', '819-345-6345', '514-543-4567', '819-366-9000', 'Jonathan', 'butterfly@gmail.ca', 'DUSM78123021'),
			('Frost', 'Iain', '451, rue des avions, Sherbrooke, QC CA', '1978-03-15', '819-127-3452', '514-129-9032', '819-127-5432', 'Marcel', 'link@gmail.ca', 'FROI78031518'),	
			('Tremblay', 'Bob', '876, rue des filous , Sherbrooke, QC CA', '1975-01-11', '819-541-2345', '819-781-2376', '819-901-2348', 'Bernard', 'tremblant@gmail.ca', 'TREB75011121'),	
			('Graton', 'Willy', '777, avenue des peupliers , Sherbrooke, QC CA', '1982-02-27', '819-321-0002', '819-235-3045', '819-222-3457', 'Serge', NULL, 'GRAW82022702'),	
			('Tremblay', 'Robert', '567, boulevard des études , Sherbrooke, QC CA', '1973-03-17', '819-124-2389', '514-222-0918', '819-278-9017', 'Bill', 'kory12@outlook.fr', 'ROBT73031772'),	
			('Coen', 'Claudia', '3689, rue des tigres , Sherbrooke, QC CA', '1991-04-24', '819-097-8523', '514-219-8234', '819-098-2135', 'Julie', 'gaston@gmail.ca', 'CLAC91042490'),	
			('Pitt', 'Brad', '455, boulevard des sapins , Sherbrooke, QC CA', '1984-07-02', '819-876-0008', '819-543-8732', '819-333-5422', 'Serge', 'iamgod32@videotron.ca', 'BRAP84070223'),	
			('Tremblay', 'Maurice', '102, avenue des fous , Sherbrooke, QC CA', '1987-05-27', '819-124-7812', '514-543-5432', '819-278-9017', 'Bill', 'metoo12@gmail.ca', 'MAUT87052738'),
			('Aniston', 'Jennifer', '809, rue des jouets , Sherbrooke, QC CA', '1992-04-24', '819-124-8762', '514-345-7123', '819-761-3245', 'Will', 'random47@gmail.ca', 'JENA92042435');
	
/* Ajout dans la table ta_liste_patient */

/*Aspirine_1*/
INSERT INTO ta_liste_patient (id_etude, id_patient) 
	VALUES 	(1, 1),	
			(1, 3),				
			(1, 6),
			(1, 8),				
			(1, 9),				
			(1, 10);

	
/*Aspirine_2*/	
INSERT INTO ta_liste_patient (id_etude, id_patient) 
	VALUES 	(2, 4),
			(2, 2),	
			(2, 7);


/*Hydromorphone_1*/	
INSERT INTO ta_liste_patient (id_etude, id_patient) 
	VALUES 	(3, 1),
			(3, 8),
			(3, 3),
			(3, 2);
			
	
	
/*Aspirine_3*/	
INSERT INTO ta_liste_patient (id_etude, id_patient) 
	VALUES 	(4, 6);

	
/*Effexor_1*/	
INSERT INTO ta_liste_patient (id_etude, id_patient) 
	VALUES 	(5, 9),
			(5, 10),
			(5, 5);
	
	
/* Ajout dans la table prescription */


INSERT INTO prescription (posologie, commentaire, id_medicament, id_etude) 
	VALUES 	('1 comprimé 1 fois par jour', NULL, 1, 1),	/*Aspirine_1*/
			('1 comprimé 1 fois par jour', NULL, 1, 2),	/*Aspirine_2*/
			('1 comprimé au besoin', NULL, 2, 3),		/*Hydromorphone*/
			('1 comprimé 1 fois par jour', NULL, 1, 4),	/*Aspirine_3*/
			('2 comprimé 1 fois par jour', NULL, 3, 5);	/*Effexor*/	
				
	
	
/* Ajout dans la table prise_medicament */

/*Aspirine_1*/
INSERT INTO prise_medicament (date_prise_medicament, id_patient, id_prescription)
	VALUES 	('2008-01-02', 1, 1),	
			('2008-01-03', 1, 1),
			('2008-01-05', 1, 1), 
			('2008-01-06', 1, 1),
			('2008-01-02', 3, 1),	
			('2008-01-03', 3, 1),	
			('2008-01-04', 3, 1), 
			('2008-01-05', 3, 1),       
			('2008-01-06', 3, 1), 
			('2008-01-02', 6, 1),        
			('2008-01-03', 6, 1),         
			('2008-01-05', 6, 1),        
			('2008-01-06', 6, 1),
			('2008-01-02', 8, 1),         
			('2008-01-03', 8, 1),        
			('2008-01-04', 8, 1),        
			('2008-01-05', 8, 1),         
			('2008-01-06', 8, 1), 
			('2008-01-02', 9, 1),        
			('2008-01-03', 9, 1),     
			('2008-01-04', 9, 1),         
			('2008-01-05', 9, 1),         
			('2008-01-06', 9, 1),  
			('2008-01-03', 10, 1), 
			('2008-01-04', 10, 1), 
			('2008-01-05', 10, 1),        
			('2008-01-06', 10, 1);


/*Aspirine_2*/
INSERT INTO prise_medicament (date_prise_medicament, id_patient, id_prescription)
	VALUES 	('2010-04-12', 2, 2),
			('2010-04-13', 2, 2),
			('2010-04-14', 2, 2),
			('2010-04-15', 2, 2),
			('2010-04-16', 2, 2),
			('2010-04-17', 2, 2),
			('2010-04-18', 2, 2),
			('2010-04-19', 2, 2),
			('2010-04-20', 2, 2),
			('2010-04-21', 2, 2),
			('2010-04-22', 2, 2),
			('2010-04-23', 2, 2),
			('2010-04-12', 4, 2),
			('2010-04-13', 4, 2),
			('2010-04-15', 4, 2),
			('2010-04-18', 4, 2),
			('2010-04-19', 4, 2),
			('2010-04-21', 4, 2),
			('2010-04-22', 4, 2),
			('2010-04-23', 4, 2),
			('2010-04-12', 7, 2),
			('2010-04-14', 7, 2),
			('2010-04-16', 7, 2),
			('2010-04-17', 7, 2),
			('2010-04-18', 7, 2),
			('2010-04-19', 7, 2),
			('2010-04-20', 7, 2),
			('2010-04-21', 7, 2),
			('2010-04-23', 7, 2);

/*Hydromorphone*/
INSERT INTO prise_medicament (date_prise_medicament, id_patient, id_prescription)
	VALUES 	('2012-03-21', 3, 3),
			('2012-03-22', 3, 3),
			('2012-03-23', 3, 3),
			('2012-03-24', 3, 3),
			('2012-03-25', 3, 3),
			('2012-03-26', 3, 3),
			('2012-03-27', 3, 3),
			('2012-03-28', 3, 3),
			('2012-03-29', 3, 3),
			('2012-03-31', 3, 3),
			('2012-04-01', 3, 3),
			('2012-04-02', 3, 3),
			('2012-04-03', 3, 3),
			('2012-04-04', 3, 3),
			('2012-04-05', 3, 3),
			('2012-04-06', 3, 3),
			('2012-04-07', 3, 3),
			('2012-04-09', 3, 3),
			('2012-04-10', 3, 3),
			('2012-04-11', 3, 3),
			('2012-04-12', 3, 3),                
			('2012-03-21', 2, 3),
			('2012-03-23', 2, 3),
			('2012-03-24', 2, 3),
			('2012-03-26', 2, 3),
			('2012-03-28', 2, 3),
			('2012-03-29', 2, 3),
			('2012-03-30', 2, 3),
			('2012-04-01', 2, 3),
			('2012-04-02', 2, 3),
			('2012-04-03', 2, 3),
			('2012-04-04', 2, 3),
			('2012-04-05', 2, 3),
			('2012-04-07', 2, 3),
			('2012-04-08', 2, 3),
			('2012-04-10', 2, 3),
			('2012-04-11', 2, 3),
			('2012-04-12', 2, 3),
			('2012-03-21', 1, 3),
			('2012-03-22', 1, 3),
			('2012-03-24', 1, 3),
			('2012-03-25', 1, 3),
			('2012-03-26', 1, 3),
			('2012-03-28', 1, 3),
			('2012-03-29', 1, 3),
			('2012-03-31', 1, 3),
			('2012-04-01', 1, 3),
			('2012-04-05', 1, 3),
			('2012-04-06', 1, 3),
			('2012-04-08', 1, 3),
			('2012-04-10', 1, 3),
			('2012-04-11', 1, 3),
			('2012-04-12', 1, 3),
			('2012-03-21', 8, 3),
			('2012-03-22', 8, 3),
			('2012-03-25', 8, 3),
			('2012-03-29', 8, 3),
			('2012-04-02', 8, 3),
			('2012-04-04', 8, 3),
			('2012-04-06', 8, 3),
			('2012-04-09', 8, 3),
			('2012-04-12', 8, 3);
			
/*Apirine_3*/			
INSERT INTO prise_medicament (date_prise_medicament, id_patient, id_prescription)
	VALUES 	('2015-05-01', 6, 4), 
			('2015-05-02', 6, 4),
			('2015-05-03', 6, 4),
			('2015-05-04', 6, 4),
			('2015-05-05', 6, 4),
			('2015-05-06', 6, 4),
			('2015-05-07', 6, 4),
			('2015-05-08', 6, 4),
			('2015-05-10', 6, 4),
			('2015-05-11', 6, 4),
			('2015-05-13', 6, 4),
			('2015-05-14', 6, 4),
			('2015-05-15', 6, 4),
			('2015-05-16', 6, 4),
			('2015-05-17', 6, 4),
			('2015-05-18', 6, 4),
			('2015-05-19', 6, 4),
			('2015-05-21', 6, 4),
			('2015-05-22', 6, 4),
			('2015-05-23', 6, 4),
			('2015-05-24', 6, 4),
			('2015-05-25', 6, 4),
			('2015-05-26', 6, 4),
			('2015-05-28', 6, 4),
			('2015-05-29', 6, 4),
			('2015-05-30', 6, 4),
			('2015-05-31', 6, 4),			
			('2015-06-01', 6, 4),
			('2015-06-03', 6, 4),
			('2015-06-04', 6, 4),
			('2015-06-06', 6, 4),
			('2015-06-07', 6, 4),
			('2015-06-08', 6, 4),
			('2015-06-09', 6, 4),
			('2015-06-12', 6, 4),
			('2015-06-13', 6, 4),
			('2015-06-14', 6, 4),
			('2015-06-15', 6, 4),
			('2015-06-16', 6, 4),
			('2015-06-18', 6, 4),
			('2015-06-19', 6, 4),
			('2015-06-21', 6, 4),
			('2015-06-22', 6, 4),
			('2015-06-23', 6, 4),
			('2015-06-24', 6, 4),
			('2015-06-26', 6, 4),
			('2015-06-27', 6, 4),
			('2015-06-28', 6, 4),
			('2015-06-29', 6, 4),
			('2015-06-30', 6, 4);
			

/*Effexor*/

			
INSERT INTO prise_medicament (date_prise_medicament, id_patient, id_prescription)
	VALUES 	('2017-01-02', 9, 5),
			('2017-01-03', 9, 5),
			('2017-01-04', 9, 5),
			('2017-01-05', 9, 5),
			('2017-01-06', 9, 5),
			('2017-01-09', 9, 5),
			('2017-01-11', 9, 5),
			('2017-01-13', 9, 5),
			('2017-01-15', 9, 5),
			('2017-01-16', 9, 5),
			('2017-01-17', 9, 5),
			('2017-01-19', 9, 5),
			('2017-01-20', 9, 5),
			('2017-01-21', 9, 5),
			('2017-01-22', 9, 5),
			('2017-01-23', 9, 5),
			('2017-01-24', 9, 5),
			('2017-01-26', 9, 5),
			('2017-01-27', 9, 5),
			('2017-01-28', 9, 5),
			('2017-01-29', 9, 5),
			('2017-01-31', 9, 5),			
			('2017-02-01', 9, 5),
			('2017-02-02', 9, 5),
			('2017-01-02', 10, 5),
			('2017-01-04', 10, 5),
			('2017-01-05', 10, 5),
			('2017-01-06', 10, 5),
			('2017-01-09', 10, 5),
			('2017-01-10', 10, 5),
			('2017-01-11', 10, 5),
			('2017-01-14', 10, 5),
			('2017-01-16', 10, 5),
			('2017-01-17', 10, 5),
			('2017-01-18', 10, 5),
			('2017-01-19', 10, 5),
			('2017-01-20', 10, 5),
			('2017-01-21', 10, 5),
			('2017-01-24', 10, 5),
			('2017-01-26', 10, 5),
			('2017-01-27', 10, 5),
			('2017-01-29', 10, 5),
			('2017-01-31', 10, 5),			
			('2017-02-01', 10, 5),
			('2017-02-02', 10, 5),
			('2017-01-02', 5, 5),
			('2017-01-04', 5, 5),
			('2017-01-08', 5, 5),
			('2017-01-10', 5, 5),
			('2017-01-14', 5, 5),
			('2017-01-15', 5, 5),
			('2017-01-17', 5, 5),
			('2017-01-21', 5, 5),
			('2017-01-28', 5, 5),
			('2017-01-31', 5, 5);			
			
			
			
			
		
			







