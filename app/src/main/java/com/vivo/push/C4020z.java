package com.vivo.push;

import android.text.TextUtils;
import com.vivo.push.p233c.C3856a;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.p241b.InterfaceC3950a;
import com.vivo.push.util.C4010u;

/* compiled from: SubscribeImpl.java */
/* renamed from: com.vivo.push.z */
/* loaded from: classes2.dex */
public final class C4020z implements InterfaceC3922k {

    /* renamed from: a */
    private C4019y f14292a = new C4019y();

    /* renamed from: b */
    private C4019y f14293b = new C4019y();

    /* renamed from: c */
    private C3856a f14294c;

    /* renamed from: d */
    private volatile String f14295d;

    /* renamed from: e */
    private InterfaceC3950a f14296e;

    public C4020z(C3856a c3856a, InterfaceC3950a interfaceC3950a) {
        this.f14294c = c3856a;
        this.f14296e = interfaceC3950a;
    }

    /* renamed from: d */
    private void m13333d(String str) {
        this.f14295d = str;
        this.f14296e.mo13119c(this.f14295d);
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: b */
    public final String mo13011b() {
        if (!TextUtils.isEmpty(this.f14295d)) {
            return this.f14295d;
        }
        String m13332d = m13332d();
        if (TextUtils.isEmpty(m13332d)) {
            m13332d = this.f14296e.mo13124f();
            C3975t.m13171c(new RunnableC3826aa(this, m13332d));
        }
        this.f14295d = m13332d;
        C4010u.m13309d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(m13332d)));
        return m13332d;
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: c */
    public final void mo13013c(String str) {
        m13333d(str);
    }

    /* renamed from: c */
    private int m13331c() {
        if (!this.f14294c.m12894d()) {
            return 8013;
        }
        if (this.f14293b.m13329a()) {
            C4010u.m13309d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
            return 1002;
        }
        int i2 = 1;
        try {
            String mo12933a = new C3876e(1, C3932a.m13069a().m13071b().getPackageName(), "", "", C3932a.m13069a().m13074e().mo13124f()).mo12933a();
            C4010u.m13309d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(mo12933a)));
            String m12889a = C3856a.m12889a(C3932a.m13069a().m13071b(), mo12933a);
            C4010u.m13309d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(m12889a)));
            if (!TextUtils.isEmpty(m12889a)) {
                i2 = 1 ^ (Boolean.parseBoolean(C3917g.f14051a.mo12936a(m12889a).m12990b()) ? 1 : 0);
            }
        } catch (Exception e2) {
            C4010u.m13293a("SubscribeImpl", "isAppSubscribe", e2);
        }
        C4010u.m13309d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i2)));
        return i2;
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: a */
    public final void mo13008a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f14294c.m12893c() || iPushActionListener == null) {
            C3924m.m13016a().m13040b(iPushActionListener, str, str2);
        } else {
            iPushActionListener.onStateChanged(8012);
        }
    }

    /* renamed from: d */
    private String m13332d() {
        String str = "";
        if (!this.f14294c.m12894d()) {
            C4010u.m13309d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
            return "";
        }
        if (this.f14292a.m13329a()) {
            C4010u.m13309d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
            return "";
        }
        try {
            String mo12933a = new C3876e(2, C3932a.m13069a().m13071b().getPackageName(), "", "", C3932a.m13069a().m13074e().mo13124f()).mo12933a();
            C4010u.m13309d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(mo12933a)));
            String m12889a = C3856a.m12889a(C3932a.m13069a().m13071b(), mo12933a);
            C4010u.m13309d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(m12889a)));
            if (!TextUtils.isEmpty(m12889a)) {
                str = C3917g.f14051a.mo12936a(m12889a).m12990b();
            }
        } catch (Exception e2) {
            C4010u.m13293a("SubscribeImpl", "getRegidByCoreSdk", e2);
        }
        C4010u.m13309d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(str)));
        return str;
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: a */
    public final int mo13007a() {
        return m13331c();
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: a */
    public final void mo13010a(String str, String str2, String str3) {
        m13333d(str);
        this.f14296e.mo13115a(str2);
        this.f14296e.mo13117b(str3);
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: a */
    public final void mo13009a(String str) {
        m13333d(str);
        this.f14296e.mo13120d();
        this.f14296e.mo13116b();
    }

    @Override // com.vivo.push.InterfaceC3922k
    /* renamed from: b */
    public final void mo13012b(String str) {
        m13333d(str);
        C3924m.m13016a().m13046e();
        this.f14296e.mo13126h();
        this.f14296e.mo13120d();
        this.f14296e.mo13116b();
    }
}
