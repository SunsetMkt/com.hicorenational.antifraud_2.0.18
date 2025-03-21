package p357j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;
import util.C7277f1;

/* compiled from: ImageCacheUtils.java */
/* renamed from: j.c */
/* loaded from: classes2.dex */
public class C5844c {

    /* renamed from: a */
    public static String f21112a = C7277f1.m26345a() + "/appiconjb";

    /* renamed from: b */
    public static String f21113b = C7277f1.m26345a() + "/appiconxs";

    /* renamed from: c */
    public static String f21114c = C7277f1.m26345a() + "/appiconAutoVirus";

    /* renamed from: d */
    private static String f21115d = C7277f1.m26345a() + "/apppic";

    /* renamed from: e */
    public static String f21116e = C7277f1.m26345a() + "/appiconxk";

    /* renamed from: f */
    public static String f21117f = C7277f1.m26345a() + "/appiconxc";

    /* compiled from: ImageCacheUtils.java */
    /* renamed from: j.c$a */
    static class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21118a;

        /* renamed from: b */
        final /* synthetic */ String f21119b;

        /* renamed from: c */
        final /* synthetic */ String f21120c;

        /* renamed from: d */
        final /* synthetic */ Bitmap f21121d;

        a(String str, String str2, String str3, Bitmap bitmap) {
            this.f21118a = str;
            this.f21119b = str2;
            this.f21120c = str3;
            this.f21121d = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String str = "国家反诈中心_" + this.f21118a + "_v" + this.f21119b + PictureMimeType.PNG;
                if (C5844c.m24599b(str, this.f21120c)) {
                    return;
                }
                File file = new File(this.f21120c, str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.f21121d.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public static File m24597b(Context context, String str) {
        try {
            return ComponentCallbacks2C1576b.m3649e(context).m3795f().mo3719a(str).m3760T().get();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static File m24590a(Context context, String str) {
        try {
            return ComponentCallbacks2C1576b.m3649e(context).mo3719a(str).m3772b(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static Drawable m24596b(String str, String str2, String str3) {
        return new BitmapDrawable(m24589a(str, str2, str3));
    }

    /* renamed from: a */
    public static Bitmap m24588a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m24599b(String str, String str2) {
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (TextUtils.equals(file2.getName(), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m24592a(Bitmap bitmap, String str, String str2, String str3) {
        new Thread(new a(str, str2, str3, bitmap)).start();
    }

    /* renamed from: b */
    public static String m24598b(String str) {
        return new File(f21115d, str).getAbsolutePath();
    }

    /* renamed from: a */
    public static Bitmap m24589a(String str, String str2, String str3) {
        try {
            File file = new File(str3, "国家反诈中心_" + str + "_v" + str2 + PictureMimeType.PNG);
            if (file.exists()) {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m24594a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
    }

    /* renamed from: a */
    public static void m24591a(Context context, String str, String str2) {
        File file;
        try {
            file = ComponentCallbacks2C1576b.m3649e(context).mo3719a(str).m3772b(90, 90).get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            file = null;
            m24593a(file, new File(f21115d, str2));
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            file = null;
            m24593a(file, new File(f21115d, str2));
        }
        m24593a(file, new File(f21115d, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0052 A[Catch: IOException -> 0x004e, TRY_LEAVE, TryCatch #7 {IOException -> 0x004e, blocks: (B:40:0x004a, B:33:0x0052), top: B:39:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m24593a(java.io.File r2, java.io.File r3) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
        Lf:
            int r0 = r1.read(r3)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            if (r0 <= 0) goto L19
            r2.write(r3)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            goto Lf
        L19:
            r1.close()     // Catch: java.io.IOException -> L3a
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L45
        L20:
            r3 = move-exception
            goto L48
        L22:
            r3 = move-exception
            goto L29
        L24:
            r3 = move-exception
            r2 = r0
            goto L48
        L27:
            r3 = move-exception
            r2 = r0
        L29:
            r0 = r1
            goto L31
        L2b:
            r3 = move-exception
            r2 = r0
            r1 = r2
            goto L48
        L2f:
            r3 = move-exception
            r2 = r0
        L31:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L3c
            r0.close()     // Catch: java.io.IOException -> L3a
            goto L3c
        L3a:
            r2 = move-exception
            goto L42
        L3c:
            if (r2 == 0) goto L45
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L45
        L42:
            r2.printStackTrace()
        L45:
            return
        L46:
            r3 = move-exception
            r1 = r0
        L48:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L50
        L4e:
            r2 = move-exception
            goto L56
        L50:
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L59
        L56:
            r2.printStackTrace()
        L59:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p357j.C5844c.m24593a(java.io.File, java.io.File):void");
    }
}
