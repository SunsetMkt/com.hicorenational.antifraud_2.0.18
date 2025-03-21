package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.j */
/* loaded from: classes2.dex */
public class C4056j {

    /* renamed from: a */
    private static volatile C4056j f14415a;

    /* renamed from: a */
    private final Context f14416a;

    private C4056j(Context context) {
        this.f14416a = context.getApplicationContext();
    }

    /* renamed from: a */
    private static C4056j m13566a(Context context) {
        if (f14415a == null) {
            synchronized (C4056j.class) {
                if (f14415a == null) {
                    f14415a = new C4056j(context);
                }
            }
        }
        return f14415a;
    }

    /* renamed from: b */
    public static void m13570b(Context context, C4262hb c4262hb, boolean z) {
        m13566a(context).m13569a(c4262hb, 2, z);
    }

    /* renamed from: c */
    public static void m13571c(Context context, C4262hb c4262hb, boolean z) {
        m13566a(context).m13569a(c4262hb, 3, z);
    }

    /* renamed from: d */
    public static void m13572d(Context context, C4262hb c4262hb, boolean z) {
        m13566a(context).m13569a(c4262hb, 4, z);
    }

    /* renamed from: e */
    public static void m13573e(Context context, C4262hb c4262hb, boolean z) {
        C4048b m13476a = C4048b.m13476a(context);
        if (TextUtils.isEmpty(m13476a.m13495c()) || TextUtils.isEmpty(m13476a.m13497d())) {
            m13566a(context).m13569a(c4262hb, 6, z);
        } else if (m13476a.m13502f()) {
            m13566a(context).m13569a(c4262hb, 7, z);
        } else {
            m13566a(context).m13569a(c4262hb, 5, z);
        }
    }

    /* renamed from: a */
    public static void m13568a(Context context, C4262hb c4262hb, boolean z) {
        m13566a(context).m13569a(c4262hb, 1, z);
    }

    /* renamed from: a */
    public static void m13567a(Context context, C4262hb c4262hb) {
        m13566a(context).m13569a(c4262hb, 0, true);
    }

    /* renamed from: a */
    private void m13569a(C4262hb c4262hb, int i2, boolean z) {
        if (C4300j.m15681a(this.f14416a) || !C4300j.m15680a() || c4262hb == null || c4262hb.f15998a != EnumC4239gf.SendMessage || c4262hb.m15264a() == null || !z) {
            return;
        }
        AbstractC4022b.m13347a("click to start activity result:" + String.valueOf(i2));
        C4265he c4265he = new C4265he(c4262hb.m15264a().m15096a(), false);
        c4265he.m15318c(EnumC4249gp.SDK_START_ACTIVITY.f15769a);
        c4265he.m15314b(c4262hb.m15271a());
        c4265he.m15322d(c4262hb.f16005b);
        c4265he.f16034a = new HashMap();
        c4265he.f16034a.put("result", String.valueOf(i2));
        C4067u.m13627a(this.f14416a).m13666a(c4265he, EnumC4239gf.Notification, false, false, null, true, c4262hb.f16005b, c4262hb.f16001a, true, false);
    }
}
