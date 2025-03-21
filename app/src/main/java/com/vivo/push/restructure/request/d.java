package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.i;
import com.vivo.push.util.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: RequestManager.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, b> f12199a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f12200b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f12201c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f12202d;

    /* compiled from: RequestManager.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static d f12203a = new d(0);
    }

    /* synthetic */ d(byte b2) {
        this();
    }

    private synchronized Integer b() {
        Integer valueOf;
        if (this.f12200b == null) {
            this.f12200b = 0;
        }
        if (this.f12200b.intValue() < 0 || this.f12200b.intValue() >= Integer.MAX_VALUE) {
            this.f12200b = 0;
        }
        valueOf = Integer.valueOf(this.f12200b.intValue() + 1);
        this.f12200b = valueOf;
        return new Integer(valueOf.intValue());
    }

    private d() {
        this.f12199a = new ConcurrentHashMap();
        this.f12200b = null;
        this.f12201c = new HandlerThread("request_timer_task——thread");
        this.f12201c.start();
        this.f12202d = new e(this, this.f12201c.getLooper());
    }

    public static d a() {
        return a.f12203a;
    }

    public final void a(b bVar) {
        Integer b2 = b();
        int a2 = a(bVar.a().a(b2.intValue()));
        if (a2 != 0) {
            if (bVar.b() != null) {
                bVar.b().a(a2);
            }
        } else {
            if (bVar.c() <= 0 || bVar.b() == null) {
                return;
            }
            this.f12199a.put(b2, bVar);
            this.f12202d.sendEmptyMessageDelayed(b2.intValue(), bVar.c());
        }
    }

    public final void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.request.a.a h2;
        int b2;
        com.vivo.push.restructure.request.a.a.a aVar2;
        if (aVar == null || !aVar.g() || (b2 = (h2 = aVar.h()).b()) <= 0) {
            return;
        }
        this.f12202d.removeMessages(b2);
        b remove = this.f12199a.remove(Integer.valueOf(b2));
        if (remove == null || remove.b() == null || remove.a() == null) {
            return;
        }
        if (h2.c() == 0) {
            try {
                aVar2 = new com.vivo.push.restructure.request.a.a.a(aVar.i());
            } catch (JSONException e2) {
                e2.printStackTrace();
                aVar2 = null;
            }
            if (aVar2 != null) {
                remove.b().a((c) remove.a().a(aVar2));
                return;
            } else {
                remove.b().a(8003);
                return;
            }
        }
        remove.b().a(h2.c());
    }

    private static int a(Intent intent) {
        Context b2 = com.vivo.push.restructure.a.a().b();
        if (b2 == null) {
            return JosStatusCodes.RNT_CODE_NO_JOS_INFO;
        }
        i a2 = i.a(b2, "com.vivo.vms.aidlservice");
        if (a2.a() && !"com.vivo.pushservice".equals(b2.getPackageName())) {
            if (a2.a(intent.getExtras())) {
                return 0;
            }
            u.b("RequestManager", "send command error by aidl");
            u.c(b2, "send command error by aidl");
        }
        String k2 = com.vivo.push.restructure.a.a().e().k();
        if (TextUtils.isEmpty(k2)) {
            return JosStatusCodes.RTN_CODE_NO_SUPPORT_JOS;
        }
        Intent intent2 = new Intent("com.vivo.pushservice.action.METHOD");
        intent2.setPackage(k2);
        intent2.setClassName(k2, "com.vivo.push.sdk.service.PushService");
        try {
            com.vivo.push.a.a.a(b2, intent2);
        } catch (Exception e2) {
            u.a("RequestManager", "CommandBridge startService exception: ", e2);
        }
        return 0;
    }
}
