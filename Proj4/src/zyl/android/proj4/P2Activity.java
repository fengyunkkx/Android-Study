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

		// 获取推送管理器，用于发送推送
		final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		// 第一个推送
		
		Button button1 = (Button) findViewById(R.id.button1); // 获取“显示推送”按钮
		// 为“显示推送”按钮添加单击事件监听器
		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Notification notify = new Notification(); // 创建一个Notification对象
				notify.icon = R.drawable.advise;
				notify.tickerText = "这是第一个推送";
				notify.when = System.currentTimeMillis(); // 设置发送时间
				notify.setLatestEventInfo(P2Activity.this, "提醒一下！",
						"WOW！你发现了一条推送！", null);// 设置事件信息
				notificationManager.notify(NOTIFYID_1, notify); // 通过推送管理器发送推送
			}
		});
		
		// 第二个推送
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Notification notify1 = new Notification(R.drawable.advise2,
						"显示第二个推送", System.currentTimeMillis());
				notify1.flags |= Notification.FLAG_AUTO_CANCEL; // 打开应用程序后图标消失
				Intent intent = new Intent(P2Activity.this,
						ContentActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(
						P2Activity.this, 0, intent, 0);
				notify1.setLatestEventInfo(P2Activity.this, "再提醒一遍~", "点开这条看具体信息！",
						pendingIntent);// 设置事件信息
				notificationManager.notify(NOTIFYID_2, notify1); // 通过推送管理器发送推送
			}
		});
		
		
		
		
		
		Button button3 = (Button) findViewById(R.id.button3); // 获取“删除推送”按钮
		// 为“删除推送”按钮添加单击事件监听器
		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// notificationManager.cancel(NOTIFYID_1);
				// //清除ID号为常量NOTIFYID_1的推送
				notificationManager.cancelAll(); // 清除全部推送

			}
		});
	}
}