package util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import bean.LocalVideoBean;
import cn.cloudwalk.libproject.Contants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.umeng.analytics.pro.bl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import ui.Hicore;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j1 {

    /* JADX INFO: compiled from: FileUtils.java */
    public static class a implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* JADX INFO: compiled from: FileUtils.java */
    public static class b implements Comparator<LocalVideoBean> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a */
        public int compare(LocalVideoBean localVideoBean, LocalVideoBean localVideoBean2) {
            if (localVideoBean == null || localVideoBean2 == null) {
                return 0;
            }
            return (localVideoBean2.getLastTime() + "").compareTo(localVideoBean.getLastTime() + "");
        }
    }

    public static String a(Context context, String str) {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return uri.getPath();
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                cursorQuery.close();
                return string;
            }
        }
        return "";
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(str.replaceAll("[^\\d]", ""));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean c() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String d(String str) {
        int iLastIndexOf;
        return (str == null || str.isEmpty() || (iLastIndexOf = str.lastIndexOf(".")) <= 0 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static String e(String str) {
        int iLastIndexOf;
        return (str == null || str.isEmpty() || (iLastIndexOf = str.lastIndexOf(46)) <= 0 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static long f(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return 0L;
    }

    public static double g(String str) {
        long jF = f(str);
        if (jF == 0) {
            return 0.0d;
        }
        return jF / 1024.0d;
    }

    public static String h(String str) {
        return a(f(str));
    }

    public static String i(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth + "x" + options.outHeight;
    }

    public static String j(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (str == null) {
            return "text/plain";
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            return mediaMetadataRetriever.extractMetadata(12);
        } catch (IllegalArgumentException | IllegalStateException | RuntimeException unused) {
            return "text/plain";
        }
    }

    public static boolean k(String str) {
        String strJ = j(str);
        return !TextUtils.isEmpty(strJ) && strJ.contains("audio/");
    }

    public static boolean l(String str) {
        String strJ = j(str);
        return !TextUtils.isEmpty(strJ) && strJ.contains("video/");
    }

    public static String b() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (g2.b()) {
                str = Hicore.getApp().getExternalFilesDir("").getAbsolutePath() + "/hicore_national/cache/";
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hicore_national/cache/";
            }
        } else {
            str = Hicore.getApp().getFilesDir().getAbsolutePath() + "/hicore_national/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String c(String str) {
        return a(str, "GBK");
    }

    public static String c(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str3 = new String(bArr, "UTF-8");
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            str3 = "";
        }
        return str3;
    }

    public static File a(Context context, Uri uri) {
        if ("file".equals(uri.getScheme())) {
            String encodedPath = uri.getEncodedPath();
            if (encodedPath != null) {
                encodedPath = Uri.decode(encodedPath);
                ContentResolver contentResolver = context.getContentResolver();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("(");
                stringBuffer.append("_data");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append("'" + encodedPath + "'");
                stringBuffer.append(")");
                Cursor cursorQuery = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{bl.f7101d, "_data"}, stringBuffer.toString(), null, null);
                int i2 = 0;
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(bl.f7101d));
                    encodedPath = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
                if (i2 != 0) {
                    s1.d("temp uri is :" + Uri.parse("content://media/external/images/media/" + i2));
                }
            }
            if (encodedPath != null) {
                return new File(encodedPath);
            }
        } else if ("content".equals(uri.getScheme())) {
            Cursor cursorQuery2 = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            String string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("_data")) : null;
            cursorQuery2.close();
            return new File(string);
        }
        return null;
    }

    public static File b(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists() && file.isDirectory()) {
                file.mkdirs();
            }
            return new File(str + File.separator + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
    }

    public static String b(Context context, Uri uri) {
        Cursor cursorQuery;
        int columnIndex;
        String string = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || (cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_data")) > -1) {
            string = cursorQuery.getString(columnIndex);
        }
        cursorQuery.close();
        return string;
    }

    public static Bitmap b(Bitmap bitmap, int i2) {
        String str = i2 + "";
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2, -i2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Uri a(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{bl.f7101d}, "_data=? ", new String[]{absolutePath}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(bl.f7101d));
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i2);
        }
        if (!file.exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static String b(long j2) {
        if (j2 <= 0) {
            return "0 KB";
        }
        if (j2 < 1024) {
            return j2 + " KB";
        }
        double d2 = j2 / 1024.0d;
        if (d2 < 1024.0d) {
            return String.format("%.1f MB", Double.valueOf(d2));
        }
        double d3 = d2 / 1024.0d;
        return d3 < 1024.0d ? String.format("%.1f GB", Double.valueOf(d3)) : String.format("%.2f TB", Double.valueOf(d3 / 1024.0d));
    }

    public static String a() {
        try {
            if ((Build.BRAND.equalsIgnoreCase("oppo") || Build.BRAND.equalsIgnoreCase("vivo")) && Build.VERSION.SDK_INT < 24) {
                return b();
            }
            File cacheDir = Hicore.getApp().getCacheDir();
            if (cacheDir != null) {
                return cacheDir.getPath();
            }
            return b();
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] a(String str) {
        try {
            return a(new File(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public static File a(byte[] bArr, String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        File file;
        try {
            try {
                File file2 = new File((String) str);
                if (!file2.exists() && file2.isDirectory()) {
                    file2.mkdirs();
                }
                file = new File(((String) str) + File.separator + ((String) str2));
                str = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(str);
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    str2 = 0;
                    if (str2 != 0) {
                        try {
                            str2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                str = 0;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                str2 = 0;
            }
            try {
                bufferedOutputStream.write(bArr);
                try {
                    bufferedOutputStream.close();
                    try {
                        str.close();
                        return file;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return null;
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                    return null;
                }
            } catch (Exception e8) {
                e = e8;
                e.printStackTrace();
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return null;
                    }
                }
                if (str != 0) {
                    try {
                        str.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(Bitmap bitmap, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap a(String str, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = i2 / 1048576;
        s1.a("hsc", " height---" + i4 + "----width==" + i5 + "-------minLen---");
        StringBuilder sb = new StringBuilder();
        sb.append(" temp---+++++++");
        sb.append(d2.a((float) i2));
        s1.a("hsc", sb.toString());
        if (i6 >= 4) {
            i3 = ((i5 * i4) / 1048576) / 2;
        } else if (i6 >= 2 && i6 < 4) {
            i3 = 3;
        } else if (i6 >= 1 && i6 < 2) {
            i3 = 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i3;
        return BitmapFactory.decodeFile(str, options);
    }

    public static int a(Context context, int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = SubsamplingScaleImageView.ORIENTATION_270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i3) + 360) % 360;
    }

    public static Bitmap a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap a(int i2, Bitmap bitmap) {
        return a(i2, 0, bitmap);
    }

    public static Bitmap a(int i2, int i3, Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(i2);
        if (i3 != 0) {
            matrix.postScale(-i3, i3);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap a(Activity activity, Bitmap bitmap, int i2) {
        Bitmap bitmapA;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                bitmapA = a(cameraInfo.orientation, bitmap);
                if (bitmapA == null) {
                    bitmapA = bitmap;
                }
            } catch (Exception unused) {
                bitmapA = a(SubsamplingScaleImageView.ORIENTATION_270, bitmap);
            }
            return b(bitmapA, -1);
        }
        if (a(activity, i2)) {
            return b(bitmap, 1);
        }
        return b(bitmap, -1);
    }

    @RequiresApi(api = 21)
    public static boolean a(Activity activity, int i2) {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) activity.getSystemService("camera")).getCameraCharacteristics(i2 + "");
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
            cameraCharacteristics = null;
        }
        Integer num = 0;
        if (cameraCharacteristics != null) {
            num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        }
        return num.intValue() == 2;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            s1.a("getAssetsData--\u300b\u6587\u4ef6\u540d\u4e3a\u7a7a");
            return "";
        }
        try {
            InputStream inputStreamOpen = Hicore.getApp().getAssets().open(str);
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return new String(bArr, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static ByteArrayOutputStream a(Bitmap bitmap, long j2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String str = e.d.f10176l + e.d.f10166b;
        File file = new File(e.d.f10176l);
        if (!file.exists()) {
            file.mkdirs();
        }
        a(bitmap, str);
        File file2 = new File(str);
        String absolutePath = Hicore.getApp().getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        int i2 = 98;
        while (file2.length() > j2) {
            try {
                file2 = new g.a.a.b(Hicore.getApp()).b(480).a(Contants.PREVIEW_W).c(i2).a(Bitmap.CompressFormat.JPEG).a(absolutePath).c(new File(str));
                i2 -= 2;
                if (i2 <= 0) {
                    i2 = 1;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        while (true) {
            try {
                int i3 = bufferedInputStream.read();
                if (i3 == -1) {
                    break;
                }
                byteArrayOutputStream2.write(i3);
            } catch (Exception e3) {
                byteArrayOutputStream = byteArrayOutputStream2;
                e = e3;
                e.printStackTrace();
                byteArrayOutputStream2 = byteArrayOutputStream;
            }
        }
        File file3 = new File(absolutePath + File.separator + e.d.f10166b);
        if (file3.exists() && file3.isFile()) {
            file3.delete();
        }
        File file4 = new File(str);
        if (file4.exists() && file4.isFile()) {
            file4.delete();
        }
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArrayOutputStream2;
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        File file = new File(str, str2);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str3.getBytes());
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String a(long j2) {
        if (j2 <= 0) {
            return "0 B";
        }
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        double d2 = j2;
        int iLog10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        if (iLog10 >= strArr.length) {
            iLog10 = strArr.length - 1;
        }
        return String.format("%.1f %s", Double.valueOf(d2 / Math.pow(1024.0d, iLog10)), strArr[iLog10]);
    }
}
