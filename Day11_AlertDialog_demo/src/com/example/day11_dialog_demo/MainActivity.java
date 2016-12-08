package com.example.day11_dialog_demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// ����Զ����¼�Ի���
	public void dialog3(View view) {
		// ���������ĶԻ���
		final AlertDialog dialog;
		// 1.Builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 2.LayoutInflater-->layout.xml-->view
		View loginView = LayoutInflater.from(this).inflate(
				R.layout.layout_dialog_login, null);
		// 3.���ñ��⼰����,
		builder.setTitle("��¼");
		builder.setView(loginView);
		// 4.��ʾ
		dialog = builder.show();
		// 5.�ҵ���Ӧ�Ŀؼ������ý����¼�
		final EditText name = (EditText) loginView.findViewById(R.id.name);
		final EditText password = (EditText) loginView
				.findViewById(R.id.password);

		Button sure = (Button) loginView.findViewById(R.id.sure);
		Button cancel = (Button) loginView.findViewById(R.id.cancel);

		// �����¼��ť
		sure.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ���û��������Ϣ��ʾ����
				String name_info = name.getText().toString();
				String password_info = password.getText().toString();
				Toast.makeText(MainActivity.this,
						name_info + ":" + password_info, Toast.LENGTH_SHORT)
						.show();
				// ��ʧ�Ի���
				dialog.dismiss();
			}
		});
		// ���ȡ����¼��ť
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ʧ�Ի���
				dialog.dismiss();

			}
		});

	}

	String[] items = { "����", "����", "����", "��ɭ��" };
	boolean[] isChecks = { true, false, false, false };

	// �����ѡ�Ի���ť
	public void dialog1(View view) {
		// 1.Builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 2.���ñ��⡢���ݡ�����
		builder.setTitle("����ϲ����֧���");
		builder.setSingleChoiceItems(items, 0, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// ������ǰѡ���������
				Toast.makeText(MainActivity.this, items[which],
						Toast.LENGTH_SHORT).show();

			}
		});
		// 3.��ʾ
		builder.show();

	}

	// �����ѡ�Ի���ť
	public void dialog2(View view) {
		// 1.Builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 2.���ñ��⡢���ݡ�����
		builder.setTitle("����ϲ����֧���");
		/*
		 * ����1������Դ����
		 * 
		 * ����2:ÿ��ѡ���Ĭ�ϳ�ʼ�ĵ��״̬boolean����
		 * 
		 */
		builder.setMultiChoiceItems(items, isChecks,
				new OnMultiChoiceClickListener() {

					// ����������ǰ���Ǳ�ѡ�л���ȡ��
					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						// ����һ������ַ���
						StringBuilder sb = new StringBuilder();
						// ѭ������ѡ�����ݣ���ȡѡ��������ݣ���ƴ�ӵ������
						for (int i = 0; i < items.length; i++) {
							// �����ǰ����ѡ�У�ƴ�ӵ������
							if (isChecks[i]) {
								sb.append(items[i]).append("\n");
							}
						}
						Toast.makeText(MainActivity.this, sb.toString(),
								Toast.LENGTH_SHORT).show();
					}
				});
		// 3.��ʾ
		builder.show();
	}

	// �����ͨ�Ի���ť
	public void dialog(View view) {
		// ��������Ի���
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 2.����Builder���⡢ͼ��
		// 3.�����ı�����,����
		builder.setTitle("�򵥶Ի���");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("����").setPositiveButton("ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// ����һ��Dialog,��ǰ��ʾ�ĶԻ���
				// ����������ʾ�������λ��
				finish();
			}
		});
		// 4.�����Ի���
		// 5.show
		builder.create().show();

	}

	
	// �����ؼ�ʱ�������Ի���
	/*
	 * onKeyDown��������������
	 * 
	 * ����һ����ǰ���¼��ļ�ֵkeyCode
	 * 
	 * ��������KeyEvent���¼����¼���װ�ɵĶ���
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// �����·��ؼ�ʱ��������ʾ,��������ͬʱ���㣺�¼��ǰ����¼������Ƿ��ؼ�
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			// дһ���Ի���
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("�˳���ʾ").setMessage("�Ƿ��˳���");
			// ������ť
			builder.setPositiveButton("ȷ��", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// ȷ���˳�
					finish();
				}
			});

			builder.setNegativeButton("���˳�", null);

			builder.show();
		}

		return super.onKeyDown(keyCode, event);

	}
}
