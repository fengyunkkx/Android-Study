package zyl.android.projx;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class ProjXPage1 extends Fragment {
	
	GridView gvInfo;
	String[] titles = new String[] { "新增支出", "新增收入", "我的支出", "我的收入"};
	int[] images = new int[] { R.drawable.img01xl,
			R.drawable.img02xl, R.drawable.img03xl,
			R.drawable.img04xl };
	
    private View mView;  

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        if(mView == null){  
            mView = inflater.inflate(R.layout.page1, container, false);  
        }  
        return mView;  
    }  


    public void onDestroyView() {  
        super.onDestroyView();  
        ((ViewGroup) mView.getParent()).removeView(mView);  
    }  

	
	
	// Activity
	
    private ListView list1;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        gvInfo = (GridView) findViewById(R.id.gvInfo1);
		pictureAdapter adapter = new pictureAdapter(titles, images, this);
		gvInfo.setAdapter(adapter);
		gvInfo.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = null;
				switch (arg2) {

				case 0:
					intent = new Intent(ProjXPage1.this, ProjXAddOutaccount.class); 	//新增支出
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(ProjXPage1.this, ProjXAddInaccount.class); 	//新增支出
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(ProjXPage1.this, ProjXOutaccountinfo.class); 	//新增支出
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(ProjXPage1.this, ProjXInaccountinfo.class); 	//我的收入
					startActivity(intent);
					break;

				}
			}
		});
    }
 
    private class MyAdapter extends BaseAdapter {
 
        private LayoutInflater inflater;
 
        MyAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }
 
        public int getCount() {
            return 20;
        }
 
        public Object getItem(int position) {
            return position;
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        public View getView(int position, View convertView, ViewGroup parent) {
 
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.page1, null);
            }
            
            
            
            
            return convertView;
        }
 
    }
	
	
	
	// 布局内容	
	
	
	
	
	class ViewHolder
	{
		public TextView title;
		public ImageView image;
	}

	class Picture
	{
		private String title;
		private int imageId;
		public Picture()
		{
			super();
		}
		public Picture(String title,int imageId)
		{
			super();
			this.title=title;
			this.imageId=imageId;
		}
		public String getTitle(){
			return title;
		}
		public void setTitle(String title){
			this.title=title;
		}
		public int getImageId(){
			return imageId;

		}
		public void setimageId(int imageId){
			this.imageId=imageId;
		}

	}

	class pictureAdapter extends BaseAdapter
	{
		private LayoutInflater inflater;
		private List<Picture> pictures;


		public pictureAdapter(String[] titles, int[] images, Context context) {
			super();
			pictures = new ArrayList<Picture>();
			inflater = LayoutInflater.from(context);
			for (int i = 0; i < images.length; i++)
			{
				Picture picture = new Picture(titles[i], images[i]);
				pictures.add(picture);
			}
		}

		public int getCount() {
			if (null != pictures) {
				return pictures.size();
			} else {
				return 0;
			}
		}

		public Object getItem(int arg0) {
			return pictures.get(arg0);
		}


		public long getItemId(int arg0) {
			return arg0;
		}


		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ViewHolder viewHolder;
			if (arg1 == null)
			{
				arg1 = inflater.inflate(R.layout.gvitem, null);
				viewHolder = new ViewHolder();
				viewHolder.title = (TextView) arg1.findViewById(R.id.ItemTitle);
				viewHolder.image = (ImageView) arg1.findViewById(R.id.ItemImage);
				arg1.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) arg1.getTag();
			}
			viewHolder.title.setText(pictures.get(arg0).getTitle());
			viewHolder.image.setImageResource(pictures.get(arg0).getImageId());
			return arg1;
		}
	}
}
