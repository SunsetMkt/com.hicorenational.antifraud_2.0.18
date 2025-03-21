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
import com.huawei.hms.framework.common.ContainerUtils;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.umeng.analytics.pro.C3355bl;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import p388ui.Hicore;

/* compiled from: FileUtils.java */
/* renamed from: util.f1 */
/* loaded from: classes2.dex */
public class C7277f1 {

    /* compiled from: FileUtils.java */
    /* renamed from: util.f1$a */
    public static class a implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: FileUtils.java */
    /* renamed from: util.f1$b */
    public static class b implements Comparator<LocalVideoBean> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LocalVideoBean localVideoBean, LocalVideoBean localVideoBean2) {
            if (localVideoBean == null || localVideoBean2 == null) {
                return 0;
            }
            return (localVideoBean2.getLastTime() + "").compareTo(localVideoBean.getLastTime() + "");
        }
    }

    /* renamed from: a */
    public static String m26346a(Context context, String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getAuthority())) {
            return parse.getPath();
        }
        Cursor query = context.getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            if (query.moveToFirst()) {
                String string = query.getString(columnIndexOrThrow);
                query.close();
                return string;
            }
        }
        return "";
    }

    /* renamed from: b */
    public static int m26353b(String str) {
        try {
            return Integer.parseInt(str.replaceAll("[^\\d]", ""));
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public static boolean m26361c() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: d */
    public static String m26362d(String str) {
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

    /* renamed from: e */
    public static boolean m26363e(String str) {
        String m26362d = m26362d(str);
        return !TextUtils.isEmpty(m26362d) && m26362d.contains("audio/");
    }

    /* renamed from: f */
    public static boolean m26364f(String str) {
        String m26362d = m26362d(str);
        return !TextUtils.isEmpty(m26362d) && m26362d.contains("video/");
    }

    /* renamed from: b */
    public static String m26357b() {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (C7337y1.m26768b()) {
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

    /* renamed from: c */
    public static String m26359c(String str) {
        return m26347a(str, "GBK");
    }

    /* renamed from: c */
    public static String m26360c(String str, String str2) {
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
                return str3;
            }
        } catch (IOException e3) {
            e = e3;
            str3 = "";
        }
        return str3;
    }

    /* renamed from: a */
    public static File m26343a(Context context, Uri uri) {
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
                Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{C3355bl.f11732d, "_data"}, stringBuffer.toString(), null, null);
                int i2 = 0;
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    i2 = query.getInt(query.getColumnIndex(C3355bl.f11732d));
                    encodedPath = query.getString(query.getColumnIndex("_data"));
                    query.moveToNext();
                }
                query.close();
                if (i2 != 0) {
                    C7301n1.m26460d("temp uri is :" + Uri.parse("content://media/external/images/media/" + i2));
                }
            }
            if (encodedPath != null) {
                return new File(encodedPath);
            }
        } else if ("content".equals(uri.getScheme())) {
            Cursor query2 = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            String string = query2.moveToFirst() ? query2.getString(query2.getColumnIndexOrThrow("_data")) : null;
            query2.close();
            return new File(string);
        }
        return null;
    }

    /* renamed from: b */
    public static File m26356b(String str, String str2) {
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

    /* renamed from: b */
    public static Bitmap m26354b(Bitmap bitmap) {
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
    }

    /* renamed from: b */
    public static String m26358b(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
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
        if (!"content".equals(scheme) || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    /* renamed from: b */
    public static Bitmap m26355b(Bitmap bitmap, int i2) {
        String str = i2 + "";
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2, -i2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: a */
    public static Uri m26341a(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{C3355bl.f11732d}, "_data=? ", new String[]{absolutePath}, null);
        if (query != null && query.moveToFirst()) {
            int i2 = query.getInt(query.getColumnIndex(C3355bl.f11732d));
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i2);
        }
        if (!file.exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    /* renamed from: a */
    public static String m26345a() {
        try {
            if ((Build.BRAND.equalsIgnoreCase("oppo") || Build.BRAND.equalsIgnoreCase("vivo")) && Build.VERSION.SDK_INT < 24) {
                return m26357b();
            }
            File cacheDir = Hicore.getApp().getCacheDir();
            if (cacheDir != null) {
                return cacheDir.getPath();
            }
            return m26357b();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static byte[] m26352a(String str) {
        try {
            return m26351a(new File(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m26351a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
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
    /* renamed from: a */
    public static File m26344a(byte[] bArr, String str, String str2) {
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

    /* renamed from: a */
    public static void m26348a(Bitmap bitmap, String str) {
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

    /* renamed from: a */
    public static Bitmap m26339a(Bitmap bitmap, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    /* renamed from: a */
    public static Bitmap m26340a(String str, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = i2 / 1048576;
        C7301n1.m26454a("hsc", " height---" + i4 + "----width==" + i5 + "-------minLen---");
        StringBuilder sb = new StringBuilder();
        sb.append(" temp---+++++++");
        sb.append(C7328v1.m26644a((float) i2));
        C7301n1.m26454a("hsc", sb.toString());
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

    /* renamed from: a */
    public static int m26334a(Context context, int i2) {
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

    /* renamed from: a */
    public static Bitmap m26338a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: a */
    public static Bitmap m26336a(int i2, Bitmap bitmap) {
        return m26335a(i2, 0, bitmap);
    }

    /* renamed from: a */
    public static Bitmap m26335a(int i2, int i3, Bitmap bitmap) {
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

    /* renamed from: a */
    public static Bitmap m26337a(Activity activity, Bitmap bitmap, int i2) {
        Bitmap m26336a;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                m26336a = m26336a(cameraInfo.orientation, bitmap);
                if (m26336a == null) {
                    m26336a = bitmap;
                }
            } catch (Exception unused) {
                m26336a = m26336a(SubsamplingScaleImageView.ORIENTATION_270, bitmap);
            }
            return m26355b(m26336a, -1);
        }
        if (m26350a(activity, i2)) {
            return m26355b(bitmap, 1);
        }
        return m26355b(bitmap, -1);
    }

    @RequiresApi(api = 21)
    /* renamed from: a */
    public static boolean m26350a(Activity activity, int i2) {
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

    /* renamed from: a */
    public static String m26347a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C7301n1.m26453a("getAssetsData--》文件名为空");
            return "";
        }
        try {
            InputStream open = Hicore.getApp().getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            if (open != null) {
                open.close();
            }
            return new String(bArr, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.ByteArrayOutputStream m26342a(android.graphics.Bitmap r9, long r10) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = p245d.C4443d.f16965l
            r1.append(r2)
            java.lang.String r2 = "portrait.jpg"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r3 = new java.io.File
            java.lang.String r4 = p245d.C4443d.f16965l
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L28
            r3.mkdirs()
        L28:
            m26348a(r9, r1)
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            ui.Hicore r4 = p388ui.Hicore.getApp()
            java.lang.String r5 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r4 = r4.getExternalFilesDir(r5)
            java.lang.String r4 = r4.getAbsolutePath()
            r5 = 98
        L40:
            long r6 = r3.length()     // Catch: java.lang.Exception -> L98
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 <= 0) goto L7a
            f.a.a.b r3 = new f.a.a.b     // Catch: java.lang.Exception -> L98
            ui.Hicore r6 = p388ui.Hicore.getApp()     // Catch: java.lang.Exception -> L98
            r3.<init>(r6)     // Catch: java.lang.Exception -> L98
            r6 = 480(0x1e0, float:6.73E-43)
            f.a.a.b r3 = r3.m16426b(r6)     // Catch: java.lang.Exception -> L98
            r6 = 640(0x280, float:8.97E-43)
            f.a.a.b r3 = r3.m16422a(r6)     // Catch: java.lang.Exception -> L98
            f.a.a.b r3 = r3.m16429c(r5)     // Catch: java.lang.Exception -> L98
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L98
            f.a.a.b r3 = r3.m16423a(r6)     // Catch: java.lang.Exception -> L98
            f.a.a.b r3 = r3.m16424a(r4)     // Catch: java.lang.Exception -> L98
            java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L98
            r6.<init>(r1)     // Catch: java.lang.Exception -> L98
            java.io.File r3 = r3.m16430c(r6)     // Catch: java.lang.Exception -> L98
            int r5 = r5 + (-2)
            if (r5 > 0) goto L40
            r5 = 1
            goto L40
        L7a:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L98
            r10.<init>(r3)     // Catch: java.lang.Exception -> L98
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L98
            r11.<init>(r10)     // Catch: java.lang.Exception -> L98
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L98
            r10.<init>()     // Catch: java.lang.Exception -> L98
        L89:
            int r0 = r11.read()     // Catch: java.lang.Exception -> L94
            r3 = -1
            if (r0 == r3) goto L9d
            r10.write(r0)     // Catch: java.lang.Exception -> L94
            goto L89
        L94:
            r11 = move-exception
            r0 = r10
            r10 = r11
            goto L99
        L98:
            r10 = move-exception
        L99:
            r10.printStackTrace()
            r10 = r0
        L9d:
            java.io.File r11 = new java.io.File
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r3 = java.io.File.separator
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            boolean r0 = r11.exists()
            if (r0 == 0) goto Lc5
            boolean r0 = r11.isFile()
            if (r0 == 0) goto Lc5
            r11.delete()
        Lc5:
            java.io.File r11 = new java.io.File
            r11.<init>(r1)
            boolean r0 = r11.exists()
            if (r0 == 0) goto Ld9
            boolean r0 = r11.isFile()
            if (r0 == 0) goto Ld9
            r11.delete()
        Ld9:
            boolean r11 = r9.isRecycled()
            if (r11 != 0) goto Le2
            r9.recycle()
        Le2:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: util.C7277f1.m26342a(android.graphics.Bitmap, long):java.io.ByteArrayOutputStream");
    }

    /* renamed from: a */
    public static void m26349a(String str, String str2, String str3) {
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
}
