package com.vivo.push;

import android.net.Uri;
import p388ui.activity.BaseProgressUploadActivity;

/* compiled from: PushConstants.java */
/* renamed from: com.vivo.push.x */
/* loaded from: classes2.dex */
public final class C4018x {

    /* renamed from: a */
    public static final Uri f14285a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* renamed from: b */
    public static final Uri f14286b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c */
    public static final Uri f14287c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d */
    public static final Uri f14288d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    /* renamed from: e */
    public static final Uri f14289e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");

    /* renamed from: f */
    public static final Uri f14290f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");

    /* renamed from: a */
    public static String m13328a(int i2) {
        switch (i2) {
            case BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 /* 2002 */:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case 2004:
                return "method_tag_bind";
            case 2005:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
