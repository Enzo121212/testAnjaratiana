-- Création de la table "articles"
CREATE TABLE articles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    article VARCHAR(255)
);

-- Création de la table "livreur"
CREATE TABLE livreur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    contacte VARCHAR(255),
    adresse VARCHAR(255)
);

-- Création de la table "clients"
CREATE TABLE clients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    contacte VARCHAR(255),
    adresse VARCHAR(255)
);

-- Création de la table "livraison"
CREATE TABLE livraison (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idClient INT,
    idCommande INT,
    dateLivraison DATE,
    heureLivraison TIME,
    idLivreur INT,
    idTransport INT,
    prix DECIMAL(10, 2)
);

-- Création de la table "Transport" et ajout des valeurs possibles
CREATE TABLE Transport (
    id INT PRIMARY KEY,
    transport VARCHAR(255)
);

INSERT INTO Transport (id, transport) VALUES
(1, 'bus'),
(2, 'voiture'),
(3, 'velo'),
(4, 'moto');
