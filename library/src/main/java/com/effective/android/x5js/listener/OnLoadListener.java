package com.effective.android.x5js.listener;

/**
 * 加载listener
 * Created by yummyLau on 18-09-17
 * Email: yummyl.lau@gmail.com
 * blog: yummylau.com
 */
public interface OnLoadListener {

    void onLoading(String url);

    void onLoadSuccess(String url);

    void onLoadFail(String url);
}
