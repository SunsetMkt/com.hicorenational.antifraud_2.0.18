package com.huawei.hms.push;

import android.R;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: NotificationIconUtil.java */
/* renamed from: com.huawei.hms.push.h */
/* loaded from: classes.dex */
public class C2488h {
    /* renamed from: a */
    private static int m7561a(Context context) {
        int i2 = context.getApplicationInfo().icon;
        if (i2 != 0) {
            return i2;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", DispatchConstants.ANDROID);
        HMSLog.m7712d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.m7712d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return R.drawable.sym_def_app_icon;
    }

    /* renamed from: b */
    private static int m7564b(Context context, C2495o c2495o) {
        int i2 = 0;
        if (context == null || c2495o == null) {
            HMSLog.m7717i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!TextUtils.isEmpty(c2495o.m7613l())) {
            String[] split = c2495o.m7613l().split("/");
            if (split.length == 3) {
                i2 = C2499s.m7635a(context, split[1], split[2]);
            }
        }
        if (i2 == 0) {
            i2 = C2499s.m7634a(context, "com.huawei.messaging.default_notification_icon");
        }
        return i2 != 0 ? i2 : m7561a(context);
    }

    /* renamed from: a */
    public static Bitmap m7562a(Context context, C2495o c2495o) {
        if (context == null || c2495o == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.m7717i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            }
            if ("com.huawei.android.pushagent".equals(c2495o.m7611j())) {
                return null;
            }
            HMSLog.m7717i("PushSelfShowLog", "get left bitmap from " + c2495o.m7611j());
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(c2495o.m7611j())).getBitmap();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m7715e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.m7715e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    /* renamed from: a */
    public static void m7563a(Context context, Notification.Builder builder, C2495o c2495o) {
        if (context != null && builder != null && c2495o != null) {
            builder.setSmallIcon(m7564b(context, c2495o));
        } else {
            HMSLog.m7715e("PushSelfShowLog", "msg is null");
        }
    }
}
