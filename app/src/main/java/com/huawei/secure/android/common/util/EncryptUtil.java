package com.huawei.secure.android.common.util;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes.dex */
public class EncryptUtil {

    /* renamed from: a */
    private static final String f8261a = "EncryptUtil";

    /* renamed from: b */
    private static final String f8262b = "RSA";

    /* JADX WARN: Removed duplicated region for block: B:16:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] generateSecureRandom(int r3) {
        /*
            byte[] r3 = new byte[r3]
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.NoSuchAlgorithmException -> Ld
            r1 = 26
            if (r0 < r1) goto L14
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstanceStrong()     // Catch: java.security.NoSuchAlgorithmException -> Ld
            goto L15
        Ld:
            java.lang.String r0 = com.huawei.secure.android.common.util.EncryptUtil.f8261a
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.util.LogsUtil.m8021e(r0, r1)
        L14:
            r0 = 0
        L15:
            if (r0 != 0) goto L1d
            java.lang.String r0 = "SHA1PRNG"
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r0)     // Catch: java.lang.Exception -> L21 java.security.NoSuchAlgorithmException -> L3d
        L1d:
            r0.nextBytes(r3)     // Catch: java.lang.Exception -> L21 java.security.NoSuchAlgorithmException -> L3d
            return r3
        L21:
            r3 = move-exception
            java.lang.String r0 = com.huawei.secure.android.common.util.EncryptUtil.f8261a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getSecureRandomBytes getInstance: exception : "
            r1.append(r2)
            java.lang.String r3 = r3.getMessage()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            com.huawei.secure.android.common.util.LogsUtil.m8021e(r0, r3)
            goto L44
        L3d:
            java.lang.String r3 = com.huawei.secure.android.common.util.EncryptUtil.f8261a
            java.lang.String r0 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
            com.huawei.secure.android.common.util.LogsUtil.m8021e(r3, r0)
        L44:
            r3 = 0
            byte[] r3 = new byte[r3]
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.EncryptUtil.generateSecureRandom(int):byte[]");
    }

    @Deprecated
    public static String generateSecureRandomStr(int i2) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i2));
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(f8262b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e2) {
                LogsUtil.m8026e(f8261a, "load Key Exception:" + e2.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.m8026e(f8261a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.m8026e(f8261a, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f8262b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e2) {
                LogsUtil.m8026e(f8261a, "load Key Exception:" + e2.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.m8026e(f8261a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.m8026e(f8261a, "base64 decode Exception", true);
            return null;
        }
    }
}
