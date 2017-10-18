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
	private boolean[] checkedItems;//��¼���б����״̬
	private String[] items;//���б���Ҫ��ʾ������
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p3);
		Button button1 = (Button) findViewById(R.id.button1); // ��ȡ����ʾ��ȡ����������ȷ����ť�ĶԻ��򡱰�ť
		// Ϊ����ʾ��ȡ����������ȷ����ť�ĶԻ��򡱰�ť��ӵ����¼�������
		button1.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				AlertDialog alert = new AlertDialog.Builder(P3Activity.this).create();
				alert.setIcon(R.drawable.advise);	//���öԻ����ͼ��
				alert.setTitle("ϵͳ��ʾ��");	//���öԻ���ı���
				alert.setMessage("��ȡ����������ȷ����ť�ĶԻ���");	//����Ҫ��ʾ������
				//���ȡ����ť
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"ȡ��", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this, "��������ȡ����ť",
								Toast.LENGTH_SHORT).show();

					}
				});
				//���ȷ����ť
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"ȷ��", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this, "��������ȷ����ť",
								Toast.LENGTH_SHORT).show();

					}
				});
				alert.setButton(DialogInterface.BUTTON_NEUTRAL,"����",new OnClickListener(){

					
					public void onClick(DialogInterface dialog, int which) {}
				});//���������ť
				alert.show(); // �����Ի�����ʾ
			}
		});

		// ���б�ĶԻ���
		Button button2 = (Button) findViewById(R.id.button2); // ��ȡ����ʾ���б�ĶԻ��򡱰�ť
		button2.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				final String[] items = new String[] { "�ܲ�", "��ë��", "ƹ����", "����",
				"���" };
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise1);	//���öԻ����ͼ��
				builder.setTitle("��ѡ����ϲ�����˶���Ŀ��");	//���öԻ���ı���
				//����б���
				builder.setItems(items, new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this,
								"��ѡ����" + items[which], Toast.LENGTH_SHORT).show();

					}
				});
				builder.create().show(); // �����Ի�����ʾ
			}
		});
		//�������ѡ�б��ȷ����ť���б�Ի���
		Button button3 = (Button) findViewById(R.id.button3); // ��ȡ����ʾ����ѡ�б���ĶԻ��򡱰�ť
		button3.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View v) {
				final String[] items = new String[] { "��׼", "����", "����", "����",
				"����" };
				// ��ʾ����ѡ�б���ĶԻ���
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise2);	//���öԻ����ͼ��
				builder.setTitle("��ѡ��Ҫʹ�õ��龰ģʽ��");	//���öԻ���ı���
				builder.setSingleChoiceItems(items, 0, new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(P3Activity.this,
								"��ѡ����" + items[which], Toast.LENGTH_SHORT).show();	//��ʾѡ����

					}
				});

				builder.setPositiveButton("ȷ��", null);	//���ȷ����ť
				builder.create().show(); // �����Ի�����ʾ
			}
		});
		//�������ѡ�б��ȷ����ť���б�Ի���
		Button button4 = (Button) findViewById(R.id.button4); // ��ȡ����ʾ����ѡ�б���ĶԻ��򡱰�ť
		button4.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				checkedItems= new boolean[] { false, true, false,true, false };	//��¼���б����״̬
				items = new String[] { "ֲ���ս��ʬ", "��ŭ��С��", "������", "����ũ��",
				"��������" };	//���б���Ҫ��ʾ������
				// ��ʾ����ѡ�б���ĶԻ���
				Builder builder = new AlertDialog.Builder(P3Activity.this);
				builder.setIcon(R.drawable.advise2);	//���öԻ����ͼ��
				builder.setTitle("��ѡ����ϲ������Ϸ��");	//���öԻ������
				builder.setMultiChoiceItems(items, checkedItems,
						new OnMultiChoiceClickListener() {

					
					public void onClick(DialogInterface dialog,
							int which, boolean isChecked) {
						checkedItems[which]=isChecked;	//�ı䱻�����б����״̬	
					}
				});
				//Ϊ�Ի�����ӡ�ȷ������ť
				builder.setPositiveButton("ȷ��", new OnClickListener() {

					
					public void onClick(DialogInterface dialog, int which) {
						String result="";	//���ڱ���ѡ����
						for(int i=0;i<checkedItems.length;i++){
							if(checkedItems[i]){	//��ѡ�ѡ��ʱ
								result+=items[i]+"��";	//��ѡ���������ӵ�result��
							}
						}
						//��result��Ϊ��ʱ��ͨ����Ϣ��ʾ����ʾѡ��Ľ��
						if(!"".equals(result)){	
							result=result.substring(0, result.length()-1);	//ȥ���������ӵġ�������
							Toast.makeText(P3Activity.this, "��ѡ����[ "+result+" ]", Toast.LENGTH_LONG).show();
						}
					}
				});
				builder.create().show(); // �����Ի�����ʾ
			}
		});
	}
}

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























