package zyl.android.proj4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class P2Activity extends Activity {
	final int NOTIFYID_1 = 123;	//��һ��֪ͨ��ID
	final int NOTIFYID_2 = 124;	//�ڶ���֪ͨ��ID

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//��ȡ֪ͨ�����������ڷ���֪ͨ
		final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Button button1 = (Button) findViewById(R.id.button1);	//��ȡ����ʾ֪ͨ����ť
		//Ϊ����ʾ֪ͨ����ť���ӵ����¼�������
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Notification notify = new Notification(); // ����һ��Notification����
				notify.icon = R.drawable.advise;
				notify.tickerText = "��ʾ��һ��֪ͨ";
				notify.when = System.currentTimeMillis(); // ���÷���ʱ��
				notify.defaults = Notification.DEFAULT_ALL;	//����Ĭ��������Ĭ���񶯺�Ĭ�������
				notify.setLatestEventInfo(P2Activity.this, "����", "ÿ�����һ���",
						null);//�����¼���Ϣ
				notificationManager.notify(NOTIFYID_1, notify); // ͨ��֪ͨ����������֪ͨ
				// ���ӵڶ���֪ͨ
				Notification notify1 = new Notification(R.drawable.advise2,
						"��ʾ�ڶ���֪ͨ", System.currentTimeMillis());
				notify1.flags|=Notification.FLAG_AUTO_CANCEL;	//��Ӧ�ó����ͼ����ʧ
				Intent intent=new Intent(P2Activity.this,ContentActivity.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(P2Activity.this, 0, intent, 0);
				notify1.setLatestEventInfo(P2Activity.this, "֪ͨ",
						"�鿴��ϸ����", pendingIntent);//�����¼���Ϣ
				notificationManager.notify(NOTIFYID_2, notify1); // ͨ��֪ͨ����������֪ͨ
			}
		});
		Button button2 = (Button) findViewById(R.id.button2);	//��ȡ��ɾ��֪ͨ����ť
		//Ϊ��ɾ��֪ͨ����ť���ӵ����¼�������
		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
//				notificationManager.cancel(NOTIFYID_1);	//���ID��Ϊ����NOTIFYID_1��֪ͨ
				notificationManager.cancelAll();	//���ȫ��֪ͨ

			}
		});
	}
}