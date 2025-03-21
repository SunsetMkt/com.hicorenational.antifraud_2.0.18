package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* renamed from: com.xiaomi.push.cs */
/* loaded from: classes2.dex */
public class C4144cs {

    /* renamed from: com.xiaomi.push.cs$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14790a = new int[EnumC4239gf.values().length];

        static {
            try {
                f14790a[EnumC4239gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14790a[EnumC4239gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14790a[EnumC4239gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14790a[EnumC4239gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14790a[EnumC4239gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14790a[EnumC4239gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14790a[EnumC4239gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14790a[EnumC4239gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14790a[EnumC4239gf.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14790a[EnumC4239gf.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14790a[EnumC4239gf.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14790a[EnumC4239gf.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: a */
    public static int m14179a(InterfaceC4277hq interfaceC4277hq, EnumC4239gf enumC4239gf) {
        int m14513a;
        switch (AnonymousClass1.f14790a[enumC4239gf.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return C4171ds.m14513a(enumC4239gf.m14968a());
            case 11:
                m14513a = C4171ds.m14513a(enumC4239gf.m14968a());
                if (interfaceC4277hq != null) {
                    try {
                        if (interfaceC4277hq instanceof C4256gw) {
                            String str = ((C4256gw) interfaceC4277hq).f15931d;
                            if (!TextUtils.isEmpty(str) && C4171ds.m14514a(C4171ds.m14521a(str)) != -1) {
                                m14513a = C4171ds.m14514a(C4171ds.m14521a(str));
                                break;
                            }
                        } else if (interfaceC4277hq instanceof C4265he) {
                            String str2 = ((C4265he) interfaceC4277hq).f16039d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (C4171ds.m14514a(C4171ds.m14521a(str2)) != -1) {
                                    m14513a = C4171ds.m14514a(C4171ds.m14521a(str2));
                                }
                                if (EnumC4249gp.UploadTinyData.equals(C4171ds.m14521a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        AbstractC4022b.m13361d("PERF_ERROR : parse Notification type error");
                        return m14513a;
                    }
                }
                break;
            case 12:
                m14513a = C4171ds.m14513a(enumC4239gf.m14968a());
                if (interfaceC4277hq != null) {
                    try {
                        if (interfaceC4277hq instanceof C4261ha) {
                            String m15250b = ((C4261ha) interfaceC4277hq).m15250b();
                            if (!TextUtils.isEmpty(m15250b) && EnumC4183ed.m14594a(m15250b) != -1) {
                                m14513a = EnumC4183ed.m14594a(m15250b);
                                break;
                            }
                        } else if (interfaceC4277hq instanceof C4259gz) {
                            String m15219a = ((C4259gz) interfaceC4277hq).m15219a();
                            if (!TextUtils.isEmpty(m15219a) && EnumC4183ed.m14594a(m15219a) != -1) {
                                return EnumC4183ed.m14594a(m15219a);
                            }
                        }
                    } catch (Exception unused2) {
                        AbstractC4022b.m13361d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return m14513a;
    }

    /* renamed from: a */
    public static int m14177a(Context context, int i2) {
        int m14908a = C4232fz.m14908a(context);
        if (-1 == m14908a) {
            return -1;
        }
        return (i2 * (m14908a == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a */
    public static int m14178a(EnumC4239gf enumC4239gf) {
        return C4171ds.m14513a(enumC4239gf.m14968a());
    }

    /* renamed from: a */
    public static void m14183a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        C4262hb c4262hb = new C4262hb();
        try {
            C4276hp.m15566a(c4262hb, bArr);
            m14181a(str, context, c4262hb, bArr.length);
        } catch (C4281hu unused) {
            AbstractC4022b.m13347a("fail to convert bytes to container");
        }
    }

    /* renamed from: a */
    public static void m14181a(String str, Context context, C4262hb c4262hb, int i2) {
        EnumC4239gf m15263a;
        if (context == null || c4262hb == null || (m15263a = c4262hb.m15263a()) == null) {
            return;
        }
        int m14178a = m14178a(m15263a);
        if (i2 <= 0) {
            byte[] m15567a = C4276hp.m15567a(c4262hb);
            i2 = m15567a != null ? m15567a.length : 0;
        }
        m14180a(str, context, m14178a, i2);
    }

    /* renamed from: a */
    public static void m14180a(String str, Context context, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int m14177a = m14177a(context, i3);
        if (i2 != C4171ds.m14514a(EnumC4249gp.UploadTinyData)) {
            C4172dt.m14529a(context.getApplicationContext()).m14531a(str, i2, 1L, m14177a);
        }
    }

    /* renamed from: a */
    public static void m14182a(String str, Context context, InterfaceC4277hq interfaceC4277hq, EnumC4239gf enumC4239gf, int i2) {
        m14180a(str, context, m14179a(interfaceC4277hq, enumC4239gf), i2);
    }
}
