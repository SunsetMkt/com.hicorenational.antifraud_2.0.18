package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.e;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c extends e.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f1731h = "anet.ParcelableFutureResponse";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Future<b.a.i> f1732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    NetworkResponse f1733g;

    public c(Future<b.a.i> future) {
        this.f1732f = future;
    }

    @Override // anetwork.channel.aidl.e
    public NetworkResponse a(long j2) throws RemoteException {
        Future<b.a.i> future = this.f1732f;
        if (future == null) {
            NetworkResponse networkResponse = this.f1733g;
            return networkResponse != null ? networkResponse : new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
        try {
            return (NetworkResponse) future.get(j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            if ("NO SUPPORT".equalsIgnoreCase(e2.getMessage())) {
                ALog.e(f1731h, "[get]\u6709listener\u5c06\u4e0d\u652f\u6301future.get()\u65b9\u6cd5\uff0c\u5982\u6709\u9700\u8981\u8bf7listener\u4f20\u5165null", null, e2, new Object[0]);
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
    }

    @Override // anetwork.channel.aidl.e
    public boolean cancel(boolean z) throws RemoteException {
        Future<b.a.i> future = this.f1732f;
        if (future == null) {
            return true;
        }
        return future.cancel(z);
    }

    @Override // anetwork.channel.aidl.e
    public boolean isCancelled() throws RemoteException {
        Future<b.a.i> future = this.f1732f;
        if (future == null) {
            return true;
        }
        return future.isCancelled();
    }

    @Override // anetwork.channel.aidl.e
    public boolean isDone() throws RemoteException {
        Future<b.a.i> future = this.f1732f;
        if (future == null) {
            return true;
        }
        return future.isDone();
    }
}
