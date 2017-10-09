package zyl.android.proj3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class P3Activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p3);
		ListView lv1=(ListView)this.findViewById(R.id.listView1);
		String[] str1={"a1","a2","a3","a4","a5","a6","a7","a8"};
		int[] images=new int []{R.drawable.img01,R.drawable.img02,
			R.drawable.img03,R.drawable.img04,
			R.drawable.img05,R.drawable.img06,
			R.drawable.img07,R.drawable.img08};
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();

		//通过循环，将图标放入列表
		for(int i=0;i<images.length;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("img01", images[i]);
			map.put("title", str1[i]);
			data.add(map);
			
		}
		//两列显示
		SimpleAdapter sdt1=new SimpleAdapter(this,data,R.layout.p3layout,new String[]{"image","title"},new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});
		lv1.setAdapter(sdt1);
		
	}
}
