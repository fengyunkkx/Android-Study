package zyl.android.proj3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class P2Activity extends Activity{ //�̳� Activity ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.p2);
        
        String[] str1={"ѡ��1","ѡ��2","ѡ��3","ѡ��4"};		// ���� ListView ������
 
        ListView lv1=(ListView)this.findViewById(R.id.listView1);					// ���� ListView ����
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,R.layout.p2layout,str1); //�Զ�����ʾ��ʽ

        lv1.setAdapter(ad1);
	}
}

