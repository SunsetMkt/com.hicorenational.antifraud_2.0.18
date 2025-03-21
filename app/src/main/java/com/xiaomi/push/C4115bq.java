package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4121bw;

/* renamed from: com.xiaomi.push.bq */
/* loaded from: classes2.dex */
public class C4115bq extends C4117bs {
    public C4115bq(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    /* renamed from: a */
    public static C4115bq m13945a(Context context, String str, int i2) {
        AbstractC4022b.m13356b("delete  messages when db size is too bigger");
        String m13960a = C4121bw.m13957a(context).m13960a(str);
        if (TextUtils.isEmpty(m13960a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m13960a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new C4115bq(str, sb.toString(), new String[]{String.valueOf(i2)}, "a job build to delete history message");
    }

    /* renamed from: a */
    private void m13946a(long j2) {
        String[] strArr = ((C4121bw.d) this).f14688a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j2);
    }

    @Override // com.xiaomi.push.C4121bw.a
    /* renamed from: a */
    public void mo13947a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long m14027a = C4126ca.m14027a(m13966a());
            long j2 = C4113bo.f14654a;
            if (m14027a > j2) {
                long j3 = (long) ((((m14027a - j2) * 1.2d) / j2) * longValue);
                m13946a(j3);
                C4112bn.m13932a(context).m13942a("begin delete " + j3 + "noUpload messages , because db size is " + m14027a + "B");
                super.mo13947a(context, obj);
                return;
            }
            AbstractC4022b.m13356b("db size is suitable");
        }
    }
}
