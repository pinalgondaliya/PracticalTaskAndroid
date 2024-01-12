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
import com.pinal.practicaltaskandroid.Model.RangePattern;
import com.pinal.practicaltaskandroid.Model.ShopByFabric;
import com.pinal.practicaltaskandroid.R;

import java.util.List;

public class RecShoRangeAdapter extends RecyclerView.Adapter<RecShoRangeAdapter.RecViewHolder> {
    private Context context;
    private List<RangePattern> menuList;
    int limit;

    public RecShoRangeAdapter(Context context, List<RangePattern> menuList, int limit) {
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
        RangePattern menu = menuList.get(position);
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
