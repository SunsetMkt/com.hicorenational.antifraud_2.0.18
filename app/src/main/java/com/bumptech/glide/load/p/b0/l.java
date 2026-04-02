package com.bumptech.glide.load.p.b0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2840e = "MemorySizeCalculator";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f2841f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f2842g = 2;
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f2844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2845d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    private static final class b implements c {
        private final DisplayMetrics a;

        b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.p.b0.l.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // com.bumptech.glide.load.p.b0.l.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    l(a aVar) {
        this.f2844c = aVar.a;
        this.f2845d = a(aVar.f2851b) ? aVar.f2857h / 2 : aVar.f2857h;
        int iA = a(aVar.f2851b, aVar.f2855f, aVar.f2856g);
        float fB = aVar.f2852c.b() * aVar.f2852c.a() * 4;
        int iRound = Math.round(aVar.f2854e * fB);
        int iRound2 = Math.round(fB * aVar.f2853d);
        int i2 = iA - this.f2845d;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.f2843b = iRound2;
            this.a = iRound;
        } else {
            float f2 = i2;
            float f3 = aVar.f2854e;
            float f4 = aVar.f2853d;
            float f5 = f2 / (f3 + f4);
            this.f2843b = Math.round(f4 * f5);
            this.a = Math.round(f5 * aVar.f2854e);
        }
        if (Log.isLoggable(f2840e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f2843b));
            sb.append(", pool size: ");
            sb.append(a(this.a));
            sb.append(", byte array size: ");
            sb.append(a(this.f2845d));
            sb.append(", memory class limited? ");
            sb.append(i3 > iA);
            sb.append(", max size: ");
            sb.append(a(iA));
            sb.append(", memoryClass: ");
            sb.append(aVar.f2851b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f2851b));
            sb.toString();
        }
    }

    public int a() {
        return this.f2845d;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.f2843b;
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @VisibleForTesting
        static final int f2846i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f2847j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final float f2848k = 0.4f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final float f2849l = 0.33f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static final int f2850m = 4194304;
        final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ActivityManager f2851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f2852c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2854e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f2853d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f2855f = f2848k;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f2856g = f2849l;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f2857h = 4194304;

        static {
            f2847j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f2854e = f2847j;
            this.a = context;
            this.f2851b = (ActivityManager) context.getSystemService("activity");
            this.f2852c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !l.a(this.f2851b)) {
                return;
            }
            this.f2854e = 0.0f;
        }

        public a a(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f2854e = f2;
            return this;
        }

        public a b(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f2856g = f2;
            return this;
        }

        public a c(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f2855f = f2;
            return this;
        }

        public a d(float f2) {
            com.bumptech.glide.util.j.a(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f2853d = f2;
            return this;
        }

        public a a(int i2) {
            this.f2857h = i2;
            return this;
        }

        @VisibleForTesting
        a a(ActivityManager activityManager) {
            this.f2851b = activityManager;
            return this;
        }

        @VisibleForTesting
        a a(c cVar) {
            this.f2852c = cVar;
            return this;
        }

        public l a() {
            return new l(this);
        }
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f2844c, i2);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
