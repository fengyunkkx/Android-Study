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

public class ProjXRegister extends Activity { // 登录界面
	EditText userregister, pwdregister;
	Button btnclose, btnregister;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		userregister = (EditText) findViewById(R.id.userRegister); 		// 用户名输入框
		pwdregister = (EditText) findViewById(R.id.pwdRegister);		// 密码输入框
		btnregister = (Button) findViewById(R.id.btnRegister); 			// 注册按钮
		btnclose = (Button) findViewById(R.id.btnClose); 				// 取消按钮

		btnregister.setOnClickListener(new OnClickListener() {
			public void onClick(View login) {

				Intent intent = new Intent(ProjXRegister.this, ProjXActivity.class);
/*
				PwdDAO pwdDAO = new PwdDAO(ProjXRegister.this);
				Tb_pwd tb_pwd = new Tb_pwd(userregister.getText().toString(), pwdregister.getText().toString());

				// 判断用户名和密码是否正确

				pwdDAO.add(tb_pwd);
*/
				Toast.makeText(ProjXRegister.this, "注册成功，请重新登录",
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
			Toast.makeText(this,"该用户名已被注册，注册失败",Toast.LENGTH_SHORT).show();
		}
		else {

			if (register(newname, password)) {
				Toast.makeText(this, "插入数据表成功", Toast.LENGTH_SHORT).show();
			}
		}
	}
	//向数据库插入数据
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
	//检验用户名是否已存在
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