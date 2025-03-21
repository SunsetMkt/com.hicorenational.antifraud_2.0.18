package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bw;

/* loaded from: classes2.dex */
public class bq extends bs {
    public bq(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static bq a(Context context, String str, int i2) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m192a = bw.a(context).m192a(str);
        if (TextUtils.isEmpty(m192a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m192a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new bq(str, sb.toString(), new String[]{String.valueOf(i2)}, "a job build to delete history message");
    }

    private void a(long j2) {
        String[] strArr = ((bw.d) this).f242a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j2);
    }

    @Override // com.xiaomi.push.bw.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a2 = ca.a(m194a());
            long j2 = bo.f224a;
            if (a2 > j2) {
                long j3 = (long) ((((a2 - j2) * 1.2d) / j2) * longValue);
                a(j3);
                bn.a(context).a("begin delete " + j3 + "noUpload messages , because db size is " + a2 + "B");
                super.a(context, obj);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
        }
    }
}
