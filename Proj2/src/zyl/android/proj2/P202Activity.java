package zyl.android.proj2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class P202Activity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p202);

	}

	public void buttonclick1 (View view){
		Toast.makeText(P202Activity.this,"���������ְ�ť",Toast.LENGTH_SHORT).show();
	}
	public void imageclick2 (View view){
		Toast.makeText(P202Activity.this,"������ͼƬ��ť",Toast.LENGTH_SHORT).show();
	}
}
