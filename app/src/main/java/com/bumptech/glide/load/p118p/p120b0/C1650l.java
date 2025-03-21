package com.bumptech.glide.load.p118p.p120b0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1876j;

/* compiled from: MemorySizeCalculator.java */
/* renamed from: com.bumptech.glide.load.p.b0.l */
/* loaded from: classes.dex */
public final class C1650l {

    /* renamed from: e */
    private static final String f4365e = "MemorySizeCalculator";

    /* renamed from: f */
    @VisibleForTesting
    static final int f4366f = 4;

    /* renamed from: g */
    private static final int f4367g = 2;

    /* renamed from: a */
    private final int f4368a;

    /* renamed from: b */
    private final int f4369b;

    /* renamed from: c */
    private final Context f4370c;

    /* renamed from: d */
    private final int f4371d;

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.p.b0.l$b */
    private static final class b implements c {

        /* renamed from: a */
        private final DisplayMetrics f4385a;

        b(DisplayMetrics displayMetrics) {
            this.f4385a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1650l.c
        /* renamed from: a */
        public int mo4020a() {
            return this.f4385a.heightPixels;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1650l.c
        /* renamed from: b */
        public int mo4021b() {
            return this.f4385a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.p.b0.l$c */
    interface c {
        /* renamed from: a */
        int mo4020a();

        /* renamed from: b */
        int mo4021b();
    }

    C1650l(a aVar) {
        this.f4370c = aVar.f4377a;
        this.f4371d = m4008a(aVar.f4378b) ? aVar.f4384h / 2 : aVar.f4384h;
        int m4006a = m4006a(aVar.f4378b, aVar.f4382f, aVar.f4383g);
        float mo4021b = aVar.f4379c.mo4021b() * aVar.f4379c.mo4020a() * 4;
        int round = Math.round(aVar.f4381e * mo4021b);
        int round2 = Math.round(mo4021b * aVar.f4380d);
        int i2 = m4006a - this.f4371d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f4369b = round2;
            this.f4368a = round;
        } else {
            float f2 = i2;
            float f3 = aVar.f4381e;
            float f4 = aVar.f4380d;
            float f5 = f2 / (f3 + f4);
            this.f4369b = Math.round(f4 * f5);
            this.f4368a = Math.round(f5 * aVar.f4381e);
        }
        if (Log.isLoggable(f4365e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m4007a(this.f4369b));
            sb.append(", pool size: ");
            sb.append(m4007a(this.f4368a));
            sb.append(", byte array size: ");
            sb.append(m4007a(this.f4371d));
            sb.append(", memory class limited? ");
            sb.append(i3 > m4006a);
            sb.append(", max size: ");
            sb.append(m4007a(m4006a));
            sb.append(", memoryClass: ");
            sb.append(aVar.f4378b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m4008a(aVar.f4378b));
            sb.toString();
        }
    }

    /* renamed from: a */
    public int m4009a() {
        return this.f4371d;
    }

    /* renamed from: b */
    public int m4010b() {
        return this.f4368a;
    }

    /* renamed from: c */
    public int m4011c() {
        return this.f4369b;
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.p.b0.l$a */
    public static final class a {

        /* renamed from: i */
        @VisibleForTesting
        static final int f4372i = 2;

        /* renamed from: j */
        static final int f4373j;

        /* renamed from: k */
        static final float f4374k = 0.4f;

        /* renamed from: l */
        static final float f4375l = 0.33f;

        /* renamed from: m */
        static final int f4376m = 4194304;

        /* renamed from: a */
        final Context f4377a;

        /* renamed from: b */
        ActivityManager f4378b;

        /* renamed from: c */
        c f4379c;

        /* renamed from: e */
        float f4381e;

        /* renamed from: d */
        float f4380d = 2.0f;

        /* renamed from: f */
        float f4382f = f4374k;

        /* renamed from: g */
        float f4383g = f4375l;

        /* renamed from: h */
        int f4384h = 4194304;

        static {
            f4373j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f4381e = f4373j;
            this.f4377a = context;
            this.f4378b = (ActivityManager) context.getSystemService("activity");
            this.f4379c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !C1650l.m4008a(this.f4378b)) {
                return;
            }
            this.f4381e = 0.0f;
        }

        /* renamed from: a */
        public a m4012a(float f2) {
            C1876j.m4989a(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f4381e = f2;
            return this;
        }

        /* renamed from: b */
        public a m4017b(float f2) {
            C1876j.m4989a(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f4383g = f2;
            return this;
        }

        /* renamed from: c */
        public a m4018c(float f2) {
            C1876j.m4989a(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f4382f = f2;
            return this;
        }

        /* renamed from: d */
        public a m4019d(float f2) {
            C1876j.m4989a(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f4380d = f2;
            return this;
        }

        /* renamed from: a */
        public a m4013a(int i2) {
            this.f4384h = i2;
            return this;
        }

        @VisibleForTesting
        /* renamed from: a */
        a m4014a(ActivityManager activityManager) {
            this.f4378b = activityManager;
            return this;
        }

        @VisibleForTesting
        /* renamed from: a */
        a m4015a(c cVar) {
            this.f4379c = cVar;
            return this;
        }

        /* renamed from: a */
        public C1650l m4016a() {
            return new C1650l(this);
        }
    }

    /* renamed from: a */
    private static int m4006a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (m4008a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    /* renamed from: a */
    private String m4007a(int i2) {
        return Formatter.formatFileSize(this.f4370c, i2);
    }

    @TargetApi(19)
    /* renamed from: a */
    static boolean m4008a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
