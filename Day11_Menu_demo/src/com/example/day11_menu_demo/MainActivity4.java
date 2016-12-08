package com.example.day11_menu_demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;

public class MainActivity4 extends Activity {
	
	
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv =(TextView) findViewById(R.id.tv);
		
		// ����ı���ļ����¼�-->�����˵�
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//����PopupMenu(����ʽ�˵�)
				//1.new PopupMenu
				PopupMenu menu = new PopupMenu(MainActivity4.this, v);
				//2.getMenuInflater.inflat(R.menu.xxx,menu)
				getMenuInflater().inflate(R.menu.main, menu.getMenu());
				//menu.getMenuInflater().inflate(R.menu.main, menu.getMenu());
				//MainActivity4.this.getMenuInflater().inflate(R.menu.main, menu.getMenu());������һ��Ч��
				//3.show
				menu.show();
				//4.����popupmenu����¼�
				menu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						
						switch (item.getItemId()) {
						case R.id.add:{
							tv.setText("12321321312321312313123");
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
					
						return false;
					}
				});
			}
		});
	}

}
