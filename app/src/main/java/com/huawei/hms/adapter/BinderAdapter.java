package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: classes.dex */
public class BinderAdapter implements ServiceConnection {

    /* renamed from: a */
    private final Context f7067a;

    /* renamed from: b */
    private final String f7068b;

    /* renamed from: c */
    private final String f7069c;

    /* renamed from: d */
    private BinderCallBack f7070d;

    /* renamed from: e */
    private IBinder f7071e;

    /* renamed from: f */
    private final Object f7072f = new Object();

    /* renamed from: g */
    private boolean f7073g = false;

    /* renamed from: h */
    private Handler f7074h = null;

    /* renamed from: i */
    private Handler f7075i = null;

    public interface BinderCallBack {
        void onBinderFailed(int i2);

        void onBinderFailed(int i2, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f7067a = context;
        this.f7068b = str;
        this.f7069c = str2;
    }

    /* renamed from: c */
    private void m6586c() {
        synchronized (this.f7072f) {
            Handler handler = this.f7074h;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.f7074h = null;
            }
        }
    }

    /* renamed from: d */
    private void m6587d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.m7717i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack m6589f = BinderAdapter.this.m6589f();
                if (m6589f == null) {
                    return true;
                }
                m6589f.onTimedDisconnected();
                return true;
            }
        });
        this.f7075i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    /* renamed from: e */
    private void m6588e() {
        HMSLog.m7715e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f7067a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack m6589f = m6589f();
            if (m6589f != null) {
                m6589f.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e2) {
            HMSLog.m7715e("BinderAdapter", "getBindFailPendingIntent failed " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public BinderCallBack m6589f() {
        return this.f7070d;
    }

    /* renamed from: g */
    private void m6590g() {
        Handler handler = this.f7074h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f7074h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.m7715e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.m6585b();
                    return true;
                }
            });
        }
        this.f7074h.sendEmptyMessageDelayed(getConnTimeOut(), C2084a.f6135q);
    }

    /* renamed from: h */
    private void m6591h() {
        HMSLog.m7712d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f7075i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.f7070d = binderCallBack;
        m6582a();
    }

    protected int getConnTimeOut() {
        return 0;
    }

    protected int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f7068b;
    }

    public IBinder getServiceBinder() {
        return this.f7071e;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.m7715e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f7073g) {
            this.f7073g = false;
            return;
        }
        unBind();
        m6586c();
        BinderCallBack m6589f = m6589f();
        if (m6589f != null) {
            m6589f.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m7717i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f7071e = iBinder;
        m6586c();
        BinderCallBack m6589f = m6589f();
        if (m6589f != null) {
            m6589f.onServiceConnected(componentName, iBinder);
        }
        m6587d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m7717i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack m6589f = m6589f();
        if (m6589f != null) {
            m6589f.onServiceDisconnected(componentName);
        }
        m6591h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f7067a, this);
    }

    public void updateDelayTask() {
        HMSLog.m7712d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f7075i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.f7075i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
            }
        }
    }

    /* renamed from: a */
    private void m6582a() {
        if (TextUtils.isEmpty(this.f7068b) || TextUtils.isEmpty(this.f7069c)) {
            m6588e();
        }
        Intent intent = new Intent(this.f7068b);
        try {
            intent.setPackage(this.f7069c);
        } catch (IllegalArgumentException unused) {
            HMSLog.m7715e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            m6588e();
        }
        synchronized (this.f7072f) {
            if (this.f7067a.bindService(intent, this, 1)) {
                m6590g();
            } else {
                this.f7073g = true;
                m6588e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6585b() {
        BinderCallBack m6589f = m6589f();
        if (m6589f != null) {
            m6589f.onBinderFailed(-1);
        }
    }
}
