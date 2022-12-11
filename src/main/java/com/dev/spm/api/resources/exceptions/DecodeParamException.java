package com.dev.spm.api.resources.exceptions;

public class DecodeParamException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DecodeParamException(String msg) {
        super(msg);
    }

}
