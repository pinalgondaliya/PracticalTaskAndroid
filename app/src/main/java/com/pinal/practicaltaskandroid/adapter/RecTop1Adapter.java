package com.pinal.practicaltaskandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinal.practicaltaskandroid.Model.StickyMenu;
import com.pinal.practicaltaskandroid.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecTop1Adapter extends RecyclerView.Adapter<RecTop1Adapter.RecViewHolder> {
    private Context context;
    private List<StickyMenu.Menu> menuList;

    public RecTop1Adapter(Context context, List<StickyMenu.Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rectop1,parent,false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        StickyMenu.Menu menu = menuList.get(position);
        holder.txttitle.setText(menu.getTitle());

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
