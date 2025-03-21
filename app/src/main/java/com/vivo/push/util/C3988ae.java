package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpCache.java */
/* renamed from: com.vivo.push.util.ae */
/* loaded from: classes2.dex */
public final class C3988ae implements InterfaceC3994e {

    /* renamed from: a */
    private static String f14219a = "SpCache";

    /* renamed from: b */
    private static String f14220b = "com.vivo.push.cache";

    /* renamed from: c */
    private SharedPreferences f14221c;

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: a */
    public final boolean mo13196a(Context context) {
        if (this.f14221c != null) {
            return true;
        }
        this.f14221c = context.getSharedPreferences(f14220b, 0);
        return true;
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: b */
    public final void mo13197b(String str, String str2) {
        SharedPreferences.Editor edit = this.f14221c.edit();
        if (edit == null) {
            C4010u.m13301b(f14219a, "putString error by ".concat(String.valueOf(str)));
            return;
        }
        edit.putString(str, str2);
        C3992c.m13234a(edit);
        C4010u.m13309d(f14219a, "putString by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: a */
    public final String mo13195a(String str, String str2) {
        String string = this.f14221c.getString(str, str2);
        C4010u.m13309d(f14219a, "getString " + str + " is " + string);
        return string;
    }

    /* renamed from: a */
    public final void m13203a() {
        SharedPreferences.Editor edit = this.f14221c.edit();
        if (edit != null) {
            edit.clear();
            C3992c.m13234a(edit);
        }
        C4010u.m13309d(f14219a, "system cache is cleared");
    }
}
