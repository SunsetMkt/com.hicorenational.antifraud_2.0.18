package com.bumptech.glide.load.p116o.p117p;

import android.net.Uri;
import com.umeng.socialize.common.SocializeConstants;

/* compiled from: MediaStoreUtil.java */
/* renamed from: com.bumptech.glide.load.o.p.b */
/* loaded from: classes.dex */
public final class C1617b {

    /* renamed from: a */
    private static final int f4242a = 512;

    /* renamed from: b */
    private static final int f4243b = 384;

    private C1617b() {
    }

    /* renamed from: a */
    public static boolean m3877a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= f4243b;
    }

    /* renamed from: a */
    public static boolean m3878a(Uri uri) {
        return m3879b(uri) && !m3881d(uri);
    }

    /* renamed from: b */
    public static boolean m3879b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority());
    }

    /* renamed from: c */
    public static boolean m3880c(Uri uri) {
        return m3879b(uri) && m3881d(uri);
    }

    /* renamed from: d */
    private static boolean m3881d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
