package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.dm */
/* loaded from: classes2.dex */
public class C4165dm extends AbstractC4164dl {
    public C4165dm(Context context, int i2) {
        super(context, i2);
    }

    @Override // com.xiaomi.push.AbstractC4164dl
    /* renamed from: a */
    public EnumC4241gh mo14301a() {
        return EnumC4241gh.Storage;
    }

    @Override // com.xiaomi.push.C4076ae.a
    /* renamed from: a */
    public String mo13391a() {
        return "23";
    }

    @Override // com.xiaomi.push.AbstractC4164dl
    /* renamed from: b */
    public String mo14303b() {
        return "ram:" + C4287i.m15632a() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + C4287i.m15642b() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "ramOriginal:" + C4287i.m15646c() + Constants.ACCEPT_TIME_SEPARATOR_SP + "romOriginal:" + C4287i.m15649d();
    }
}
