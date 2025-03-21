package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4283hw;
import com.xiaomi.push.C4294ig;
import com.xiaomi.push.service.C4354af;

/* renamed from: com.xiaomi.push.hp */
/* loaded from: classes2.dex */
public class C4276hp {
    /* renamed from: a */
    public static <T extends InterfaceC4277hq<T, ?>> byte[] m15567a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new C4282hv(new C4283hw.a()).m15588a(t);
        } catch (C4281hu e2) {
            AbstractC4022b.m13349a("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static <T extends InterfaceC4277hq<T, ?>> void m15566a(T t, byte[] bArr) {
        if (bArr != null) {
            new C4280ht(new C4294ig.a(true, true, bArr.length)).m15587a(t, bArr);
            return;
        }
        throw new C4281hu("the message byte is empty.");
    }

    /* renamed from: a */
    public static short m15563a(Context context, C4262hb c4262hb) {
        C4252gs m15264a = c4262hb.m15264a();
        return m15565a(context, c4262hb.f16005b, (m15264a == null || m15264a.m15097a() == null) ? null : m15264a.m15097a().get("channel_id"));
    }

    /* renamed from: a */
    public static short m15564a(Context context, String str) {
        return m15565a(context, str, (String) null);
    }

    /* renamed from: a */
    public static short m15565a(Context context, String str, String str2) {
        return (short) (C4233g.m14929a(context, str, false).m14944a() + 0 + (C4075ad.m13696b(context) ? 4 : 0) + (C4075ad.m13695a(context) ? 8 : 0) + (C4354af.m15882a(context) ? 16 : 0) + m15562a(context, str, str2));
    }

    /* renamed from: a */
    private static int m15562a(Context context, String str, String str2) {
        C4354af m15874a;
        NotificationChannel m15886a;
        if (Build.VERSION.SDK_INT < 26 || context == null || TextUtils.isEmpty(str) || (m15874a = C4354af.m15874a(context, str)) == null || (m15886a = m15874a.m15886a(m15874a.m15889a(str2))) == null) {
            return 0;
        }
        return m15886a.getImportance() != 0 ? 32 : 64;
    }
}
