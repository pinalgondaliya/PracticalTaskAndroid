package com.pinal.practicaltaskandroid.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinal.practicaltaskandroid.Model.ShopByCategory;
import com.pinal.practicaltaskandroid.Model.ShopByFabric;
import com.pinal.practicaltaskandroid.R;

import java.util.List;

public class RecShoFabAdapter extends RecyclerView.Adapter<RecShoFabAdapter.RecViewHolder> {
    private Context context;
    private List<ShopByFabric> menuList;
    int limit;

    public RecShoFabAdapter(Context context, List<ShopByFabric> menuList, int limit) {
        this.context = context;
        this.menuList = menuList;
        this.limit = limit;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fab,parent,false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        ShopByFabric menu = menuList.get(position);
        holder.txttitle.setText(menu.getName());

        Glide.with(context).load(menu.image).into(holder.img_thumb);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder{
        TextView txttitle;
        ImageView img_thumb;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            txttitle = itemView.findViewById(R.id.txttilte);
            img_thumb = itemView.findViewById(R.id.img_thumb);
        }
    }
}
