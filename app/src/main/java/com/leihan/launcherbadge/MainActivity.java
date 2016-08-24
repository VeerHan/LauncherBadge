package com.leihan.launcherbadge;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int badgeCount;//待显示的角标数量
    private Button btnAdd, btnRemove, btnPartAdd, btnPartRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnRemove = (Button) findViewById(R.id.btn_remove);
        btnPartAdd = (Button) findViewById(R.id.btn_custom_add);
        btnPartRemove = (Button) findViewById(R.id.btn_custom_remove);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnPartAdd.setOnClickListener(this);
        btnPartRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                badgeCount = 8;
                ShortcutBadger.applyCount(this, badgeCount);
                break;
            case R.id.btn_remove:
                badgeCount = 0;
                ShortcutBadger.applyCount(this, badgeCount);
                break;
            case R.id.btn_custom_add:
                badgeCount = 8;
                if (DeviceUtil.isSpecialDevice(DeviceUtil.DEVICE_SAMSUNG)) {
                    Log.d(TAG, "DEVICE_SAMSUNG add count");
                    setSamsungBadge(this, badgeCount);
                }
                break;
            case R.id.btn_custom_remove:
                badgeCount = 0;
                if (DeviceUtil.isSpecialDevice(DeviceUtil.DEVICE_SAMSUNG)) {
                    Log.d(TAG, "DEVICE_SAMSUNG remove count");
                    setSamsungBadge(this, badgeCount);
                }
                break;
        }
    }

    /**
     * 设置三星角标
     *
     * @param context
     * @param count
     */
    public static void setSamsungBadge(Context context, int count) {
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", count);
        intent.putExtra("badge_count_package_name", context.getPackageName());
        intent.putExtra("badge_count_class_name", launcherClassName);
        context.sendBroadcast(intent);
    }

    public static String getLauncherClassName(Context context) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }
}
