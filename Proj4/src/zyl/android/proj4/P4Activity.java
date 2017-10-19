package zyl.android.proj4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class P4Activity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p4);

		int[] imageId = new int[] { R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5 };
		final String[] title = new String[] { "应用商店", "时钟设置", "通讯录设置", "电话设置", "下载设置" };
		
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		
		
		for (int i = 0; i < imageId.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", imageId[i]);
			map.put("title", title[i]);
			listItems.add(map);
		}

		final SimpleAdapter adapter = new SimpleAdapter(this, listItems,
				R.layout.p4layout, new String[] { "title", "image" }, new int[] {
				R.id.title, R.id.image });
		
		
		// 带列表的对话框
		
		Button button1 = (Button) findViewById(R.id.button1);

		button1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Builder builder = new AlertDialog.Builder(P4Activity.this);
				builder.setIcon(R.drawable.advise);
				builder.setTitle("设置：");
				
				builder.setAdapter(adapter, new OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P4Activity.this,
								"你选择的是[ " + title[which] + " ]",
								Toast.LENGTH_SHORT).show();

					}
				});
				builder.create().show();
			}
		});

	}
}