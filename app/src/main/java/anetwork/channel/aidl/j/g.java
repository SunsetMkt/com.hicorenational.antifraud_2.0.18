package anetwork.channel.aidl.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class g implements b.a.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static String f1746d = "anet.NetworkProxy";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int f1747e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final int f1748f = 1;
    private volatile anetwork.channel.aidl.h a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f1750c;

    public g(Context context, int i2) {
        this.f1749b = 0;
        this.f1750c = context;
        this.f1749b = i2;
    }

    @Override // b.a.c
    public b.a.i a(b.a.h hVar, Object obj) {
        ALog.i(f1746d, "networkProxy syncSend", hVar.l(), new Object[0]);
        a(hVar);
        a(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(hVar);
        if (parcelableRequest.f1682d == null) {
            return new NetworkResponse(-102);
        }
        try {
            return this.a.a(parcelableRequest);
        } catch (Throwable th) {
            a(th, "[syncSend]call syncSend method failed.");
            return new NetworkResponse(-103);
        }
    }

    @Override // b.a.c
    public anetwork.channel.aidl.a b(b.a.h hVar, Object obj) {
        ALog.i(f1746d, "networkProxy getConnection", hVar.l(), new Object[0]);
        a(hVar);
        a(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(hVar);
        if (parcelableRequest.f1682d == null) {
            return new a(-102);
        }
        try {
            return this.a.b(parcelableRequest);
        } catch (Throwable th) {
            a(th, "[getConnection]call getConnection method failed.");
            return new a(-103);
        }
    }

    private void a(boolean z) {
        if (this.a != null) {
            return;
        }
        if (b.a.k.b.n()) {
            boolean zIsTargetProcess = GlobalAppRuntimeInfo.isTargetProcess();
            if (b.a.k.b.h() && zIsTargetProcess) {
                i.a(this.f1750c, false);
                if (i.f1754c && this.a == null) {
                    this.a = this.f1749b == 1 ? new b.a.m.b(this.f1750c) : new b.a.o.b(this.f1750c);
                    ALog.i(f1746d, "[initDelegateInstance] getNetworkInstance when binding service", null, new Object[0]);
                    return;
                } else {
                    a(this.f1749b);
                    if (this.a != null) {
                        return;
                    }
                }
            } else {
                i.a(this.f1750c, z);
                a(this.f1749b);
                if (this.a != null) {
                    return;
                }
            }
            if (b.a.k.b.f() && zIsTargetProcess && i.f1753b) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = this.f1749b == 1 ? new b.a.m.b(this.f1750c) : new b.a.o.b(this.f1750c);
                        ALog.e(f1746d, "[initDelegateInstance] getNetworkInstance when bindService failed.", null, new Object[0]);
                        return;
                    }
                }
            }
        }
        synchronized (this) {
            if (this.a == null) {
                if (ALog.isPrintLog(2)) {
                    ALog.i(f1746d, "[getLocalNetworkInstance]", null, new Object[0]);
                }
                this.a = new b.a.o.b(this.f1750c);
            }
        }
    }

    @Override // b.a.c
    public Future<b.a.i> a(b.a.h hVar, Object obj, Handler handler, b.a.f fVar) {
        ALog.i(f1746d, "networkProxy asyncSend", hVar.l(), new Object[0]);
        a(hVar);
        a(Looper.myLooper() != Looper.getMainLooper());
        ParcelableRequest parcelableRequest = new ParcelableRequest(hVar);
        e eVar = (fVar == null && handler == null) ? null : new e(fVar, handler, obj);
        if (parcelableRequest.f1682d == null) {
            if (eVar != null) {
                try {
                    eVar.a(new DefaultFinishEvent(-102));
                } catch (RemoteException unused) {
                }
            }
            return new f(new NetworkResponse(-102));
        }
        try {
            return new f(this.a.a(parcelableRequest, eVar));
        } catch (Throwable th) {
            if (eVar != null) {
                try {
                    eVar.a(new DefaultFinishEvent(-102));
                } catch (RemoteException unused2) {
                }
            }
            a(th, "[asyncSend]call asyncSend exception");
            return new f(new NetworkResponse(-103));
        }
    }

    private synchronized void a(int i2) {
        if (this.a != null) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i(f1746d, "[tryGetRemoteNetworkInstance] type=" + i2, null, new Object[0]);
        }
        anetwork.channel.aidl.b bVarA = i.a();
        if (bVarA != null) {
            try {
                this.a = bVarA.get(i2);
            } catch (Throwable th) {
                a(th, "[tryGetRemoteNetworkInstance]get RemoteNetwork Delegate failed.");
            }
        }
    }

    private void a(Throwable th, String str) {
        ALog.e(f1746d, null, str, th, new Object[0]);
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(-103, null, "rt");
        exceptionStatistic.exceptionStack = th.toString();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    private void a(b.a.h hVar) {
        if (hVar == null) {
            return;
        }
        hVar.a(b.a.u.a.o, String.valueOf(System.currentTimeMillis()));
        String strF = hVar.f(b.a.u.a.p);
        if (TextUtils.isEmpty(strF)) {
            strF = anet.channel.fulltrace.a.a().createRequest();
        }
        hVar.a(b.a.u.a.p, strF);
        hVar.a(b.a.u.a.q, GlobalAppRuntimeInfo.getCurrentProcess());
    }
}
