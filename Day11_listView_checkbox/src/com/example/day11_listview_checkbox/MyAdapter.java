package com.example.day11_listview_checkbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class MyAdapter extends BaseAdapter  {

	public LayoutInflater flater;
	//map :����checkbox���ı����Լ���¼checkbox�ĵ��״̬ 
	public List<Bean> data;
	public Context context;

	public MyAdapter(List<Bean> data, Context context) {
		super();
		this.flater = LayoutInflater.from(context);;
		this.data = data;
		this.context = context;

	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if(convertView ==null){
			convertView = flater.inflate(R.layout.item_list, parent, false);
			holder = new ViewHolder();
			holder.tv = (TextView) convertView.findViewById(R.id.tv);
			holder.cb = (CheckBox) convertView.findViewById(R.id.cb);
			convertView.setTag(holder);
			
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		// ��checkBox���ü���,һ�������ü�����������ֵ����������ֵ���ټ���������״̬���λ��
		holder.cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// ��������checkbox״̬����
				data.get(position).isCheck = isChecked;
				Log.d("Tag", "```" + position + isChecked);
			}
		});
		

		// ������Ĭ��ֵ������ֵ�ڼ�������
//		holder.cb.setChecked(false);
		Log.d("Tag", ""+position+data.get(position).isCheck);
		holder.cb.setChecked(data.get(position).isCheck);
		
		holder.tv.setText(data.get(position).name);
		

		

		
		return convertView;
	}
	
	class ViewHolder{
		CheckBox cb;
		TextView tv;
	}





}
