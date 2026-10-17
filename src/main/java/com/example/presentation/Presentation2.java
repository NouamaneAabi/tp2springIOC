package com.example.presentation;

import com.example.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Classe principale : point d entree de l application Spring (config par annotations).
 *
 * @Configuration : cette classe contient la configuration Spring
 * @ComponentScan  : Spring scanne les packages dao et metier pour decouvrir
 *                   les beans annotes (@Component)
 *
 * Flux d execution :
 *  1. Spring demarre et scanne les packages declares
 *  2. Il detecte DaoImpl, DaoImpl2 et MetierImpl -> les enregistre comme beans
 *  3. Il injecte "capteurLocal" (ou "capteurDistant") dans MetierImpl
 *  4. On recupere IMetier depuis le contexte et on appelle calcul()
 */
@Configuration
@ComponentScan(basePackages = {"com.example.dao", "com.example.metier"})
public class Presentation2 {

    public static void main(String[] args) {

        System.out.println("=== Demarrage du contexte Spring (IoC) ===");

        // Initialisation du conteneur IoC avec la configuration par annotations
        ApplicationContext contexte =
                new AnnotationConfigApplicationContext(Presentation2.class);

        // Recuperation du bean metier depuis le conteneur
        IMetier serviceMetier = contexte.getBean(IMetier.class);

        // Execution du traitement metier et affichage du resultat
        double resultat = serviceMetier.calcul();
        System.out.println(">>> Resultat du calcul metier : " + resultat);

        // Fermeture propre du contexte (libere les ressources Spring)
        ((AnnotationConfigApplicationContext) contexte).close();
        System.out.println("=== Contexte Spring ferme proprement ===");
    }
}