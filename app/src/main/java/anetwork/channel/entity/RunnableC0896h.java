package anetwork.channel.entity;

import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0871g;
import anetwork.channel.aidl.ParcelableHeader;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.h */
/* loaded from: classes.dex */
class RunnableC0896h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0871g f1347a;

    /* renamed from: b */
    final /* synthetic */ int f1348b;

    /* renamed from: c */
    final /* synthetic */ Map f1349c;

    /* renamed from: d */
    final /* synthetic */ C0895g f1350d;

    RunnableC0896h(C0895g c0895g, InterfaceC0871g interfaceC0871g, int i2, Map map) {
        this.f1350d = c0895g;
        this.f1347a = interfaceC0871g;
        this.f1348b = i2;
        this.f1349c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1347a.mo777a(this.f1348b, new ParcelableHeader(this.f1348b, this.f1349c));
        } catch (RemoteException unused) {
        }
    }
}
