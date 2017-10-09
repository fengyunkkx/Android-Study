package zyl.android.proj3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] str1={"��ͨ�б�","���Զ��岼���ļ����б�","��ʾ˫���ı��б�","��ͼ���ı����б�"};		// ���� ListView ������

        ListView lv1=(ListView)this.findViewById(R.id.listView1);					// ���� ListView ����
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,str1);

        lv1.setAdapter(ad1);
        lv1.setOnItemClickListener(new OnItemClickListener()
        {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				if(arg2==0)
				{
					Intent intent1 = new Intent(MainActivity.this,P1Activity.class);
					startActivity(intent1);
				}
				if(arg2==1)
				{
					Intent intent1 = new Intent(MainActivity.this,P2Activity.class);
					startActivity(intent1);
				}
				if(arg2==2)
				{
					Intent intent1 = new Intent(MainActivity.this,P3Activity.class);
					startActivity(intent1);
				}
        
			}
        });
    }
}