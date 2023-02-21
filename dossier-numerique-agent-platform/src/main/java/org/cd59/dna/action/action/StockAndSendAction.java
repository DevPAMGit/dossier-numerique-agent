package org.cd59.dna.action.action;

import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.lock.LockService;
import org.alfresco.service.cmr.lock.LockType;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.cd59.dna.model.pleiades.PleiadesModel;

/**
 * Classe d'action permettant de stocker et envoyer.
 */
public class StockAndSendAction {
    /**
     * Le registre de gestion de service.
     */
    private final ServiceRegistry serviceRegistry;

    /**
     * Le service de gestion de nœuds.
     */
    private final NodeService nodeService;

    /**
     * Le service de verrouillage d'Alfresco.
     */
    private final LockService lockService;

    /**
     * Le statut pour un envoi à Pastell.
     */
    private final static String STATUT = "ETAT";

    /**
     * Initialise une nouvelle instance de la classe {@link StockAndSendAction}.
     * @paaram serviceRegistry Le registre de service Alfresco.
     */
    public StockAndSendAction(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
        this.nodeService = this.serviceRegistry.getNodeService();
        this.lockService = this.serviceRegistry.getLockService();
    }

    /**
     * Execute l'action.
     * @param nodeRef Le nœud de référence de l'action.
     */
    public void executer(NodeRef nodeRef) {
        // Vérification des
        if(nodeRef == null) return;
        else if(!this.nodeService.hasAspect(nodeRef, PleiadesModel.NOM)) return;

        String statut = (String) this.nodeService.getProperty(nodeRef, PleiadesModel.STATUT);
        if(statut.isEmpty()) return;
        else if(!statut.equals(STATUT)) return;

        // Verrouillage du document.
        this.lockService.lock(nodeRef, LockType.valueOf("READ_ONLY_LOCK"));
        // Envoie du document.



    }
}
