package com.zhouxuan.manshop.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhouxuan.manshop.R;
import com.zhouxuan.manshop.home.bean.HomeBean;

import java.util.List;

/**
 * 周旋
 * 2017/10/20  10:56
 */

public class HomeAdapter4 extends RecyclerView.Adapter<HomeAdapter4.MyViewHolder>{
    Context context;
    List<HomeBean.DataBean.SubjectsBean> list;

    public HomeAdapter4(Context context, List<HomeBean.DataBean.SubjectsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_home4,parent,false);
        MyViewHolder holder1 = new MyViewHolder(view);
        return holder1;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(list.get(0).getGoodsList().get(position).getGoods_img(),holder.img);
        holder.tv.setText(list.get(0).getGoodsList().get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
           img = (ImageView) itemView.findViewById(R.id.img);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
