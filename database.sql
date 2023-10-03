-- CrÃ©ation de la table "articles"
CREATE TABLE articles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    article VARCHAR(255)
);

-- CrÃ©ation de la table "livreur"
CREATE TABLE livreur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    contacte VARCHAR(255),
    adresse VARCHAR(255)
);

-- CrÃ©ation de la table "clients"
CREATE TABLE clients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    contacte VARCHAR(255),
    adresse VARCHAR(255)
);

-- CrÃ©ation de la table "livraison"
CREATE TABLE livraison (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idClient INT,
    idCommande INT,
    dateLivraison DATE,
    heureLivraison VARCHAR(255),
    idLivreur INT,
    idTransport INT,
    prix DECIMAL(10, 2)
);

-- CrÃ©ation de la table "Transport" et ajout des valeurs possibles
CREATE TABLE Transport (
    id INT PRIMARY KEY,
    transport VARCHAR(255)
);

INSERT INTO Transport (id, transport) VALUES
(1, 'bus'),
(2, 'voiture'),
(3, 'velo'),
(4, 'moto');



INSERT INTO articles (article) VALUES
    ('Article 1'),
    ('Article 2'),
    ('Article 3');
    
 
 INSERT INTO livreur (nom, prenom, contacte, adresse) VALUES
    ('Livreur 1', 'Prénom 1', '035456', 'Adresse 1'),
    ('Livreur 2', 'Prénom 2', '45645612', 'Adresse 2'),
    ('Livreur 3', 'Prénom 3', '456456456', 'Adresse 3');

    
    
 INSERT INTO clients (nom, prenom, contacte, adresse) VALUES
    ('Client 1', 'Prénom 1', '5645645', 'Adresse 1'),
    ('Client 2', 'Prénom 2', '546546', 'Adresse 2'),
    ('Client 3', 'Prénom 3', '546456', 'Adresse 3');
