package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* JADX INFO: compiled from: SelfShowType.java */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: c */
    private static final String[] f4907c = {"url", Constants.JumpUrlConstants.SRC_TYPE_APP, "cosa", "rp"};
    private Context a;

    /* JADX INFO: renamed from: b */
    private o f4908b;

    public u(Context context, o oVar) {
        this.a = context;
        this.f4908b = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : f4907c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd A[PHI: r2 r3
  0x00cd: PHI (r2v22 android.content.Intent) = (r2v16 android.content.Intent), (r2v25 android.content.Intent) binds: [B:45:0x008b, B:52:0x00cb] A[DONT_GENERATE, DONT_INLINE]
  0x00cd: PHI (r3v5 boolean) = (r3v3 boolean), (r3v1 boolean) binds: [B:45:0x008b, B:52:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        Intent uri;
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.f4908b.c() + ",and msg.intentUri is " + this.f4908b.m());
            Intent intentB = e.b(this.a, this.f4908b.c());
            boolean zBooleanValue = false;
            if (this.f4908b.m() != null) {
                try {
                    uri = Intent.parseUri(this.f4908b.m(), 0);
                    uri.setSelector(null);
                    if (uri.getClipData() == null) {
                        uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                    }
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
                    zBooleanValue = e.a(this.a, this.f4908b.c(), uri).booleanValue();
                    if (zBooleanValue) {
                        intentB = uri;
                    }
                } catch (Exception e2) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e2.toString());
                }
            } else if (this.f4908b.a() != null) {
                uri = new Intent(this.f4908b.a());
                if (e.a(this.a, this.f4908b.c(), uri).booleanValue()) {
                }
            }
            if (intentB == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            intentB.setPackage(this.f4908b.c());
            if (zBooleanValue) {
                intentB.addFlags(CommonNetImpl.FLAG_AUTH);
            } else {
                intentB.setFlags(805437440);
            }
            this.a.startActivity(intentB);
        } catch (Exception e3) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e3.toString());
        }
    }

    public void c() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.a == null || (oVar = this.f4908b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equals(oVar.h())) {
            a();
            return;
        }
        if ("cosa".equals(this.f4908b.h())) {
            b();
            return;
        }
        if ("rp".equals(this.f4908b.h())) {
            HMSLog.w("PushSelfShowLog", this.f4908b.h() + " not support rich message.");
            return;
        }
        if ("url".equals(this.f4908b.h())) {
            HMSLog.w("PushSelfShowLog", this.f4908b.h() + " not support URL.");
            return;
        }
        HMSLog.d("PushSelfShowLog", this.f4908b.h() + " is not exist in hShowType");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f4908b.c());
            if (e.c(this.a, this.f4908b.c())) {
                b();
            }
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e2.toString());
        }
    }
}
