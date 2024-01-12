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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VieWHolder> {
    Context context;
    List<CateGoryModel.Category> list;
    String bannerUrl;
    List<CateGoryModel.Child> listchild;
    boolean ssss = false;

    public CategoryAdapter(Context context, List<CateGoryModel.Category> list, String bannerUrl) {
        this.context = context;
        this.list = list;
        this.bannerUrl = bannerUrl;
    }

    public CategoryAdapter(Context context, List<CateGoryModel.Category> list, List<CateGoryModel.Child> listchild) {
        this.context = context;
        this.list = list;
        this.listchild = listchild;
    }

    @NonNull
    @Override
    public VieWHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new VieWHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VieWHolder holder, int position) {
        CateGoryModel.Category category = list.get(position);
        holder.catName.setText(category.getCategoryName());
        Glide.with(context).load("https://www.91-cdn.com/hub/wp-content/uploads/2022/07/Top-laptop-brands-in-India.jpg").into(holder.imgBanner);
        holder.sss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.recsub.getVisibility() == View.VISIBLE){
                    holder.recsub.setVisibility(View.GONE);
                }
                if (category.child.size() >= 0 && !category.child.isEmpty()) {
                    holder.recsub.setVisibility(View.VISIBLE);
                    ssss = true;
                    holder.recsub.setAdapter(new SubCategoryAdapter(context, listchild));
                } else {
                    holder.recsub.setVisibility(View.GONE);
                    ssss = false;
                }
            }
        });

        if (category.child.size() >= 0 && !category.child.isEmpty()) {
            holder.sss.setVisibility(View.VISIBLE);
        } else {
            holder.sss.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VieWHolder extends RecyclerView.ViewHolder {
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
