package com.xiaomi.push;

import com.xiaomi.push.hw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class ig extends hw {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f9322b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f9323c = 10000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9324d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f9325e = 10485760;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f9326f = 104857600;

    public static class a extends hw.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hw.a, com.xiaomi.push.ic
        public ia a(ik ikVar) {
            ig igVar = new ig(ikVar, ((hw.a) this).f896a, this.f9315b);
            int i2 = ((hw.a) this).a;
            if (i2 != 0) {
                igVar.b(i2);
            }
            return igVar;
        }

        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
        }
    }

    public ig(ik ikVar, boolean z, boolean z2) {
        super(ikVar, z, z2);
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public hz mo603a() throws hu {
        byte bA = a();
        byte bA2 = a();
        int iMo599a = mo599a();
        if (iMo599a <= f9322b) {
            return new hz(bA, bA2, iMo599a);
        }
        throw new ib(3, "Thrift map size " + iMo599a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public hy mo602a() throws hu {
        byte bA = a();
        int iMo599a = mo599a();
        if (iMo599a <= f9323c) {
            return new hy(bA, iMo599a);
        }
        throw new ib(3, "Thrift list size " + iMo599a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public ie mo604a() throws hu {
        byte bA = a();
        int iMo599a = mo599a();
        if (iMo599a <= f9324d) {
            return new ie(bA, iMo599a);
        }
        throw new ib(3, "Thrift set size " + iMo599a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public String mo606a() throws hu {
        int iMo599a = mo599a();
        if (iMo599a <= f9325e) {
            if (((ia) this).a.b() >= iMo599a) {
                try {
                    String str = new String(((ia) this).a.a(), ((ia) this).a.a_(), iMo599a, "UTF-8");
                    ((ia) this).a.a(iMo599a);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new hu("JVM DOES NOT SUPPORT UTF-8");
                }
            }
            return a(iMo599a);
        }
        throw new ib(3, "Thrift string size " + iMo599a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo607a() throws hu {
        int iMo599a = mo599a();
        if (iMo599a <= f9326f) {
            c(iMo599a);
            if (((ia) this).a.b() >= iMo599a) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(((ia) this).a.a(), ((ia) this).a.a_(), iMo599a);
                ((ia) this).a.a(iMo599a);
                return byteBufferWrap;
            }
            byte[] bArr = new byte[iMo599a];
            ((ia) this).a.b(bArr, 0, iMo599a);
            return ByteBuffer.wrap(bArr);
        }
        throw new ib(3, "Thrift binary size " + iMo599a + " out of range!");
    }
}
