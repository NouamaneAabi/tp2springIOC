package com.example.dao;

import org.springframework.stereotype.Component;

/**
 * Implementation 2 de IDao : simule un capteur distant (ex : API meteo).
 * Retourne une temperature fixe de 150.0 degres.
 *
 * Identifiant Spring : "capteurDistant"
 * -> alternative a DaoImpl, demontrant la flexibilite de l IoC
 */
@Component("capteurDistant")
public class DaoImpl2 implements IDao {

    @Override
    public double getValue() {
        // Simulation : lecture depuis un capteur distant (valeur fixe)
        double temperatureDistante = 150.0;
        return temperatureDistante;
    }
}