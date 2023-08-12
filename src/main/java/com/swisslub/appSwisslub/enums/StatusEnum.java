package com.swisslub.appSwisslub.enums;

public enum StatusEnum {
    P("Pendiente"),
    T("Transito"),
    E("Entregado");

    private String name;

    StatusEnum(String name) {
        this.name = name;
    }

}
