package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.AbstractC3001a;
import com.taobao.accs.net.C3022v;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3054v;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.internal.d */
/* loaded from: classes2.dex */
public abstract class AbstractC2999d implements IBaseService {

    /* renamed from: a */
    protected static ConcurrentHashMap<String, AbstractC3001a> f9515a = new ConcurrentHashMap<>(2);

    /* renamed from: b */
    private Context f9516b;

    /* renamed from: c */
    private Service f9517c;

    public AbstractC2999d(Service service2) {
        this.f9517c = null;
        this.f9517c = service2;
        this.f9516b = service2.getApplicationContext();
    }

    /* renamed from: a */
    protected static AbstractC3001a m9078a(Context context, String str, boolean z) {
        AbstractC3001a abstractC3001a = null;
        try {
        } catch (Throwable th) {
            ALog.m9181e("ElectionServiceImpl", "getConnection", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.m9186w("ElectionServiceImpl", "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(f9515a.size()));
            if (f9515a.size() > 0) {
                return f9515a.elements().nextElement();
            }
            return null;
        }
        ALog.m9183i("ElectionServiceImpl", "getConnection", Constants.KEY_CONFIG_TAG, str, "start", Boolean.valueOf(z));
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.getDisableChannel()) {
            ALog.m9182e("ElectionServiceImpl", "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
            return null;
        }
        int m9286b = C3054v.m9286b(context);
        String str2 = str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + m9286b;
        synchronized (AbstractC2999d.class) {
            try {
                AbstractC3001a abstractC3001a2 = f9515a.get(str2);
                if (abstractC3001a2 == null) {
                    try {
                        AccsClientConfig.mEnv = m9286b;
                        abstractC3001a = new C3022v(context, 0, str);
                        f9515a.put(str2, abstractC3001a);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    abstractC3001a = abstractC3001a2;
                }
                if (z) {
                    abstractC3001a.mo9082a();
                }
                return abstractC3001a;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: b */
    private void m9080b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra("appKey");
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent.getIntExtra(Constants.KEY_MODE, 0);
            ALog.m9183i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, C2085b.f6156A, stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && stringExtra.equals(this.f9516b.getPackageName())) {
                C3054v.m9283a(this.f9516b, intExtra);
                AbstractC3001a m9078a = m9078a(this.f9516b, stringExtra5, false);
                if (m9078a != null) {
                    m9078a.f9521a = stringExtra3;
                } else {
                    ALog.m9182e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
                }
            }
        } catch (Throwable th) {
            ALog.m9181e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public abstract int mo9075a(Intent intent);

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.m9183i("ElectionServiceImpl", "onCreate,", "sdkVersion", 221);
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.m9182e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.f9516b = null;
        this.f9517c = null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.m9183i("ElectionServiceImpl", "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            m9080b(intent);
        }
        return mo9075a(intent);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    /* renamed from: b */
    protected static AbstractC3001a m9079b(Context context, String str, boolean z) {
        return m9078a(context, str, z);
    }
}
