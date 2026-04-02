package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.umeng.analytics.pro.bh;
import com.xiaomi.push.cs;
import com.xiaomi.push.dt;
import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.fl;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fz;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ui.activity.BaseProgressUploadActivity;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    private static void b(Context context, hb hbVar, byte[] bArr) {
        if (x.m755a(hbVar)) {
            return;
        }
        String strA = x.a(hbVar);
        if (TextUtils.isEmpty(strA) || a(context, strA, bArr)) {
            return;
        }
        dt.a(context).b(strA, x.b(hbVar), hbVar.m527a().m493a(), "1");
    }

    private static boolean c(hb hbVar) {
        if (hbVar.m527a() == null || hbVar.m527a().m494a() == null) {
            return false;
        }
        return "1".equals(hbVar.m527a().m494a().get("obslete_ads_message"));
    }

    private static void d(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m527a().a("miui_message_unrecognized", "1");
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(Context context, am.b bVar, boolean z, int i2, String str) {
        p pVarM739a;
        if (z || (pVarM739a = q.m739a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        q.a(context, pVarM739a.f9415f, pVarM739a.f9413d, pVarM739a.f9414e);
    }

    private static void c(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m527a().a("message_obsleted", "1");
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, fo foVar, am.b bVar) throws Throwable {
        if (foVar instanceof fn) {
            fn fnVar = (fn) foVar;
            fl flVarA = fnVar.a(bh.aE);
            if (flVarA != null) {
                try {
                    a(xMPushService, ar.a(ar.a(bVar.f9363h, fnVar.j()), flVarA.c()), fz.a(foVar.mo429a()));
                    return;
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    return;
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("not a mipush message");
    }

    private static boolean b(hb hbVar) {
        Map<String, String> mapM494a = hbVar.m527a().m494a();
        return mapM494a != null && mapM494a.containsKey("notify_effect");
    }

    private static void b(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                Map<String, String> mapA = null;
                try {
                    if (com.xiaomi.push.j.m625a((Context) xMPushService)) {
                        try {
                            mapA = v.a((Context) xMPushService, hbVar);
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.d("error creating params for ack message :" + th);
                        }
                    }
                    w.a(xMPushService, u.a(xMPushService, hbVar, mapA));
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("error sending ack message :" + e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, er erVar, am.b bVar) throws Throwable {
        try {
            byte[] bArrM393a = erVar.m393a(bVar.f9363h);
            HashMap map = null;
            if (e.b(erVar)) {
                map = new HashMap();
                map.put("t_im", String.valueOf(erVar.m394b()));
                map.put("t_rt", String.valueOf(erVar.m387a()));
            }
            a(xMPushService, bArrM393a, erVar.c(), map);
        } catch (IllegalArgumentException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j2) throws Throwable {
        a(xMPushService, bArr, j2, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(XMPushService xMPushService, byte[] bArr, long j2, Map<String, String> map) throws Throwable {
        byte[] bArr2;
        String str;
        Map<String, String> mapM494a;
        Map<String, String> mapM494a2;
        byte[] bArrA;
        hb hbVarA = a(bArr);
        if (hbVarA == null) {
            return;
        }
        if (TextUtils.isEmpty(hbVarA.f724b)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("receive a mipush message without package name");
            return;
        }
        gs gsVarM527a = hbVarA.m527a();
        if (gsVarM527a == null || map == null || map.isEmpty() || (mapM494a2 = gsVarM527a.m494a()) == null || mapM494a2.isEmpty()) {
            bArr2 = bArr;
        } else {
            boolean z = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (mapM494a2.containsKey(entry.getKey())) {
                    mapM494a2.put(entry.getKey(), entry.getValue());
                    z = true;
                }
            }
            if (z && (bArrA = hp.a(hbVarA)) != null && bArrA.length > 0) {
                bArr2 = bArrA;
            }
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        Intent intentA = a(bArr2, lValueOf.longValue());
        String strA = x.a(hbVarA);
        fz.a(xMPushService, strA, j2, true, true, System.currentTimeMillis());
        if (gsVarM527a != null && gsVarM527a.m493a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", hbVarA.m528a(), aj.a(gsVarM527a.m493a()), hbVarA.a()));
        }
        if (gsVarM527a != null) {
            gsVarM527a.a("mrt", Long.toString(lValueOf.longValue()));
        }
        String strM493a = "";
        if (gf.SendMessage == hbVarA.a() && r.a(xMPushService).m743a(hbVarA.f724b) && !x.m755a(hbVarA)) {
            if (gsVarM527a != null) {
                strM493a = gsVarM527a.m493a();
                if (x.e(hbVarA)) {
                    dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), strM493a, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("Drop a message for unregistered, msgid=" + strM493a);
            a(xMPushService, hbVarA, hbVarA.f724b);
            return;
        }
        if (gf.SendMessage == hbVarA.a() && r.a(xMPushService).m745c(hbVarA.f724b) && !x.m755a(hbVarA)) {
            if (gsVarM527a != null) {
                strM493a = gsVarM527a.m493a();
                if (x.e(hbVarA)) {
                    dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), strM493a, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("Drop a message for push closed, msgid=" + strM493a);
            a(xMPushService, hbVarA, hbVarA.f724b);
            return;
        }
        if (gf.SendMessage == hbVarA.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), hbVarA.f724b)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + hbVarA.f724b);
            a(xMPushService, hbVarA, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + hbVarA.f724b);
            if (gsVarM527a == null || !x.e(hbVarA)) {
                return;
            }
            dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "3");
            return;
        }
        if (gf.SendMessage == hbVarA.a() && com.xiaomi.push.i.a() == 999) {
            str = strA;
            if (com.xiaomi.push.i.m616a((Context) xMPushService, str)) {
                com.xiaomi.channel.commonutils.logger.b.m48a("Receive the uninstalled dual app message");
                try {
                    w.a(xMPushService, w.a(str, hbVarA.m528a()));
                    com.xiaomi.channel.commonutils.logger.b.m48a("uninstall " + str + " msg sent");
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e2.getMessage());
                    xMPushService.a(10, e2);
                }
                x.m752a((Context) xMPushService, str);
                return;
            }
        } else {
            str = strA;
        }
        if (gsVarM527a != null && (mapM494a = gsVarM527a.m494a()) != null && mapM494a.containsKey("hide") && b.a.u.a.f1908j.equalsIgnoreCase(mapM494a.get("hide"))) {
            b(xMPushService, hbVarA);
        } else {
            a(xMPushService, str, bArr2, intentA);
        }
    }

    public static Intent a(byte[] bArr, long j2) {
        hb hbVarA = a(bArr);
        if (hbVarA == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j2));
        intent.setPackage(hbVarA.f724b);
        return intent;
    }

    public static hb a(byte[] bArr) {
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            return hbVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x044b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) throws Throwable {
        boolean z;
        hb hbVarA = a(bArr);
        gs gsVarM527a = hbVarA.m527a();
        hq hqVarA = null;
        String strM493a = null;
        if (bArr != null) {
            cs.a(hbVarA.b(), xMPushService.getApplicationContext(), null, hbVarA.a(), bArr.length);
        }
        if (c(hbVarA) && a(xMPushService, str)) {
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "5");
            }
            c(xMPushService, hbVarA);
            return;
        }
        if (a(hbVarA) && !a(xMPushService, str) && !b(hbVarA)) {
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "6");
            }
            d(xMPushService, hbVarA);
            return;
        }
        if ((x.m755a(hbVarA) && com.xiaomi.push.g.c(xMPushService, hbVarA.f724b)) || a(xMPushService, intent)) {
            boolean zA = false;
            if (gf.Registration == hbVarA.a()) {
                String strB = hbVarA.b();
                SharedPreferences.Editor editorEdit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                editorEdit.putString(strB, hbVarA.f720a);
                editorEdit.commit();
                hg hgVarA = l.a(hbVarA);
                if (hgVarA.a() == 0 && !TextUtils.isEmpty(hgVarA.b())) {
                    l.a(xMPushService, strB, hgVarA.b());
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("read regSecret failed");
                }
                r.a(xMPushService).e(strB);
                r.a(xMPushService).f(strB);
                dt.a(xMPushService.getApplicationContext()).a(strB, "E100003", gsVarM527a.m493a(), AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, null);
                if (!TextUtils.isEmpty(gsVarM527a.m493a())) {
                    intent.putExtra("messageId", gsVarM527a.m493a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (x.c(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(gsVarM527a.m493a())) {
                    intent.putExtra("messageId", gsVarM527a.m493a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (x.m759b(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(gsVarM527a.m493a())) {
                    intent.putExtra("messageId", gsVarM527a.m493a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (x.m755a(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(gsVarM527a.m493a())) {
                    intent.putExtra("messageId", gsVarM527a.m493a());
                    intent.putExtra("eventMessageType", PathInterpolatorCompat.MAX_NUM_POINTS);
                }
            }
            if (gsVarM527a != null && !TextUtils.isEmpty(gsVarM527a.m501c()) && !TextUtils.isEmpty(gsVarM527a.d()) && gsVarM527a.f634b != 1 && !x.m754a((Context) xMPushService, hbVarA.f724b, x.m756a(gsVarM527a.m494a()))) {
                if (gsVarM527a != null) {
                    Map<String, String> map = gsVarM527a.f632a;
                    strM493a = map != null ? map.get("jobkey") : null;
                    if (TextUtils.isEmpty(strM493a)) {
                        strM493a = gsVarM527a.m493a();
                    }
                    zA = y.a(xMPushService, hbVarA.f724b, strM493a);
                }
                if (zA) {
                    dt.a(xMPushService.getApplicationContext()).c(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "1:" + strM493a);
                    com.xiaomi.channel.commonutils.logger.b.m48a("drop a duplicate message, key=" + strM493a);
                } else if (com.xiaomi.push.j.m625a((Context) xMPushService) && v.m747a(hbVarA)) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("receive pull down message");
                } else {
                    a(xMPushService, hbVarA, bArr);
                }
                b(xMPushService, hbVarA);
            } else if ("com.xiaomi.xmsf".contains(hbVarA.f724b) && !hbVarA.m535b() && gsVarM527a != null && gsVarM527a.m494a() != null && gsVarM527a.m494a().containsKey("ab")) {
                b(xMPushService, hbVarA);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + gsVarM527a.m493a());
            } else if (a(xMPushService, str, hbVarA, gsVarM527a)) {
                if (gsVarM527a != null && !TextUtils.isEmpty(gsVarM527a.m493a())) {
                    if (x.m759b(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2, null);
                    } else if (x.m755a(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "7");
                    } else if (x.c(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "8");
                    } else if (x.d(hbVarA)) {
                        dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), "E100003", gsVarM527a.m493a(), AuthCode.StatusCode.PERMISSION_NOT_EXIST, null);
                    }
                }
                if (gf.Notification == hbVarA.f717a) {
                    try {
                        hqVarA = bc.a(xMPushService, hbVarA);
                    } catch (hu e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e2);
                    }
                    if (hqVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + hbVarA.f717a);
                    } else {
                        z = true;
                        if (z || !(hqVarA instanceof he)) {
                            zA = true;
                            if (zA) {
                                com.xiaomi.channel.commonutils.logger.b.m48a("broadcast passthrough message.");
                                xMPushService.sendBroadcast(intent, w.a(hbVarA.f724b));
                            }
                        } else {
                            he heVar = (he) hqVarA;
                            if (gp.CancelPushMessage.f597a.equals(heVar.f741d) && heVar.m543a() != null) {
                                String str2 = heVar.m543a().get(an.Q);
                                int i2 = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        i2 = Integer.parseInt(str2);
                                    } catch (NumberFormatException e3) {
                                        com.xiaomi.channel.commonutils.logger.b.m48a("parse notifyId from STRING to INT failed: " + e3);
                                    }
                                }
                                if (i2 >= -1) {
                                    com.xiaomi.channel.commonutils.logger.b.m48a("try to retract a message by notifyId=" + i2);
                                    x.a(xMPushService, hbVarA.f724b, i2);
                                } else {
                                    String str3 = heVar.m543a().get(an.O);
                                    String str4 = heVar.m543a().get(an.P);
                                    com.xiaomi.channel.commonutils.logger.b.m48a("try to retract a message by title&description.");
                                    x.a(xMPushService, hbVarA.f724b, str3, str4);
                                }
                                if (gsVarM527a != null && gsVarM527a.m494a() != null && com.xiaomi.push.j.m625a((Context) xMPushService) && "pulldown".equals(ag.a((Object) gsVarM527a.m494a()))) {
                                    v.a(hbVarA);
                                }
                                a(xMPushService, hbVarA, heVar);
                            } else if (gp.SettingAppNotificationPermission.f597a.equals(heVar.c())) {
                                if (com.xiaomi.push.j.m625a((Context) xMPushService)) {
                                    v.a(xMPushService, hbVarA, heVar);
                                }
                            }
                            if (zA) {
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        zA = true;
                        if (zA) {
                        }
                    }
                }
            } else {
                dt.a(xMPushService.getApplicationContext()).a(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "9");
            }
            if (hbVarA.a() != gf.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
            return;
        }
        if (!com.xiaomi.push.g.c(xMPushService, hbVarA.f724b)) {
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).b(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "2");
            }
            a(xMPushService, hbVarA);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m48a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (x.e(hbVarA)) {
                dt.a(xMPushService.getApplicationContext()).b(hbVarA.b(), x.b(hbVarA), gsVarM527a.m493a(), "3");
            }
        }
    }

    public static void a(Context context, hb hbVar, byte[] bArr) throws Throwable {
        try {
            x.c cVarM751a = x.m751a(context, hbVar, bArr);
            if (cVarM751a.a > 0 && !TextUtils.isEmpty(cVarM751a.f1095a)) {
                fz.a(context, cVarM751a.f1095a, cVarM751a.a, true, false, System.currentTimeMillis());
            }
            if (com.xiaomi.push.j.m625a(context) && v.a(context, hbVar, cVarM751a.f1096a)) {
                v.m746a(context, hbVar);
                com.xiaomi.channel.commonutils.logger.b.m48a("consume this broadcast by tts");
            } else {
                b(context, hbVar, bArr);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("notify push msg error " + e2);
            e2.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!com.xiaomi.push.g.m452a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("broadcast message arrived.");
            context.sendBroadcast(intent, w.a(str));
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("meet error when broadcast message arrived. " + e2);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, String str, hb hbVar, gs gsVar) {
        boolean z = true;
        if (gsVar != null && gsVar.m494a() != null && gsVar.m494a().containsKey("__check_alive") && gsVar.m494a().containsKey("__awake")) {
            he heVar = new he();
            heVar.b(hbVar.m528a());
            heVar.d(str);
            heVar.c(gp.AwakeSystemApp.f597a);
            heVar.a(gsVar.m493a());
            heVar.f736a = new HashMap();
            boolean zM452a = com.xiaomi.push.g.m452a(xMPushService.getApplicationContext(), str);
            heVar.f736a.put("app_running", Boolean.toString(zM452a));
            if (!zM452a) {
                boolean z2 = Boolean.parseBoolean(gsVar.m494a().get("__awake"));
                heVar.f736a.put("awaked", Boolean.toString(z2));
                if (!z2) {
                    z = false;
                }
            }
            try {
                w.a(xMPushService, w.a(hbVar.b(), hbVar.m528a(), heVar, gf.Notification));
            } catch (fi e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        return z;
    }

    private static void a(final XMPushService xMPushService, final hb hbVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                try {
                    w.a(xMPushService, w.a(hbVar.b(), hbVar.m528a()));
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static boolean a(hb hbVar) {
        return "com.xiaomi.xmsf".equals(hbVar.f724b) && hbVar.m527a() != null && hbVar.m527a().m494a() != null && hbVar.m527a().m494a().containsKey("miui_package_name");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (listQueryBroadcastReceivers.isEmpty()) {
                if (listQueryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final String str) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.m527a().a("absent_target_package", str);
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final String str, final String str2) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                try {
                    hb hbVarA = u.a((Context) xMPushService, hbVar);
                    hbVarA.f718a.a("error", str);
                    hbVarA.f718a.a("reason", str2);
                    w.a(xMPushService, hbVarA);
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hb hbVar, final he heVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo377a() {
                try {
                    gw gwVar = new gw();
                    gwVar.c(gp.CancelPushMessageACK.f597a);
                    gwVar.a(heVar.m542a());
                    gwVar.a(heVar.a());
                    gwVar.b(heVar.b());
                    gwVar.e(heVar.d());
                    gwVar.a(0L);
                    gwVar.d("success clear push message.");
                    w.a(xMPushService, w.b(hbVar.b(), hbVar.m528a(), gwVar, gf.Notification));
                } catch (fi e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public static hb a(Context context, hb hbVar) {
        return a(context, hbVar, (Map<String, String>) null);
    }

    public static hb a(Context context, hb hbVar, Map<String, String> map) {
        gv gvVar = new gv();
        gvVar.b(hbVar.m528a());
        gs gsVarM527a = hbVar.m527a();
        if (gsVarM527a != null) {
            gvVar.a(gsVarM527a.m493a());
            gvVar.a(gsVarM527a.m491a());
            if (!TextUtils.isEmpty(gsVarM527a.m498b())) {
                gvVar.c(gsVarM527a.m498b());
            }
        }
        gvVar.a(hp.a(context, hbVar));
        hb hbVarA = w.a(hbVar.b(), hbVar.m528a(), gvVar, gf.AckMessage);
        gs gsVarM527a2 = hbVar.m527a();
        if (gsVarM527a2 != null) {
            gsVarM527a2 = au.a(gsVarM527a2.m492a());
            Map<String, String> mapM494a = gsVarM527a2.m494a();
            String str = mapM494a != null ? mapM494a.get("channel_id") : null;
            gsVarM527a2.a("mat", Long.toString(System.currentTimeMillis()));
            gsVarM527a2.a("cs", String.valueOf(f.a(context, hbVar.f724b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        gsVarM527a2.a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("error adding params to ack message :" + th);
            }
        }
        hbVarA.a(gsVarM527a2);
        return hbVarA;
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (listQueryBroadcastReceivers != null) {
                if (!listQueryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
