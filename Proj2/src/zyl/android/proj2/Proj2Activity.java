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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String[] str1={"�ı������","��ť����","ѡ������","������ʱ�����"};
        ListView lst1=(ListView)this.findViewById(R.id.listView1);
        ArrayAdapter<String>adp1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,str1);
        lst1.setAdapter(adp1);
        lst1.setOnItemClickListener(new  OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(arg2==0){
					Intent intent1 = new Intent(Proj2Activity.this,P201Activity.class);
					startActivity(intent1);
				}
				
			}
        	
        	
		});
    }

}