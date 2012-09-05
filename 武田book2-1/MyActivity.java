/*
* クリックリスナー
* トースト
*/

public class MyActivity extends Activity{

	private TextView text1;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		this.text1 = (TextView)this.findViewById(R.id.TextView01);
		Button btn1 = (Button)this.findViewById(R.id.Button01);
		btn1.setOnClickListener(new MyClickAdapter());
	}

	class MyClickAdapter implements OnclickListener{
		public void onClick(View view){
			this.text1.setText("クリックしました");

			@Override
			public void onClick(View view){
				Toast toast = Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_LONG);
				toast.show();
			}
		}
	}
}