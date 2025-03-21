package com.bumptech.glide.load.p125r.p126d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.util.C1876j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import p286h.C5230f1;

/* compiled from: DefaultImageHeaderParser.java */
/* renamed from: com.bumptech.glide.load.r.d.o */
/* loaded from: classes.dex */
public final class C1740o implements ImageHeaderParser {

    /* renamed from: b */
    private static final String f4881b = "DfltImageHeaderParser";

    /* renamed from: c */
    private static final int f4882c = 4671814;

    /* renamed from: d */
    private static final int f4883d = -1991225785;

    /* renamed from: e */
    static final int f4884e = 65496;

    /* renamed from: f */
    private static final int f4885f = 19789;

    /* renamed from: g */
    private static final int f4886g = 18761;

    /* renamed from: j */
    private static final int f4889j = 218;

    /* renamed from: k */
    private static final int f4890k = 217;

    /* renamed from: l */
    static final int f4891l = 255;

    /* renamed from: m */
    static final int f4892m = 225;

    /* renamed from: n */
    private static final int f4893n = 274;

    /* renamed from: p */
    private static final int f4895p = 1380533830;

    /* renamed from: q */
    private static final int f4896q = 1464156752;

    /* renamed from: r */
    private static final int f4897r = 1448097792;

    /* renamed from: s */
    private static final int f4898s = -256;

    /* renamed from: t */
    private static final int f4899t = 255;

    /* renamed from: u */
    private static final int f4900u = 88;

    /* renamed from: v */
    private static final int f4901v = 76;

    /* renamed from: w */
    private static final int f4902w = 16;

    /* renamed from: x */
    private static final int f4903x = 8;

    /* renamed from: h */
    private static final String f4887h = "Exif\u0000\u0000";

    /* renamed from: i */
    static final byte[] f4888i = f4887h.getBytes(Charset.forName("UTF-8"));

    /* renamed from: o */
    private static final int[] f4894o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.r.d.o$a */
    private static final class a implements c {

        /* renamed from: a */
        private final ByteBuffer f4904a;

