package com.eval2p.petshop.model;

public class Pet {

    private final String name;
    private final int idDrawable;

    public Pet(final String name, final int idDrawable){
        this.name = name;
        this.idDrawable = idDrawable;
    }

    public String getName() {
        return name;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}
