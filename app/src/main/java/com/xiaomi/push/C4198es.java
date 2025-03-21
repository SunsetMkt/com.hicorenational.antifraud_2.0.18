package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4201ev;

/* renamed from: com.xiaomi.push.es */
/* loaded from: classes2.dex */
class C4198es {

    /* renamed from: a */
    private static final boolean f15216a = Log.isLoggable("BCompressed", 3);

    /* renamed from: a */
    static byte[] m14712a(C4197er c4197er, byte[] bArr) {
        try {
            byte[] m14730a = C4201ev.a.m14730a(bArr);
            if (f15216a) {
                AbstractC4022b.m13348a("BCompressed", "decompress " + bArr.length + " to " + m14730a.length + " for " + c4197er);
                if (c4197er.f15210a == 1) {
                    AbstractC4022b.m13348a("BCompressed", "decompress not support upStream");
                }
            }
            return m14730a;
        } catch (Exception e2) {
            AbstractC4022b.m13348a("BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}
