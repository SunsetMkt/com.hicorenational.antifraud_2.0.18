package com.xiaomi.mipush.sdk;

import com.xiaomi.push.EnumC4244gk;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.g */
/* loaded from: classes2.dex */
public class C4053g {

    /* renamed from: a */
    private static HashMap<EnumC4050d, a> f14409a = new HashMap<>();

    /* renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14410a = new int[EnumC4050d.values().length];

        static {
            try {
                f14410a[EnumC4050d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14410a[EnumC4050d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14410a[EnumC4050d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14410a[EnumC4050d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.g$a */
    static class a {

        /* renamed from: a */
        public String f14411a;

        /* renamed from: b */
        public String f14412b;

        public a(String str, String str2) {
            this.f14411a = str;
            this.f14412b = str2;
        }
    }

    static {
        m13557a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        m13557a(EnumC4050d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        m13557a(EnumC4050d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        m13557a(EnumC4050d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    /* renamed from: a */
    private static void m13557a(EnumC4050d enumC4050d, a aVar) {
        if (aVar != null) {
            f14409a.put(enumC4050d, aVar);
        }
    }

    /* renamed from: a */
    public static a m13554a(EnumC4050d enumC4050d) {
        return f14409a.get(enumC4050d);
    }

    /* renamed from: a */
    public static EnumC4244gk m13556a(EnumC4050d enumC4050d) {
        return EnumC4244gk.AggregatePushSwitch;
    }

    /* renamed from: a */
    public static EnumC4068v m13555a(EnumC4050d enumC4050d) {
        int i2 = AnonymousClass1.f14410a[enumC4050d.ordinal()];
        if (i2 == 1) {
            return EnumC4068v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i2 == 2) {
            return EnumC4068v.UPLOAD_FCM_TOKEN;
        }
        if (i2 == 3) {
            return EnumC4068v.UPLOAD_COS_TOKEN;
        }
        if (i2 != 4) {
            return null;
        }
        return EnumC4068v.UPLOAD_FTOS_TOKEN;
    }
}
