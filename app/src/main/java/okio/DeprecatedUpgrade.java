package okio;

import i.q2.e;
import i.y;
import j.c.a.d;

/* JADX INFO: renamed from: okio.-DeprecatedUpgrade, reason: invalid class name */
/* JADX INFO: compiled from: -DeprecatedUpgrade.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "-DeprecatedUpgrade")
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Okio", "Lokio/-DeprecatedOkio;", "getOkio", "()Lokio/-DeprecatedOkio;", "Utf8", "Lokio/-DeprecatedUtf8;", "getUtf8", "()Lokio/-DeprecatedUtf8;", "okio"}, k = 2, mv = {1, 1, 16})
public final class DeprecatedUpgrade {

    @d
    private static final DeprecatedOkio Okio = DeprecatedOkio.INSTANCE;

    @d
    private static final DeprecatedUtf8 Utf8 = DeprecatedUtf8.INSTANCE;

    @d
    public static final DeprecatedOkio getOkio() {
        return Okio;
    }

    @d
    public static final DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
