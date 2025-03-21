package com.bumptech.glide.load.r.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f4952f = 128;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4953g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static final File f4954h = new File("/proc/self/fd");

    /* renamed from: i, reason: collision with root package name */
    private static final int f4955i = 50;

    /* renamed from: j, reason: collision with root package name */
    private static final int f4956j = 700;

    /* renamed from: k, reason: collision with root package name */
    private static final int f4957k = 20000;

    /* renamed from: l, reason: collision with root package name */
    private static volatile w f4958l;

    /* renamed from: b, reason: collision with root package name */
    private final int f4960b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4961c;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f4962d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f4963e = true;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4959a = c();

    @VisibleForTesting
    w() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4960b = 20000;
            this.f4961c = 0;
        } else {
            this.f4960b = 700;
            this.f4961c = 128;
        }
    }

    public static w a() {
        if (f4958l == null) {
            synchronized (w.class) {
                if (f4958l == null) {
                    f4958l = new w();
                }
            }
        }
        return f4958l;
    }

    private synchronized boolean b() {
        int i2 = this.f4962d + 1;
        this.f4962d = i2;
        if (i2 >= 50) {
            this.f4962d = 0;
            int length = f4954h.list().length;
            this.f4963e = length < this.f4960b;
            if (!this.f4963e && Log.isLoggable("Downsampler", 5)) {
                String str = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f4960b;
            }
        }
        return this.f4963e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean c() {
        char c2;
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = Build.MODEL.substring(0, 7);
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (Build.VERSION.SDK_INT != 26) {
                }
                break;
        }
        return true;
    }

    public boolean a(int i2, int i3, boolean z, boolean z2) {
        int i4;
        return z && this.f4959a && Build.VERSION.SDK_INT >= 26 && !z2 && i2 >= (i4 = this.f4961c) && i3 >= i4 && b();
    }

    @TargetApi(26)
    boolean a(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean a2 = a(i2, i3, z, z2);
        if (a2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return a2;
    }
}
