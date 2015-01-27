package com.thoughtworks.spring.jpa.tomcat.exceptions;

public class EmailNotUniqueException extends Exception {
    public EmailNotUniqueException() {
        super();
    }

    public EmailNotUniqueException(String message) {
        super(message);
    }
}
