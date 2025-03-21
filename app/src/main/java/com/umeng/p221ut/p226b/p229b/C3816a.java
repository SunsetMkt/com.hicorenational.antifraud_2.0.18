package com.umeng.p221ut.p226b.p229b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.p221ut.p222a.C3796a;
import com.umeng.p221ut.p222a.p224b.RunnableC3805g;
import com.umeng.p221ut.p222a.p225c.C3806a;
import com.umeng.p221ut.p222a.p225c.C3810e;

/* renamed from: com.umeng.ut.b.b.a */
/* loaded from: classes2.dex */
public class C3816a {

    /* renamed from: a */
    private static final C3816a f13888a = new C3816a();

    /* renamed from: c */
    private static long f13889c = 3000;

    /* renamed from: c */
    private String f13890c = "";

    private C3816a() {
    }

    /* renamed from: a */
    public static C3816a m12801a() {
        return f13888a;
    }

    /* renamed from: b */
    public static long m12802b() {
        return f13889c;
    }

    /* renamed from: d */
    private void m12803d() {
        C3810e.m12788c();
        if (TextUtils.isEmpty(this.f13890c)) {
            return;
        }
        try {
            Context m12757a = C3796a.m12755a().m12757a();
            if (C3806a.m12770a(m12757a)) {
                new Thread(new RunnableC3805g(m12757a)).start();
            }
        } catch (Throwable th) {
            C3810e.m12784a("", th);
        }
    }

    synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f13890c)) {
            return this.f13890c;
        }
        try {
            String value = C3819d.m12808a(context).getValue();
            if (TextUtils.isEmpty(value)) {
                return "ffffffffffffffffffffffff";
            }
            this.f13890c = value;
            m12803d();
            return this.f13890c;
        } catch (Throwable th) {
            C3810e.m12783a("AppUtdid", th, new Object[0]);
            return "ffffffffffffffffffffffff";
        }
    }

    /* renamed from: i */
    public synchronized String m12804i() {
        return this.f13890c;
    }
}
