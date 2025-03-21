package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.InterfaceC0871g;
import anetwork.channel.aidl.p022j.BinderC0877d;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.i */
/* loaded from: classes.dex */
class RunnableC0897i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1351a;

    /* renamed from: b */
    final /* synthetic */ ByteArray f1352b;

    /* renamed from: c */
    final /* synthetic */ int f1353c;

    /* renamed from: d */
    final /* synthetic */ InterfaceC0871g f1354d;

    /* renamed from: e */
    final /* synthetic */ C0895g f1355e;

    RunnableC0897i(C0895g c0895g, int i2, ByteArray byteArray, int i3, InterfaceC0871g interfaceC0871g) {
        this.f1355e = c0895g;
        this.f1351a = i2;
        this.f1352b = byteArray;
        this.f1353c = i3;
        this.f1354d = interfaceC0871g;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        BinderC0877d binderC0877d;
        BinderC0877d binderC0877d2;
        BinderC0877d binderC0877d3;
        BinderC0877d binderC0877d4;
        BinderC0877d binderC0877d5;
        C0899k c0899k;
        BinderC0877d binderC0877d6;
        BinderC0877d binderC0877d7;
        z = this.f1355e.f1345d;
        try {
            if (z) {
                try {
                    binderC0877d3 = this.f1355e.f1344c;
                    if (binderC0877d3 == null) {
                        this.f1355e.f1344c = new BinderC0877d();
                        binderC0877d5 = this.f1355e.f1344c;
                        c0899k = this.f1355e.f1346e;
                        binderC0877d5.m789a(c0899k, this.f1353c);
                        binderC0877d6 = this.f1355e.f1344c;
                        binderC0877d6.m788a(this.f1352b);
                        InterfaceC0871g interfaceC0871g = this.f1354d;
                        binderC0877d7 = this.f1355e.f1344c;
                        interfaceC0871g.mo776a(binderC0877d7);
                    } else {
                        binderC0877d4 = this.f1355e.f1344c;
                        binderC0877d4.m788a(this.f1352b);
                    }
                } catch (Exception unused) {
                    binderC0877d = this.f1355e.f1344c;
                    if (binderC0877d == null) {
                        return;
                    }
                    binderC0877d2 = this.f1355e.f1344c;
                    binderC0877d2.close();
                }
            } else {
                this.f1354d.mo775a(new DefaultProgressEvent(this.f1351a, this.f1352b.getDataLength(), this.f1353c, this.f1352b.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
