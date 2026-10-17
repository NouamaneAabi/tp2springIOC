package com.example.dao;

import org.springframework.stereotype.Component;

/**
 * Implementation 1 de IDao : simule un capteur local.
 * Retourne une temperature fixe de 100.0 degres.
 *
 * Identifiant Spring : "capteurLocal"
 * -> sera injecte dans MetierImpl via @Qualifier("capteurLocal")
 */
@Component("capteurLocal")
public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        // Simulation : lecture depuis un capteur local (valeur fixe)
        double temperatureLocale = 100.0;
        return temperatureLocale;
    }
}