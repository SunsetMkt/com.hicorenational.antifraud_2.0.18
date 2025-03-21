package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4257gx;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4245gl;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4357ai;

/* renamed from: com.xiaomi.mipush.sdk.o */
/* loaded from: classes2.dex */
public class C4061o extends C4076ae.a {

    /* renamed from: a */
    private Context f14424a;

    /* renamed from: a */
    private boolean f14425a = false;

    public C4061o(Context context) {
        this.f14424a = context;
    }

    @Override // com.xiaomi.push.C4076ae.a
    /* renamed from: a */
    public String mo13391a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        C4356ah m15923a = C4356ah.m15923a(this.f14424a);
        C4257gx c4257gx = new C4257gx();
        if (this.f14425a) {
            c4257gx.m15204a(0);
            c4257gx.m15209b(0);
        } else {
            c4257gx.m15204a(C4357ai.m15937a(m15923a, EnumC4245gl.MISC_CONFIG));
            c4257gx.m15209b(C4357ai.m15937a(m15923a, EnumC4245gl.PLUGIN_CONFIG));
        }
        C4265he c4265he = new C4265he("-1", false);
        c4265he.m15318c(EnumC4249gp.DailyCheckClientConfig.f15769a);
        c4265he.m15305a(C4276hp.m15567a(c4257gx));
        AbstractC4022b.m13358b("OcVersionCheckJob", "-->check version: checkMessage=", c4257gx);
        C4067u.m13627a(this.f14424a).m13659a((C4067u) c4265he, EnumC4239gf.Notification, (C4252gs) null);
    }
}
