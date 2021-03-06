package zyl.android.projx;

import zyl.android.dao.PwdDAO;
import zyl.android.model.Tb_pwd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProjXSysset extends Activity {
	EditText now_txtPwd1, now_txtPwd2;
	Button btnSet, btnsetCancel, btnClose;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxsysset);

		now_txtPwd1 = (EditText) findViewById(R.id.now_txtPwd1);
		now_txtPwd2 = (EditText) findViewById(R.id.now_txtPwd2);
		btnSet = (Button) findViewById(R.id.btnSet);
		btnsetCancel = (Button) findViewById(R.id.btnsetCancel);
		btnClose = (Button) findViewById(R.id.btnClose);


		btnSet.setOnClickListener(new OnClickListener() {			//设置按钮
			public void onClick(View arg0) {
				PwdDAO pwdDAO = new PwdDAO(ProjXSysset.this);

				Tb_pwd tb_pwd = new Tb_pwd(now_txtPwd1.getText().toString(),now_txtPwd1.getText().toString());

				if (pwdDAO.getCount() == 0) {
					pwdDAO.add(tb_pwd);
				}
				else if(now_txtPwd1.getText().toString().equals("")||now_txtPwd2.getText().toString().equals("")){
					Toast.makeText(ProjXSysset.this, "输入的密码为空", Toast.LENGTH_SHORT).show();
				}
				else if(!now_txtPwd1.getText().toString().equals(now_txtPwd2.getText().toString())){
					Toast.makeText(ProjXSysset.this, "两次密码输入不一致,请重新输入", Toast.LENGTH_SHORT).show();
					now_txtPwd1.setText("");
					now_txtPwd2.setText("");
				}
				else {
					pwdDAO.update(tb_pwd);

					Toast.makeText(ProjXSysset.this, "密码设置成功！", Toast.LENGTH_SHORT)
					.show();
				}
			}

		});


		btnsetCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				now_txtPwd1.setText("");
				now_txtPwd1.setHint("请输入新密码");
				now_txtPwd2.setText("");
				now_txtPwd2.setHint("再次输入密码");
			}
		});

		btnClose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();  //退出
			}
		});

	}
}
