package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.service.C4356ah;

/* renamed from: com.xiaomi.push.dk */
/* loaded from: classes2.dex */
public class C4163dk {

    /* renamed from: a */
    private static volatile C4163dk f14890a;

    /* renamed from: a */
    private Context f14891a;

    /* renamed from: a */
    private a f14892a;

    /* renamed from: com.xiaomi.push.dk$a */
    public interface a {
        /* renamed from: a */
        void m14296a();
    }

    private C4163dk(Context context) {
        this.f14891a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14294b() {
        a aVar;
        C4076ae m13698a = C4076ae.m13698a(this.f14891a);
        C4356ah m15923a = C4356ah.m15923a(this.f14891a);
        SharedPreferences sharedPreferences = this.f14891a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j2 == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j2) < 172800000) {
            return;
        }
        m14292a(m15923a, m13698a, false);
        if (m15923a.m15935a(EnumC4244gk.StorageCollectionSwitch.m15014a(), true)) {
            int m14289a = m14289a(m15923a.m15927a(EnumC4244gk.StorageCollectionFrequency.m15014a(), RemoteMessageConst.DEFAULT_TTL));
            m13698a.m13707a(new C4165dm(this.f14891a, m14289a), m14289a, 0);
        }
        if (C4300j.m15681a(this.f14891a) && (aVar = this.f14892a) != null) {
            aVar.m14296a();
        }
        if (m15923a.m15935a(EnumC4244gk.ActivityTSSwitch.m15014a(), false)) {
            m14293a();
        }
        m14292a(m15923a, m13698a, true);
    }

    /* renamed from: a */
    public static C4163dk m14290a(Context context) {
        if (f14890a == null) {
            synchronized (C4163dk.class) {
                if (f14890a == null) {
                    f14890a = new C4163dk(context);
                }
            }
        }
        return f14890a;
    }

    /* renamed from: a */
    public void m14295a() {
        C4076ae.m13698a(this.f14891a).m13703a(new Runnable() { // from class: com.xiaomi.push.dk.1
            @Override // java.lang.Runnable
            public void run() {
                C4163dk.this.m14294b();
            }
        });
    }

    /* renamed from: a */
    private void m14292a(C4356ah c4356ah, C4076ae c4076ae, boolean z) {
        if (c4356ah.m15935a(EnumC4244gk.UploadSwitch.m15014a(), true)) {
            C4166dn c4166dn = new C4166dn(this.f14891a);
            if (z) {
                c4076ae.m13706a((C4076ae.a) c4166dn, m14289a(c4356ah.m15927a(EnumC4244gk.UploadFrequency.m15014a(), RemoteMessageConst.DEFAULT_TTL)));
            } else {
                c4076ae.m13705a((C4076ae.a) c4166dn);
            }
        }
    }

    /* renamed from: a */
    public static int m14289a(int i2) {
        return Math.max(60, i2);
    }

    /* renamed from: a */
    private boolean m14293a() {
        Application application;
        try {
            if (this.f14891a instanceof Application) {
                application = (Application) this.f14891a;
            } else {
                application = (Application) this.f14891a.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new C4157de(this.f14891a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return false;
        }
    }
}
