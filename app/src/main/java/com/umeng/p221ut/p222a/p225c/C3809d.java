package com.umeng.p221ut.p222a.p225c;

/* renamed from: com.umeng.ut.a.c.d */
/* loaded from: classes2.dex */
public class C3809d {

    /* renamed from: com.umeng.ut.a.c.d$a */
    private static class a {

        /* renamed from: a */
        public int[] f13870a;

        /* renamed from: x */
        public int f13871x;

        /* renamed from: y */
        public int f13872y;

        private a() {
            this.f13870a = new int[256];
        }
    }

    /* renamed from: a */
    private static a m12777a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i2 = 0; i2 < 256; i2++) {
            aVar.f13870a[i2] = i2;
        }
        aVar.f13871x = 0;
        aVar.f13872y = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            try {
                i4 = ((str.charAt(i3) + aVar.f13870a[i5]) + i4) % 256;
                int i6 = aVar.f13870a[i5];
                aVar.f13870a[i5] = aVar.f13870a[i4];
                aVar.f13870a[i4] = i6;
                i3 = (i3 + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    /* renamed from: b */
    public static byte[] m12779b(byte[] bArr) {
        a m12777a;
        if (bArr == null || (m12777a = m12777a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return m12778a(bArr, m12777a);
    }

    /* renamed from: a */
    private static byte[] m12778a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i2 = aVar.f13871x;
        int i3 = aVar.f13872y;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = aVar.f13870a;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            int i6 = (iArr[i2] + iArr[i3]) % 256;
            bArr[i4] = (byte) (iArr[i6] ^ bArr[i4]);
        }
        aVar.f13871x = i2;
        aVar.f13872y = i3;
        return bArr;
    }
}
