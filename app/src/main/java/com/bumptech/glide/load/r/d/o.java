package com.bumptech.glide.load.r.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import i.f1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: DefaultImageHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class o implements ImageHeaderParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3187b = "DfltImageHeaderParser";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f3188c = 4671814;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f3189d = -1991225785;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f3190e = 65496;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f3191f = 19789;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f3192g = 18761;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f3195j = 218;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f3196k = 217;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f3197l = 255;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f3198m = 225;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f3199n = 274;
    private static final int p = 1380533830;
    private static final int q = 1464156752;
    private static final int r = 1448097792;
    private static final int s = -256;
    private static final int t = 255;
    private static final int u = 88;
    private static final int v = 76;
    private static final int w = 16;
    private static final int x = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f3193h = "Exif\u0000\u0000";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final byte[] f3194i = f3193h.getBytes(Charset.forName("UTF-8"));
    private static final int[] o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class a implements c {
        private final ByteBuffer a;

        a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int getUInt16() throws c.a {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public short getUInt8() throws c.a {
            if (this.a.remaining() >= 1) {
                return (short) (this.a.get() & f1.f12066c);
            }
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int read(byte[] bArr, int i2) {
            int iMin = Math.min(i2, this.a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public long skip(long j2) {
            int iMin = (int) Math.min(this.a.remaining(), j2);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class b {
        private final ByteBuffer a;

        b(byte[] bArr, int i2) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        void a(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }

        int b(int i2) {
            if (a(i2, 4)) {
                return this.a.getInt(i2);
            }
            return -1;
        }

        int a() {
            return this.a.remaining();
        }

        short a(int i2) {
            if (a(i2, 2)) {
                return this.a.getShort(i2);
            }
            return (short) -1;
        }

        private boolean a(int i2, int i3) {
            return this.a.remaining() - i2 >= i3;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private interface c {

        /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
        public static final class a extends IOException {
            private static final long serialVersionUID = 1;

            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j2) throws IOException;
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class d implements c {
        private final InputStream a;

        d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public short getUInt8() throws IOException {
            int i2 = this.a.read();
            if (i2 != -1) {
                return (short) i2;
            }
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 == 0 && i4 == -1) {
                throw new c.a();
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.r.d.o.c
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

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private static boolean a(int i2) {
        return (i2 & f3190e) == f3190e || i2 == f3191f || i2 == f3192g;
    }

    private int b(c cVar) throws IOException {
        short uInt8;
        int uInt16;
        long j2;
        long jSkip;
        do {
            short uInt82 = cVar.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(f3187b, 3)) {
                    String str = "Unknown segmentId=" + ((int) uInt82);
                }
                return -1;
            }
            uInt8 = cVar.getUInt8();
            if (uInt8 == f3195j) {
                return -1;
            }
            if (uInt8 == f3196k) {
                Log.isLoggable(f3187b, 3);
                return -1;
            }
            uInt16 = cVar.getUInt16() - 2;
            if (uInt8 == f3198m) {
                return uInt16;
            }
            j2 = uInt16;
            jSkip = cVar.skip(j2);
        } while (jSkip == j2);
        if (Log.isLoggable(f3187b, 3)) {
            String str2 = "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + jSkip;
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) throws IOException {
        return a(new d((InputStream) com.bumptech.glide.util.j.a(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return a(new a((ByteBuffer) com.bumptech.glide.util.j.a(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(new d((InputStream) com.bumptech.glide.util.j.a(inputStream)), (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(new a((ByteBuffer) com.bumptech.glide.util.j.a(byteBuffer)), (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar));
    }

    @NonNull
    private ImageHeaderParser.ImageType a(c cVar) throws IOException {
        try {
            int uInt16 = cVar.getUInt16();
            if (uInt16 == f3190e) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | cVar.getUInt8();
            if (uInt8 == f3188c) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | cVar.getUInt8();
            if (uInt82 == f3189d) {
                cVar.skip(21L);
                try {
                    return cVar.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt82 != p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if (((cVar.getUInt16() << 16) | cVar.getUInt16()) != q) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt162 = (cVar.getUInt16() << 16) | cVar.getUInt16();
            if ((uInt162 & (-256)) != r) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = uInt162 & 255;
            if (i2 == 88) {
                cVar.skip(4L);
                return (cVar.getUInt8() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i2 == 76) {
                cVar.skip(4L);
                return (cVar.getUInt8() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private int a(c cVar, com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        try {
            int uInt16 = cVar.getUInt16();
            if (!a(uInt16)) {
                if (Log.isLoggable(f3187b, 3)) {
                    String str = "Parser doesn't handle magic number: " + uInt16;
                }
                return -1;
            }
            int iB = b(cVar);
            if (iB == -1) {
                Log.isLoggable(f3187b, 3);
                return -1;
            }
            byte[] bArr = (byte[]) bVar.b(iB, byte[].class);
            try {
                return a(cVar, bArr, iB);
            } finally {
                bVar.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    private int a(c cVar, byte[] bArr, int i2) throws IOException {
        int i3 = cVar.read(bArr, i2);
        if (i3 != i2) {
            if (Log.isLoggable(f3187b, 3)) {
                String str = "Unable to read exif segment data, length: " + i2 + ", actually read: " + i3;
            }
            return -1;
        }
        if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        }
        Log.isLoggable(f3187b, 3);
        return -1;
    }

    private boolean a(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f3194i.length;
        if (!z) {
            return z;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f3194i;
            if (i3 >= bArr2.length) {
                return z;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != f3192g) {
            if (sA != f3191f && Log.isLoggable(f3187b, 3)) {
                String str = "Unknown endianness = " + ((int) sA);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i2 = 0; i2 < sA2; i2++) {
            int iA = a(iB, i2);
            short sA3 = bVar.a(iA);
            if (sA3 == f3199n) {
                short sA4 = bVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iA + 4);
                    if (iB2 < 0) {
                        Log.isLoggable(f3187b, 3);
                    } else {
                        if (Log.isLoggable(f3187b, 3)) {
                            String str2 = "Got tagIndex=" + i2 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2;
                        }
                        int i3 = iB2 + o[sA4];
                        if (i3 > 4) {
                            if (Log.isLoggable(f3187b, 3)) {
                                String str3 = "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4);
                            }
                        } else {
                            int i4 = iA + 8;
                            if (i4 >= 0 && i4 <= bVar.a()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                    return bVar.a(i4);
                                }
                                if (Log.isLoggable(f3187b, 3)) {
                                    String str4 = "Illegal number of bytes for TI tag data tagType=" + ((int) sA3);
                                }
                            } else if (Log.isLoggable(f3187b, 3)) {
                                String str5 = "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) sA3);
                            }
                        }
                    }
                } else if (Log.isLoggable(f3187b, 3)) {
                    String str6 = "Got invalid format code = " + ((int) sA4);
                }
            }
        }
        return -1;
    }
}
