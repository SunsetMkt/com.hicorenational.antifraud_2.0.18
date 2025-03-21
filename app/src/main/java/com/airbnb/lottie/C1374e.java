package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.p110z.C1487b;
import com.airbnb.lottie.p110z.C1492g;
import com.airbnb.lottie.p110z.C1493h;
import com.airbnb.lottie.p110z.InterfaceC1490e;
import com.airbnb.lottie.p110z.InterfaceC1491f;
import java.io.File;

/* compiled from: L.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.airbnb.lottie.e */
/* loaded from: classes.dex */
public class C1374e {

    /* renamed from: a */
    public static boolean f3188a = false;

    /* renamed from: b */
    public static final String f3189b = "LOTTIE";

    /* renamed from: c */
    private static final int f3190c = 20;

    /* renamed from: d */
    private static boolean f3191d = false;

    /* renamed from: e */
    private static String[] f3192e;

    /* renamed from: f */
    private static long[] f3193f;

    /* renamed from: g */
    private static int f3194g;

    /* renamed from: h */
    private static int f3195h;

    /* renamed from: i */
    private static InterfaceC1491f f3196i;

    /* renamed from: j */
    private static InterfaceC1490e f3197j;

    /* renamed from: k */
    private static volatile C1493h f3198k;

    /* renamed from: l */
    private static volatile C1492g f3199l;

    /* compiled from: L.java */
    /* renamed from: com.airbnb.lottie.e$a */
    class a implements InterfaceC1490e {

        /* renamed from: a */
        final /* synthetic */ Context f3200a;

        a(Context context) {
            this.f3200a = context;
        }

        @Override // com.airbnb.lottie.p110z.InterfaceC1490e
        @NonNull
        /* renamed from: a */
        public File mo2885a() {
            return new File(this.f3200a.getCacheDir(), "lottie_network_cache");
        }
    }

    private C1374e() {
    }

    /* renamed from: a */
    public static void m2882a(boolean z) {
        if (f3191d == z) {
            return;
        }
        f3191d = z;
        if (f3191d) {
            f3192e = new String[20];
            f3193f = new long[20];
        }
    }

    /* renamed from: b */
    public static float m2883b(String str) {
        int i2 = f3195h;
        if (i2 > 0) {
            f3195h = i2 - 1;
            return 0.0f;
        }
        if (!f3191d) {
            return 0.0f;
        }
        f3194g--;
        int i3 = f3194g;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f3192e[i3])) {
            TraceCompat.endSection();
            return (System.nanoTime() - f3193f[f3194g]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f3192e[f3194g] + ".");
    }

    /* renamed from: a */
    public static void m2881a(String str) {
        if (f3191d) {
            int i2 = f3194g;
            if (i2 == 20) {
                f3195h++;
                return;
            }
            f3192e[i2] = str;
            f3193f[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f3194g++;
        }
    }

    @NonNull
    /* renamed from: b */
    public static C1493h m2884b(@NonNull Context context) {
        C1493h c1493h = f3198k;
        if (c1493h == null) {
            synchronized (C1493h.class) {
                c1493h = f3198k;
                if (c1493h == null) {
                    c1493h = new C1493h(m2878a(context), f3196i != null ? f3196i : new C1487b());
                    f3198k = c1493h;
                }
            }
        }
        return c1493h;
    }

    /* renamed from: a */
    public static void m2880a(InterfaceC1491f interfaceC1491f) {
        f3196i = interfaceC1491f;
    }

    /* renamed from: a */
    public static void m2879a(InterfaceC1490e interfaceC1490e) {
        f3197j = interfaceC1490e;
    }

    @NonNull
    /* renamed from: a */
    public static C1492g m2878a(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        C1492g c1492g = f3199l;
        if (c1492g == null) {
            synchronized (C1492g.class) {
                c1492g = f3199l;
                if (c1492g == null) {
                    c1492g = new C1492g(f3197j != null ? f3197j : new a(applicationContext));
                    f3199l = c1492g;
                }
            }
        }
        return c1492g;
    }
}
