package zyl.android.proj3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P1Activity extends Activity{ //�̳� Activity ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);
        
        String[] str1={"��ͨѡ��1","��ͨѡ��2","��ͨѡ��3","��ͨѡ��4"};		// ���� ListView ������
        
        ListView lst1=(ListView)this.findViewById(R.id.listView1);
        ArrayAdapter<String>adp1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,str1);
        lst1.setAdapter(adp1);
	}
}

