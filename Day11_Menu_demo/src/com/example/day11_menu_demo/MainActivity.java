package com.example.day11_menu_demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	/*
	 * ����ѡ��˵� ���������б�Ҫ��ʱ���Լ�дmain.xml��Դ ��
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
		//�����Ǹ�ѡ��˵�.xml
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		
		//�����id�ǲ˵���Դ���id
		int id = item.getItemId();
		TextView tv = (TextView) findViewById(R.id.tv);
		switch (id) {
		case R.id.action_settings:{
			// �������
			tv.setText("");
		}
			
			break;
		case R.id.add:{
			// �����Ӳ˵�
			tv.setText("hahahahahahahaha");
		}
		
		break;
		case R.id.red:{
			tv.setTextColor(Color.RED);
		}
		
		break;
		case R.id.green:{
			tv.setTextColor(Color.GREEN);
		}
		
		break;
		case R.id.bule:{
			tv.setTextColor(Color.BLUE);
		}
		
		break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
