package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class ev {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f12791a = {80, 85, 83, 72};

    /* renamed from: a, reason: collision with other field name */
    private byte f480a;

    /* renamed from: a, reason: collision with other field name */
    private int f481a;

    /* renamed from: a, reason: collision with other field name */
    private short f482a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f12792b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f12793a = new c();

        /* renamed from: a, reason: collision with other field name */
        public static final d f483a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f483a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!ev.m404a(bArr)) {
                return bArr;
            }
            ev a2 = ev.a(bArr);
            return (a2.f480a == 0 || a2.f480a != bVar.a()) ? a2.f12792b : bVar.a(a2.f12792b, a2.f481a);
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i2);
    }

    public static final class c {
    }

    public static final class d implements b {
        @Override // com.xiaomi.push.ev.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.ev.b
        public byte[] a(byte[] bArr, int i2) {
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

    protected ev(byte b2, int i2, byte[] bArr) {
        this((short) 1, b2, i2, bArr);
    }

    protected ev(short s, byte b2, int i2, byte[] bArr) {
        this.f482a = (short) 1;
        this.f482a = s;
        this.f480a = b2;
        this.f481a = i2;
        this.f12792b = bArr;
    }

    public static ev a(byte b2, int i2, byte[] bArr) {
        return new ev(b2, i2, bArr);
    }

    public static ev a(short s, byte b2, int i2, byte[] bArr) {
        return new ev(s, b2, i2, bArr);
    }

    public static ev a(byte[] bArr) {
        if (m404a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i2 = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b2, i2, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m404a(byte[] bArr) {
        byte[] bArr2 = f12791a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i2) {
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
