package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* renamed from: com.xiaomi.push.ce */
/* loaded from: classes2.dex */
public final class C4130ce {

    /* renamed from: a */
    private int f14717a;

    /* renamed from: a */
    private String f14718a;

    public C4130ce(String str, int i2) {
        this.f14718a = str;
        this.f14717a = i2;
    }

    /* renamed from: a */
    public int m14063a() {
        return this.f14717a;
    }

    public String toString() {
        if (this.f14717a <= 0) {
            return this.f14718a;
        }
        return this.f14718a + Constants.COLON_SEPARATOR + this.f14717a;
    }

    /* renamed from: a */
    public String m14064a() {
        return this.f14718a;
    }

    /* renamed from: a */
    public static C4130ce m14061a(String str, int i2) {
        String str2;
        int lastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i2 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
        } else {
            str2 = str;
        }
        return new C4130ce(str2, i2);
    }

    /* renamed from: a */
    public static InetSocketAddress m14062a(String str, int i2) {
        C4130ce m14061a = m14061a(str, i2);
        return new InetSocketAddress(m14061a.m14064a(), m14061a.m14063a());
    }
}
