package com.huawei.hms.opendevice;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;

/* compiled from: BaseUtil.java */
/* renamed from: com.huawei.hms.opendevice.d */
/* loaded from: classes.dex */
public abstract class AbstractC2466d {
    /* renamed from: a */
    public static String m7451a(byte[] bArr) {
        return HexUtil.byteArray2HexStr(bArr);
    }

    /* renamed from: a */
    public static byte[] m7452a(String str) {
        return HexUtil.hexStr2ByteArray(str);
    }
}
