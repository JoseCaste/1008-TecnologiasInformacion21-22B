package com.informatica.unistmo.sqliteexample.models;

import android.graphics.drawable.Drawable;

public class Pet {

    private final Integer avatar;
    private final int bones;
    private final String breed;
    private final String name;

    public Pet(Integer avatar, int bones, String breed, String name) {
        this.avatar = avatar;
        this.bones = bones;
        this.breed = breed;
        this.name = name;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public int getBones() {
        return bones;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }
}
