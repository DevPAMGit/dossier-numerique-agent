package org.cd59.exception;

/**
 * Exception personnalisée pour les erreurs de type métiers.
 */
public class MetierException extends Exception {
    /**
     * Initialise une nouvelle instance de la classe {@link MetierException}.
     * @param message   Le message de l'exception.
     */
    public MetierException(String message) {
        super(message);
    }
}
