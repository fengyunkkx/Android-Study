package zyl.android.proj3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P2Activity extends Activity{ //继承 Activity 类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.p2);
        
        String[] str1={"选项1","选项2","选项3","选项4"};		// 定义 ListView 的数组
 
        ListView lv1=(ListView)this.findViewById(R.id.listView1);					// 建立 ListView 对象
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,R.layout.p2layout,str1); //自定义显示方式

        lv1.setAdapter(ad1);
	}
}

