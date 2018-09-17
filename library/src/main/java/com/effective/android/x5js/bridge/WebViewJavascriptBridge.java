package com.effective.android.x5js.bridge;

public interface WebViewJavascriptBridge {
	void send(String data);
	void send(String data, CallBackFunction responseCallback);
}
