package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* renamed from: com.xiaomi.push.ev */
/* loaded from: classes2.dex */
public class C4201ev {

    /* renamed from: a */
    public static final byte[] f15233a = {80, 85, 83, 72};

    /* renamed from: a */
    private byte f15234a;

    /* renamed from: a */
    private int f15235a;

    /* renamed from: a */
    private short f15236a;

    /* renamed from: b */
    private byte[] f15237b;

    /* renamed from: com.xiaomi.push.ev$a */
    public static class a {

        /* renamed from: a */
        public static final c f15238a = new c();

        /* renamed from: a */
        public static final d f15239a = new d();

        /* renamed from: a */
        public static byte[] m14730a(byte[] bArr) {
            return m14731a(bArr, f15239a);
        }

        /* renamed from: a */
        public static byte[] m14731a(byte[] bArr, b bVar) {
            if (!C4201ev.m14727a(bArr)) {
                return bArr;
            }
            C4201ev m14726a = C4201ev.m14726a(bArr);
            return (m14726a.f15234a == 0 || m14726a.f15234a != bVar.mo14732a()) ? m14726a.f15237b : bVar.mo14733a(m14726a.f15237b, m14726a.f15235a);
        }
    }

    /* renamed from: com.xiaomi.push.ev$b */
    public interface b {
        /* renamed from: a */
        byte mo14732a();

        /* renamed from: a */
        byte[] mo14733a(byte[] bArr, int i2);
    }

    /* renamed from: com.xiaomi.push.ev$c */
    public static final class c {
    }

    /* renamed from: com.xiaomi.push.ev$d */
    public static final class d implements b {
        @Override // com.xiaomi.push.C4201ev.b
        /* renamed from: a */
        public byte mo14732a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.C4201ev.b
        /* renamed from: a */
        public byte[] mo14733a(byte[] bArr, int i2) {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i2);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[i2];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    protected C4201ev(byte b2, int i2, byte[] bArr) {
        this((short) 1, b2, i2, bArr);
    }

    protected C4201ev(short s, byte b2, int i2, byte[] bArr) {
        this.f15236a = (short) 1;
        this.f15236a = s;
        this.f15234a = b2;
        this.f15235a = i2;
        this.f15237b = bArr;
    }

    /* renamed from: a */
    public static C4201ev m14724a(byte b2, int i2, byte[] bArr) {
        return new C4201ev(b2, i2, bArr);
    }

    /* renamed from: a */
    public static C4201ev m14725a(short s, byte b2, int i2, byte[] bArr) {
        return new C4201ev(s, b2, i2, bArr);
    }

    /* renamed from: a */
    public static C4201ev m14726a(byte[] bArr) {
        if (m14727a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i2 = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return m14725a(s, b2, i2, bArr2);
        }
        return m14724a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a */
    public static boolean m14727a(byte[] bArr) {
        byte[] bArr2 = f15233a;
        return m14728a(bArr2, bArr, bArr2.length);
    }

    /* renamed from: a */
    public static boolean m14728a(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr.length < i2 || bArr2.length < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
