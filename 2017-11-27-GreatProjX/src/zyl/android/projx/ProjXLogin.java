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

public class ProjXLogin extends Activity {						// ��¼����
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

		btnregister.setOnClickListener(new OnClickListener() {
			Intent intent = null;
			public void onClick(View v) {
				intent = new Intent(ProjXLogin.this, ProjXRegister.class); 	//��ת��ע��ҳ��
				startActivity(intent);
			}
		});

		btnlogin.setOnClickListener(new OnClickListener() {
			public void onClick(View login) {
				Intent intent = new Intent(ProjXLogin.this, ProjXActivity.class);
				PwdDAO pwdDAO = new PwdDAO(ProjXLogin.this);
				int flag = 0;
				Toast.makeText(ProjXLogin.this, "��½�ɹ���",Toast.LENGTH_SHORT).show();
				startActivity(intent);
				// �ж��û����������Ƿ���ȷ
				
				for (int i = 0; i < pwdDAO.getScrollData().size(); i++) {
					if(pwdDAO.getScrollData().get(i).getUsername().equals(userlogin.getText().toString())
							&& pwdDAO.getScrollData().get(i).getPassword().equals(pwdlogin.getText().toString()))
					{
						flag = 1;
					}
				}
				
				if (flag == 1)
				{
					Toast.makeText(ProjXLogin.this, "��½�ɹ���",Toast.LENGTH_SHORT).show();
					startActivity(intent);
				}
				else
				{
					/*Toast.makeText(ProjXLogin.this, "��������ȷ���û���������",Toast.LENGTH_SHORT).show();*/
				}
			}
		});
		
		btnclose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();  //�˳�
			}


		});
	}
}


