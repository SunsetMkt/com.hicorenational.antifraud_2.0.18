package h.n2;

import h.q2.t.i0;
import java.io.File;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        i0.a((Object) sb2, "sb.toString()");
        return sb2;
    }
}
