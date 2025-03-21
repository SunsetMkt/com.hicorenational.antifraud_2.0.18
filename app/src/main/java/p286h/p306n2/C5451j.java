package p286h.p306n2;

import java.io.File;
import java.io.IOException;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Exceptions.kt */
/* renamed from: h.n2.j */
/* loaded from: classes2.dex */
public class C5451j extends IOException {

    @InterfaceC5816d
    private final File file;

    @InterfaceC5817e
    private final File other;

    @InterfaceC5817e
    private final String reason;

    public /* synthetic */ C5451j(File file, File file2, String str, int i2, C5586v c5586v) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    @InterfaceC5816d
    public final File getFile() {
        return this.file;
    }

    @InterfaceC5817e
    public final File getOther() {
        return this.other;
    }

    @InterfaceC5817e
    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C5451j(@p324i.p336c.p337a.InterfaceC5816d java.io.File r2, @p324i.p336c.p337a.InterfaceC5817e java.io.File r3, @p324i.p336c.p337a.InterfaceC5817e java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            p286h.p309q2.p311t.C5544i0.m22546f(r2, r0)
            java.lang.String r0 = p286h.p306n2.C5447f.m22304a(r2, r3, r4)
            r1.<init>(r0)
            r1.file = r2
            r1.other = r3
            r1.reason = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p286h.p306n2.C5451j.<init>(java.io.File, java.io.File, java.lang.String):void");
    }
}
