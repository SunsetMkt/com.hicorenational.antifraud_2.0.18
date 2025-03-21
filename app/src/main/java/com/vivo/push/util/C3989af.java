package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* compiled from: SystemCache.java */
/* renamed from: com.vivo.push.util.af */
/* loaded from: classes2.dex */
public final class C3989af implements InterfaceC3994e {

    /* renamed from: a */
    private static final HashMap<String, Integer> f14222a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<String, Long> f14223b = new HashMap<>();

    /* renamed from: c */
    private static final HashMap<String, String> f14224c = new HashMap<>();

    /* renamed from: d */
    private static C3989af f14225d;

    /* renamed from: e */
    private Context f14226e;

    /* renamed from: f */
    private InterfaceC3994e f14227f;

    /* renamed from: g */
    private boolean f14228g;

    private C3989af(Context context) {
        this.f14228g = false;
        this.f14226e = context;
        this.f14228g = mo13196a(context);
        C4010u.m13309d("SystemCache", "init status is " + this.f14228g + ";  curCache is " + this.f14227f);
    }

    /* renamed from: b */
    public static synchronized C3989af m13204b(Context context) {
        C3989af c3989af;
        synchronized (C3989af.class) {
            if (f14225d == null) {
                f14225d = new C3989af(context.getApplicationContext());
            }
            c3989af = f14225d;
        }
        return c3989af;
    }

    /* renamed from: a */
    public final void m13205a() {
        C3988ae c3988ae = new C3988ae();
        if (c3988ae.mo13196a(this.f14226e)) {
            c3988ae.m13203a();
            C4010u.m13309d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: b */
    public final void mo13197b(String str, String str2) {
        InterfaceC3994e interfaceC3994e;
        f14224c.put(str, str2);
        if (!this.f14228g || (interfaceC3994e = this.f14227f) == null) {
            return;
        }
        interfaceC3994e.mo13197b(str, str2);
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: a */
    public final boolean mo13196a(Context context) {
        this.f14227f = new C3986ac();
        boolean mo13196a = this.f14227f.mo13196a(context);
        if (!mo13196a) {
            this.f14227f = new C3988ae();
            mo13196a = this.f14227f.mo13196a(context);
        }
        if (!mo13196a) {
            this.f14227f = null;
        }
        return mo13196a;
    }

    @Override // com.vivo.push.util.InterfaceC3994e
    /* renamed from: a */
    public final String mo13195a(String str, String str2) {
        InterfaceC3994e interfaceC3994e;
        String str3 = f14224c.get(str);
        return (str3 != null || (interfaceC3994e = this.f14227f) == null) ? str3 : interfaceC3994e.mo13195a(str, str2);
    }
}
