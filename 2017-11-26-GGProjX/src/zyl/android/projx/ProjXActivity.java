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
	String[] titles = new String[] { "新增支出", "新增收入", "我的支出", "我的收入", "数据管理",
			"系统设置", "收支便签", "退出登录" };
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
					intent = new Intent(ProjXActivity.this, ProjXAddOutaccount.class); 	//新增支出
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(ProjXActivity.this, ProjXAddInaccount.class); 		//新增支出
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(ProjXActivity.this, ProjXOutaccountinfo.class); 	//新增支出
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(ProjXActivity.this, ProjXInaccountinfo.class); 	//我的收入
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(ProjXActivity.this, ProjXShowinfo.class); 			//数据管理
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(ProjXActivity.this, ProjXSysset.class); 			//数据管理
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(ProjXActivity.this, ProjXAccountflag.class); 		//收支便签
					startActivity(intent);
					break;
				case 7:
					finish();																//退出登录

				}
			}
		});
	}
	*/
}