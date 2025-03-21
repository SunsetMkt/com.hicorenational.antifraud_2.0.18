package anet.channel.strategy;

import com.heytap.mcssdk.constant.C2084a;
import java.io.Serializable;
import p286h.C5230f1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class ConnHistoryItem implements Serializable {

    /* renamed from: a */
    byte f1033a = 0;

    /* renamed from: b */
    long f1034b = 0;

    /* renamed from: c */
    long f1035c = 0;

    ConnHistoryItem() {
    }

    /* renamed from: a */
    void m627a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (z ? this.f1034b : this.f1035c) > C2084a.f6135q) {
            this.f1033a = (byte) ((this.f1033a << 1) | (!z ? 1 : 0));
            if (z) {
                this.f1034b = currentTimeMillis;
            } else {
                this.f1035c = currentTimeMillis;
            }
        }
    }

    /* renamed from: b */
    boolean m628b() {
        return (this.f1033a & 1) == 1;
    }

    /* renamed from: c */
    boolean m629c() {
        return m626a() >= 3 && System.currentTimeMillis() - this.f1035c <= 300000;
    }

    /* renamed from: d */
    boolean m630d() {
        long j2 = this.f1034b;
        long j3 = this.f1035c;
        if (j2 <= j3) {
            j2 = j3;
        }
        return j2 != 0 && System.currentTimeMillis() - j2 > 86400000;
    }

    /* renamed from: a */
    int m626a() {
        int i2 = 0;
        for (int i3 = this.f1033a & C5230f1.f20085c; i3 > 0; i3 >>= 1) {
            i2 += i3 & 1;
        }
        return i2;
    }
}
