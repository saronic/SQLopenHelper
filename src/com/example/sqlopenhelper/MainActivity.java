package com.example.sqlopenhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn_insert;
	private Button btn_query;
	private Button btn_update;
	private Button btn_delete;

	private Button btn_insert_api;
	private Button btn_query_api;
	private Button btn_update_api;
	private Button btn_delete_api;
	private SQLDBMessage mSqldbMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		mSqldbMessage = new SQLDBMessage(this);

		setContentView(R.layout.db_main);
		btn_insert = (Button) findViewById(R.id.btn_insert);
		btn_insert.setOnClickListener(this);
		btn_query = (Button) findViewById(R.id.btn_query);
		btn_query.setOnClickListener(this);
		btn_update = (Button) findViewById(R.id.btn_update);
		btn_update.setOnClickListener(this);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		btn_delete.setOnClickListener(this);

		btn_insert_api = (Button) findViewById(R.id.btn_insert_api);
		btn_insert_api.setOnClickListener(this);
		btn_query_api = (Button) findViewById(R.id.btn_query_api);
		btn_query_api.setOnClickListener(this);
		btn_update_api = (Button) findViewById(R.id.btn_update_api);
		btn_update_api.setOnClickListener(this);
		btn_delete_api = (Button) findViewById(R.id.btn_delete_api);
		btn_delete_api.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_insert:
			mSqldbMessage.insertSQL();
			Toast.makeText(getApplicationContext(), "插入数据成功", 1000).show();
			break;
		case R.id.btn_query:
			mSqldbMessage.querySQL();

			Toast.makeText(getApplicationContext(), "查询数据成功", 1000).show();
			break;
		case R.id.btn_update:
			mSqldbMessage.updateSQL();
			Toast.makeText(getApplicationContext(), "更新数据成功", 1000).show();
			break;
		case R.id.btn_delete:
			mSqldbMessage.deleteSQL();
			Toast.makeText(getApplicationContext(), "删除数据成功", 1000).show();
			break;

		case R.id.btn_insert_api:
			mSqldbMessage.insert2();
			Toast.makeText(getApplicationContext(), "Insert插入数据成功", 1000)
					.show();
			break;
		case R.id.btn_query_api:
			mSqldbMessage.query2();

			Toast.makeText(getApplicationContext(), "Query查询数据成功", 1000).show();
			break;
		case R.id.btn_update_api:
			mSqldbMessage.update2();
			Toast.makeText(getApplicationContext(), "Update更新数据成功", 1000)
					.show();
			break;
		case R.id.btn_delete_api:
			mSqldbMessage.delete2();
			Toast.makeText(getApplicationContext(), "Delete删除数据成功", 1000)
					.show();
			break;

		}

	}

}
