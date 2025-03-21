package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3996g;

/* compiled from: BasePushClient.java */
/* renamed from: com.vivo.push.a */
/* loaded from: classes2.dex */
public class C3824a {
    public void deleteRegid(IPushActionListener iPushActionListener, String str, String str2) {
        C3932a.m13069a().m13077h().mo13008a(iPushActionListener, str, str2);
    }

    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        C3996g.m13250a().execute(new RunnableC3828b(this, iPushQueryActionListener));
    }

    public void querySubscribeState(IPushActionListener iPushActionListener) {
        C3996g.m13250a().execute(new RunnableC3855c(this, iPushActionListener));
    }
}
