package zyl.android.proj4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/*
 * 项目四：用户界面设计三
 * 用 Toast 显示消息
 * 用 Notification 显示状态通知
 * 用 AlertDialog 创建对话框
 * 自定义对话框
 * 
 *  带确定和取消的对话框
 *  带列表的对话框
 *  带单选列表项的对话框
 *  带多选列表项的对话框
 *
 */

public class Proj4Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] str1={"用 Toast 显示消息","用 Notification 显示状态通知","用 AlertDialog 创建对话框","自定义对话框"};		// 定义 ListView 的数组

        ListView lv1=(ListView)this.findViewById(R.id.listView1);					// 建立 ListView 对象
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,str1);

        lv1.setAdapter(ad1);
        lv1.setOnItemClickListener(new OnItemClickListener()
        {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				if(arg2==0)
				{
					Intent intent1 = new Intent(Proj4Activity.this,P1Activity.class);
					startActivity(intent1);
				}
				if(arg2==1)
				{
					Intent intent1 = new Intent(Proj4Activity.this,P2Activity.class);
					startActivity(intent1);
				}
				if(arg2==2)
				{
					Intent intent1 = new Intent(Proj4Activity.this,P3Activity.class);
					startActivity(intent1);
				}
				if(arg2==3)
				{
					Intent intent1 = new Intent(Proj4Activity.this,P4Activity.class);
					startActivity(intent1);
				}
        
				

				}
        });
    }
}