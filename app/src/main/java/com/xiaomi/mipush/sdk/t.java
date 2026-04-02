package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bb;
import com.xiaomi.push.bn;
import com.xiaomi.push.cs;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.ed;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private static t a;

    /* JADX INFO: renamed from: a */
    private static Object f130a = new Object();

    /* JADX INFO: renamed from: a */
    private static Queue<String> f131a;

    /* JADX INFO: renamed from: a */
    private Context f132a;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.t$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[gf.values().length];

        static {
            try {
                a[gf.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[gf.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[gf.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[gf.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[gf.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[gf.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[gf.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private t(Context context) {
        this.f132a = context.getApplicationContext();
        if (this.f132a == null) {
            this.f132a = context;
        }
    }

    public static t a(Context context) {
        if (a == null) {
            a = new t(context);
        }
        return a;
    }

    private void b(gw gwVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + gwVar.toString());
        String strA = gwVar.a();
        Map<String, String> mapM508a = gwVar.m508a();
        if (mapM508a != null) {
            String str = mapM508a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + q.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : receive fcm token sync ack");
                f.b(this.f132a, d.ASSEMBLE_PUSH_FCM, str);
                a(strA, gwVar.f675a, d.ASSEMBLE_PUSH_FCM);
                return;
            }
            if (!str.contains("brand:" + q.HUAWEI.name())) {
                if (!str.contains("channel:" + q.HUAWEI.name())) {
                    if (!str.contains("brand:" + q.OPPO.name())) {
                        if (!str.contains("channel:" + q.OPPO.name())) {
                            if (!str.contains("brand:" + q.VIVO.name())) {
                                if (!str.contains("channel:" + q.VIVO.name())) {
                                    return;
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            f.b(this.f132a, d.ASSEMBLE_PUSH_FTOS, str);
                            a(strA, gwVar.f675a, d.ASSEMBLE_PUSH_FTOS);
                            return;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : receive COS token sync ack");
                    f.b(this.f132a, d.ASSEMBLE_PUSH_COS, str);
                    a(strA, gwVar.f675a, d.ASSEMBLE_PUSH_COS);
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : receive hw token sync ack");
            f.b(this.f132a, d.ASSEMBLE_PUSH_HUAWEI, str);
            a(strA, gwVar.f675a, d.ASSEMBLE_PUSH_HUAWEI);
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m48a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                dt.a(this.f132a).a(this.f132a.getPackageName(), intent, "12");
                return null;
            }
            hb hbVar = new hb();
            try {
                hp.a(hbVar, byteArrayExtra);
                b bVarM73a = b.m73a(this.f132a);
                gs gsVarM527a = hbVar.m527a();
                if (hbVar.a() == gf.SendMessage && gsVarM527a != null && !bVarM73a.m84e() && !booleanExtra) {
                    gsVarM527a.a("mrt", stringExtra);
                    gsVarM527a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m105a(hbVar)) {
                        b(hbVar);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        gsVarM527a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(gsVarM527a.m491a()));
                        gsVarM527a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) hp.a(this.f132a, hbVar)));
                    }
                }
                if (hbVar.a() == gf.SendMessage && !hbVar.m535b()) {
                    if (x.m755a(hbVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hbVar.b();
                        objArr[1] = gsVarM527a != null ? gsVarM527a.m493a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m48a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        dt.a(this.f132a).a(this.f132a.getPackageName(), intent, String.format("13: %1$s", hbVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hbVar.b();
                        objArr2[1] = gsVarM527a != null ? gsVarM527a.m493a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m48a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        dt.a(this.f132a).a(this.f132a.getPackageName(), intent, String.format("14: %1$s", hbVar.b()));
                    }
                    j.a(this.f132a, hbVar, booleanExtra);
                    return null;
                }
                if (hbVar.a() == gf.SendMessage && hbVar.m535b() && x.m755a(hbVar) && (!booleanExtra || gsVarM527a == null || gsVarM527a.m494a() == null || !gsVarM527a.m494a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hbVar.b();
                    objArr3[1] = gsVarM527a != null ? gsVarM527a.m493a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m48a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    dt.a(this.f132a).a(this.f132a.getPackageName(), intent, String.format("25: %1$s", hbVar.b()));
                    j.b(this.f132a, hbVar, booleanExtra);
                    return null;
                }
                if (!bVarM73a.m82c() && hbVar.f717a != gf.Registration) {
                    if (x.m755a(hbVar)) {
                        return a(hbVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    j.e(this.f132a, hbVar, booleanExtra);
                    boolean zM83d = bVarM73a.m83d();
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + zM83d);
                    dt.a(this.f132a).a(this.f132a.getPackageName(), intent, "15");
                    if (zM83d) {
                        a();
                    }
                } else if (bVarM73a.m82c() && bVarM73a.m85f()) {
                    if (hbVar.f717a == gf.UnRegistration) {
                        if (hbVar.m535b()) {
                            bVarM73a.m75a();
                            MiPushClient.clearExtras(this.f132a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else {
                        j.e(this.f132a, hbVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f132a);
                    }
                } else {
                    return a(hbVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                }
            } catch (hu e2) {
                dt.a(this.f132a).a(this.f132a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            } catch (Exception e3) {
                dt.a(this.f132a).a(this.f132a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
                com.xiaomi.channel.commonutils.logger.b.a(e3);
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                hb hbVar2 = new hb();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        hp.a(hbVar2, byteArrayExtra2);
                    }
                } catch (hu unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(hbVar2.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                    return null;
                }
                hb hbVar3 = new hb();
                try {
                    hp.a(hbVar3, byteArrayExtra3);
                    b bVarM73a2 = b.m73a(this.f132a);
                    if (x.m755a(hbVar3)) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                    } else if (!bVarM73a2.m82c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                    } else if (bVarM73a2.m82c() && bVarM73a2.m85f()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                    } else {
                        return a(hbVar3, byteArrayExtra3);
                    }
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e4);
                }
            }
        }
        return null;
    }

    private void b(hb hbVar) {
        gs gsVarM527a = hbVar.m527a();
        if (gsVarM527a != null) {
            gsVarM527a = au.a(gsVarM527a.m492a());
        }
        gv gvVar = new gv();
        gvVar.b(hbVar.m528a());
        gvVar.a(gsVarM527a.m493a());
        gvVar.a(gsVarM527a.m491a());
        if (!TextUtils.isEmpty(gsVarM527a.m498b())) {
            gvVar.c(gsVarM527a.m498b());
        }
        gvVar.a(hp.a(this.f132a, hbVar));
        u.a(this.f132a).a(gvVar, gf.AckMessage, false, gsVarM527a);
    }

    private void b(he heVar) {
        Map<String, String> mapM543a = heVar.m543a();
        if (mapM543a == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("detect failed because null");
            return;
        }
        String str = (String) ag.a(mapM543a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("detect failed because empty");
            return;
        }
        Map<String, String> mapM450a = com.xiaomi.push.g.m450a(this.f132a, str);
        if (mapM450a != null) {
            String str2 = mapM450a.get("alive");
            String str3 = mapM450a.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                he heVar2 = new he();
                heVar2.a(heVar.m542a());
                heVar2.b(heVar.b());
                heVar2.d(heVar.d());
                heVar2.c(gp.DetectAppAliveResult.f597a);
                heVar2.f736a = new HashMap();
                heVar2.f736a.put("alive", str2);
                if (Boolean.parseBoolean((String) ag.a(mapM543a, "reportNotAliveApp", b.a.u.a.f1909k)) && !TextUtils.isEmpty(str3)) {
                    heVar2.f736a.put("notAlive", str3);
                }
                u.a(this.f132a).a(heVar2, gf.Notification, false, (gs) null);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("detect failed because get status illegal");
    }

    private PushMessageHandler.a a(hb hbVar, byte[] bArr) {
        String str = null;
        try {
            hq hqVarA = r.a(this.f132a, hbVar);
            if (hqVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + hbVar.f717a);
                return null;
            }
            gf gfVarA = hbVar.a();
            com.xiaomi.channel.commonutils.logger.b.m48a("message arrived: processing an arrived message, action=" + gfVarA);
            if (AnonymousClass1.a[gfVarA.ordinal()] != 1) {
                return null;
            }
            if (!hbVar.m535b()) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            hi hiVar = (hi) hqVarA;
            gr grVarA = hiVar.a();
            if (grVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            gs gsVar = hbVar.f718a;
            if (gsVar != null && gsVar.m494a() != null) {
                str = hbVar.f718a.f632a.get("jobkey");
            }
            MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage(hiVar, hbVar.m527a(), false);
            miPushMessageGenerateMessage.setArrivedMessage(true);
            com.xiaomi.channel.commonutils.logger.b.m48a("message arrived: receive a message, msgid=" + grVarA.m485a() + ", jobkey=" + str);
            return miPushMessageGenerateMessage;
        } catch (l e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (hu e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PushMessageHandler.a a(hb hbVar, boolean z, byte[] bArr, String str, int i2, Intent intent) throws Throwable {
        gs gsVar;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            hq hqVarA = r.a(this.f132a, hbVar);
            if (hqVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + hbVar.f717a);
                dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, "18");
                j.c(this.f132a, hbVar, z);
                return null;
            }
            gf gfVarA = hbVar.a();
            com.xiaomi.channel.commonutils.logger.b.m50a("processing a message, action=", gfVarA, ", hasNotified=", Boolean.valueOf(z));
            switch (AnonymousClass1.a[gfVarA.ordinal()]) {
                case 1:
                    if (!hbVar.m535b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (b.m73a(this.f132a).m84e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m48a("receive a message in pause state. drop it");
                        dt.a(this.f132a).a(this.f132a.getPackageName(), ds.m355a(i2), str, "12");
                        return null;
                    }
                    hi hiVar = (hi) hqVarA;
                    gr grVarA = hiVar.a();
                    if (grVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, "22");
                        j.d(this.f132a, hbVar, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (x.m755a(hbVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f132a, grVarA.m485a(), hbVar.m527a(), hbVar.f724b, grVarA.b());
                        } else {
                            if (hbVar.m527a() != null) {
                                gsVar = new gs(hbVar.m527a());
                            } else {
                                gsVar = new gs();
                            }
                            if (gsVar.m494a() == null) {
                                gsVar.a(new HashMap());
                            }
                            gsVar.m494a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.reportMessageClicked(this.f132a, grVarA.m485a(), gsVar, grVarA.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(hiVar.d()) && MiPushClient.aliasSetTime(this.f132a, hiVar.d()) < 0) {
                            MiPushClient.addAlias(this.f132a, hiVar.d());
                        } else if (!TextUtils.isEmpty(hiVar.c()) && MiPushClient.topicSubscribedTime(this.f132a, hiVar.c()) < 0) {
                            MiPushClient.addTopic(this.f132a, hiVar.c());
                        }
                    }
                    gs gsVar2 = hbVar.f718a;
                    String strM485a = (gsVar2 == null || gsVar2.m494a() == null) ? null : hbVar.f718a.f632a.get("jobkey");
                    String str2 = strM485a;
                    if (TextUtils.isEmpty(strM485a)) {
                        strM485a = grVarA.m485a();
                    }
                    if (!z && m104a(this.f132a, strM485a)) {
                        com.xiaomi.channel.commonutils.logger.b.m48a("drop a duplicate message, key=" + strM485a);
                        dt.a(this.f132a).c(this.f132a.getPackageName(), ds.m355a(i2), str, "2:" + strM485a);
                    } else {
                        MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage(hiVar, hbVar.m527a(), z);
                        if (miPushMessageGenerateMessage.getPassThrough() == 0 && !z && x.m756a(miPushMessageGenerateMessage.getExtra())) {
                            x.m751a(this.f132a, hbVar, bArr);
                            return null;
                        }
                        String strA = x.a(miPushMessageGenerateMessage.getExtra(), intExtra);
                        com.xiaomi.channel.commonutils.logger.b.m50a("receive a message, msgid=", grVarA.m485a(), ", jobkey=", strM485a, ", btn=", Integer.valueOf(intExtra), ", typeId=", strA, ", hasNotified=", Boolean.valueOf(z));
                        if (z && miPushMessageGenerateMessage.getExtra() != null && !TextUtils.isEmpty(strA)) {
                            Map<String, String> extra = miPushMessageGenerateMessage.getExtra();
                            if (intExtra != 0 && hbVar.m527a() != null) {
                                u.a(this.f132a).a(hbVar.m527a().c(), intExtra);
                            }
                            if (x.m755a(hbVar)) {
                                Intent intentA = a(this.f132a, hbVar.f724b, extra, intExtra);
                                intentA.putExtra("eventMessageType", i2);
                                intentA.putExtra("messageId", str);
                                intentA.putExtra("jobkey", str2);
                                if (intentA == null) {
                                    com.xiaomi.channel.commonutils.logger.b.m48a("Getting Intent fail from ignore reg message. ");
                                    dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, "23");
                                    return null;
                                }
                                String strC = grVarA.c();
                                if (!TextUtils.isEmpty(strC)) {
                                    intentA.putExtra("payload", strC);
                                }
                                this.f132a.startActivity(intentA);
                                j.a(this.f132a, hbVar);
                                dt.a(this.f132a).a(this.f132a.getPackageName(), ds.m355a(i2), str, 3006, strA);
                                com.xiaomi.channel.commonutils.logger.b.m49a("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f132a;
                                Intent intentA2 = a(context, context.getPackageName(), extra, intExtra);
                                if (intentA2 != null) {
                                    if (!strA.equals(an.f9371c)) {
                                        intentA2.putExtra(PushMessageHelper.KEY_MESSAGE, miPushMessageGenerateMessage);
                                        intentA2.putExtra("eventMessageType", i2);
                                        intentA2.putExtra("messageId", str);
                                        intentA2.putExtra("jobkey", str2);
                                    }
                                    this.f132a.startActivity(intentA2);
                                    j.a(this.f132a, hbVar);
                                    com.xiaomi.channel.commonutils.logger.b.m49a("PushMessageProcessor", "start activity succ");
                                    dt.a(this.f132a).a(this.f132a.getPackageName(), ds.m355a(i2), str, 1006, strA);
                                    if (strA.equals(an.f9371c)) {
                                        dt.a(this.f132a).a(this.f132a.getPackageName(), ds.m355a(i2), str, "13");
                                    }
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.d("PushMessageProcessor", "missing target intent for message: " + grVarA.m485a() + ", typeId=" + strA);
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m49a("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = miPushMessageGenerateMessage;
                    }
                    if (hbVar.m527a() == null && !z) {
                        a(hiVar, hbVar);
                    }
                    return miPushMessage;
                case 2:
                    hg hgVar = (hg) hqVarA;
                    String str3 = b.m73a(this.f132a).f108a;
                    if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, hgVar.m557a())) {
                        long jM114a = u.a(this.f132a).m114a();
                        if (jM114a > 0 && SystemClock.elapsedRealtime() - jM114a > com.heytap.mcssdk.constant.a.f3872h) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("The received registration result has expired.");
                            dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_VIDEO);
                            return null;
                        }
                        b.m73a(this.f132a).f108a = null;
                        if (hgVar.f780a == 0) {
                            b.m73a(this.f132a).b(hgVar.f792e, hgVar.f793f, hgVar.f799l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f132a);
                            dt.a(this.f132a).a(this.f132a.getPackageName(), ds.m355a(i2), str, AuthCode.StatusCode.PERMISSION_EXPIRED, "1");
                        } else {
                            dt.a(this.f132a).a(this.f132a.getPackageName(), ds.m355a(i2), str, AuthCode.StatusCode.PERMISSION_EXPIRED, "2");
                        }
                        if (!TextUtils.isEmpty(hgVar.f792e)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(hgVar.f792e);
                        }
                        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ed.COMMAND_REGISTER.f424a, arrayList3, hgVar.f780a, hgVar.f791d, null, hgVar.m558a());
                        u.a(this.f132a).m123d();
                        return miPushCommandMessageGenerateCommandMessage;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m48a("bad Registration result:");
                    dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, "21");
                    return null;
                case 3:
                    if (!hbVar.m535b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hm) hqVarA).f858a == 0) {
                        b.m73a(this.f132a).m75a();
                        MiPushClient.clearExtras(this.f132a);
                    }
                    PushMessageHandler.a();
                    return miPushMessage;
                case 4:
                    hk hkVar = (hk) hqVarA;
                    if (hkVar.f833a == 0) {
                        MiPushClient.addTopic(this.f132a, hkVar.b());
                    }
                    if (!TextUtils.isEmpty(hkVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(hkVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ed.COMMAND_SUBSCRIBE_TOPIC + ", " + hkVar.a());
                    return PushMessageHelper.generateCommandMessage(ed.COMMAND_SUBSCRIBE_TOPIC.f424a, arrayList2, hkVar.f833a, hkVar.f839d, hkVar.c(), null);
                case 5:
                    ho hoVar = (ho) hqVarA;
                    if (hoVar.f878a == 0) {
                        MiPushClient.removeTopic(this.f132a, hoVar.b());
                    }
                    if (!TextUtils.isEmpty(hoVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(hoVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ed.COMMAND_UNSUBSCRIBE_TOPIC + ", " + hoVar.a());
                    return PushMessageHelper.generateCommandMessage(ed.COMMAND_UNSUBSCRIBE_TOPIC.f424a, arrayList, hoVar.f878a, hoVar.f884d, hoVar.c(), null);
                case 6:
                    cs.a(this.f132a.getPackageName(), this.f132a, hqVarA, gf.Command, bArr.length);
                    ha haVar = (ha) hqVarA;
                    String strB = haVar.b();
                    List<String> listM521a = haVar.m521a();
                    if (haVar.f705a == 0) {
                        if (TextUtils.equals(strB, ed.COMMAND_SET_ACCEPT_TIME.f424a) && listM521a != null && listM521a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f132a, listM521a.get(0), listM521a.get(1));
                            if ("00:00".equals(listM521a.get(0)) && "00:00".equals(listM521a.get(1))) {
                                b.m73a(this.f132a).a(true);
                            } else {
                                b.m73a(this.f132a).a(false);
                            }
                            listM521a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), listM521a);
                        } else if (TextUtils.equals(strB, ed.COMMAND_SET_ALIAS.f424a) && listM521a != null && listM521a.size() > 0) {
                            MiPushClient.addAlias(this.f132a, listM521a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_UNSET_ALIAS.f424a) && listM521a != null && listM521a.size() > 0) {
                            MiPushClient.removeAlias(this.f132a, listM521a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_SET_ACCOUNT.f424a) && listM521a != null && listM521a.size() > 0) {
                            MiPushClient.addAccount(this.f132a, listM521a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_UNSET_ACCOUNT.f424a) && listM521a != null && listM521a.size() > 0) {
                            MiPushClient.removeAccount(this.f132a, listM521a.get(0));
                        } else if (TextUtils.equals(strB, ed.COMMAND_CHK_VDEVID.f424a)) {
                            return null;
                        }
                    }
                    List<String> list = listM521a;
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + strB + ", " + haVar.a());
                    return PushMessageHelper.generateCommandMessage(strB, list, haVar.f705a, haVar.f713d, haVar.c(), null);
                case 7:
                    cs.a(this.f132a.getPackageName(), this.f132a, hqVarA, gf.Notification, bArr.length);
                    if (hqVarA instanceof gw) {
                        gw gwVar = (gw) hqVarA;
                        String strA2 = gwVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + gwVar.b() + ", code:" + gwVar.f675a + ", " + strA2);
                        if (gp.DisablePushMessage.f597a.equalsIgnoreCase(gwVar.f682d)) {
                            if (gwVar.f675a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f132a).m103a(strA2)) {
                                        p.a(this.f132a).c(strA2);
                                        if ("syncing".equals(p.a(this.f132a).a(v.DISABLE_PUSH))) {
                                            p.a(this.f132a).a(v.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f132a);
                                            MiPushClient.clearLocalNotificationType(this.f132a);
                                            PushMessageHandler.a();
                                            u.a(this.f132a).m120b();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(p.a(this.f132a).a(v.DISABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f132a).m103a(strA2)) {
                                        if (p.a(this.f132a).a(strA2) < 10) {
                                            p.a(this.f132a).b(strA2);
                                            u.a(this.f132a).a(true, strA2);
                                        } else {
                                            p.a(this.f132a).c(strA2);
                                        }
                                    }
                                }
                            } else {
                                p.a(this.f132a).c(strA2);
                            }
                            break;
                        } else if (gp.EnablePushMessage.f597a.equalsIgnoreCase(gwVar.f682d)) {
                            if (gwVar.f675a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f132a).m103a(strA2)) {
                                        p.a(this.f132a).c(strA2);
                                        if ("syncing".equals(p.a(this.f132a).a(v.ENABLE_PUSH))) {
                                            p.a(this.f132a).a(v.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(p.a(this.f132a).a(v.ENABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f132a).m103a(strA2)) {
                                        if (p.a(this.f132a).a(strA2) < 10) {
                                            p.a(this.f132a).b(strA2);
                                            u.a(this.f132a).a(false, strA2);
                                        } else {
                                            p.a(this.f132a).c(strA2);
                                        }
                                    }
                                }
                            } else {
                                p.a(this.f132a).c(strA2);
                            }
                            break;
                        } else if (gp.ThirdPartyRegUpdate.f597a.equalsIgnoreCase(gwVar.f682d)) {
                            b(gwVar);
                        } else if (gp.UploadTinyData.f597a.equalsIgnoreCase(gwVar.f682d)) {
                            a(gwVar);
                        }
                    } else if (hqVarA instanceof he) {
                        he heVar = (he) hqVarA;
                        if ("registration id expired".equalsIgnoreCase(heVar.f741d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f132a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f132a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f132a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f132a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + heVar.f741d + ", " + heVar.m542a());
                            MiPushClient.reInitialize(this.f132a, gt.RegIdExpired);
                            for (String str4 : allAlias) {
                                MiPushClient.removeAlias(this.f132a, str4);
                                MiPushClient.setAlias(this.f132a, str4, null);
                            }
                            for (String str5 : allTopic) {
                                MiPushClient.removeTopic(this.f132a, str5);
                                MiPushClient.subscribe(this.f132a, str5, null);
                            }
                            for (String str6 : allUserAccount) {
                                MiPushClient.removeAccount(this.f132a, str6);
                                MiPushClient.setUserAccount(this.f132a, str6, null);
                            }
                            String[] strArrSplit = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (strArrSplit.length == 2) {
                                MiPushClient.removeAcceptTime(this.f132a);
                                MiPushClient.addAcceptTime(this.f132a, strArrSplit[0], strArrSplit[1]);
                            }
                        } else if (gp.ClientInfoUpdateOk.f597a.equalsIgnoreCase(heVar.f741d)) {
                            if (heVar.m543a() != null && heVar.m543a().containsKey("app_version")) {
                                b.m73a(this.f132a).m76a(heVar.m543a().get("app_version"));
                            }
                        } else {
                            try {
                                if (gp.NormalClientConfigUpdate.f597a.equalsIgnoreCase(heVar.f741d)) {
                                    hd hdVar = new hd();
                                    hp.a(hdVar, heVar.m548a());
                                    ai.a(ah.a(this.f132a), hdVar);
                                } else if (gp.CustomClientConfigUpdate.f597a.equalsIgnoreCase(heVar.f741d)) {
                                    hc hcVar = new hc();
                                    hp.a(hcVar, heVar.m548a());
                                    ai.a(ah.a(this.f132a), hcVar);
                                } else if (gp.SyncInfoResult.f597a.equalsIgnoreCase(heVar.f741d)) {
                                    w.a(this.f132a, heVar);
                                } else if (gp.ForceSync.f597a.equalsIgnoreCase(heVar.f741d)) {
                                    com.xiaomi.channel.commonutils.logger.b.m48a("receive force sync notification");
                                    w.a(this.f132a, false);
                                } else if (gp.CancelPushMessage.f597a.equals(heVar.f741d)) {
                                    com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + heVar.f741d + ", " + heVar.m542a());
                                    if (heVar.m543a() != null) {
                                        int i3 = -2;
                                        if (heVar.m543a().containsKey(an.Q)) {
                                            String str7 = heVar.m543a().get(an.Q);
                                            if (!TextUtils.isEmpty(str7)) {
                                                try {
                                                    i3 = Integer.parseInt(str7);
                                                } catch (NumberFormatException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i3 >= -1) {
                                            MiPushClient.clearNotification(this.f132a, i3);
                                        } else {
                                            MiPushClient.clearNotification(this.f132a, heVar.m543a().containsKey(an.O) ? heVar.m543a().get(an.O) : "", heVar.m543a().containsKey(an.P) ? heVar.m543a().get(an.P) : "");
                                        }
                                    }
                                    a(heVar);
                                    break;
                                } else if (gp.HybridRegisterResult.f597a.equals(heVar.f741d)) {
                                    try {
                                        hg hgVar2 = new hg();
                                        hp.a(hgVar2, heVar.m548a());
                                        MiPushClient4Hybrid.onReceiveRegisterResult(this.f132a, hgVar2);
                                    } catch (hu e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    }
                                    break;
                                } else if (gp.HybridUnregisterResult.f597a.equals(heVar.f741d)) {
                                    try {
                                        hm hmVar = new hm();
                                        hp.a(hmVar, heVar.m548a());
                                        MiPushClient4Hybrid.onReceiveUnregisterResult(this.f132a, hmVar);
                                    } catch (hu e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                    break;
                                } else if (!gp.PushLogUpload.f597a.equals(heVar.f741d)) {
                                    if (gp.DetectAppAlive.f597a.equals(heVar.f741d)) {
                                        com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                        b(heVar);
                                    } else if (com.xiaomi.push.service.g.a(heVar)) {
                                        com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                    }
                                }
                                break;
                            } catch (hu unused) {
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (l e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            a(hbVar);
            dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
            j.c(this.f132a, hbVar, z);
            return null;
        } catch (hu e6) {
            com.xiaomi.channel.commonutils.logger.b.a(e6);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            dt.a(this.f132a).b(this.f132a.getPackageName(), ds.m355a(i2), str, "20");
            j.c(this.f132a, hbVar, z);
            return null;
        }
    }

    private void a(String str, long j2, d dVar) {
        v vVarM99a = g.m99a(dVar);
        if (vVarM99a == null) {
            return;
        }
        if (j2 == 0) {
            synchronized (p.class) {
                if (p.a(this.f132a).m103a(str)) {
                    p.a(this.f132a).c(str);
                    if ("syncing".equals(p.a(this.f132a).a(vVarM99a))) {
                        p.a(this.f132a).a(vVarM99a, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(p.a(this.f132a).a(vVarM99a))) {
            synchronized (p.class) {
                if (p.a(this.f132a).m103a(str)) {
                    if (p.a(this.f132a).a(str) < 10) {
                        p.a(this.f132a).b(str);
                        u.a(this.f132a).a(str, vVarM99a, dVar, "retry");
                    } else {
                        p.a(this.f132a).c(str);
                    }
                }
            }
            return;
        }
        p.a(this.f132a).c(str);
    }

    private void a(gw gwVar) {
        String strA = gwVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + strA);
        Map<String, String> mapM508a = gwVar.m508a();
        if (mapM508a != null) {
            String str = mapM508a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + strA + "  realSource = " + str);
            bn.a(this.f132a).a(strA, str, Boolean.valueOf(gwVar.f675a == 0));
        }
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long j2 = ((((Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        long j3 = ((((Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60)));
        return arrayList;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f132a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f132a, gt.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, jCurrentTimeMillis).commit();
        }
    }

    private void a(hb hbVar) {
        com.xiaomi.channel.commonutils.logger.b.m48a("receive a message but decrypt failed. report now.");
        he heVar = new he(hbVar.m527a().f630a, false);
        heVar.c(gp.DecryptMessageFail.f597a);
        heVar.b(hbVar.m528a());
        heVar.d(hbVar.f724b);
        heVar.f736a = new HashMap();
        heVar.f736a.put("regid", MiPushClient.getRegId(this.f132a));
        u.a(this.f132a).a(heVar, gf.Notification, false, (gs) null);
    }

    private void a(hi hiVar, hb hbVar) {
        gs gsVarM527a = hbVar.m527a();
        if (gsVarM527a != null) {
            gsVarM527a = au.a(gsVarM527a.m492a());
        }
        gv gvVar = new gv();
        gvVar.b(hiVar.b());
        gvVar.a(hiVar.m566a());
        gvVar.a(hiVar.a().a());
        if (!TextUtils.isEmpty(hiVar.c())) {
            gvVar.c(hiVar.c());
        }
        if (!TextUtils.isEmpty(hiVar.d())) {
            gvVar.d(hiVar.d());
        }
        gvVar.a(hp.a(this.f132a, hbVar));
        u.a(this.f132a).a(gvVar, gf.AckMessage, gsVarM527a);
    }

    private void a(he heVar) {
        gw gwVar = new gw();
        gwVar.c(gp.CancelPushMessageACK.f597a);
        gwVar.a(heVar.m542a());
        gwVar.a(heVar.a());
        gwVar.b(heVar.b());
        gwVar.e(heVar.d());
        gwVar.a(0L);
        gwVar.d("success clear push message.");
        u.a(this.f132a).a(gwVar, gf.Notification, false, true, null, false, this.f132a.getPackageName(), b.m73a(this.f132a).m74a(), false);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m104a(Context context, String str) {
        synchronized (f130a) {
            b.m73a(context);
            SharedPreferences sharedPreferencesA = b.a(context);
            if (f131a == null) {
                String[] strArrSplit = sharedPreferencesA.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f131a = new LinkedList();
                for (String str2 : strArrSplit) {
                    f131a.add(str2);
                }
            }
            if (f131a.contains(str)) {
                return true;
            }
            f131a.add(str);
            if (f131a.size() > 25) {
                f131a.poll();
            }
            String strA = bb.a(f131a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString("pref_msg_ids", strA);
            com.xiaomi.push.p.a(editorEdit);
            return false;
        }
    }

    public static void a(Context context, String str) {
        synchronized (f130a) {
            f131a.remove(str);
            b.m73a(context);
            SharedPreferences sharedPreferencesA = b.a(context);
            String strA = bb.a(f131a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString("pref_msg_ids", strA);
            com.xiaomi.push.p.a(editorEdit);
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i2) {
        return x.b(context, str, map, i2);
    }

    /* JADX INFO: renamed from: a */
    private boolean m105a(hb hbVar) {
        Map<String, String> mapM494a = hbVar.m527a() == null ? null : hbVar.m527a().m494a();
        if (mapM494a == null) {
            return false;
        }
        String str = mapM494a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }
}
