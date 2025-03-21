package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.NotificationBuilderC4174dv;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ab */
/* loaded from: classes2.dex */
public abstract class AbstractC4350ab {
    /* renamed from: a */
    abstract NotificationBuilderC4174dv m15823a(Context context, int i2, String str, Map<String, String> map);

    /* renamed from: a */
    abstract void m15824a(C4262hb c4262hb, Map<String, String> map, int i2, Notification notification);

    /* renamed from: a */
    abstract void m15825a(String str);

    /* renamed from: a */
    abstract boolean m15826a(Context context, int i2, String str, Map<String, String> map);

    /* renamed from: a */
    abstract boolean m15827a(Map<String, String> map, int i2, Notification notification);
}
