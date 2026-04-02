package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class cs {

    /* JADX INFO: renamed from: com.xiaomi.push.cs$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[gf.values().length];

        static {
            try {
                a[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[gf.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[gf.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[gf.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[gf.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static int a(hq hqVar, gf gfVar) {
        int iA;
        switch (AnonymousClass1.a[gfVar.ordinal()]) {
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
                iA = ds.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof gw) {
                            String str = ((gw) hqVar).f682d;
                            if (!TextUtils.isEmpty(str) && ds.a(ds.m354a(str)) != -1) {
                                iA = ds.a(ds.m354a(str));
                            }
                        } else if (hqVar instanceof he) {
                            String str2 = ((he) hqVar).f741d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (ds.a(ds.m354a(str2)) != -1) {
                                    iA = ds.a(ds.m354a(str2));
                                }
                                if (gp.UploadTinyData.equals(ds.m354a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
                        return iA;
                    }
                }
                break;
            case 12:
                iA = ds.a(gfVar.a());
                if (hqVar != null) {
                    try {
                        if (hqVar instanceof ha) {
                            String strB = ((ha) hqVar).b();
                            if (!TextUtils.isEmpty(strB) && ed.a(strB) != -1) {
                                iA = ed.a(strB);
                            }
                        } else if (hqVar instanceof gz) {
                            String strA = ((gz) hqVar).a();
                            if (!TextUtils.isEmpty(strA) && ed.a(strA) != -1) {
                                return ed.a(strA);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
                    }
                }
                break;
            default:
                return -1;
        }
        return iA;
    }

    public static int a(Context context, int i2) {
        int iA = fz.a(context);
        if (-1 == iA) {
            return -1;
        }
        return (i2 * (iA == 0 ? 13 : 11)) / 10;
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
            com.xiaomi.channel.commonutils.logger.b.m48a("fail to convert bytes to container");
        }
    }

    public static void a(String str, Context context, hb hbVar, int i2) {
        gf gfVarA;
        if (context == null || hbVar == null || (gfVarA = hbVar.a()) == null) {
            return;
        }
        int iA = a(gfVarA);
        if (i2 <= 0) {
            byte[] bArrA = hp.a(hbVar);
            i2 = bArrA != null ? bArrA.length : 0;
        }
        a(str, context, iA, i2);
    }

    public static void a(String str, Context context, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int iA = a(context, i3);
        if (i2 != ds.a(gp.UploadTinyData)) {
            dt.a(context.getApplicationContext()).a(str, i2, 1L, iA);
        }
    }

    public static void a(String str, Context context, hq hqVar, gf gfVar, int i2) {
        a(str, context, a(hqVar, gfVar), i2);
    }
}
