package p324i.p325a.p326a.p327a.p330m;

import java.util.Locale;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: SoundexUtils.java */
/* renamed from: i.a.a.a.m.j */
/* loaded from: classes2.dex */
final class C5788j {
    C5788j() {
    }

    /* renamed from: a */
    static String m24344a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (Character.isLetter(str.charAt(i3))) {
                cArr[i2] = str.charAt(i3);
                i2++;
            }
        }
        return i2 == length ? str.toUpperCase(Locale.ENGLISH) : new String(cArr, 0, i2).toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: a */
    static int m24342a(InterfaceC5764i interfaceC5764i, String str, String str2) throws C5762g {
        return m24343a(interfaceC5764i.mo24152a(str), interfaceC5764i.mo24152a(str2));
    }

    /* renamed from: a */
    static int m24343a(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            if (str.charAt(i3) == str2.charAt(i3)) {
                i2++;
            }
        }
        return i2;
    }
}
