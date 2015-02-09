package com.thoughtworks.spring.jpa.tomcat.commons.json;

import com.thoughtworks.spring.jpa.tomcat.commons.ShoppingCartStatus;

public class ShoppingCartResponse {
    ShoppingCartStatus status;

    public ShoppingCartStatus getStatus() {
        return status;
    }

    public void setStatus(ShoppingCartStatus status) {
        this.status = status;
    }
}
