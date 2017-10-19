package zyl.android.proj4;

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
	final int NOTIFYID_1 = 001; // ��һ�����͵�ID
	final int NOTIFYID_2 = 002; // �ڶ������͵�ID

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.p2);


		final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);		// ��ȡ���͹����������ڷ�������

		// ��һ������

		Button button1 = (Button) findViewById(R.id.button1); // ��ȡ��ʾ���Ͱ�ť
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Notification notify = new Notification();
				notify.icon = R.drawable.advise;
				notify.tickerText = "���ǵ�һ������";
				notify.when = System.currentTimeMillis();
				notify.setLatestEventInfo(P2Activity.this, "����һ�£�",
						"WOW���㷢����һ�����ͣ�", null);
				notificationManager.notify(NOTIFYID_1, notify);
			}
		});

		// �ڶ�������

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Notification notify1 = new Notification(R.drawable.advise2,
						"��ʾ�ڶ�������", System.currentTimeMillis());
				notify1.flags |= Notification.FLAG_AUTO_CANCEL;
				Intent intent = new Intent(P2Activity.this,
						ContentActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(
						P2Activity.this, 0, intent, 0);
				notify1.setLatestEventInfo(P2Activity.this, "������һ��~", "�㿪������������Ϣ��",
						pendingIntent);
				notificationManager.notify(NOTIFYID_2, notify1);
			}
		});



		// ɾ������

		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				notificationManager.cancel(NOTIFYID_1);  	//���һ������
			}
		});
		
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				notificationManager.cancel(NOTIFYID_2);  	//�����������
			}
		});
		
		Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				notificationManager.cancelAll(); 			// ���ȫ������

			}
		});
	}
}