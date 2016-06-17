package com.example.mac.testviewpagerandwebview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allen on 16/6/16.
 */
public class NormalFragment extends Fragment {

    @BindView(R.id.web_view)
    CustomWebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.normal_layout, null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setSaveEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.addJavascriptInterface(new JSActionInterface(), "jsAction");
        mWebView.loadUrl("http://m.xiu.com/H5/H5Demo/index.html");
    }

}
