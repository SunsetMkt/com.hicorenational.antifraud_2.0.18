package com.heytap.mcssdk.k;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.constant.MessageConstant;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "type";

    public void a(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(com.heytap.mcssdk.a.w().b(context));
            intent.setPackage(com.heytap.mcssdk.a.w().a(context));
            intent.putExtra(com.heytap.mcssdk.constant.b.f3895e, context.getPackageName());
            intent.putExtra(com.heytap.mcssdk.constant.b.f3893c, str);
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (Exception e2) {
            g.e("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
