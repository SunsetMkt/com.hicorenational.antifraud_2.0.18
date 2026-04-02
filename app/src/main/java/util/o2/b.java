package util.o2;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import util.x0;

/* JADX INFO: compiled from: UrlAES.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "hicore2020051518";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15004b = "AES/ECB/PKCS5Padding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15005c = "hicore2020051518";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15006d = "UTF-8";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f15007e = "AES";

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : x0.a(str.replaceAll(d.c.a.b.a.a.f10074g, "+"), "hicore2020051518", "hicore2020051518");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("hicore2020051518".getBytes("UTF-8"), f15007e);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec("hicore2020051518".getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : x0.b(str.replaceAll(d.c.a.b.a.a.f10074g, "+"), "hicore2020051518", "hicore2020051518");
        } catch (Exception unused) {
            return "";
        }
    }
}
