package com.example.mobile.appview.adapter;

import android.annotation.SuppressLint;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile.appview.R;
import com.example.mobile.appview.model.image;
import com.example.mobile.appview.model.imageSub;

import java.util.List;

public class ListAdapterDetail extends RecyclerView.Adapter<ListAdapterDetail.ViewHolder> {

    private final List<imageSub> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView img;

        public ViewHolder(View v) {
            super(v);
            img = v.findViewById(R.id.img_list);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapterDetail(List<imageSub> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_img_list, parent, false);
        return new ViewHolder(v);
    }

    // ReString the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final imageSub image = items.get(position);

        holder.img.setImageResource(image.getImgsub());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

}