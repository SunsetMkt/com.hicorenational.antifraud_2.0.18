package com.taobao.agoo.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.o;
import com.taobao.accs.utl.p;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5958d = String.valueOf(221);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f5964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f5965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f5966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f5967n;
    public String o;
    public String p;

    public byte[] a() {
        try {
            String string = new p.a().a(b.JSON_CMD, this.f5955e).a("appKey", this.a).a("utdid", this.f5956b).a("appVersion", this.f5957c).a("sdkVersion", this.f5958d).a(Constants.KEY_TTID, this.f5959f).a(Constants.KEY_PACKAGE_NAME, this.f5960g).a("notifyEnable", this.f5961h).a("romInfo", this.f5962i).a("c0", this.f5963j).a("c1", this.f5964k).a("c2", this.f5965l).a("c3", this.f5966m).a("c4", this.f5967n).a("c5", this.o).a("c6", this.p).a().toString();
            ALog.i("RegisterDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(Context context, String str, String str2) {
        c cVar;
        String strJ;
        String packageName;
        String str3;
        try {
            strJ = UtilityImpl.j(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strJ) && !TextUtils.isEmpty(str3)) {
            cVar = new c();
            try {
                cVar.f5955e = "register";
                cVar.a = str;
                cVar.f5956b = strJ;
                cVar.f5957c = str3;
                cVar.f5959f = str2;
                cVar.f5960g = packageName;
                cVar.f5963j = Build.BRAND;
                cVar.f5964k = Build.MODEL;
                cVar.f5961h = j.c(context);
                UtilityImpl.a(context, Constants.SP_CHANNEL_FILE_NAME, cVar.f5961h);
                cVar.f5962i = new o().a();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (cVar == null) {
                        return null;
                    }
                } finally {
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            return cVar.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", "appKey", str, "utdid", strJ, "appVersion", str3);
        return null;
    }
}
