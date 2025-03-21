package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4096ay;
import com.xiaomi.push.C4254gu;
import com.xiaomi.push.C4255gv;
import com.xiaomi.push.C4256gw;
import com.xiaomi.push.C4260h;
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
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.mipush.sdk.r */
/* loaded from: classes2.dex */
public class C4064r {

    /* renamed from: com.xiaomi.mipush.sdk.r$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14436a = new int[EnumC4239gf.values().length];

        static {
            try {
                f14436a[EnumC4239gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14436a[EnumC4239gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14436a[EnumC4239gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14436a[EnumC4239gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14436a[EnumC4239gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14436a[EnumC4239gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14436a[EnumC4239gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14436a[EnumC4239gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14436a[EnumC4239gf.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14436a[EnumC4239gf.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: a */
    protected static <T extends InterfaceC4277hq<T, ?>> C4262hb m13595a(Context context, T t, EnumC4239gf enumC4239gf) {
        return m13596a(context, t, enumC4239gf, !enumC4239gf.equals(EnumC4239gf.Registration), context.getPackageName(), C4048b.m13476a(context).m13480a());
    }

    /* renamed from: b */
    protected static <T extends InterfaceC4277hq<T, ?>> C4262hb m13600b(Context context, T t, EnumC4239gf enumC4239gf, boolean z, String str, String str2) {
        return m13597a(context, t, enumC4239gf, z, str, str2, false);
    }

    /* renamed from: a */
    protected static <T extends InterfaceC4277hq<T, ?>> C4262hb m13596a(Context context, T t, EnumC4239gf enumC4239gf, boolean z, String str, String str2) {
        return m13597a(context, t, enumC4239gf, z, str, str2, true);
    }

    /* renamed from: a */
    protected static <T extends InterfaceC4277hq<T, ?>> C4262hb m13597a(Context context, T t, EnumC4239gf enumC4239gf, boolean z, String str, String str2, boolean z2) {
        byte[] m15567a = C4276hp.m15567a(t);
        if (m15567a == null) {
            AbstractC4022b.m13347a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        C4262hb c4262hb = new C4262hb();
        if (z) {
            String m13497d = C4048b.m13476a(context).m13497d();
            if (TextUtils.isEmpty(m13497d)) {
                AbstractC4022b.m13347a("regSecret is empty, return null");
                return null;
            }
            try {
                m15567a = C4260h.m15242b(C4096ay.m13840a(m13497d), m15567a);
            } catch (Exception unused) {
                AbstractC4022b.m13361d("encryption error. ");
            }
        }
        C4254gu c4254gu = new C4254gu();
        c4254gu.f15864a = 5L;
        c4254gu.f15865a = "fakeid";
        c4262hb.m15267a(c4254gu);
        c4262hb.m15269a(ByteBuffer.wrap(m15567a));
        c4262hb.m15265a(enumC4239gf);
        c4262hb.m15278b(z2);
        c4262hb.m15277b(str);
        c4262hb.m15270a(z);
        c4262hb.m15268a(str2);
        return c4262hb;
    }

    /* renamed from: a */
    public static InterfaceC4277hq m13598a(Context context, C4262hb c4262hb) {
        byte[] m15276a;
        if (c4262hb.m15281b()) {
            byte[] m13546a = C4052f.m13546a(context, c4262hb, EnumC4050d.ASSEMBLE_PUSH_FCM);
            if (m13546a == null) {
                m13546a = C4096ay.m13840a(C4048b.m13476a(context).m13497d());
            }
            try {
                m15276a = C4260h.m15241a(m13546a, c4262hb.m15276a());
            } catch (Exception e2) {
                throw new C4058l("the aes decrypt failed.", e2);
            }
        } else {
            m15276a = c4262hb.m15276a();
        }
        InterfaceC4277hq m13599a = m13599a(c4262hb.m15263a(), c4262hb.f16006b);
        if (m13599a != null) {
            C4276hp.m15566a(m13599a, m15276a);
        }
        return m13599a;
    }

    /* renamed from: a */
    private static InterfaceC4277hq m13599a(EnumC4239gf enumC4239gf, boolean z) {
        switch (AnonymousClass1.f14436a[enumC4239gf.ordinal()]) {
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
