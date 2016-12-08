package com.example.day11_menu_demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class MainActivity3 extends Activity {

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.tv);

		// ע�������Ĳ˵�
		registerForContextMenu(tv);
	}

	
	/*
	 * ʹ�������Ĳ˵���
	 * 
	 * ��дonCreateContextMenu����
	 * 
	 * ע�ᵽ��Ӧ�Ŀؼ���
	 * 
	 * ����һ��ContextMenu
	 * 
	 * ��������View ע�������Ĳ˵���View
	 * 
	 * ��������ContextMenuInfo �˵�����չ��Ϣ
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		// ����һ��menu��Դ��id
		// ������������˵�
		getMenuInflater().inflate(R.menu.main, menu);
	}

	
	/*
	 * contextMenu�ĵ���¼�
	 * 
	 * ��дonContextItemSelected
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		

		switch (item.getItemId()) {

		case R.id.add: {
			tv.setText("hahhahahahahhahah");
		}
			break;
		case R.id.red: {
			tv.setTextColor(Color.RED);
		}
			break;

		case R.id.green: {
			tv.setTextColor(Color.GREEN);
		}
			break;

		case R.id.bule: {
			tv.setTextColor(Color.BLUE);
		}
			break;

		default:
			break;
		}

		return super.onContextItemSelected(item);
	}
}
