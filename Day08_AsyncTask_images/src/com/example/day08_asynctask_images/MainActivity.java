package com.example.day08_asynctask_images;

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
	// ����ͼƬ��url����
	String[] urls = { "http://www.ytmfdw.com/image/img1.jpg",
			"http://www.ytmfdw.com/image/img2.jpg",
			"http://www.ytmfdw.com/image/img3.jpg",
			"http://www.ytmfdw.com/image/img4.jpg",
			"http://www.ytmfdw.com/image/img5.jpg",
			"http://www.ytmfdw.com/image/img6.jpg",
			"http://www.ytmfdw.com/image/img7.jpg",
			"http://www.ytmfdw.com/image/img8.jpg",
			"http://www.ytmfdw.com/image/img9.jpg" };

	// ����һ������������¼��ǰ���ص�ͼƬ��url�����±�
	int index = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.iv);
	}

	// �����ť������һ��ͼƬ
	public void download(View view) {
		MyTask task = new MyTask();
		// ��������ѭ��ȡֵ����ͨ��%ģ��ȡ�����ķ�ʽ
		task.execute(urls[index++ % urls.length]); // ���෽��������±�

	}

	// �첽����
	class MyTask extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected Bitmap doInBackground(String... params) {
			// 1.��ȡ�����url
			String http = params[0];
			// 2.HttpUrlConnection,Bitmap
			Bitmap bitmap = null;
			HttpURLConnection conn = null;

			try {
				// 3.URL
				URL url = new URL(http);
				// 4.url.openConnection
				conn = (HttpURLConnection) url.openConnection();
				// 5.InputStream
				InputStream in = conn.getInputStream();
				// 6.InputStream-->Bitmap
				bitmap = BitmapFactory.decodeStream(in);
				// 7.�������Ͽ�����
				in.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conn != null) {
					conn.disconnect();
				}
			}

			return bitmap;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result != null) {
				iv.setImageBitmap(result);
			}
		}

	}

}
