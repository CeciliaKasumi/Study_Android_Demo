package com.example.day16_animation_demo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv_number, iv_rocket;
	/**
	 * ��������ʱ��
	 */
	int time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 1.�ҵ����ö����Ŀؼ�
		iv_number = (ImageView) findViewById(R.id.iv_number);
		iv_rocket = (ImageView) findViewById(R.id.iv_rocket);
		
		
	}

	// �����ʵ�ֵ���ʱ�Ķ���
	public void send(View view) {

		// 2.�ҵ���Ӧ���ԣ��ĸ������˶����ģ�
		// 3.ǿת��AnimationDrawable
		AnimationDrawable number_anim = (AnimationDrawable) iv_number
				.getBackground();
		// ����һ��,����startǰ�󶼿���
		// animation.setOneShot(true);

		// ���㶯������ʱ��:�Ȼ�ȡ��֡������ȡÿһ֡�ĳ���ʱ��
		int frameCount = number_anim.getNumberOfFrames();
		// ѭ����������ȡÿһ֡��ʱ��
		for (int i = 0; i < frameCount; i++) {
			time += number_anim.getDuration(i);
		}
		// ����ִ����ɺ�iv_number��ʧ������һ���̣߳��ø��߳�sleep
		// timeʱ�䣬sleep�󣬾�ִ��iv.setVisiable(View.GONE)
		new Thread() {

			public void run() {

				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// ���ÿؼ����ɼ��������߳�������
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// ����iv_number���ɼ�
						iv_number.setVisibility(View.GONE);
						// ����������Ķ���
						AnimationDrawable rocket_anim = (AnimationDrawable) iv_rocket
								.getBackground();
						// ���ÿؼ����ɼ��������߳�������
						rocket_anim.start();
					}
				});

			};

		}.start();
		// 4.��������ʱ����
		number_anim.start();

	}
	// �����iv_rocketִ��͸������
	public void alphaAnim(View view) {
		// 2.��rocket_alpha������װ�ؽ���
		Animation rocket_alpha = AnimationUtils.loadAnimation(this,
				R.anim.rocket_alpha);
		// 3.ͨ��View.startAnimation
		iv_rocket.startAnimation(rocket_alpha);

	}

	// ���������ʵ��iv_rocket͸������
	public void alphaAnim_java(View view) {
		// 1.����AlphaAnimation
		AlphaAnimation animation = new AlphaAnimation(1f, 0f);
		// ���ó���ʱ��
		animation.setDuration(1000);
		// ����ѭ������
		animation.setRepeatCount(AlphaAnimation.INFINITE);
		// ����ѭ��ģʽ
		animation.setRepeatMode(AlphaAnimation.REVERSE);
		// 2.ͨ��View.startAnimation
		iv_rocket.startAnimation(animation);
	}
	
	// ����� xmlʵ��iv_rocket���Ŷ���
	public void scaleAnim(View view) {
		// 2.װ�ض���
		Animation rocket_scale = AnimationUtils.loadAnimation(this,
				R.anim.rocket_scale);
		// 3.���Ŷ���
		iv_rocket.startAnimation(rocket_scale);

	}
	// �����javaʵ��iv_rocket���Ŷ���
	public void scaleAnim_java(View view) {
		// 2.����һ��ScaleAnimation����
		ScaleAnimation animation = new ScaleAnimation(1f, 3f, 1f, 3f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		// ����ʱ��
		animation.setDuration(1000);
		// ����ֹͣ�����һ֡
		animation.setFillAfter(true);
		// 3.���Ŷ���
		iv_rocket.startAnimation(animation);

	}
	
	// �����xmlʵ��iv_rocket�ƶ�����
	public void translateAnim(View view) {
		// 2.ͨ��AnimationUtils.loadAnim
		Animation rocket_translate = AnimationUtils.loadAnimation(this,
				R.anim.rocket_translate);
		// 3.���Ŷ���
		iv_rocket.startAnimation(rocket_translate);

	}
	// �����javaʵ��iv_rocket�ƶ�����
	public void translateAnim_java(View view) {
		// 2.����TranslateAnimation
		TranslateAnimation animation = new TranslateAnimation(
				TranslateAnimation.RELATIVE_TO_PARENT, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, -1f);
		animation.setDuration(5000);
		// ͣ�����
		animation.setFillAfter(true);
		// ���ò�ֵ��
		animation.setInterpolator(new LinearInterpolator());
		// 3.���Ŷ���
		iv_rocket.startAnimation(animation);

	}

	// �����xmlʵ��iv_rocket����ת
	public void rotateAnim(View view) {
		// 2.AnimationUtils.loadAnim..
		Animation rocket_rotate = AnimationUtils.loadAnimation(this,
				R.anim.rocket_rotate);
		// 3.���Ŷ���
		iv_rocket.startAnimation(rocket_rotate);

	}

	// �����javaʵ��iv_rocket����ת
	public void rotateAnim_java(View view) {
		// 2.����RotateAnimation
		RotateAnimation animation = new RotateAnimation(-45f, 45f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0f);
		animation.setDuration(1000);
		animation.setRepeatCount(Animation.INFINITE);
		animation.setRepeatMode(Animation.REVERSE);
		animation.setInterpolator(new LinearInterpolator());
		// 3.���Ŷ���
		iv_rocket.startAnimation(animation);

	}
	// �����iv_rocket���ţ�ƽ�ơ����Ŷ���
	public void setAnim(View view) {
		// 2.AnimationUtils.loadAnimation
		Animation rocket_set = AnimationUtils.loadAnimation(this,
				R.anim.rocket_set);
		// 3.���Ŷ���
		iv_rocket.startAnimation(rocket_set);

	}
	// �����iv_rocketʵ��set����
	public void setAnim_java(View view) {
		// 2.����һ��AnimationSet
		AnimationSet set = new AnimationSet(true);
		// 3.������������:ƽ�ơ���ת�����š�͸��
				// 2.����TranslateAnimation
		TranslateAnimation trans = new TranslateAnimation(
				TranslateAnimation.RELATIVE_TO_PARENT, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, -1f);
		// 2.����ScaleAnimation
		ScaleAnimation scale = new ScaleAnimation(1f, 0.6f, 1f, 0.6f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		// 4.ͨ��set.addAnimtion()
		set.addAnimation(trans);
		set.addAnimation(scale);
		// ��ֵ��
		set.setInterpolator(new AccelerateInterpolator());
		// ����ʱ��
		set.setDuration(2000);
		// ����ֹͣ�����
		set.setFillAfter(true);
		// 5.���Ŷ���
		iv_rocket.startAnimation(set);

	}
}
