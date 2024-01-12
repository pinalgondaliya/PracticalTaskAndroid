package com.pinal.practicaltaskandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinal.practicaltaskandroid.Model.CateGoryModel;
import com.pinal.practicaltaskandroid.R;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.VieWHolder> {
    Context context;
    String bannerUrl;
    List<CateGoryModel.Child> listchild;



    public SubCategoryAdapter(Context context, List<CateGoryModel.Child> listchild) {
        this.context = context;
        this.listchild = listchild;
    }

    @NonNull
    @Override
    public VieWHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new VieWHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VieWHolder holder, int position) {
        CateGoryModel.Child category = listchild.get(position);
        holder.catName.setText(category.getCategoryName());
        Glide.with(context).load("https://www.91-cdn.com/hub/wp-content/uploads/2022/07/Top-laptop-brands-in-India.jpg").into(holder.imgBanner);
        holder.sss.setVisibility(View.GONE);
        holder.recsub.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return listchild.size();
    }

    public class VieWHolder extends RecyclerView.ViewHolder{
        ImageView imgBanner;
        TextView catName;
        ImageView sss;
        RecyclerView recsub;

        public VieWHolder(@NonNull View itemView) {
            super(itemView);

            imgBanner = itemView.findViewById(R.id.imgBanner);
            catName = itemView.findViewById(R.id.catName);
            sss = itemView.findViewById(R.id.sss);
            recsub = itemView.findViewById(R.id.recsub);
        }
    }



}
