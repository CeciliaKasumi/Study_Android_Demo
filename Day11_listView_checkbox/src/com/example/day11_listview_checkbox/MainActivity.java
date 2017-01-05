package com.example.day11_listview_checkbox;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	
	ListView lv;
	List<Bean> data;
	MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		lv = (ListView) findViewById(R.id.lv);
		data = new ArrayList<Bean>();
		for (int i = 0; i < 100; i++) {
			Bean bean = new Bean();
			bean.name=""+i;
			data.add(bean);
		}
		
		adapter = new MyAdapter(data, this);
		lv.setAdapter(adapter);
		
		
		
		// ListView��Item����¼�
		//����������ť��ListView�ListView��ʧȥ���㡣���ȣ�����item�Ĳ��ֵĸ��ڵ���������android:descendantFocusability="blocksDescendants"
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Toast.makeText(MainActivity.this, data.get(position).name, Toast.LENGTH_SHORT).show();
				
			}
		});
		
		// ��ListViewע�������Ĳ˵�
		registerForContextMenu(lv);
		
	}
	
	/*
	 * 
	 * ��дonCreateContextMenu
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		// ���3���˵�ѡ��
		menu.add(1, 1, 0, "���");
		menu.add(1, 2, 0, "ɾ��");
		menu.add(1, 3, 0, "����");
		
	}
	
	
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		case 1:{
			// ����ǰ�����һ������
			Bean bean = new Bean();
			bean.name= "���������ӵ���Ϣ";
			// �����ݼ������������
			data.add(0,bean);
			// ֪ͨadapter���ݷ����ı䣬���½���
			adapter.notifyDataSetChanged();
		}
			
			break;
		case 2:{
			//ɾ������
			// 1.�Ȼ�ȡ��ǰ�������position
			// ͨ��MenuItem��ȡContextMenuInfo
			// ��ContextmenuInfoǿת��AdapterContextMenuInfo
			AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
			int position = menuInfo.position;
			// 2.ͨ������ɾ��ָ��λ�õ�����
			data.remove(position);
			// 3.֪ͨ�������
			adapter.notifyDataSetChanged();
		}
		case 3:{
			//���빦��
			AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
			int position = menuInfo.position;
			Bean bean = new Bean();
			bean.name= "�����²������Ϣ";
			data.add(position,bean);
			adapter.notifyDataSetChanged();
		}
		
		break;

		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}


}
