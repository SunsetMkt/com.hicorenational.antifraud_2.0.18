package util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.annotation.RequiresApi;
import com.luck.picture.lib.tools.BitmapUtils;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: BitMapUtil.java */
/* loaded from: classes2.dex */
public class y0 {
    public static String a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT >= 19 ? b(context, uri) : c(context, uri);
    }

    @RequiresApi(api = 19)
    private static String b(Context context, Uri uri) {
        String a2;
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return a(context, uri, (String) null, (String[]) null);
            }
            if ("file".equals(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        if (b(uri)) {
            a2 = a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(Constants.COLON_SEPARATOR)[1]});
        } else {
            if (!a(uri)) {
                return null;
            }
            a2 = a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
        }
        return a2;
    }

    private static String c(Context context, Uri uri) {
        return a(context, uri, (String) null, (String[]) null);
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        String[] strArr2 = {"_data"};
        try {
            cursor = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (cursor == null) {
                return null;
            }
            try {
                if (cursor.moveToFirst()) {
                    return cursor.getString(cursor.getColumnIndexOrThrow(strArr2[0]));
                }
                return null;
            } catch (Exception unused) {
                if (cursor == null) {
                    return null;
                }
                cursor.close();
                return null;
            }
        } catch (Exception unused2) {
            cursor = null;
        }
    }

    private static boolean a(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static Bitmap a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str2 = "未压缩之前图片的宽：" + options.outWidth + "--未压缩之前图片的高：" + options.outHeight + "--未压缩之前图片大小:" + ((((options.outWidth * options.outHeight) * 4) / 1024) / 1024) + "M";
        options.inSampleSize = a(options, 100, 100);
        String str3 = " inSampleSize:" + options.inSampleSize;
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        String str4 = " 图片的宽：" + decodeFile.getWidth() + "--图片的高：" + decodeFile.getHeight() + "--图片大小:" + ((((decodeFile.getWidth() * decodeFile.getHeight()) * 4) / 1024) / 1024) + "M";
        return decodeFile;
    }

    private static boolean b(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public static Bitmap a(Bitmap bitmap, String str, String str2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile == null) {
            return null;
        }
        Bitmap a2 = a(BitmapUtils.rotatingImage(decodeFile, BitmapUtils.readTruePathDegree(str)), bitmap);
        f1.a(a2, str2);
        return a2;
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap a2 = a(bitmap, 960);
        return a(a2, bitmap2, (a2.getWidth() - bitmap2.getWidth()) / 2, (a2.getHeight() - bitmap2.getHeight()) / 2);
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAlpha(200);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, i2, i3, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static Bitmap a(Bitmap bitmap, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = (i2 * 1.0f) / width;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2, 0.0f, 0.0f);
        Bitmap createBitmap = Bitmap.createBitmap(i2, (int) (height * f2), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap, int i2, int i3) {
        Matrix matrix = new Matrix();
        matrix.postScale((i2 * 1.0f) / bitmap.getWidth(), (i3 * 1.0f) / bitmap.getHeight(), 0.0f, 0.0f);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }
}
