package com.yinhao.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yinhao on 2017/9/13.
 */

public class MyBaseExpandableListViewAdapter extends BaseExpandableListAdapter {

    private ArrayList<County> counties = new ArrayList<>();
    private ArrayList<ArrayList<Row>> rows = new ArrayList<>();
    private Context context;

    public MyBaseExpandableListViewAdapter(ArrayList<County> counties, ArrayList<ArrayList<Row>> rows, Context context) {
        this.counties = counties;
        this.rows = rows;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return counties.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return rows.get(groupPosition).size();
    }

    @Override
    public County getGroup(int groupPosition) {
        return counties.get(groupPosition);
    }

    @Override
    public Row getChild(int groupPosition, int childPosition) {
        return rows.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderCounty holderCounty;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.list_exlist_group, parent, false);
            holderCounty = new ViewHolderCounty();
            holderCounty.tvGroupName = (TextView) convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(holderCounty);
        } else {
            holderCounty = (ViewHolderCounty) convertView.getTag();
        }
        holderCounty.tvGroupName.setText(counties.get(groupPosition).getCountyName());
        return convertView;
    }

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderRow viewHolderRow;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_exlist_item, parent, false);
            viewHolderRow = new ViewHolderRow();
            viewHolderRow.imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolderRow.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolderRow);
        } else {
            viewHolderRow = (ViewHolderRow) convertView.getTag();
        }
        viewHolderRow.imgIcon.setImageResource(rows.get(groupPosition).get(childPosition).getRowImg());
        viewHolderRow.tvName.setText(rows.get(groupPosition).get(childPosition).getRowname());
        return convertView;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolderCounty {
        private TextView tvGroupName;
    }

    private class ViewHolderRow {
        private ImageView imgIcon;
        private TextView tvName;
    }
}
