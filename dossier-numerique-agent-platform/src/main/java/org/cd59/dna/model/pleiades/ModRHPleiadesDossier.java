package org.cd59.dna.model.pleiades;

import org.alfresco.service.namespace.QName;

/**
 * Modèle de données pléiades pour un dossier.
 */
public class ModRHPleiadesDossier {
    /**
     * Le préfixe du type de contenu.
     */
    public final static String PREFIX = "ModPId";

    /**
     * L'URL du type de contenu.
     */
    public final static String URI = "http://www.acme.org/model/Model_RH_Pleiades/1.0";

    /**
     * La date de naissance de l'agent.
     */
    public final static QName AGENT_DATE_NAISSANCE = QName.createQName( URI , "dateNaissAgtDossier");

    /**
     * Le nom d'usage de l'agent.
     */
    public final static QName AGENT_NOM_USAGE = QName.createQName(URI, "agtNomUsageDossier");

    /**
     * Fonction de l'agent.
     */
    public final static QName AGENT_FONCTION = QName.createQName(URI, "fonctionAgtDossier");

    /**
     * Identifiant du gestionnaire Pléïades.
     */
    public final static QName USER_ID = QName.createQName(URI, "userIdDossier");

    /**
     * La date de fin de fonction de l'agent.
     */
    public final static QName DATE_FIN_FONCTION = QName.createQName(URI, "dateCFNDossier");

    /**
     * Nom de de l'agent.
     */
    public final static QName AGENT_NOM_PATRONYME = QName.createQName(URI, "agtNomPatroDossier");

    /**
     * Date d'entrée de l'agent.
     */
    public final static QName AGENT_DATE_ENTREE = QName.createQName(URI, "dateEntreeEJDossier");

    /**
     * Prénom de l'agent
     */
    public final static QName AGENT_PRENOM = QName.createQName(URI, "agtPrenomDossier");
}
