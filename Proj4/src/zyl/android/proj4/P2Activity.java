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
	final int NOTIFYID_1 = 001; // 第一个推送的ID
	final int NOTIFYID_2 = 002; // 第二个推送的ID

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.p2);


		final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);		// 获取推送管理器，用于发送推送

		// 第一个推送

		Button button1 = (Button) findViewById(R.id.button1); // 获取显示推送按钮
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Notification notify = new Notification();
				notify.icon = R.drawable.advise;
				notify.tickerText = "这是第一个推送";
				notify.when = System.currentTimeMillis();
				notify.setLatestEventInfo(P2Activity.this, "提醒一下！",
						"WOW！你发现了一条推送！", null);
				notificationManager.notify(NOTIFYID_1, notify);
			}
		});

		// 第二个推送

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Notification notify1 = new Notification(R.drawable.advise2,
						"显示第二个推送", System.currentTimeMillis());
				notify1.flags |= Notification.FLAG_AUTO_CANCEL;
				Intent intent = new Intent(P2Activity.this,
						ContentActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(
						P2Activity.this, 0, intent, 0);
				notify1.setLatestEventInfo(P2Activity.this, "再提醒一遍~", "点开这条看具体信息！",
						pendingIntent);
				notificationManager.notify(NOTIFYID_2, notify1);
			}
		});



		// 删除推送

		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				notificationManager.cancel(NOTIFYID_1);  	//清除一号推送
			}
		});
		
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				notificationManager.cancel(NOTIFYID_2);  	//清除二号推送
			}
		});
		
		Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				notificationManager.cancelAll(); 			// 清除全部推送

			}
		});
	}
}