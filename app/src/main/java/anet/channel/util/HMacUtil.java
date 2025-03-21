package anet.channel.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HMacUtil {
    private static final String TAG = "awcn.HMacUtil";

    private static byte[] hmacSha1(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String hmacSha1Hex(byte[] bArr, byte[] bArr2) {
        try {
            return StringUtils.bytesToHexString(hmacSha1(bArr, bArr2));
        } catch (Throwable th) {
            ALog.m715e(TAG, "hmacSha1Hex", null, "result", "", th);
            return "";
        }
    }
}
