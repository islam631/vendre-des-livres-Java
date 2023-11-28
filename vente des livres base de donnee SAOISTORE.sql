CREATE TABLE VillCl
    (
        id_ville INTEGER PRIMARY KEY NOT NULL,
        pays_vl VARCHAR(20) ,
        nom_vl VARCHAR(20)
    );





CREATE TABLE Client
    (
        id_cl INTEGER PRIMARY KEY NOT NULL,
        nom_cl VARCHAR(20),
        prenom_cl VARCHAR(20),
        daten_cl TIMESTAMP,
        tel_cl INTEGER ,
        email_cl VARCHAR(50),
        id_ville INTEGER ,
        FOREIGN KEY (id_ville) REFERENCES VillCl (id_ville) ON DELETE CASCADE
    );



CREATE TABLE compteCL
    (
        id_cmp INTEGER PRIMARY KEY NOT NULL,
        nomutili_cmp VARCHAR(20),
        email_cmp VARCHAR(20),
        motdp_cmp VARCHAR(20),
        id_cl INTEGER ,
        FOREIGN KEY (id_cl) REFERENCES Client (id_cl) ON DELETE CASCADE
    );




CREATE TABLE administrateur 
    (
        id_admin INTEGER PRIMARY KEY NOT NULL,
        nom_admin VARCHAR(30),
        prenom_admin VARCHAR(30),
        email_admin VARCHAR(50),
        motdp_admin VARCHAR(15)
    );




CREATE TABLE creersuprimer
    (
        id_cmp INTEGER , FOREIGN KEY (id_cmp ) REFERENCES compteCL (id_cmp ) ON DELETE CASCADE,
        id_admin INTEGER , FOREIGN KEY (id_admin) REFERENCES administrateur (id_admin) ON DELETE CASCADE, 
        PRIMARY KEY (id_cmp,id_admin)
    );


CREATE TABLE commande
    (
        nemuro_cmp INTEGER PRIMARY KEY,
        date_cmp TIMESTAMP,
        id_cmp INTEGER , FOREIGN KEY (id_cmp) REFERENCES compteCL (id_cmp) ON DELETE CASCADE,
        id_ville INTEGER , FOREIGN KEY (id_ville) REFERENCES VillCl (id_ville) ON DELETE CASCADE
    
    );



CREATE TABLE categorielv
    (
        id_ct INTEGER PRIMARY KEY NOT NULL,
        nom_ct VARCHAR(20),
        desc_ct VARCHAR(500)
    );




CREATE TABLE livre
    (
        ISBN_lv INTEGER PRIMARY KEY NOT NULL,
        titre_lv VARCHAR(20),
        prix_lv INTEGER,
        desc_lv VARCHAR(500),
        nmrpage_lv INTEGER,
        datepr_lv TIMESTAMP,
        id_ct INTEGER, FOREIGN KEY (id_ct) REFERENCES categorielv (id_ct) ON DELETE CASCADE
    );
   
    
CREATE TABLE ajouter
    (
        id_admin, FOREIGN KEY (id_admin) REFERENCES administrateur (id_admin) ON DELETE CASCADE ,
        ISBN_lv, FOREIGN KEY (ISBN_lv) REFERENCES livre (ISBN_lv) ON DELETE CASCADE , 
        nbrempr_lv INTEGER,
        PRIMARY KEY(id_admin,ISBN_lv)
    );
    

CREATE TABLE contient
    (
        nemuro_cmp INTEGER,
        ISBN_lv INTEGER,
        quatite_cnt INTEGER,
        PRIMARY KEY(nemuro_cmp,ISBN_lv)
    );
    
  

CREATE TABLE auteur
    (  
        id_aut INTEGER PRIMARY KEY NOT NULL,
        nom_aut VARCHAR(20),
        prenom_aut VARCHAR(20),
        daten_aut TIMESTAMP,
        nationalite_aut VARCHAR(20)
    );
    
    
CREATE TABLE posseder
    (
        ISBN_lv INTEGER ,FOREIGN KEY (ISBN_lv ) REFERENCES livre (ISBN_lv ) ON DELETE CASCADE,
        id_aut INTEGER,FOREIGN KEY (id_aut ) REFERENCES auteur(id_aut ) ON DELETE CASCADE,
        PRIMARY KEY(ISBN_lv ,id_aut )
    );
    

    
