package com.lxj.xpopup.p185d;

/* compiled from: ImageType.java */
/* renamed from: com.lxj.xpopup.d.a */
/* loaded from: classes.dex */
public enum EnumC2801a {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    UNKNOWN(false);

    private final boolean hasAlpha;

    EnumC2801a(boolean z) {
        this.hasAlpha = z;
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }
}
