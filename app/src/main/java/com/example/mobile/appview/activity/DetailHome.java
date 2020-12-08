package com.example.mobile.appview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobile.appview.R;
import com.example.mobile.appview.adapter.DotIndicator;
import com.example.mobile.appview.adapter.ListAdapter;
import com.example.mobile.appview.adapter.ListAdapterDetail;
import com.example.mobile.appview.model.image;
import com.example.mobile.appview.model.imageSub;

import java.util.HashSet;
import java.util.Set;

import static com.example.mobile.appview.utils.data.getListIMG;

public class DetailHome extends AppCompatActivity {

    image image;
    private LinearLayout dotsLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle b = getIntent().getExtras();
        if (b!=null) {
            image = (image) b.getSerializable("Image");
        }

        ImageView Back = findViewById(R.id.back_detail);
        Back.setOnClickListener(view -> finish());

        RecyclerView recyclerView = findViewById(R.id.rc_img_list_detail);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        ListAdapterDetail listAdapter = new ListAdapterDetail(image.getListImgSub());
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DotIndicator());
    }


}