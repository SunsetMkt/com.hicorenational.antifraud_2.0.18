package com.umeng.p221ut.p226b.p227a.p228a;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
import p324i.p325a.p326a.p327a.C5758c;

/* renamed from: com.umeng.ut.b.a.a.a */
/* loaded from: classes2.dex */
public class C3811a {

    /* renamed from: d */
    static final /* synthetic */ boolean f13875d = !C3811a.class.desiredAssertionStatus();

    /* renamed from: com.umeng.ut.b.a.a.a$a */
    static abstract class a {

        /* renamed from: a */
        public byte[] f13876a;

        /* renamed from: b */
        public int f13877b;

        a() {
        }
    }

    /* renamed from: com.umeng.ut.b.a.a.a$b */
    static class b extends a {

        /* renamed from: c */
        int f13881c;
        private int count;

        /* renamed from: d */
        private final byte[] f13882d;

        /* renamed from: e */
        public final boolean f13883e;

        /* renamed from: e */
        private final byte[] f13884e;

        /* renamed from: f */
        public final boolean f13885f;

        /* renamed from: g */
        public final boolean f13886g;

        /* renamed from: d */
        static final /* synthetic */ boolean f13880d = !C3811a.class.desiredAssertionStatus();

        /* renamed from: b */
        private static final byte[] f13878b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: c */
        private static final byte[] f13879c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        public b(int i2, byte[] bArr) {
            this.f13876a = bArr;
            this.f13883e = (i2 & 1) == 0;
            this.f13885f = (i2 & 2) == 0;
            this.f13886g = (i2 & 4) != 0;
            this.f13884e = (i2 & 8) == 0 ? f13878b : f13879c;
            this.f13882d = new byte[2];
            this.f13881c = 0;
            this.count = this.f13885f ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e9 A[SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean m12793a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 528
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.p221ut.p226b.p227a.p228a.C3811a.b.m12793a(byte[], int, int, boolean):boolean");
        }
    }

    private C3811a() {
    }

    /* renamed from: a */
    public static String m12790a(byte[] bArr, int i2) {
        try {
            return new String(m12791a(bArr, i2), C5758c.f20751b);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a */
    public static byte[] m12791a(byte[] bArr, int i2) {
        return m12792a(bArr, 0, bArr.length, i2);
    }

    @SuppressLint({"Assert"})
    /* renamed from: a */
    public static byte[] m12792a(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, null);
        int i5 = (i3 / 3) * 4;
        if (bVar.f13883e) {
            if (i3 % 3 > 0) {
                i5 += 4;
            }
        } else {
            int i6 = i3 % 3;
            if (i6 != 0) {
                if (i6 == 1) {
                    i5 += 2;
                } else if (i6 == 2) {
                    i5 += 3;
                }
            }
        }
        if (bVar.f13885f && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (bVar.f13886g ? 2 : 1);
        }
        bVar.f13876a = new byte[i5];
        bVar.m12793a(bArr, i2, i3, true);
        if (f13875d || bVar.f13877b == i5) {
            return bVar.f13876a;
        }
        throw new AssertionError();
    }
}
