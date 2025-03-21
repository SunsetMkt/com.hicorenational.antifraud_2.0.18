package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* compiled from: NotificationUtils.java */
/* renamed from: com.huawei.hms.push.j */
/* loaded from: classes.dex */
public class C2490j {
    /* renamed from: a */
    public static EnumC2491k m7567a(C2495o c2495o) {
        EnumC2491k enumC2491k = EnumC2491k.STYLE_DEFAULT;
        return (c2495o.m7621v() < 0 || c2495o.m7621v() >= EnumC2491k.values().length) ? enumC2491k : EnumC2491k.values()[c2495o.m7621v()];
    }

    /* renamed from: a */
    public static void m7568a(Notification.Builder builder, String str, C2495o c2495o) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(c2495o.m7608g())) {
            bigTextStyle.setBigContentTitle(c2495o.m7608g());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
