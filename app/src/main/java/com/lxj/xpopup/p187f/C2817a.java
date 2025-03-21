package com.lxj.xpopup.p187f;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import com.lxj.xpopup.p185d.EnumC2801a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageHeaderParser.java */
/* renamed from: com.lxj.xpopup.f.a */
/* loaded from: classes.dex */
public class C2817a {

    /* renamed from: a */
    private static final int f8718a = 4671814;

    /* renamed from: b */
    private static final int f8719b = -1991225785;

    /* renamed from: c */
    static final int f8720c = 65496;

    /* renamed from: d */
    private static final int f8721d = 1380533830;

    /* renamed from: e */
    private static final int f8722e = 1464156752;

    /* renamed from: f */
    private static final int f8723f = 1448097792;

    /* renamed from: g */
    private static final int f8724g = -256;

    /* renamed from: h */
    private static final int f8725h = 255;

    /* renamed from: i */
    private static final int f8726i = 88;

    /* renamed from: j */
    private static final int f8727j = 76;

    /* renamed from: k */
    private static final int f8728k = 16;

    /* renamed from: l */
    private static final int f8729l = 8;

    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.lxj.xpopup.f.a$a */
    private interface a {
        /* renamed from: a */
        int mo8439a() throws IOException;

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j2) throws IOException;
    }

    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.lxj.xpopup.f.a$b */
    private static final class b implements a {

        /* renamed from: a */
        private final InputStream f8730a;

        b(InputStream inputStream) {
            this.f8730a = inputStream;
        }

        @Override // com.lxj.xpopup.p187f.C2817a.a
        /* renamed from: a */
        public int mo8439a() throws IOException {
            return this.f8730a.read();
        }

        @Override // com.lxj.xpopup.p187f.C2817a.a
        public int getUInt16() throws IOException {
            return ((this.f8730a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f8730a.read() & 255);
        }

        @Override // com.lxj.xpopup.p187f.C2817a.a
        public short getUInt8() throws IOException {
            return (short) (this.f8730a.read() & 255);
        }

        @Override // com.lxj.xpopup.p187f.C2817a.a
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int read = this.f8730a.read(bArr, i2 - i3, i3);
                if (read == -1) {
                    break;
                }
                i3 -= read;
            }
            return i2 - i3;
        }

        @Override // com.lxj.xpopup.p187f.C2817a.a
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f8730a.skip(j3);
                if (skip <= 0) {
                    if (this.f8730a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }
    }

    /* renamed from: a */
    static EnumC2801a m8438a(InputStream inputStream) throws IOException {
        b bVar = new b(inputStream);
        int uInt16 = bVar.getUInt16();
        if (uInt16 == f8720c) {
            return EnumC2801a.JPEG;
        }
        int uInt162 = ((uInt16 << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535);
        if (uInt162 == f8719b) {
            bVar.skip(21L);
            return bVar.mo8439a() >= 3 ? EnumC2801a.PNG_A : EnumC2801a.PNG;
        }
        if ((uInt162 >> 8) == f8718a) {
            return EnumC2801a.GIF;
        }
        if (uInt162 != f8721d) {
            return EnumC2801a.UNKNOWN;
        }
        bVar.skip(4L);
        if ((((bVar.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535)) != f8722e) {
            return EnumC2801a.UNKNOWN;
        }
        int uInt163 = ((bVar.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535);
        if ((uInt163 & (-256)) != f8723f) {
            return EnumC2801a.UNKNOWN;
        }
        int i2 = uInt163 & 255;
        if (i2 == 88) {
            bVar.skip(4L);
            return (bVar.mo8439a() & 16) != 0 ? EnumC2801a.WEBP_A : EnumC2801a.WEBP;
        }
        if (i2 == 76) {
            bVar.skip(4L);
            return (bVar.mo8439a() & 8) != 0 ? EnumC2801a.WEBP_A : EnumC2801a.WEBP;
        }
        inputStream.close();
        return EnumC2801a.WEBP;
    }
}
