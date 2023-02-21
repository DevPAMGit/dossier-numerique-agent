package org.cd59.dna.model.pleiades;

import org.alfresco.service.namespace.QName;

/**
 * Modèle de données pour les types de contenus pléïades.
 */
public class PleiadesModel {
    /**
     * Le préfixe du type de contenu.
     */
    public final static String PREFIX = "pleiades";

    /**
     * L'URL du type de contenu.
     */
    public final static String URI = "http://www.cd59.fr/model/pleiades/1.0";

    /**
     * Le nom du type de contenu.
     */
    public final static QName NOM = QName.createQName( URI , "donnees");

    /**
     * L'identifiant utilisateur.
     */
    public final static QName USER_ID = QName.createQName(URI, "userId");

    /**
     * Le matricule utilisateur.
     */
    public final static QName MATRICULE = QName.createQName(URI, "agtMatricule");

    /**
     * Le nom d'usage de l'agent.
     */
    public final static QName AGENT_NOM_USAGE = QName.createQName(URI, "agtNomUsage");

    /**
     * Le patronyme l'agent.
     */

    public final static QName AGENT_PATRONYME = QName.createQName(URI, "agtNomPatro");

    /**
     * Le prénom d'usage de l'agent.
     */
    public final static QName AGENT_PRENOM = QName.createQName(URI, "agtPrenom");

    /**
     * La date de naissance de l'agent.
     */
    public final static QName AGENT_DATE_NAISSANCE = QName.createQName(URI, "dateNaissAgt");

    /**
     *  La date d'entrée de l'agent dans le département.
     */
    public final static QName AGENT_DATE_ENTREE = QName.createQName(URI, "dateEntreeEJ");

    /**
     *  La fonction de l'agent au sein du département.
     */
    public final static QName AGENT_FONCTION = QName.createQName(URI, "fonctionAgt");

    /**
     *  ??????? Date d'effet de l'arrêté ?????
     */
    public final static QName DATE_EFFET_ARRETE = QName.createQName(URI, "dateEffet");

    /**
     *  Date d'effet de numérisation du document.
     */
    public final static QName DATE_NUMERISATION = QName.createQName(URI, "dateNumerisation");

    /**
     *  Le type du document.
     */
    public final static QName TYPOLOGIE = QName.createQName(URI, "typeDoc");

    /**
     *  Indique si le document doit passer au contrôle de légalité.
     */
    public final static QName CTRL_LEGALITE = QName.createQName(URI, "ctrlLegalite");

    /**
     *  Indique si l'agent doit être notifié.
     */
    public final static QName NOTIFICATION_AGENT = QName.createQName(URI, "notifAgt");

    /**
     *  Indique Le type de signature.
     */
    public final static QName TYPE_VALIDATION = QName.createQName(URI, "typeValidation");

    /**
     *  Indique Le statut du document.
     */
    public final static QName STATUT = QName.createQName(URI, "docStatut");

    /**
     *  ????????????????
     */
    public final static QName SIGNATURE_CRITIQUE_1 = QName.createQName(URI, "signcrit1");

    /**
     *  ????????????????
     */
    public final static QName SIGNATURE_CRITIQUE_2 = QName.createQName(URI, "signcrit2");

    /**
     * La pochette de dépôt du document.
     */
    public final static QName POCHETTE = QName.createQName(URI, "pochetteNom");

}
