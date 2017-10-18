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

		int[] imageId = new int[] { R.drawable.img1, R.drawable.img2,
				R.drawable.img3, R.drawable.img4, R.drawable.img5 }; // 定义并初始化保存图片id的数组
		final String[] title = new String[] { "应用商店", "时钟设置", "通讯录设置", "电话设置",
		"下载设置" }; // 定义并初始化保存列表项文字的数组
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>(); // 创建一个list集合
		// 通过for循环将图片id和列表项文字放到Map中，并添加到list集合中
		for (int i = 0; i < imageId.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>(); // 实例化Map对象
			map.put("image", imageId[i]);
			map.put("title", title[i]);
			listItems.add(map); // 将map对象添加到List集合中
		}

		final SimpleAdapter adapter = new SimpleAdapter(this, listItems,
				R.layout.p4layout, new String[] { "title", "image" }, new int[] {
				R.id.title, R.id.image }); // 创建SimpleAdapter
		
		
		// 带列表的对话框
		
		Button button1 = (Button) findViewById(R.id.button1); // 获取布局文件中添加的按钮
		button1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Builder builder = new AlertDialog.Builder(P4Activity.this);
				builder.setIcon(R.drawable.advise); // 设置对话框的图标
				builder.setTitle("设置："); // 设置对话框的标题
				// 添加列表项
				builder.setAdapter(adapter, new OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P4Activity.this,
								"您选择了[ " + title[which] + " ]",
								Toast.LENGTH_SHORT).show();

					}
				});
				builder.create().show(); // 创建对话框并显示
			}
		});

	}
}