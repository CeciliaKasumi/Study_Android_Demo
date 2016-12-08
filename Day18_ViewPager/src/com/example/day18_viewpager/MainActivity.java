package com.example.day18_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	ViewPager vp;
	// ����Դ
	List<View> views;
	// �����ӿؼ��ĸ�����
	LinearLayout point_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// eclipseȥ��������
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// android studio����ActionBar
		// getSupportActionBar().hide();

		// �ҵ��ؼ��ͳ�ʼ������Դ
		vp = (ViewPager) findViewById(R.id.viewpager);
		// ��ʼ��LinearLayout
		point_layout = (LinearLayout) findViewById(R.id.point_layout);

		// ��ʼ������
		initData();

		// ��ʼ��Բ��
		initPoint();

		// ʹ��Adapter
		MyAdapter adapter = new MyAdapter();
		vp.setAdapter(adapter);

		// ����ViewPager��ҳ���л�����
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			/*
			 * ��ҳ������л�ʱ���ص�
			 * 
			 * ��������ǰ�л���ҳ����±�
			 */
			@Override
			public void onPageSelected(int position) {

				// ��ȡdot_layout�ӿؼ��ĸ���
				int viewCount = point_layout.getChildCount();
				// ѭ������ÿ���ӿؼ�����ǿת��ImageView
				for (int i = 0; i < viewCount; i++) {
					// ��ȡÿ���ӿؼ�
					ImageView iv = (ImageView) point_layout.getChildAt(i);
					// ����ImageView��ͼƬ
					if (position == i) {
						// ��ǰѡ�е�ҳ��
						iv.setImageResource(R.drawable.page_now);
					} else {
						iv.setImageResource(R.drawable.page);
					}
				}
				
				Log.d("Tag", "getChildCount:"+vp.getChildCount());

			}

			// ҳ�滬��ʱ�ص�
			/*
			 * ����һ����ǰ���϶���ҳ����±�
			 * 
			 * ���������ƶ��İٷֱ�
			 * 
			 * ���������ƶ������ص�
			 */
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub

			}

			// ����״̬�����ı�ʱ�ص�
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub

			}
		});

	}
	

	/*
	 * ��̬���ص�
	 */
	private void initPoint() {
		// ֪��views�Ĵ�С,��ȷ��Բ��ĸ���
		// ѭ������ImageView,���Ѵ���������ImageView��ӵ�point_layout
		int size = views.size();
		// �����Բ����е�����
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
		// ������߾�
		params.setMargins(5, 5, 5, 5);

		for (int i = 0; i < size; i++) {
			// ����һ��ImageView
			ImageView iv = new ImageView(this);

			// ����iv�Ĵ�С
			// ����1
			iv.setLayoutParams(params);

			if (i == 0) {
				// Ĭ�ϵ�һ��ͼƬΪ����
				iv.setImageResource(R.drawable.page_now);
			} else {
				iv.setImageResource(R.drawable.page);
			}
			// ���ص�dot_layout
			point_layout.addView(iv);
			// ����2
			// point_layout.addView(iv, params);
		}

	}

	private void initData() {
		// TODO Auto-generated method stub
		views = new ArrayList<>();
		LayoutInflater inflater = LayoutInflater.from(this);
		// ----------��1������
		View view1 = inflater.inflate(R.layout.page1, null);
		views.add(view1);
		// -----------��2������
		View view2 = inflater.inflate(R.layout.page2, null);
		views.add(view2);
		// -----------��3������
		View view3 = inflater.inflate(R.layout.page3, null);
		views.add(view3);
		// -----------��4������
		View view4 = inflater.inflate(R.layout.page4, null);
		views.add(view4);

	}

	/*
	 * ViewPager���ʺ�����
	 * 
	 * 1.дһ��class,�̳���PagerAdatepr
	 * 
	 * 2.��д��Ӧ����
	 */

	class MyAdapter extends PagerAdapter {

		// ����View�ĸ���
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return views.size();
		}

		// ��������£�
		/*
		 * һ.����View
		 * 
		 * �������ص�ǰ�����ص�View
		 * 
		 * ����һ��ViewGroup:����View�ĸ��ؼ�
		 * 
		 * ��������int :��ǰ�����ص�View������Դ�е�λ��
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// ����positionλ�õ�View
			container.addView(views.get(position));
			// ���ظձ����ص�View
			return views.get(position);
		}

		/*
		 * �Ƴ���ʹ�õ�View
		 */
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// �����super�������ȥ��
			// super.destroyItem(container, position, object);
			// д��һ��
			container.removeView(views.get(position));
			// д������
			// container.removeView(((View)object));
		}

		// �ж�instantiateItem���ص�object�ǲ���view
		@Override
		public boolean isViewFromObject(View view, Object object) {
			// �̶�д��view == object;
			return view == object;
		}

	}

}
