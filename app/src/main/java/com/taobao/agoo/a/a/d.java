package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5969c;

    public byte[] a() {
        try {
            p.a aVar = new p.a();
            aVar.a(b.JSON_CMD, this.f5955e).a("appKey", this.a);
            if (TextUtils.isEmpty(this.f5968b)) {
                aVar.a("utdid", this.f5969c);
            } else {
                aVar.a("deviceId", this.f5968b);
            }
            String string = aVar.a().toString();
            ALog.i("SwitchDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z) {
        d dVar = new d();
        dVar.a = str;
        dVar.f5968b = str2;
        dVar.f5969c = str3;
        if (z) {
            dVar.f5955e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.f5955e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
