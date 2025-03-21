package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.connect.common.Constants;

/* compiled from: SelfShowType.java */
/* renamed from: com.huawei.hms.push.u */
/* loaded from: classes.dex */
public class C2501u {

    /* renamed from: c */
    private static final String[] f7803c = {"url", Constants.JumpUrlConstants.SRC_TYPE_APP, "cosa", "rp"};

    /* renamed from: a */
    private Context f7804a;

    /* renamed from: b */
    private C2495o f7805b;

    public C2501u(Context context, C2495o c2495o) {
        this.f7804a = context;
        this.f7805b = c2495o;
    }

    /* renamed from: a */
    public static boolean m7644a(String str) {
        for (String str2 : f7803c) {
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
    
        if (com.huawei.hms.push.C2485e.m7552a(r6.f7804a, r6.f7805b.m7604c(), r2).booleanValue() != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d0 A[Catch: Exception -> 0x00f2, TryCatch #1 {Exception -> 0x00f2, blocks: (B:3:0x0007, B:12:0x00d0, B:15:0x00d6, B:17:0x00e1, B:18:0x00ec, B:20:0x00e7, B:6:0x00a8, B:8:0x00b0, B:29:0x008f, B:22:0x0044, B:24:0x0058, B:25:0x0063), top: B:2:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6 A[Catch: Exception -> 0x00f2, TryCatch #1 {Exception -> 0x00f2, blocks: (B:3:0x0007, B:12:0x00d0, B:15:0x00d6, B:17:0x00e1, B:18:0x00ec, B:20:0x00e7, B:6:0x00a8, B:8:0x00b0, B:29:0x008f, B:22:0x0044, B:24:0x0058, B:25:0x0063), top: B:2:0x0007, inners: #0 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7645b() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.C2501u.m7645b():void");
    }

    /* renamed from: c */
    public void m7646c() {
        C2495o c2495o;
        HMSLog.m7712d("PushSelfShowLog", "enter launchNotify()");
        if (this.f7804a == null || (c2495o = this.f7805b) == null) {
            HMSLog.m7712d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equals(c2495o.m7609h())) {
            m7643a();
            return;
        }
        if ("cosa".equals(this.f7805b.m7609h())) {
            m7645b();
            return;
        }
        if ("rp".equals(this.f7805b.m7609h())) {
            HMSLog.m7718w("PushSelfShowLog", this.f7805b.m7609h() + " not support rich message.");
            return;
        }
        if ("url".equals(this.f7805b.m7609h())) {
            HMSLog.m7718w("PushSelfShowLog", this.f7805b.m7609h() + " not support URL.");
            return;
        }
        HMSLog.m7712d("PushSelfShowLog", this.f7805b.m7609h() + " is not exist in hShowType");
    }

    /* renamed from: a */
    private void m7643a() {
        try {
            HMSLog.m7717i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f7805b.m7604c());
            if (C2485e.m7558c(this.f7804a, this.f7805b.m7604c())) {
                m7645b();
            }
        } catch (Exception e2) {
            HMSLog.m7715e("PushSelfShowLog", "launchApp error:" + e2.toString());
        }
    }
}
