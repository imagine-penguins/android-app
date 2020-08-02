package com.startuppro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class    RecyclerViewAdapter_H extends RecyclerView.Adapter<RecyclerViewAdapter_H.mViewholder> {
    Activity context;
    List<Hardware_ModelClass> mylist;

    public RecyclerViewAdapter_H(Activity context,List<Hardware_ModelClass>mylist) {
        this.context=context;
        this.mylist=mylist;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter_H.mViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mview=LayoutInflater.from(context).inflate(R.layout.hardware_customlist_grid,
                viewGroup,false);
        GridLayoutManager.LayoutParams lp=(GridLayoutManager.LayoutParams) mview.getLayoutParams();

        mview.getLayoutParams().width = viewGroup.getMeasuredWidth() / 2;
        mview.getLayoutParams().height =viewGroup.getMeasuredWidth() / 2;

        mview.setLayoutParams(lp);
        return new RecyclerViewAdapter_H.mViewholder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter_H.mViewholder mViewholder, int i) {
        mViewholder.hardware_txt.setText(mylist.get(i).getHardware_name());
        mViewholder.hardware_pic.setImageResource(mylist.get(i).getHardware_img());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public static class mViewholder extends RecyclerView.ViewHolder{
        TextView hardware_txt;
        ImageView hardware_pic;
        private final Context context;

        public mViewholder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();

            hardware_pic=(itemView).findViewById(R.id.hardware_img);
            hardware_txt=(itemView).findViewById(R.id.hardware_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = null;
                    switch (getAdapterPosition()){
                        case 0: intent=new Intent(context,Awards.class);
                        break;

                        case 1: intent=new Intent(context,Awards.class);
                            break;

                        case 2: intent=new Intent(context,Awards.class);
                            break;

                        case 3: intent=new Intent(context,Awards.class);
                            break;

                        case 4: intent=new Intent(context,Awards.class);
                            break;

                        case 5: intent=new Intent(context,Awards.class);
                            break;

                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
