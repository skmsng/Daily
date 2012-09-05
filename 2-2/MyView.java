/*
 * グラフィックを描いて表示する
 * Viewクラス
 */
package jp.rutles.android;

public class MyView extends View{
	
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
		super.onDraw(c);
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
			canvas.drowCircle(25*i+125, 25*i+125, 100, p2);
		}
	}
}