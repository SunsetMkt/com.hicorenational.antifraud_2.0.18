package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* compiled from: SettingsCache.java */
/* renamed from: com.vivo.push.util.ac */
/* loaded from: classes2.dex */
final class C3986ac implements InterfaceC3994e {

    /* renamed from: a */
    private ContentResolver f14217a;

    C3986ac() {
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: a */
    public final boolean mo13196a(Context context) {
        if (!C4003n.m13268b()) {
            return false;
        }
        this.f14217a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: b */
    public final void mo13197b(String str, String str2) {
        try {
            Settings.System.putString(this.f14217a, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13301b("SettingsCache", "putString error by ".concat(String.valueOf(str)));
        }
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: a */
    public final String mo13195a(String str, String str2) {
        try {
            return Settings.System.getString(this.f14217a, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13301b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
