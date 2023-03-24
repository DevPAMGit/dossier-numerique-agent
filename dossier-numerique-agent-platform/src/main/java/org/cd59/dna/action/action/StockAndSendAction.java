package org.cd59.dna.action.action;

import baobab.libraries.pastell.PastellApiV2;
import baobab.libraries.requete.noyau.RequeteHTTPException;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.lock.LockService;
import org.alfresco.service.cmr.lock.LockType;
import org.alfresco.service.cmr.model.FileFolderService;

import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.cd59.exception.MetierException;
import org.json.JSONObject;

import org.cd59.dna.model.pleiades.ModRHPleiadesTyp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * Classe d'action permettant de stocker et envoyer.
 */
public class StockAndSendAction {

    /**
     * Le logger de l'action.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StockAndSendAction.class);

    /**
     * Le service de gestion de nœuds.
     */
    private final NodeService nodeService;

    /**
     * Service de gestion des fichiers et dossiers.
     */
    private final FileFolderService fileFolderService;

    /**
     * Le service de verrouillage d'Alfresco.
     */
    private final LockService lockService;

    /**
     * Initialise une nouvelle instance de la classe {@link StockAndSendAction}.
     * @param serviceRegistry Le registre de service Alfresco.
     */
    public StockAndSendAction(ServiceRegistry serviceRegistry) {
        this.fileFolderService = serviceRegistry.getFileFolderService();
        this.nodeService = serviceRegistry.getNodeService();
        this.lockService = serviceRegistry.getLockService();
    }

    /**
     * Execute l'action.
     * @param nodeRef Le nœud de référence de l'action.
     */
    public void executer(NodeRef nodeRef) throws IOException, RequeteHTTPException, InterruptedException, MetierException {
        // Vérification des préconditions
        if (nodeRef == null)
            throw new MetierException("Le noeud de référence est null.");

        else if (!this.nodeService.getType(nodeRef).equals(ModRHPleiadesTyp.NOM))
            throw new MetierException("Le noeud de référence n'a pas la bonne typologie.");

        PastellApiV2 pastell = new PastellApiV2("https://pastell-tst.intranet.cg59.fr", "admin","admin");
        JSONObject document = pastell.creerDocument("30", "dna-document-agent");

        // Récupération des données à fournir à Pastell.
        HashMap<String, String> donnees = new HashMap<>(){{
            put("user_id", (String)nodeService.getProperty(nodeRef, ModRHPleiadesTyp.GESTIONNAIRE));
            put("matricule", (String)nodeService.getProperty(nodeRef, ModRHPleiadesTyp.AGENT_MATRICULE));
            put("nom_agent", (String)nodeService.getProperty(nodeRef, ModRHPleiadesTyp.AGENT_NOM_USAGE));
            put("prenom_agent", (String)nodeService.getProperty(nodeRef, ModRHPleiadesTyp.AGENT_PRENOM));
            // Les données parapheur.
            put("iparapheur_type", "Type_DNA");
            put("iparapheur_sous_type", "SS_Type_UTRH_Cambrai_simple");
        }};

        // Mise à jour des données du dossier Pastell.
        pastell.modifierDocument("30", document.getString("id_d"), donnees);

        // Ajout du fichier.
        pastell.ajouterFichierDocument("30", document.getString("id_d"), "fichier_a_signer",
                "a_signer.pdf", this.fileFolderService.getReader(nodeRef).getContentInputStream().readAllBytes());

        // Verrouillage du document.
        this.lockService.lock(nodeRef, LockType.valueOf("READ_ONLY_LOCK"));

        // Envoie du document.
        pastell.actionDocument("30", document.getString("id_d"), "orientation");
    }
}
