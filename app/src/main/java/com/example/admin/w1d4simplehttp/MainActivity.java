package com.example.admin.w1d4simplehttp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";
    OkHttpClient client = new OkHttpClient();
    private String url = "https://randomuser.me/api";
    private EditText editText;
    private WebView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        editText = (EditText) findViewById(R.id.editTextMain);
        textView = (WebView) findViewById(R.id.textViewMain);
//        try {
//            Log.d(TAG, "onCreate: " + run(url));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public void getHttpResult(View view) {
        String url = editText.getText().toString();
//        try {
            textView.loadUrl(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
