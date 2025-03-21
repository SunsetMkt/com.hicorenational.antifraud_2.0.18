package p358k.p359a.p360a.p361a;

import android.text.TextUtils;

/* compiled from: Checker.java */
/* renamed from: k.a.a.a.a */
/* loaded from: classes2.dex */
public final class C5847a {
    /* renamed from: a */
    public static <T> T m24623a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    /* renamed from: a */
    public static String m24624a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(str2));
        }
        return str;
    }
}
