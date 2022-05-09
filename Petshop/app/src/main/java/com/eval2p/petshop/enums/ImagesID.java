package com.eval2p.petshop.enums;

import com.eval2p.petshop.R;

public enum ImagesID {
    BEAGLE(R.drawable.beagle),BONE(R.drawable.bone),BOXER(R.drawable.boxer), BRACO(R.drawable.braco), BULL_DOG(R.drawable.bulldog),
    CAT(R.drawable.cat), DOG(R.drawable.dog), HAMSTER(R.drawable.hamster), PET(R.drawable.pet),IMAGE_ME(R.drawable.img_me);

    private final int idDrawable;

    ImagesID(int idDrawable){
        this.idDrawable = idDrawable;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}
