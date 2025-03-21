package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.InterfaceC0871g;
import anetwork.channel.aidl.p022j.BinderC0877d;
import java.util.List;
import java.util.Map;
import p000a.p001a.p008p.InterfaceC0026a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.g */
/* loaded from: classes.dex */
public class C0895g implements InterfaceC0026a {

    /* renamed from: a */
    private InterfaceC0871g f1342a;

    /* renamed from: b */
    private String f1343b;

    /* renamed from: c */
    private BinderC0877d f1344c = null;

    /* renamed from: d */
    private boolean f1345d;

    /* renamed from: e */
    private C0899k f1346e;

    public C0895g(InterfaceC0871g interfaceC0871g, C0899k c0899k) {
        this.f1345d = false;
        this.f1346e = null;
        this.f1342a = interfaceC0871g;
        this.f1346e = c0899k;
        if (interfaceC0871g != null) {
            try {
                if ((interfaceC0871g.mo778j() & 8) != 0) {
                    this.f1345d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // p000a.p001a.p008p.InterfaceC0026a
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.Repeater", "[onResponseCode]", this.f1343b, new Object[0]);
        }
        InterfaceC0871g interfaceC0871g = this.f1342a;
        if (interfaceC0871g != null) {
            m815a(new RunnableC0896h(this, interfaceC0871g, i2, map));
        }
    }

    @Override // p000a.p001a.p008p.InterfaceC0026a
    /* renamed from: a */
    public void mo150a(int i2, int i3, ByteArray byteArray) {
        InterfaceC0871g interfaceC0871g = this.f1342a;
        if (interfaceC0871g != null) {
            m815a(new RunnableC0897i(this, i2, byteArray, i3, interfaceC0871g));
        }
    }

    @Override // p000a.p001a.p008p.InterfaceC0026a
    /* renamed from: a */
    public void mo151a(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.Repeater", "[onFinish] ", this.f1343b, new Object[0]);
        }
        InterfaceC0871g interfaceC0871g = this.f1342a;
        if (interfaceC0871g != null) {
            RunnableC0898j runnableC0898j = new RunnableC0898j(this, defaultFinishEvent, interfaceC0871g);
            RequestStatistic requestStatistic = defaultFinishEvent.f1196e;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
            }
            m815a(runnableC0898j);
        }
        this.f1342a = null;
    }

    /* renamed from: a */
    private void m815a(Runnable runnable) {
        if (this.f1346e.m829c()) {
            runnable.run();
        } else {
            String str = this.f1343b;
            C0893e.m813a(str != null ? str.hashCode() : hashCode(), runnable);
        }
    }

    /* renamed from: a */
    public void m820a(String str) {
        this.f1343b = str;
    }
}