        a(ByteBuffer byteBuffer) {
            this.f4904a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public int getUInt16() throws c.a {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public short getUInt8() throws c.a {
            if (this.f4904a.remaining() >= 1) {
                return (short) (this.f4904a.get() & C5230f1.f20085c);
            }
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public int read(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f4904a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f4904a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public long skip(long j2) {
            int min = (int) Math.min(this.f4904a.remaining(), j2);
            ByteBuffer byteBuffer = this.f4904a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.r.d.o$b */
    private static final class b {

        /* renamed from: a */
        private final ByteBuffer f4905a;

        b(byte[] bArr, int i2) {
            this.f4905a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        /* renamed from: a */
        void m4367a(ByteOrder byteOrder) {
            this.f4905a.order(byteOrder);
        }

        /* renamed from: b */
        int m4368b(int i2) {
            if (m4364a(i2, 4)) {
                return this.f4905a.getInt(i2);
            }
            return -1;
        }

        /* renamed from: a */
        int m4365a() {
            return this.f4905a.remaining();
        }

        /* renamed from: a */
        short m4366a(int i2) {
            if (m4364a(i2, 2)) {
                return this.f4905a.getShort(i2);
            }
            return (short) -1;
        }

        /* renamed from: a */
        private boolean m4364a(int i2, int i3) {
            return this.f4905a.remaining() - i2 >= i3;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.r.d.o$c */
    private interface c {

        /* compiled from: DefaultImageHeaderParser.java */
        /* renamed from: com.bumptech.glide.load.r.d.o$c$a */
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

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.r.d.o$d */
    private static final class d implements c {

        /* renamed from: a */
        private final InputStream f4906a;

        d(InputStream inputStream) {
            this.f4906a = inputStream;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public short getUInt8() throws IOException {
            int read = this.f4906a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f4906a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 == 0 && i4 == -1) {
                throw new c.a();
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1740o.c
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f4906a.skip(j3);
                if (skip <= 0) {
                    if (this.f4906a.read() == -1) {
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
    private static int m4356a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    /* renamed from: a */
    private static boolean m4361a(int i2) {
        return (i2 & f4884e) == f4884e || i2 == f4885f || i2 == f4886g;
    }

    /* renamed from: b */
    private int m4363b(c cVar) throws IOException {
        short uInt8;
        int uInt16;
        long j2;
        long skip;
        do {
            short uInt82 = cVar.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(f4881b, 3)) {
                    String str = "Unknown segmentId=" + ((int) uInt82);
                }
                return -1;
            }
            uInt8 = cVar.getUInt8();
            if (uInt8 == f4889j) {
                return -1;
            }
            if (uInt8 == f4890k) {
                Log.isLoggable(f4881b, 3);
                return -1;
            }
            uInt16 = cVar.getUInt16() - 2;
            if (uInt8 == f4892m) {
                return uInt16;
            }
            j2 = uInt16;
            skip = cVar.skip(j2);
        } while (skip == j2);
        if (Log.isLoggable(f4881b, 3)) {
            String str2 = "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip;
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo3815a(@NonNull InputStream inputStream) throws IOException {
        return m4360a(new d((InputStream) C1876j.m4985a(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo3816a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return m4360a(new a((ByteBuffer) C1876j.m4985a(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public int mo3813a(@NonNull InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        return m4358a(new d((InputStream) C1876j.m4985a(inputStream)), (InterfaceC1623b) C1876j.m4985a(interfaceC1623b));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public int mo3814a(@NonNull ByteBuffer byteBuffer, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        return m4358a(new a((ByteBuffer) C1876j.m4985a(byteBuffer)), (InterfaceC1623b) C1876j.m4985a(interfaceC1623b));
    }

    @NonNull
    /* renamed from: a */
    private ImageHeaderParser.ImageType m4360a(c cVar) throws IOException {
        try {
            int uInt16 = cVar.getUInt16();
            if (uInt16 == f4884e) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | cVar.getUInt8();
            if (uInt8 == f4882c) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | cVar.getUInt8();
            if (uInt82 == f4883d) {
                cVar.skip(21L);
                try {
                    return cVar.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt82 != f4895p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if (((cVar.getUInt16() << 16) | cVar.getUInt16()) != f4896q) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt162 = (cVar.getUInt16() << 16) | cVar.getUInt16();
            if ((uInt162 & (-256)) != f4897r) {
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

    /* renamed from: a */
    private int m4358a(c cVar, InterfaceC1623b interfaceC1623b) throws IOException {
        try {
            int uInt16 = cVar.getUInt16();
            if (!m4361a(uInt16)) {
                if (Log.isLoggable(f4881b, 3)) {
                    String str = "Parser doesn't handle magic number: " + uInt16;
                }
                return -1;
            }
            int m4363b = m4363b(cVar);
            if (m4363b == -1) {
                Log.isLoggable(f4881b, 3);
                return -1;
            }
            byte[] bArr = (byte[]) interfaceC1623b.mo3907b(m4363b, byte[].class);
            try {
                return m4359a(cVar, bArr, m4363b);
            } finally {
                interfaceC1623b.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private int m4359a(c cVar, byte[] bArr, int i2) throws IOException {
        int read = cVar.read(bArr, i2);
        if (read != i2) {
            if (Log.isLoggable(f4881b, 3)) {
                String str = "Unable to read exif segment data, length: " + i2 + ", actually read: " + read;
            }
            return -1;
        }
        if (m4362a(bArr, i2)) {
            return m4357a(new b(bArr, i2));
        }
        Log.isLoggable(f4881b, 3);
        return -1;
    }

    /* renamed from: a */
    private boolean m4362a(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f4888i.length;
        if (!z) {
            return z;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f4888i;
            if (i3 >= bArr2.length) {
                return z;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    /* renamed from: a */
    private static int m4357a(b bVar) {
        ByteOrder byteOrder;
        short m4366a = bVar.m4366a(6);
        if (m4366a == f4886g) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (m4366a != f4885f) {
            if (Log.isLoggable(f4881b, 3)) {
                String str = "Unknown endianness = " + ((int) m4366a);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.m4367a(byteOrder);
        int m4368b = bVar.m4368b(10) + 6;
        short m4366a2 = bVar.m4366a(m4368b);
        for (int i2 = 0; i2 < m4366a2; i2++) {
            int m4356a = m4356a(m4368b, i2);
            short m4366a3 = bVar.m4366a(m4356a);
            if (m4366a3 == f4893n) {
                short m4366a4 = bVar.m4366a(m4356a + 2);
                if (m4366a4 >= 1 && m4366a4 <= 12) {
                    int m4368b2 = bVar.m4368b(m4356a + 4);
                    if (m4368b2 < 0) {
                        Log.isLoggable(f4881b, 3);
                    } else {
                        if (Log.isLoggable(f4881b, 3)) {
                            String str2 = "Got tagIndex=" + i2 + " tagType=" + ((int) m4366a3) + " formatCode=" + ((int) m4366a4) + " componentCount=" + m4368b2;
                        }
                        int i3 = m4368b2 + f4894o[m4366a4];
                        if (i3 > 4) {
                            if (Log.isLoggable(f4881b, 3)) {
                                String str3 = "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) m4366a4);
                            }
                        } else {
                            int i4 = m4356a + 8;
                            if (i4 >= 0 && i4 <= bVar.m4365a()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.m4365a()) {
                                    return bVar.m4366a(i4);
                                }
                                if (Log.isLoggable(f4881b, 3)) {
                                    String str4 = "Illegal number of bytes for TI tag data tagType=" + ((int) m4366a3);
                                }
                            } else if (Log.isLoggable(f4881b, 3)) {
                                String str5 = "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) m4366a3);
                            }
                        }
                    }
                } else if (Log.isLoggable(f4881b, 3)) {
                    String str6 = "Got invalid format code = " + ((int) m4366a4);
                }
            }
        }
        return -1;
    }
}
