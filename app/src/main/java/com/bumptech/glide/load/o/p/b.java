package com.bumptech.glide.load.o.p;

import android.net.Uri;
import com.umeng.socialize.common.SocializeConstants;

/* JADX INFO: compiled from: MediaStoreUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final int a = 512;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f2753b = 384;

    private b() {
    }

    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= f2753b;
    }

    public static boolean a(Uri uri) {
        return b(uri) && !d(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && d(uri);
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
