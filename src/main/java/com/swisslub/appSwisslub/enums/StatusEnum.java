package com.swisslub.appSwisslub.enums;

public enum StatusEnum {
    P("Pendiente"),
    T("Transito"),
    E("Entregado");

    private final String name;
    StatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
