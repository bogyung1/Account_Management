package com.example.finaltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context mContext = null;
    ArrayList<SiteInfo> mData ;
    LayoutInflater mLayoutInflater = null;

    public MyAdapter(Context context, ArrayList<SiteInfo> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemLayout = convertView;
        if (itemLayout == null) {
            itemLayout = mLayoutInflater.inflate(R.layout.custom_list_setting, null);
        }

            TextView siteTv = (TextView) itemLayout.findViewById(R.id.site_name);
            TextView urlTv = (TextView) itemLayout.findViewById(R.id.url);
            TextView nameTv = (TextView) itemLayout.findViewById(R.id.name);



            siteTv.setText(mData.get(position).getmName());
            urlTv.setText(mData.get(position).getmUrl());
            nameTv.setText(mData.get(position).getmUser());


            return itemLayout;



    }
//
//    public void add(int index, SiteInfo addData){
//        mData.add(index, addData);
//        notifyDataSetChanged();
//    }


}
