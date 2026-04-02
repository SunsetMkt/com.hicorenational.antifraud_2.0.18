package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;

/* JADX INFO: loaded from: classes2.dex */
public class bc {

    /* JADX INFO: renamed from: com.xiaomi.push.service.bc$1 */
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
                a[gf.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[gf.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static hq a(Context context, hb hbVar) {
        if (hbVar.m535b()) {
            return null;
        }
        byte[] bArrM533a = hbVar.m533a();
        hq hqVarA = a(hbVar.a(), hbVar.f725b);
        if (hqVarA != null) {
            hp.a(hqVarA, bArrM533a);
        }
        return hqVarA;
    }

    private static hq a(gf gfVar, boolean z) {
        switch (AnonymousClass1.a[gfVar.ordinal()]) {
            case 1:
                return new hg();
            case 2:
                return new hm();
            case 3:
                return new hk();
            case 4:
                return new ho();
            case 5:
                return new hi();
            case 6:
                return new gv();
            case 7:
                return new ha();
            case 8:
                return new hh();
            case 9:
                if (z) {
                    return new he();
                }
                gw gwVar = new gw();
                gwVar.a(true);
                return gwVar;
            case 10:
                return new ha();
            default:
                return null;
        }
    }
}
