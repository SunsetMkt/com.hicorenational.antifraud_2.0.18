package com.bumptech.glide.load.p125r.p126d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* renamed from: com.bumptech.glide.load.r.d.w */
/* loaded from: classes.dex */
public final class C1748w {

    /* renamed from: f */
    @VisibleForTesting
    static final int f4946f = 128;

    /* renamed from: g */
    private static final int f4947g = 0;

    /* renamed from: h */
    private static final File f4948h = new File("/proc/self/fd");

    /* renamed from: i */
    private static final int f4949i = 50;

    /* renamed from: j */
    private static final int f4950j = 700;

    /* renamed from: k */
    private static final int f4951k = 20000;

    /* renamed from: l */
    private static volatile C1748w f4952l;

    /* renamed from: b */
    private final int f4954b;

    /* renamed from: c */
    private final int f4955c;

    /* renamed from: d */
    @GuardedBy("this")
    private int f4956d;

    /* renamed from: e */
    @GuardedBy("this")
    private boolean f4957e = true;

    /* renamed from: a */
    private final boolean f4953a = m4403c();

    @VisibleForTesting
    C1748w() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4954b = 20000;
            this.f4955c = 0;
        } else {
            this.f4954b = 700;
            this.f4955c = 128;
        }
    }

    /* renamed from: a */
    public static C1748w m4401a() {
        if (f4952l == null) {
            synchronized (C1748w.class) {
                if (f4952l == null) {
                    f4952l = new C1748w();
                }
            }
        }
        return f4952l;
    }

    /* renamed from: b */
    private synchronized boolean m4402b() {
        int i2 = this.f4956d + 1;
        this.f4956d = i2;
        if (i2 >= 50) {
            this.f4956d = 0;
            int length = f4948h.list().length;
            this.f4957e = length < this.f4954b;
            if (!this.f4957e && Log.isLoggable("Downsampler", 5)) {
                String str = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f4954b;
            }
        }
        return this.f4957e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: c */
    private static boolean m4403c() {
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

    /* renamed from: a */
    public boolean m4405a(int i2, int i3, boolean z, boolean z2) {
        int i4;
        return z && this.f4953a && Build.VERSION.SDK_INT >= 26 && !z2 && i2 >= (i4 = this.f4955c) && i3 >= i4 && m4402b();
    }

    @TargetApi(26)
    /* renamed from: a */
    boolean m4404a(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean m4405a = m4405a(i2, i3, z, z2);
        if (m4405a) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return m4405a;
    }
}
