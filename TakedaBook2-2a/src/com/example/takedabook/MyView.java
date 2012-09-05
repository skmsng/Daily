package com.example.takedabook;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/*
 * Viewクラス
 * グラフィックを描いて表示する
 */
public class MyView extends View {
	
	private Context context;
	
	public MyView(Context context){
		super(context);
		this.context = context;
	}
	
	public MyView(Context context, AttributeSet attrs){
		super(context, attrs);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		int w = this.getWidth();
		int h = this.getHeight();
		Paint p = new Paint();
		p.setStyle(Style.STROKE);
		p.setColor(Color.DKGRAY);
		canvas.drawRect(new Rect(5, 5, w-10, h-10), p);
		
		for(int i=0; i<10; i++){
			Paint p2 = new Paint();
			p2.setStyle(Style.FILL);
			p2.setColor(Color.rgb(25*i, 0, 0));
			canvas.drawCircle(125+25*i, 125+25*i, 100, p2);
		}
	}
}
