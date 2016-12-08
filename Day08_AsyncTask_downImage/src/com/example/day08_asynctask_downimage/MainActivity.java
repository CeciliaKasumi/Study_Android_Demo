package com.example.day08_asynctask_downimage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv =(ImageView) findViewById(R.id.iv);
	}
	
	// ���������ͼƬ����չʾ����
	public void download(View view ){
		
		MyTask task = new MyTask();
		task.execute();
	}

	
	// ʹ���첽����
		/*
		 * 1.дһ��class,�̳���AsyncTask
		 * 
		 * 2.ȷ����������
		 * 
		 * 3.��дdoInBackground
		 * 
		 * 4.��дonPostExecute
		 */
	
	class MyTask extends AsyncTask<Void, Void, Bitmap>{

		@Override
		protected Bitmap doInBackground(Void... params) {
			
			HttpURLConnection conn =null;
			Bitmap bitmap= null;
			try {
				URL url = new URL("http://www.ytmfdw.com/image/img2.jpg");
				conn = (HttpURLConnection) url.openConnection();
				// ��InputStreamת����Bitmap
				InputStream in = conn.getInputStream();
				bitmap = BitmapFactory.decodeStream(in);
				
				in.close();
				// ��bitmap����
				return bitmap;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn != null){
					conn.disconnect();
				}
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// �жϽ���Ƿ�Ϊnull,�������null�����ø�ImageView
			if(result != null){
			iv.setImageBitmap(result);
			}
		}
		
		
	}

}
