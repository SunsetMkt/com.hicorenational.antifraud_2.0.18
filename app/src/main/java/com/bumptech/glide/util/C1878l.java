package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p123q.InterfaceC1693l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import p286h.C5230f1;

/* compiled from: Util.java */
/* renamed from: com.bumptech.glide.util.l */
/* loaded from: classes.dex */
public final class C1878l {

    /* renamed from: a */
    private static final int f5496a = 31;

    /* renamed from: b */
    private static final int f5497b = 17;

    /* renamed from: c */
    private static final char[] f5498c = "0123456789abcdef".toCharArray();

    /* renamed from: d */
    private static final char[] f5499d = new char[64];

    /* compiled from: Util.java */
    /* renamed from: com.bumptech.glide.util.l$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f5500a = new int[Bitmap.Config.values().length];

        static {
            try {
                f5500a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5500a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5500a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5500a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5500a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private C1878l() {
    }

    /* renamed from: a */
    public static int m4992a(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    @NonNull
    /* renamed from: a */
    public static String m4999a(@NonNull byte[] bArr) {
        String m5000a;
        synchronized (f5499d) {
            m5000a = m5000a(bArr, f5499d);
        }
        return m5000a;
    }

    @Deprecated
    /* renamed from: b */
    public static int m5006b(@NonNull Bitmap bitmap) {
        return m4995a(bitmap);
    }

    /* renamed from: c */
    public static boolean m5010c() {
        return !m5012d();
    }

    /* renamed from: c */
    private static boolean m5011c(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    /* renamed from: d */
    public static boolean m5012d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static boolean m5008b(int i2, int i3) {
        return m5011c(i2) && m5011c(i3);
    }

    /* renamed from: b */
    public static void m5007b() {
        if (!m5012d()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    @NonNull
    /* renamed from: a */
    private static String m5000a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & C5230f1.f20085c;
            int i4 = i2 * 2;
            char[] cArr2 = f5498c;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static boolean m5009b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static int m5005b(int i2) {
        return m4992a(i2, 17);
    }

    @TargetApi(19)
    /* renamed from: a */
    public static int m4995a(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    /* renamed from: a */
    public static int m4993a(int i2, int i3, @Nullable Bitmap.Config config) {
        return i2 * i3 * m4994a(config);
    }

    /* renamed from: a */
    private static int m4994a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = a.f5500a[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 4 : 8;
    }

    /* renamed from: a */
    public static void m5003a() {
        if (!m5010c()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    @NonNull
    /* renamed from: a */
    public static <T> Queue<T> m5002a(int i2) {
        return new ArrayDeque(i2);
    }

    @NonNull
    /* renamed from: a */
    public static <T> List<T> m5001a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m5004a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof InterfaceC1693l) {
            return ((InterfaceC1693l) obj).m4250a(obj2);
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static int m4990a(float f2) {
        return m4991a(f2, 17);
    }

    /* renamed from: a */
    public static int m4991a(float f2, int i2) {
        return m4992a(Float.floatToIntBits(f2), i2);
    }

    /* renamed from: a */
    public static int m4996a(@Nullable Object obj, int i2) {
        return m4992a(obj == null ? 0 : obj.hashCode(), i2);
    }

    /* renamed from: a */
    public static int m4998a(boolean z, int i2) {
        return m4992a(z ? 1 : 0, i2);
    }

    /* renamed from: a */
    public static int m4997a(boolean z) {
        return m4998a(z, 17);
    }
}
