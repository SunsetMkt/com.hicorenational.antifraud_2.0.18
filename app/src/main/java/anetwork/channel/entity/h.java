package anetwork.channel.entity;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableHeader;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ anetwork.channel.aidl.g a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f1778b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ Map f1779c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ g f1780d;

    h(g gVar, anetwork.channel.aidl.g gVar2, int i2, Map map) {
        this.f1780d = gVar;
        this.a = gVar2;
        this.f1778b = i2;
        this.f1779c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a(this.f1778b, new ParcelableHeader(this.f1778b, this.f1779c));
        } catch (RemoteException unused) {
        }
    }
}
