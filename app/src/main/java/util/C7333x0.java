package util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;

/* compiled from: Base64Utils.java */
/* renamed from: util.x0 */
/* loaded from: classes2.dex */
public class C7333x0 {
    /* renamed from: a */
    public static String m26699a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* renamed from: b */
    public static String m26702b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* renamed from: c */
    public static String m26704c(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m26700a(ByteArrayOutputStream byteArrayOutputStream) {
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* renamed from: b */
    public static String m26703b(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static Bitmap m26698a(String str) {
        if (str.contains("data:image/*;base64,")) {
            byte[] decode = Base64.decode(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        byte[] decode2 = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode2, 0, decode2.length);
    }

    /* renamed from: a */
    public static String m26701a(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
