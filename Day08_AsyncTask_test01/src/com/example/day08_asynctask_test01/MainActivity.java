package com.example.day08_asynctask_test01;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	Button btn;
	ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn);
		pb = (ProgressBar) findViewById(R.id.pb);
		pb.setMax(10000);
	}

	// ��ť����¼��������첽����ִ�к�ʱ��������ӦView������ֵ
	public void startAsynTask(View view) {
		// 1.����AsyncTask����
		MyTask task = new MyTask();
		// 2.����
		task.execute(1L, 10000L, 100L);
	}

	/*
	 * 
	 * ʹ��AsyncTask (������)
	 * 1.дһ��class ,�̳���AsyncTask<> 
	 * 2.��дdoInBackground���� 
	 * ��������:
	 * ��һ������ʾexecute��������������� 
	 * �ڶ�������������ֵ������ 
	 * �����������߳�(doInBackground)����ֵ����
	 */

	class MyTask extends AsyncTask<Long, Integer, Integer> {

		
		/*
		 * �����߳�����֮ǰ���á�
		 * 
		 * ���������߳���
		 */
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			btn.setText("��ʼ���񣡣�");
		}

		
		/*
		 * ִ�������߳���
		 * 
		 * ִ�к�ʱ��������������
		 * 
		 * ����(�ɱ����... params:ȡ��ʱ�򵱳�����Ԫ��ȡ����)��
		 * ����execute�����
		 */
		@Override
		protected Integer doInBackground(Long... params) {
			// TODO Auto-generated method stub
			int sum = 0;
			for (long i = params[0]; i < params[1]; i += params[2]) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.d("TAG", "��ǰִ����" + i);
				// ��btn�����ı�,�����߳������У����ܸ���UI
				// btn.setText("��ǰi=" + i);
				// �������и���
				publishProgress((int) i);
				//�ۼ�
				sum += i;
			}
			return sum;
		}

		/*
		 * ִ����UI�߳�
		 * doInBackgroundִ����ɺ󣬻��ִ�н�������÷�����
		 */
		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// �����߳�ִ�н�����ø�btn
			btn.setText("�ۼӽ��" + result);

		}

		@Override
		/*
		 * UI�߳�ִ��
		 */
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			// ȡ���������ȵ�ֵ
			int value = values[0];
			// ���ø�Button
			btn.setText("" + value);
			pb.setProgress(value);
		}

	}

}
