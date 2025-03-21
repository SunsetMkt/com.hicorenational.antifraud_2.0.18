package p324i.p325a.p326a.p327a.p328k;

import com.umeng.analytics.pro.C3393cw;
import java.io.UnsupportedEncodingException;
import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5756a;
import p324i.p325a.p326a.p327a.InterfaceC5757b;

/* compiled from: Hex.java */
/* renamed from: i.a.a.a.k.k */
/* loaded from: classes2.dex */
public class C5776k implements InterfaceC5757b, InterfaceC5756a {

    /* renamed from: b */
    public static final String f20820b = "UTF-8";

    /* renamed from: c */
    private static final char[] f20821c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d */
    private static final char[] f20822d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    private final String f20823a;

    public C5776k() {
        this.f20823a = "UTF-8";
    }

    /* renamed from: a */
    public static byte[] m24198a(char[] cArr) throws C5760e {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new C5760e("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int m24197a = m24197a(cArr[i2], i2) << 4;
            int i4 = i2 + 1;
            int m24197a2 = m24197a | m24197a(cArr[i4], i4);
            i2 = i4 + 1;
            bArr[i3] = (byte) (m24197a2 & 255);
            i3++;
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m24202b(byte[] bArr) {
        return new String(m24199a(bArr));
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) throws C5760e {
        try {
            return m24198a(new String(bArr, m24203a()).toCharArray());
        } catch (UnsupportedEncodingException e2) {
            throw new C5760e(e2.getMessage(), e2);
        }
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5757b
    public byte[] encode(byte[] bArr) {
        return C5777l.m24208a(m24202b(bArr), m24203a());
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.f20823a + "]";
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        try {
            return m24199a(obj instanceof String ? ((String) obj).getBytes(m24203a()) : (byte[]) obj);
        } catch (UnsupportedEncodingException e2) {
            throw new C5762g(e2.getMessage(), e2);
        } catch (ClassCastException e3) {
            throw new C5762g(e3.getMessage(), e3);
        }
    }

    public C5776k(String str) {
        this.f20823a = str;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) throws C5760e {
        try {
            return m24198a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e2) {
            throw new C5760e(e2.getMessage(), e2);
        }
    }

    /* renamed from: a */
    public static char[] m24199a(byte[] bArr) {
        return m24200a(bArr, true);
    }

    /* renamed from: a */
    public static char[] m24200a(byte[] bArr, boolean z) {
        return m24201a(bArr, z ? f20821c : f20822d);
    }

    /* renamed from: a */
    protected static char[] m24201a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & C3393cw.f11873m];
        }
        return cArr2;
    }

    /* renamed from: a */
    protected static int m24197a(char c2, int i2) throws C5760e {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new C5760e("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    /* renamed from: a */
    public String m24203a() {
        return this.f20823a;
    }
}
