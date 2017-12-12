package zyl.android.projx;

import zyl.android.dao.FlagDAO;
import zyl.android.model.Tb_flag;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProjXFlagManage extends Activity {
	EditText txtFlag;
	Button btnEdit, btnDel;
	String strid;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxflagmanage);
		txtFlag = (EditText) findViewById(R.id.txtFlagManage);
		btnEdit = (Button) findViewById(R.id.btnFlagManageEdit);
		btnDel = (Button) findViewById(R.id.btnFlagManageDelete);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		strid = bundle.getString(ProjXShowinfo.FLAG);
		final FlagDAO flagDAO = new FlagDAO(ProjXFlagManage.this);
		txtFlag.setText(flagDAO.find(Integer.parseInt(strid)).getFlag());
		btnEdit.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Tb_flag tb_flag = new Tb_flag();
				tb_flag.setid(Integer.parseInt(strid));
				tb_flag.setFlag(txtFlag.getText().toString());
				flagDAO.update(tb_flag);
				Toast.makeText(ProjXFlagManage.this, "±ãÇ©ÒÑÐÞ¸Ä£¡",	Toast.LENGTH_SHORT).show();
			}
		});

		btnDel.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				flagDAO.detele(Integer.parseInt(strid));
				Toast.makeText(ProjXFlagManage.this, "±ãÇ©ÒÑÉ¾³ý£¡",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
