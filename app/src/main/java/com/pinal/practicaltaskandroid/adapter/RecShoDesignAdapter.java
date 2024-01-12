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
import com.pinal.practicaltaskandroid.Model.Design;
import com.pinal.practicaltaskandroid.Model.ShopByCategory;
import com.pinal.practicaltaskandroid.R;

import java.util.List;

public class RecShoDesignAdapter extends RecyclerView.Adapter<RecShoDesignAdapter.RecViewHolder> {
    private Context context;
    private List<Design> menuList;
    int limit;

    public RecShoDesignAdapter(Context context, List<Design> menuList, int limit) {
        this.context = context;
        this.menuList = menuList;
        this.limit = limit;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_cdesignt, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        Design menu = menuList.get(position);
        holder.txttitle.setText(menu.getName());
        holder.txtcta.setText(menu.getCta());
        holder.txtexplore.setText(menu.getSub_name());

        Glide.with(context).load(menu.image).into(holder.img_thumb);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {
        TextView txttitle,txtexplore,txtcta;
        LinearLayout ll_bottom;
        ImageView img_thumb;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            txttitle = itemView.findViewById(R.id.txttilte);
            img_thumb = itemView.findViewById(R.id.img_thumb);
            ll_bottom = itemView.findViewById(R.id.ll_bottom);
            txtexplore = itemView.findViewById(R.id.txtexplore);
            txtcta = itemView.findViewById(R.id.txtcta);
        }
    }
}
