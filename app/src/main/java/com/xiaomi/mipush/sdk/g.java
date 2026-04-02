package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gk;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static HashMap<d, a> a = new HashMap<>();

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[d.values().length];

        static {
            try {
                a[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static class a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8720b;

        public a(String str, String str2) {
            this.a = str;
            this.f8720b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            a.put(dVar, aVar);
        }
    }

    public static a a(d dVar) {
        return a.get(dVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static gk m100a(d dVar) {
        return gk.AggregatePushSwitch;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static v m99a(d dVar) {
        int i2 = AnonymousClass1.a[dVar.ordinal()];
        if (i2 == 1) {
            return v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i2 == 2) {
            return v.UPLOAD_FCM_TOKEN;
        }
        if (i2 == 3) {
            return v.UPLOAD_COS_TOKEN;
        }
        if (i2 != 4) {
            return null;
        }
        return v.UPLOAD_FTOS_TOKEN;
    }
}
