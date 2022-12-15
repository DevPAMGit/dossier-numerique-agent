package org.cd59.utilitaires.librairies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe {@link UtilitaireChaine}.
 */
class UtilitaireChaineTest {
    /**
     * Chaîne de caractères null.
     */
    private static final String CHAINE_NULL = null;

    /**
     * Chaîne de caractères vide.
     */
    private static final String CHAINE_VIDE = " ";

    /**
     * Chaîne de caractères non null ou vides.
     */
    private static final String CHAINE_NON_NULL = "TEST";

    /**
     * Chaîne de caractères non null ou vides.
     */
    private static final int ENTIER = 12;

    @Test
    void convertitEntierSurNChiffres() {
        assertEquals("012", UtilitaireChaine.convertitEntierSurNChiffres(ENTIER, 3));
    }

    @Test
    void etreNullOuVideNull() {
        assertTrue(UtilitaireChaine.etreNullOuVide(CHAINE_NULL));
    }

    @Test
    void etreNullOuVideVide() {
        assertTrue(UtilitaireChaine.etreNullOuVide(CHAINE_VIDE));
    }

    @Test
    void etreNullOuVideNonVide() {
        assertFalse(UtilitaireChaine.etreNullOuVide(CHAINE_NON_NULL));
    }
}