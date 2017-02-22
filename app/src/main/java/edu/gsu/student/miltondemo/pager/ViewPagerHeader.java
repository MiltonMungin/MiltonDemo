package edu.gsu.student.miltondemo.pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by miltonm on 2/21/17.
 */

public class ViewPagerHeader extends ViewPager {

    public ViewPagerHeader(Context context) {
        super(context);
    }

    public ViewPagerHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

}
