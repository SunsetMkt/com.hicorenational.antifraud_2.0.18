package i.z2;

/* JADX INFO: compiled from: Char.kt */
/* JADX INFO: loaded from: classes2.dex */
class e extends d {
    @i.m2.f
    private static final String a(char c2, String str) {
        return String.valueOf(c2) + str;
    }

    public static final boolean c(char c2) {
        return '\ud800' <= c2 && '\udfff' >= c2;
    }

    public static /* synthetic */ boolean a(char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(c2, c3, z);
    }

    public static final boolean a(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }
}
