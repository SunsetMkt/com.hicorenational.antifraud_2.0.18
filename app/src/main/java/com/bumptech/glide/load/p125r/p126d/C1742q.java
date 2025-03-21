package com.bumptech.glide.load.p125r.p126d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.C1595i;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1588b;
import com.bumptech.glide.load.EnumC1597k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.p116o.C1613m;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p126d.AbstractC1741p;
import com.bumptech.glide.load.p125r.p126d.InterfaceC1749x;
import com.bumptech.glide.util.C1872f;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* renamed from: com.bumptech.glide.load.r.d.q */
/* loaded from: classes.dex */
public final class C1742q {

    /* renamed from: f */
    static final String f4917f = "Downsampler";

    /* renamed from: g */
    public static final C1595i<EnumC1588b> f4918g = C1595i.m3831a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", EnumC1588b.DEFAULT);

    /* renamed from: h */
    public static final C1595i<EnumC1597k> f4919h = C1595i.m3831a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", EnumC1597k.SRGB);

    /* renamed from: i */
    @Deprecated
    public static final C1595i<AbstractC1741p> f4920i = AbstractC1741p.f4914h;

    /* renamed from: j */
    public static final C1595i<Boolean> f4921j = C1595i.m3831a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: k */
    public static final C1595i<Boolean> f4922k = C1595i.m3831a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);

    /* renamed from: l */
    private static final String f4923l = "image/vnd.wap.wbmp";

    /* renamed from: m */
    private static final String f4924m = "image/x-ico";

    /* renamed from: n */
    private static final Set<String> f4925n = Collections.unmodifiableSet(new HashSet(Arrays.asList(f4923l, f4924m)));

    /* renamed from: o */
    private static final b f4926o = new a();

    /* renamed from: p */
    private static final Set<ImageHeaderParser.ImageType> f4927p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: q */
    private static final Queue<BitmapFactory.Options> f4928q = C1878l.m5002a(0);

    /* renamed from: a */
    private final InterfaceC1626e f4929a;

    /* renamed from: b */
    private final DisplayMetrics f4930b;

    /* renamed from: c */
    private final InterfaceC1623b f4931c;

    /* renamed from: d */
    private final List<ImageHeaderParser> f4932d;

    /* renamed from: e */
    private final C1748w f4933e = C1748w.m4401a();

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.r.d.q$a */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1742q.b
        /* renamed from: a */
        public void mo4313a() {
        }

        @Override // com.bumptech.glide.load.p125r.p126d.C1742q.b
        /* renamed from: a */
        public void mo4314a(InterfaceC1626e interfaceC1626e, Bitmap bitmap) {
        }
    }

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.r.d.q$b */
    public interface b {
        /* renamed from: a */
        void mo4313a();

        /* renamed from: a */
        void mo4314a(InterfaceC1626e interfaceC1626e, Bitmap bitmap) throws IOException;
    }

    public C1742q(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, InterfaceC1626e interfaceC1626e, InterfaceC1623b interfaceC1623b) {
        this.f4932d = list;
        this.f4930b = (DisplayMetrics) C1876j.m4985a(displayMetrics);
        this.f4929a = (InterfaceC1626e) C1876j.m4985a(interfaceC1626e);
        this.f4931c = (InterfaceC1623b) C1876j.m4985a(interfaceC1623b);
    }

    /* renamed from: a */
    private static boolean m4383a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    /* renamed from: b */
    private static int m4385b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    /* renamed from: c */
    private static int m4388c(double d2) {
        return (int) (d2 + 0.5d);
    }

    /* renamed from: c */
    private static void m4389c(BitmapFactory.Options options) {
        m4390d(options);
        synchronized (f4928q) {
            f4928q.offer(options);
        }
    }

    /* renamed from: d */
    private static void m4390d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* renamed from: a */
    public boolean m4394a(ParcelFileDescriptor parcelFileDescriptor) {
        return C1613m.m3870c();
    }

    /* renamed from: a */
    public boolean m4395a(InputStream inputStream) {
        return true;
    }

    /* renamed from: a */
    public boolean m4396a(ByteBuffer byteBuffer) {
        return true;
    }

    /* renamed from: b */
    private static int[] m4387b(InterfaceC1749x interfaceC1749x, BitmapFactory.Options options, b bVar, InterfaceC1626e interfaceC1626e) throws IOException {
        options.inJustDecodeBounds = true;
        m4373a(interfaceC1749x, options, bVar, interfaceC1626e);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: a */
    public InterfaceC1677v<Bitmap> m4392a(InputStream inputStream, int i2, int i3, C1596j c1596j) throws IOException {
        return m4393a(inputStream, i2, i3, c1596j, f4926o);
    }

    /* renamed from: a */
    public InterfaceC1677v<Bitmap> m4393a(InputStream inputStream, int i2, int i3, C1596j c1596j, b bVar) throws IOException {
        return m4375a(new InterfaceC1749x.a(inputStream, this.f4932d, this.f4931c), i2, i3, c1596j, bVar);
    }

    @RequiresApi(21)
    /* renamed from: a */
    public InterfaceC1677v<Bitmap> m4391a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, C1596j c1596j) throws IOException {
        return m4375a(new InterfaceC1749x.b(parcelFileDescriptor, this.f4932d, this.f4931c), i2, i3, c1596j, f4926o);
    }

    /* renamed from: a */
    private InterfaceC1677v<Bitmap> m4375a(InterfaceC1749x interfaceC1749x, int i2, int i3, C1596j c1596j, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f4931c.mo3907b(65536, byte[].class);
        BitmapFactory.Options m4374a = m4374a();
        m4374a.inTempStorage = bArr;
        EnumC1588b enumC1588b = (EnumC1588b) c1596j.m3840a(f4918g);
        EnumC1597k enumC1597k = (EnumC1597k) c1596j.m3840a(f4919h);
        try {
            return C1728g.m4315a(m4372a(interfaceC1749x, m4374a, (AbstractC1741p) c1596j.m3840a(AbstractC1741p.f4914h), enumC1588b, enumC1597k, c1596j.m3840a(f4922k) != null && ((Boolean) c1596j.m3840a(f4922k)).booleanValue(), i2, i3, ((Boolean) c1596j.m3840a(f4921j)).booleanValue(), bVar), this.f4929a);
        } finally {
            m4389c(m4374a);
            this.f4931c.put(bArr);
        }
    }

    /* renamed from: b */
    private static boolean m4386b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    /* renamed from: a */
    private Bitmap m4372a(InterfaceC1749x interfaceC1749x, BitmapFactory.Options options, AbstractC1741p abstractC1741p, EnumC1588b enumC1588b, EnumC1597k enumC1597k, boolean z, int i2, int i3, boolean z2, b bVar) throws IOException {
        int i4;
        int i5;
        int i6;
        C1742q c1742q;
        int round;
        int round2;
        int i7;
        ColorSpace colorSpace;
        long m4970a = C1872f.m4970a();
        int[] m4387b = m4387b(interfaceC1749x, options, bVar, this.f4929a);
        boolean z3 = false;
        int i8 = m4387b[0];
        int i9 = m4387b[1];
        String str = options.outMimeType;
        boolean z4 = (i8 == -1 || i9 == -1) ? false : z;
        int mo4406a = interfaceC1749x.mo4406a();
        int m4316a = C1729g0.m4316a(mo4406a);
        boolean m4333b = C1729g0.m4333b(mo4406a);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = m4383a(m4316a) ? i9 : i8;
        } else {
            i4 = i3;
            i5 = i2;
        }
        if (i4 == Integer.MIN_VALUE) {
            i6 = m4383a(m4316a) ? i8 : i9;
        } else {
            i6 = i4;
        }
        ImageHeaderParser.ImageType mo4409c = interfaceC1749x.mo4409c();
        m4381a(mo4409c, interfaceC1749x, bVar, this.f4929a, abstractC1741p, m4316a, i8, i9, i5, i6, options);
        m4382a(interfaceC1749x, enumC1588b, z4, m4333b, options, i5, i6);
        boolean z5 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z5) {
            c1742q = this;
            if (c1742q.m4384a(mo4409c)) {
                if (i8 < 0 || i9 < 0 || !z2 || !z5) {
                    float f2 = m4386b(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i10 = options.inSampleSize;
                    float f3 = i10;
                    int ceil = (int) Math.ceil(i8 / f3);
                    int ceil2 = (int) Math.ceil(i9 / f3);
                    round = Math.round(ceil * f2);
                    round2 = Math.round(ceil2 * f2);
                    if (Log.isLoggable(f4917f, 2)) {
                        String str2 = "Calculated target [" + round + "x" + round2 + "] for source [" + i8 + "x" + i9 + "], sampleSize: " + i10 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2;
                    }
                } else {
                    round = i5;
                    round2 = i6;
                }
                if (round > 0 && round2 > 0) {
                    m4380a(options, c1742q.f4929a, round, round2);
                }
            }
        } else {
            c1742q = this;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            if (enumC1597k == EnumC1597k.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i11 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap m4373a = m4373a(interfaceC1749x, options, bVar, c1742q.f4929a);
        bVar.mo4314a(c1742q.f4929a, m4373a);
        if (Log.isLoggable(f4917f, 2)) {
            i7 = mo4406a;
            m4379a(i8, i9, str, options, m4373a, i2, i3, m4970a);
        } else {
            i7 = mo4406a;
        }
        Bitmap bitmap = null;
        if (m4373a != null) {
            m4373a.setDensity(c1742q.f4930b.densityDpi);
            bitmap = C1729g0.m4321a(c1742q.f4929a, m4373a, i7);
            if (!m4373a.equals(bitmap)) {
                c1742q.f4929a.mo3924a(m4373a);
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private static void m4381a(ImageHeaderParser.ImageType imageType, InterfaceC1749x interfaceC1749x, b bVar, InterfaceC1626e interfaceC1626e, AbstractC1741p abstractC1741p, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int min;
        int max;
        int floor;
        double floor2;
        int i9;
        if (i3 > 0 && i4 > 0) {
            if (m4383a(i2)) {
                i8 = i3;
                i7 = i4;
            } else {
                i7 = i3;
                i8 = i4;
            }
            float mo4370b = abstractC1741p.mo4370b(i7, i8, i5, i6);
            if (mo4370b > 0.0f) {
                AbstractC1741p.g mo4369a = abstractC1741p.mo4369a(i7, i8, i5, i6);
                if (mo4369a != null) {
                    float f2 = i7;
                    float f3 = i8;
                    int m4388c = i7 / m4388c(mo4370b * f2);
                    int m4388c2 = i8 / m4388c(mo4370b * f3);
                    if (mo4369a == AbstractC1741p.g.MEMORY) {
                        min = Math.max(m4388c, m4388c2);
                    } else {
                        min = Math.min(m4388c, m4388c2);
                    }
                    if (Build.VERSION.SDK_INT > 23 || !f4925n.contains(options.outMimeType)) {
                        max = Math.max(1, Integer.highestOneBit(min));
                        if (mo4369a == AbstractC1741p.g.MEMORY && max < 1.0f / mo4370b) {
                            max <<= 1;
                        }
                    } else {
                        max = 1;
                    }
                    options.inSampleSize = max;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(max, 8);
                        floor = (int) Math.ceil(f2 / min2);
                        i9 = (int) Math.ceil(f3 / min2);
                        int i10 = max / 8;
                        if (i10 > 0) {
                            floor /= i10;
                            i9 /= i10;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                                if (i7 % max == 0 && i8 % max == 0) {
                                    floor = i7 / max;
                                    i9 = i8 / max;
                                } else {
                                    int[] m4387b = m4387b(interfaceC1749x, options, bVar, interfaceC1626e);
                                    floor = m4387b[0];
                                    i9 = m4387b[1];
                                }
                            } else if (Build.VERSION.SDK_INT >= 24) {
                                float f4 = max;
                                floor = Math.round(f2 / f4);
                                i9 = Math.round(f3 / f4);
                            } else {
                                float f5 = max;
                                floor = (int) Math.floor(f2 / f5);
                                floor2 = Math.floor(f3 / f5);
                            }
                        } else {
                            float f6 = max;
                            floor = (int) Math.floor(f2 / f6);
                            floor2 = Math.floor(f3 / f6);
                        }
                        i9 = (int) floor2;
                    }
                    double mo4370b2 = abstractC1741p.mo4370b(floor, i9, i5, i6);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options.inTargetDensity = m4371a(mo4370b2);
                        options.inDensity = m4385b(mo4370b2);
                    }
                    if (m4386b(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable(f4917f, 2)) {
                        String str = "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + floor + "x" + i9 + "], exact scale factor: " + mo4370b + ", power of 2 sample size: " + max + ", adjusted scale factor: " + mo4370b2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + mo4370b + " from: " + abstractC1741p + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        if (Log.isLoggable(f4917f, 3)) {
            String str2 = "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]";
        }
    }

    /* renamed from: a */
    private static int m4371a(double d2) {
        return m4388c((d2 / (r1 / r0)) * m4388c(m4385b(d2) * d2));
    }

    /* renamed from: a */
    private boolean m4384a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f4927p.contains(imageType);
    }

    /* renamed from: a */
    private void m4382a(InterfaceC1749x interfaceC1749x, EnumC1588b enumC1588b, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.f4933e.m4404a(i2, i3, options, z, z2)) {
            return;
        }
        if (enumC1588b != EnumC1588b.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean z3 = false;
            try {
                z3 = interfaceC1749x.mo4409c().hasAlpha();
            } catch (IOException unused) {
                if (Log.isLoggable(f4917f, 3)) {
                    String str = "Cannot determine whether the image has alpha or not from header, format " + enumC1588b;
                }
            }
            options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        throw r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap m4373a(com.bumptech.glide.load.p125r.p126d.InterfaceC1749x r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.p125r.p126d.C1742q.b r6, com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.mo4313a()
            r4.mo4408b()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.p125r.p126d.C1729g0.m4325a()
            r3.lock()
            android.graphics.Bitmap r4 = r4.mo4407a(r5)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalArgumentException -> L25
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.p125r.p126d.C1729g0.m4325a()
            r5.unlock()
            return r4
        L23:
            r4 = move-exception
            goto L4b
        L25:
            r3 = move-exception
            java.io.IOException r0 = m4376a(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L23
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L4a
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            r7.mo3924a(r1)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            r1 = 0
            r5.inBitmap = r1     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            android.graphics.Bitmap r4 = m4373a(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.p125r.p126d.C1729g0.m4325a()
            r5.unlock()
            return r4
        L49:
            throw r0     // Catch: java.lang.Throwable -> L23
        L4a:
            throw r0     // Catch: java.lang.Throwable -> L23
        L4b:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.p125r.p126d.C1729g0.m4325a()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p125r.p126d.C1742q.m4373a(com.bumptech.glide.load.r.d.x, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.r.d.q$b, com.bumptech.glide.load.p.a0.e):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static void m4379a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        String str2 = "Decoded " + m4377a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + m4378a(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + C1872f.m4969a(j2);
    }

    /* renamed from: a */
    private static String m4378a(BitmapFactory.Options options) {
        return m4377a(options.inBitmap);
    }

    @Nullable
    @TargetApi(19)
    /* renamed from: a */
    private static String m4377a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    /* renamed from: a */
    private static IOException m4376a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + m4378a(options), illegalArgumentException);
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m4380a(BitmapFactory.Options options, InterfaceC1626e interfaceC1626e, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = interfaceC1626e.mo3926b(i2, i3, config);
    }

    /* renamed from: a */
    private static synchronized BitmapFactory.Options m4374a() {
        BitmapFactory.Options poll;
        synchronized (C1742q.class) {
            synchronized (f4928q) {
                poll = f4928q.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                m4390d(poll);
            }
        }
        return poll;
    }
}
