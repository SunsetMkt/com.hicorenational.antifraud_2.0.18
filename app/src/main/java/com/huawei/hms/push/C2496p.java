package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushSelfShowThread.java */
/* renamed from: com.huawei.hms.push.p */
/* loaded from: classes.dex */
public class C2496p extends Thread {

    /* renamed from: a */
    private Context f7788a;

    /* renamed from: b */
    private C2495o f7789b;

    public C2496p(Context context, C2495o c2495o) {
        this.f7788a = context;
        this.f7789b = c2495o;
    }

    /* renamed from: a */
    private static Intent m7625a(Context context, C2495o c2495o) {
        if (c2495o == null) {
            return null;
        }
        Intent m7555b = C2485e.m7555b(context, c2495o.m7604c());
        if (c2495o.m7614m() == null) {
            if (c2495o.m7601a() != null) {
                Intent intent = new Intent(c2495o.m7601a());
                if (C2485e.m7552a(context, c2495o.m7604c(), intent).booleanValue()) {
                    m7555b = intent;
                }
            }
            m7555b.setPackage(c2495o.m7604c());
            return m7555b;
        }
        try {
            Intent parseUri = Intent.parseUri(c2495o.m7614m(), 0);
            parseUri.setSelector(null);
            if (parseUri.getClipData() == null) {
                parseUri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
            }
            HMSLog.m7712d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
            return C2485e.m7552a(context, c2495o.m7604c(), parseUri).booleanValue() ? parseUri : m7555b;
        } catch (Exception e2) {
            HMSLog.m7718w("PushSelfShowLog", "intentUri error," + e2.toString());
            return m7555b;
        }
    }

    /* renamed from: b */
    private boolean m7627b(Context context) {
        if ("cosa".equals(this.f7789b.m7609h())) {
            return m7626a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.m7717i("PushSelfShowLog", "enter run()");
        try {
            if (!m7627b(this.f7788a) || m7628b(this.f7788a, this.f7789b)) {
                return;
            }
            C2494n.m7576a(this.f7788a, this.f7789b);
        } catch (Exception e2) {
            HMSLog.m7715e("PushSelfShowLog", e2.toString());
        }
    }

    /* renamed from: b */
    private boolean m7628b(Context context, C2495o c2495o) {
        if (!"cosa".equals(c2495o.m7609h()) || m7625a(context, c2495o) != null) {
            return false;
        }
        HMSLog.m7712d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    /* renamed from: a */
    private boolean m7626a(Context context) {
        return C2485e.m7558c(context, this.f7789b.m7604c());
    }
}
