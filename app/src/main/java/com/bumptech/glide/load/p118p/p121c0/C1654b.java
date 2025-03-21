package com.bumptech.glide.load.p118p.p121c0;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* renamed from: com.bumptech.glide.load.p.c0.b */
/* loaded from: classes.dex */
final class C1654b {

    /* renamed from: a */
    private static final String f4427a = "GlideRuntimeCompat";

    /* renamed from: b */
    private static final String f4428b = "cpu[0-9]+";

    /* renamed from: c */
    private static final String f4429c = "/sys/devices/system/cpu/";

    /* compiled from: RuntimeCompat.java */
    /* renamed from: com.bumptech.glide.load.p.c0.b$a */
    class a implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ Pattern f4430a;

        a(Pattern pattern) {
            this.f4430a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f4430a.matcher(str).matches();
        }
    }

    private C1654b() {
    }

    /* renamed from: a */
    static int m4046a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(m4047b(), availableProcessors) : availableProcessors;
    }

    /* renamed from: b */
    private static int m4047b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArr = new File(f4429c).listFiles(new a(Pattern.compile(f4428b)));
            } catch (Throwable unused) {
                Log.isLoggable(f4427a, 6);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            }
            return Math.max(1, fileArr != null ? fileArr.length : 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
