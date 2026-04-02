package i.n2;

import i.q2.t.i0;
import java.io.File;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends j {
    public /* synthetic */ a(File file, File file2, String str, int i2, i.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@j.c.a.d File file, @j.c.a.e File file2, @j.c.a.e String str) {
        super(file, file2, str);
        i0.f(file, "file");
    }
}
