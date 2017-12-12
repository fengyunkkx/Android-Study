package zyl.android.projx;

import zyl.android.dao.PwdDAO;
import zyl.android.model.Tb_pwd;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProjXRegister extends Activity { // 登录界面
	EditText userregister, pwdregister;
	Button btnclose, btnregister;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		userregister = (EditText) findViewById(R.id.userRegister); 		// 用户名输入框
		pwdregister = (EditText) findViewById(R.id.pwdRegister);		// 密码输入框
		btnregister = (Button) findViewById(R.id.btnRegister); 			// 注册按钮
		btnclose = (Button) findViewById(R.id.btnClose); 				// 取消按钮

		btnregister.setOnClickListener(new OnClickListener() {
			public void onClick(View login) {

				Intent intent = new Intent(ProjXRegister.this, ProjXActivity.class);
				PwdDAO pwdDAO = new PwdDAO(ProjXRegister.this);
				Tb_pwd tb_pwd = new Tb_pwd(userregister.getText().toString(), pwdregister.getText().toString());

				// 判断用户名和密码是否正确
				
				pwdDAO.add(tb_pwd);

				Toast.makeText(ProjXRegister.this, "注册成功，请重新登录",
						Toast.LENGTH_SHORT).show();
				intent = new Intent(ProjXRegister.this, ProjXLogin.class);
				startActivity(intent);
			}

		});
	}
}