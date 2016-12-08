package com.example.day11_menu_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class MainActivity2 extends Activity {

	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		
		
	}
	
	/**
	 * �����˵�
	 * 
	 * ��дonCreateOptionsMenu
	 * 
	 * ͨ��������ʽ��Ӳ˵���
	 * */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//��д Activity �� onCreateOptionsMenu(Menu menu) �������ڷ����ڵ��� Menu ����ķ�������Ӳ˵�����Ӳ˵���
		// ���һ����ͨ�˵�(һ���˵�)
		// groupId,itemId,orderId,title
		MenuItem add_item = menu.add(0, 0x666, 0, "���");
		// ����ͼƬ
		add_item.setIcon(R.drawable.d03);
		// ��ʾ�ڲ˵���
		add_item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		//���������˵�
		SubMenu subMenu = menu.addSubMenu("�ı���С");
		//�����д����Ĳ˵������ö����˵���ͼƬûʲô����,û��Ӧ��(xml����)
//		subMenu.setHeaderIcon(R.drawable.ic_launcher);
//		subMenu.setIcon(R.drawable.ic_launcher);
		subMenu.add(1, 0x101, 0, "��");
		subMenu.add(1, 0x102, 0, "��");
		subMenu.add(1, 0x103, 0, "С");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * ѡ�˵��ĵ���¼�
	 * 
	 * ��дonOptionsItemSelected
	 * */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		// ����id�жϣ�����Ӧ����
		case 0x666:
			tv.setText("�����"+item.getTitle());
			break;
		case 0x101:
			tv.setTextSize(50);
			break;
		case 0x102:
			tv.setTextSize(30);
			break;
		case 0x103:
			tv.setTextSize(20);
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
