package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.xiaomi.push.c */
/* loaded from: classes2.dex */
public final class C4125c {

    /* renamed from: a */
    private final int f14692a;

    /* renamed from: a */
    private final OutputStream f14693a;

    /* renamed from: a */
    private final byte[] f14694a;

    /* renamed from: b */
    private int f14695b;

    /* renamed from: com.xiaomi.push.c$a */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C4125c(byte[] bArr, int i2, int i3) {
        this.f14693a = null;
        this.f14694a = bArr;
        this.f14695b = i2;
        this.f14692a = i2 + i3;
    }

    /* renamed from: a */
    public static int m13989a(boolean z) {
        return 1;
    }

    /* renamed from: a */
    public static C4125c m13990a(OutputStream outputStream) {
        return m13991a(outputStream, 4096);
    }

    /* renamed from: c */
    public static int m13998c(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: c */
    private void m13999c() {
        OutputStream outputStream = this.f14693a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f14694a, 0, this.f14695b);
        this.f14695b = 0;
    }

    /* renamed from: d */
    public static int m14000d(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: b */
    public void m14021b(int i2, long j2) {
        m14024c(i2, 0);
        m14022b(j2);
    }

    /* renamed from: d */
    public void m14026d(int i2) {
        while ((i2 & (-128)) != 0) {
            m14023c((i2 & 127) | 128);
            i2 >>>= 7;
        }
        m14023c(i2);
    }

    /* renamed from: a */
    public static C4125c m13991a(OutputStream outputStream, int i2) {
        return new C4125c(outputStream, new byte[i2]);
    }

    /* renamed from: a */
    public static C4125c m13992a(byte[] bArr, int i2, int i3) {
        return new C4125c(bArr, i2, i3);
    }

    /* renamed from: b */
    public void m14020b(int i2, int i3) {
        m14024c(i2, 0);
        m14019b(i3);
    }

    /* renamed from: a */
    public void m14006a(int i2, long j2) {
        m14024c(i2, 0);
        m14011a(j2);
    }

    /* renamed from: b */
    public void m14022b(long j2) {
        m14025c(j2);
    }

    /* renamed from: c */
    public void m14023c(int i2) {
        m14003a((byte) i2);
    }

    private C4125c(OutputStream outputStream, byte[] bArr) {
        this.f14693a = outputStream;
        this.f14694a = bArr;
        this.f14695b = 0;
        this.f14692a = bArr.length;
    }

    /* renamed from: a */
    public void m14005a(int i2, int i3) {
        m14024c(i2, 0);
        m14004a(i3);
    }

    /* renamed from: b */
    public void m14019b(int i2) {
        m14026d(i2);
    }

    /* renamed from: c */
    public void m14024c(int i2, int i3) {
        m14026d(C4206f.m14755a(i2, i3));
    }

    /* renamed from: b */
    public static int m13995b(int i2, long j2) {
        return m13997c(i2) + m13996b(j2);
    }

    /* renamed from: c */
    public static int m13997c(int i2) {
        return m14000d(C4206f.m14755a(i2, 0));
    }

    /* renamed from: b */
    public static int m13994b(int i2, int i3) {
        return m13997c(i2) + m13993b(i3);
    }

    /* renamed from: a */
    public void m14010a(int i2, boolean z) {
        m14024c(i2, 0);
        m14015a(z);
    }

    /* renamed from: c */
    public void m14025c(long j2) {
        while (((-128) & j2) != 0) {
            m14023c((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        m14023c((int) j2);
    }

    /* renamed from: b */
    public static int m13996b(long j2) {
        return m13998c(j2);
    }

    /* renamed from: b */
    public static int m13993b(int i2) {
        return m14000d(i2);
    }

    /* renamed from: a */
    public void m14009a(int i2, String str) {
        m14024c(i2, 2);
        m14014a(str);
    }

    /* renamed from: b */
    public void m14018b() {
        if (m14001a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: a */
    public void m14008a(int i2, AbstractC4179e abstractC4179e) {
        m14024c(i2, 2);
        m14013a(abstractC4179e);
    }

    /* renamed from: a */
    public void m14007a(int i2, C4071a c4071a) {
        m14024c(i2, 2);
        m14012a(c4071a);
    }

    /* renamed from: a */
    public void m14011a(long j2) {
        m14025c(j2);
    }

    /* renamed from: a */
    public void m14004a(int i2) {
        if (i2 >= 0) {
            m14026d(i2);
        } else {
            m14025c(i2);
        }
    }

    /* renamed from: a */
    public void m14015a(boolean z) {
        m14023c(z ? 1 : 0);
    }

    /* renamed from: a */
    public void m14014a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m14026d(bytes.length);
        m14016a(bytes);
    }

    /* renamed from: a */
    public void m14013a(AbstractC4179e abstractC4179e) {
        m14026d(abstractC4179e.mo14314a());
        abstractC4179e.mo14320a(this);
    }

    /* renamed from: a */
    public void m14012a(C4071a c4071a) {
        byte[] m13690a = c4071a.m13690a();
        m14026d(m13690a.length);
        m14016a(m13690a);
    }

    /* renamed from: a */
    public static int m13980a(int i2, long j2) {
        return m13997c(i2) + m13985a(j2);
    }

    /* renamed from: a */
    public static int m13979a(int i2, int i3) {
        return m13997c(i2) + m13978a(i3);
    }

    /* renamed from: a */
    public static int m13984a(int i2, boolean z) {
        return m13997c(i2) + m13989a(z);
    }

    /* renamed from: a */
    public static int m13983a(int i2, String str) {
        return m13997c(i2) + m13988a(str);
    }

    /* renamed from: a */
    public static int m13982a(int i2, AbstractC4179e abstractC4179e) {
        return m13997c(i2) + m13987a(abstractC4179e);
    }

    /* renamed from: a */
    public static int m13981a(int i2, C4071a c4071a) {
        return m13997c(i2) + m13986a(c4071a);
    }

    /* renamed from: a */
    public static int m13985a(long j2) {
        return m13998c(j2);
    }

    /* renamed from: a */
    public static int m13978a(int i2) {
        if (i2 >= 0) {
            return m14000d(i2);
        }
        return 10;
    }

    /* renamed from: a */
    public static int m13988a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return m14000d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: a */
    public static int m13987a(AbstractC4179e abstractC4179e) {
        int mo14322b = abstractC4179e.mo14322b();
        return m14000d(mo14322b) + mo14322b;
    }

    /* renamed from: a */
    public static int m13986a(C4071a c4071a) {
        return m14000d(c4071a.m13689a()) + c4071a.m13689a();
    }

    /* renamed from: a */
    public void m14002a() {
        if (this.f14693a != null) {
            m13999c();
        }
    }

    /* renamed from: a */
    public int m14001a() {
        if (this.f14693a == null) {
            return this.f14692a - this.f14695b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a */
    public void m14003a(byte b2) {
        if (this.f14695b == this.f14692a) {
            m13999c();
        }
        byte[] bArr = this.f14694a;
        int i2 = this.f14695b;
        this.f14695b = i2 + 1;
        bArr[i2] = b2;
    }

    /* renamed from: a */
    public void m14016a(byte[] bArr) {
        m14017a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m14017a(byte[] bArr, int i2, int i3) {
        int i4 = this.f14692a;
        int i5 = this.f14695b;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.f14694a, i5, i3);
            this.f14695b += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.f14694a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f14695b = this.f14692a;
        m13999c();
        if (i8 <= this.f14692a) {
            System.arraycopy(bArr, i7, this.f14694a, 0, i8);
            this.f14695b = i8;
        } else {
            this.f14693a.write(bArr, i7, i8);
        }
    }
}
