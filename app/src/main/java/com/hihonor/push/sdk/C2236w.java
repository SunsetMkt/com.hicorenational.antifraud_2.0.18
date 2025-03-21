package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.hihonor.push.sdk.w */
/* loaded from: classes.dex */
public class C2236w {

    /* renamed from: a */
    public final String f6845a;

    /* renamed from: b */
    public final int f6846b;

    public C2236w(String str) {
        this.f6845a = str;
        this.f6846b = m6401a(str);
    }

    /* renamed from: a */
    public static C2236w m6402a(String str) {
        return new C2236w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2236w.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f6845a, ((C2236w) obj).f6845a);
    }

    public final int hashCode() {
        return this.f6846b;
    }

    /* renamed from: a */
    public static int m6401a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
