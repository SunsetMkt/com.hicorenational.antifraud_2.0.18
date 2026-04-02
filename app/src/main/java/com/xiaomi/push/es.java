package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.ev;

/* JADX INFO: loaded from: classes2.dex */
class es {
    private static final boolean a = Log.isLoggable("BCompressed", 3);

    static byte[] a(er erVar, byte[] bArr) {
        try {
            byte[] bArrA = ev.a.a(bArr);
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.m49a("BCompressed", "decompress " + bArr.length + " to " + bArrA.length + " for " + erVar);
                if (erVar.f462a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m49a("BCompressed", "decompress not support upStream");
                }
            }
            return bArrA;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m49a("BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}
