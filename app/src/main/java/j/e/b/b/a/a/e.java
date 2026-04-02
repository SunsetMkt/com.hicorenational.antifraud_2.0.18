package j.e.b.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class e extends BroadcastReceiver {
    e() {
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean zContains = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        f.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            if (TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                zContains = true;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra != null) {
                zContains = stringArrayListExtra.contains(context.getPackageName());
            }
        } else if (intExtra == 0) {
        }
        if (zContains) {
            String stringExtra = intent.getStringExtra("openIdType");
            f fVarA = f.a();
            a aVar = "oaid".equals(stringExtra) ? fVarA.f12571b : "vaid".equals(stringExtra) ? fVarA.f12573d : "aaid".equals(stringExtra) ? fVarA.f12572c : "udid".equals(stringExtra) ? fVarA.a : null;
            if (aVar == null) {
                return;
            }
            aVar.b();
        }
    }
}
