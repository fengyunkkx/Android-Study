package zyl.android.proj4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class P3Activity extends Activity {
	private boolean[] checkedItems;
	private String[] items;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p3);
		

/*
	protected static final int DialogInterface = 0;
	private boolean[] checkedItems;
	private String[] items;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p3);
		Button button1=(Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = new AlertDialog.Builder(P3Activity.this).create();
				alert.setIcon(R.drawable.advise);
				alert.setTitle("测试成功！");
				alert.setMessage("这是一个带确定和取消按钮的对话框：");

				alert.setButton(DialogInterface, BUTTON_NEGATIVE,"取消",new OnClickListener(){
					public void onClick(DialogInterface dialog, log which){
						Toast.makeText(P3Activity.this,"你单击了取消按钮",Toast.LENGTH_SHORT).show();

					}
				})
			}
		})

	}
 */

		
		// 取消确定对话框
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				AlertDialog alert = new AlertDialog.Builder(P3Activity.this).create();
				alert.setIcon(R.drawable.advise);
				alert.setTitle("Hey，这是一个通知！");
				alert.setMessage("取消、还行吧、确定");
				
				
				//取消按钮
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this, "您单击了取消按钮",
								Toast.LENGTH_SHORT).show();

					}
				});
				
				
				//确定按钮
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this, "您单击了确定按钮",
								Toast.LENGTH_SHORT).show();

					}
				});
				
				
				//中立按钮
				alert.setButton(DialogInterface.BUTTON_NEUTRAL,"还行吧",new OnClickListener(){

					
					public void onClick(DialogInterface dialog, int which) {}
				});
				
				alert.show();
			}
		});
		
		
		
		// 单选对话框1
		Button button2 = (Button) findViewById(R.id.button2); 
		button2.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				final String[] items = new String[] { "新浪微博", "QQ 空间", "知乎", "Twitter", "Instagram" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise1);
				builder.setTitle("你最喜欢的社交平台是：");
				builder.setItems(items, new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this,
								"你最喜欢用的是" + items[which], Toast.LENGTH_SHORT).show();

					}
				});
				builder.create().show();
			}
		});
		
		
		
		
		//单选对话框2
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				final String[] items = new String[] { "QQ", "微信", "Telegram", "Line", "钉钉" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise2);
				builder.setTitle("你最喜欢用的社交软件是：");
				builder.setSingleChoiceItems(items, 0, new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this,
								"你最喜欢用的是" + items[which], Toast.LENGTH_SHORT).show();

					}
				});

				builder.setPositiveButton("确定", null);
				builder.create().show();
			}
		});
		
		
		
		// 多选对话框
		
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				checkedItems= new boolean[] { false, true, false,true, false };
				items = new String[] { "Wizard 3", "Radiation 4", "Assassin's Creed", "MineCraft",
				"Hearth Stone" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise2);
				builder.setTitle("你最喜欢玩的游戏是：");	
				builder.setMultiChoiceItems(items, checkedItems,
						new OnMultiChoiceClickListener() {

					
					public void onClick(DialogInterface dialog,
							int which, boolean isChecked) {
						checkedItems[which]=isChecked;
					}
				});
				
				
				builder.setPositiveButton("确定", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						String result="";
						for(int i=0;i<checkedItems.length;i++){
							if(checkedItems[i]){
								result+=items[i]+"、";
							}
						}
						if(!"".equals(result)){	
							result=result.substring(0, result.length()-1);
							Toast.makeText(P3Activity.this, "你最喜欢玩的是[ "+result+" ]", Toast.LENGTH_LONG).show();
						}
					}
				});
				builder.create().show();
			}
		});
	}
}





















