package org.cd59.dna.model.pleiades;

import org.alfresco.service.namespace.QName;

/**
 * Modèle de données pléiades pour un fichier.
 */
public class ModRHPleiadesTyp {
    /**
     * Le préfixe du type de contenu.
     */
    public final static String PREFIX = "ModPId";

    /**
     * L'URL du type de contenu.
     */
    public final static String URI = "http://www.acme.org/model/Model_RH_Pleiades/1.0";

    /**
     * Le nom du type de contenu.
     */
    public final static QName NOM = QName.createQName( URI , "Typ");

    /**
     * Le nom de l'agent.
     */
    public final static QName AGENT_NOM_PATRONYME = QName.createQName(URI, "agtNomPatro");

    /**
     * Le prénom de l'agent.
     */
    public final static QName AGENT_PRENOM = QName.createQName(URI, "agtPrenom");

    /**
     * L'heure de numérisation.
     */
    public final static QName HEURE_NUMERISATION = QName.createQName(URI, "heureNumerisation");

    /**
     * Mois de paie associé.
     */
    public final static QName MOIS_PAIE = QName.createQName(URI, "moisPaie");

    /**
     * Date d'effet de l'acte
     */
    public final static QName DATE_EFFET_ACTE = QName.createQName(URI, "dateEffet");

    /**
     * Type de validation
     */
    public final static QName TYPE_VALIDATION = QName.createQName(URI, "typeValidation");

    /**
     * Année de paie associée
     */
    public final static QName ANNEE_PAIE = QName.createQName(URI, "anneePaie");

    /**
     * Critère n°1 de signature
     */
    public final static QName CRITERE_N1 = QName.createQName(URI, "signcrit1");

    /**
     * Identifiant de numérisation
     */
    public final static QName ID_NUMERISATION = QName.createQName(URI, "IDNumerisation");

    /**
     * Date de dépôt
     */
    public final static QName DATE_DEPOT = QName.createQName(URI, "dateDepot");

    /**
     * Statut du document.
     */
    public final static QName STATUT_DOCUMENT = QName.createQName(URI, "docStatut");

    /**
     * Statut du document.
     */
    public final static QName AGENT_NOM_USAGE = QName.createQName(URI, "agtNomUsage");

    /**
     * Matricule de l'agent.
     */
    public final static QName AGENT_MATRICULE = QName.createQName(URI, "agtMatricule");

    /**
     * Contrôle de légalité.
     */
    public final static QName CTRL_LEGALITE = QName.createQName(URI, "ctrlLegalite");

    /**
     * Date de fin de fonction.
     */
    public final static QName DATE_FIN_FONCTION = QName.createQName(URI, "dateCFN");

    /**
     * Critère n°2 de signature
     */
    public final static QName CRITERE_N2 = QName.createQName(URI, "signcrit2");

    /**
     * Nom de la pochette.
     */
    public final static QName NOM_POCHETTE = QName.createQName(URI, "pochetteNom");

    /**
     * Date de numérisation.
     */
    public final static QName DATE_NUMERISATION = QName.createQName(URI, "dateNumerisation");

    /**
     * Notification à l'agent.
     */
    public final static QName NOTIFICATION_AGENT = QName.createQName(URI, "notifAgt");

    /**
     * Date de naissance de l'agent.
     */
    public final static QName AGENT_DATE_NAISSANCE = QName.createQName(URI, "dateNaissAgt");

    /**
     * Date du statut du document.
     */
    public final static QName DATE_STATUT = QName.createQName(URI, "dateStatut");

    /**
     * Le type de document.
     */
    public final static QName TYPE_DOCUMENT = QName.createQName(URI, "typeDoc");

    /**
     * Date d'entrée de l'agent.
     */
    public final static QName AGENT_DATE_ENTREE = QName.createQName(URI, "dateEntreeEJ");

    /**
     * Le gestionnaire
     */
    public final static QName GESTIONNAIRE = QName.createQName(URI, "userId");

    /**
     * Fonction de l'agent.
     */
    public final static QName AGENT_FONCTION = QName.createQName(URI, "fonctionAgt");
}
