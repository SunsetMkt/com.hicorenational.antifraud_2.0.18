package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f10860a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f10861b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f10862c;

    public c(Context context) {
        this.f10862c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f10862c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f10844i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f10862c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f10862c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f10843h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f10846k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f10844i = a.f10846k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f10870b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f10870b.startsWith(c.c.a.b.a.a.K) || com.umeng.commonsdk.statistics.b.f10870b.startsWith("461")) {
            a.f10844i = a.f10843h;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0100, code lost:
    
        if (r11 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0102, code lost:
    
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x012c, code lost:
    
        if (r11 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011b, code lost:
    
        if (r11 == null) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String, javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
