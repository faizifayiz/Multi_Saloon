package com.example.multisaloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    LinearLayout toolbarLL;

    private GlobalPreference globalPreference;
    private String ip,uid;

    private String shop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();
        uid = globalPreference.getID();

        shop_name = getIntent().getStringExtra("shop");
        //Toast.makeText(this, ""+uid, Toast.LENGTH_SHORT).show();

       // String function = getIntent().getStringExtra("function");

        String url = "http://"+ ip +"/Multi_Saloon/api/recommendation.php?shop_mame="+shop_name;

        toolbarLL = findViewById(R.id.toolbarLL);
        toolbarLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        WebView view = (WebView) findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        view.addJavascriptInterface(new WebAppInterface(this), "android");
        view.setWebViewClient(new WebViewClient());


       /* webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.addJavascriptInterface(new WebAppInterface(this), "android");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return true;
            }
        });*/
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            //  Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
            alert(toast);
        }
    }

    public  void alert(String t){

        Toast.makeText(this, "success"+t, Toast.LENGTH_SHORT).show();
    }
}