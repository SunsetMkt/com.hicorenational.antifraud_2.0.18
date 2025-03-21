package anet.channel.p021e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.IStrategyListener;

/* compiled from: Taobao */
/* renamed from: anet.channel.e.c */
/* loaded from: classes.dex */
final class C0776c implements IStrategyListener {
    C0776c() {
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(C0842l.d dVar) {
        String str;
        String str2;
        String str3;
        if (dVar == null || dVar.f1132b == null) {
            return;
        }
        int i2 = 0;
        loop0: while (true) {
            C0842l.b[] bVarArr = dVar.f1132b;
            if (i2 >= bVarArr.length) {
                return;
            }
            str = bVarArr[i2].f1117a;
            C0842l.a[] aVarArr = bVarArr[i2].f1124h;
            if (aVarArr != null && aVarArr.length > 0) {
                for (C0842l.a aVar : aVarArr) {
                    String str4 = aVar.f1110b;
                    if (ConnType.HTTP3.equals(str4) || ConnType.HTTP3_PLAIN.equals(str4)) {
                        break loop0;
                    }
                }
            }
            i2++;
        }
        str2 = C0774a.f818b;
        if (!str.equals(str2)) {
            String unused = C0774a.f818b = str;
            SharedPreferences.Editor edit = C0774a.f822f.edit();
            str3 = C0774a.f818b;
            edit.putString("http3_detector_host", str3);
            edit.apply();
        }
        C0774a.m494a(NetworkStatusHelper.getStatus());
    }
}
