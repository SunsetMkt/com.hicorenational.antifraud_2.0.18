package com.umeng.analytics.filter;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p286h.C5230f1;

/* compiled from: SmartDict.java */
/* renamed from: com.umeng.analytics.filter.d */
/* loaded from: classes2.dex */
public class C3315d {

    /* renamed from: b */
    private static final String f11406b = "Ă";

    /* renamed from: c */
    private MessageDigest f11408c;

    /* renamed from: e */
    private boolean f11410e;

    /* renamed from: a */
    private final String f11407a = "MD5";

    /* renamed from: d */
    private Set<Object> f11409d = new HashSet();

    public C3315d(boolean z, String str) {
        int i2 = 0;
        this.f11410e = false;
        this.f11410e = z;
        try {
            this.f11408c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (!z) {
                String[] split = str.split(f11406b);
                int length = split.length;
                while (i2 < length) {
                    this.f11409d.add(split[i2]);
                    i2++;
                }
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i2 < decode.length / 4) {
                    int i3 = i2 * 4;
                    this.f11409d.add(Integer.valueOf(((decode[i3 + 0] & C5230f1.f20085c) << 24) + ((decode[i3 + 1] & C5230f1.f20085c) << 16) + ((decode[i3 + 2] & C5230f1.f20085c) << 8) + (decode[i3 + 3] & C5230f1.f20085c)));
                    i2++;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private Integer m10794c(String str) {
        try {
            this.f11408c.update(str.getBytes());
            byte[] digest = this.f11408c.digest();
            return Integer.valueOf(((digest[0] & C5230f1.f20085c) << 24) + ((digest[1] & C5230f1.f20085c) << 16) + ((digest[2] & C5230f1.f20085c) << 8) + (digest[3] & C5230f1.f20085c));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public boolean m10796a(String str) {
        return this.f11410e ? this.f11409d.contains(m10794c(str)) : this.f11409d.contains(str);
    }

    /* renamed from: b */
    public void m10797b(String str) {
        if (this.f11410e) {
            this.f11409d.add(m10794c(str));
        } else {
            this.f11409d.add(str);
        }
    }

    public String toString() {
        if (!this.f11410e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f11409d) {
                if (sb.length() > 0) {
                    sb.append(f11406b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f11409d.size() * 4];
        Iterator<Object> it = this.f11409d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((-16777216) & intValue) >> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((16711680 & intValue) >> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((65280 & intValue) >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    /* renamed from: a */
    public void m10795a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f11409d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        System.out.println(sb.toString());
    }
}
