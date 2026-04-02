package i.z2;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "CharsetsKt")
public final class g {
    @i.m2.f
    private static final Charset a(String str) {
        Charset charsetForName = Charset.forName(str);
        i.q2.t.i0.a((Object) charsetForName, "Charset.forName(charsetName)");
        return charsetForName;
    }
}
