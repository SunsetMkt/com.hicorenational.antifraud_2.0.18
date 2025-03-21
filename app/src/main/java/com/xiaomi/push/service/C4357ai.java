package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4248go;
import com.xiaomi.push.C4250gq;
import com.xiaomi.push.C4263hc;
import com.xiaomi.push.C4264hd;
import com.xiaomi.push.C4411z;
import com.xiaomi.push.EnumC4245gl;
import com.xiaomi.push.EnumC4246gm;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ai */
/* loaded from: classes2.dex */
public class C4357ai {

    /* renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f16535a;

        /* renamed from: b */
        static final /* synthetic */ int[] f16536b = new int[EnumC4246gm.values().length];

        static {
            try {
                f16536b[EnumC4246gm.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16536b[EnumC4246gm.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16536b[EnumC4246gm.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16536b[EnumC4246gm.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f16535a = new int[EnumC4245gl.values().length];
            try {
                f16535a[EnumC4245gl.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16535a[EnumC4245gl.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: a */
    public static void m15940a(C4356ah c4356ah, C4264hd c4264hd) {
        AbstractC4022b.m13358b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", c4356ah, ", configMessage=", c4264hd);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C4248go c4248go : c4264hd.m15295a()) {
            arrayList.add(new Pair<>(c4248go.m15031a(), Integer.valueOf(c4248go.m15029a())));
            List<Pair<Integer, Object>> m15938a = m15938a(c4248go.f15706a, false);
            if (!C4411z.m16370a(m15938a)) {
                arrayList2.addAll(m15938a);
            }
        }
        c4356ah.m15934a(arrayList, arrayList2);
        c4356ah.m15936b();
    }

    /* renamed from: a */
    public static void m15939a(C4356ah c4356ah, C4263hc c4263hc) {
        AbstractC4022b.m13358b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", c4356ah, ", configMessage=", c4263hc);
        c4356ah.m15933a(m15938a(c4263hc.m15290a(), true));
        c4356ah.m15936b();
    }

    /* renamed from: a */
    public static int m15937a(C4356ah c4356ah, EnumC4245gl enumC4245gl) {
        int i2 = 0;
        if (AnonymousClass1.f16535a[enumC4245gl.ordinal()] == 1) {
            i2 = 1;
        }
        return c4356ah.m15928a(enumC4245gl, i2);
    }

    /* renamed from: a */
    private static List<Pair<Integer, Object>> m15938a(List<C4250gq> list, boolean z) {
        Pair pair;
        if (C4411z.m16370a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C4250gq c4250gq : list) {
            int m15038a = c4250gq.m15038a();
            EnumC4246gm m15017a = EnumC4246gm.m15017a(c4250gq.m15046b());
            if (m15017a != null) {
                if (z && c4250gq.f15782a) {
                    arrayList.add(new Pair(Integer.valueOf(m15038a), null));
                } else {
                    int i2 = AnonymousClass1.f16536b[m15017a.ordinal()];
                    if (i2 == 1) {
                        pair = new Pair(Integer.valueOf(m15038a), Integer.valueOf(c4250gq.m15049c()));
                    } else if (i2 == 2) {
                        pair = new Pair(Integer.valueOf(m15038a), Long.valueOf(c4250gq.m15040a()));
                    } else if (i2 != 3) {
                        pair = i2 != 4 ? null : new Pair(Integer.valueOf(m15038a), Boolean.valueOf(c4250gq.m15058g()));
                    } else {
                        pair = new Pair(Integer.valueOf(m15038a), c4250gq.m15041a());
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }
}
