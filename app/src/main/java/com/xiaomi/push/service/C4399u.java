package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3351bh;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.AbstractC4221fo;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.C4218fl;
import com.xiaomi.push.C4220fn;
import com.xiaomi.push.C4232fz;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4255gv;
import com.xiaomi.push.C4256gw;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.C4402x;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.u */
/* loaded from: classes2.dex */
public class C4399u {
    /* renamed from: b */
    private static void m16250b(Context context, C4262hb c4262hb, byte[] bArr) {
        if (C4402x.m16322a(c4262hb)) {
            return;
        }
        String m16306a = C4402x.m16306a(c4262hb);
        if (TextUtils.isEmpty(m16306a) || m16247a(context, m16306a, bArr)) {
            return;
        }
        C4172dt.m14529a(context).m14537b(m16306a, C4402x.m16329b(c4262hb), c4262hb.m15264a().m15096a(), "1");
    }

    /* renamed from: c */
    private static boolean m16254c(C4262hb c4262hb) {
        if (c4262hb.m15264a() == null || c4262hb.m15264a().m15097a() == null) {
            return false;
        }
        return "1".equals(c4262hb.m15264a().m15097a().get("obslete_ads_message"));
    }

    /* renamed from: d */
    private static void m16255d(final XMPushService xMPushService, final C4262hb c4262hb) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                try {
                    C4262hb m16234a = C4399u.m16234a((Context) xMPushService, c4262hb);
                    m16234a.m15264a().m15099a("miui_message_unrecognized", "1");
                    C4401w.m16281a(xMPushService, m16234a);
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    public void m16256a(Context context, C4361am.b bVar, boolean z, int i2, String str) {
        C4393p m16204a;
        if (z || (m16204a = C4394q.m16204a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        C4394q.m16205a(context, m16204a.f16759f, m16204a.f16757d, m16204a.f16758e);
    }

    /* renamed from: c */
    private static void m16253c(final XMPushService xMPushService, final C4262hb c4262hb) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                try {
                    C4262hb m16234a = C4399u.m16234a((Context) xMPushService, c4262hb);
                    m16234a.m15264a().m15099a("message_obsleted", "1");
                    C4401w.m16281a(xMPushService, m16234a);
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    public void m16258a(XMPushService xMPushService, AbstractC4221fo abstractC4221fo, C4361am.b bVar) {
        if (abstractC4221fo instanceof C4220fn) {
            C4220fn c4220fn = (C4220fn) abstractC4221fo;
            C4218fl m14856a = c4220fn.m14856a(C3351bh.f11580aE);
            if (m14856a != null) {
                try {
                    m16243a(xMPushService, C4366ar.m15995a(C4366ar.m15994a(bVar.f16564h, c4220fn.m14864j()), m14856a.m14825c()), C4232fz.m14909a(abstractC4221fo.mo14829a()));
                    return;
                } catch (IllegalArgumentException e2) {
                    AbstractC4022b.m13351a(e2);
                    return;
                }
            }
            return;
        }
        AbstractC4022b.m13347a("not a mipush message");
    }

    /* renamed from: b */
    private static boolean m16252b(C4262hb c4262hb) {
        Map<String, String> m15097a = c4262hb.m15264a().m15097a();
        return m15097a != null && m15097a.containsKey("notify_effect");
    }

    /* renamed from: b */
    private static void m16251b(final XMPushService xMPushService, final C4262hb c4262hb) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                Map<String, String> map = null;
                try {
                    if (C4300j.m15681a((Context) xMPushService)) {
                        try {
                            map = C4400v.m16259a((Context) xMPushService, c4262hb);
                        } catch (Throwable th) {
                            AbstractC4022b.m13361d("error creating params for ack message :" + th);
                        }
                    }
                    C4401w.m16281a(xMPushService, C4399u.m16235a(xMPushService, c4262hb, map));
                } catch (C4215fi e2) {
                    AbstractC4022b.m13361d("error sending ack message :" + e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    public void m16257a(XMPushService xMPushService, C4197er c4197er, C4361am.b bVar) {
        try {
            byte[] m14697a = c4197er.m14697a(bVar.f16564h);
            HashMap hashMap = null;
            if (AbstractC4382e.m16078b(c4197er)) {
                hashMap = new HashMap();
                hashMap.put("t_im", String.valueOf(c4197er.m14699b()));
                hashMap.put("t_rt", String.valueOf(c4197er.m14684a()));
            }
            m16244a(xMPushService, m14697a, c4197er.mo14704c(), hashMap);
        } catch (IllegalArgumentException e2) {
            AbstractC4022b.m13351a(e2);
        }
    }

    /* renamed from: a */
    private static void m16243a(XMPushService xMPushService, byte[] bArr, long j2) {
        m16244a(xMPushService, bArr, j2, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m16244a(com.xiaomi.push.service.XMPushService r19, byte[] r20, long r21, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4399u.m16244a(com.xiaomi.push.service.XMPushService, byte[], long, java.util.Map):void");
    }

    /* renamed from: a */
    public static Intent m16233a(byte[] bArr, long j2) {
        C4262hb m16236a = m16236a(bArr);
        if (m16236a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j2));
        intent.setPackage(m16236a.f16005b);
        return intent;
    }

    /* renamed from: a */
    public static C4262hb m16236a(byte[] bArr) {
        C4262hb c4262hb = new C4262hb();
        try {
            C4276hp.m15566a(c4262hb, bArr);
            return c4262hb;
        } catch (Throwable th) {
            AbstractC4022b.m13351a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x043e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m16242a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 1241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4399u.m16242a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    /* renamed from: a */
    public static void m16237a(Context context, C4262hb c4262hb, byte[] bArr) {
        try {
            C4402x.c m16304a = C4402x.m16304a(context, c4262hb, bArr);
            if (m16304a.f16813a > 0 && !TextUtils.isEmpty(m16304a.f16814a)) {
                C4232fz.m14917a(context, m16304a.f16814a, m16304a.f16813a, true, false, System.currentTimeMillis());
            }
            if (C4300j.m15681a(context) && C4400v.m16264a(context, c4262hb, m16304a.f16815a)) {
                C4400v.m16260a(context, c4262hb);
                AbstractC4022b.m13347a("consume this broadcast by tts");
            } else {
                m16250b(context, c4262hb, bArr);
            }
        } catch (Exception e2) {
            AbstractC4022b.m13347a("notify push msg error " + e2);
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m16247a(Context context, String str, byte[] bArr) {
        if (!C4233g.m14935a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            AbstractC4022b.m13347a("broadcast message arrived.");
            context.sendBroadcast(intent, C4401w.m16279a(str));
            return true;
        } catch (Exception e2) {
            AbstractC4022b.m13347a("meet error when broadcast message arrived. " + e2);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m16249a(XMPushService xMPushService, String str, C4262hb c4262hb, C4252gs c4252gs) {
        boolean z = true;
        if (c4252gs != null && c4252gs.m15097a() != null && c4252gs.m15097a().containsKey("__check_alive") && c4252gs.m15097a().containsKey("__awake")) {
            C4265he c4265he = new C4265he();
            c4265he.m15314b(c4262hb.m15271a());
            c4265he.m15322d(str);
            c4265he.m15318c(EnumC4249gp.AwakeSystemApp.f15769a);
            c4265he.m15301a(c4252gs.m15096a());
            c4265he.f16034a = new HashMap();
            boolean m14935a = C4233g.m14935a(xMPushService.getApplicationContext(), str);
            c4265he.f16034a.put("app_running", Boolean.toString(m14935a));
            if (!m14935a) {
                boolean parseBoolean = Boolean.parseBoolean(c4252gs.m15097a().get("__awake"));
                c4265he.f16034a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                C4401w.m16281a(xMPushService, C4401w.m16276a(c4262hb.m15279b(), c4262hb.m15271a(), c4265he, EnumC4239gf.Notification));
            } catch (C4215fi e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
        return z;
    }

    /* renamed from: a */
    private static void m16238a(final XMPushService xMPushService, final C4262hb c4262hb) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                try {
                    C4401w.m16281a(xMPushService, C4401w.m16275a(c4262hb.m15279b(), c4262hb.m15271a()));
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    private static boolean m16248a(C4262hb c4262hb) {
        return "com.xiaomi.xmsf".equals(c4262hb.f16005b) && c4262hb.m15264a() != null && c4262hb.m15264a().m15097a() != null && c4262hb.m15264a().m15097a().containsKey("miui_package_name");
    }

    /* renamed from: a */
    private static boolean m16246a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return false;
        }
    }

    /* renamed from: a */
    private static void m16240a(final XMPushService xMPushService, final C4262hb c4262hb, final String str) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                try {
                    C4262hb m16234a = C4399u.m16234a((Context) xMPushService, c4262hb);
                    m16234a.m15264a().m15099a("absent_target_package", str);
                    C4401w.m16281a(xMPushService, m16234a);
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m16241a(final XMPushService xMPushService, final C4262hb c4262hb, final String str, final String str2) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                try {
                    C4262hb m16234a = C4399u.m16234a((Context) xMPushService, c4262hb);
                    m16234a.f15999a.m15099a("error", str);
                    m16234a.f15999a.m15099a("reason", str2);
                    C4401w.m16281a(xMPushService, m16234a);
                } catch (C4215fi e2) {
                    AbstractC4022b.m13351a(e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m16239a(final XMPushService xMPushService, final C4262hb c4262hb, final C4265he c4265he) {
        xMPushService.m15797a(new XMPushService.AbstractC4337j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                try {
                    C4256gw c4256gw = new C4256gw();
                    c4256gw.m15192c(EnumC4249gp.CancelPushMessageACK.f15769a);
                    c4256gw.m15182a(c4265he.m15306a());
                    c4256gw.m15181a(c4265he.m15300a());
                    c4256gw.m15189b(c4265he.m15315b());
                    c4256gw.m15196e(c4265he.m15323d());
                    c4256gw.m15180a(0L);
                    c4256gw.m15194d("success clear push message.");
                    C4401w.m16281a(xMPushService, C4401w.m16286b(c4262hb.m15279b(), c4262hb.m15271a(), c4256gw, EnumC4239gf.Notification));
                } catch (C4215fi e2) {
                    AbstractC4022b.m13361d("clear push message. " + e2);
                    xMPushService.m15795a(10, e2);
                }
            }
        });
    }

    /* renamed from: a */
    public static C4262hb m16234a(Context context, C4262hb c4262hb) {
        return m16235a(context, c4262hb, (Map<String, String>) null);
    }

    /* renamed from: a */
    public static C4262hb m16235a(Context context, C4262hb c4262hb, Map<String, String> map) {
        C4255gv c4255gv = new C4255gv();
        c4255gv.m15153b(c4262hb.m15271a());
        C4252gs m15264a = c4262hb.m15264a();
        if (m15264a != null) {
            c4255gv.m15147a(m15264a.m15096a());
            c4255gv.m15146a(m15264a.m15091a());
            if (!TextUtils.isEmpty(m15264a.m15106b())) {
                c4255gv.m15156c(m15264a.m15106b());
            }
        }
        c4255gv.m15148a(C4276hp.m15563a(context, c4262hb));
        C4262hb m16276a = C4401w.m16276a(c4262hb.m15279b(), c4262hb.m15271a(), c4255gv, EnumC4239gf.AckMessage);
        C4252gs m15264a2 = c4262hb.m15264a();
        if (m15264a2 != null) {
            m15264a2 = C4369au.m16011a(m15264a2.m15092a());
            Map<String, String> m15097a = m15264a2.m15097a();
            String str = m15097a != null ? m15097a.get("channel_id") : null;
            m15264a2.m15099a("mat", Long.toString(System.currentTimeMillis()));
            m15264a2.m15099a("cs", String.valueOf(C4383f.m16080a(context, c4262hb.f16005b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        m15264a2.m15099a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                AbstractC4022b.m13361d("error adding params to ack message :" + th);
            }
        }
        m16276a.m15266a(m15264a2);
        return m16276a;
    }

    /* renamed from: a */
    private static boolean m16245a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
