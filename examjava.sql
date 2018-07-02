-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 02 Juillet 2018 à 09:17
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `examjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `accusereception`
--

CREATE TABLE `accusereception` (
  `id` int(10) NOT NULL,
  `date` date NOT NULL,
  `idCommande` int(10) NOT NULL,
  `idLivraison` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(10) NOT NULL,
  `date` date NOT NULL,
  `produit` varchar(30) NOT NULL,
  `quantite` int(20) NOT NULL,
  `prix` float NOT NULL,
  `idUtilisateur` int(10) NOT NULL,
  `idFournisseur` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id`, `date`, `produit`, `quantite`, `prix`, `idUtilisateur`, `idFournisseur`) VALUES
(3, '2018-06-11', 'Table', 4, 340, 1, 1),
(4, '2018-06-27', 'Bougie', 3, 6.5, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `etatlivraison`
--

CREATE TABLE `etatlivraison` (
  `id` int(10) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `etatlivraison`
--

INSERT INTO `etatlivraison` (`id`, `libelle`) VALUES
(1, 'A livrer'),
(2, 'Livree'),
(3, 'Receptionnee');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id` int(10) NOT NULL,
  `date` date NOT NULL,
  `idCommande` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`id`, `date`, `idCommande`) VALUES
(1, '2018-07-11', 3);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` int(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `codePostal` varchar(7) NOT NULL,
  `ville` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `nom`, `adresse`, `codePostal`, `ville`) VALUES
(1, 'Gifi', '2 rue des genies', '92100', 'Boulogne-Billancourt'),
(2, 'Casa', '2 rue des java', '92100', 'Boulogne-Billancourt');

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE `livraison` (
  `id` int(10) NOT NULL,
  `date` date NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `codePostal` varchar(7) NOT NULL,
  `ville` varchar(40) NOT NULL,
  `idCommande` int(10) NOT NULL,
  `idEtatLivraison` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `livraison`
--

INSERT INTO `livraison` (`id`, `date`, `adresse`, `codePostal`, `ville`, `idCommande`, `idEtatLivraison`) VALUES
(1, '2018-07-02', '2 rue des sentiers', '75015', 'Paris', 3, 3),
(2, '2018-07-06', '2 rue des sentiers', '92100', 'Paris', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id` int(10) NOT NULL,
  `date` date NOT NULL,
  `prix` float NOT NULL,
  `idCommande` int(10) NOT NULL,
  `idFacture` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `paiement`
--

INSERT INTO `paiement` (`id`, `date`, `prix`, `idCommande`, `idFacture`) VALUES
(1, '2018-07-13', 340, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id` int(10) NOT NULL,
  `libelle` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`id`, `libelle`) VALUES
(1, 'Responsable des achats'),
(2, 'Responsable des stocks'),
(3, 'Comptable');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `codePostal` varchar(7) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `login` varchar(20) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `idProfil` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `adresse`, `codePostal`, `ville`, `login`, `mdp`, `idProfil`) VALUES
(1, 'Dupont', 'François', '2 rue des sentiers', '75015', 'Paris', 'fdupont', 'test', 1),
(2, 'Dubois', 'Leon', '2 rue des sentiers', '75015', 'Paris', 'ldubois', 'test', 2),
(3, 'Durand', 'Marie', '2 rue des sentiers', '75015', 'Paris', 'mdurand', 'test', 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `accusereception`
--
ALTER TABLE `accusereception`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCommande` (`idCommande`),
  ADD KEY `idLivraison` (`idLivraison`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUtilisateur` (`idUtilisateur`),
  ADD KEY `idFournisseur` (`idFournisseur`);

--
-- Index pour la table `etatlivraison`
--
ALTER TABLE `etatlivraison`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCommande` (`idCommande`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEtatLivraison` (`idEtatLivraison`),
  ADD KEY `idCommande` (`idCommande`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCommande` (`idCommande`),
  ADD KEY `idFacture` (`idFacture`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProfil` (`idProfil`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `accusereception`
--
ALTER TABLE `accusereception`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `etatlivraison`
--
ALTER TABLE `etatlivraison`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `livraison`
--
ALTER TABLE `livraison`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `accusereception`
--
ALTER TABLE `accusereception`
  ADD CONSTRAINT `accusereception_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `accusereception_ibfk_2` FOREIGN KEY (`idLivraison`) REFERENCES `livraison` (`id`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`idFournisseur`) REFERENCES `fournisseur` (`id`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `livraison_ibfk_1` FOREIGN KEY (`idEtatLivraison`) REFERENCES `etatlivraison` (`id`),
  ADD CONSTRAINT `livraison_ibfk_2` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `paiement_ibfk_2` FOREIGN KEY (`idFacture`) REFERENCES `facture` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`idProfil`) REFERENCES `profil` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
