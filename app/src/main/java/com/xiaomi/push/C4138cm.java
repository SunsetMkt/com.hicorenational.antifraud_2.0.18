package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.cm */
/* loaded from: classes2.dex */
public class C4138cm implements InterfaceC4212ff, InterfaceC4217fk {

    /* renamed from: a */
    private Context f14746a;

    public C4138cm(Context context) {
        this.f14746a = context;
    }

    @Override // com.xiaomi.push.InterfaceC4212ff
    /* renamed from: a */
    public void mo14117a(AbstractC4221fo abstractC4221fo) {
        C4145ct.m14184a(this.f14746a);
    }

    @Override // com.xiaomi.push.InterfaceC4217fk
    /* renamed from: a */
    public boolean mo14118a(AbstractC4221fo abstractC4221fo) {
        return true;
    }

    @Override // com.xiaomi.push.InterfaceC4212ff
    /* renamed from: a */
    public void mo14116a(C4197er c4197er) {
        if (c4197er != null && c4197er.m14683a() == 0 && "PING".equals(c4197er.m14685a())) {
            C4145ct.m14191c(this.f14746a);
        } else {
            C4145ct.m14184a(this.f14746a);
        }
    }
}
