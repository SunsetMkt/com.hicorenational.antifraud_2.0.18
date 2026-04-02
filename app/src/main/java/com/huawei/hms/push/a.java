package com.huawei.hms.push;

/* JADX INFO: compiled from: BaseUtil.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        return bArr == null ? "" : new String(bArr, m.a);
    }
}
