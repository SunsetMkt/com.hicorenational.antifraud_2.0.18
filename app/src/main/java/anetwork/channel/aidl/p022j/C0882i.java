package anetwork.channel.aidl.p022j;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.InterfaceC0866b;
import anetwork.channel.aidl.NetworkService;
import com.heytap.mcssdk.constant.C2084a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p003k.C0014b;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.i */
/* loaded from: classes.dex */
public class C0882i {

    /* renamed from: a */
    static volatile InterfaceC0866b f1314a = null;

    /* renamed from: b */
    static volatile boolean f1315b = false;

    /* renamed from: c */
    static volatile boolean f1316c = false;

    /* renamed from: d */
    static volatile CountDownLatch f1317d;

    /* renamed from: e */
    static Handler f1318e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private static ServiceConnection f1319f = new ServiceConnectionC0883j();

    /* renamed from: a */
    public static void m802a(Context context, boolean z) {
        if (f1314a == null && !f1315b) {
            m801a(context);
            if (f1315b || !z) {
                return;
            }
            try {
                synchronized (C0882i.class) {
                    if (f1314a != null) {
                        return;
                    }
                    if (f1317d == null) {
                        f1317d = new CountDownLatch(1);
                    }
                    ALog.m716i("anet.RemoteGetter", "[initRemoteGetterAndWait]begin to wait", null, new Object[0]);
                    if (f1317d.await(C0014b.m78c(), TimeUnit.SECONDS)) {
                        ALog.m716i("anet.RemoteGetter", "mServiceBindLock count down to 0", null, new Object[0]);
                    } else {
                        ALog.m716i("anet.RemoteGetter", "mServiceBindLock wait timeout", null, new Object[0]);
                    }
                }
            } catch (InterruptedException unused) {
                ALog.m715e("anet.RemoteGetter", "mServiceBindLock wait interrupt", null, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC0866b m800a() {
        return f1314a;
    }

    /* renamed from: a */
    private static void m801a(Context context) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.RemoteGetter", "[asyncBindService] mContext:" + context + " bBindFailed:" + f1315b + " bBinding:" + f1316c, null, new Object[0]);
        }
        if (context == null || f1315b || f1316c) {
            return;
        }
        f1316c = true;
        Intent intent = new Intent(context, (Class<?>) NetworkService.class);
        intent.setAction(InterfaceC0866b.class.getName());
        intent.addCategory("android.intent.category.DEFAULT");
        f1315b = !context.bindService(intent, f1319f, 1);
        if (f1315b) {
            f1316c = false;
            ALog.m715e("anet.RemoteGetter", "[asyncBindService]ANet_Service start not success. ANet run with local mode!", null, new Object[0]);
        }
        f1318e.postDelayed(new RunnableC0884k(), C2084a.f6135q);
    }
}
