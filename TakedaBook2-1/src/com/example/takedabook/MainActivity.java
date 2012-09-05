package com.example.takedabook;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * クイックリスナー
 * トースト
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		Button button = (Button)this.findViewById(R.id.Button01);
		button.setOnClickListener(new MyClickAdapter());
    }
    
    class MyClickAdapter implements OnClickListener{
    	
		@Override
		public void onClick(View view1){
			
			Toast toast = Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_LONG);
			toast.show();
		}
	}
}
