package zyl.android.projx;

import zyl.android.dao.PwdDAO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProjXLogin extends Activity {						// 登录界面
	EditText userlogin, pwdlogin;
	Button btnlogin, btnclose, btnregister, btnauto;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		userlogin = (EditText) findViewById(R.id.userLogin); 	// 用户名输入框
		pwdlogin = (EditText) findViewById(R.id.pwdLogin);		// 密码输入框
		btnregister = (Button) findViewById(R.id.btnRegister); 	// 注册按钮
		btnlogin = (Button) findViewById(R.id.btnLogin); 		// 登陆按钮
		btnclose = (Button) findViewById(R.id.btnClose); 		// 取消按钮

		btnregister.setOnClickListener(new OnClickListener() {
			Intent intent = null;
			public void onClick(View v) {
				intent = new Intent(ProjXLogin.this, ProjXRegister.class); 	//跳转到注册页面
				startActivity(intent);
			}
		});


		/*
		btnlogin.setOnClickListener(new OnClickListener() {
			public void onClick(View login) {

				Intent intent = new Intent(ProjXLogin.this, ProjXActivity.class);
				PwdDAO pwdDAO = new PwdDAO(ProjXLogin.this);

				int flag = 0;
				Toast.makeText(ProjXLogin.this, "登陆成功！",Toast.LENGTH_SHORT).show();
				startActivity(intent);
				// 判断用户名和密码是否正确

				for (int i = 0; i < pwdDAO.getScrollData().size(); i++) {
					if(pwdDAO.getScrollData().get(i).getUsername().equals(userlogin.getText().toString())
							&& pwdDAO.getScrollData().get(i).getPassword().equals(pwdlogin.getText().toString()))
					{
						flag = 1;
					}
				}

				if (flag == 1)
				{
					Toast.makeText(ProjXLogin.this, "登陆成功！",Toast.LENGTH_SHORT).show();
					startActivity(intent);
				}
				else
				{
					Toast.makeText(ProjXLogin.this, "请输入正确的用户名和密码",Toast.LENGTH_SHORT).show();
				}



			}
		});


		 */



		btnlogin.setOnClickListener(new OnClickListener() {
			PwdDAO pwdDAO = new PwdDAO(ProjXLogin.this);
			public void onClick(View v) {	
				
				if(userlogin.getText().toString().equals("") || pwdlogin.getText().toString().equals("")){
					Toast.makeText(ProjXLogin.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
				}
				
				else if(pwdDAO.has_username(userlogin.getText().toString()) == false){
					Toast.makeText(ProjXLogin.this, "用户名不存在", Toast.LENGTH_SHORT).show();
				}
				
				else if (pwdDAO.find(userlogin.getText().toString()).getPassword().equals(pwdlogin.getText().toString())){
					Intent intent = new Intent(ProjXLogin.this, ProjXActivity.class);
					Toast.makeText(ProjXLogin.this, "登陆成功！", Toast.LENGTH_SHORT).show();
					startActivity(intent);
					pwdlogin.setText("");
				}
				
				else{
					Toast.makeText(ProjXLogin.this, "密码输入错误", Toast.LENGTH_SHORT).show();
				}
			}
		});






		btnclose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();  //退出
			}
		});
	}

}



