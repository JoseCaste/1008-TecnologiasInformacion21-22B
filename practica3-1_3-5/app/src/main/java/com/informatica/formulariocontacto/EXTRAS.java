package com.informatica.formulariocontacto;

public enum EXTRAS {
    CONTACTO("CONTACTO_DETALLE");
    private String code;

    EXTRAS(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
