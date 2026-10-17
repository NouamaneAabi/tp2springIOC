package com.example.metier;

import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation de la couche metier.
 *
 * Spring injecte automatiquement une implementation de IDao (@Autowired).
 * Le @Qualifier precise lequel des deux capteurs utiliser :
 *   - "capteurLocal"   -> DaoImpl  (100.0) => calcul = 200.0
 *   - "capteurDistant" -> DaoImpl2 (150.0) => calcul = 300.0
 *
 * Le traitement applique un facteur de conversion sur la valeur brute.
 */
@Component("traitementMetier")
public class MetierImpl implements IMetier {

    /** Facteur de conversion applique a la mesure brute */
    private static final double FACTEUR_CONVERSION = 2.0;

    // Injection par champ : Spring selectionne le bean via @Qualifier
    @Autowired
    @Qualifier("capteurDistant")
    private IDao capteur;

    @Override
    public double calcul() {
        double valeurBrute   = capteur.getValue();
        double valeurTraitee = valeurBrute * FACTEUR_CONVERSION;
        return valeurTraitee;
    }

    /** Setter pour injection alternative par setter */
    public void setCapteur(IDao capteur) {
        this.capteur = capteur;
    }
}