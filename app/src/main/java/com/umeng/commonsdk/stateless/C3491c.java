package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.C3494b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* renamed from: com.umeng.commonsdk.stateless.c */
/* loaded from: classes2.dex */
public class C3491c {

    /* renamed from: a */
    private String f12705a = "10.0.0.172";

    /* renamed from: b */
    private int f12706b = 80;

    /* renamed from: c */
    private Context f12707c;

    public C3491c(Context context) {
        this.f12707c = context;
    }

    /* renamed from: a */
    private void m11696a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f12707c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        C3489a.f12689i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    /* renamed from: b */
    private void m11697b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f12707c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f12707c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            C3489a.f12688h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            C3489a.f12691k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        C3489a.f12689i = C3489a.f12691k;
        if (TextUtils.isEmpty(C3494b.f12716b)) {
            return;
        }
        if (C3494b.f12716b.startsWith(AbstractC1191a.f2512K) || C3494b.f12716b.startsWith("461")) {
            C3489a.f12689i = C3489a.f12688h;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0100, code lost:
    
        if (r11 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0102, code lost:
    
        com.umeng.commonsdk.debug.UMRTLog.m11555e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m11698a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.C3491c.m11698a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
