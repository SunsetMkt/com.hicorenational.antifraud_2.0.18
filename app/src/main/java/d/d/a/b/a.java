package d.d.a.b;

import d.d.a.a.d;
import d.d.a.a.e;
import java.io.File;

/* JADX INFO: compiled from: ChannelReader.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(File file, String str) {
        if (str != null) {
            return str.equals(c(file));
        }
        return false;
    }

    public static boolean b(File file, String str) {
        if (str != null) {
            return str.equals(d(file));
        }
        return false;
    }

    public static String c(File file) {
        try {
            return d.d(file);
        } catch (Exception unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have channel info from Zip Comment");
            return null;
        }
    }

    public static String d(File file) {
        System.out.println("try to read channel info from apk : " + file.getAbsolutePath());
        return b.c(file, d.d.a.a.b.a);
    }

    public static boolean a(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return d.b(file);
        }
        return false;
    }

    public static boolean b(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return e.a(file);
        }
        return false;
    }
}
