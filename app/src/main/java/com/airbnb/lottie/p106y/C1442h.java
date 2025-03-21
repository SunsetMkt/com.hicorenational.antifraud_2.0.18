package com.airbnb.lottie.p106y;

/* compiled from: Marker.java */
/* renamed from: com.airbnb.lottie.y.h */
/* loaded from: classes.dex */
public class C1442h {

    /* renamed from: d */
    private static String f3608d = "\r";

    /* renamed from: a */
    private final String f3609a;

    /* renamed from: b */
    public final float f3610b;

    /* renamed from: c */
    public final float f3611c;

    public C1442h(String str, float f2, float f3) {
        this.f3609a = str;
        this.f3611c = f3;
        this.f3610b = f2;
    }

    /* renamed from: a */
    public boolean m3217a(String str) {
        if (this.f3609a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f3609a.endsWith(f3608d)) {
            String str2 = this.f3609a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
