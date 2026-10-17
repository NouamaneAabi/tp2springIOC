package com.example.dao;

/**
 * Interface DAO : definit le contrat de recuperation de donnees brutes.
 * Chaque implementation peut representer une source differente
 * (base de donnees, API, capteur physique, etc.).
 */
public interface IDao {
    /**
     * Retourne la valeur numerique issue de la source de donnees.
     * @return valeur double recuperee
     */
    double getValue();
}