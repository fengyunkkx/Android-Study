package zyl.android.projx;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class ProjXPage2 extends Activity {
	/** Called when the activity is first created. */

	GridView gvInfo;
	String[] titles = new String[] { "数据管理", "收支便签" };
	int[] images = new int[] {R.drawable.img05xl, R.drawable.img07xl,};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page2);

		gvInfo = (GridView) findViewById(R.id.gvInfo2);
		pictureAdapter adapter = new pictureAdapter(titles, images, this);
		gvInfo.setAdapter(adapter);
		gvInfo.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = null;
				switch (arg2) {
				
				case 0:
					intent = new Intent(ProjXPage2.this, ProjXShowinfo.class); 			//数据管理
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(ProjXPage2.this, ProjXAccountflag.class); 		//收支便签
					startActivity(intent);
					break;

				}
			}
		});
	}
	
	
	
	
	
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
