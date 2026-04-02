package com.taobao.agoo.a.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5954d;

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.f5952b = str2;
        aVar.f5954d = str3;
        aVar.f5955e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.f5952b = str2;
        aVar.f5953c = str3;
        aVar.f5955e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public byte[] a() {
        try {
            String string = new p.a().a(b.JSON_CMD, this.f5955e).a("appKey", this.a).a("deviceId", this.f5952b).a("alias", this.f5953c).a(JSON_PUSH_USER_TOKEN, this.f5954d).a().toString();
            ALog.i("AliasDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.f5952b = str2;
        aVar.f5953c = str3;
        aVar.f5955e = JSON_CMD_SETALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2) {
        a aVar = new a();
        aVar.a = str;
        aVar.f5952b = str2;
        aVar.f5955e = JSON_CMD_REMOVEALLALIAS;
        return aVar.a();
    }
}
