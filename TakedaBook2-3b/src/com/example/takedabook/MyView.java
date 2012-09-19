package com.example.takedabook;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/*
 * Viewクラス
 * タップした場所に画像を移動させる
 * onTouchEvent() 画面をタッチしたときに呼ばれるメソッド
 * invalidate()   画面の更新
 */
public class MyView extends View {
	
	//private Context context;
	private MainActivity context;
	private Drawable drawable;
	private Rect lastRect;
	
	public MyView(Context context){
		this(context, null);
	}
	
	public MyView(Context context, AttributeSet attrs){
		super(context, attrs);
		this.context = (MainActivity)context;
		
		Resources resources = this.context.getResources();
		this.drawable = resources.getDrawable(R.drawable.image);
		
		this.lastRect = new Rect(5, 5, 205, 205);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		//四角形の枠
		int w = this.getWidth();
		int h = this.getHeight();
		Paint p = new Paint();
		p.setStyle(Style.STROKE);
		p.setColor(Color.DKGRAY);
		canvas.drawRect(new Rect(5, 5, w-10, h-10), p);
		
		//テキスト表示
		p.setTextSize(30);
		canvas.drawText("W:"+w+"h:"+h, 50, h-50, p);
		
		//lastRectの大きさで画像を描画
		if(this.drawable != null){
			this.drawable.setBounds(this.lastRect);
			this.drawable.draw(canvas);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		int x = (int)event.getX();
		int y = (int)event.getY();
		this.lastRect = new Rect(x-100, y-100, x+100, y+100);
		this.invalidate();	//画面の更新
		return true;
	}
}
