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

public class ProjXLogin extends Activity {
	EditText txtlogin,userlogin;
	Button btnlogin, btnclose;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);



		userlogin = (EditText) findViewById(R.id.userLogin);
		txtlogin = (EditText) findViewById(R.id.txtLogin);
		btnlogin = (Button) findViewById(R.id.btnLogin);
	
		
		
		btnlogin.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(ProjXLogin.this, ProjXActivity.class);


				
				if (userlogin.getText().toString().isEmpty()){
					Toast.makeText(ProjXLogin.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
				}
				else{
					if (userlogin.getText().toString().trim().equals("321")){

						if (txtlogin.getText().toString().isEmpty()){
							Toast.makeText(ProjXLogin.this, "请输入密码", Toast.LENGTH_SHORT).show();
						}
						else{
							if (txtlogin.getText().toString().trim().equals("123")){
								startActivity(intent);
								userlogin.setText("");
								txtlogin.setText("");
							}
							else{
								Toast.makeText(ProjXLogin.this, "请输入正确密码", Toast.LENGTH_SHORT).show();
							}
						}

					}
					else{
						Toast.makeText(ProjXLogin.this, "请输入正确用户名", Toast.LENGTH_SHORT).show();
					}
				}

			}
		});
		
		btnclose = (Button) findViewById(R.id.btnClose);
		btnclose.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				finish();
				
			}
		});
	}
}


