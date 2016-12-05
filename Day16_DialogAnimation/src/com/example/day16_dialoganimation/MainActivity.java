package com.example.day16_dialoganimation;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void doClick(View view) {
		//AlertDialog����
		// 1.����AlertDialog
		// AlertDialog dialog = new AlertDialog.Builder(this).setTitle("title")
		// .setMessage("message").create();
		// 2.ͨ��Dialog��ȡWindow
		// Window window = dialog.getWindow();
		// window.setGravity(Gravity.BOTTOM); // �˴���������dialog��ʾ��λ��
		// 3.��Window�������ö������
		// window.setWindowAnimations(R.style.dialogWindowAnim); // ��Ӷ���
		// ��ʾ�Ի���
		// dialog.show();
		
		//popupwindow�Ķ���
		View popupwindow = getLayoutInflater().inflate(
				R.layout.popupwindow_layout, null);
		PopupWindow pop = new PopupWindow(popupwindow,
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		pop.setAnimationStyle(R.style.dialogWindowAnim);
		pop.showAsDropDown(view);
	}

}
