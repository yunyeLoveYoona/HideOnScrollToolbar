package com.example.administrator.hideonscrolltoolbar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.example.administrator.hideonscrolltoolbar.adapter.ListViewAdapter;
import com.example.administrator.hideonscrolltoolbar.view.HideToolbarListView;


public class MainActivity extends ActionBarActivity {
    private boolean isHede=false;
    private  Toolbar toolbar;
    private HideToolbarListView hideToolbarListView;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        image =(ImageView)findViewById(R.id.image);
        setSupportActionBar(toolbar);
        toolbar.setTitle("HideToolbar");
        toolbar.setTitleTextColor(Color.WHITE);
        hideToolbarListView= (HideToolbarListView) findViewById(R.id.listview);
        String[] strings ={"item1","item1","item1","item1","item1",
                "item1","item1","item1","item1","item1","item1","item1"};
        hideToolbarListView.setHeaderView(toolbar.getLayoutParams().height);
        hideToolbarListView.setAdapter(new ListViewAdapter(strings,this));
        hideToolbarListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                            if(!isHede) {
                                ValueAnimator valueAnimator = ObjectAnimator.ofFloat(toolbar, "translationY", 0.0f, 0-toolbar.getMeasuredHeight());
                                valueAnimator.setDuration(500);
                                valueAnimator.start();
                                hideToolbarListView.setHeaderView(0);
                                ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(image, "translationY", 0.0f,300);
                                valueAnimator1.setDuration(500);
                                valueAnimator1.start();
                                hideToolbarListView.setHeaderView(0);

                                isHede = true;
                            }
                        break;
                    case MotionEvent.ACTION_UP:
                        isHede=false;
                        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(toolbar, "translationY",0-toolbar.getMeasuredHeight() ,0.0f);
                        valueAnimator.setDuration(500);
                        valueAnimator.start();
                        ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(image, "translationY",300,0.0f);
                        valueAnimator1.setDuration(500);
                        valueAnimator1.start();
                        hideToolbarListView.setHeaderView(toolbar.getLayoutParams().height);
                        break;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
