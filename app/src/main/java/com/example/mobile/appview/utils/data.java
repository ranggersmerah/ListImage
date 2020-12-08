package com.example.mobile.appview.utils;

import com.example.mobile.appview.R;
import com.example.mobile.appview.model.image;
import com.example.mobile.appview.model.imageSub;

import java.util.ArrayList;
import java.util.List;

public class data {

    public static List<image> getListIMG(){
        List<image> imgList = new ArrayList<>();
        List<imageSub> imgListSubStetoscope = new ArrayList<>();
        List<imageSub> imgListSubSuntik = new ArrayList<>();
        List<imageSub> imgListTermometer = new ArrayList<>();

        imgListSubStetoscope.add(new imageSub(R.drawable.stetoskop_satu));
        imgListSubStetoscope.add(new imageSub(R.drawable.stetoskop_dua));
        imgListSubStetoscope.add(new imageSub(R.drawable.stetoskop_tiga));

        imgListSubSuntik.add(new imageSub(R.drawable.suntik_satu));
        imgListSubSuntik.add(new imageSub(R.drawable.suntik_dua));
        imgListSubSuntik.add(new imageSub(R.drawable.suntik_tiga));

        imgListTermometer.add(new imageSub(R.drawable.termometer_satu));
        imgListTermometer.add(new imageSub(R.drawable.termometer_dua));
        imgListTermometer.add(new imageSub(R.drawable.termometer_tiga));

        imgList.add(new image(R.drawable.stetoscope, imgListSubStetoscope));
        imgList.add(new image(R.drawable.suntik, imgListSubSuntik));
        imgList.add(new image(R.drawable.termometer, imgListTermometer));

        return imgList;
    }

}
