package com.example.mobile.appview.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class image implements Serializable {

    private final int img;
    private List<imageSub> listImgSub = new ArrayList<>();

    public image(int img, List<imageSub> listImgSub) {
        this.img = img;
        this.listImgSub = listImgSub;
    }

    public int getImg() {
        return img;
    }

    public List<imageSub> getListImgSub() {
        return listImgSub;
    }
}
