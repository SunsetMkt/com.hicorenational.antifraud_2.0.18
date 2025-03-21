package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class BaseActivity extends Activity {
    private boolean h() {
        Method method;
        boolean booleanValue;
        boolean z = false;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            method.setAccessible(false);
            return booleanValue;
        } catch (Exception e3) {
            z = booleanValue;
            e = e3;
            e.printStackTrace();
            return z;
        }
    }

    private boolean i() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && h()) {
            i();
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (Build.VERSION.SDK_INT == 26 && h()) {
            return;
        }
        super.setRequestedOrientation(i2);
    }
}
