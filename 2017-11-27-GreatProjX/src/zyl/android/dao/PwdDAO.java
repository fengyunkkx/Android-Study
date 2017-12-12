package zyl.android.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
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
	 * 添加密码信息
	 * 
	 * @param tb_pwd
	 */

	public void add(Tb_pwd tb_pwd) {
		db = helper.getWritableDatabase();
		db.execSQL("insert into tb_pwd (username,password) values (?)",
				new Object[] { tb_pwd.getPassword(),tb_pwd.getUsername() });
	}


	/**
	 * 设置密码信息
	 * 
	 * @param tb_pwd
	 */
	public void update(Tb_pwd tb_pwd) {
		db = helper.getWritableDatabase();
		db.execSQL("update tb_pwd set password = ?,username = ?",
				new Object[] { tb_pwd.getPassword(),tb_pwd.getUsername() });
	}

	/**
	 * 查找密码信息
	 * 
	 * @return
	 */
	public Tb_pwd find() {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select password from tb_pwd", null);
		if (cursor.moveToNext())
		{
			return new Tb_pwd(
					cursor.getString(cursor
					.getColumnIndex("username")),
					cursor.getString(cursor
					.getColumnIndex("password")));
		}
		return null;
	}
	
	public List <Tb_pwd> getScrollData()
	{
		List<Tb_pwd> tb_pwd = new ArrayList<Tb_pwd>();
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from tb_pwd",null);
		while (cursor.moveToNext())
		{
			tb_pwd.add(new Tb_pwd(
					cursor.getString(cursor.getColumnIndex("username")),
					cursor.getString(cursor.getColumnIndex("password")))
			);
		}
		
		return tb_pwd;
		
		
	}
	
	public long getCount() {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select count(username) from tb_pwd", null);
		if (cursor.moveToNext())
		{
			return cursor.getLong(0);
		}
		return 0;
	}
	

	


}




