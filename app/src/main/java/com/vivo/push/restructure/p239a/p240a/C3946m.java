package com.vivo.push.restructure.p239a.p240a;

import android.text.TextUtils;
import com.vivo.push.p232b.C3836h;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.util.C4010u;

/* compiled from: NodeReportItem.java */
/* renamed from: com.vivo.push.restructure.a.a.m */
/* loaded from: classes2.dex */
final class C3946m {

    /* renamed from: a */
    private String f14139a;

    /* renamed from: b */
    private String f14140b;

    public C3946m(InterfaceC3933a interfaceC3933a, String str) {
        if (interfaceC3933a != null) {
            this.f14139a = interfaceC3933a.mo13078a();
        }
        this.f14140b = str;
    }

    /* renamed from: a */
    public final C3836h m13106a() {
        if (!TextUtils.isEmpty(this.f14139a) && !TextUtils.isEmpty(this.f14140b)) {
            return new C3836h(this.f14139a, this.f14140b);
        }
        C4010u.m13298a("convertOffLineMsg() error, mMessageID = " + this.f14139a + ", mNodeArrayInfo = " + this.f14140b);
        return null;
    }
}
