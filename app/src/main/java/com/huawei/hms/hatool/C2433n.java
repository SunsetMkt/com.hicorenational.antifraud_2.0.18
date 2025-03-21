package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.hatool.n */
/* loaded from: classes.dex */
public class C2433n {

    /* renamed from: a */
    public static final Charset f7585a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static Pair<byte[], String> m7244a(String str, int i2) {
        if (str == null || str.length() < i2) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, i2);
        return new Pair<>(HexUtil.hexStr2ByteArray(substring), str.substring(i2));
    }

    /* renamed from: a */
    public static String m7245a(String str, String str2) {
        Pair<byte[], String> m7244a = m7244a(str, 32);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) m7244a.second), HexUtil.hexStr2ByteArray(str2), (byte[]) m7244a.first), f7585a);
    }

    /* renamed from: a */
    public static String m7246a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
            if (hexStr2ByteArray.length >= 16) {
                return HexUtil.byteArray2HexStr(AesGcm.encrypt(bArr, hexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        C2452v.m7382b("AesCipher", str2);
        return "";
    }

    /* renamed from: b */
    public static String m7247b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f7585a), HexUtil.hexStr2ByteArray(str2)));
    }
}
