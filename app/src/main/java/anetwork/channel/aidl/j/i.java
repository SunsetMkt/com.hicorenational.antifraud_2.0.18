package anetwork.channel.aidl.j;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.NetworkService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class i {
    static volatile anetwork.channel.aidl.b a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile boolean f1753b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile boolean f1754c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile CountDownLatch f1755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Handler f1756e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ServiceConnection f1757f = new j();

    public static void a(Context context, boolean z) {
        if (a == null && !f1753b) {
            a(context);
            if (f1753b || !z) {
                return;
            }
            try {
                synchronized (i.class) {
                    if (a != null) {
                        return;
                    }
                    if (f1755d == null) {
                        f1755d = new CountDownLatch(1);
                    }
                    ALog.i("anet.RemoteGetter", "[initRemoteGetterAndWait]begin to wait", null, new Object[0]);
                    if (f1755d.await(b.a.k.b.c(), TimeUnit.SECONDS)) {
                        ALog.i("anet.RemoteGetter", "mServiceBindLock count down to 0", null, new Object[0]);
                    } else {
                        ALog.i("anet.RemoteGetter", "mServiceBindLock wait timeout", null, new Object[0]);
                    }
                }
            } catch (InterruptedException unused) {
                ALog.e("anet.RemoteGetter", "mServiceBindLock wait interrupt", null, new Object[0]);
            }
        }
    }

    public static anetwork.channel.aidl.b a() {
        return a;
    }

    private static void a(Context context) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "[asyncBindService] mContext:" + context + " bBindFailed:" + f1753b + " bBinding:" + f1754c, null, new Object[0]);
        }
        if (context == null || f1753b || f1754c) {
            return;
        }
        f1754c = true;
        Intent intent = new Intent(context, (Class<?>) NetworkService.class);
        intent.setAction(anetwork.channel.aidl.b.class.getName());
        intent.addCategory("android.intent.category.DEFAULT");
        f1753b = !context.bindService(intent, f1757f, 1);
        if (f1753b) {
            f1754c = false;
            ALog.e("anet.RemoteGetter", "[asyncBindService]ANet_Service start not success. ANet run with local mode!", null, new Object[0]);
        }
        f1756e.postDelayed(new k(), com.heytap.mcssdk.constant.a.q);
    }
}
