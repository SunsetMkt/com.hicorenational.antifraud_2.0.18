package p031c.p091d.p092a.p093a;

import java.nio.ByteBuffer;
import p031c.p091d.p092a.p093a.p094f.C1222a;

/* compiled from: ApkSectionInfo.java */
/* renamed from: c.d.a.a.a */
/* loaded from: classes.dex */
public class C1217a {

    /* renamed from: a */
    public boolean f2663a = false;

    /* renamed from: b */
    public long f2664b;

    /* renamed from: c */
    public C1219c<ByteBuffer, Long> f2665c;

    /* renamed from: d */
    public C1219c<ByteBuffer, Long> f2666d;

    /* renamed from: e */
    public C1219c<ByteBuffer, Long> f2667e;

    /* renamed from: f */
    public C1219c<ByteBuffer, Long> f2668f;

    /* renamed from: a */
    public void m2365a() throws C1222a.c {
        long m2391a = C1222a.m2391a(this.f2668f.m2369a(), this.f2668f.m2370b().longValue());
        if (m2391a == this.f2667e.m2370b().longValue()) {
            return;
        }
        throw new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + m2391a + ", centralDirOffset : " + this.f2667e.m2370b());
    }

    /* renamed from: b */
    public void m2366b() throws C1222a.c {
        if ((!this.f2663a && this.f2665c == null) || this.f2666d == null || this.f2667e == null || this.f2668f == null) {
            throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
        }
        if ((this.f2663a || (this.f2665c.m2370b().longValue() == 0 && ((long) this.f2665c.m2369a().remaining()) + this.f2665c.m2370b().longValue() == this.f2666d.m2370b().longValue())) && ((long) this.f2666d.m2369a().remaining()) + this.f2666d.m2370b().longValue() == this.f2667e.m2370b().longValue() && ((long) this.f2667e.m2369a().remaining()) + this.f2667e.m2370b().longValue() == this.f2668f.m2370b().longValue() && ((long) this.f2668f.m2369a().remaining()) + this.f2668f.m2370b().longValue() == this.f2664b) {
            m2365a();
            return;
        }
        throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
    }

    /* renamed from: c */
    public void m2367c() {
        C1219c<ByteBuffer, Long> c1219c = this.f2665c;
        if (c1219c != null) {
            c1219c.m2369a().rewind();
        }
        C1219c<ByteBuffer, Long> c1219c2 = this.f2666d;
        if (c1219c2 != null) {
            c1219c2.m2369a().rewind();
        }
        C1219c<ByteBuffer, Long> c1219c3 = this.f2667e;
        if (c1219c3 != null) {
            c1219c3.m2369a().rewind();
        }
        C1219c<ByteBuffer, Long> c1219c4 = this.f2668f;
        if (c1219c4 != null) {
            c1219c4.m2369a().rewind();
        }
    }

    public String toString() {
        return "lowMemory : " + this.f2663a + "\n apkSize : " + this.f2664b + "\n contentEntry : " + this.f2665c + "\n schemeV2Block : " + this.f2666d + "\n centralDir : " + this.f2667e + "\n eocd : " + this.f2668f;
    }
}
