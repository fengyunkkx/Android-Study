package zyl.android.projx;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class ProjXActivity extends Activity {
/*
	GridView gvInfo;
	String[] titles = new String[] { "����֧��", "��������", "�ҵ�֧��", "�ҵ�����", "���ݹ���",
			"ϵͳ����", "��֧��ǩ", "�˳���¼" };
	int[] images = new int[] { R.drawable.img01xl,
			R.drawable.img02xl, R.drawable.img03xl,
			R.drawable.img04xl, R.drawable.img05xl,
			R.drawable.img06xl, R.drawable.img07xl,
			R.drawable.img08xl };


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		gvInfo = (GridView) findViewById(R.id.gvInfo);
		pictureAdapter adapter = new pictureAdapter(titles, images, this);
		gvInfo.setAdapter(adapter);
		gvInfo.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = null;
				switch (arg2) {

				case 0:
					intent = new Intent(ProjXActivity.this, ProjXAddOutaccount.class); 	//����֧��
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(ProjXActivity.this, ProjXAddInaccount.class); 		//����֧��
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(ProjXActivity.this, ProjXOutaccountinfo.class); 	//����֧��
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(ProjXActivity.this, ProjXInaccountinfo.class); 	//�ҵ�����
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(ProjXActivity.this, ProjXShowinfo.class); 			//���ݹ���
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(ProjXActivity.this, ProjXSysset.class); 			//���ݹ���
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(ProjXActivity.this, ProjXAccountflag.class); 		//��֧��ǩ
					startActivity(intent);
					break;
				case 7:
					finish();																//�˳���¼

				}
			}
		});
	}
	*/
}