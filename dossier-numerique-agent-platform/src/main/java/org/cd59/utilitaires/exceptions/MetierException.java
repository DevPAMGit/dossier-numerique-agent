package org.cd59.utilitaires.exceptions;

/**
 * Classe d'exception personnalisée pour les erreurs de types métiers.
 */
public class MetierException extends BaseException {
    /**
     * Initialise une nouvelle instance de la classe {@link MetierException}.
     * @param message Le message personnalisé accompagnant l'exception.
     */
    public MetierException(String message) {
        super(message);
    }
}
