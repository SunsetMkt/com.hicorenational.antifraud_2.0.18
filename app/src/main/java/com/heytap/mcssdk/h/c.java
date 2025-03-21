package com.heytap.mcssdk.h;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.k.e;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements d {
    public static List<BaseMode> a(Context context, Intent intent) {
        BaseMode a2;
        if (intent == null) {
            return null;
        }
        int i2 = 4096;
        try {
            i2 = Integer.parseInt(e.d(intent.getStringExtra("type")));
        } catch (Exception e2) {
            g.e("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
        }
        g.b("MessageParser--getMessageByIntent--type:" + i2);
        ArrayList arrayList = new ArrayList();
        for (d dVar : com.heytap.mcssdk.a.w().l()) {
            if (dVar != null && (a2 = dVar.a(context, i2, intent)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    protected abstract BaseMode a(Intent intent, int i2);
}
