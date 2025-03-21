package anet.channel.e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class c implements IStrategyListener {
    c() {
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        String str;
        String str2;
        String str3;
        if (dVar == null || dVar.f2012b == null) {
            return;
        }
        int i2 = 0;
        loop0: while (true) {
            l.b[] bVarArr = dVar.f2012b;
            if (i2 >= bVarArr.length) {
                return;
            }
            str = bVarArr[i2].f1997a;
            l.a[] aVarArr = bVarArr[i2].f2004h;
            if (aVarArr != null && aVarArr.length > 0) {
                for (l.a aVar : aVarArr) {
                    String str4 = aVar.f1990b;
                    if (ConnType.HTTP3.equals(str4) || ConnType.HTTP3_PLAIN.equals(str4)) {
                        break loop0;
                    }
                }
            }
            i2++;
        }
        str2 = a.f1744b;
        if (!str.equals(str2)) {
            String unused = a.f1744b = str;
            SharedPreferences.Editor edit = a.f1748f.edit();
            str3 = a.f1744b;
            edit.putString("http3_detector_host", str3);
            edit.apply();
        }
        a.a(NetworkStatusHelper.getStatus());
    }
}
