package com.umeng.p221ut.p222a.p224b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.p221ut.p222a.p223a.C3797a;
import com.umeng.p221ut.p222a.p223a.C3798b;
import com.umeng.p221ut.p222a.p225c.C3808c;
import com.umeng.p221ut.p222a.p225c.C3810e;
import com.umeng.p221ut.p226b.p229b.C3816a;
import com.umeng.p221ut.p226b.p229b.C3819d;
import com.umeng.p221ut.p226b.p229b.C3820e;

/* renamed from: com.umeng.ut.a.b.g */
/* loaded from: classes2.dex */
public class RunnableC3805g implements Runnable {

    /* renamed from: a */
    private static volatile boolean f13867a = false;

    /* renamed from: a */
    private Context f13868a;

    public RunnableC3805g(Context context) {
        this.f13868a = context;
    }

    /* renamed from: a */
    private void m12766a() {
        C3810e.m12788c();
        if (C3808c.m12776b(this.f13868a) && !f13867a) {
            f13867a = true;
            if (C3819d.m12808a(this.f13868a).m12821b()) {
                try {
                    m12769b();
                } catch (Throwable unused) {
                }
                f13867a = false;
            }
        }
    }

    /* renamed from: b */
    private void m12769b() {
        C3810e.m12788c();
        String m12768b = m12768b();
        if (TextUtils.isEmpty(m12768b)) {
            C3810e.m12784a("postData is empty", new Object[0]);
        } else if (m12767a(m12768b)) {
            C3810e.m12784a("", "upload success");
        } else {
            C3810e.m12784a("", "upload fail");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                Thread.sleep(C3816a.m12802b());
            } catch (Throwable th) {
                C3810e.m12783a("", th, new Object[0]);
                return;
            }
        } catch (Exception unused) {
        }
        m12766a();
    }

    /* renamed from: a */
    private boolean m12767a(String str) {
        C3799a m12765a = C3800b.m12765a("https://audid.umeng.com/v3/a/audid/req", str, true);
        if (m12765a == null) {
            return false;
        }
        return C3820e.m12825a(m12765a);
    }

    /* renamed from: b */
    private String m12768b() {
        String m12804i = C3816a.m12801a().m12804i();
        if (TextUtils.isEmpty(m12804i)) {
            return null;
        }
        String m12761a = C3797a.m12761a(m12804i);
        if (C3810e.m12785a()) {
            C3810e.m12787b("", m12761a);
        }
        return C3798b.m12763b(m12761a);
    }
}
