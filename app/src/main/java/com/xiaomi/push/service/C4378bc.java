package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.C4255gv;
import com.xiaomi.push.C4256gw;
import com.xiaomi.push.C4261ha;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4267hg;
import com.xiaomi.push.C4268hh;
import com.xiaomi.push.C4269hi;
import com.xiaomi.push.C4271hk;
import com.xiaomi.push.C4273hm;
import com.xiaomi.push.C4275ho;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.InterfaceC4277hq;

/* renamed from: com.xiaomi.push.service.bc */
/* loaded from: classes2.dex */
public class C4378bc {

    /* renamed from: com.xiaomi.push.service.bc$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16690a = new int[EnumC4239gf.values().length];

        static {
            try {
                f16690a[EnumC4239gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16690a[EnumC4239gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16690a[EnumC4239gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16690a[EnumC4239gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16690a[EnumC4239gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16690a[EnumC4239gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16690a[EnumC4239gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16690a[EnumC4239gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16690a[EnumC4239gf.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16690a[EnumC4239gf.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC4277hq m16068a(Context context, C4262hb c4262hb) {
        if (c4262hb.m15281b()) {
            return null;
        }
        byte[] m15276a = c4262hb.m15276a();
        InterfaceC4277hq m16069a = m16069a(c4262hb.m15263a(), c4262hb.f16006b);
        if (m16069a != null) {
            C4276hp.m15566a(m16069a, m15276a);
        }
        return m16069a;
    }

    /* renamed from: a */
    private static InterfaceC4277hq m16069a(EnumC4239gf enumC4239gf, boolean z) {
        switch (AnonymousClass1.f16690a[enumC4239gf.ordinal()]) {
            case 1:
                return new C4267hg();
            case 2:
                return new C4273hm();
            case 3:
                return new C4271hk();
            case 4:
                return new C4275ho();
            case 5:
                return new C4269hi();
            case 6:
                return new C4255gv();
            case 7:
                return new C4261ha();
            case 8:
                return new C4268hh();
            case 9:
                if (z) {
                    return new C4265he();
                }
                C4256gw c4256gw = new C4256gw();
                c4256gw.m15186a(true);
                return c4256gw;
            case 10:
                return new C4261ha();
            default:
                return null;
        }
    }
}
