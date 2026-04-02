package com.hihonor.honorid.h;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import java.util.ArrayList;
import java.util.HashMap;
import l.a.a.a.j.e;

/* JADX INFO: compiled from: HnIDMemCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c */
    private static a f4222c;

    /* JADX INFO: renamed from: d */
    private static final Object f4223d = new Object();
    private Context a;

    /* JADX INFO: renamed from: b */
    private HonorAccount f4224b;

    private a(Context context) {
        new HashMap();
        this.a = context;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f4223d) {
            if (f4222c == null) {
                f4222c = new a(context.getApplicationContext());
            }
            aVar = f4222c;
        }
        return aVar;
    }

    public String b() {
        HonorAccount honorAccount = this.f4224b;
        return honorAccount == null ? "" : honorAccount.w();
    }

    public void c() {
        e.b("HnIDMemCache", "initHnAccountMemCache", true);
        ArrayList<HonorAccount> arrayListA = com.hihonor.honorid.g.a.a(this.a).a(this.a);
        if (arrayListA.size() > 0) {
            this.f4224b = arrayListA.get(0);
        } else {
            e.b("HnIDMemCache", "file has no account", true);
        }
    }

    public void a(HonorAccount honorAccount) {
        e.b("HnIDMemCache", "saveHnAccountToCache", true);
        if (com.hihonor.honorid.f.a.a(honorAccount)) {
            this.f4224b = honorAccount;
        } else {
            e.a("HnIDMemCache", "save honorAccount is null", true);
            this.f4224b = null;
        }
    }

    public HonorAccount a() {
        if (this.f4224b == null) {
            c();
        }
        return this.f4224b;
    }
}
