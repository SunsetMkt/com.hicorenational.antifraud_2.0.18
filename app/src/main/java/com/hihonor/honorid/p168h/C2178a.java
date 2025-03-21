package com.hihonor.honorid.p168h;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.p165f.C2171a;
import com.hihonor.honorid.p166g.AbstractC2174a;
import java.util.ArrayList;
import java.util.HashMap;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: HnIDMemCache.java */
/* renamed from: com.hihonor.honorid.h.a */
/* loaded from: classes.dex */
public final class C2178a {

    /* renamed from: c */
    private static C2178a f6730c;

    /* renamed from: d */
    private static final Object f6731d = new Object();

    /* renamed from: a */
    private Context f6732a;

    /* renamed from: b */
    private HonorAccount f6733b;

    private C2178a(Context context) {
        new HashMap();
        this.f6732a = context;
    }

    /* renamed from: a */
    public static C2178a m6345a(Context context) {
        C2178a c2178a;
        synchronized (f6731d) {
            if (f6730c == null) {
                f6730c = new C2178a(context.getApplicationContext());
            }
            c2178a = f6730c;
        }
        return c2178a;
    }

    /* renamed from: b */
    public String m6348b() {
        HonorAccount honorAccount = this.f6733b;
        return honorAccount == null ? "" : honorAccount.m6203w();
    }

    /* renamed from: c */
    public void m6349c() {
        C5863e.m24692b("HnIDMemCache", "initHnAccountMemCache", true);
        ArrayList<HonorAccount> mo6332a = AbstractC2174a.m6331a(this.f6732a).mo6332a(this.f6732a);
        if (mo6332a.size() > 0) {
            this.f6733b = mo6332a.get(0);
        } else {
            C5863e.m24692b("HnIDMemCache", "file has no account", true);
        }
    }

    /* renamed from: a */
    public void m6347a(HonorAccount honorAccount) {
        C5863e.m24692b("HnIDMemCache", "saveHnAccountToCache", true);
        if (C2171a.m6321a(honorAccount)) {
            this.f6733b = honorAccount;
        } else {
            C5863e.m24691a("HnIDMemCache", "save honorAccount is null", true);
            this.f6733b = null;
        }
    }

    /* renamed from: a */
    public HonorAccount m6346a() {
        if (this.f6733b == null) {
            m6349c();
        }
        return this.f6733b;
    }
}
