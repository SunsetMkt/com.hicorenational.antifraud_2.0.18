package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ByteArray f1781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f1783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ g f1784e;

    i(g gVar, int i2, ByteArray byteArray, int i3, anetwork.channel.aidl.g gVar2) {
        this.f1784e = gVar;
        this.a = i2;
        this.f1781b = byteArray;
        this.f1782c = i3;
        this.f1783d = gVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f1784e.f1776d) {
                try {
                    if (this.f1784e.f1775c == null) {
                        this.f1784e.f1775c = new anetwork.channel.aidl.j.d();
                        this.f1784e.f1775c.a(this.f1784e.f1777e, this.f1782c);
                        this.f1784e.f1775c.a(this.f1781b);
                        this.f1783d.a(this.f1784e.f1775c);
                    } else {
                        this.f1784e.f1775c.a(this.f1781b);
                    }
                } catch (Exception unused) {
                    if (this.f1784e.f1775c == null) {
                    } else {
                        this.f1784e.f1775c.close();
                    }
                }
            } else {
                this.f1783d.a(new DefaultProgressEvent(this.a, this.f1781b.getDataLength(), this.f1782c, this.f1781b.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
