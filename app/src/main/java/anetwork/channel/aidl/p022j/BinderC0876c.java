package anetwork.channel.aidl.p022j;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.InterfaceC0869e;
import anetwork.channel.aidl.NetworkResponse;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p000a.p001a.InterfaceC0008i;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.c */
/* loaded from: classes.dex */
public class BinderC0876c extends InterfaceC0869e.a {

    /* renamed from: h */
    private static final String f1284h = "anet.ParcelableFutureResponse";

    /* renamed from: f */
    Future<InterfaceC0008i> f1285f;

    /* renamed from: g */
    NetworkResponse f1286g;

    public BinderC0876c(Future<InterfaceC0008i> future) {
        this.f1285f = future;
    }

    @Override // anetwork.channel.aidl.InterfaceC0869e
    /* renamed from: a */
    public NetworkResponse mo769a(long j2) throws RemoteException {
        Future<InterfaceC0008i> future = this.f1285f;
        if (future == null) {
            NetworkResponse networkResponse = this.f1286g;
            return networkResponse != null ? networkResponse : new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
        try {
            return (NetworkResponse) future.get(j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            if ("NO SUPPORT".equalsIgnoreCase(e2.getMessage())) {
                ALog.m714e(f1284h, "[get]有listener将不支持future.get()方法，如有需要请listener传入null", null, e2, new Object[0]);
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0869e
    public boolean cancel(boolean z) throws RemoteException {
        Future<InterfaceC0008i> future = this.f1285f;
        if (future == null) {
            return true;
        }
        return future.cancel(z);
    }

    @Override // anetwork.channel.aidl.InterfaceC0869e
    public boolean isCancelled() throws RemoteException {
        Future<InterfaceC0008i> future = this.f1285f;
        if (future == null) {
            return true;
        }
        return future.isCancelled();
    }

    @Override // anetwork.channel.aidl.InterfaceC0869e
    public boolean isDone() throws RemoteException {
        Future<InterfaceC0008i> future = this.f1285f;
        if (future == null) {
            return true;
        }
        return future.isDone();
    }
}
