package com.example.administrator.hideonscrolltoolbar.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.hideonscrolltoolbar.R;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 15-5-28.
 */
public class ListViewAdapter extends BaseAdapter {
    private String[] strings;
    private Context context;
    public ListViewAdapter(String [] strings,Context context){
        this.strings = strings;
        this.context = context;

    }
    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(context, R.layout.adapter_item,null);
        }
        ((TextView)convertView.findViewById(R.id.text)).setText(strings[position]);
        return convertView;
    }
}
