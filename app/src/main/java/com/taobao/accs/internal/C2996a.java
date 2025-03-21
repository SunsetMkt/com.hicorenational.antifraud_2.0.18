package com.taobao.accs.internal;

import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.InterfaceC2977c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3044l;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.internal.a */
/* loaded from: classes2.dex */
class C2996a implements C3044l.b {

    /* renamed from: a */
    final /* synthetic */ ACCSManagerImpl f9511a;

    C2996a(ACCSManagerImpl aCCSManagerImpl) {
        this.f9511a = aCCSManagerImpl;
    }

    @Override // com.taobao.accs.utl.C3044l.b
    /* renamed from: a */
    public void mo9076a() {
        String str;
        String str2;
        String str3;
        InterfaceC2977c interfaceC2977c;
        try {
            str2 = ACCSManagerImpl.f9500c;
            ALog.m9182e(str2, "onForeState", new Object[0]);
            str3 = this.f9511a.f9502b;
            if (AccsClientConfig.getConfigByTag(str3).isForePingEnable()) {
                ACCSManagerImpl aCCSManagerImpl = this.f9511a;
                interfaceC2977c = this.f9511a.f9503d;
                aCCSManagerImpl.m9060a(interfaceC2977c);
            }
        } catch (Exception e2) {
            str = ACCSManagerImpl.f9500c;
            ALog.m9181e(str, "onForeState error, Error:", e2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.utl.C3044l.b
    /* renamed from: b */
    public void mo9077b() {
        String str;
        str = ACCSManagerImpl.f9500c;
        ALog.m9182e(str, "onBackState", new Object[0]);
    }
}
