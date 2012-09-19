package com.example.takedabook;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.WindowManager;
import android.view.Window;

/*
 * Activityに「画面の向き」と「画像の大きさ」を設定し、Viewから読み込ませる
 * onSaveInstanceState()でアクティビティ間のデータを保存する
 */
public class MainActivity extends Activity {
	
	private Configuration config;	//設定（現在の画面の状態）
	private int orientation;		//areasの添字（0:縦, 1:横）
	private static int[][] areas = new int[][]{
		new int[]{5, 5, 205, 305},	//縦画面の写真の大きさ
		new int[]{5, 5, 305, 205}	//横画面の写真の大きさ
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //タイトルバー、情報バーを消して全画面表示
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        //画面の向きを取得
        Resources resources = getResources();
        this.config = resources.getConfiguration();
        
        //縦向きではない場合
        if(this.config.orientation != Configuration.ORIENTATION_PORTRAIT){
        	this.orientation = 1;
        }
        setContentView(R.layout.main);
    }
    
/*	無くても動きは同じ
  
    //設定変更後（インスタンス状態が変更された時）
    @Override
    public void onConfigurationChanged(Configuration newConfig){
    	super.onConfigurationChanged(newConfig);
    	this.config = newConfig;
    }
    
    //インスタンス状態の保存
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
    	//super.onRestoreInstanceState(savedInstanceState);
    	super.onSaveInstanceState(savedInstanceState);
    	int ori = 0;
    	
    	//縦向きではない場合
    	if(this.config.orientation != Configuration.ORIENTATION_PORTRAIT){
    		ori = 1;
    	}
    	savedInstanceState.putInt("ORIENTATION", ori);
    }
    
    //インスタンス状態のリストア
    @Override
    protected void onRestoreInstanceState(Bundle outState){
    	//super.onSaveInstanceState(outState);
    	super.onRestoreInstanceState(outState);
    	this.orientation = outState.getInt("ORIENTATION");
    }
*/
    
    //MyViewクラスから呼ばれる
    public Rect getArea(){
    	int[] area = areas[this.orientation];
    	return new Rect(area[0], area[1], area[2], area[3]);
    }
}
