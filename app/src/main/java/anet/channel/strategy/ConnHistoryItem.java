package anet.channel.strategy;

import i.f1;
import java.io.Serializable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class ConnHistoryItem implements Serializable {
    byte a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f1556b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f1557c = 0;

    ConnHistoryItem() {
    }

    void a(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - (z ? this.f1556b : this.f1557c) > com.heytap.mcssdk.constant.a.q) {
            this.a = (byte) ((this.a << 1) | (!z ? 1 : 0));
            if (z) {
                this.f1556b = jCurrentTimeMillis;
            } else {
                this.f1557c = jCurrentTimeMillis;
            }
        }
    }

    boolean b() {
        return (this.a & 1) == 1;
    }

    boolean c() {
        return a() >= 3 && System.currentTimeMillis() - this.f1557c <= 300000;
    }

    boolean d() {
        long j2 = this.f1556b;
        long j3 = this.f1557c;
        if (j2 <= j3) {
            j2 = j3;
        }
        return j2 != 0 && System.currentTimeMillis() - j2 > 86400000;
    }

    int a() {
        int i2 = 0;
        for (int i3 = this.a & f1.f12066c; i3 > 0; i3 >>= 1) {
            i2 += i3 & 1;
        }
        return i2;
    }
}
