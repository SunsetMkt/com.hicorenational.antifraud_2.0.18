package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: SystemCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class af implements e {
    private static final HashMap<String, Integer> a = new HashMap<>();

    /* JADX INFO: renamed from: b */
    private static final HashMap<String, Long> f8649b = new HashMap<>();

    /* JADX INFO: renamed from: c */
    private static final HashMap<String, String> f8650c = new HashMap<>();

    /* JADX INFO: renamed from: d */
    private static af f8651d;

    /* JADX INFO: renamed from: e */
    private Context f8652e;

    /* JADX INFO: renamed from: f */
    private e f8653f;

    /* JADX INFO: renamed from: g */
    private boolean f8654g;

    private af(Context context) {
        this.f8654g = false;
        this.f8652e = context;
        this.f8654g = a(context);
        u.d("SystemCache", "init status is " + this.f8654g + ";  curCache is " + this.f8653f);
    }

    public static synchronized af b(Context context) {
        if (f8651d == null) {
            f8651d = new af(context.getApplicationContext());
        }
        return f8651d;
    }

    public final void a() {
        ae aeVar = new ae();
        if (aeVar.a(this.f8652e)) {
            aeVar.a();
            u.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        e eVar;
        f8650c.put(str, str2);
        if (!this.f8654g || (eVar = this.f8653f) == null) {
            return;
        }
        eVar.b(str, str2);
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        this.f8653f = new ac();
        boolean zA = this.f8653f.a(context);
        if (!zA) {
            this.f8653f = new ae();
            zA = this.f8653f.a(context);
        }
        if (!zA) {
            this.f8653f = null;
        }
        return zA;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = f8650c.get(str);
        return (str3 != null || (eVar = this.f8653f) == null) ? str3 : eVar.a(str, str2);
    }
}
