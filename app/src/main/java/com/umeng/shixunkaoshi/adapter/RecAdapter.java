package com.umeng.shixunkaoshi.adapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.umeng.shixunkaoshi.Bean;
import com.umeng.shixunkaoshi.R;

import java.util.ArrayList;


public class RecAdapter extends RecyclerView.Adapter {
    private Context baseContext;
    private ArrayList<Bean.DataBeanX.DataBean> beans;

    public RecAdapter(Context baseContext, ArrayList<Bean.DataBeanX.DataBean> beans) {
        this.baseContext = baseContext;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(baseContext, R.layout.rec_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final ViewHolder holder= (ViewHolder) viewHolder;
        Glide.with(baseContext).load(beans.get(i).getScene_pic_url()).into(holder.topic_img);
        holder.topic_name.setText(beans.get(i).getTitle());
        holder.topic_title.setText(beans.get(i).getSubtitle());
        holder.topic_price.setText(beans.get(i).getPrice_info()+"元起");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onclick(i);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClick.onlongclick(i);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView topic_img;
        private TextView topic_name;
        private TextView topic_title;
        private TextView topic_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topic_img = itemView.findViewById(R.id.topic_img);
            topic_name = itemView.findViewById(R.id.topic_name);
            topic_title = itemView.findViewById(R.id.topic_title);
            topic_price = itemView.findViewById(R.id.topic_price);
        }
    }
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
    public interface OnClick{
        void onclick(int position);
        void onlongclick(int position);
    }
}
