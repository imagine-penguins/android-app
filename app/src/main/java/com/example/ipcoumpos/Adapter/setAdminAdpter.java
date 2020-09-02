package com.example.ipcoumpos.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipcoumpos.R;

import java.util.ArrayList;

public class setAdminAdpter extends RecyclerView.Adapter<setAdminAdpter.ViewHolder> {
   private final ArrayList<String>setAd;
   private final Activity context;
    public setAdminAdpter(Activity context,ArrayList<String> setAd) {
        this.setAd = setAd;
        this.context=context;
    }

    @NonNull
    @Override
    public setAdminAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.dashboardcarddesign, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull setAdminAdpter.ViewHolder holder, int position) {
        holder.tt.setText(setAd.get(position));
    }

    @Override
    public int getItemCount() {
        return setAd.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tt;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            tt=itemView.findViewById(R.id.tt);
//            imageView=itemView.findViewById(R.id.background);

        }
    }
}
