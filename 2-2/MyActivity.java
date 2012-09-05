/*
 *タイトルバー、情報バーを消して全画面表示
 */

package jp.rutles.android;

public class MyActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.main);
		//setContentView(new MyView(this));
	}
}