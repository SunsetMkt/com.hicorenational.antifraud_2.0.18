package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.mipush.sdk.p */
/* loaded from: classes2.dex */
public class C4062p {

    /* renamed from: a */
    private static volatile C4062p f14426a;

    /* renamed from: a */
    private Context f14427a;

    /* renamed from: a */
    private List<C4060n> f14428a = new ArrayList();

    private C4062p(Context context) {
        this.f14427a = context.getApplicationContext();
        if (this.f14427a == null) {
            this.f14427a = context;
        }
    }

    /* renamed from: a */
    public static C4062p m13587a(Context context) {
        if (f14426a == null) {
            synchronized (C4062p.class) {
                if (f14426a == null) {
                    f14426a = new C4062p(context);
                }
            }
        }
        return f14426a;
    }

    /* renamed from: b */
    public void m13593b(String str) {
        synchronized (this.f14428a) {
            C4060n c4060n = new C4060n();
            c4060n.f14423a = str;
            if (this.f14428a.contains(c4060n)) {
                Iterator<C4060n> it = this.f14428a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C4060n next = it.next();
                    if (c4060n.equals(next)) {
                        c4060n = next;
                        break;
                    }
                }
            }
            c4060n.f14422a++;
            this.f14428a.remove(c4060n);
            this.f14428a.add(c4060n);
        }
    }

    /* renamed from: c */
    public void m13594c(String str) {
        synchronized (this.f14428a) {
            C4060n c4060n = new C4060n();
            c4060n.f14423a = str;
            if (this.f14428a.contains(c4060n)) {
                this.f14428a.remove(c4060n);
            }
        }
    }

    /* renamed from: a */
    public void m13591a(String str) {
        synchronized (this.f14428a) {
            C4060n c4060n = new C4060n();
            c4060n.f14422a = 0;
            c4060n.f14423a = str;
            if (this.f14428a.contains(c4060n)) {
                this.f14428a.remove(c4060n);
            }
            this.f14428a.add(c4060n);
        }
    }

    /* renamed from: a */
    public int m13588a(String str) {
        synchronized (this.f14428a) {
            C4060n c4060n = new C4060n();
            c4060n.f14423a = str;
            if (this.f14428a.contains(c4060n)) {
                for (C4060n c4060n2 : this.f14428a) {
                    if (c4060n2.equals(c4060n)) {
                        return c4060n2.f14422a;
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: a */
    public boolean m13592a(String str) {
        synchronized (this.f14428a) {
            C4060n c4060n = new C4060n();
            c4060n.f14423a = str;
            return this.f14428a.contains(c4060n);
        }
    }

    /* renamed from: a */
    public synchronized String m13589a(EnumC4068v enumC4068v) {
        return this.f14427a.getSharedPreferences("mipush_extra", 0).getString(enumC4068v.name(), "");
    }

    /* renamed from: a */
    public synchronized void m13590a(EnumC4068v enumC4068v, String str) {
        SharedPreferences sharedPreferences = this.f14427a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(enumC4068v.name(), str).apply();
    }
}
