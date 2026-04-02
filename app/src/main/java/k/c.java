package k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import util.j1;

/* JADX INFO: compiled from: ImageCacheUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a = j1.a() + "/appiconjb";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f12649b = j1.a() + "/appiconxs";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f12650c = j1.a() + "/appiconAutoVirus";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f12651d = j1.a() + "/apppic";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f12652e = j1.a() + "/appiconxk";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f12653f = j1.a() + "/appiconxc";

    /* JADX INFO: compiled from: ImageCacheUtils.java */
    static class a implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f12655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap f12656d;

        a(String str, String str2, String str3, Bitmap bitmap) {
            this.a = str;
            this.f12654b = str2;
            this.f12655c = str3;
            this.f12656d = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String str = "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3_" + this.a + "_v" + this.f12654b + PictureMimeType.PNG;
                if (c.b(str, this.f12655c)) {
                    return;
                }
                File file = new File(this.f12655c, str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.f12656d.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static File b(Context context, String str) {
        try {
            return com.bumptech.glide.b.e(context).f().a(str).T().get();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static File a(Context context, String str) {
        try {
            return com.bumptech.glide.b.e(context).a(str).b(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable b(String str, String str2, String str3) {
        return new BitmapDrawable(a(str, str2, str3));
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
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

    public static void a(Bitmap bitmap, String str, String str2, String str3) {
        new Thread(new a(str, str2, str3, bitmap)).start();
    }

    public static String b(String str) {
        return new File(f12651d, str).getAbsolutePath();
    }

    public static Bitmap a(String str, String str2, String str3) {
        try {
            File file = new File(str3, "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3_" + str + "_v" + str2 + PictureMimeType.PNG);
            if (file.exists()) {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
    }

    public static void a(Context context, String str, String str2) throws Throwable {
        File file;
        try {
            file = com.bumptech.glide.b.e(context).a(str).b(90, 90).get();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            file = null;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            file = null;
        }
        a(file, new File(f12651d, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0052 A[Catch: IOException -> 0x004e, TRY_LEAVE, TryCatch #7 {IOException -> 0x004e, blocks: (B:39:0x004a, B:43:0x0052), top: B:50:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (fileInputStream.read(bArr) > 0) {
                    fileOutputStream.write(bArr);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }
}
