package com.bumptech.glide.load.r.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

/* JADX INFO: compiled from: HardwareConfigState.java */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f3232f = 128;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f3233g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final File f3234h = new File("/proc/self/fd");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f3235i = 50;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f3236j = 700;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f3237k = 20000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile w f3238l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f3241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f3242e = true;
    private final boolean a = c();

    @VisibleForTesting
    w() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3239b = 20000;
            this.f3240c = 0;
        } else {
            this.f3239b = 700;
            this.f3240c = 128;
        }
    }

    public static w a() {
        if (f3238l == null) {
            synchronized (w.class) {
                if (f3238l == null) {
                    f3238l = new w();
                }
            }
        }
        return f3238l;
    }

    private synchronized boolean b() {
        int i2 = this.f3241d + 1;
        this.f3241d = i2;
        if (i2 >= 50) {
            this.f3241d = 0;
            int length = f3234h.list().length;
            this.f3242e = length < this.f3239b;
            if (!this.f3242e && Log.isLoggable("Downsampler", 5)) {
                String str = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f3239b;
            }
        }
        return this.f3242e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        switch (Build.MODEL.substring(0, 7)) {
            case "SM-N935":
            case "SM-J720":
            case "SM-G960":
            case "SM-G965":
            case "SM-G935":
            case "SM-G930":
            case "SM-A520":
                if (Build.VERSION.SDK_INT != 26) {
                }
                break;
        }
        return true;
    }

    public boolean a(int i2, int i3, boolean z, boolean z2) {
        int i4;
        return z && this.a && Build.VERSION.SDK_INT >= 26 && !z2 && i2 >= (i4 = this.f3240c) && i3 >= i4 && b();
    }

    @TargetApi(26)
    boolean a(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zA = a(i2, i3, z, z2);
        if (zA) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zA;
    }
}
