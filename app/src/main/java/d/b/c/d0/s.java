package d.b.c.d0;

import java.util.Map;

/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class s extends x {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final x f9658j = new h();

    @Override // d.b.c.d0.x
    public d.b.c.r a(int i2, d.b.c.z.a aVar, int[] iArr, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        return a(this.f9658j.a(i2, aVar, iArr, map));
    }

    @Override // d.b.c.d0.x, d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        return a(this.f9658j.a(i2, aVar, map));
    }

    @Override // d.b.c.d0.q, d.b.c.p
    public d.b.c.r a(d.b.c.c cVar) throws d.b.c.m, d.b.c.h {
        return a(this.f9658j.a(cVar));
    }

    @Override // d.b.c.d0.q, d.b.c.p
    public d.b.c.r a(d.b.c.c cVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.h {
        return a(this.f9658j.a(cVar, map));
    }

    @Override // d.b.c.d0.x
    d.b.c.a a() {
        return d.b.c.a.UPC_A;
    }

    @Override // d.b.c.d0.x
    protected int a(d.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws d.b.c.m {
        return this.f9658j.a(aVar, iArr, sb);
    }

    private static d.b.c.r a(d.b.c.r rVar) throws d.b.c.h {
        String strE = rVar.e();
        if (strE.charAt(0) == '0') {
            return new d.b.c.r(strE.substring(1), null, rVar.d(), d.b.c.a.UPC_A);
        }
        throw d.b.c.h.getFormatInstance();
    }
}
