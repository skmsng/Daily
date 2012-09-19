package com.example.takedabook3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class PuzzleView extends View{
	private static final int BTN_X = 50;	//ボタンの横位置
	private static final int BTN_Y = 768;	//ボタンの縦位置
	private static final int BTN_W = 390;	//ボタンの横幅
	private static final int BTN_H = 40;	//ボタンの縦幅
	private static final int BOARD_X = 40;	//ゲーム版の横位置
	private static final int BOARD_Y = 126;	//ゲーム版の縦位置
	private static final int SCORE_X = 60;	//テキストの表示横位置
	private static final int SCORE_Y = 73;	//テキストの表示縦位置
	
	private Puzzle puzzle;		//Puzzleクラス
	private PuzzleBoard board;	//PuzzleBoardクラス
	private Drawable back,btn1,btn2;	//使用するイメージ
	private boolean btn_down,isPlaying;	//ボタンの状態、プレイ中の状態
	private int pressX,pressY,upX,upY;	//ボタンを押したとき、離したときの位置
	
	public PuzzleView(Context context){
		super(context);
		this.init(context);
	}
	
	public PuzzleView(Context context, AttributeSet attrs){
		super(context, attrs);
		this.init(context);
	}
	
	public void init(Context context){
		this.puzzle = (Puzzle)context;
		Resources resources = context.getResources();
		this.back = resources.getDrawable(R.drawable.back);
		this.btn1 = resources.getDrawable(R.drawable.start);
		this.btn1.setBounds(BTN_X, BTN_Y, BTN_X+BTN_W, BTN_Y+BTN_H);
		this.btn2 = resources.getDrawable(R.drawable.start2);
		this.btn2.setBounds(BTN_X, BTN_Y, BTN_X+BTN_W, BTN_Y+BTN_H);
		
		Bitmap img = BitmapFactory.decodeResource(resources, R.drawable.image1);
		this.board = new PuzzleBoard(BOARD_X, BOARD_Y, img);
		this.btn_down = false;
		this.isPlaying = false;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		int w = this.getWidth();
		int h = this.getHeight();
		this.back.setBounds(0, 0, w, h);
		this.back.draw(canvas);
		this.board.draw(canvas);
		if(this.btn_down){
			this.btn2.draw(canvas);
		}else{
			this.btn1.draw(canvas);
		}
		Paint p = new Paint();
		p.setTextSize(30f);
		canvas.drawText("count: "+this.board.count, this.SCORE_X, this.SCORE_Y, p);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		int x = (int)event.getX();
		int y = (int)event.getY();
		switch(action){
		case MotionEvent.ACTION_DOWN:
			this.pressX = x;
			this.pressY = y;
			if(this.isIn(x,y,this.btn1.getBounds())){
				this.btn_down = true;
				this.isPlaying = true;
				this.board.init();
				Toast toast = Toast.makeText(this.puzzle, "スタート！"	, Toast.LENGTH_LONG);
				toast.show();
			}
			break;
		case MotionEvent.ACTION_UP:
			this.btn_down = false;
			this.upX = x;
			this.upY = y;
			if(this.isPlaying) this.checkMove();
			break;
		}
		this.invalidate();
		return true;
	}
	
	public boolean isIn(int x, int y, Rect rect){
		return x > rect.left && x < rect.right && y > rect.top && y < rect.bottom;
		
	}
	
	public void checkMove(){
		int dx = this.upX - this.pressX;
		int dy = this.upY - this.pressY;
		if(dx < -100) this.board.move(PuzzleBoard.WEST);
		if(dx > 100) this.board.move(PuzzleBoard.EAST);
		if(dy < -100) this.board.move(PuzzleBoard.NORTH);
		if(dy > 100) this.board.move(PuzzleBoard.SOUTH);
		if(this.board.checkFinish()){
			this.isPlaying = false;
			Toast toast = Toast.makeText(this.puzzle, "おめでとう！", Toast.LENGTH_LONG);
			toast.show();
		}
	}
}
