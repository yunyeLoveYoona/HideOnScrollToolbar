package com.example.administrator.hideonscrolltoolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 15-5-28.
 */
public class HideToolbarListView extends ListView{
    private View headView;
    public HideToolbarListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        headView=new View(context);
    }
    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }
    public void setHeaderView(float height){
        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) height);
        headView.setLayoutParams(layoutParams);
        if(getHeaderViewsCount()==0) {
            addHeaderView(headView);
        }
    }
}
