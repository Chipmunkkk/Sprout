package com.example.chipmunk.sprout.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Chipmunk on 2017/5/31.
 */

public class GridView_Information extends GridView {
    public GridView_Information(Context context) {
        super(context);
    }

    public GridView_Information(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridView_Information(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
