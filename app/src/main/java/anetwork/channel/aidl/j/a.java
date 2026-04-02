package anetwork.channel.aidl.j;

import android.os.Build;
import android.os.RemoteException;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.a;
import b.a.d;
import b.a.e;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a extends a.AbstractBinderC0013a implements d.a, d.b, d.InterfaceC0021d {

    /* JADX INFO: renamed from: h */
    private d f1722h;

    /* JADX INFO: renamed from: i */
    private int f1723i;

    /* JADX INFO: renamed from: j */
    private String f1724j;

    /* JADX INFO: renamed from: k */
    private Map<String, List<String>> f1725k;

    /* JADX INFO: renamed from: l */
    private b.a.s.a f1726l;

    /* JADX INFO: renamed from: m */
    private CountDownLatch f1727m = new CountDownLatch(1);

    /* JADX INFO: renamed from: n */
    private CountDownLatch f1728n = new CountDownLatch(1);
    private anetwork.channel.aidl.e o;
    private anetwork.channel.entity.k p;

    public a(int i2) {
        this.f1723i = i2;
        this.f1724j = ErrorConstant.getErrMsg(i2);
    }

    public void a(anetwork.channel.aidl.e eVar) {
        this.o = eVar;
    }

    @Override // anetwork.channel.aidl.a
    public void cancel() throws RemoteException {
        anetwork.channel.aidl.e eVar = this.o;
        if (eVar != null) {
            eVar.cancel(true);
        }
    }

    @Override // anetwork.channel.aidl.a
    public String d() throws RemoteException {
        a(this.f1727m);
        return this.f1724j;
    }

    @Override // anetwork.channel.aidl.a
    public b.a.s.a e() {
        return this.f1726l;
    }

    @Override // anetwork.channel.aidl.a
    public Map<String, List<String>> f() throws RemoteException {
        a(this.f1727m);
        return this.f1725k;
    }

    @Override // anetwork.channel.aidl.a
    public int getStatusCode() throws RemoteException {
        a(this.f1727m);
        return this.f1723i;
    }

    @Override // anetwork.channel.aidl.a
    public anetwork.channel.aidl.f k() throws RemoteException {
        a(this.f1728n);
        return this.f1722h;
    }

    @Override // b.a.d.a
    public void a(e.a aVar, Object obj) {
        this.f1723i = aVar.f();
        this.f1724j = aVar.d() != null ? aVar.d() : ErrorConstant.getErrMsg(this.f1723i);
        this.f1726l = aVar.e();
        d dVar = this.f1722h;
        if (dVar != null) {
            dVar.a();
        }
        this.f1728n.countDown();
        this.f1727m.countDown();
    }

    public a(anetwork.channel.entity.k kVar) {
        this.p = kVar;
    }

    private void a(CountDownLatch countDownLatch) throws RemoteException {
        try {
            if (countDownLatch.await(this.p.b() + 1000, TimeUnit.MILLISECONDS)) {
                return;
            }
            if (this.o != null) {
                this.o.cancel(true);
            }
            throw a("wait time out");
        } catch (InterruptedException unused) {
            throw a("thread interrupt");
        }
    }

    private RemoteException a(String str) {
        if (Build.VERSION.SDK_INT >= 15) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }

    @Override // b.a.d.InterfaceC0021d
    public boolean a(int i2, Map<String, List<String>> map, Object obj) {
        this.f1723i = i2;
        this.f1724j = ErrorConstant.getErrMsg(this.f1723i);
        this.f1725k = map;
        this.f1727m.countDown();
        return false;
    }

    @Override // b.a.d.b
    public void a(anetwork.channel.aidl.f fVar, Object obj) {
        this.f1722h = (d) fVar;
        this.f1728n.countDown();
    }
}
