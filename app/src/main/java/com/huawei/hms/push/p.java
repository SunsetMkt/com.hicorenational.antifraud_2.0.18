package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: compiled from: PushSelfShowThread.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends Thread {
    private Context a;

    /* JADX INFO: renamed from: b */
    private o f4899b;

    public p(Context context, o oVar) {
        this.a = context;
        this.f4899b = oVar;
    }

    private static Intent a(Context context, o oVar) {
        if (oVar == null) {
            return null;
        }
        Intent intentB = e.b(context, oVar.c());
        if (oVar.m() == null) {
            if (oVar.a() != null) {
                Intent intent = new Intent(oVar.a());
                if (e.a(context, oVar.c(), intent).booleanValue()) {
                    intentB = intent;
                }
            }
            intentB.setPackage(oVar.c());
            return intentB;
        }
        try {
            Intent uri = Intent.parseUri(oVar.m(), 0);
            uri.setSelector(null);
            if (uri.getClipData() == null) {
                uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
            }
            HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
            return e.a(context, oVar.c(), uri).booleanValue() ? uri : intentB;
        } catch (Exception e2) {
            HMSLog.w("PushSelfShowLog", "intentUri error," + e2.toString());
            return intentB;
        }
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.f4899b.h())) {
            return a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.a) || b(this.a, this.f4899b)) {
                return;
            }
            n.a(this.a, this.f4899b);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", e2.toString());
        }
    }

    private boolean b(Context context, o oVar) {
        if (!"cosa".equals(oVar.h()) || a(context, oVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    private boolean a(Context context) {
        return e.c(context, this.f4899b.c());
    }
}
