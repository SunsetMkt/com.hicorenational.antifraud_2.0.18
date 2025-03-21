package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.q */
/* loaded from: classes2.dex */
public class C3049q {
    public static final int MAX_FAIL_TIMES = 3;

    /* renamed from: a */
    public static void m9264a() {
        try {
            int m9266c = m9266c();
            if (m9266c > 0) {
                SharedPreferences.Editor edit = GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_LOAD_SO_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
                ALog.m9183i("LoadSoFailUtil", "loadSoSuccess", "fail times", Integer.valueOf(m9266c));
            }
        } catch (Throwable th) {
            ALog.m9181e("LoadSoFailUtil", "loadSoSuccess", th, new Object[0]);
        }
    }

    /* renamed from: b */
    public static void m9265b() {
        try {
            Context context = GlobalClientInfo.getContext();
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_LOAD_SO_FILE_NAME, 0);
            int i2 = sharedPreferences.getInt(Constants.SP_KEY_LOAD_SO_TIMES, 0) + 1;
            if (i2 > 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(Constants.SP_KEY_LOAD_SO_TIMES, i2);
                edit.apply();
            }
            ALog.m9182e("LoadSoFailUtil", "loadSoFail", Constants.KEY_TIMES, Integer.valueOf(i2));
            if (Build.VERSION.SDK_INT == 15) {
                UtilityImpl.killService(context);
            }
        } catch (Throwable th) {
            ALog.m9181e("LoadSoFailUtil", "loadSoFail", th, new Object[0]);
        }
    }

    /* renamed from: c */
    public static int m9266c() {
        int i2;
        try {
            i2 = GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_LOAD_SO_FILE_NAME, 0).getInt(Constants.SP_KEY_LOAD_SO_TIMES, 0);
        } catch (Throwable th) {
            th = th;
            i2 = 0;
        }
        try {
            ALog.m9183i("LoadSoFailUtil", "getSoFailTimes", Constants.KEY_TIMES, Integer.valueOf(i2));
        } catch (Throwable th2) {
            th = th2;
            ALog.m9181e("LoadSoFailUtil", "getSoFailTimes", th, new Object[0]);
            return i2;
        }
        return i2;
    }
}
