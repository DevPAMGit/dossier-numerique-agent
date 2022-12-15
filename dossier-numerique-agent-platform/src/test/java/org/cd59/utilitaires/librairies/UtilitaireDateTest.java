package org.cd59.utilitaires.librairies;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe personnalisée pour tester l'utilitaire de date.
 */
public class UtilitaireDateTest {
    /**
     * La date à tester.
     */
    private final Date date;

    public UtilitaireDateTest() throws ParseException {
        this.date = new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2022");
    }

    /**
     * Teste l'extraction du jour dans la date.
     */
    @Test
    void extraireJour() {
        assertEquals(UtilitaireDate.extraireJour(date), 15);
    }

    /**
     * Teste l'extraction du mois d'une date.
     */
    @Test
    void extraireMois() {
        assertEquals(UtilitaireDate.extraireMois(date), 12);
    }

    @Test
    void extraireAnnee() {
        assertEquals(UtilitaireDate.extraireAnnee(date), 2022);
    }

    @Test
    void extraireNomMoisParDate() {
        assertEquals(UtilitaireDate.extraireNomMois(date), "décembre");
    }

    @Test
    void testExtraireNomMoisParNumero() {
        assertEquals(UtilitaireDate.extraireNomMois(12), "décembre");
    }
}