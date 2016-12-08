package com.example.day08_asynctask_stop;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	MyTask task = new MyTask();
	
	
	public void startAsync(View view){
		
		task.execute();
		// ��ֹ�û���ε��
		view.setClickable(false);
		
		
	}
	
	// ����1������һ���߳̽����ı�ʶ����
	boolean isStop;
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//ֹͣ�첽���񷽷�1������ֹͣ��ʶ
//		isStop = true;
		//����2:
		task.cancel(true);
	}
	
	class MyTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			int i =0;
			//����1: while(!isStop)
			//����2:
			while(!isCancelled()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				Log.d("TAG", "�첽����"+i);
				
			}
			
			return null;
			
		}
		
	}
}
