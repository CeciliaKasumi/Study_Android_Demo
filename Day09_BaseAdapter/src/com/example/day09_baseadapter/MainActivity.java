package com.example.day09_baseadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	// �����ؼ������ݣ�adapter
	ListView lv;
	ArrayList<String> data;
	MyAdapter adapter;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ���ؼ�
		lv =(ListView) findViewById(R.id.lv);
		//��ʼ������
		data = new ArrayList<>();	
		for (int i = 0; i < 200; i++) {
			data.add("momo"+i);
		}
		//��ʼ��adpater
		adapter = new MyAdapter();
		//��ListView����Adapter
		lv.setAdapter(adapter);
	}
	
	/**
	 * �Զ���Adapter
	 * 
	 * 1.дһ��class,�̳���BaseAdapters(������)
	 * 
	 * 2.ʵ��BaseAdapter�еĳ��󷽷�
	 * */
	class MyAdapter extends BaseAdapter{
		
		//��ʼ��LayoutInflater(������⣺���ִ���Ͳ)�����ðѲ���ת��ΪView
		LayoutInflater flater ;
		
		public MyAdapter(){
			flater = LayoutInflater.from(MainActivity.this);
		}
		
		/* ����ListViewҪ���ض���������
		 * 
		 * һ����д������Դ�Ĵ�С
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

	
		/* ����ÿ��Item����Ҫ����ͼ
		 * 
		 * ��������£�һ��������ͼ�����������ݸ���ͼ��
		 * 
		 * ����һ��int �����ǵ�ǰ������ͼ���б��е�λ��
		 * 
		 * ���������Ѿ�����������ͼ�����ɸ��õ���ͼ
		 * 
		 * �����������ֿؼ��ĸ�����
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Log.d("TAG", "position"+position);
			//����convertView�ж��Ƿ��п�����ͼ�����convertViewΪnull���ʹ���һ���µ���ͼ�������Ϊnull��˵���Ѿ��������ˣ��Ϳ���ֱ������
			//������ViewHolder
			//���convertViewΪnull���ʹ���һ���µ�ViewHolder,�������еĿؼ����г�ʼ��
			//��ViewHoder��convertView���й���
			ViewHolder holder;

//			View view = flater.inflate(R.layout.item_list, null);
			if(convertView == null){
				Log.d("TAG","convertView");
				//ͨ��LayoutInflater��xml�����ļ�ת����View
				//����һ����Ҫת����layout��id
				//�����������ظ�View�ĸ��ؼ����򵥿�д��null
//				convertView = flater.inflate(R.layout.item_list, null);
				//��׼д��
				convertView = flater.inflate(R.layout.item_list, parent,false);
				holder = new ViewHolder();
				holder.tv =(TextView) convertView.findViewById(R.id.tv);
				
				//��convertView���ñ��,��ViewHolder��convertView���й���
				convertView.setTag(holder);
			}else{
				//�п�����ͼ,ȡ��Tag,ǿת��ViewHolder
				holder = (ViewHolder) convertView.getTag();
			}
			//���ҵ�������ݵĿؼ���TextView
			
			//������Դ��ȡ������
			String value = data.get(position);
			//��TextView��������
			holder.tv.setText(value);
			
			return convertView;
		}
		
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		class ViewHolder{
			TextView tv;
			
		}
		
	}


}
