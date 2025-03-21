package com.taobao.accs.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3052t;
import com.taobao.accs.utl.C3054v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MsgDistributeService extends Service {

    /* renamed from: a */
    private static boolean f9455a = false;

    /* renamed from: b */
    private Messenger f9456b = new Messenger(new HandlerC2992j(this));

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (C3052t.m9277b() && C3054v.m9284a(this) && !f9455a) {
            f9455a = true;
            try {
                getApplicationContext().bindService(new Intent(this, getClass()), new ServiceConnectionC2993k(this), 1);
            } catch (Throwable th) {
                ALog.m9181e("MsgDistributeService", "bindService", th, new Object[0]);
                f9455a = false;
            }
        }
        return this.f9456b.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        try {
            ALog.m9183i("MsgDistributeService", "onStartCommand", "action", intent.getAction());
            if (TextUtils.isEmpty(intent.getAction()) || !TextUtils.equals(intent.getAction(), Constants.ACTION_SEND)) {
                ALog.m9183i("MsgDistributeService", "onStartCommand distribute message", new Object[0]);
                intent.setFlags(0);
                C2989g.m9042a(getApplicationContext(), intent);
            } else {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(new RunnableC2994l(this, intent));
            }
        } catch (Throwable th) {
            ALog.m9181e("MsgDistributeService", "onStartCommand", th, new Object[0]);
        }
        return 2;
    }
}
