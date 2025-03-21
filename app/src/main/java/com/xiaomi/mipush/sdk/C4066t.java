package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4112bn;
import com.xiaomi.push.C4144cs;
import com.xiaomi.push.C4171ds;
import com.xiaomi.push.C4172dt;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4251gr;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4255gv;
import com.xiaomi.push.C4256gw;
import com.xiaomi.push.C4261ha;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4263hc;
import com.xiaomi.push.C4264hd;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4267hg;
import com.xiaomi.push.C4269hi;
import com.xiaomi.push.C4271hk;
import com.xiaomi.push.C4273hm;
import com.xiaomi.push.C4275ho;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4281hu;
import com.xiaomi.push.C4306p;
import com.xiaomi.push.EnumC4183ed;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.EnumC4253gt;
import com.xiaomi.push.InterfaceC4277hq;
import com.xiaomi.push.service.AbstractC4362an;
import com.xiaomi.push.service.C4355ag;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4357ai;
import com.xiaomi.push.service.C4369au;
import com.xiaomi.push.service.C4384g;
import com.xiaomi.push.service.C4402x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
import p000a.p001a.p014u.C0052a;

/* renamed from: com.xiaomi.mipush.sdk.t */
/* loaded from: classes2.dex */
public class C4066t {

    /* renamed from: a */
    private static C4066t f14437a;

    /* renamed from: a */
    private static Object f14438a = new Object();

    /* renamed from: a */
    private static Queue<String> f14439a;

    /* renamed from: a */
    private Context f14440a;

    /* renamed from: com.xiaomi.mipush.sdk.t$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14441a = new int[EnumC4239gf.values().length];

        static {
            try {
                f14441a[EnumC4239gf.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14441a[EnumC4239gf.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14441a[EnumC4239gf.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14441a[EnumC4239gf.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14441a[EnumC4239gf.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14441a[EnumC4239gf.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14441a[EnumC4239gf.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private C4066t(Context context) {
        this.f14440a = context.getApplicationContext();
        if (this.f14440a == null) {
            this.f14440a = context;
        }
    }

    /* renamed from: a */
    public static C4066t m13606a(Context context) {
        if (f14437a == null) {
            f14437a = new C4066t(context);
        }
        return f14437a;
    }

