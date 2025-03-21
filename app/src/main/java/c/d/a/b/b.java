package c.d.a.b;

import c.d.a.a.e;
import c.d.a.a.f.a;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* compiled from: IdValueReader.java */
/* loaded from: classes.dex */
public class b {
    public static ByteBuffer a(File file, int i2) {
        if (file != null && file.exists() && file.isFile()) {
            Map<Integer, ByteBuffer> a2 = a(file);
            System.out.println("getByteBufferValueById , destApk " + file.getAbsolutePath() + " IdValueMap = " + a2);
            if (a2 != null) {
                return a2.get(Integer.valueOf(i2));
            }
        }
        return null;
    }

    public static byte[] b(File file, int i2) {
        if (file != null && file.exists() && file.isFile()) {
            ByteBuffer a2 = a(file, i2);
            System.out.println("getByteValueById , id = " + i2 + " , value = " + a2);
            if (a2 != null) {
                return Arrays.copyOfRange(a2.array(), a2.arrayOffset() + a2.position(), a2.arrayOffset() + a2.limit());
            }
        }
        return null;
    }

    public static String c(File file, int i2) {
        byte[] b2;
        if (file != null && file.exists() && file.isFile() && (b2 = b(file, i2)) != null) {
            try {
                if (b2.length > 0) {
                    return new String(b2, "UTF-8");
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static Map<Integer, ByteBuffer> a(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                return e.a(e.b(file));
            } catch (a.c unused) {
                System.out.println("APK : " + file.getAbsolutePath() + " not have apk signature block");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
