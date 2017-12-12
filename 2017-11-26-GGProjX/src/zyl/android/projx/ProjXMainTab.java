package zyl.android.projx;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;


/**
 * 使用ViewPager和RadioGroup实现底部导航栏
 * 
 */
public class ProjXMainTab extends FinalActivity {

	@ViewInject(id = R.id.viewpager)
	private ViewPager viewPager;
	@ViewInject(id = R.id.radiogroup)
	private RadioGroup radioGroup;
	@ViewInject(id = R.id.tab1)
	private RadioButton tab1;
	@ViewInject(id = R.id.tab2)
	private RadioButton tab2;
	@ViewInject(id = R.id.tab3)
	private RadioButton tab3;

	private List<View> viewList;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintab);

		initViewPager();
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(RadioGroup group, int checkedId) {				// 切换页面
				switch (checkedId) {
				case R.id.tab1:
					viewPager.setCurrentItem(0);
					break;
				case R.id.tab2:
					viewPager.setCurrentItem(1);
					break;
				case R.id.tab3:
					viewPager.setCurrentItem(2);
					break;
				}
			}
		});


	}


	private void initViewPager() {

		viewList = new ArrayList<View>();
		viewList.add(LayoutInflater.from(this).inflate(R.layout.page1, null));
		viewList.add(LayoutInflater.from(this).inflate(R.layout.page2, null));
		viewList.add(LayoutInflater.from(this).inflate(R.layout.page3, null));
		viewPager.setAdapter(new MyViewPagerAdapter());
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					tab1.setChecked(true);
					tab2.setChecked(false);
					tab3.setChecked(false);
					break;
				case 1:
					tab1.setChecked(false);
					tab2.setChecked(true);
					tab3.setChecked(false);
					break;
				case 2:
					tab1.setChecked(false);
					tab2.setChecked(false);
					tab3.setChecked(true);
					break;
				}
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}


	private class MyViewPagerAdapter extends PagerAdapter {

		public int getCount() {
			return viewList.size();
		}

		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(viewList.get(position));
		}

		public Object instantiateItem(ViewGroup container, int position) {
			View view = viewList.get(position);
			container.addView(view);

			return view;
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
