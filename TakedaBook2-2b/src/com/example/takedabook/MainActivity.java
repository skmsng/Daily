package com.example.takedabook;

import android.os.Bundle;
import android.app.Activity;
import android.view.WindowManager;
import android.view.Window;

/*
 * タイトルバー、情報バーを消して全画面表示
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);
        //setContentView(new MyView(this));
    }
}
