package com.lxj.xpopup.f;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ImageHeaderParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final int a = 4671814;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5454b = -1991225785;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f5455c = 65496;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f5456d = 1380533830;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f5457e = 1464156752;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f5458f = 1448097792;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f5459g = -256;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f5460h = 255;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f5461i = 88;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f5462j = 76;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5463k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f5464l = 8;

    /* JADX INFO: renamed from: com.lxj.xpopup.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageHeaderParser.java */
    private interface InterfaceC0102a {
        int a() throws IOException;

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j2) throws IOException;
    }

    /* JADX INFO: compiled from: ImageHeaderParser.java */
    private static final class b implements InterfaceC0102a {
        private final InputStream a;

        b(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0102a
        public int a() throws IOException {
            return this.a.read();
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0102a
        public int getUInt16() throws IOException {
            return ((this.a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.a.read() & 255);
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0102a
        public short getUInt8() throws IOException {
            return (short) (this.a.read() & 255);
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0102a
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int i4 = this.a.read(bArr, i2 - i3, i3);
                if (i4 == -1) {
                    break;
                }
                i3 -= i4;
            }
            return i2 - i3;
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0102a
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long jSkip = this.a.skip(j3);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j3 -= jSkip;
            }
            return j2 - j3;
        }
    }

    static com.lxj.xpopup.d.a a(InputStream inputStream) throws IOException {
        b bVar = new b(inputStream);
        int uInt16 = bVar.getUInt16();
        if (uInt16 == f5455c) {
            return com.lxj.xpopup.d.a.JPEG;
        }
        int uInt162 = ((uInt16 << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535);
        if (uInt162 == f5454b) {
            bVar.skip(21L);
            return bVar.a() >= 3 ? com.lxj.xpopup.d.a.PNG_A : com.lxj.xpopup.d.a.PNG;
        }
        if ((uInt162 >> 8) == a) {
            return com.lxj.xpopup.d.a.GIF;
        }
        if (uInt162 != f5456d) {
            return com.lxj.xpopup.d.a.UNKNOWN;
        }
        bVar.skip(4L);
        if ((((bVar.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535)) != f5457e) {
            return com.lxj.xpopup.d.a.UNKNOWN;
        }
        int uInt163 = ((bVar.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535);
        if ((uInt163 & (-256)) != f5458f) {
            return com.lxj.xpopup.d.a.UNKNOWN;
        }
        int i2 = uInt163 & 255;
        if (i2 == 88) {
            bVar.skip(4L);
            return (bVar.a() & 16) != 0 ? com.lxj.xpopup.d.a.WEBP_A : com.lxj.xpopup.d.a.WEBP;
        }
        if (i2 == 76) {
            bVar.skip(4L);
            return (bVar.a() & 8) != 0 ? com.lxj.xpopup.d.a.WEBP_A : com.lxj.xpopup.d.a.WEBP;
        }
        inputStream.close();
        return com.lxj.xpopup.d.a.WEBP;
    }
}
