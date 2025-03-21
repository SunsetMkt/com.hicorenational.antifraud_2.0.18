package com.hihonor.honorid.p165f;

/* compiled from: StringUtil.java */
/* renamed from: com.hihonor.honorid.f.b */
/* loaded from: classes.dex */
public class C2172b {
    /* renamed from: a */
    public static boolean m6329a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str == null || str2 == null) ? str == null ? str2.trim().length() == 0 : str.trim().length() == 0 : str.equals(str2);
    }
}
