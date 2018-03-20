/* Ajout dans la table type d'études */

insert into type_etude (nom_type, description_type, commentaire_type)
	values ('Descriptive', "Décrivent des variables individuelles", NULL);
 
insert into type_etude (nom_type, description_type, commentaire_type)
	values ('Analytique', "Analyse d'association entre 2 ou plusieurs variables", NULL);
	
insert into type_etude (nom_type, description_type, commentaire_type)
	values ('Cas Témoin', "Sélectionn des sujets réalisés en fonction de l'issue", NULL);
  
insert into type_etude (nom_type, description_type, commentaire_type)
	values ('Rapport de cas', "Description d'un cas intéresssant et inhabituel",  NULL);
	
/* Ajout dans la table étude */

insert into etude (titre_etude, description_etude, date_debut, date_fin, id_type_etude) 
	values ('Aspirine_1', "Premier test des aspirines", '2008-01-02', '2008-01-06', 1);
    
insert into etude (titre_etude, description_etude, date_debut, date_fin, id_type_etude) 
	values ('Aspirine_2', "Deuxième test des aspirines", '2010-04-12', '2010-10-23', 3);
    
insert into etude (titre_etude, description_etude, date_debut, date_fin, id_type_etude) 
	values ('Hydromorphone_1', "Premier test d'hydromorphone", '2012-03-21', '2012-11-01', 4);
    
insert into etude (titre_etude, description_etude, date_debut, date_fin, id_type_etude) 
	values ('Aspirine_3', "Troisième test des aspirines", '2015-05-07', '2016-02-08', 2);

insert into etude (titre_etude, description_etude, date_debut, date_fin, id_type_etude) 
	values ('Effexor_1', "Premier test d'effexor", '2018-01-02', NULL , 3);
	
/* Ajout dans la table médicament */

insert into medicament (nom_medicament, description_medicament, commentaire_medicament) 
	values ('Aspirine', "Contre les maux de tête", NULL);
	
insert into medicament (nom_medicament, description_medicament, commentaire_medicament) 
	values ('Hydromorphone', "Contre les douleurs graves", "Variante de morphine");
	
insert into medicament (nom_medicament, description_medicament, commentaire_medicament) 
	values ('Effexor', "Anti-dépresseur", NULL);

/* Ajout dans la table professionnel */

insert into professionnel (nom_professionnel, prenom_professionnel, specialite, adresse_professionnel, no_tel_maison, no_tel_mobile, no_tel_bureau, no_pagette, no_fax, email_professionnel) 
	values ('Bouleau', 'Martin', 'Neurologie', '124, rue des avions, Sherbrooke, QC CA', NULL, '819-124-3456', '819-124-7546', NULL, '819-124-7547', 'martinb@gmail.com');

insert into professionnel (nom_professionnel, prenom_professionnel, specialite, adresse_professionnel, no_tel_maison, no_tel_mobile, no_tel_bureau, no_pagette, no_fax, email_professionnel) 
	values ('Morin', 'Gaston', 'Neuropsychiatrie', '344, rue des renards, Sherbrooke, QC CA', '819-344-6543', '819-450-3245', '819-564-2981', '819-578-4333', '819-564-2982', 'gastonm@gmail.com');	
	
insert into professionnel (nom_professionnel, prenom_professionnel, specialite, adresse_professionnel, no_tel_maison, no_tel_mobile, no_tel_bureau, no_pagette, no_fax, email_professionnel) 
	values ('Beaudoin', 'Alfred', 'Cardiologie', '1254, rue de la reine, Sherbrooke, QC CA', '819-654-3457', '567-345-3456', '819-901-9823', NULL, '819-901-9824', 'alfredb@gmail.com');	

insert into professionnel (nom_professionnel, prenom_professionnel, specialite, adresse_professionnel, no_tel_maison, no_tel_mobile, no_tel_bureau, no_pagette, no_fax, email_professionnel) 
	values ('Rose', 'Violet', 'Pneumologie', '756, rue du mouvement, Sherbrooke, QC CA', '819-721-4374', '321-345-6721', '819-520-6345', '819-091-2378', '819-520-6346', 'violetr@gmail.com');	
	
/* Ajout dans la table ta_etude_professionnel */

insert into ta_etude_professionel (id_etude, id_prof) 
	values (1, 3);
	
insert into ta_etude_professionel (id_etude, id_prof) 
	values (1, 2);
	
insert into ta_etude_professionel (id_etude, id_prof) 
	values (3, 1);
	
insert into ta_etude_professionel (id_etude, id_prof) 
	values (2, 4);

insert into ta_etude_professionel (id_etude, id_prof) 
	values (4, 2);
	
insert into ta_etude_professionel (id_etude, id_prof) 
	values (5, 4);
	
