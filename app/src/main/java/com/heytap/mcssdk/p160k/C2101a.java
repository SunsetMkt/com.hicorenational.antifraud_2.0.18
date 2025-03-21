package com.heytap.mcssdk.p160k;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.constant.C2085b;
import com.heytap.mcssdk.constant.MessageConstant;

/* renamed from: com.heytap.mcssdk.k.a */
/* loaded from: classes.dex */
public class C2101a {

    /* renamed from: a */
    private static final String f6239a = "type";

    /* renamed from: a */
    public void m5854a(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(C2080a.m5698w().m5716b(context));
            intent.setPackage(C2080a.m5698w().m5702a(context));
            intent.putExtra(C2085b.f6164e, context.getPackageName());
            intent.putExtra(C2085b.f6162c, str);
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (Exception e2) {
            C2107g.m5896e("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
