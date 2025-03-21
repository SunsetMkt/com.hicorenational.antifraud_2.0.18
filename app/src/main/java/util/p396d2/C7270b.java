package util.p396d2;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import util.C7324u0;

/* compiled from: UrlAES.java */
/* renamed from: util.d2.b */
/* loaded from: classes2.dex */
public class C7270b {

    /* renamed from: a */
    private static final String f25292a = "hicore2020051518";

    /* renamed from: b */
    private static final String f25293b = "AES/ECB/PKCS5Padding";

    /* renamed from: c */
    private static final String f25294c = "hicore2020051518";

    /* renamed from: d */
    private static final String f25295d = "UTF-8";

    /* renamed from: e */
    private static final String f25296e = "AES";

    /* renamed from: a */
    public static String m26326a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : C7324u0.m26598a(str.replaceAll(AbstractC1191a.f2568g, "+"), "hicore2020051518", "hicore2020051518");
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m26327b(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("hicore2020051518".getBytes("UTF-8"), f25296e);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec("hicore2020051518".getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m26328c(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : C7324u0.m26605b(str.replaceAll(AbstractC1191a.f2568g, "+"), "hicore2020051518", "hicore2020051518");
        } catch (Exception unused) {
            return "";
        }
    }
}
