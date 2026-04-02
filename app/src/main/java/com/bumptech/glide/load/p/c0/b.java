package com.bumptech.glide.load.p.c0;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RuntimeCompat.java */
/* JADX INFO: loaded from: classes.dex */
final class b {
    private static final String a = "GlideRuntimeCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2890b = "cpu[0-9]+";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2891c = "/sys/devices/system/cpu/";

    /* JADX INFO: compiled from: RuntimeCompat.java */
    class a implements FilenameFilter {
        final /* synthetic */ Pattern a;

        a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.a.matcher(str).matches();
        }
    }

    private b() {
    }

    static int a() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), iAvailableProcessors) : iAvailableProcessors;
    }

    private static int b() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArrListFiles = new File(f2891c).listFiles(new a(Pattern.compile(f2890b)));
            } catch (Throwable unused) {
                Log.isLoggable(a, 6);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            }
            return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
