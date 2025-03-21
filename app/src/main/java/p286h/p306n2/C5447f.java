package p286h.p306n2;

import java.io.File;
import p286h.p309q2.p311t.C5544i0;

/* compiled from: Exceptions.kt */
/* renamed from: h.n2.f */
/* loaded from: classes2.dex */
public final class C5447f {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final String m22305b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        C5544i0.m22521a((Object) sb2, "sb.toString()");
        return sb2;
    }
}
