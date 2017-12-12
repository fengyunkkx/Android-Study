package zyl.android.projx;

import zyl.android.dao.DBOpenHelper;
import zyl.android.dao.PwdDAO;
import zyl.android.model.Tb_pwd;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteDatabase.CursorFactory; 
import android.database.sqlite.SQLiteOpenHelper; 
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
/*
				PwdDAO pwdDAO = new PwdDAO(ProjXRegister.this);
				Tb_pwd tb_pwd = new Tb_pwd(userregister.getText().toString(), pwdregister.getText().toString());

				// �ж��û����������Ƿ���ȷ

				pwdDAO.add(tb_pwd);
*/
				Toast.makeText(ProjXRegister.this, "ע��ɹ��������µ�¼",
						Toast.LENGTH_SHORT).show();
				intent = new Intent(ProjXRegister.this, ProjXLogin.class);
				startActivity(intent);
				
			}

		});

		btnclose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}

/*

	public void register(View view){
		//SQLiteDatabase db=dbHelper.getWritableDatabase();

		String newname =userregister.getText().toString();
		String password=pwdregister.getText().toString();
		if (CheckIsDataAlreadyInDBorNot(newname)) {
			Toast.makeText(this,"���û����ѱ�ע�ᣬע��ʧ��",Toast.LENGTH_SHORT).show();
		}
		else {

			if (register(newname, password)) {
				Toast.makeText(this, "�������ݱ�ɹ�", Toast.LENGTH_SHORT).show();
			}
		}
	}
	//�����ݿ��������
	public boolean register(String username,String password){
		SQLiteDatabase db= DBOpenHelper.getWritableDatabase();

		String sql = "insert into userData(name,password) value(?,?)";
		Object obj[]={username,password};
		db.execSQL(sql,obj);


		ContentValues values=new ContentValues();
		values.put("name",username);
		values.put("password",password);
		db.insert("userData",null,values);
		db.close();
		//db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
		return true;
	}
	//�����û����Ƿ��Ѵ���
	public boolean CheckIsDataAlreadyInDBorNot(String value){
		SQLiteDatabase db = DBOpenHelper.getWritableDatabase();
		String Query = "Select * from userData where name =?";
		Cursor cursor = db.rawQuery(Query,new String[] { value });
		if (cursor.getCount()>0){
			cursor.close();
			return true;
		}
		cursor.close();
		return false;
	}
	*/
}