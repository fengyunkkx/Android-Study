package zyl.android.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import zyl.android.model.*;

public class PwdDAO {
	private DBOpenHelper helper;
	private SQLiteDatabase db;

	public PwdDAO(Context context)
	{
		helper = new DBOpenHelper(context);
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param tb_pwd
	 */

	public void add(Tb_pwd tb_pwd) {
		db = helper.getWritableDatabase();
		try{
			db.execSQL("insert into tb_pwd (username,password) values (?,?)",
					new Object[] { tb_pwd.getUsername(), tb_pwd.getPassword() });
		}catch(SQLException e){
			
		}
	}
	

	/**
	 * ����������Ϣ
	 * 
	 * @param tb_pwd
	 */
	public void update(Tb_pwd tb_pwd) {
		db = helper.getWritableDatabase();
		db.execSQL("update tb_pwd set password = ?",
				new Object[] { tb_pwd.getPassword() });
	}

	/**
	 * ����������Ϣ
	 * 
	 * @return
	 */
	public Tb_pwd find(String username) {
		db = helper.getWritableDatabase();
		try{
			Cursor cursor = db.rawQuery("select password from tb_pwd where username=\"" + username+"\"", null);
			if (cursor.moveToNext()){
				return new Tb_pwd(username, cursor.getString(cursor
						.getColumnIndex("password")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean has_username(String username){
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select username from tb_pwd", null);
		while(cursor.moveToNext()){
			if(cursor.getString(cursor.getColumnIndex("username")).equals(username)){
				return true;
			}
		}
		return false;
	}

	public long getCount() {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select count(username) from tb_pwd", null);
		if (cursor.moveToNext()){
			return cursor.getLong(0);
		}
		return 0;
	}
}
	

	







