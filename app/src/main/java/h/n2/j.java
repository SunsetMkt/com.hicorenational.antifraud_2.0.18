package h.n2;

import java.io.File;
import java.io.IOException;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public class j extends IOException {

    @i.c.a.d
    private final File file;

    @i.c.a.e
    private final File other;

    @i.c.a.e
    private final String reason;

    public /* synthetic */ j(File file, File file2, String str, int i2, h.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    @i.c.a.d
    public final File getFile() {
        return this.file;
    }

    @i.c.a.e
    public final File getOther() {
        return this.other;
    }

    @i.c.a.e
    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j(@i.c.a.d java.io.File r2, @i.c.a.e java.io.File r3, @i.c.a.e java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            h.q2.t.i0.f(r2, r0)
            java.lang.String r0 = h.n2.f.a(r2, r3, r4)
            r1.<init>(r0)
            r1.file = r2
            r1.other = r3
            r1.reason = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.n2.j.<init>(java.io.File, java.io.File, java.lang.String):void");
    }
}
