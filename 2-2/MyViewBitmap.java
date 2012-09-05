/*
 * Bitmapクラス
 * 画像の大きさは変えられない
 */

public class MyViewBitmap extends View{

	private Context context;
	private Bitmap image;

	public MyViewBitmap(Context context){
		this(context, null);
	}

	public MyViewBitmap(Context context, AttributeSet attrs){
		super(context, attrs);
		this.context = context;

		Resources resources = this.context.getResources();
		this.images = BitmapFactory.decodeResource(resources, R.drawable.image);
	}

	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);

		if(this.image != null){
			canvas.drawBitmap(this.image, 10, 10, new Paint());
		}

		int w = this.getWidth();
		int h = this.getHeight();
		Paint p = new Paint();
		p.setStyle(Style.STROKE);
		p.setColor(Color.DKGRAY);
		canvas.drawRect(new Rect(5, 5, w-10, h-10), p);
	}

}