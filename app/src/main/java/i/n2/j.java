package i.n2;

import i.q2.t.i0;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public class j extends IOException {

    @j.c.a.d
    private final File file;

    @j.c.a.e
    private final File other;

    @j.c.a.e
    private final String reason;

    public /* synthetic */ j(File file, File file2, String str, int i2, i.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    @j.c.a.d
    public final File getFile() {
        return this.file;
    }

    @j.c.a.e
    public final File getOther() {
        return this.other;
    }

    @j.c.a.e
    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@j.c.a.d File file, @j.c.a.e File file2, @j.c.a.e String str) {
        super(f.b(file, file2, str));
        i0.f(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
