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
import android.widget.Toast;

/*
 * Viewクラスに押せるイメージ（ボタンもどき）を作る
 * drawable.setAlpha(0-255)　//透明度（0=透明）
 * event.getAction() //イベントの種類（押す、離す、動かす）
 */
public class MyView extends View {
	
	private MainActivity context;
	private Drawable drawable;
	private Rect rect;			//枠
	private boolean press;		//枠内を押したときtrue
	private boolean selected;	//枠内で離したときtrue
	
	public MyView(Context context){
		this(context, null);
	}
	
	public MyView(Context context, AttributeSet attrs){
		super(context, attrs);
		this.context = (MainActivity)context;
		
		Resources resources = this.context.getResources();
		this.drawable = resources.getDrawable(R.drawable.image);
		
		this.rect = new Rect(140, 140, 340, 340);
		this.press = false;
		this.selected = false;
	}
	
	@Override
	protected void onDraw(Canvas canvas){
//		super.onDraw(canvas);	無くても問題ない・・・らしい
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
			this.drawable.setBounds(this.rect);
			if(press){
				this.drawable.setAlpha(100); //少し透明
			}else{
				this.drawable.setAlpha(255);
			}
			this.drawable.draw(canvas);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		int action = event.getAction(); //イベントの種類
		int x = (int)event.getX();
		int y = (int)event.getY();
		if(x>this.rect.left && x<this.rect.right && y>this.rect.top && y<this.rect.bottom){
			switch(action){
			case MotionEvent.ACTION_DOWN:
				this.press = true;
				this.selected = false;
				break;
			case MotionEvent.ACTION_UP:
				this.press = false;
				this.selected = true;
				break;
			}
		}else{
			this.press = false;
			this.selected = false;
		}
		
		this.invalidate();	//画面の更新
		
		if(this.selected){
			this.selected = false;
			this.showMsg();
		}
		
		return true;
	}
	
	private void showMsg(){
		Toast toast = Toast.makeText(this.context, "クリックしました！", Toast.LENGTH_LONG);
		toast.show();
	}
}
