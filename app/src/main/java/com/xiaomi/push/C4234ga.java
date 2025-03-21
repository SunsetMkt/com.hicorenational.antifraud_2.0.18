package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* renamed from: com.xiaomi.push.ga */
/* loaded from: classes2.dex */
public class C4234ga implements XMPushService.InterfaceC4341n {

    /* renamed from: a */
    private static boolean f15443a = false;

    /* renamed from: a */
    private int f15444a;

    /* renamed from: a */
    private Context f15445a;

    /* renamed from: b */
    private boolean f15446b;

    public C4234ga(Context context) {
        this.f15445a = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.InterfaceC4341n
    /* renamed from: a */
    public void mo14950a() {
        m14946a(this.f15445a);
        if (this.f15446b && m14948a()) {
            AbstractC4022b.m13347a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            InterfaceC4238ge m14962a = C4237gd.m14961a(this.f15445a).m14962a();
            if (m14949a(m14962a)) {
                f15443a = true;
                C4235gb.m14952a(this.f15445a, m14962a);
            } else {
                AbstractC4022b.m13347a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    private void m14946a(Context context) {
        this.f15446b = C4356ah.m15923a(context).m15935a(EnumC4244gk.TinyDataUploadSwitch.m15014a(), true);
        this.f15444a = C4356ah.m15923a(context).m15927a(EnumC4244gk.TinyDataUploadFrequency.m15014a(), 7200);
        this.f15444a = Math.max(60, this.f15444a);
    }

    /* renamed from: a */
    private boolean m14948a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f15445a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f15444a);
    }

    /* renamed from: a */
    private boolean m14949a(InterfaceC4238ge interfaceC4238ge) {
        if (!C4092au.m13799a(this.f15445a) || interfaceC4238ge == null || TextUtils.isEmpty(m14945a(this.f15445a.getPackageName())) || !new File(this.f15445a.getFilesDir(), "tiny_data.data").exists() || f15443a) {
            return false;
        }
        return !C4356ah.m15923a(this.f15445a).m15935a(EnumC4244gk.ScreenOnOrChargingTinyDataUploadSwitch.m15014a(), false) || C4287i.m15638a(this.f15445a) || C4287i.m15644b(this.f15445a);
    }

    /* renamed from: a */
    private String m14945a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f15445a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    /* renamed from: a */
    public static void m14947a(boolean z) {
        f15443a = z;
    }
}
