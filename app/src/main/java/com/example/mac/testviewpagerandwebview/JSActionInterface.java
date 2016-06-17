package com.example.mac.testviewpagerandwebview;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by allen on 16/6/16.
 */
public class JSActionInterface {

    public static String currrentState;

    @JavascriptInterface
    public void isCanHtmlHorizationMove(String isCanMove) {
        Log.d("aaa", "isCanMove:" + isCanMove);
        currrentState = isCanMove;
    }
}
