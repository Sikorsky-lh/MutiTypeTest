package com.example.lihang.multitypetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private MultiTypeAdapter adapter;
    private Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        adapter=new MultiTypeAdapter();

        adapter.register(Plane.class,new PlaneViewBinder());
        adapter.register(TankItem.class,new TankViewBinder());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        items=new Items();
        for (int i=0;i<20;i++){
            items.add(new Plane("苏35",R.mipmap.ic_launcher));
        }

        items.add(0,new TankItem("挑战者"));
        items.add(5,new TankItem("艾布拉姆斯"));

        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
