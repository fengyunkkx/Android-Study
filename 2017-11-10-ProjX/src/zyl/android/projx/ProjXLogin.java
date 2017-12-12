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
	EditText userlogin, pwdlogin;
	Button btnlogin, btnclose, btnregister, btnauto;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		userlogin = (EditText) findViewById(R.id.userLogin); 	// �û��������
		pwdlogin = (EditText) findViewById(R.id.pwdLogin);		// ���������
		btnregister = (Button) findViewById(R.id.btnRegister); 	// ע�ᰴť
		btnlogin = (Button) findViewById(R.id.btnLogin); 		// ��½��ť
		btnclose = (Button) findViewById(R.id.btnClose); 		// ȡ����ť
		//btnauto = (Button) findViewById(R.id.btnAuto); 			// �Զ���䰴ť

		btnregister.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

			}
		});


		btnlogin.setOnClickListener(new OnClickListener() {
			public void onClick(View login) {

				Intent intent = new Intent(ProjXLogin.this, ProjXActivity.class);
				PwdDAO pwdDAO = new PwdDAO(ProjXLogin.this);
				String flag = null;
				// �ж��û����������Ƿ���ȷ

				for (int i = 0; i < pwdDAO.getScrollData().size(); i++) {
					if(pwdDAO.getScrollData().get(i).getUsername().equals(userlogin.getText().toString())
							&& pwdDAO.getScrollData().get(i).getPassword().equals(pwdlogin.getText().toString()))
					{
						startActivity(intent);
						flag = "success";
					}
				}
				if (flag != "success")
				{
					Toast.makeText(ProjXLogin.this, "��������ȷ���û���������",
							Toast.LENGTH_SHORT).show();
				}



				/*


					if ((pwdDAO.getUsername() == 0 | pwdDAO.find().getUsername().isEmpty())
							&& userlogin.getText().toString().isEmpty()) {
						if ((pwdDAO.getPassword() == 0 | pwdDAO.find().getPassword().isEmpty())
								&& pwdlogin.getText().toString().isEmpty()) {
							startActivity(intent);
						}
						else {
							if(pwdDAO.find().getUsername().equals(pwdlogin.getText().toString())){
								if(pwdDAO.find().getPassword().equals(pwdlogin.getText().toString())){
									startActivity(intent);
								} else {
									Toast.makeText(ProjXLogin.this, "����������",
											Toast.LENGTH_SHORT).show();
								}
							}
							else {
								Toast.makeText(ProjXLogin.this, "�������û���",
										Toast.LENGTH_SHORT).show();
							}

						}
					}
					userlogin.setText("");
					pwdlogin.setText("");
				}




				Intent intent = new Intent(ProjXLogin.this, ProjXActivity.class);
				if (userlogin.getText().toString().isEmpty()) {
					Toast.makeText(ProjXLogin.this, "�������û���������",
							Toast.LENGTH_SHORT).show();
				} else {
					if (userlogin.getText().toString().trim().equals("321")) {

						if (txtlogin.getText().toString().isEmpty()) {
							Toast.makeText(ProjXLogin.this, "����������",
									Toast.LENGTH_SHORT).show();
						} else {
							if (txtlogin.getText().toString().trim()
									.equals("123")) {
								startActivity(intent);
								userlogin.setText("");
								txtlogin.setText("");
							} else {
								Toast.makeText(ProjXLogin.this, "��������ȷ����",
										Toast.LENGTH_SHORT).show();
							}
						}

					} else {
						Toast.makeText(ProjXLogin.this, "��������ȷ�û���",
								Toast.LENGTH_SHORT).show();
					}
				}

				btnauto.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							PwdDAO pwdDAO = new PwdDAO(ProjXLogin.this);
							userlogin.setText(pwdDAO.find().getUsername().toString());
							pwdlogin.setText(pwdDAO.find().getPassword().toString());
						}
					});

				 */



			}
		});
		
		btnclose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();  //�˳�
			}


		});
	}
}


