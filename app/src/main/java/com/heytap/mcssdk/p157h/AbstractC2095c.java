package com.heytap.mcssdk.p157h;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.p160k.C2105e;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.heytap.mcssdk.h.c */
/* loaded from: classes.dex */
public abstract class AbstractC2095c implements InterfaceC2096d {
    /* renamed from: a */
    public static List<BaseMode> m5844a(Context context, Intent intent) {
        BaseMode mo5841a;
        if (intent == null) {
            return null;
        }
        int i2 = 4096;
        try {
            i2 = Integer.parseInt(C2105e.m5875d(intent.getStringExtra("type")));
        } catch (Exception e2) {
            C2107g.m5896e("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
        }
        C2107g.m5884b("MessageParser--getMessageByIntent--type:" + i2);
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2096d interfaceC2096d : C2080a.m5698w().m5743l()) {
            if (interfaceC2096d != null && (mo5841a = interfaceC2096d.mo5841a(context, i2, intent)) != null) {
                arrayList.add(mo5841a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected abstract BaseMode mo5842a(Intent intent, int i2);
}
