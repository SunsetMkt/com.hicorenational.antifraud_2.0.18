package p031c.p091d.p092a.p095b;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import p031c.p091d.p092a.p093a.C1221e;
import p031c.p091d.p092a.p093a.p094f.C1222a;

/* compiled from: IdValueReader.java */
/* renamed from: c.d.a.b.b */
/* loaded from: classes.dex */
public class C1225b {
    /* renamed from: a */
    public static ByteBuffer m2427a(File file, int i2) {
        if (file != null && file.exists() && file.isFile()) {
            Map<Integer, ByteBuffer> m2428a = m2428a(file);
            System.out.println("getByteBufferValueById , destApk " + file.getAbsolutePath() + " IdValueMap = " + m2428a);
            if (m2428a != null) {
                return m2428a.get(Integer.valueOf(i2));
            }
        }
        return null;
    }

    /* renamed from: b */
    public static byte[] m2429b(File file, int i2) {
        if (file != null && file.exists() && file.isFile()) {
            ByteBuffer m2427a = m2427a(file, i2);
            System.out.println("getByteValueById , id = " + i2 + " , value = " + m2427a);
            if (m2427a != null) {
                return Arrays.copyOfRange(m2427a.array(), m2427a.arrayOffset() + m2427a.position(), m2427a.arrayOffset() + m2427a.limit());
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m2430c(File file, int i2) {
        byte[] m2429b;
        if (file != null && file.exists() && file.isFile() && (m2429b = m2429b(file, i2)) != null) {
            try {
                if (m2429b.length > 0) {
                    return new String(m2429b, "UTF-8");
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Map<Integer, ByteBuffer> m2428a(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                return C1221e.m2384a(C1221e.m2387b(file));
            } catch (C1222a.c unused) {
                System.out.println("APK : " + file.getAbsolutePath() + " not have apk signature block");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
