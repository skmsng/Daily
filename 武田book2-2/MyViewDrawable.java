/*
 * Drawableクラス
 * 画像の大きさを変えられる
 */

public class MyViewDrawable extends View{

	private Context context;
	private Drawable drawable;

	public MyViewDrawable(Context context){
		this(context, null);
	}

	public MyViewDrawable(Context context, AttributeSet attrs){
		super(context, attrs);
		this.context = context;

		Resource resources = this.context.getResources();
		this.drawable = resources.getDrawable(R.drawable.image);
	}

	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);

		if(this.drawable != null){
			this.drawable.setBounds(10, 10, 310, 310);
			this.drawable.draw(canvas);
		}

		int w = this.getWidth();
		int h = this.getHeight();
		Paint p = new Paint();
		p.setStyle(Style.STROKE);
		p.setColor(Color.DKGRAY);
		p.setTextSize(30);
		canvas.drawRect(new Rect(5, 5, w-10, h-10) p);
		canvas.drawText("W:" + w + "h:" + h, 50, h-50, p);
	}

}