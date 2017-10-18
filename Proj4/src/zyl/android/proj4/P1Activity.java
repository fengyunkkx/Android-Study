package zyl.android.proj4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class P1Activity extends Activity { // 继承 Activity 类
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p1); // 指定onClick属性方式

	}

	public void click1(View v) {
		setContentView(R.layout.p1); // 通过makeText()方法创建消息提示框
		Toast.makeText(this, "这是通过 makeText()方法创建的消息提示框", Toast.LENGTH_LONG)
				.show(); // 通过构造方法创建消息提示框
	}

	public void click2(View v) {

		Toast toast = new Toast(this);
		LinearLayout ll = new LinearLayout(this); // 创建一个线性布局管理器
		ImageView iv = new ImageView(this); // 创建一个ImageView
		iv.setPadding(0, 0, 5, 0); // 设置ImageView的右边距
		ll.addView(iv); // 将ImageView添加到线性布局管理器中

		TextView tv = new TextView(this); // 创建一个TextView
		tv.setText("这是通过构造方法创建的消息提示框"); // 为TextView设置文本内容
		ll.addView(tv); // 将TextView添加到线性布局管理器中
		toast.setView(ll); // 设置消息提示框中要显示的视图
		toast.show(); // 显示消息提示框
	}

}
