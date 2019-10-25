package com.enggemy22.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.recyviewHolder> {
private Context context;
private List<Uploads> mlist;

    public recycleradapter(Context context, List<Uploads> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public recyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        recyviewHolder holder=new recyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyviewHolder holder, int position) {

        Uploads currentuploads= mlist.get(position);
        holder.mTextName.setText(currentuploads.getmName());
        holder.mTextPhone.setText(currentuploads.getmPhone());
        holder.mTextAdress.setText(currentuploads.getmAdress());
        Glide.with(context).load(currentuploads.getmImage()).into(holder.mimageView);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class recyviewHolder extends RecyclerView.ViewHolder {

        private TextView mTextName;
        private TextView mTextPhone;
        private TextView mTextAdress;
        private ImageView mimageView;
        public recyviewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName=itemView.findViewById(R.id.texet_view_name);
            mTextPhone=itemView.findViewById(R.id.texet_view_Phone);
            mTextAdress=itemView.findViewById(R.id.texet_view_adress);
            mimageView=itemView.findViewById(R.id.image_goal);

        }
    }
}
