package com.bawei.gouwuche2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcview;
    private CheckBox cb_all;
    private TextView tv_heji;
    private Button btn_buy;
    private List<LXQbean> datas = new ArrayList<>();;

    private int count=0;
    private int nums=0;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rcview = (RecyclerView) findViewById(R.id.rcview);
        cb_all = (CheckBox) findViewById(R.id.cb_all);
        tv_heji = (TextView) findViewById(R.id.tv_heji);
        btn_buy = (Button) findViewById(R.id.btn_buy);


        EventBus.getDefault().register(this);


        //实例化一个集合做为recyclerview的模拟数据


        for (int i = 0; i < 20; i++) {

            datas.add(new LXQbean("我是第"+i+"条数据",700+i,false));
        }

        rcview.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(datas,this);
        rcview.setAdapter(adapter);

        cb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean b=cb_all.isChecked();

                for (int i = 0; i < datas.size(); i++) {
                    datas.get(i).setB(b);

                    if(b){

                        count++;
                        nums+=datas.get(i).getPrice();
                    }


                }

                btn_buy.setText("付款("+count+")");
                tv_heji.setText(nums+"元");

                nums=0;
                count=0;
                rcview.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                MyAdapter adapter = new MyAdapter(datas,MainActivity.this);
                rcview.setAdapter(adapter);
            }
        });

    }

    @Subscribe
    public void onEvent(EventBean bean){

        boolean b=bean.is_all();
        datas=bean.getList();

        cb_all.setChecked(b);


        for (int i = 0; i < datas.size(); i++) {

            if(datas.get(i).isB()){
                count++;
                nums+=datas.get(i).getPrice();
            }
        }

        btn_buy.setText("付款("+count+")");
        tv_heji.setText(nums+"元");

        nums=0;
        count=0;
        rcview.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        MyAdapter adapter = new MyAdapter(datas,MainActivity.this);
        rcview.setAdapter(adapter);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
