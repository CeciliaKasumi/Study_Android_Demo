package com.example.day08_asynctask_login;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class LoginTask extends AsyncTask<String, Void, String> {

	String http = "http://www.ytmfdw.com/coupon/admin.php?a=login";
	// ���ýӿڻص���ʽ��
	public interface CallBack {
		/**
		 * ��ʼ��¼ʱ���á�
		 */
		public void startButton();
		/**
		 * ��¼����ʱ���á�
		 */
		public void endButton(String result);
	}

	CallBack cb;
	
	
	

	public LoginTask(CallBack cb) {
		super();
		this.cb = cb;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		// ��ʼ��¼����¼��ť���ɵ��
		if(cb!=null){
		cb.startButton();
		}
	}

	/*
	 * �����¼ʱ�������˺ź�����
	 */
	@Override
	protected String doInBackground(String... params) {
		// 1.HttpUrlConnection
		HttpURLConnection conn = null;
		// ������¼,��¼ʱ����������������name,password
		String name =params[0];
		String password =params[1];
		// ת�����
		StringBuilder sb = new StringBuilder();

		try {
			// 2.URL
			URL url = new URL(http+"&name="+name+"&password="+password);
			// 3.url.openConnection
			conn = (HttpURLConnection) url.openConnection();
//			//POST��������=============================================
//			conn.setRequestMethod("POST");// �ύģʽ
//			conn.setDoOutput(true);// �Ƿ��������
//			String param = "name=" + name + "&password=" + password;// post�ύ����
//			byte[] bytes = param.getBytes();
//			conn.getOutputStream().write(bytes);// �������
//			//================POST�������==========================
			// 4.InputStream
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String temp = null;
			// 5.InputStream-->String
			while ((temp = br.readLine()) != null) {
				sb.append(temp).append("\n");
			}
			// 6.�ر���
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7.�Ͽ�����
			if (conn != null) {
				conn.disconnect();
			}
		}
		// 8.��ת��������ص�onPostExecute
		return sb.toString();
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		// �ָ���ť�ɵ�
		if(cb!=null){
		cb.endButton(result);
		}
	}

}
