package zyl.android.projx;

import zyl.android.dao.FlagDAO;
import zyl.android.model.Tb_flag;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProjXAddFlag extends Activity{
	private EditText txt_flag;
	private Button btn_save;
	private Button btn_exit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.projxaccountflag);


		txt_flag = (EditText)findViewById(R.id.txtFlag);
		btn_save = (Button)findViewById(R.id.btnflagSave);
		btn_exit = (Button)findViewById(R.id.btnflagCancel);

		btn_save.setOnClickListener(new OnClickListener() {		
			public void onClick(View v) {
				String flag_str = txt_flag.getText().toString();
				if (!flag_str.trim().isEmpty()) {
					FlagDAO flagDAO = new FlagDAO(ProjXAddFlag.this);
					Tb_flag tb_flag = new Tb_flag(flagDAO.getMaxId() + 1,flag_str);
					flagDAO.add(tb_flag);
					Toast.makeText(ProjXAddFlag.this, "������ӳɹ���",Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(ProjXAddFlag.this, "�㻹û�������ǩ��Ϣ",Toast.LENGTH_SHORT).show();
				}
			}
		});

		btn_exit.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
				finish();
			}
		});
	}
}


