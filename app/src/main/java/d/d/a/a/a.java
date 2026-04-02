package d.d.a.a;

import d.d.a.a.f.a;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ApkSectionInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c<ByteBuffer, Long> f10104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c<ByteBuffer, Long> f10105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c<ByteBuffer, Long> f10106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c<ByteBuffer, Long> f10107f;

    public void a() throws a.c {
        long jA = d.d.a.a.f.a.a(this.f10107f.a(), this.f10107f.b().longValue());
        if (jA == this.f10106e.b().longValue()) {
            return;
        }
        throw new RuntimeException("CentralDirOffset mismatch , EocdCentralDirOffset : " + jA + ", centralDirOffset : " + this.f10106e.b());
    }

    public void b() throws a.c {
        if ((!this.a && this.f10104c == null) || this.f10105d == null || this.f10106e == null || this.f10107f == null) {
            throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
        }
        if ((this.a || (this.f10104c.b().longValue() == 0 && ((long) this.f10104c.a().remaining()) + this.f10104c.b().longValue() == this.f10105d.b().longValue())) && ((long) this.f10105d.a().remaining()) + this.f10105d.b().longValue() == this.f10106e.b().longValue() && ((long) this.f10106e.a().remaining()) + this.f10106e.b().longValue() == this.f10107f.b().longValue() && ((long) this.f10107f.a().remaining()) + this.f10107f.b().longValue() == this.f10103b) {
            a();
            return;
        }
        throw new RuntimeException("ApkSectionInfo paramters is not valid : " + toString());
    }

    public void c() {
        c<ByteBuffer, Long> cVar = this.f10104c;
        if (cVar != null) {
            cVar.a().rewind();
        }
        c<ByteBuffer, Long> cVar2 = this.f10105d;
        if (cVar2 != null) {
            cVar2.a().rewind();
        }
        c<ByteBuffer, Long> cVar3 = this.f10106e;
        if (cVar3 != null) {
            cVar3.a().rewind();
        }
        c<ByteBuffer, Long> cVar4 = this.f10107f;
        if (cVar4 != null) {
            cVar4.a().rewind();
        }
    }

    public String toString() {
        return "lowMemory : " + this.a + "\n apkSize : " + this.f10103b + "\n contentEntry : " + this.f10104c + "\n schemeV2Block : " + this.f10105d + "\n centralDir : " + this.f10106e + "\n eocd : " + this.f10107f;
    }
}
