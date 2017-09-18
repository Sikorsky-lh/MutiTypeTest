package com.example.lihang.multitypetest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by lihang on 2017/9/18.
 */

public class PlaneViewBinder extends ItemViewBinder<Plane,PlaneViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {

        View root=inflater.inflate(R.layout.item_plane,parent,false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Plane plane) {
        holder.imgView.setImageResource(plane.imgId);
        holder.nameText.setText(plane.name);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameText;

        ImageView imgView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameText= (TextView) itemView.findViewById(R.id.plane_name);
            imgView= (ImageView) itemView.findViewById(R.id.plane_img);
        }
    }
}
