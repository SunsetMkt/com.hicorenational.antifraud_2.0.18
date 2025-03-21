package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class cs {

    /* renamed from: com.xiaomi.push.cs$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12590a = new int[gf.values().length];

        static {
            try {
                f12590a[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12590a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12590a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12590a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12590a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12590a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12590a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12590a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12590a[gf.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12590a[gf.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12590a[gf.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12590a[gf.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a(hq hqVar, gf gfVar) {
        int a2;
        switch (AnonymousClass1.f12590a[gfVar.ordinal()]) {
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
                return ds.a(gfVar.a());
            case 11:
                a2 = ds.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof gw) {
                            String str = ((gw) hqVar).f682d;
                            if (!TextUtils.isEmpty(str) && ds.a(ds.m356a(str)) != -1) {
                                a2 = ds.a(ds.m356a(str));
                                break;
                            }
                        } else if (hqVar instanceof he) {
                            String str2 = ((he) hqVar).f741d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (ds.a(ds.m356a(str2)) != -1) {
                                    a2 = ds.a(ds.m356a(str2));
                                }
                                if (gp.UploadTinyData.equals(ds.m356a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return a2;
                    }
                }
                break;
            case 12:
                a2 = ds.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof ha) {
                            String b2 = ((ha) hqVar).b();
                            if (!TextUtils.isEmpty(b2) && ed.a(b2) != -1) {
                                a2 = ed.a(b2);
                                break;
                            }
                        } else if (hqVar instanceof gz) {
                            String a3 = ((gz) hqVar).a();
                            if (!TextUtils.isEmpty(a3) && ed.a(a3) != -1) {
                                return ed.a(a3);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a2;
    }

    public static int a(Context context, int i2) {
        int a2 = fz.a(context);
        if (-1 == a2) {
            return -1;
        }
        return (i2 * (a2 == 0 ? 13 : 11)) / 10;
    }

    public static int a(gf gfVar) {
        return ds.a(gfVar.a());
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            a(str, context, hbVar, bArr.length);
        } catch (hu unused) {
            com.xiaomi.channel.commonutils.logger.b.m50a("fail to convert bytes to container");
        }
    }

    public static void a(String str, Context context, hb hbVar, int i2) {
        gf a2;
        if (context == null || hbVar == null || (a2 = hbVar.a()) == null) {
            return;
        }
        int a3 = a(a2);
        if (i2 <= 0) {
            byte[] a4 = hp.a(hbVar);
            i2 = a4 != null ? a4.length : 0;
        }
        a(str, context, a3, i2);
    }

    public static void a(String str, Context context, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int a2 = a(context, i3);
        if (i2 != ds.a(gp.UploadTinyData)) {
            dt.a(context.getApplicationContext()).a(str, i2, 1L, a2);
        }
    }

    public static void a(String str, Context context, hq hqVar, gf gfVar, int i2) {
        a(str, context, a(hqVar, gfVar), i2);
    }
}
