package com.example.day16_objectanimator_demo;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageButton ib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ib = (ImageButton) findViewById(R.id.iv);
	}

	// �����ʵ��ObjectAnimator����
	public void start(View view) {

		// ib.setRotation(0.8f);
		// 2.����ObjectAnimator����
		/*
		 * ����һ��ִ�ж����Ķ���
		 * 
		 * ��������������������,String,����һ��Ҫ�ṩset��get�ķ���
		 * 
		 * ������������������ֵ��
		 */
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ib, "Rotation",
				0, 360);
		// ���ó���ʱ��
		objectAnimator.setDuration(2000);
		// ���ó���ʱ��
		objectAnimator.setRepeatCount(10);
		// ��������
		objectAnimator.setInterpolator(new LinearInterpolator());
		// 3.��������
		objectAnimator.start();

	}

	// �����ʵ��OjbectAnimatorƽ�ƶ���
	public void translateObj(View view) {		
		// ib.setTranslationY();
		
		// 2.����ObjectAnimator
		ObjectAnimator objTrans = ObjectAnimator.ofFloat(ib, "TranslationY", 0,
				300);
		// ���ó���ʱ��
		objTrans.setDuration(3000);
		// 3.���Ŷ���
		objTrans.start();

	}
	
	// �����ʵ��ObjectAnimator����
	public void scaleObj(View view) {

		// ib.setScaleX();
		// ���嶯��
		ObjectAnimator objScale = ObjectAnimator.ofFloat(ib, "ScaleX", 1, 0.5f);
		// ����ʱ��
		objScale.setDuration(3000);
		objScale.start();
		
		// ����ObjectAnimatorֵ�ı仯
		objScale.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {
				Log.d("Tag", "onAnimationStart");

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				Log.d("Tag", "onAnimationRepeat");

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				Log.d("Tag", "onAnimationEnd");

			}

			@Override
			public void onAnimationCancel(Animator animation) {
				Log.d("Tag", "onAnimationCancel");

			}
		});

		// ValueAnimatorר�ü���,������������ֵ�ı�
		objScale.addUpdateListener(new AnimatorUpdateListener() {

			/*
			 * ������ֵ�����ı�ʱ����
			 */
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// ��ȡ��ǰ����ִ�еİٷֱ�
				float fraction = animation.getAnimatedFraction();

				Log.d("Tag", "onAnimationUpdate:" + fraction);
				// x�����ѹ����ֵΪ0.5f
				// ���ݰٷֱȣ������ǰy�����ѹ����
				float value = 1 - fraction * 0.5f;
				// ����y�����ѹ����
				ib.setScaleY(value);

			}
		});
	}

	// �����ʵ��AnimatorSet����
	public void setObj(View view) {
		// ��ȡ��Ļ�Ŀ��
		DisplayMetrics metri = getResources().getDisplayMetrics();
		// ����������Ϊ��λ
		int width = metri.widthPixels;
		// ���ߣ�������Ϊ��λ
		int height = metri.heightPixels;
		// 2.����x,y��������Զ���
		ObjectAnimator objTranY = ObjectAnimator.ofFloat(ib, "TranslationY", 0,
				height - 2 * ib.getHeight());
		ObjectAnimator objTranX = ObjectAnimator.ofFloat(ib, "TranslationX", 0,
				width - ib.getWidth());
		// 3.����AnimatorSet
		AnimatorSet set = new AnimatorSet();
		
		set.setDuration(3000);
		// 4.ͨ��AnimatorSet.play��Ӳ����ò���ģʽ
		set.playTogether(objTranX, objTranY);
		// 5.����
		set.start();

	}

	// ����������ڶ���Activity
	public void startSecondActivity(View view) {
		// ����Activity,���ù�������
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
		// ���ù�������
		overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity);

	}
	


}
