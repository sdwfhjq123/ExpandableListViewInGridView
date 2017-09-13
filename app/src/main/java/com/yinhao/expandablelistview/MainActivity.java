package com.yinhao.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<County> counties;
    private ArrayList<ArrayList<Row>> items;
    private ArrayList<Row> rows;
    private MyBaseExpandableListViewAdapter adapter;

    private ExpandableListView exList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exList = (ExpandableListView) findViewById(R.id.exList);
        //数据准备
        counties = new ArrayList<>();
        items=new ArrayList<>();
        //添加组名
        counties.add(new County("历下区"));
        counties.add(new County("市中区"));
        counties.add(new County("槐荫区"));
        counties.add(new County("天桥区"));
        counties.add(new County("历城区"));
        counties.add(new County("高新区"));

        rows = new ArrayList<>();
        rows.add(new Row("1街道", R.mipmap.ic_launcher));
        rows.add(new Row("2街道", R.mipmap.ic_launcher));
        rows.add(new Row("3街道", R.mipmap.ic_launcher));
        rows.add(new Row("4街道", R.mipmap.ic_launcher));
        rows.add(new Row("5街道", R.mipmap.ic_launcher));
        items.add(rows);

        rows = new ArrayList<>();
        rows.add(new Row("1街道", R.mipmap.ic_launcher));
        rows.add(new Row("2街道", R.mipmap.ic_launcher));
        rows.add(new Row("3街道", R.mipmap.ic_launcher));
        rows.add(new Row("4街道", R.mipmap.ic_launcher));
        rows.add(new Row("5街道", R.mipmap.ic_launcher));
        items.add(rows);
        rows = new ArrayList<>();
        rows.add(new Row("1街道", R.mipmap.ic_launcher));
        rows.add(new Row("2街道", R.mipmap.ic_launcher));
        rows.add(new Row("3街道", R.mipmap.ic_launcher));
        rows.add(new Row("4街道", R.mipmap.ic_launcher));
        rows.add(new Row("5街道", R.mipmap.ic_launcher));
        items.add(rows);
        rows = new ArrayList<>();
        rows.add(new Row("1街道", R.mipmap.ic_launcher));
        rows.add(new Row("2街道", R.mipmap.ic_launcher));
        rows.add(new Row("3街道", R.mipmap.ic_launcher));
        rows.add(new Row("4街道", R.mipmap.ic_launcher));
        rows.add(new Row("5街道", R.mipmap.ic_launcher));
        items.add(rows);
        rows = new ArrayList<>();
        rows.add(new Row("1街道", R.mipmap.ic_launcher));
        rows.add(new Row("2街道", R.mipmap.ic_launcher));
        rows.add(new Row("3街道", R.mipmap.ic_launcher));
        rows.add(new Row("4街道", R.mipmap.ic_launcher));
        rows.add(new Row("5街道", R.mipmap.ic_launcher));
        items.add(rows);
        rows = new ArrayList<>();
        rows.add(new Row("1街道", R.mipmap.ic_launcher));
        rows.add(new Row("2街道", R.mipmap.ic_launcher));
        rows.add(new Row("3街道", R.mipmap.ic_launcher));
        rows.add(new Row("4街道", R.mipmap.ic_launcher));
        rows.add(new Row("5街道", R.mipmap.ic_launcher));
        items.add(rows);

        Log.i(TAG, "onCreate: " + items.size());
        Log.i(TAG, "onCreate: "+rows.size());
        adapter = new MyBaseExpandableListViewAdapter(counties, items, this);
        exList.setAdapter(adapter);
    }
}
