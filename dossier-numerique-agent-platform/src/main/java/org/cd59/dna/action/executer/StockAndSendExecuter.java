package org.cd59.dna.action.executer;

import org.alfresco.repo.action.executer.ActionExecuterAbstractBase;
import org.alfresco.service.cmr.action.Action;
import org.alfresco.service.cmr.action.ParameterDefinition;
import org.alfresco.service.cmr.repository.NodeRef;

import java.util.List;

/**
 * Exécuteur d'action pour stocker et envoyer un document arrivé sur la GED.
 */
public class StockAndSendExecuter extends ActionExecuterAbstractBase {

    @Override
    protected void executeImpl(Action action, NodeRef nodeRef) {

    }

    @Override
    protected void addParameterDefinitions(List<ParameterDefinition> list) { }
}