/* Ajout dans la table patient */

insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Gaven', 'Loup', '55, avenue des canidés, Sherbrooke, QC CA', '1997-11-12', '819-567-2345', '819-324-7891', '819-346-9087', 'Jean', 'raz.an@hotmail.com', 'GAVL97111200');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Dussault', 'Marie', '346, boulevard des papillons, Sherbrooke, QC CA', '1978-12-30', '819-345-6345', '514-543-4567', '819-366-9000', 'Jonathan', 'butterfly@gmail.ca', 'DUSM78123021');

insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Frost', 'Iain', '451, rue des avions, Sherbrooke, QC CA', '1978-03-15', '819-127-3452', '514-129-9032', '819-127-5432', 'Marcel', 'link@gmail.ca', 'FROI78031518');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Tremblay', 'Bob', '876, rue des filous , Sherbrooke, QC CA', '1975-01-11', '819-541-2345', '819-781-2376', '819-901-2348', 'Bernard', 'tremblant@gmail.ca', 'TREB75011121');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Graton', 'Willy', '777, avenue des peupliers , Sherbrooke, QC CA', '1982-02-27', '819-321-0002', '819-235-3045', '819-222-3457', 'Serge', NULL, 'GRAW82022702');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Tremblay', 'Robert', '567, boulevard des études , Sherbrooke, QC CA', '1973-03-17', '819-124-2389', '514-222-0918', '819-278-9017', 'Bill', 'kory12@outlook.fr', 'ROBT73031772');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Coen', 'Claudia', '3689, rue des tigres , Sherbrooke, QC CA', '1991-04-24', '819-097-8523', '514-219-8234', '819-098-2135', 'Julie', 'gaston@gmail.ca', 'CLAC91042490');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Pitt', 'Brad', '455, boulevard des sapins , Sherbrooke, QC CA', '1984-07-02', '819-876-0008', '819-543-8732', '819-333-5422', 'Serge', 'iamgod32@videotron.ca', 'BRAP84070223');
	
insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Tremblay', 'Maurice', '102, avenue des fous , Sherbrooke, QC CA', '1987-05-27', '819-124-7812', '514-543-5432', '819-278-9017', 'Bill', 'metoo12@gmail.ca', 'MAUT87052738');

insert into patient (nom_patient, prenom_patient, adresse_patient, date_naissance, no_tel_maison, no_tel_mobile, no_tel_urgences, contact_urgences, email_patient, numero_assu_maladie) 
	values ('Aniston', 'Jennifer', '809, rue des jouets , Sherbrooke, QC CA', '1992-04-24', '819-124-8762', '514-345-7123', '819-761-3245', 'Will', 'random47@gmail.ca', 'JENA92042435');
	
/* Ajout dans la table ta_liste_patient */

insert into ta_liste_patient (id_etude, id_patient) 
	values (1, 1);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (1, 3);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (1, 6);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (1, 8);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (1, 9);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (1, 10);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (2, 4);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (2, 2);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (2, 7);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (3, 3);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (3, 2);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (4, 6);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (5, 9);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (5, 10);
	
insert into ta_liste_patient (id_etude, id_patient) 
	values (5, 5);
	
/* Ajout dans la table prescription */

insert into prescription (posologie, commentaire, id_medicament, id_etude) 
	values ('1 comprimé 1 fois par jour', NULL, 1, 1);
	
insert into prescription (posologie, commentaire, id_medicament, id_etude) 
	values ('1 comprimé 1 fois par jour', NULL, 1, 2);
	
insert into prescription (posologie, commentaire, id_medicament, id_etude) 
	values ('2 comprimé 1 fois par jour', NULL, 2, 3);

insert into prescription (posologie, commentaire, id_medicament, id_etude) 
	values ('1 comprimé 1 fois par jour', NULL, 1, 4);
	
insert into prescription (posologie, commentaire, id_medicament, id_etude) 
	values ('1 comprimé au besoin', NULL, 3, 5);
	
/* Ajout dans la table prise_medicament */

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-02', 1, 1);
	
insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-03', 1, 1);

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-05', 1, 1);

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-06', 1, 1);

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-02', 3, 1);
	
insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-03', 3, 1);
	
insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-04', 3, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-05', 3, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-06', 3, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-02', 6, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-03', 6, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-05', 6, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-06', 6, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-02', 8, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-03', 8, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-04', 8, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-05', 8, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-06', 8, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-02', 9, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-03', 9, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-04', 9, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-05', 9, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-06', 9, 1);         

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-03', 10, 1);        

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-04', 10, 1);        

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-05', 10, 1);        

insert into prise_medicament (date_prise_medicament, id_patient, id_prescription)
	values ('2008-01-06', 10, 1);

	