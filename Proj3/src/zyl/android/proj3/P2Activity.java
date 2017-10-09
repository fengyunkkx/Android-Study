package zyl.android.proj3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class P2Activity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.p2);
        
        ListView lv1=(ListView)this.findViewById(R.id.listView1);
        
        ArrayList<Map<String, Object>> data=new ArrayList<Map<String,Object>>();
        Map <String,Object> thing = new HashMap<String,Object>();

        thing.put("col01","张三");
        thing.put("col02","20");
        data.add(thing);
        
        thing = new HashMap<String,Object>();
        thing.put("col01", "李四");
        thing.put("col02", "25");
        data.add(thing);
        
        thing = new HashMap<String,Object>();
        thing.put("col01", "王五");
        thing.put("col02", "22");
        data.add(thing);

        
        SimpleAdapter sad1=new SimpleAdapter(this,data,R.layout.p2layout,new String[]{"col01","col02"},new int[]{R.id.textView1,R.id.textView2});
        lv1.setAdapter(sad1);
	}
}
