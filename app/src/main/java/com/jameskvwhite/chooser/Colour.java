package com.jameskvwhite.chooser;

public enum Colour {
    GREEN_DARK(0xff27ae60),
    GREEN_LIGHT(0xff2ecc71);

    private int numVal;

    Colour(int numVal) {
        this.numVal = numVal;
    }

    public int getValue() {
        return numVal;
    }
}
