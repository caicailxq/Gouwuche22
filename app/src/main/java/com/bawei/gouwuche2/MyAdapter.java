package com.bawei.gouwuche2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public class MyAdapter extends RecyclerView.Adapter{
    private List<LXQbean> list;
    private Context context;

    public MyAdapter(List<LXQbean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rcview_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
       if(holder instanceof MyViewHolder){

           ((MyViewHolder) holder).cb_goods.setChecked(list.get(position).isB());
           ((MyViewHolder) holder).tv_name.setText(list.get(position).getName());
           ((MyViewHolder) holder).tv_price.setText(list.get(position).getPrice()+"");

           ((MyViewHolder) holder).cb_goods.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   list.get(position).setB(!list.get(position).isB());


                   boolean b=true;

                   for (int i = 0; i < list.size(); i++) {

                       if(!list.get(i).isB()){
                           b=false;
                       }
                   }

                   EventBus.getDefault().post(new EventBean(b,list));


                   notifyDataSetChanged();
               }
           });







       }


    }

    @Override
    public int getItemCount() {
//        list=new ArrayList<>();
        return list.size();
    }

 public class MyViewHolder extends RecyclerView.ViewHolder{

     public CheckBox cb_goods;
     public TextView tv_name;
     public TextView tv_price;

     public MyViewHolder(View itemView) {
         super(itemView);

         cb_goods=itemView.findViewById(R.id.cb_goods);
         tv_name=itemView.findViewById(R.id.tv_name);
         tv_price=itemView.findViewById(R.id.tv_price);
     }
 }

}
