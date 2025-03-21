package com.vivo.push.restructure.p242c;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.C3924m;
import com.vivo.push.p232b.C3852x;
import com.vivo.push.restructure.p241b.InterfaceC3950a;
import com.vivo.push.util.C4010u;
import java.util.HashMap;

/* compiled from: ReportImpl.java */
/* renamed from: com.vivo.push.restructure.c.b */
/* loaded from: classes2.dex */
public final class C3957b implements InterfaceC3956a {

    /* renamed from: a */
    private InterfaceC3950a f14157a;

    public C3957b(InterfaceC3950a interfaceC3950a) {
        this.f14157a = interfaceC3950a;
    }

    @Override // com.vivo.push.restructure.p242c.InterfaceC3956a
    /* renamed from: a */
    public final void mo13137a(int i2, String str) {
        C4010u.m13309d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i2);
        if (i2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        C3852x c3852x = new C3852x(i2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(C2085b.f6162c, str);
        InterfaceC3950a interfaceC3950a = this.f14157a;
        if (interfaceC3950a != null) {
            String mo13112a = interfaceC3950a.mo13112a();
            if (!TextUtils.isEmpty(mo13112a)) {
                hashMap.put("remoteAppId", mo13112a);
            }
        }
        c3852x.m12886a(hashMap);
        C3924m.m13016a().m13032a(c3852x);
    }
}
