package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.util.ALog;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class f implements Future<b.a.i> {
    private anetwork.channel.aidl.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.a.i f1745b;

    public f(anetwork.channel.aidl.e eVar) {
        this.a = eVar;
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b.a.i get() throws ExecutionException, InterruptedException {
        b.a.i iVar = this.f1745b;
        if (iVar != null) {
            return iVar;
        }
        anetwork.channel.aidl.e eVar = this.a;
        if (eVar != null) {
            try {
                return eVar.a(20000L);
            } catch (RemoteException e2) {
                ALog.w("anet.FutureResponse", "[get]", null, e2, new Object[0]);
            }
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        anetwork.channel.aidl.e eVar = this.a;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.cancel(z);
        } catch (RemoteException e2) {
            ALog.w("anet.FutureResponse", "[cancel]", null, e2, new Object[0]);
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        try {
            return this.a.isCancelled();
        } catch (RemoteException e2) {
            ALog.w("anet.FutureResponse", "[isCancelled]", null, e2, new Object[0]);
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        try {
            return this.a.isDone();
        } catch (RemoteException e2) {
            ALog.w("anet.FutureResponse", "[isDone]", null, e2, new Object[0]);
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ b.a.i get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(j2);
    }

    public f(b.a.i iVar) {
        this.f1745b = iVar;
    }

    public b.a.i a(long j2) throws ExecutionException, InterruptedException, TimeoutException {
        b.a.i iVar = this.f1745b;
        if (iVar != null) {
            return iVar;
        }
        anetwork.channel.aidl.e eVar = this.a;
        if (eVar != null) {
            try {
                return eVar.a(j2);
            } catch (RemoteException e2) {
                ALog.w("anet.FutureResponse", "[get(long timeout, TimeUnit unit)]", null, e2, new Object[0]);
            }
        }
        return null;
    }
}
