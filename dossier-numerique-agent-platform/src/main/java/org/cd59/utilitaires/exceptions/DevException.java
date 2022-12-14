package org.cd59.utilitaires.exceptions;

/**
 * Exception personnalisée de base pour toutes les exceptions de développement du projet détectées.
 */
public class DevException extends BaseException {
    /**
     * Le début du message d'exception.
     */
    private static final String MESSAGE = "Une erreur inattendue a eu lieu. Veuillez contacter votre assistance.";

    /**
     * Le message pour le développeur.
     */
    public final String messageDev;

    /**
     * Initialise une nouvelle instance de la classe {@link BaseException}.
     * @param message Le message personnalisé accompagnant l'exception.
     */
    public DevException(String message) {
        super(MESSAGE);
        this.messageDev = message;
    }
}
