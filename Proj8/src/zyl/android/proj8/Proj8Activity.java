package zyl.android.proj8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/*
 * 项目八：资源访问
 * 字符串、颜色与尺寸资源
 * 图片资源
 * 样式与主题资源
 * 菜单资源
 * XML文件资源
 */

public class Proj8Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		String[] str1={"字符串资源","彩虹色","图片资源","样式与主题资源","菜单资源","XML文件资源"};		// 定义 ListView 的数组

		ListView lv1=(ListView)this.findViewById(R.id.listView1);					// 建立 ListView 对象
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,str1);

		lv1.setAdapter(ad1);
		lv1.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				if(arg2==0)
				{
					Intent intent1 = new Intent(Proj8Activity.this,P1Activity.class);
					startActivity(intent1);
				}
				if(arg2==1)
				{
					Intent intent1 = new Intent(Proj8Activity.this,P2Activity.class);
					startActivity(intent1);
				}
				if(arg2==2)
				{
					Intent intent1 = new Intent(Proj8Activity.this,P3Activity.class);
					startActivity(intent1);
				}
				if(arg2==3)
				{
					Intent intent1 = new Intent(Proj8Activity.this,P4Activity.class);
					startActivity(intent1);
				}
				if(arg2==4)
				{
					Intent intent1 = new Intent(Proj8Activity.this,P5Activity.class);
					startActivity(intent1);
				}
				if(arg2==5)
				{
					Intent intent1 = new Intent(Proj8Activity.this,P6Activity.class);
					startActivity(intent1);
				}



			}
		});
	}
}