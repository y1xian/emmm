package com.yyxnb.arch.base;

import android.os.Bundle;

import com.yyxnb.arch.annotations.SwipeStyle;
import com.yyxnb.arch.delegate.ActivityDelegate;

public interface IActivity extends IView {

    ActivityDelegate getBaseDelegate();

    default void initWindows() {
    }

    default boolean initArgs(Bundle extras) {
        return true;
    }

    void setSwipeBack(@SwipeStyle int mSwipeBack);
}