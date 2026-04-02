package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class g implements b.a.p.a {
    private anetwork.channel.aidl.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private anetwork.channel.aidl.j.d f1775c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k f1777e;

    public g(anetwork.channel.aidl.g gVar, k kVar) {
        this.f1776d = false;
        this.f1777e = null;
        this.a = gVar;
        this.f1777e = kVar;
        if (gVar != null) {
            try {
                if ((gVar.j() & 8) != 0) {
                    this.f1776d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // b.a.p.a
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onResponseCode]", this.f1774b, new Object[0]);
        }
        anetwork.channel.aidl.g gVar = this.a;
        if (gVar != null) {
            a(new h(this, gVar, i2, map));
        }
    }

    @Override // b.a.p.a
    public void a(int i2, int i3, ByteArray byteArray) {
        anetwork.channel.aidl.g gVar = this.a;
        if (gVar != null) {
            a(new i(this, i2, byteArray, i3, gVar));
        }
    }

    @Override // b.a.p.a
    public void a(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onFinish] ", this.f1774b, new Object[0]);
        }
        anetwork.channel.aidl.g gVar = this.a;
        if (gVar != null) {
            j jVar = new j(this, defaultFinishEvent, gVar);
            RequestStatistic requestStatistic = defaultFinishEvent.f1664e;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
            }
            a(jVar);
        }
        this.a = null;
    }

    private void a(Runnable runnable) {
        if (this.f1777e.c()) {
            runnable.run();
        } else {
            String str = this.f1774b;
            e.a(str != null ? str.hashCode() : hashCode(), runnable);
        }
    }

    public void a(String str) {
        this.f1774b = str;
    }
}
