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
	EditText txtpwd;
	Button btnSet, btnsetCancel;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxsysset);

		txtpwd = (EditText) findViewById(R.id.txtPwd);
		btnSet = (Button) findViewById(R.id.btnSet);
		btnsetCancel = (Button) findViewById(R.id.btnsetCancel);

		btnSet.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				PwdDAO pwdDAO = new PwdDAO(ProjXSysset.this);
				Tb_pwd tb_pwd = new Tb_pwd(txtpwd.getText().toString(),txtpwd.getText().toString());
				if (pwdDAO.getCount() == 0) {
					pwdDAO.add(tb_pwd);
				} else {
					pwdDAO.update(tb_pwd);
				}
				Toast.makeText(ProjXSysset.this, "√‹¬Î…Ë÷√≥…π¶£°", Toast.LENGTH_SHORT)
						.show();
			}
		});

		btnsetCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				txtpwd.setText("");
				txtpwd.setHint("«Î ‰»Î√‹¬Î");
			}
		});
	}
}
