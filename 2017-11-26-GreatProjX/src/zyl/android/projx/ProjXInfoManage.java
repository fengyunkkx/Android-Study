package zyl.android.projx;

import java.util.Calendar;

import zyl.android.dao.InaccountDAO;
import zyl.android.dao.OutaccountDAO;
import zyl.android.model.Tb_inaccount;
import zyl.android.model.Tb_outaccount;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProjXInfoManage extends Activity {
	protected static final int DATE_DIALOG_ID = 0;
	TextView tvtitle, textView;
	EditText txtMoney, txtTime, txtHA, txtMark;
	Spinner spType;
	Button btnEdit, btnDel;
	String[] strInfos;
	String strid, strType;

	private int mYear;
	private int mMonth;
	private int mDay;

	OutaccountDAO outaccountDAO = new OutaccountDAO(ProjXInfoManage.this);
	InaccountDAO inaccountDAO = new InaccountDAO(ProjXInfoManage.this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxinfomanage);
		tvtitle = (TextView) findViewById(R.id.inouttitle);
		textView = (TextView) findViewById(R.id.tvInOut);
		txtMoney = (EditText) findViewById(R.id.txtInOutMoney);
		txtTime = (EditText) findViewById(R.id.txtInOutTime);
		spType = (Spinner) findViewById(R.id.spInOutType);
		txtHA = (EditText) findViewById(R.id.txtInOut);
		txtMark = (EditText) findViewById(R.id.txtInOutMark);
		btnEdit = (Button) findViewById(R.id.btnInOutEdit);
		btnDel = (Button) findViewById(R.id.btnInOutDelete);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		strInfos = bundle.getStringArray(ProjXShowinfo.FLAG);
		strid = strInfos[0];
		strType = strInfos[1];
		if (strType.equals("btnoutinfo")) {
			tvtitle.setText("֧������");
			textView.setText("��  �㣺");
			Tb_outaccount tb_outaccount = outaccountDAO.find(Integer
					.parseInt(strid));
			txtMoney.setText(String.valueOf(tb_outaccount.getMoney()));
			txtTime.setText(tb_outaccount.getTime());
			spType.setPrompt(tb_outaccount.getType());
			txtHA.setText(tb_outaccount.getAddress());
			txtMark.setText(tb_outaccount.getMark());
		} else if (strType.equals("btnininfo")) {
			tvtitle.setText("�������");
			textView.setText("�����");
			Tb_inaccount tb_inaccount = inaccountDAO.find(Integer
					.parseInt(strid));
			txtMoney.setText(String.valueOf(tb_inaccount.getMoney()));
			txtTime.setText(tb_inaccount.getTime());
			spType.setPrompt(tb_inaccount.getType());
			txtHA.setText(tb_inaccount.getHandler());
			txtMark.setText(tb_inaccount.getMark());
		}

		txtTime.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				showDialog(DATE_DIALOG_ID);
			}
		});

		btnEdit.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				if (strType.equals("btnoutinfo")) {
					Tb_outaccount tb_outaccount = new Tb_outaccount();
					tb_outaccount.setid(Integer.parseInt(strid));
					tb_outaccount.setMoney(Double.parseDouble(txtMoney
							.getText().toString()));
					tb_outaccount.setTime(txtTime.getText().toString());
					tb_outaccount.setType(spType.getSelectedItem().toString());
					tb_outaccount.setAddress(txtHA.getText().toString());
					tb_outaccount.setMark(txtMark.getText().toString());
					outaccountDAO.update(tb_outaccount);
				} else if (strType.equals("btnininfo")) {
					Tb_inaccount tb_inaccount = new Tb_inaccount();
					tb_inaccount.setid(Integer.parseInt(strid));
					tb_inaccount.setMoney(Double.parseDouble(txtMoney.getText()
							.toString()));
					tb_inaccount.setTime(txtTime.getText().toString());
					tb_inaccount.setType(spType.getSelectedItem().toString());
					tb_inaccount.setHandler(txtHA.getText().toString());
					tb_inaccount.setMark(txtMark.getText().toString());
					inaccountDAO.update(tb_inaccount);
				}
				Toast.makeText(ProjXInfoManage.this, "�����ݡ��޸ĳɹ���",
						Toast.LENGTH_SHORT).show();
			}
		});

		btnDel.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if (strType.equals("btnoutinfo")) {
					outaccountDAO.detele(Integer.parseInt(strid));
				} else if (strType.equals("btnininfo")) {
					inaccountDAO.detele(Integer.parseInt(strid));
				}
				Toast.makeText(ProjXInfoManage.this, "�����ݡ�ɾ���ɹ���",
						Toast.LENGTH_SHORT).show();
			}
		});

		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		updateDisplay();
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};

	private void updateDisplay() {
		txtTime.setText(new StringBuilder().append(mYear).append("-")
				.append(mMonth + 1).append("-").append(mDay));
	}
}
