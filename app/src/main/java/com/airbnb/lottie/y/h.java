package com.airbnb.lottie.y;

/* JADX INFO: compiled from: Marker.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f2423d = "\r";
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2425c;

    public h(String str, float f2, float f3) {
        this.a = str;
        this.f2425c = f3;
        this.f2424b = f2;
    }

    public boolean a(String str) {
        if (this.a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.a.endsWith(f2423d)) {
            String str2 = this.a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
