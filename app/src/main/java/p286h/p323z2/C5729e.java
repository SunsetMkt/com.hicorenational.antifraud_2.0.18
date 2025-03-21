package p286h.p323z2;

import p286h.p304m2.InterfaceC5426f;

/* compiled from: Char.kt */
/* renamed from: h.z2.e */
/* loaded from: classes2.dex */
class C5729e extends C5727d {
    @InterfaceC5426f
    /* renamed from: a */
    private static final String m23829a(char c2, String str) {
        return String.valueOf(c2) + str;
    }

    /* renamed from: c */
    public static final boolean m23832c(char c2) {
        return 55296 <= c2 && 57343 >= c2;
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m23831a(char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return m23830a(c2, c3, z);
    }

    /* renamed from: a */
    public static final boolean m23830a(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }
}
