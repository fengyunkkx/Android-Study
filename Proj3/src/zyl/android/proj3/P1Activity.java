package zyl.android.proj3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P1Activity extends Activity{ //�̳� Activity ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.p1);
        
        String[] str1={"ѡ��1","ѡ��2","ѡ��3","ѡ��4"};		// ���� ListView ������
 
        ListView lv1=(ListView)this.findViewById(R.id.listView1);					// ���� ListView ����
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,R.layout.p1layout,str1); //�Զ�����ʾ��ʽ

        lv1.setAdapter(ad1);
	}
}

