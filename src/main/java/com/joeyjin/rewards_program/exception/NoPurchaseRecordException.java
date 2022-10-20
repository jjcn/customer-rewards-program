package com.joeyjin.rewards_program.exception;

/**
 * An exception for scenarios where there is no purchase record.
 */
public class NoPurchaseRecordException extends RuntimeException {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public NoPurchaseRecordException() {
        super();
    }

    public NoPurchaseRecordException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
