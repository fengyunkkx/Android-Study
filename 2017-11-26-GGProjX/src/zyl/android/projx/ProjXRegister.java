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

public class ProjXRegister extends Activity { // ��¼����
	EditText userregister, pwdregister;
	Button btnclose, btnregister;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		userregister = (EditText) findViewById(R.id.userRegister); 		// �û��������
		pwdregister = (EditText) findViewById(R.id.pwdRegister);		// ���������
		btnregister = (Button) findViewById(R.id.btnRegister); 			// ע�ᰴť
		btnclose = (Button) findViewById(R.id.btnClose); 				// ȡ����ť

		btnregister.setOnClickListener(new OnClickListener() {
			public void onClick(View login) {

				Intent intent = new Intent(ProjXRegister.this, ProjXActivity.class);
				PwdDAO pwdDAO = new PwdDAO(ProjXRegister.this);
				Tb_pwd tb_pwd = new Tb_pwd(userregister.getText().toString(), pwdregister.getText().toString());

				// �ж��û����������Ƿ���ȷ
				
				pwdDAO.add(tb_pwd);

				Toast.makeText(ProjXRegister.this, "ע��ɹ��������µ�¼",
						Toast.LENGTH_SHORT).show();
				intent = new Intent(ProjXRegister.this, ProjXLogin.class);
				startActivity(intent);
			}

		});
	}
}