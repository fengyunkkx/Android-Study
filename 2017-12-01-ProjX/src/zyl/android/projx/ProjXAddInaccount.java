package zyl.android.projx;

import java.util.Calendar;

import zyl.android.dao.InaccountDAO;
import zyl.android.model.Tb_inaccount;
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

public class ProjXAddInaccount extends Activity {
	protected static final int DATE_DIALOG_ID = 0;
	EditText txtInMoney, txtInTime, txtInHandler, txtInMark;
	Spinner spInType;
	Button btnInSaveButton;
	Button btnInCancelButton;

	private int mYear;
	private int mMonth;
	private int mDay;

	protected void onCreate(Bundle savedInstanceState) {			// ��������ҳ��
		super.onCreate(savedInstanceState);
		setContentView(R.layout.projxaddinaccount);
		txtInMoney = (EditText) findViewById(R.id.txtInMoney);
		txtInTime = (EditText) findViewById(R.id.txtInTime);
		txtInHandler = (EditText) findViewById(R.id.txtInHandler);
		txtInMark = (EditText) findViewById(R.id.txtInMark);
		spInType = (Spinner) findViewById(R.id.spInType);
		btnInSaveButton = (Button) findViewById(R.id.btnInSave);
		btnInCancelButton = (Button) findViewById(R.id.btnInCancel);

		txtInTime.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				showDialog(DATE_DIALOG_ID);
			}
		});

		btnInSaveButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				String strInMoney = txtInMoney.getText().toString();
				if (!strInMoney.isEmpty()) {
					InaccountDAO inaccountDAO = new InaccountDAO(
							ProjXAddInaccount.this);
					Tb_inaccount tb_inaccount = new Tb_inaccount(
							inaccountDAO.getMaxId() + 1, Double
							.parseDouble(strInMoney), txtInTime
							.getText().toString(), spInType
							.getSelectedItem().toString(),
							txtInHandler.getText().toString(),
							txtInMark.getText().toString());
					inaccountDAO.add(tb_inaccount);
					Toast.makeText(ProjXAddInaccount.this, "����������ӳɹ���",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(ProjXAddInaccount.this, "���������������",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		btnInCancelButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				txtInMoney.setText("");					// ����ı���
				txtInMoney.setHint("0.00");				// ����ı���������ʾ
				txtInTime.setText("");					// ʱ���ı���
				txtInTime.setHint("2017-01-01");		// ʱ���ı���������ʾ
				txtInHandler.setText("");				// ����ı���
				txtInMark.setText("");					// ��ע�ı���
				spInType.setSelection(0);				// ������������б�Ĭ��ѡ���һ��
			}
		});

		final Calendar c = Calendar.getInstance();				// �Զ���ȡ��ǰϵͳ����
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		updateDisplay();
	}

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
			updateDisplay();									// ��ʾ���õ�����
		}
	};

	private void updateDisplay() {								// ��ʾ���õ�ʱ��
		txtInTime.setText(new StringBuilder().append(mYear).append("-")
				.append(mMonth + 1).append("-").append(mDay));
	}
}
