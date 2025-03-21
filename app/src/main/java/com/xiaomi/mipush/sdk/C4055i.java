package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.InterfaceC4158df;

/* renamed from: com.xiaomi.mipush.sdk.i */
/* loaded from: classes2.dex */
public class C4055i implements InterfaceC4158df {

    /* renamed from: a */
    private Context f14414a;

    public C4055i(Context context) {
        this.f14414a = context;
    }

    @Override // com.xiaomi.push.InterfaceC4158df
    /* renamed from: a */
    public String mo13564a() {
        return C4048b.m13476a(this.f14414a).m13497d();
    }

    @Override // com.xiaomi.push.InterfaceC4158df
    /* renamed from: a */
    public void mo13565a(C4265he c4265he, EnumC4239gf enumC4239gf, C4252gs c4252gs) {
        C4067u.m13627a(this.f14414a).m13659a((C4067u) c4265he, enumC4239gf, c4252gs);
    }
}
