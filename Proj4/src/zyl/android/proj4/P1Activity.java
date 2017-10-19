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
		setContentView(R.layout.p1); // ָ��onClick���Է�ʽ

	}
	
	
/* ͨ��makeText()����������Ϣ��ʾ�� */
	
	public void click1(View v) {
		setContentView(R.layout.p1);
		Toast.makeText(this, "����ͨ�� makeText()������������Ϣ��ʾ��", Toast.LENGTH_LONG)
				.show();
	}
	
	
/* ͨ�����췽��������Ϣ��ʾ�� */
	
	public void click2(View v) {

		Toast toast = new Toast(this);
		
		LinearLayout ll = new LinearLayout(this); // ����һ�����Բ��ֹ�����
		
		ImageView iv = new ImageView(this); // ����һ��ImageView
		iv.setPadding(0, 0, 5, 0);
		ll.addView(iv);

		TextView tv = new TextView(this); // ���� TextView
		tv.setText("����ͨ�����췽����������Ϣ��ʾ��"); 
		ll.addView(tv);
		toast.setView(ll);
		toast.show(); 
	}

}
