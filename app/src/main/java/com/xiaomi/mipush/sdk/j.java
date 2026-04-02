package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static volatile j a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f122a;

    private j(Context context) {
        this.f122a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    public static void b(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 2, z);
    }

    public static void c(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 3, z);
    }

    public static void d(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 4, z);
    }

    public static void e(Context context, hb hbVar, boolean z) {
        b bVarM73a = b.m73a(context);
        if (TextUtils.isEmpty(bVarM73a.m81c()) || TextUtils.isEmpty(bVarM73a.d())) {
            a(context).a(hbVar, 6, z);
        } else if (bVarM73a.m85f()) {
            a(context).a(hbVar, 7, z);
        } else {
            a(context).a(hbVar, 5, z);
        }
    }

    public static void a(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 1, z);
    }

    public static void a(Context context, hb hbVar) {
        a(context).a(hbVar, 0, true);
    }

    private void a(hb hbVar, int i2, boolean z) {
        if (com.xiaomi.push.j.m625a(this.f122a) || !com.xiaomi.push.j.m624a() || hbVar == null || hbVar.f717a != gf.SendMessage || hbVar.m527a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("click to start activity result:" + String.valueOf(i2));
        he heVar = new he(hbVar.m527a().m493a(), false);
        heVar.c(gp.SDK_START_ACTIVITY.f597a);
        heVar.b(hbVar.m528a());
        heVar.d(hbVar.f724b);
        heVar.f736a = new HashMap();
        heVar.f736a.put("result", String.valueOf(i2));
        u.a(this.f122a).a(heVar, gf.Notification, false, false, null, true, hbVar.f724b, hbVar.f720a, true, false);
    }
}
