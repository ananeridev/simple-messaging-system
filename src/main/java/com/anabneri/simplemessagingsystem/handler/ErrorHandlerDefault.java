package com.anabneri.simplemessagingsystem.handler;

import org.springframework.util.ErrorHandler;

public class ErrorHandlerDefault implements ErrorHandler {

    @Override
    public void handleError(final Throwable t) {
        System.out.println("An ERROR occurred" + t.getStackTrace());
    }

}
