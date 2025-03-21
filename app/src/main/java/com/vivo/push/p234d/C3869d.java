package com.vivo.push.p234d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.p234d.p235a.C3864a;
import com.vivo.push.p234d.p235a.C3865b;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.request.C3966b;
import com.vivo.push.restructure.request.C3968d;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C3996g;
import com.vivo.push.util.C4010u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.d.d */
/* loaded from: classes2.dex */
public final class C3869d implements InterfaceC3863a {
    /* renamed from: a */
    static /* synthetic */ void m12937a(C3869d c3869d, String str, IPushRequestCallback iPushRequestCallback, int i2) {
        if (C3932a.m13069a().m13076g().m12892b() != 0) {
            C4010u.m13304b("core not support sync profileInfo");
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context m13071b = C3932a.m13069a().m13071b();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new C3867b(str));
        }
        C3968d.m13155a().m13159a(new C3966b(new C3864a(new C3865b(m13071b.getPackageName(), arrayList, i2)), new C3875j(c3869d, iPushRequestCallback, i2), (byte) 0));
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public final void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        C3996g.m13250a().execute(new RunnableC3870e(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public final void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        C3996g.m13250a().execute(new RunnableC3872g(this, iPushRequestCallback));
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public final void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        C3996g.m13250a().execute(new RunnableC3871f(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.p234d.InterfaceC3863a
    public final void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        C3996g.m13250a().execute(new RunnableC3873h(this, iPushRequestCallback));
    }
}
