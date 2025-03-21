package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.InterfaceC4277hq;

/* renamed from: com.xiaomi.mipush.sdk.k */
/* loaded from: classes2.dex */
public class C4057k {
    /* renamed from: a */
    public static <T extends InterfaceC4277hq<T, ?>> void m13574a(Context context, Config config) {
        if (config == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", config.isEventUploadSwitchOpen());
        intent.putExtra("action_cr_event_frequency", config.getEventUploadFrequency());
        intent.putExtra("action_cr_perf_switch", config.isPerfUploadSwitchOpen());
        intent.putExtra("action_cr_perf_frequency", config.getPerfUploadFrequency());
        intent.putExtra("action_cr_event_en", config.isEventEncrypted());
        intent.putExtra("action_cr_max_file_size", config.getMaxFileLength());
        C4067u.m13627a(context).m13655a(intent);
    }
}
