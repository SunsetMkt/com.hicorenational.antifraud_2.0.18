package com.umeng.analytics.filter;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import i.f1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SmartDict.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f6970b = "\u0102";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MessageDigest f6971c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6973e;
    private final String a = "MD5";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<Object> f6972d = new HashSet();

    public d(boolean z, String str) {
        int i2 = 0;
        this.f6973e = false;
        this.f6973e = z;
        try {
            this.f6971c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (!z) {
                String[] strArrSplit = str.split(f6970b);
                int length = strArrSplit.length;
                while (i2 < length) {
                    this.f6972d.add(strArrSplit[i2]);
                    i2++;
                }
                return;
            }
            try {
                byte[] bArrDecode = Base64.decode(str.getBytes(), 0);
                while (i2 < bArrDecode.length / 4) {
                    int i3 = i2 * 4;
                    this.f6972d.add(Integer.valueOf(((bArrDecode[i3 + 0] & f1.f12066c) << 24) + ((bArrDecode[i3 + 1] & f1.f12066c) << 16) + ((bArrDecode[i3 + 2] & f1.f12066c) << 8) + (bArrDecode[i3 + 3] & f1.f12066c)));
                    i2++;
                }
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f6971c.update(str.getBytes());
            byte[] bArrDigest = this.f6971c.digest();
            return Integer.valueOf(((bArrDigest[0] & f1.f12066c) << 24) + ((bArrDigest[1] & f1.f12066c) << 16) + ((bArrDigest[2] & f1.f12066c) << 8) + (bArrDigest[3] & f1.f12066c));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        return this.f6973e ? this.f6972d.contains(c(str)) : this.f6972d.contains(str);
    }

    public void b(String str) {
        if (this.f6973e) {
            this.f6972d.add(c(str));
        } else {
            this.f6972d.add(str);
        }
    }

    public String toString() {
        if (!this.f6973e) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : this.f6972d) {
                if (sb.length() > 0) {
                    sb.append(f6970b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[this.f6972d.size() * 4];
        Iterator<Object> it = this.f6972d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((-16777216) & iIntValue) >> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((16711680 & iIntValue) >> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((65280 & iIntValue) >> 8);
            i2 = i5 + 1;
            bArr[i5] = (byte) (iIntValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.f6972d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        System.out.println(sb.toString());
    }
}
