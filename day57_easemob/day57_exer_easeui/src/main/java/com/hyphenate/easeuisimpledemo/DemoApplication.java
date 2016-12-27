package com.hyphenate.easeuisimpledemo;

import com.hyphenate.easeui.controller.EaseUI;

import android.app.Application;


/**
 * ������http://www.easemob.com/
 *
 *
 * ��Ϊ��ģ�����ü�ʱͨѶeasemob���裺(���ټ��ɹٷ���Demo)
 * 1.����sdk
 * 2.��ѹѡ�����е�examples�ļ���easemob
 * 3.�������е�simpledemo����
 * 4.��easemob��ҵ��ģ�鵼�룬���޸Ķ�Ӧ��build.gradle
 * 5.��simpledemo�е�res��src�����ļ�������Ҫʵ�ּ�ʱͨѶ��ģ���С�
 * 6.��Ӧ�޸�AndroidManifest
 * �Կӵĵط���easemob��libs�ļ��е���v4����������ģ���v7��ͻ���൱���ظ�����v4�������������7.
 * 7.ɾ��easemob��libs�ļ��е���v4����������ģ���build.gradle������v7�����룬���У��Ǽ��У���������easemob��build.gradle
 * 8.���м���
 */
public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this, null);
    }
    
}