    /* renamed from: b */
    private void m13616b(C4256gw c4256gw) {
        AbstractC4022b.m13359c("ASSEMBLE_PUSH : " + c4256gw.toString());
        String m15183a = c4256gw.m15183a();
        Map<String, String> m15184a = c4256gw.m15184a();
        if (m15184a != null) {
            String str = m15184a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + EnumC4063q.FCM.name())) {
                AbstractC4022b.m13347a("ASSEMBLE_PUSH : receive fcm token sync ack");
                C4052f.m13549b(this.f14440a, EnumC4050d.ASSEMBLE_PUSH_FCM, str);
                m13613a(m15183a, c4256gw.f15924a, EnumC4050d.ASSEMBLE_PUSH_FCM);
                return;
            }
            if (!str.contains("brand:" + EnumC4063q.HUAWEI.name())) {
                if (!str.contains("channel:" + EnumC4063q.HUAWEI.name())) {
                    if (!str.contains("brand:" + EnumC4063q.OPPO.name())) {
                        if (!str.contains("channel:" + EnumC4063q.OPPO.name())) {
                            if (!str.contains("brand:" + EnumC4063q.VIVO.name())) {
                                if (!str.contains("channel:" + EnumC4063q.VIVO.name())) {
                                    return;
                                }
                            }
                            AbstractC4022b.m13347a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            C4052f.m13549b(this.f14440a, EnumC4050d.ASSEMBLE_PUSH_FTOS, str);
                            m13613a(m15183a, c4256gw.f15924a, EnumC4050d.ASSEMBLE_PUSH_FTOS);
                            return;
                        }
                    }
                    AbstractC4022b.m13347a("ASSEMBLE_PUSH : receive COS token sync ack");
                    C4052f.m13549b(this.f14440a, EnumC4050d.ASSEMBLE_PUSH_COS, str);
                    m13613a(m15183a, c4256gw.f15924a, EnumC4050d.ASSEMBLE_PUSH_COS);
                    return;
                }
            }
            AbstractC4022b.m13347a("ASSEMBLE_PUSH : receive hw token sync ack");
            C4052f.m13549b(this.f14440a, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, str);
            m13613a(m15183a, c4256gw.f15924a, EnumC4050d.ASSEMBLE_PUSH_HUAWEI);
        }
    }

    /* renamed from: a */
    public PushMessageHandler.InterfaceC4046a m13619a(Intent intent) {
        String action = intent.getAction();
        AbstractC4022b.m13347a("receive an intent from server, action=" + action);
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
                AbstractC4022b.m13361d("receiving an empty message, drop");
                C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, "12");
                return null;
            }
            C4262hb c4262hb = new C4262hb();
            try {
                C4276hp.m15566a(c4262hb, byteArrayExtra);
                C4048b m13476a = C4048b.m13476a(this.f14440a);
                C4252gs m15264a = c4262hb.m15264a();
                if (c4262hb.m15263a() == EnumC4239gf.SendMessage && m15264a != null && !m13476a.m13500e() && !booleanExtra) {
                    m15264a.m15099a("mrt", stringExtra);
                    m15264a.m15099a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m13615a(c4262hb)) {
                        m13617b(c4262hb);
                    } else {
                        AbstractC4022b.m13356b("this is a mina's message, ack later");
                        m15264a.m15099a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m15264a.m15091a()));
                        m15264a.m15099a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) C4276hp.m15563a(this.f14440a, c4262hb)));
                    }
                }
                if (c4262hb.m15263a() == EnumC4239gf.SendMessage && !c4262hb.m15281b()) {
                    if (C4402x.m16322a(c4262hb)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = c4262hb.m15279b();
                        objArr[1] = m15264a != null ? m15264a.m15096a() : "";
                        AbstractC4022b.m13347a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, String.format("13: %1$s", c4262hb.m15279b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = c4262hb.m15279b();
                        objArr2[1] = m15264a != null ? m15264a.m15096a() : "";
                        AbstractC4022b.m13347a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, String.format("14: %1$s", c4262hb.m15279b()));
                    }
                    C4056j.m13568a(this.f14440a, c4262hb, booleanExtra);
                    return null;
                }
                if (c4262hb.m15263a() == EnumC4239gf.SendMessage && c4262hb.m15281b() && C4402x.m16322a(c4262hb) && (!booleanExtra || m15264a == null || m15264a.m15097a() == null || !m15264a.m15097a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = c4262hb.m15279b();
                    objArr3[1] = m15264a != null ? m15264a.m15096a() : "";
                    AbstractC4022b.m13347a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, String.format("25: %1$s", c4262hb.m15279b()));
                    C4056j.m13570b(this.f14440a, c4262hb, booleanExtra);
                    return null;
                }
                if (!m13476a.m13496c() && c4262hb.f15998a != EnumC4239gf.Registration) {
                    if (C4402x.m16322a(c4262hb)) {
                        return m13604a(c4262hb, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    C4056j.m13573e(this.f14440a, c4262hb, booleanExtra);
                    boolean m13498d = m13476a.m13498d();
                    AbstractC4022b.m13361d("receive message without registration. need re-register!registered?" + m13498d);
                    C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, "15");
                    if (m13498d) {
                        m13607a();
                    }
                } else if (m13476a.m13496c() && m13476a.m13502f()) {
                    if (c4262hb.f15998a == EnumC4239gf.UnRegistration) {
                        if (c4262hb.m15281b()) {
                            m13476a.m13481a();
                            MiPushClient.clearExtras(this.f14440a);
                            PushMessageHandler.m13454a();
                        } else {
                            AbstractC4022b.m13361d("receiving an un-encrypt unregistration message");
                        }
                    } else {
                        C4056j.m13573e(this.f14440a, c4262hb, booleanExtra);
                        MiPushClient.unregisterPush(this.f14440a);
                    }
                } else {
                    return m13604a(c4262hb, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                }
            } catch (C4281hu e2) {
                C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
                AbstractC4022b.m13351a(e2);
            } catch (Exception e3) {
                C4172dt.m14529a(this.f14440a).m14533a(this.f14440a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
                AbstractC4022b.m13351a(e3);
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                C4262hb c4262hb2 = new C4262hb();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        C4276hp.m15566a(c4262hb2, byteArrayExtra2);
                    }
                } catch (C4281hu unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(c4262hb2.m15263a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                AbstractC4022b.m13361d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    AbstractC4022b.m13361d("message arrived: receiving an empty message, drop");
                    return null;
                }
                C4262hb c4262hb3 = new C4262hb();
                try {
                    C4276hp.m15566a(c4262hb3, byteArrayExtra3);
                    C4048b m13476a2 = C4048b.m13476a(this.f14440a);
                    if (C4402x.m16322a(c4262hb3)) {
                        AbstractC4022b.m13361d("message arrived: receive ignore reg message, ignore!");
                    } else if (!m13476a2.m13496c()) {
                        AbstractC4022b.m13361d("message arrived: receive message without registration. need unregister or re-register!");
                    } else if (m13476a2.m13496c() && m13476a2.m13502f()) {
                        AbstractC4022b.m13361d("message arrived: app info is invalidated");
                    } else {
                        return m13605a(c4262hb3, byteArrayExtra3);
                    }
                } catch (Exception e4) {
                    AbstractC4022b.m13361d("fail to deal with arrived message. " + e4);
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m13617b(C4262hb c4262hb) {
        C4252gs m15264a = c4262hb.m15264a();
        if (m15264a != null) {
            m15264a = C4369au.m16011a(m15264a.m15092a());
        }
        C4255gv c4255gv = new C4255gv();
        c4255gv.m15153b(c4262hb.m15271a());
        c4255gv.m15147a(m15264a.m15096a());
        c4255gv.m15146a(m15264a.m15091a());
        if (!TextUtils.isEmpty(m15264a.m15106b())) {
            c4255gv.m15156c(m15264a.m15106b());
        }
        c4255gv.m15148a(C4276hp.m15563a(this.f14440a, c4262hb));
        C4067u.m13627a(this.f14440a).m13661a((C4067u) c4255gv, EnumC4239gf.AckMessage, false, m15264a);
    }

    /* renamed from: b */
    private void m13618b(C4265he c4265he) {
        Map<String, String> m15307a = c4265he.m15307a();
        if (m15307a == null) {
            AbstractC4022b.m13347a("detect failed because null");
            return;
        }
        String str = (String) C4355ag.m15905a(m15307a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            AbstractC4022b.m13347a("detect failed because empty");
            return;
        }
        Map<String, String> m14932a = C4233g.m14932a(this.f14440a, str);
        if (m14932a != null) {
            String str2 = m14932a.get("alive");
            String str3 = m14932a.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                C4265he c4265he2 = new C4265he();
                c4265he2.m15301a(c4265he.m15306a());
                c4265he2.m15314b(c4265he.m15315b());
                c4265he2.m15322d(c4265he.m15323d());
                c4265he2.m15318c(EnumC4249gp.DetectAppAliveResult.f15769a);
                c4265he2.f16034a = new HashMap();
                c4265he2.f16034a.put("alive", str2);
                if (Boolean.parseBoolean((String) C4355ag.m15905a(m15307a, "reportNotAliveApp", C0052a.f159k)) && !TextUtils.isEmpty(str3)) {
                    c4265he2.f16034a.put("notAlive", str3);
                }
                C4067u.m13627a(this.f14440a).m13661a((C4067u) c4265he2, EnumC4239gf.Notification, false, (C4252gs) null);
                return;
            }
            AbstractC4022b.m13356b("detect failed because no alive process");
            return;
        }
        AbstractC4022b.m13347a("detect failed because get status illegal");
    }

    /* renamed from: a */
    private PushMessageHandler.InterfaceC4046a m13605a(C4262hb c4262hb, byte[] bArr) {
        String str = null;
        try {
            InterfaceC4277hq m13598a = C4064r.m13598a(this.f14440a, c4262hb);
            if (m13598a == null) {
                AbstractC4022b.m13361d("message arrived: receiving an un-recognized message. " + c4262hb.f15998a);
                return null;
            }
            EnumC4239gf m15263a = c4262hb.m15263a();
            AbstractC4022b.m13347a("message arrived: processing an arrived message, action=" + m15263a);
            if (AnonymousClass1.f14441a[m15263a.ordinal()] != 1) {
                return null;
            }
            if (!c4262hb.m15281b()) {
                AbstractC4022b.m13361d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            C4269hi c4269hi = (C4269hi) m13598a;
            C4251gr m15438a = c4269hi.m15438a();
            if (m15438a == null) {
                AbstractC4022b.m13361d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            C4252gs c4252gs = c4262hb.f15999a;
            if (c4252gs != null && c4252gs.m15097a() != null) {
                str = c4262hb.f15999a.f15842a.get("jobkey");
            }
            MiPushMessage generateMessage = PushMessageHelper.generateMessage(c4269hi, c4262hb.m15264a(), false);
            generateMessage.setArrivedMessage(true);
            AbstractC4022b.m13347a("message arrived: receive a message, msgid=" + m15438a.m15062a() + ", jobkey=" + str);
            return generateMessage;
        } catch (C4058l e2) {
            AbstractC4022b.m13351a(e2);
            AbstractC4022b.m13361d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (C4281hu e3) {
            AbstractC4022b.m13351a(e3);
            AbstractC4022b.m13361d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private PushMessageHandler.InterfaceC4046a m13604a(C4262hb c4262hb, boolean z, byte[] bArr, String str, int i2, Intent intent) {
        C4252gs c4252gs;
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
            InterfaceC4277hq m13598a = C4064r.m13598a(this.f14440a, c4262hb);
            if (m13598a == null) {
                AbstractC4022b.m13361d("receiving an un-recognized message. " + c4262hb.f15998a);
                C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "18");
                C4056j.m13571c(this.f14440a, c4262hb, z);
                return null;
            }
            EnumC4239gf m15263a = c4262hb.m15263a();
            AbstractC4022b.m13350a("processing a message, action=", m15263a, ", hasNotified=", Boolean.valueOf(z));
            switch (AnonymousClass1.f14441a[m15263a.ordinal()]) {
                case 1:
                    if (!c4262hb.m15281b()) {
                        AbstractC4022b.m13361d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (C4048b.m13476a(this.f14440a).m13500e() && !z) {
                        AbstractC4022b.m13347a("receive a message in pause state. drop it");
                        C4172dt.m14529a(this.f14440a).m14536a(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "12");
                        return null;
                    }
                    C4269hi c4269hi = (C4269hi) m13598a;
                    C4251gr m15438a = c4269hi.m15438a();
                    if (m15438a == null) {
                        AbstractC4022b.m13361d("receive an empty message without push content, drop it");
                        C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "22");
                        C4056j.m13572d(this.f14440a, c4262hb, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (C4402x.m16322a(c4262hb)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f14440a, m15438a.m15062a(), c4262hb.m15264a(), c4262hb.f16005b, m15438a.m15067b());
                        } else {
                            if (c4262hb.m15264a() != null) {
                                c4252gs = new C4252gs(c4262hb.m15264a());
                            } else {
                                c4252gs = new C4252gs();
                            }
                            if (c4252gs.m15097a() == null) {
                                c4252gs.m15095a(new HashMap());
                            }
                            c4252gs.m15097a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.reportMessageClicked(this.f14440a, m15438a.m15062a(), c4252gs, m15438a.m15067b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(c4269hi.m15448d()) && MiPushClient.aliasSetTime(this.f14440a, c4269hi.m15448d()) < 0) {
                            MiPushClient.addAlias(this.f14440a, c4269hi.m15448d());
                        } else if (!TextUtils.isEmpty(c4269hi.m15446c()) && MiPushClient.topicSubscribedTime(this.f14440a, c4269hi.m15446c()) < 0) {
                            MiPushClient.addTopic(this.f14440a, c4269hi.m15446c());
                        }
                    }
                    C4252gs c4252gs2 = c4262hb.f15999a;
                    String str2 = (c4252gs2 == null || c4252gs2.m15097a() == null) ? null : c4262hb.f15999a.f15842a.get("jobkey");
                    String str3 = str2;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = m15438a.m15062a();
                    }
                    if (!z && m13614a(this.f14440a, str2)) {
                        AbstractC4022b.m13347a("drop a duplicate message, key=" + str2);
                        C4172dt.m14529a(this.f14440a).m14538c(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "2:" + str2);
                    } else {
                        MiPushMessage generateMessage = PushMessageHelper.generateMessage(c4269hi, c4262hb.m15264a(), z);
                        if (generateMessage.getPassThrough() == 0 && !z && C4402x.m16324a(generateMessage.getExtra())) {
                            C4402x.m16304a(this.f14440a, c4262hb, bArr);
                            return null;
                        }
                        String m16307a = C4402x.m16307a(generateMessage.getExtra(), intExtra);
                        AbstractC4022b.m13350a("receive a message, msgid=", m15438a.m15062a(), ", jobkey=", str2, ", btn=", Integer.valueOf(intExtra), ", typeId=", m16307a, ", hasNotified=", Boolean.valueOf(z));
                        if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(m16307a)) {
                            Map<String, String> extra = generateMessage.getExtra();
                            if (intExtra != 0 && c4262hb.m15264a() != null) {
                                C4067u.m13627a(this.f14440a).m13652a(c4262hb.m15264a().m15111c(), intExtra);
                            }
                            if (C4402x.m16322a(c4262hb)) {
                                Intent m13603a = m13603a(this.f14440a, c4262hb.f16005b, extra, intExtra);
                                m13603a.putExtra("eventMessageType", i2);
                                m13603a.putExtra("messageId", str);
                                m13603a.putExtra("jobkey", str3);
                                if (m13603a == null) {
                                    AbstractC4022b.m13347a("Getting Intent fail from ignore reg message. ");
                                    C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "23");
                                    return null;
                                }
                                String m15070c = m15438a.m15070c();
                                if (!TextUtils.isEmpty(m15070c)) {
                                    m13603a.putExtra("payload", m15070c);
                                }
                                this.f14440a.startActivity(m13603a);
                                C4056j.m13567a(this.f14440a, c4262hb);
                                C4172dt.m14529a(this.f14440a).m14535a(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, 3006, m16307a);
                                AbstractC4022b.m13348a("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f14440a;
                                Intent m13603a2 = m13603a(context, context.getPackageName(), extra, intExtra);
                                if (m13603a2 != null) {
                                    if (!m16307a.equals(AbstractC4362an.f16601c)) {
                                        m13603a2.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        m13603a2.putExtra("eventMessageType", i2);
                                        m13603a2.putExtra("messageId", str);
                                        m13603a2.putExtra("jobkey", str3);
                                    }
                                    this.f14440a.startActivity(m13603a2);
                                    C4056j.m13567a(this.f14440a, c4262hb);
                                    AbstractC4022b.m13348a("PushMessageProcessor", "start activity succ");
                                    C4172dt.m14529a(this.f14440a).m14535a(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, 1006, m16307a);
                                    if (m16307a.equals(AbstractC4362an.f16601c)) {
                                        C4172dt.m14529a(this.f14440a).m14536a(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "13");
                                    }
                                } else {
                                    AbstractC4022b.m13362d("PushMessageProcessor", "missing target intent for message: " + m15438a.m15062a() + ", typeId=" + m16307a);
                                }
                            }
                            AbstractC4022b.m13348a("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = generateMessage;
                    }
                    if (c4262hb.m15264a() == null && !z) {
                        m13612a(c4269hi, c4262hb);
                    }
                    return miPushMessage;
                case 2:
                    C4267hg c4267hg = (C4267hg) m13598a;
                    String str4 = C4048b.m13476a(this.f14440a).f14378a;
                    if (!TextUtils.isEmpty(str4) && TextUtils.equals(str4, c4267hg.m15394a())) {
                        long m13649a = C4067u.m13627a(this.f14440a).m13649a();
                        if (m13649a > 0 && SystemClock.elapsedRealtime() - m13649a > C2084a.f6126h) {
                            AbstractC4022b.m13347a("The received registration result has expired.");
                            C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_VIDEO);
                            return null;
                        }
                        C4048b.m13476a(this.f14440a).f14378a = null;
                        if (c4267hg.f16127a == 0) {
                            C4048b.m13476a(this.f14440a).m13493b(c4267hg.f16139e, c4267hg.f16140f, c4267hg.f16146l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f14440a);
                            C4172dt.m14529a(this.f14440a).m14535a(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, AuthCode.StatusCode.PERMISSION_EXPIRED, "1");
                        } else {
                            C4172dt.m14529a(this.f14440a).m14535a(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, AuthCode.StatusCode.PERMISSION_EXPIRED, "2");
                        }
                        if (!TextUtils.isEmpty(c4267hg.f16139e)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(c4267hg.f16139e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_REGISTER.f15082a, arrayList3, c4267hg.f16127a, c4267hg.f16138d, null, c4267hg.m15395a());
                        C4067u.m13627a(this.f14440a).m13677d();
                        return generateCommandMessage;
                    }
                    AbstractC4022b.m13347a("bad Registration result:");
                    C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "21");
                    return null;
                case 3:
                    if (!c4262hb.m15281b()) {
                        AbstractC4022b.m13361d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((C4273hm) m13598a).f16262a == 0) {
                        C4048b.m13476a(this.f14440a).m13481a();
                        MiPushClient.clearExtras(this.f14440a);
                    }
                    PushMessageHandler.m13454a();
                    return miPushMessage;
                case 4:
                    C4271hk c4271hk = (C4271hk) m13598a;
                    if (c4271hk.f16216a == 0) {
                        MiPushClient.addTopic(this.f14440a, c4271hk.m15482b());
                    }
                    if (!TextUtils.isEmpty(c4271hk.m15482b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(c4271hk.m15482b());
                    }
                    AbstractC4022b.m13363e("resp-cmd:" + EnumC4183ed.COMMAND_SUBSCRIBE_TOPIC + ", " + c4271hk.m15477a());
                    return PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_SUBSCRIBE_TOPIC.f15082a, arrayList2, c4271hk.f16216a, c4271hk.f16222d, c4271hk.m15484c(), null);
                case 5:
                    C4275ho c4275ho = (C4275ho) m13598a;
                    if (c4275ho.f16299a == 0) {
                        MiPushClient.removeTopic(this.f14440a, c4275ho.m15552b());
                    }
                    if (!TextUtils.isEmpty(c4275ho.m15552b())) {
                        arrayList = new ArrayList();
                        arrayList.add(c4275ho.m15552b());
                    }
                    AbstractC4022b.m13363e("resp-cmd:" + EnumC4183ed.COMMAND_UNSUBSCRIBE_TOPIC + ", " + c4275ho.m15547a());
                    return PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_UNSUBSCRIBE_TOPIC.f15082a, arrayList, c4275ho.f16299a, c4275ho.f16305d, c4275ho.m15554c(), null);
                case 6:
                    C4144cs.m14182a(this.f14440a.getPackageName(), this.f14440a, m13598a, EnumC4239gf.Command, bArr.length);
                    C4261ha c4261ha = (C4261ha) m13598a;
                    String m15250b = c4261ha.m15250b();
                    List<String> m15245a = c4261ha.m15245a();
                    if (c4261ha.f15978a == 0) {
                        if (TextUtils.equals(m15250b, EnumC4183ed.COMMAND_SET_ACCEPT_TIME.f15082a) && m15245a != null && m15245a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f14440a, m15245a.get(0), m15245a.get(1));
                            if ("00:00".equals(m15245a.get(0)) && "00:00".equals(m15245a.get(1))) {
                                C4048b.m13476a(this.f14440a).m13486a(true);
                            } else {
                                C4048b.m13476a(this.f14440a).m13486a(false);
                            }
                            m15245a = m13620a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m15245a);
                        } else if (TextUtils.equals(m15250b, EnumC4183ed.COMMAND_SET_ALIAS.f15082a) && m15245a != null && m15245a.size() > 0) {
                            MiPushClient.addAlias(this.f14440a, m15245a.get(0));
                        } else if (TextUtils.equals(m15250b, EnumC4183ed.COMMAND_UNSET_ALIAS.f15082a) && m15245a != null && m15245a.size() > 0) {
                            MiPushClient.removeAlias(this.f14440a, m15245a.get(0));
                        } else if (TextUtils.equals(m15250b, EnumC4183ed.COMMAND_SET_ACCOUNT.f15082a) && m15245a != null && m15245a.size() > 0) {
                            MiPushClient.addAccount(this.f14440a, m15245a.get(0));
                        } else if (TextUtils.equals(m15250b, EnumC4183ed.COMMAND_UNSET_ACCOUNT.f15082a) && m15245a != null && m15245a.size() > 0) {
                            MiPushClient.removeAccount(this.f14440a, m15245a.get(0));
                        } else if (TextUtils.equals(m15250b, EnumC4183ed.COMMAND_CHK_VDEVID.f15082a)) {
                            return null;
                        }
                    }
                    List<String> list = m15245a;
                    AbstractC4022b.m13363e("resp-cmd:" + m15250b + ", " + c4261ha.m15244a());
                    return PushMessageHelper.generateCommandMessage(m15250b, list, c4261ha.f15978a, c4261ha.f15986d, c4261ha.m15253c(), null);
                case 7:
                    C4144cs.m14182a(this.f14440a.getPackageName(), this.f14440a, m13598a, EnumC4239gf.Notification, bArr.length);
                    if (m13598a instanceof C4256gw) {
                        C4256gw c4256gw = (C4256gw) m13598a;
                        String m15183a = c4256gw.m15183a();
                        AbstractC4022b.m13363e("resp-type:" + c4256gw.m15190b() + ", code:" + c4256gw.f15924a + ", " + m15183a);
                        if (EnumC4249gp.DisablePushMessage.f15769a.equalsIgnoreCase(c4256gw.f15931d)) {
                            if (c4256gw.f15924a == 0) {
                                synchronized (C4062p.class) {
                                    if (C4062p.m13587a(this.f14440a).m13592a(m15183a)) {
                                        C4062p.m13587a(this.f14440a).m13594c(m15183a);
                                        if ("syncing".equals(C4062p.m13587a(this.f14440a).m13589a(EnumC4068v.DISABLE_PUSH))) {
                                            C4062p.m13587a(this.f14440a).m13590a(EnumC4068v.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f14440a);
                                            MiPushClient.clearLocalNotificationType(this.f14440a);
                                            PushMessageHandler.m13454a();
                                            C4067u.m13627a(this.f14440a).m13673b();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(C4062p.m13587a(this.f14440a).m13589a(EnumC4068v.DISABLE_PUSH))) {
                                synchronized (C4062p.class) {
                                    if (C4062p.m13587a(this.f14440a).m13592a(m15183a)) {
                                        if (C4062p.m13587a(this.f14440a).m13588a(m15183a) < 10) {
                                            C4062p.m13587a(this.f14440a).m13593b(m15183a);
                                            C4067u.m13627a(this.f14440a).m13670a(true, m15183a);
                                        } else {
                                            C4062p.m13587a(this.f14440a).m13594c(m15183a);
                                        }
                                    }
                                }
                            } else {
                                C4062p.m13587a(this.f14440a).m13594c(m15183a);
                            }
                        } else if (EnumC4249gp.EnablePushMessage.f15769a.equalsIgnoreCase(c4256gw.f15931d)) {
                            if (c4256gw.f15924a == 0) {
                                synchronized (C4062p.class) {
                                    if (C4062p.m13587a(this.f14440a).m13592a(m15183a)) {
                                        C4062p.m13587a(this.f14440a).m13594c(m15183a);
                                        if ("syncing".equals(C4062p.m13587a(this.f14440a).m13589a(EnumC4068v.ENABLE_PUSH))) {
                                            C4062p.m13587a(this.f14440a).m13590a(EnumC4068v.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(C4062p.m13587a(this.f14440a).m13589a(EnumC4068v.ENABLE_PUSH))) {
                                synchronized (C4062p.class) {
                                    if (C4062p.m13587a(this.f14440a).m13592a(m15183a)) {
                                        if (C4062p.m13587a(this.f14440a).m13588a(m15183a) < 10) {
                                            C4062p.m13587a(this.f14440a).m13593b(m15183a);
                                            C4067u.m13627a(this.f14440a).m13670a(false, m15183a);
                                        } else {
                                            C4062p.m13587a(this.f14440a).m13594c(m15183a);
                                        }
                                    }
                                }
                            } else {
                                C4062p.m13587a(this.f14440a).m13594c(m15183a);
                            }
                        } else if (EnumC4249gp.ThirdPartyRegUpdate.f15769a.equalsIgnoreCase(c4256gw.f15931d)) {
                            m13616b(c4256gw);
                        } else if (EnumC4249gp.UploadTinyData.f15769a.equalsIgnoreCase(c4256gw.f15931d)) {
                            m13609a(c4256gw);
                        }
                    } else if (m13598a instanceof C4265he) {
                        C4265he c4265he = (C4265he) m13598a;
                        if ("registration id expired".equalsIgnoreCase(c4265he.f16039d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f14440a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f14440a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f14440a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f14440a);
                            AbstractC4022b.m13363e("resp-type:" + c4265he.f16039d + ", " + c4265he.m15306a());
                            MiPushClient.reInitialize(this.f14440a, EnumC4253gt.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f14440a, str5);
                                MiPushClient.setAlias(this.f14440a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f14440a, str6);
                                MiPushClient.subscribe(this.f14440a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f14440a, str7);
                                MiPushClient.setUserAccount(this.f14440a, str7, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f14440a);
                                MiPushClient.addAcceptTime(this.f14440a, split[0], split[1]);
                            }
                        } else if (EnumC4249gp.ClientInfoUpdateOk.f15769a.equalsIgnoreCase(c4265he.f16039d)) {
                            if (c4265he.m15307a() != null && c4265he.m15307a().containsKey("app_version")) {
                                C4048b.m13476a(this.f14440a).m13483a(c4265he.m15307a().get("app_version"));
                            }
                        } else {
                            try {
                                if (EnumC4249gp.NormalClientConfigUpdate.f15769a.equalsIgnoreCase(c4265he.f16039d)) {
                                    C4264hd c4264hd = new C4264hd();
                                    C4276hp.m15566a(c4264hd, c4265he.m15313a());
                                    C4357ai.m15940a(C4356ah.m15923a(this.f14440a), c4264hd);
                                } else if (EnumC4249gp.CustomClientConfigUpdate.f15769a.equalsIgnoreCase(c4265he.f16039d)) {
                                    C4263hc c4263hc = new C4263hc();
                                    C4276hp.m15566a(c4263hc, c4265he.m15313a());
                                    C4357ai.m15939a(C4356ah.m15923a(this.f14440a), c4263hc);
                                } else if (EnumC4249gp.SyncInfoResult.f15769a.equalsIgnoreCase(c4265he.f16039d)) {
                                    C4069w.m13682a(this.f14440a, c4265he);
                                } else if (EnumC4249gp.ForceSync.f15769a.equalsIgnoreCase(c4265he.f16039d)) {
                                    AbstractC4022b.m13347a("receive force sync notification");
                                    C4069w.m13683a(this.f14440a, false);
                                } else if (EnumC4249gp.CancelPushMessage.f15769a.equals(c4265he.f16039d)) {
                                    AbstractC4022b.m13363e("resp-type:" + c4265he.f16039d + ", " + c4265he.m15306a());
                                    if (c4265he.m15307a() != null) {
                                        int i3 = -2;
                                        if (c4265he.m15307a().containsKey(AbstractC4362an.f16597Q)) {
                                            String str8 = c4265he.m15307a().get(AbstractC4362an.f16597Q);
                                            if (!TextUtils.isEmpty(str8)) {
                                                try {
                                                    i3 = Integer.parseInt(str8);
                                                } catch (NumberFormatException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i3 >= -1) {
                                            MiPushClient.clearNotification(this.f14440a, i3);
                                        } else {
                                            MiPushClient.clearNotification(this.f14440a, c4265he.m15307a().containsKey(AbstractC4362an.f16595O) ? c4265he.m15307a().get(AbstractC4362an.f16595O) : "", c4265he.m15307a().containsKey(AbstractC4362an.f16596P) ? c4265he.m15307a().get(AbstractC4362an.f16596P) : "");
                                        }
                                    }
                                    m13611a(c4265he);
                                } else if (EnumC4249gp.HybridRegisterResult.f15769a.equals(c4265he.f16039d)) {
                                    try {
                                        C4267hg c4267hg2 = new C4267hg();
                                        C4276hp.m15566a(c4267hg2, c4265he.m15313a());
                                        MiPushClient4Hybrid.onReceiveRegisterResult(this.f14440a, c4267hg2);
                                    } catch (C4281hu e3) {
                                        AbstractC4022b.m13351a(e3);
                                    }
                                } else if (EnumC4249gp.HybridUnregisterResult.f15769a.equals(c4265he.f16039d)) {
                                    try {
                                        C4273hm c4273hm = new C4273hm();
                                        C4276hp.m15566a(c4273hm, c4265he.m15313a());
                                        MiPushClient4Hybrid.onReceiveUnregisterResult(this.f14440a, c4273hm);
                                    } catch (C4281hu e4) {
                                        AbstractC4022b.m13351a(e4);
                                    }
                                } else if (!EnumC4249gp.PushLogUpload.f15769a.equals(c4265he.f16039d)) {
                                    if (EnumC4249gp.DetectAppAlive.f15769a.equals(c4265he.f16039d)) {
                                        AbstractC4022b.m13356b("receive detect msg");
                                        m13618b(c4265he);
                                    } else if (C4384g.m16096a(c4265he)) {
                                        AbstractC4022b.m13356b("receive notification handle by cpra");
                                    }
                                }
                            } catch (C4281hu unused) {
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (C4058l e5) {
            AbstractC4022b.m13351a(e5);
            m13610a(c4262hb);
            C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
            C4056j.m13571c(this.f14440a, c4262hb, z);
            return null;
        } catch (C4281hu e6) {
            AbstractC4022b.m13351a(e6);
            AbstractC4022b.m13361d("receive a message which action string is not valid. is the reg expired?");
            C4172dt.m14529a(this.f14440a).m14537b(this.f14440a.getPackageName(), C4171ds.m14522a(i2), str, "20");
            C4056j.m13571c(this.f14440a, c4262hb, z);
            return null;
        }
    }

    /* renamed from: a */
    private void m13613a(String str, long j2, EnumC4050d enumC4050d) {
        EnumC4068v m13555a = C4053g.m13555a(enumC4050d);
        if (m13555a == null) {
            return;
        }
        if (j2 == 0) {
            synchronized (C4062p.class) {
                if (C4062p.m13587a(this.f14440a).m13592a(str)) {
                    C4062p.m13587a(this.f14440a).m13594c(str);
                    if ("syncing".equals(C4062p.m13587a(this.f14440a).m13589a(m13555a))) {
                        C4062p.m13587a(this.f14440a).m13590a(m13555a, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(C4062p.m13587a(this.f14440a).m13589a(m13555a))) {
            synchronized (C4062p.class) {
                if (C4062p.m13587a(this.f14440a).m13592a(str)) {
                    if (C4062p.m13587a(this.f14440a).m13588a(str) < 10) {
                        C4062p.m13587a(this.f14440a).m13593b(str);
                        C4067u.m13627a(this.f14440a).m13667a(str, m13555a, enumC4050d, "retry");
                    } else {
                        C4062p.m13587a(this.f14440a).m13594c(str);
                    }
                }
            }
            return;
        }
        C4062p.m13587a(this.f14440a).m13594c(str);
    }

    /* renamed from: a */
    private void m13609a(C4256gw c4256gw) {
        String m15183a = c4256gw.m15183a();
        AbstractC4022b.m13356b("receive ack " + m15183a);
        Map<String, String> m15184a = c4256gw.m15184a();
        if (m15184a != null) {
            String str = m15184a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AbstractC4022b.m13356b("receive ack : messageId = " + m15183a + "  realSource = " + str);
            C4112bn.m13932a(this.f14440a).m13943a(m15183a, str, Boolean.valueOf(c4256gw.f15924a == 0));
        }
    }

    /* renamed from: a */
    public List<String> m13620a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }

    /* renamed from: a */
    private void m13607a() {
        SharedPreferences sharedPreferences = this.f14440a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f14440a, EnumC4253gt.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    private void m13610a(C4262hb c4262hb) {
        AbstractC4022b.m13347a("receive a message but decrypt failed. report now.");
        C4265he c4265he = new C4265he(c4262hb.m15264a().f15840a, false);
        c4265he.m15318c(EnumC4249gp.DecryptMessageFail.f15769a);
        c4265he.m15314b(c4262hb.m15271a());
        c4265he.m15322d(c4262hb.f16005b);
        c4265he.f16034a = new HashMap();
        c4265he.f16034a.put("regid", MiPushClient.getRegId(this.f14440a));
        C4067u.m13627a(this.f14440a).m13661a((C4067u) c4265he, EnumC4239gf.Notification, false, (C4252gs) null);
    }

    /* renamed from: a */
    private void m13612a(C4269hi c4269hi, C4262hb c4262hb) {
        C4252gs m15264a = c4262hb.m15264a();
        if (m15264a != null) {
            m15264a = C4369au.m16011a(m15264a.m15092a());
        }
        C4255gv c4255gv = new C4255gv();
        c4255gv.m15153b(c4269hi.m15444b());
        c4255gv.m15147a(c4269hi.m15439a());
        c4255gv.m15146a(c4269hi.m15438a().m15061a());
        if (!TextUtils.isEmpty(c4269hi.m15446c())) {
            c4255gv.m15156c(c4269hi.m15446c());
        }
        if (!TextUtils.isEmpty(c4269hi.m15448d())) {
            c4255gv.m15159d(c4269hi.m15448d());
        }
        c4255gv.m15148a(C4276hp.m15563a(this.f14440a, c4262hb));
        C4067u.m13627a(this.f14440a).m13659a((C4067u) c4255gv, EnumC4239gf.AckMessage, m15264a);
    }

    /* renamed from: a */
    private void m13611a(C4265he c4265he) {
        C4256gw c4256gw = new C4256gw();
        c4256gw.m15192c(EnumC4249gp.CancelPushMessageACK.f15769a);
        c4256gw.m15182a(c4265he.m15306a());
        c4256gw.m15181a(c4265he.m15300a());
        c4256gw.m15189b(c4265he.m15315b());
        c4256gw.m15196e(c4265he.m15323d());
        c4256gw.m15180a(0L);
        c4256gw.m15194d("success clear push message.");
        C4067u.m13627a(this.f14440a).m13665a(c4256gw, EnumC4239gf.Notification, false, true, null, false, this.f14440a.getPackageName(), C4048b.m13476a(this.f14440a).m13480a(), false);
    }

    /* renamed from: a */
    private static boolean m13614a(Context context, String str) {
        synchronized (f14438a) {
            C4048b.m13476a(context);
            SharedPreferences m13475a = C4048b.m13475a(context);
            if (f14439a == null) {
                String[] split = m13475a.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f14439a = new LinkedList();
                for (String str2 : split) {
                    f14439a.add(str2);
                }
            }
            if (f14439a.contains(str)) {
                return true;
            }
            f14439a.add(str);
            if (f14439a.size() > 25) {
                f14439a.poll();
            }
            String m13881a = C4100bb.m13881a(f14439a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = m13475a.edit();
            edit.putString("pref_msg_ids", m13881a);
            C4306p.m15711a(edit);
            return false;
        }
    }

    /* renamed from: a */
    public static void m13608a(Context context, String str) {
        synchronized (f14438a) {
            f14439a.remove(str);
            C4048b.m13476a(context);
            SharedPreferences m13475a = C4048b.m13475a(context);
            String m13881a = C4100bb.m13881a(f14439a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = m13475a.edit();
            edit.putString("pref_msg_ids", m13881a);
            C4306p.m15711a(edit);
        }
    }

    /* renamed from: a */
    public static Intent m13603a(Context context, String str, Map<String, String> map, int i2) {
        return C4402x.m16328b(context, str, map, i2);
    }

    /* renamed from: a */
    private boolean m13615a(C4262hb c4262hb) {
        Map<String, String> m15097a = c4262hb.m15264a() == null ? null : c4262hb.m15264a().m15097a();
        if (m15097a == null) {
            return false;
        }
        String str = m15097a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }
}
