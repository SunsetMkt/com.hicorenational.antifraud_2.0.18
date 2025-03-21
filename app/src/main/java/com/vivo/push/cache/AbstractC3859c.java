package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.C3987ad;
import com.vivo.push.util.C3989af;
import com.vivo.push.util.C4000k;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.ContextDelegate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ICacheSettings.java */
/* renamed from: com.vivo.push.cache.c */
/* loaded from: classes2.dex */
public abstract class AbstractC3859c<T> {

    /* renamed from: a */
    protected static final Object f13967a = new Object();

    /* renamed from: b */
    protected List<T> f13968b = new ArrayList();

    /* renamed from: c */
    protected Context f13969c;

    /* renamed from: d */
    private byte[] f13970d;

    /* renamed from: e */
    private byte[] f13971e;

    protected AbstractC3859c(Context context) {
        this.f13969c = ContextDelegate.getContext(context);
        C3987ad m13198b = C3987ad.m13198b();
        m13198b.m13200a(this.f13969c);
        this.f13970d = m13198b.m13201c();
        this.f13971e = m13198b.m13202d();
        m12906c();
    }

    /* renamed from: b */
    private String m12903b() {
        return C3989af.m13204b(this.f13969c).mo13195a(mo12896a(), null);
    }

    /* renamed from: d */
    private void m12905d(String str) {
        C3989af.m13204b(this.f13969c).mo13197b(mo12896a(), str);
    }

    /* renamed from: a */
    protected abstract String mo12896a();

    /* renamed from: a */
    protected abstract List<T> mo12897a(String str);

    /* renamed from: b */
    abstract String mo12899b(String str) throws Exception;

    /* renamed from: c */
    public final void m12906c() {
        synchronized (f13967a) {
            C4000k.m13261a(mo12896a());
            this.f13968b.clear();
            m12904c(m12903b());
        }
    }

    /* renamed from: e */
    protected final byte[] m12908e() {
        byte[] bArr = this.f13970d;
        return (bArr == null || bArr.length <= 0) ? C3987ad.m13198b().m13201c() : bArr;
    }

    /* renamed from: f */
    protected final byte[] m12909f() {
        byte[] bArr = this.f13971e;
        return (bArr == null || bArr.length <= 0) ? C3987ad.m13198b().m13202d() : bArr;
    }

    /* renamed from: d */
    public final void m12907d() {
        synchronized (f13967a) {
            this.f13968b.clear();
            m12905d("");
            C4010u.m13309d("CacheSettings", "clear " + mo12896a() + " strApps");
        }
    }

    /* renamed from: c */
    private void m12904c(String str) {
        if (TextUtils.isEmpty(str)) {
            C4010u.m13309d("CacheSettings", "ClientManager init " + mo12896a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            C4010u.m13309d("CacheSettings", "sync " + mo12896a() + " strApps lenght too large");
            m12907d();
            return;
        }
        try {
            C4010u.m13309d("CacheSettings", "ClientManager init " + mo12896a() + " strApps : " + str);
            List<T> mo12897a = mo12897a(mo12899b(str));
            if (mo12897a != null) {
                this.f13968b.addAll(mo12897a);
            }
        } catch (Exception e2) {
            m12907d();
            C4010u.m13309d("CacheSettings", C4010u.m13295a(e2));
        }
    }
}
