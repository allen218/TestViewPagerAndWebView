解决问题
===
>本项目解决的是当使用ViewPager内嵌webview,而webview内部又有左右滑动的事件时,会产生冲突.

注意
===
>1. 需要js配合,本地提供一个方法给js调用,也就是在webview页面控件可以左右滑动时,调用此方法.
>2. 如果看不到此事例,说明页面url已经过期,此时需要替换``Constant.WEBVIEW_URL``相应可左右滑动的页面url

JS部分代码:
---

    onTouchStart: function(swiper, even) {
                        console.log('22')
                        jsAction.isCanHtmlHorizationMove('1');
                    }
                    
Android暴露接口方法
---

     @JavascriptInterface
        public void isCanHtmlHorizationMove(String isCanMove) {
            Log.d("aaa", "isCanMove:" + isCanMove);
            currrentState = isCanMove;
        }

Android接口注册方法
---

        mWebView.addJavascriptInterface(new JSActionInterface(), "jsAction");


图例
===
![图例](./test.gif)
