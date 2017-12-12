package zyl.android.projx;

import java.util.Calendar;

import zyl.android.dao.OutaccountDAO;
import zyl.android.model.Tb_outaccount;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ProjXAddOutaccount extends Activity {
	protected static final int DATE_DIALOG_ID = 0;
	EditText txtMoney, txtTime, txtAddress, txtMark;
	Spinner spType;
	Button btnSaveButton;
	Button btnCancelButton;
	private int mYear;
	private int mMonth;
	private int mDay;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxaddoutaccount);
		txtMoney = (EditText) findViewById(R.id.txtMoney);
		txtTime = (EditText) findViewById(R.id.txtTime);
		txtAddress = (EditText) findViewById(R.id.txtAddress);
		txtMark = (EditText) findViewById(R.id.txtMark);
		spType = (Spinner) findViewById(R.id.spType);
		btnSaveButton = (Button) findViewById(R.id.btnSave);
		btnCancelButton = (Button) findViewById(R.id.btnCancel);

		txtTime.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				showDialog(DATE_DIALOG_ID);
			}
		});

		btnSaveButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				String strMoney = txtMoney.getText().toString();
				if (!strMoney.isEmpty()) {
					OutaccountDAO outaccountDAO = new OutaccountDAO(
							ProjXAddOutaccount.this);
					Tb_outaccount tb_outaccount = new Tb_outaccount(
							outaccountDAO.getMaxId() + 1, Double
							.parseDouble(strMoney), txtTime
							.getText().toString(), spType
							.getSelectedItem().toString(),
							txtAddress.getText().toString(), txtMark
							.getText().toString());
					outaccountDAO.add(tb_outaccount);
					Toast.makeText(ProjXAddOutaccount.this, "����֧����ӳɹ���",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(ProjXAddOutaccount.this, "����������֧����",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		btnCancelButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				txtMoney.setText("");					// ����ı���
				txtMoney.setHint("0.00");				// ����ı���������ʾ
				txtTime.setText("");					// ʱ���ı���
				txtTime.setHint("2017-11-11");			// ʱ���ı���������ʾ
				txtAddress.setText("");					// ����ı���
				txtMark.setText("");					// ��ע�ı���
				spType.setSelection(0);					// ������������б�Ĭ��ѡ���һ��
			}
		});

		final Calendar c = Calendar.getInstance();				// ��ȡ��ǰϵͳ����
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		updateDisplay();										// ��ʾ��ǰϵͳʱ��
	}

	@Override
	protected Dialog onCreateDialog(int id)
	{
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

	private void updateDisplay() {								// ��ʾ���õ�ʱ��
		txtTime.setText(new StringBuilder().append(mYear).append("-")
				.append(mMonth + 1).append("-").append(mDay));
	}
}
