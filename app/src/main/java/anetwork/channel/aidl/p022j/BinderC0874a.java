package anetwork.channel.aidl.p022j;

import android.os.Build;
import android.os.RemoteException;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.InterfaceC0865a;
import anetwork.channel.aidl.InterfaceC0869e;
import anetwork.channel.aidl.InterfaceC0870f;
import anetwork.channel.entity.C0899k;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p000a.p001a.C0003d;
import p000a.p001a.C0004e;
import p000a.p001a.p012s.C0035a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.a */
/* loaded from: classes.dex */
public class BinderC0874a extends InterfaceC0865a.a implements C0003d.a, C0003d.b, C0003d.d {

    /* renamed from: h */
    private BinderC0877d f1273h;

    /* renamed from: i */
    private int f1274i;

    /* renamed from: j */
    private String f1275j;

    /* renamed from: k */
    private Map<String, List<String>> f1276k;

    /* renamed from: l */
    private C0035a f1277l;

    /* renamed from: m */
    private CountDownLatch f1278m = new CountDownLatch(1);

    /* renamed from: n */
    private CountDownLatch f1279n = new CountDownLatch(1);

    /* renamed from: o */
    private InterfaceC0869e f1280o;

    /* renamed from: p */
    private C0899k f1281p;

    public BinderC0874a(int i2) {
        this.f1274i = i2;
        this.f1275j = ErrorConstant.getErrMsg(i2);
    }

    /* renamed from: a */
    public void m785a(InterfaceC0869e interfaceC0869e) {
        this.f1280o = interfaceC0869e;
    }

    @Override // anetwork.channel.aidl.InterfaceC0865a
    public void cancel() throws RemoteException {
        InterfaceC0869e interfaceC0869e = this.f1280o;
        if (interfaceC0869e != null) {
            interfaceC0869e.cancel(true);
        }
    }

    @Override // anetwork.channel.aidl.InterfaceC0865a
    /* renamed from: d */
    public String mo761d() throws RemoteException {
        m784a(this.f1278m);
        return this.f1275j;
    }

    @Override // anetwork.channel.aidl.InterfaceC0865a
    /* renamed from: e */
    public C0035a mo762e() {
        return this.f1277l;
    }

    @Override // anetwork.channel.aidl.InterfaceC0865a
    /* renamed from: f */
    public Map<String, List<String>> mo763f() throws RemoteException {
        m784a(this.f1278m);
        return this.f1276k;
    }

    @Override // anetwork.channel.aidl.InterfaceC0865a
    public int getStatusCode() throws RemoteException {
        m784a(this.f1278m);
        return this.f1274i;
    }

    @Override // anetwork.channel.aidl.InterfaceC0865a
    /* renamed from: k */
    public InterfaceC0870f mo764k() throws RemoteException {
        m784a(this.f1279n);
        return this.f1273h;
    }

    @Override // p000a.p001a.C0003d.a
    /* renamed from: a */
    public void mo4a(C0004e.a aVar, Object obj) {
        this.f1274i = aVar.mo10f();
        this.f1275j = aVar.mo8d() != null ? aVar.mo8d() : ErrorConstant.getErrMsg(this.f1274i);
        this.f1277l = aVar.mo9e();
        BinderC0877d binderC0877d = this.f1273h;
        if (binderC0877d != null) {
            binderC0877d.m787a();
        }
        this.f1279n.countDown();
        this.f1278m.countDown();
    }

    public BinderC0874a(C0899k c0899k) {
        this.f1281p = c0899k;
    }

    /* renamed from: a */
    private void m784a(CountDownLatch countDownLatch) throws RemoteException {
        try {
            if (countDownLatch.await(this.f1281p.m828b() + 1000, TimeUnit.MILLISECONDS)) {
                return;
            }
            if (this.f1280o != null) {
                this.f1280o.cancel(true);
            }
            throw m783a("wait time out");
        } catch (InterruptedException unused) {
            throw m783a("thread interrupt");
        }
    }

    /* renamed from: a */
    private RemoteException m783a(String str) {
        if (Build.VERSION.SDK_INT >= 15) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }

    @Override // p000a.p001a.C0003d.d
    /* renamed from: a */
    public boolean mo7a(int i2, Map<String, List<String>> map, Object obj) {
        this.f1274i = i2;
        this.f1275j = ErrorConstant.getErrMsg(this.f1274i);
        this.f1276k = map;
        this.f1278m.countDown();
        return false;
    }

    @Override // p000a.p001a.C0003d.b
    /* renamed from: a */
    public void mo5a(InterfaceC0870f interfaceC0870f, Object obj) {
        this.f1273h = (BinderC0877d) interfaceC0870f;
        this.f1279n.countDown();
    }
}
