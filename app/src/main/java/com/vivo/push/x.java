package com.vivo.push;

import android.net.Uri;
import ui.activity.BaseProgressUploadActivity;

/* JADX INFO: compiled from: PushConstants.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static final Uri a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f8697b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f8698c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f8699d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Uri f8700e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Uri f8701f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");

    public static String a(int i2) {
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
