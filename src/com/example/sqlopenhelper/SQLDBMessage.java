package com.example.sqlopenhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLDBMessage {

	private MydbOpenHelper mdbOpenHelper;

	public SQLDBMessage(Context context) {
		mdbOpenHelper = new MydbOpenHelper(context);
	}

	public void insertSQL() {

		// 获取一个SQLiteDatabase一个操作可操作数据库的对象
		SQLiteDatabase db = mdbOpenHelper.getWritableDatabase();
		// 调用execSQL()方法实现插入操作
		db.execSQL("insert into stu_info values(null,'xiaoming',22)");
		db.execSQL("insert into stu_info values(null,'xiaoli',21)");
		db.execSQL("insert into stu_info values(null,'小王',21)");
		db.execSQL("insert into stu_info values(null,'域名',20)");
		db.execSQL("insert into stu_info values(null,'123',23)");
		// 数据库操作对象关闭数据库
		db.close();

	}

	public void querySQL() {

		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();
		// 获取一个光标对象
		Cursor cursor = db.rawQuery("select * from stu_info", null);

		// 使用ArrayList保存多个HashMap数据对象
		List<HashMap<String, Object>> stu_list = new ArrayList<HashMap<String, Object>>();
		// 使用HashMap保存一条语句
		HashMap<String, Object> map = null;
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			map = new HashMap<String, Object>();
			// 通过“数据库”字段获取对应的数据
			int _id = cursor.getInt(cursor.getColumnIndex("_id"));
			map.put("_id", _id);
			// 通过“数据库”字段获取对应的数据
			String stu_Name = cursor.getString(cursor
					.getColumnIndex("stu_name"));
			// 通过“数据库”字段获取对应的数据
			map.put("stu_Name", stu_Name);
			int stu_age = cursor.getInt(cursor.getColumnIndex("stu_age"));
			map.put("stu_age", stu_age);
			stu_list.add(map);
			cursor.moveToNext();
			Log.i("Yongke.pan", "_id=" + _id + ",stu_Name=" + stu_Name
					+ ",stu_age=" + stu_age);
		}

		cursor.close();
		db.close();

	}

	public void updateSQL() {
		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();
		db.execSQL("update stu_info set stu_name='zidong',stu_age=30 where _id=4 or _id=9");
		db.close();
	}

	public void deleteSQL() {

		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();
		db.execSQL("delete from stu_info where _id=4 or _id=9");
		db.close();

	}

	public void insert2() {

		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();
		ContentValues values = new ContentValues();

		// values.put("_id", 0);
		values.put("stu_name", "12345");
		values.put("stu_age", 102);
		db.insert("stu_info", null, values);

		values = new ContentValues();

		// values.put("_id", 0);
		values.put("stu_name", "23456");
		values.put("stu_age", 234);
		db.insert("stu_info", null, values);
		db.close();

	}

	public void query2() {
		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();

		Cursor cursor = db
				.query("stu_info", null, null, null, null, null, null);

		// 使用ArrayList保存多个HashMap数据对象
		List<HashMap<String, Object>> stu_list = new ArrayList<HashMap<String, Object>>();
		// 使用HashMap保存一条语句
		HashMap<String, Object> map = null;
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			map = new HashMap<String, Object>();
			// 通过“数据库”字段获取对应的数据
			int _id = cursor.getInt(cursor.getColumnIndex("_id"));
			map.put("_id", _id);
			// 通过“数据库”字段获取对应的数据
			String stu_Name = cursor.getString(cursor
					.getColumnIndex("stu_name"));
			// 通过“数据库”字段获取对应的数据
			map.put("stu_Name", stu_Name);
			int stu_age = cursor.getInt(cursor.getColumnIndex("stu_age"));
			map.put("stu_age", stu_age);
			stu_list.add(map);
			cursor.moveToNext();
			Log.i("Yongke.pan", "_id=" + _id + ",stu_Name=" + stu_Name
					+ ",stu_age=" + stu_age);
		}

		cursor.close();
		db.close();

	}

	public void update2() {
		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put("stu_name", "45678");
		values.put("stu_age", 1000);
		db.update("stu_info", values, "_id<3", null);
		db.close();

	}

	public void delete2() {
		SQLiteDatabase db = mdbOpenHelper.getReadableDatabase();
		db.delete("stu_info", "_id>10", null);
		db.close();

	}

}
