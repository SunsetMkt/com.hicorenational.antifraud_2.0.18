package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* loaded from: classes2.dex */
public final class ce {

    /* renamed from: a, reason: collision with root package name */
    private int f12550a;

    /* renamed from: a, reason: collision with other field name */
    private String f253a;

    public ce(String str, int i2) {
        this.f253a = str;
        this.f12550a = i2;
    }

    public int a() {
        return this.f12550a;
    }

    public String toString() {
        if (this.f12550a <= 0) {
            return this.f253a;
        }
        return this.f253a + Constants.COLON_SEPARATOR + this.f12550a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m226a() {
        return this.f253a;
    }

    public static ce a(String str, int i2) {
        String str2;
        int lastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i2 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
        } else {
            str2 = str;
        }
        return new ce(str2, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m225a(String str, int i2) {
        ce a2 = a(str, i2);
        return new InetSocketAddress(a2.m226a(), a2.a());
    }
}
