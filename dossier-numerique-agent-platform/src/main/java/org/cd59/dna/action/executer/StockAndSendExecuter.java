package org.cd59.dna.action.executer;

import org.alfresco.repo.action.executer.ActionExecuterAbstractBase;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.action.Action;
import org.alfresco.service.cmr.action.ParameterDefinition;
import org.alfresco.service.cmr.repository.NodeRef;
import org.cd59.dna.action.action.StockAndSendAction;

import java.util.List;

/**
 * Exécuteur d'action pour stocker et envoyer un document arrivé sur la GED.
 */
public class StockAndSendExecuter extends ActionExecuterAbstractBase {
    /**
     * Le registre des services Alfresco qui donne accès à tous les services de contenu public d'Alfresco.
     */
    private ServiceRegistry serviceRegistry;

    /**
     * Modifie la valeur du paramètre de classe serviceRegistry.
     * @param serviceRegistry La nouvelle valeur du paramètre de classe.
     */
    public void setServiceRegistry(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    protected void executeImpl(Action action, NodeRef nodeRef) {
        try { new StockAndSendAction(this.serviceRegistry).executer(nodeRef); }
        catch (Exception e) { throw new RuntimeException(e.getMessage()); }
    }

    @Override
    protected void addParameterDefinitions(List<ParameterDefinition> list) { }
}
