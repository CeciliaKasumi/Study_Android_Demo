package com.example.day18_banner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

public class MainActivity extends Activity {

	//�ؼ�����
	ViewPager vp;
	LinearLayout point_layout;
	ListView lv;
	
	
	List<View> views;
	//������
	ViewPagesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ���ؼ�
		setupView();
		//��ʼ������
		initData();
		//��ʼ����
		initPoint();
		 //����Adapter
		adapter = new ViewPagesAdapter(views);
		vp.setAdapter(adapter);
		
		//viewpager���ü���
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {

				//�Ե����ͼƬ����
                //�Ȼ�ȡԲ��ĸ��� point_layout.getChildCount()
				int pointCount = point_layout.getChildCount();

				for (int i = 0; i < pointCount; i++) {
					//ѭ����ȡÿ���ӿؼ�����ǿת��ImageView
					ImageView iv = (ImageView) point_layout.getChildAt(i);
					//����ImageView ��ͼƬ
					if (i == arg0) {
						// ѡ�е�
						iv.setImageResource(R.drawable.pager_select);
					} else {
						iv.setImageResource(R.drawable.pager_normal);

					}

				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		//�����̣߳����ֲ�ͼƬ������
		startTask();
		

	}

	private void startTask() {
		 //�����̣߳�������
		new Thread() {
			public void run() {
				//��ѭ��
				while(true){
					//ÿ��2000ms�л�һ��ͼƬ
					SystemClock.sleep(2000);
					//�л�ͼƬ��������UI�߳������
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							//��ȡ��ǰ��ʾ���±�
							int currentIndex = vp.getCurrentItem();
							//�ڵ�ǰ�����ϣ��ټ�1
							currentIndex++;
							vp.setCurrentItem(currentIndex%views.size());
							
						}
					});
					
				}
			};
		}.start();
		
	}

	private void initPoint() {
		//����LayoutParams
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
		params.setMargins(5, 5, 5, 5);
		//��ȡ����Դ�Ĵ�С
		int pointCount = views.size();
		//ѭ������ImageView
		for (int i = 0; i < pointCount; i++) {
			ImageView iv = new ImageView(this);
			if (i == 0) {
				iv.setImageResource(R.drawable.pager_select);
			} else {

				iv.setImageResource(R.drawable.pager_normal);
			}
			//��ӵ�point_layout
			point_layout.addView(iv, params);

		}

	}

	//����ͼƬ��Դ��id����
	int[] imgId = { R.drawable.banner1, R.drawable.banner2, R.drawable.banner3,
			R.drawable.banner4, R.drawable.banner5 };

	private void initData() {
		//��ʼ������
		views = new ArrayList<View>();
		//ѭ����ӿؼ�
		for (int i = 0; i < 5; i++) {
			//����ImageView
			ImageView iv = new ImageView(this);
			//����ImageView������ģʽ
			iv.setScaleType(ScaleType.FIT_XY);
			//����ImageView��ͼƬ
			iv.setImageResource(imgId[i]);
			//��ӵ�������
			views.add(iv);

		}

	}

	private void setupView() {
		vp = (ViewPager) findViewById(R.id.viewpager);
		point_layout = (LinearLayout) findViewById(R.id.point_layout);
		
		//===========================����ListView
		
		lv =(ListView) findViewById(R.id.lv);
		List<String> data = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			data.add("����"+i);
		}
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
		lv.setAdapter(listAdapter);
		
		//ListView�и�������addHeaderView(View)
	
	}

}
