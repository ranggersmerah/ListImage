package com.example.mobile.appview.model;

import java.io.Serializable;

public class imageSub implements Serializable {

    private final int imgsub;


    public imageSub(int imgsub) {
        this.imgsub = imgsub;
    }

    public int getImgsub() {
        return imgsub;
    }
}
