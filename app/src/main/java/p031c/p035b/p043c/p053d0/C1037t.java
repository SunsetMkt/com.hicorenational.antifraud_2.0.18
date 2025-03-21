package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.InterfaceC1111v;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: UPCAWriter.java */
/* renamed from: c.b.c.d0.t */
/* loaded from: classes.dex */
public final class C1037t implements InterfaceC1111v {

    /* renamed from: a */
    private final C1026i f1941a = new C1026i();

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) throws C1112w {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (enumC0953a == EnumC0953a.UPC_A) {
            return this.f1941a.mo1190a(m1517a(str), EnumC0953a.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + enumC0953a);
    }

    /* renamed from: a */
    private static String m1517a(String str) {
        int length = str.length();
        if (length == 11) {
            int i2 = 0;
            for (int i3 = 0; i3 < 11; i3++) {
                i2 += (str.charAt(i3) - '0') * (i3 % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - i2) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return '0' + str;
    }
}
