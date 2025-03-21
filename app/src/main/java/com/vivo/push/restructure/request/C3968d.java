package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.ServiceConnectionC3920i;
import com.vivo.push.p231a.C3825a;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.restructure.request.p243a.C3959a;
import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.util.C4010u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: RequestManager.java */
/* renamed from: com.vivo.push.restructure.request.d */
/* loaded from: classes2.dex */
public final class C3968d {

    /* renamed from: a */
    private Map<Integer, C3966b> f14178a;

    /* renamed from: b */
    private Integer f14179b;

    /* renamed from: c */
    private HandlerThread f14180c;

    /* renamed from: d */
    private Handler f14181d;

    /* compiled from: RequestManager.java */
    /* renamed from: com.vivo.push.restructure.request.d$a */
    private static class a {

        /* renamed from: a */
        static C3968d f14182a = new C3968d(0);
    }

    /* synthetic */ C3968d(byte b2) {
        this();
    }

    /* renamed from: b */
    private synchronized Integer m13157b() {
        Integer valueOf;
        if (this.f14179b == null) {
            this.f14179b = 0;
        }
        if (this.f14179b.intValue() < 0 || this.f14179b.intValue() >= Integer.MAX_VALUE) {
            this.f14179b = 0;
        }
        valueOf = Integer.valueOf(this.f14179b.intValue() + 1);
        this.f14179b = valueOf;
        return new Integer(valueOf.intValue());
    }

    private C3968d() {
        this.f14178a = new ConcurrentHashMap();
        this.f14179b = null;
        this.f14180c = new HandlerThread("request_timer_task——thread");
        this.f14180c.start();
        this.f14181d = new HandlerC3969e(this, this.f14180c.getLooper());
    }

    /* renamed from: a */
    public static C3968d m13155a() {
        return a.f14182a;
    }

    /* renamed from: a */
    public final void m13159a(C3966b c3966b) {
        Integer m13157b = m13157b();
        int m13154a = m13154a(c3966b.m13151a().m13138a(m13157b.intValue()));
        if (m13154a != 0) {
            if (c3966b.m13152b() != null) {
                c3966b.m13152b().mo12938a(m13154a);
            }
        } else {
            if (c3966b.m13153c() <= 0 || c3966b.m13152b() == null) {
                return;
            }
            this.f14178a.put(m13157b, c3966b);
            this.f14181d.sendEmptyMessageDelayed(m13157b.intValue(), c3966b.m13153c());
        }
    }

    /* renamed from: a */
    public final void m13158a(InterfaceC3933a interfaceC3933a) {
        C3959a mo13085h;
        int m13140b;
        C3960a c3960a;
        if (interfaceC3933a == null || !interfaceC3933a.mo13084g() || (m13140b = (mo13085h = interfaceC3933a.mo13085h()).m13140b()) <= 0) {
            return;
        }
        this.f14181d.removeMessages(m13140b);
        C3966b remove = this.f14178a.remove(Integer.valueOf(m13140b));
        if (remove == null || remove.m13152b() == null || remove.m13151a() == null) {
            return;
        }
        if (mo13085h.m13141c() == 0) {
            try {
                c3960a = new C3960a(interfaceC3933a.mo13086i());
            } catch (JSONException e2) {
                e2.printStackTrace();
                c3960a = null;
            }
            if (c3960a != null) {
                remove.m13152b().mo12939a((InterfaceC3967c) remove.m13151a().mo12928a(c3960a));
                return;
            } else {
                remove.m13152b().mo12938a(8003);
                return;
            }
        }
        remove.m13152b().mo12938a(mo13085h.m13141c());
    }

    /* renamed from: a */
    private static int m13154a(Intent intent) {
        Context m13071b = C3932a.m13069a().m13071b();
        if (m13071b == null) {
            return JosStatusCodes.RNT_CODE_NO_JOS_INFO;
        }
        ServiceConnectionC3920i m12995a = ServiceConnectionC3920i.m12995a(m13071b, "com.vivo.vms.aidlservice");
        if (m12995a.m13005a() && !"com.vivo.pushservice".equals(m13071b.getPackageName())) {
            if (m12995a.m13006a(intent.getExtras())) {
                return 0;
            }
            C4010u.m13301b("RequestManager", "send command error by aidl");
            C4010u.m13308c(m13071b, "send command error by aidl");
        }
        String mo13129k = C3932a.m13069a().m13074e().mo13129k();
        if (TextUtils.isEmpty(mo13129k)) {
            return JosStatusCodes.RTN_CODE_NO_SUPPORT_JOS;
        }
        Intent intent2 = new Intent("com.vivo.pushservice.action.METHOD");
        intent2.setPackage(mo13129k);
        intent2.setClassName(mo13129k, "com.vivo.push.sdk.service.PushService");
        try {
            C3825a.m12826a(m13071b, intent2);
        } catch (Exception e2) {
            C4010u.m13293a("RequestManager", "CommandBridge startService exception: ", e2);
        }
        return 0;
    }
}
