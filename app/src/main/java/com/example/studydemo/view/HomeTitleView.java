package com.example.studydemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.studydemo.R;

public class HomeTitleView extends RelativeLayout {

    public HomeTitleView(Context context) {
        super(context);
        init(context);
    }

    public HomeTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HomeTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public HomeTitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_home_title_layout, null);
        addView(view);
    }
}
