package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.ad;
import com.vivo.push.util.af;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ICacheSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> {
    protected static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<T> f8477b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f8478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f8479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f8480e;

    protected c(Context context) {
        this.f8478c = ContextDelegate.getContext(context);
        ad adVarB = ad.b();
        adVarB.a(this.f8478c);
        this.f8479d = adVarB.c();
        this.f8480e = adVarB.d();
        c();
    }

    private String b() {
        return af.b(this.f8478c).a(a(), null);
    }

    private void d(String str) {
        af.b(this.f8478c).b(a(), str);
    }

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (a) {
            k.a(a());
            this.f8477b.clear();
            c(b());
        }
    }

    protected final byte[] e() {
        byte[] bArr = this.f8479d;
        return (bArr == null || bArr.length <= 0) ? ad.b().c() : bArr;
    }

    protected final byte[] f() {
        byte[] bArr = this.f8480e;
        return (bArr == null || bArr.length <= 0) ? ad.b().d() : bArr;
    }

    public final void d() {
        synchronized (a) {
            this.f8477b.clear();
            d("");
            u.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            u.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            List<T> listA = a(b(str));
            if (listA != null) {
                this.f8477b.addAll(listA);
            }
        } catch (Exception e2) {
            d();
            u.d("CacheSettings", u.a(e2));
        }
    }
}
