package com.example.movierating;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String[] s1, String[] s2, int[] img){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.custom_view,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
    holder.textTitle.setText(data1[position]);
    holder.textDesc.setText(data2[position]);
    holder.imageTv.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textDesc;
        ImageView imageTv;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
         textTitle = itemView.findViewById(R.id.textTitle);
         textDesc = itemView.findViewById(R.id.textDesc);
         imageTv = itemView.findViewById(R.id.imageTv);

        }
    }
}
