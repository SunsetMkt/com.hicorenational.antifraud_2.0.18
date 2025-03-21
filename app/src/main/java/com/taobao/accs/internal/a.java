package com.taobao.accs.internal;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class a implements l.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f8491a;

    a(ACCSManagerImpl aCCSManagerImpl) {
        this.f8491a = aCCSManagerImpl;
    }

    @Override // com.taobao.accs.utl.l.b
    public void a() {
        String str;
        String str2;
        String str3;
        com.taobao.accs.c cVar;
        try {
            str2 = ACCSManagerImpl.f8480c;
            ALog.e(str2, "onForeState", new Object[0]);
            str3 = this.f8491a.f8482b;
            if (AccsClientConfig.getConfigByTag(str3).isForePingEnable()) {
                ACCSManagerImpl aCCSManagerImpl = this.f8491a;
                cVar = this.f8491a.f8483d;
                aCCSManagerImpl.a(cVar);
            }
        } catch (Exception e2) {
            str = ACCSManagerImpl.f8480c;
            ALog.e(str, "onForeState error, Error:", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.utl.l.b
    public void b() {
        String str;
        str = ACCSManagerImpl.f8480c;
        ALog.e(str, "onBackState", new Object[0]);
    }
}
