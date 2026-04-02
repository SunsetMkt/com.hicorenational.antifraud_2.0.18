package d.b.c.d0;

import java.util.Map;

/* JADX INFO: compiled from: UPCAWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class t implements d.b.c.v {
    private final i a = new i();

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3) throws d.b.c.w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<d.b.c.g, ?> map) throws d.b.c.w {
        if (aVar == d.b.c.a.UPC_A) {
            return this.a.a(a(str), d.b.c.a.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + aVar);
    }

    private static String a(String str) {
        int length = str.length();
        if (length == 11) {
            int iCharAt = 0;
            for (int i2 = 0; i2 < 11; i2++) {
                iCharAt += (str.charAt(i2) - '0') * (i2 % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - iCharAt) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return '0' + str;
    }
}
