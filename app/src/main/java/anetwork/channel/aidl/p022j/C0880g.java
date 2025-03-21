package anetwork.channel.aidl.p022j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.fulltrace.C0785a;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.InterfaceC0865a;
import anetwork.channel.aidl.InterfaceC0866b;
import anetwork.channel.aidl.InterfaceC0872h;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.concurrent.Future;
import p000a.p001a.InterfaceC0002c;
import p000a.p001a.InterfaceC0005f;
import p000a.p001a.InterfaceC0007h;
import p000a.p001a.InterfaceC0008i;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p005m.BinderC0020b;
import p000a.p001a.p007o.BinderC0024b;
import p000a.p001a.p014u.C0052a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.g */
/* loaded from: classes.dex */
public class C0880g implements InterfaceC0002c {

    /* renamed from: d */
    protected static String f1305d = "anet.NetworkProxy";

    /* renamed from: e */
    protected static final int f1306e = 0;

    /* renamed from: f */
    protected static final int f1307f = 1;

    /* renamed from: a */
    private volatile InterfaceC0872h f1308a = null;

    /* renamed from: b */
    private int f1309b;

    /* renamed from: c */
    private Context f1310c;

    public C0880g(Context context, int i2) {
        this.f1309b = 0;
        this.f1310c = context;
        this.f1309b = i2;
    }

    @Override // p000a.p001a.InterfaceC0002c
    /* renamed from: a */
    public InterfaceC0008i mo1a(InterfaceC0007h interfaceC0007h, Object obj) {
        ALog.m716i(f1305d, "networkProxy syncSend", interfaceC0007h.mo48l(), new Object[0]);
        m797a(interfaceC0007h);
        m799a(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(interfaceC0007h);
        if (parcelableRequest.f1219d == null) {
            return new NetworkResponse(-102);
        }
        try {
            return this.f1308a.mo175a(parcelableRequest);
        } catch (Throwable th) {
            m798a(th, "[syncSend]call syncSend method failed.");
            return new NetworkResponse(-103);
        }
    }

    @Override // p000a.p001a.InterfaceC0002c
    /* renamed from: b */
    public InterfaceC0865a mo3b(InterfaceC0007h interfaceC0007h, Object obj) {
        ALog.m716i(f1305d, "networkProxy getConnection", interfaceC0007h.mo48l(), new Object[0]);
        m797a(interfaceC0007h);
        m799a(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(interfaceC0007h);
        if (parcelableRequest.f1219d == null) {
            return new BinderC0874a(-102);
        }
        try {
            return this.f1308a.mo177b(parcelableRequest);
        } catch (Throwable th) {
            m798a(th, "[getConnection]call getConnection method failed.");
            return new BinderC0874a(-103);
        }
    }

    /* renamed from: a */
    private void m799a(boolean z) {
        if (this.f1308a != null) {
            return;
        }
        if (C0014b.m106n()) {
            boolean isTargetProcess = GlobalAppRuntimeInfo.isTargetProcess();
            if (C0014b.m94h() && isTargetProcess) {
                C0882i.m802a(this.f1310c, false);
                if (C0882i.f1316c && this.f1308a == null) {
                    this.f1308a = this.f1309b == 1 ? new BinderC0020b(this.f1310c) : new BinderC0024b(this.f1310c);
                    ALog.m716i(f1305d, "[initDelegateInstance] getNetworkInstance when binding service", null, new Object[0]);
                    return;
                } else {
                    m796a(this.f1309b);
                    if (this.f1308a != null) {
                        return;
                    }
                }
            } else {
                C0882i.m802a(this.f1310c, z);
                m796a(this.f1309b);
                if (this.f1308a != null) {
                    return;
                }
            }
            if (C0014b.m90f() && isTargetProcess && C0882i.f1315b) {
                synchronized (this) {
                    if (this.f1308a == null) {
                        this.f1308a = this.f1309b == 1 ? new BinderC0020b(this.f1310c) : new BinderC0024b(this.f1310c);
                        ALog.m715e(f1305d, "[initDelegateInstance] getNetworkInstance when bindService failed.", null, new Object[0]);
                        return;
                    }
                }
            }
        }
        synchronized (this) {
            if (this.f1308a == null) {
                if (ALog.isPrintLog(2)) {
                    ALog.m716i(f1305d, "[getLocalNetworkInstance]", null, new Object[0]);
                }
                this.f1308a = new BinderC0024b(this.f1310c);
            }
        }
    }

    @Override // p000a.p001a.InterfaceC0002c
    /* renamed from: a */
    public Future<InterfaceC0008i> mo2a(InterfaceC0007h interfaceC0007h, Object obj, Handler handler, InterfaceC0005f interfaceC0005f) {
        ALog.m716i(f1305d, "networkProxy asyncSend", interfaceC0007h.mo48l(), new Object[0]);
        m797a(interfaceC0007h);
        m799a(Looper.myLooper() != Looper.getMainLooper());
        ParcelableRequest parcelableRequest = new ParcelableRequest(interfaceC0007h);
        BinderC0878e binderC0878e = (interfaceC0005f == null && handler == null) ? null : new BinderC0878e(interfaceC0005f, handler, obj);
        if (parcelableRequest.f1219d == null) {
            if (binderC0878e != null) {
                try {
                    binderC0878e.mo774a(new DefaultFinishEvent(-102));
                } catch (RemoteException unused) {
                }
            }
            return new FutureC0879f(new NetworkResponse(-102));
        }
        try {
            return new FutureC0879f(this.f1308a.mo176a(parcelableRequest, binderC0878e));
        } catch (Throwable th) {
            if (binderC0878e != null) {
                try {
                    binderC0878e.mo774a(new DefaultFinishEvent(-102));
                } catch (RemoteException unused2) {
                }
            }
            m798a(th, "[asyncSend]call asyncSend exception");
            return new FutureC0879f(new NetworkResponse(-103));
        }
    }

    /* renamed from: a */
    private synchronized void m796a(int i2) {
        if (this.f1308a != null) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.m716i(f1305d, "[tryGetRemoteNetworkInstance] type=" + i2, null, new Object[0]);
        }
        InterfaceC0866b m800a = C0882i.m800a();
        if (m800a != null) {
            try {
                this.f1308a = m800a.get(i2);
            } catch (Throwable th) {
                m798a(th, "[tryGetRemoteNetworkInstance]get RemoteNetwork Delegate failed.");
            }
        }
    }

    /* renamed from: a */
    private void m798a(Throwable th, String str) {
        ALog.m714e(f1305d, null, str, th, new Object[0]);
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(-103, null, "rt");
        exceptionStatistic.exceptionStack = th.toString();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }

    /* renamed from: a */
    private void m797a(InterfaceC0007h interfaceC0007h) {
        if (interfaceC0007h == null) {
            return;
        }
        interfaceC0007h.mo22a(C0052a.f163o, String.valueOf(System.currentTimeMillis()));
        String mo42f = interfaceC0007h.mo42f(C0052a.f164p);
        if (TextUtils.isEmpty(mo42f)) {
            mo42f = C0785a.m516a().createRequest();
        }
        interfaceC0007h.mo22a(C0052a.f164p, mo42f);
        interfaceC0007h.mo22a(C0052a.f165q, GlobalAppRuntimeInfo.getCurrentProcess());
    }
}
