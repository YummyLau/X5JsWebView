package com.effective.android.x5js;

import android.content.Context;
import android.util.AttributeSet;

import com.effective.android.x5js.bridge.BridgeWebView;
import com.effective.android.x5js.listener.OnLoadListener;
import com.effective.android.x5js.listener.OnScrollListener;

/**
 * 由于{@link android.webkit.WebView}存在多个问题，如 addJavascriptInterface 漏洞/密码存储漏洞，耗电，硬件加速导致闪屏等问题.
 * 故使用{@link com.tencent.smtt.sdk.WebView}服务并引用封装 jsbridge 支持 js 功能
 * Created by yummyLau on 18-09-17
 * Email: yummyl.lau@gmail.com
 * blog: yummylau.com
 */

public final class X5JsWebView extends BridgeWebView {

    public X5JsWebView(Context context) {
        super(context);
    }

    public X5JsWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public X5JsWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void postUrl(String s, byte[] bytes) {
        if (X5WebUtils.isTrustUrl(s)) {
            super.postUrl(s, bytes);
        } else {
            super.postUrl(s, null);
        }
    }

    private OnScrollListener mScrollListener;

    private OnLoadListener mLoadListener;

    public void setScrollListener(OnScrollListener mScrollListener) {
        this.mScrollListener = mScrollListener;
    }

    public void setLoadListener(OnLoadListener mLoadListener) {
        this.mLoadListener = mLoadListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollListener != null) {
            mScrollListener.onScroll(l, t, oldl, oldt);
        }
    }
}
