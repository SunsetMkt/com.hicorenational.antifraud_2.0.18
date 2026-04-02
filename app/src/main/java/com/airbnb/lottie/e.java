package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.io.File;

/* JADX INFO: compiled from: L.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class e {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2138b = "LOTTIE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f2139c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2140d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f2141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long[] f2142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f2143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f2144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static com.airbnb.lottie.z.f f2145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static com.airbnb.lottie.z.e f2146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile com.airbnb.lottie.z.h f2147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile com.airbnb.lottie.z.g f2148l;

    /* JADX INFO: compiled from: L.java */
    class a implements com.airbnb.lottie.z.e {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.airbnb.lottie.z.e
        @NonNull
        public File a() {
            return new File(this.a.getCacheDir(), "lottie_network_cache");
        }
    }

    private e() {
    }

    public static void a(boolean z) {
        if (f2140d == z) {
            return;
        }
        f2140d = z;
        if (f2140d) {
            f2141e = new String[20];
            f2142f = new long[20];
        }
    }

    public static float b(String str) {
        int i2 = f2144h;
        if (i2 > 0) {
            f2144h = i2 - 1;
            return 0.0f;
        }
        if (!f2140d) {
            return 0.0f;
        }
        f2143g--;
        int i3 = f2143g;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f2141e[i3])) {
            TraceCompat.endSection();
            return (System.nanoTime() - f2142f[f2143g]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f2141e[f2143g] + ".");
    }

    public static void a(String str) {
        if (f2140d) {
            int i2 = f2143g;
            if (i2 == 20) {
                f2144h++;
                return;
            }
            f2141e[i2] = str;
            f2142f[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f2143g++;
        }
    }

    @NonNull
    public static com.airbnb.lottie.z.h b(@NonNull Context context) {
        com.airbnb.lottie.z.h hVar = f2147k;
        if (hVar == null) {
            synchronized (com.airbnb.lottie.z.h.class) {
                hVar = f2147k;
                if (hVar == null) {
                    hVar = new com.airbnb.lottie.z.h(a(context), f2145i != null ? f2145i : new com.airbnb.lottie.z.b());
                    f2147k = hVar;
                }
            }
        }
        return hVar;
    }

    public static void a(com.airbnb.lottie.z.f fVar) {
        f2145i = fVar;
    }

    public static void a(com.airbnb.lottie.z.e eVar) {
        f2146j = eVar;
    }

    @NonNull
    public static com.airbnb.lottie.z.g a(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        com.airbnb.lottie.z.g gVar = f2148l;
        if (gVar == null) {
            synchronized (com.airbnb.lottie.z.g.class) {
                gVar = f2148l;
                if (gVar == null) {
                    gVar = new com.airbnb.lottie.z.g(f2146j != null ? f2146j : new a(applicationContext));
                    f2148l = gVar;
                }
            }
        }
        return gVar;
    }
}
