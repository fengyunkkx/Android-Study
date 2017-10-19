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
				alert.setTitle("���Գɹ���");
				alert.setMessage("����һ����ȷ����ȡ����ť�ĶԻ���");

				alert.setButton(DialogInterface, BUTTON_NEGATIVE,"ȡ��",new OnClickListener(){
					public void onClick(DialogInterface dialog, log which){
						Toast.makeText(P3Activity.this,"�㵥����ȡ����ť",Toast.LENGTH_SHORT).show();

					}
				})
			}
		})

	}
 */

		
		// ȡ��ȷ���Ի���
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				AlertDialog alert = new AlertDialog.Builder(P3Activity.this).create();
				alert.setIcon(R.drawable.advise);
				alert.setTitle("Hey������һ��֪ͨ��");
				alert.setMessage("ȡ�������аɡ�ȷ��");
				
				
				//ȡ����ť
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this, "��������ȡ����ť",
								Toast.LENGTH_SHORT).show();

					}
				});
				
				
				//ȷ����ť
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this, "��������ȷ����ť",
								Toast.LENGTH_SHORT).show();

					}
				});
				
				
				//������ť
				alert.setButton(DialogInterface.BUTTON_NEUTRAL,"���а�",new OnClickListener(){

					
					public void onClick(DialogInterface dialog, int which) {}
				});
				
				alert.show();
			}
		});
		
		
		
		// ��ѡ�Ի���1
		Button button2 = (Button) findViewById(R.id.button2); 
		button2.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				final String[] items = new String[] { "����΢��", "QQ �ռ�", "֪��", "Twitter", "Instagram" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise1);
				builder.setTitle("����ϲ�����罻ƽ̨�ǣ�");
				builder.setItems(items, new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this,
								"����ϲ���õ���" + items[which], Toast.LENGTH_SHORT).show();

					}
				});
				builder.create().show();
			}
		});
		
		
		
		
		//��ѡ�Ի���2
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				final String[] items = new String[] { "QQ", "΢��", "Telegram", "Line", "����" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise2);
				builder.setTitle("����ϲ���õ��罻����ǣ�");
				builder.setSingleChoiceItems(items, 0, new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this,
								"����ϲ���õ���" + items[which], Toast.LENGTH_SHORT).show();

					}
				});

				builder.setPositiveButton("ȷ��", null);
				builder.create().show();
			}
		});
		
		
		
		// ��ѡ�Ի���
		
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				checkedItems= new boolean[] { false, true, false,true, false };
				items = new String[] { "Wizard 3", "Radiation 4", "Assassin's Creed", "MineCraft",
				"Hearth Stone" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise2);
				builder.setTitle("����ϲ�������Ϸ�ǣ�");	
				builder.setMultiChoiceItems(items, checkedItems,
						new OnMultiChoiceClickListener() {

					
					public void onClick(DialogInterface dialog,
							int which, boolean isChecked) {
						checkedItems[which]=isChecked;
					}
				});
				
				
				builder.setPositiveButton("ȷ��", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						String result="";
						for(int i=0;i<checkedItems.length;i++){
							if(checkedItems[i]){
								result+=items[i]+"��";
							}
						}
						if(!"".equals(result)){	
							result=result.substring(0, result.length()-1);
							Toast.makeText(P3Activity.this, "����ϲ�������[ "+result+" ]", Toast.LENGTH_LONG).show();
						}
					}
				});
				builder.create().show();
			}
		});
	}
}





















