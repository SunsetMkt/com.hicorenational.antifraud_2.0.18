package com.tencent.connect;

import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.a */
/* loaded from: classes2.dex */
public class C3202a {
    /* renamed from: a */
    public static boolean m10152a(String str, IUiListener iUiListener) {
        return m10153a(str, iUiListener, -6, Constants.MSG_PERMISSION_NOT_GRANTED, Constants.MSG_PERMISSION_NOT_GRANTED);
    }

    /* renamed from: a */
    public static boolean m10153a(String str, IUiListener iUiListener, int i2, String str2, String str3) {
        if (!Tencent.isPermissionNotGranted()) {
            return false;
        }
        SLog.m10502i(str, "permission not granted");
        if (iUiListener == null) {
            return true;
        }
        iUiListener.onError(new UiError(i2, str2, str3));
        return true;
    }
}
