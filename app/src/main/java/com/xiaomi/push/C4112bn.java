package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4121bw;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4374az;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.bn */
/* loaded from: classes2.dex */
public class C4112bn {

    /* renamed from: a */
    private static volatile C4112bn f14637a;

    /* renamed from: a */
    private Context f14638a;

    /* renamed from: a */
    private InterfaceC4122bx f14640a;

    /* renamed from: a */
    private InterfaceC4123by f14641a;

    /* renamed from: e */
    private String f14648e;

    /* renamed from: f */
    private String f14649f;

    /* renamed from: a */
    private final String f14642a = "push_stat_sp";

    /* renamed from: b */
    private final String f14644b = "upload_time";

    /* renamed from: c */
    private final String f14646c = "delete_time";

    /* renamed from: d */
    private final String f14647d = "check_time";

    /* renamed from: a */
    private C4076ae.a f14639a = new C4076ae.a() { // from class: com.xiaomi.push.bn.1
        @Override // com.xiaomi.push.C4076ae.a
        /* renamed from: a */
        public String mo13391a() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4022b.m13359c("exec== mUploadJob");
            if (C4112bn.this.f14641a != null) {
                C4112bn.this.f14641a.m13975a(C4112bn.this.f14638a);
                C4112bn.this.m13937b("upload_time");
            }
        }
    };

    /* renamed from: b */
    private C4076ae.a f14643b = new C4076ae.a() { // from class: com.xiaomi.push.bn.2
        @Override // com.xiaomi.push.C4076ae.a
        /* renamed from: a */
        public String mo13391a() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4022b.m13359c("exec== DbSizeControlJob");
            C4121bw.m13957a(C4112bn.this.f14638a).m13962a(new RunnableC4114bp(C4112bn.this.m13938c(), new WeakReference(C4112bn.this.f14638a)));
            C4112bn.this.m13937b("check_time");
        }
    };

    /* renamed from: c */
    private C4076ae.a f14645c = new C4076ae.a() { // from class: com.xiaomi.push.bn.3
        @Override // com.xiaomi.push.C4076ae.a
        /* renamed from: a */
        public String mo13391a() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4112bn.this.f14641a != null) {
                C4112bn.this.f14641a.m13976b(C4112bn.this.f14638a);
                C4112bn.this.m13937b("delete_time");
            }
        }
    };

    private C4112bn(Context context) {
        this.f14638a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13937b(String str) {
        SharedPreferences.Editor edit = this.f14638a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        C4306p.m15711a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public String m13938c() {
        return this.f14638a.getDatabasePath(C4113bo.f14655a).getAbsolutePath();
    }

    /* renamed from: a */
    public static C4112bn m13932a(Context context) {
        if (f14637a == null) {
            synchronized (C4112bn.class) {
                if (f14637a == null) {
                    f14637a = new C4112bn(context);
                }
            }
        }
        return f14637a;
    }

    /* renamed from: b */
    public String m13944b() {
        return this.f14649f;
    }

    /* renamed from: a */
    private boolean m13936a() {
        return C4356ah.m15923a(this.f14638a).m15935a(EnumC4244gk.StatDataSwitch.m15014a(), true);
    }

    /* renamed from: a */
    public void m13940a(C4121bw.a aVar) {
        C4121bw.m13957a(this.f14638a).m13961a(aVar);
    }

    /* renamed from: a */
    public void m13943a(String str, String str2, Boolean bool) {
        if (this.f14640a != null) {
            if (bool.booleanValue()) {
                this.f14640a.m13973a(this.f14638a, str2, str);
            } else {
                this.f14640a.m13974b(this.f14638a, str2, str);
            }
        }
    }

    /* renamed from: a */
    public String m13939a() {
        return this.f14648e;
    }

    /* renamed from: a */
    public void m13942a(String str) {
        if (m13936a() && !TextUtils.isEmpty(str)) {
            m13941a(C4124bz.m13977a(this.f14638a, str));
        }
    }

    /* renamed from: a */
    public void m13941a(C4243gj c4243gj) {
        if (m13936a() && C4374az.m16044a(c4243gj.m15004e())) {
            m13940a(C4118bt.m13953a(this.f14638a, m13938c(), c4243gj));
        }
    }
}
