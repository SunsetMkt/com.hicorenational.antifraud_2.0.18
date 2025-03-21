package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.connect.common.Constants;

/* compiled from: SelfShowType.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f7238c = {"url", Constants.JumpUrlConstants.SRC_TYPE_APP, "cosa", "rp"};

    /* renamed from: a, reason: collision with root package name */
    private Context f7239a;

    /* renamed from: b, reason: collision with root package name */
    private o f7240b;

    public u(Context context, o oVar) {
        this.f7239a = context;
        this.f7240b = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : f7238c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
    
        if (r3 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00cb, code lost:
    
        if (com.huawei.hms.push.e.a(r6.f7239a, r6.f7240b.c(), r2).booleanValue() != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d0 A[Catch: Exception -> 0x00f2, TryCatch #1 {Exception -> 0x00f2, blocks: (B:3:0x0007, B:12:0x00d0, B:15:0x00d6, B:17:0x00e1, B:18:0x00ec, B:20:0x00e7, B:6:0x00a8, B:8:0x00b0, B:29:0x008f, B:22:0x0044, B:24:0x0058, B:25:0x0063), top: B:2:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6 A[Catch: Exception -> 0x00f2, TryCatch #1 {Exception -> 0x00f2, blocks: (B:3:0x0007, B:12:0x00d0, B:15:0x00d6, B:17:0x00e1, B:18:0x00ec, B:20:0x00e7, B:6:0x00a8, B:8:0x00b0, B:29:0x008f, B:22:0x0044, B:24:0x0058, B:25:0x0063), top: B:2:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.u.b():void");
    }

    public void c() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f7239a == null || (oVar = this.f7240b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equals(oVar.h())) {
            a();
            return;
        }
        if ("cosa".equals(this.f7240b.h())) {
            b();
            return;
        }
        if ("rp".equals(this.f7240b.h())) {
            HMSLog.w("PushSelfShowLog", this.f7240b.h() + " not support rich message.");
            return;
        }
        if ("url".equals(this.f7240b.h())) {
            HMSLog.w("PushSelfShowLog", this.f7240b.h() + " not support URL.");
            return;
        }
        HMSLog.d("PushSelfShowLog", this.f7240b.h() + " is not exist in hShowType");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f7240b.c());
            if (e.c(this.f7239a, this.f7240b.c())) {
                b();
            }
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e2.toString());
        }
    }
}
