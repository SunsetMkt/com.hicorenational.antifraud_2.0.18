package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.service.C4358aj;

/* loaded from: classes2.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        C4265he c4265he = new C4265he();
        c4265he.m15318c(EnumC4249gp.VRUpload.f15769a);
        c4265he.m15314b(C4048b.m13476a(context).m13480a());
        c4265he.m15322d(context.getPackageName());
        c4265he.m15309a("data", str);
        c4265he.m15301a(C4358aj.m15941a());
        C4067u.m13627a(context).m13659a((C4067u) c4265he, EnumC4239gf.Notification, (C4252gs) null);
    }
}
