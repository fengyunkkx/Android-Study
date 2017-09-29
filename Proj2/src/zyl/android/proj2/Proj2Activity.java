package zyl.android.proj2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Proj2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String[] str1={"�ı������","��ť����","ѡ������","������ʱ�����","��ʱ������"};
        ListView lst1=(ListView)this.findViewById(R.id.listView1);
        ArrayAdapter<String>adp1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,str1);
        lst1.setAdapter(adp1);
        lst1.setOnItemClickListener(new OnItemClickListener()
        {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
			{
				if(arg2==0)
				{
					Intent intent1 = new Intent(Proj2Activity.this,P201Activity.class);
					startActivity(intent1);
				}
				else if(arg2==1)
				{
					Intent intent2 = new Intent(Proj2Activity.this,P202Activity.class);
					startActivity(intent2);
				}
				else if(arg2==2)
				{
					Intent intent3 = new Intent(Proj2Activity.this,P203Activity.class);
					startActivity(intent3);
				}
				else if(arg2==3)
				{
					Intent intent4 = new Intent(Proj2Activity.this,P204Activity.class);
					startActivity(intent4);
				}
				else if(arg2==4)
				{
					Intent intent5 = new Intent(Proj2Activity.this,P205Activity.class);
					startActivity(intent5);
				}
			}
		});
    }

}

