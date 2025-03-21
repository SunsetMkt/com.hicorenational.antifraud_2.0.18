package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.request.p243a.C3964c;
import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b;

/* compiled from: BaseCommand.java */
/* renamed from: com.vivo.push.restructure.request.a */
/* loaded from: classes2.dex */
public abstract class AbstractC3958a<I extends InterfaceC3961b, O extends InterfaceC3961b> {

    /* renamed from: a */
    private int f14158a = 2020;

    /* renamed from: b */
    private I f14159b;

    protected AbstractC3958a(I i2) {
        this.f14159b = i2;
    }

    /* renamed from: a */
    public final Intent m13138a(int i2) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("client_pkgname", C3932a.m13069a().m13071b().getPackageName());
        bundle.putBoolean("support_rf", true);
        C3964c c3964c = new C3964c(this.f14158a, i2);
        C3960a c3960a = new C3960a();
        c3964c.mo12930a(c3960a);
        bundle.putString("cf_content", c3960a.m13150d());
        C3960a c3960a2 = new C3960a();
        this.f14159b.mo12930a(c3960a2);
        bundle.putString("content", c3960a2.m13150d());
        intent.putExtras(bundle);
        return intent;
    }

    /* renamed from: a */
    public abstract O mo12928a(C3960a c3960a);
}
