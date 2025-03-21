package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;

/* renamed from: com.xiaomi.push.ed */
/* loaded from: classes2.dex */
public enum EnumC4183ed {
    COMMAND_REGISTER("register"),
    COMMAND_UNREGISTER(MiPushClient.COMMAND_UNREGISTER),
    COMMAND_SET_ALIAS(MiPushClient.COMMAND_SET_ALIAS),
    COMMAND_UNSET_ALIAS(MiPushClient.COMMAND_UNSET_ALIAS),
    COMMAND_SET_ACCOUNT(MiPushClient.COMMAND_SET_ACCOUNT),
    COMMAND_UNSET_ACCOUNT(MiPushClient.COMMAND_UNSET_ACCOUNT),
    COMMAND_SUBSCRIBE_TOPIC(MiPushClient.COMMAND_SUBSCRIBE_TOPIC),
    COMMAND_UNSUBSCRIBE_TOPIC(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC),
    COMMAND_SET_ACCEPT_TIME(MiPushClient.COMMAND_SET_ACCEPT_TIME),
    COMMAND_CHK_VDEVID("check-vdeviceid");


    /* renamed from: a */
    public final String f15082a;

    EnumC4183ed(String str) {
        this.f15082a = str;
    }

    /* renamed from: a */
    public static int m14594a(String str) {
        int i2 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (EnumC4183ed enumC4183ed : values()) {
            if (enumC4183ed.f15082a.equals(str)) {
                i2 = C4171ds.m14514a(enumC4183ed);
            }
        }
        return i2;
    }
}
