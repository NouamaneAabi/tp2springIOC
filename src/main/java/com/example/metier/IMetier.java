package com.example.metier;

/**
 * Interface metier : definit le contrat du traitement des donnees.
 * La couche metier s appuie sur la couche DAO via injection de dependance.
 */
public interface IMetier {
    /**
     * Effectue le calcul metier a partir de la valeur brute du capteur.
     * @return resultat du traitement
     */
    double calcul();
}