package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2213a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ByteArray f2214b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f2215c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f2216d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ g f2217e;

    i(g gVar, int i2, ByteArray byteArray, int i3, anetwork.channel.aidl.g gVar2) {
        this.f2217e = gVar;
        this.f2213a = i2;
        this.f2214b = byteArray;
        this.f2215c = i3;
        this.f2216d = gVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        anetwork.channel.aidl.j.d dVar;
        anetwork.channel.aidl.j.d dVar2;
        anetwork.channel.aidl.j.d dVar3;
        anetwork.channel.aidl.j.d dVar4;
        anetwork.channel.aidl.j.d dVar5;
        k kVar;
        anetwork.channel.aidl.j.d dVar6;
        anetwork.channel.aidl.j.d dVar7;
        z = this.f2217e.f2207d;
        try {
            if (z) {
                try {
                    dVar3 = this.f2217e.f2206c;
                    if (dVar3 == null) {
                        this.f2217e.f2206c = new anetwork.channel.aidl.j.d();
                        dVar5 = this.f2217e.f2206c;
                        kVar = this.f2217e.f2208e;
                        dVar5.a(kVar, this.f2215c);
                        dVar6 = this.f2217e.f2206c;
                        dVar6.a(this.f2214b);
                        anetwork.channel.aidl.g gVar = this.f2216d;
                        dVar7 = this.f2217e.f2206c;
                        gVar.a(dVar7);
                    } else {
                        dVar4 = this.f2217e.f2206c;
                        dVar4.a(this.f2214b);
                    }
                } catch (Exception unused) {
                    dVar = this.f2217e.f2206c;
                    if (dVar == null) {
                        return;
                    }
                    dVar2 = this.f2217e.f2206c;
                    dVar2.close();
                }
            } else {
                this.f2216d.a(new DefaultProgressEvent(this.f2213a, this.f2214b.getDataLength(), this.f2215c, this.f2214b.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
