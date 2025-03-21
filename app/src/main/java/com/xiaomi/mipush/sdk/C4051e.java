package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.service.C4356ah;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.e */
/* loaded from: classes2.dex */
public class C4051e implements AbstractPushManager {

    /* renamed from: a */
    private static volatile C4051e f14398a;

    /* renamed from: a */
    private Context f14399a;

    /* renamed from: a */
    private PushConfiguration f14400a;

    /* renamed from: a */
    private boolean f14402a = false;

    /* renamed from: a */
    private Map<EnumC4050d, AbstractPushManager> f14401a = new HashMap();

    /* renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14404a = new int[EnumC4050d.values().length];

        static {
            try {
                f14404a[EnumC4050d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14404a[EnumC4050d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14404a[EnumC4050d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14404a[EnumC4050d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private C4051e(Context context) {
        this.f14399a = context.getApplicationContext();
    }

    /* renamed from: b */
    public boolean m13527b(EnumC4050d enumC4050d) {
        int i2 = AnonymousClass2.f14404a[enumC4050d.ordinal()];
        boolean z = false;
        if (i2 == 1) {
            PushConfiguration pushConfiguration = this.f14400a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        }
        if (i2 == 2) {
            PushConfiguration pushConfiguration2 = this.f14400a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        }
        if (i2 == 3) {
            PushConfiguration pushConfiguration3 = this.f14400a;
            if (pushConfiguration3 != null) {
                z = pushConfiguration3.getOpenCOSPush();
            }
        } else if (i2 != 4) {
            return false;
        }
        PushConfiguration pushConfiguration4 = this.f14400a;
        return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        AbstractC4022b.m13347a("ASSEMBLE_PUSH : assemble push register");
        if (this.f14401a.size() <= 0) {
            m13519a();
        }
        if (this.f14401a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f14401a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            C4052f.m13536a(this.f14399a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        AbstractC4022b.m13347a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f14401a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f14401a.clear();
    }

    /* renamed from: a */
    public static C4051e m13518a(Context context) {
        if (f14398a == null) {
            synchronized (C4051e.class) {
                if (f14398a == null) {
                    f14398a = new C4051e(context);
                }
            }
        }
        return f14398a;
    }

    /* renamed from: a */
    public void m13523a(PushConfiguration pushConfiguration) {
        this.f14400a = pushConfiguration;
        this.f14402a = C4356ah.m15923a(this.f14399a).m15935a(EnumC4244gk.AggregatePushSwitch.m15014a(), true);
        if (this.f14400a.getOpenHmsPush() || this.f14400a.getOpenFCMPush() || this.f14400a.getOpenCOSPush() || this.f14400a.getOpenFTOSPush()) {
            C4356ah.m15923a(this.f14399a).m15932a(new C4356ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.C4356ah.a
                protected void onCallback() {
                    boolean m15935a = C4356ah.m15923a(C4051e.this.f14399a).m15935a(EnumC4244gk.AggregatePushSwitch.m15014a(), true);
                    if (C4051e.this.f14402a != m15935a) {
                        C4051e.this.f14402a = m15935a;
                        C4052f.m13548b(C4051e.this.f14399a);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m13525a(EnumC4050d enumC4050d, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f14401a.containsKey(enumC4050d)) {
                this.f14401a.remove(enumC4050d);
            }
            this.f14401a.put(enumC4050d, abstractPushManager);
        }
    }

    /* renamed from: a */
    public void m13524a(EnumC4050d enumC4050d) {
        this.f14401a.remove(enumC4050d);
    }

    /* renamed from: a */
    public boolean m13526a(EnumC4050d enumC4050d) {
        return this.f14401a.containsKey(enumC4050d);
    }

    /* renamed from: a */
    public AbstractPushManager m13522a(EnumC4050d enumC4050d) {
        return this.f14401a.get(enumC4050d);
    }

    /* renamed from: a */
    private void m13519a() {
        AbstractPushManager m13522a;
        AbstractPushManager m13522a2;
        AbstractPushManager m13522a3;
        AbstractPushManager m13522a4;
        PushConfiguration pushConfiguration = this.f14400a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f14400a.getOpenHmsPush() + " HW online switch : " + C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + C4054h.m13560a(this.f14399a));
                AbstractC4022b.m13347a(sb.toString());
            }
            if (this.f14400a.getOpenHmsPush() && C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_HUAWEI) && C4054h.m13560a(this.f14399a)) {
                if (!m13526a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI)) {
                    EnumC4050d enumC4050d = EnumC4050d.ASSEMBLE_PUSH_HUAWEI;
                    m13525a(enumC4050d, C4065s.m13601a(this.f14399a, enumC4050d));
                }
                AbstractC4022b.m13359c("hw manager add to list");
            } else if (m13526a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI) && (m13522a = m13522a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m13524a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI);
                m13522a.unregister();
            }
            if (this.f14400a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f14400a.getOpenFCMPush() + " FCM online switch : " + C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + C4054h.m13561b(this.f14399a));
                AbstractC4022b.m13347a(sb2.toString());
            }
            if (this.f14400a.getOpenFCMPush() && C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_FCM) && C4054h.m13561b(this.f14399a)) {
                if (!m13526a(EnumC4050d.ASSEMBLE_PUSH_FCM)) {
                    EnumC4050d enumC4050d2 = EnumC4050d.ASSEMBLE_PUSH_FCM;
                    m13525a(enumC4050d2, C4065s.m13601a(this.f14399a, enumC4050d2));
                }
                AbstractC4022b.m13359c("fcm manager add to list");
            } else if (m13526a(EnumC4050d.ASSEMBLE_PUSH_FCM) && (m13522a2 = m13522a(EnumC4050d.ASSEMBLE_PUSH_FCM)) != null) {
                m13524a(EnumC4050d.ASSEMBLE_PUSH_FCM);
                m13522a2.unregister();
            }
            if (this.f14400a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f14400a.getOpenCOSPush() + " COS online switch : " + C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + C4054h.m13562c(this.f14399a));
                AbstractC4022b.m13347a(sb3.toString());
            }
            if (this.f14400a.getOpenCOSPush() && C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_COS) && C4054h.m13562c(this.f14399a)) {
                EnumC4050d enumC4050d3 = EnumC4050d.ASSEMBLE_PUSH_COS;
                m13525a(enumC4050d3, C4065s.m13601a(this.f14399a, enumC4050d3));
            } else if (m13526a(EnumC4050d.ASSEMBLE_PUSH_COS) && (m13522a3 = m13522a(EnumC4050d.ASSEMBLE_PUSH_COS)) != null) {
                m13524a(EnumC4050d.ASSEMBLE_PUSH_COS);
                m13522a3.unregister();
            }
            if (this.f14400a.getOpenFTOSPush() && C4052f.m13543a(this.f14399a, EnumC4050d.ASSEMBLE_PUSH_FTOS) && C4054h.m13563d(this.f14399a)) {
                EnumC4050d enumC4050d4 = EnumC4050d.ASSEMBLE_PUSH_FTOS;
                m13525a(enumC4050d4, C4065s.m13601a(this.f14399a, enumC4050d4));
            } else {
                if (!m13526a(EnumC4050d.ASSEMBLE_PUSH_FTOS) || (m13522a4 = m13522a(EnumC4050d.ASSEMBLE_PUSH_FTOS)) == null) {
                    return;
                }
                m13524a(EnumC4050d.ASSEMBLE_PUSH_FTOS);
                m13522a4.unregister();
            }
        }
    }
}
