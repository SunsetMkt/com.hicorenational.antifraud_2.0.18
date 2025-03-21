package com.vivo.push.restructure.p241b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C4000k;
import com.vivo.push.util.C4010u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PushSystemRelyImpl.java */
/* renamed from: com.vivo.push.restructure.b.f */
/* loaded from: classes2.dex */
public final class C3955f implements InterfaceC3951b {
    @Override // com.vivo.push.util.InterfaceC4004o
    /* renamed from: a */
    public final List<String> mo13136a(Context context) {
        C4000k.m13261a("findAllCoreClientPush");
        List<ResolveInfo> list = null;
        if (!C3932a.m13069a().m13074e().mo13130l().isAgreePrivacyStatement()) {
            C4010u.m13309d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (Exception unused) {
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ResolveInfo resolveInfo = list.get(i2);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            C4010u.m13309d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }
}
