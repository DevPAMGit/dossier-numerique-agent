package org.cd59.utilitaires.exceptions;

/**
 * Exception personnalisée lancée en cas d'erreur inattendue.
 */
public class InattendueException extends BaseException {
    /**
     * Initialise une nouvelle instance de la classe {@link InattendueException}.
     * @param exception L'exception de base ayant provoqué celle-ci.
     * @param message Le message personnalisé accompagnant l'exception.
     */
    public InattendueException(Exception exception, String message) {
        super(exception, message);
    }
}
