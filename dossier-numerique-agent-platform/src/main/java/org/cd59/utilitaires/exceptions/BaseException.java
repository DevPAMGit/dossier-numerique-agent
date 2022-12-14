package org.cd59.utilitaires.exceptions;

/**
 * Exception personnalisée de base pour toutes les exceptions métiers du projet.
 */
public class BaseException extends Exception {
    /**
     * Initialise une nouvelle instance de la classe {@link BaseException}.
     * @param message Le message personnalisé accompagnant l'exception.
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * Initialise une nouvelle instance de la classe {@link BaseException}.
     * @param exception L'exception de base ayant provoqué celle-ci.
     * @param message   Le message personnalisé accompagnant l'exception.
     */
    public BaseException(Exception exception, String message) {
        super(message, exception);
    }
}
