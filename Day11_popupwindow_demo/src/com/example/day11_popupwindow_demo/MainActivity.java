package com.example.day11_popupwindow_demo;

import java.text.DecimalFormat;
import java.util.Random;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	PopupWindow popWindow;
	
	// ���������һ��PopupWindow
	public void doClick(View view){
		if(popWindow==null){
		// ���popWindowΪnull��˵���ǵ�һ�ε�����ʹ���һ���µ�popupwindowʵ��
		// 1.��ȡLayoutInflater	
		LayoutInflater inflater = LayoutInflater.from(this);
		// 2.layout.xml-->view
		View popView = inflater.inflate(R.layout.popupwindow_layout, null);
		// 3.new PopupWindow
		popWindow = new PopupWindow(popView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// 4.���õ���հ״���popuoWindow��ʧ:����һ��͸���ı������������ܿɴ���
		popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));//���Բ�������
		popWindow.setOutsideTouchable(true);
		
		Log.d("Tag", "ִ����popwindow==null");
		
		//		popWindow.showAsDropDown(view);// �ڿؼ����·�����
		//5.popupwindow.show...	
		popWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
		// 6.�����¼�,���ҵ�popwindow�����еĿؼ��������ü���
		popView.findViewById(R.id.send_money).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Random random = new Random();
				float num = random.nextFloat()*100;
				DecimalFormat df = new DecimalFormat("#.00");
				String money = df.format(num);
				Toast.makeText(MainActivity.this, "��ϲ������"+money+"Ǯ", Toast.LENGTH_SHORT).show();
				
				Log.d("Tag", "ִ����onClick");
				
				// popwindow��ʧ
				popWindow.dismiss();
			}
		});	
		
		Log.d("Tag", "ִ����popwindow==null,last");
		
		}else{
			// ���������û��ʾ���������Ѿ������ˣ�������ʾ
			if(popWindow.isShowing()){
				// ���������ʾ������ʧ
				popWindow.dismiss();
			}else{
				// ��ʾ����
				popWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
			}
		}
	}
}
