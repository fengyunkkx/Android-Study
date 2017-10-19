package zyl.android.proj4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class P1Activity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p1); // 指定onClick属性方式

	}
	
	
/* 通过makeText()方法创建消息提示框 */
	
	public void click1(View v) {
		setContentView(R.layout.p1);
		Toast.makeText(this, "这是通过 makeText()方法创建的消息提示框", Toast.LENGTH_LONG)
				.show();
	}
	
	
/* 通过构造方法创建消息提示框 */
	
	public void click2(View v) {

		Toast toast = new Toast(this);
		
		LinearLayout ll = new LinearLayout(this); // 创建一个线性布局管理器
		
		ImageView iv = new ImageView(this); // 创建一个ImageView
		iv.setPadding(0, 0, 5, 0);
		ll.addView(iv);

		TextView tv = new TextView(this); // 创建 TextView
		tv.setText("这是通过构造方法创建的消息提示框"); 
		ll.addView(tv);
		toast.setView(ll);
		toast.show(); 
	}

}
