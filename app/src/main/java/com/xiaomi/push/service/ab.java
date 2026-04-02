package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.dv;
import com.xiaomi.push.hb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ab {
    abstract dv a(Context context, int i2, String str, Map<String, String> map);

    abstract void a(hb hbVar, Map<String, String> map, int i2, Notification notification);

    abstract void a(String str);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    abstract boolean m668a(Context context, int i2, String str, Map<String, String> map);

    abstract boolean a(Map<String, String> map, int i2, Notification notification);
}
