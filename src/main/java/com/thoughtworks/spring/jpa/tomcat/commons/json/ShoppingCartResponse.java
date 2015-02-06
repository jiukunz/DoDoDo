package com.thoughtworks.spring.jpa.tomcat.commons.json;

import com.thoughtworks.spring.jpa.tomcat.commons.AddShoppingCartStatus;

public class ShoppingCartResponse {
    AddShoppingCartStatus status;

    public AddShoppingCartStatus getStatus() {
        return status;
    }

    public void setStatus(AddShoppingCartStatus status) {
        this.status = status;
    }
}
