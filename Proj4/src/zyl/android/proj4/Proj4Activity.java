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
 * ��Ŀ�ģ��û����������
 * �� Toast ��ʾ��Ϣ
 * �� Notification ��ʾ״̬֪ͨ
 * �� AlertDialog �����Ի���
 * �Զ���Ի���
 * 
 *  ��ȷ����ȡ���ĶԻ���
 *  ���б�ĶԻ���
 *  ����ѡ�б���ĶԻ���
 *  ����ѡ�б���ĶԻ���
 *
 */

public class Proj4Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] str1={"�� Toast ��ʾ��Ϣ","�� Notification ��ʾ״̬֪ͨ","�� AlertDialog �����Ի���","�Զ���Ի���"};		// ���� ListView ������

        ListView lv1=(ListView)this.findViewById(R.id.listView1);					// ���� ListView ����
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