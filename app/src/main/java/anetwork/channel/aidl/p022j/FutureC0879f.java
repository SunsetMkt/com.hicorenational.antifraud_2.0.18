package anetwork.channel.aidl.p022j;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.InterfaceC0869e;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000a.p001a.InterfaceC0008i;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.f */
/* loaded from: classes.dex */
public class FutureC0879f implements Future<InterfaceC0008i> {

    /* renamed from: a */
    private InterfaceC0869e f1303a;

    /* renamed from: b */
    private InterfaceC0008i f1304b;

    public FutureC0879f(InterfaceC0869e interfaceC0869e) {
        this.f1303a = interfaceC0869e;
    }

    @Override // java.util.concurrent.Future
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC0008i get() throws InterruptedException, ExecutionException {
        InterfaceC0008i interfaceC0008i = this.f1304b;
        if (interfaceC0008i != null) {
            return interfaceC0008i;
        }
        InterfaceC0869e interfaceC0869e = this.f1303a;
        if (interfaceC0869e != null) {
            try {
                return interfaceC0869e.mo769a(20000L);
            } catch (RemoteException e2) {
                ALog.m717w("anet.FutureResponse", "[get]", null, e2, new Object[0]);
            }
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterfaceC0869e interfaceC0869e = this.f1303a;
        if (interfaceC0869e == null) {
            return false;
        }
        try {
            return interfaceC0869e.cancel(z);
        } catch (RemoteException e2) {
            ALog.m717w("anet.FutureResponse", "[cancel]", null, e2, new Object[0]);
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        try {
            return this.f1303a.isCancelled();
        } catch (RemoteException e2) {
            ALog.m717w("anet.FutureResponse", "[isCancelled]", null, e2, new Object[0]);
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        try {
            return this.f1303a.isDone();
        } catch (RemoteException e2) {
            ALog.m717w("anet.FutureResponse", "[isDone]", null, e2, new Object[0]);
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ InterfaceC0008i get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m795a(j2);
    }

    public FutureC0879f(InterfaceC0008i interfaceC0008i) {
        this.f1304b = interfaceC0008i;
    }

    /* renamed from: a */
    public InterfaceC0008i m795a(long j2) throws InterruptedException, ExecutionException, TimeoutException {
        InterfaceC0008i interfaceC0008i = this.f1304b;
        if (interfaceC0008i != null) {
            return interfaceC0008i;
        }
        InterfaceC0869e interfaceC0869e = this.f1303a;
        if (interfaceC0869e != null) {
            try {
                return interfaceC0869e.mo769a(j2);
            } catch (RemoteException e2) {
                ALog.m717w("anet.FutureResponse", "[get(long timeout, TimeUnit unit)]", null, e2, new Object[0]);
            }
        }
        return null;
    }
}
