package com.example.mobile.appview.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobile.appview.R;
import com.example.mobile.appview.activity.DetailHome;
import com.example.mobile.appview.adapter.DotIndicator;
import com.example.mobile.appview.adapter.ListAdapter;

import static com.example.mobile.appview.utils.data.getListIMG;

public class Home extends Fragment {

    View view;
    RecyclerView recyclerView;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        getList(view);

        return view;
    }

    private void getList(View v){
        recyclerView = v.findViewById(R.id.rc_img_list);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(getListIMG());
        listAdapter.setOnItemClickListener((view1, obj, position) -> {
            Intent i = new Intent();
            i.setClass(requireActivity(), DetailHome.class);
            i.putExtra("Image", obj);
            startActivity(i);
        });
        recyclerView.setAdapter(listAdapter);

    }
}