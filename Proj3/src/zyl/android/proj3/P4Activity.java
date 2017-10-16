package zyl.android.proj3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class P4Activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p4);
		ListView lv1=(ListView)this.findViewById(R.id.listView1);
		String[] str1={"应用商店","日历","游戏中心","阅读","图片","照片","应用中心","短信"};
		int[] images=new int []{R.drawable.img01,R.drawable.img02,
			R.drawable.img03,R.drawable.img04,
			R.drawable.img05,R.drawable.img06,
			R.drawable.img07,R.drawable.img08};
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();

		//通过循环，将图标放入列表
		for(int i=0;i<images.length;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("image", images[i]);
			map.put("title", str1[i]);
			data.add(map);
			
		}
		//两列显示
		SimpleAdapter sdt1=new SimpleAdapter(this,data,R.layout.p4layout,new String[]{"image","title"},new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});
		lv1.setAdapter(sdt1);
		
	}
}
