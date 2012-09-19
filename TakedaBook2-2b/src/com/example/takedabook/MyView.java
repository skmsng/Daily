package com.example.takedabook;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/*
 * Bitmapクラス
 * 画像の大きさは変えられない
 */
public class MyView extends View {
	
	private Context context;
	private Bitmap image;
	
	public MyView(Context context){
		this(context, null);
	}
	
	public MyView(Context context, AttributeSet attrs){
		super(context, attrs);
		this.context = context;
		
		Resources resources = this.context.getResources();
		this.image = BitmapFactory.decodeResource(resources, R.drawable.image);
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
		
		//座標(10,10)の地点から画像を表示する
		if(this.image != null){
			canvas.drawBitmap(this.image, 10, 10, new Paint());
		}
	}
}
