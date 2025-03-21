package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4374az;
import com.xiaomi.push.service.C4376ba;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gd */
/* loaded from: classes2.dex */
public class C4237gd {

    /* renamed from: a */
    private static volatile C4237gd f15450a;

    /* renamed from: a */
    private final Context f15451a;

    /* renamed from: a */
    private Map<String, InterfaceC4238ge> f15452a = new HashMap();

    private C4237gd(Context context) {
        this.f15451a = context;
    }

    /* renamed from: a */
    public static C4237gd m14961a(Context context) {
        if (context == null) {
            AbstractC4022b.m13361d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f15450a == null) {
            synchronized (C4237gd.class) {
                if (f15450a == null) {
                    f15450a = new C4237gd(context);
                }
            }
        }
        return f15450a;
    }

    /* renamed from: a */
    public void m14964a(InterfaceC4238ge interfaceC4238ge, String str) {
        if (interfaceC4238ge == null) {
            AbstractC4022b.m13361d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            AbstractC4022b.m13361d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m14963a().put(str, interfaceC4238ge);
        }
    }

    /* renamed from: a */
    InterfaceC4238ge m14962a() {
        InterfaceC4238ge interfaceC4238ge = this.f15452a.get("UPLOADER_PUSH_CHANNEL");
        if (interfaceC4238ge != null) {
            return interfaceC4238ge;
        }
        InterfaceC4238ge interfaceC4238ge2 = this.f15452a.get("UPLOADER_HTTP");
        if (interfaceC4238ge2 != null) {
            return interfaceC4238ge2;
        }
        return null;
    }

    /* renamed from: a */
    Map<String, InterfaceC4238ge> m14963a() {
        return this.f15452a;
    }

    /* renamed from: a */
    public boolean m14965a(C4243gj c4243gj, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC4022b.m13347a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (C4374az.m16043a(c4243gj, false)) {
            return false;
        }
        if (TextUtils.isEmpty(c4243gj.m15001d())) {
            c4243gj.m15006f(C4374az.m16040a());
        }
        c4243gj.m15008g(str);
        C4376ba.m16052a(this.f15451a, c4243gj);
        return true;
    }
}
