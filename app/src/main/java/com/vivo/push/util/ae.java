package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SpCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ae implements e {
    private static String a = "SpCache";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8647b = "com.vivo.push.cache";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f8648c;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (this.f8648c != null) {
            return true;
        }
        this.f8648c = context.getSharedPreferences(f8647b, 0);
        return true;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f8648c.edit();
        if (editorEdit == null) {
            u.b(a, "putString error by ".concat(String.valueOf(str)));
            return;
        }
        editorEdit.putString(str, str2);
        c.a(editorEdit);
        u.d(a, "putString by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        String string = this.f8648c.getString(str, str2);
        u.d(a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor editorEdit = this.f8648c.edit();
        if (editorEdit != null) {
            editorEdit.clear();
            c.a(editorEdit);
        }
        u.d(a, "system cache is cleared");
    }
}
