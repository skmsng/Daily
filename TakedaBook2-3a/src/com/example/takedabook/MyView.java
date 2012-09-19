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
import android.view.View;

/*
 * Drawableクラス
 * 画像の大きさを変えられる
 */
public class MyView extends View {
	
	//private Context context;
	private MainActivity context;
	private Drawable drawable;
	
	public MyView(Context context){
		this(context, null);
	}
	
	public MyView(Context context, AttributeSet attrs){
		super(context, attrs);
		//this.context = context;
		this.context = (MainActivity)context;
		
		Resources resources = this.context.getResources();
		this.drawable = resources.getDrawable(R.drawable.image);
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
		
		//MainActivityのgetArea()から大きさを取得して表示している
		if(this.drawable != null){
			//this.drawable.setBounds(10, 10, 210, 210);
			this.drawable.setBounds(this.context.getArea());
			this.drawable.draw(canvas);
		}
	}
}
