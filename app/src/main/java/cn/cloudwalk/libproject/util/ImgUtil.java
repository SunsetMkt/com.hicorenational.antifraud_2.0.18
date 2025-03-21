package cn.cloudwalk.libproject.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.view.ViewCompat;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import h.f1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class ImgUtil {
    public static final int COLOR_FormatI420 = 1;
    public static final int COLOR_FormatNV21 = 2;
    private static final String TAG = LogUtils.makeLogTag("ImgUtil");

    public static Bitmap addRects(Rect[] rectArr, Bitmap bitmap) {
        Bitmap bitmap2;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Paint paint = new Paint();
            paint.setColor(Color.rgb(98, 212, 68));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(9.0f);
            paint.setAlpha(180);
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
            try {
                Canvas canvas = new Canvas(bitmap2);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                for (Rect rect : rectArr) {
                    canvas.drawRect(rect, paint);
                }
            } catch (Error e2) {
                e = e2;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (Error e3) {
            e = e3;
            bitmap2 = null;
        }
        return bitmap2;
    }

    public static byte[] bitmapToByte(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    public static Drawable bitmapToDrawableByBD(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static Bitmap byteArrayBGRToBitmap(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 3;
            int i7 = bArr[i6] & f1.f16099c;
            int i8 = bArr[i6 + 1] & f1.f16099c;
            int i9 = bArr[i6 + 2] & f1.f16099c;
            if (i7 < 0) {
                i7 = 0;
            } else if (i7 > 255) {
                i7 = 255;
            }
            if (i8 < 0) {
                i8 = 0;
            } else if (i8 > 255) {
                i8 = 255;
            }
            if (i9 < 0) {
                i9 = 0;
            } else if (i9 > 255) {
                i9 = 255;
            }
            iArr[i5] = (i9 << 16) + ViewCompat.MEASURED_STATE_MASK + (i8 << 8) + i7;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return createBitmap;
    }

    public static String byteToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & f1.f16099c);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static Bitmap bytesToBimap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x002f -> B:9:0x0025). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int calculateInSampleSize(android.graphics.BitmapFactory.Options r5, int r6, int r7) {
        /*
            int r0 = r5.outHeight
            int r5 = r5.outWidth
            r1 = 1
            if (r0 > r7) goto Lc
            if (r5 <= r6) goto La
            goto Lc
        La:
            r2 = 1
            goto L1e
        Lc:
            float r2 = (float) r0
            float r3 = (float) r7
            float r2 = r2 / r3
            int r2 = java.lang.Math.round(r2)
            float r3 = (float) r5
            float r4 = (float) r6
            float r3 = r3 / r4
            int r3 = java.lang.Math.round(r3)
            int r2 = java.lang.Math.max(r2, r3)
        L1e:
            if (r2 <= r1) goto L25
            int r3 = r2 % 2
            if (r3 != r1) goto L25
            goto L2f
        L25:
            int r1 = r5 / r2
            if (r1 > r6) goto L2f
            int r1 = r0 / r2
            if (r1 <= r7) goto L2e
            goto L2f
        L2e:
            return r2
        L2f:
            int r2 = r2 + 1
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.cloudwalk.libproject.util.ImgUtil.calculateInSampleSize(android.graphics.BitmapFactory$Options, int, int):int");
    }

    private static Bitmap compress(String str, int i2, int i3) {
        int i4;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        if (i5 > i3 || i6 > i2) {
            int i7 = i5 / 2;
            int i8 = i6 / 2;
            i4 = 1;
            while (i7 / i4 > i3 && i8 / i4 > i2) {
                i4 *= 2;
            }
        } else {
            i4 = 1;
        }
        options.inSampleSize = i4;
        options.inJustDecodeBounds = false;
        int ceil = (int) Math.ceil(options.outHeight / i3);
        int ceil2 = (int) Math.ceil(options.outWidth / i2);
        if (ceil > 1 || ceil2 > 1) {
            if (ceil > ceil2) {
                options.inSampleSize = ceil;
            } else {
                options.inSampleSize = ceil2;
            }
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap createImageThumbnail(Context context, String str, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        Bitmap bitmapByPath = getBitmapByPath(str, options);
        if (bitmapByPath == null) {
            return null;
        }
        int[] scaleImageSize = scaleImageSize(new int[]{bitmapByPath.getWidth(), bitmapByPath.getHeight()}, i2);
        return scaleImageSize[0] > i2 ? zoomBitmap(bitmapByPath, scaleImageSize[0], scaleImageSize[1]) : bitmapByPath;
    }

    public static Bitmap decodeSampledBitmapFromPath(String str, int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int calculateInSampleSize = calculateInSampleSize(options, i2, i3);
        options.inSampleSize = calculateInSampleSize;
        try {
            options.inJustDecodeBounds = false;
            if (config == null) {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            try {
                options.inSampleSize = calculateInSampleSize + 2;
                options.inJustDecodeBounds = false;
                if (config == null) {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                bitmap = BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                bitmap = null;
            }
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    public static Bitmap drawableToBitmapByBD(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public static Bitmap getBitmapByFile(File file) {
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (OutOfMemoryError e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                throw th;
            }
            try {
                bitmap = BitmapFactory.decodeStream(fileInputStream);
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                fileInputStream.close();
                return bitmap;
            } catch (OutOfMemoryError e5) {
                e = e5;
                e.printStackTrace();
                fileInputStream.close();
                return bitmap;
            }
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream.close();
            throw th;
        }
    }

    public static Bitmap getBitmapByPath(String str) {
        return getBitmapByPath(str, null);
    }

    public static Bitmap getBitmapFromBytes(byte[] bArr, BitmapFactory.Options options) {
        if (bArr != null) {
            return options != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static int getImageSpinAngle(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Util.getPackageFileBaseDir(context) + "/" + split[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    private static String getPathDeprecated(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return uri.getPath();
        }
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        return query.getString(columnIndexOrThrow);
    }

    public static String getSmartFilePath(Context context, Uri uri) {
        return Build.VERSION.SDK_INT < 19 ? getPathDeprecated(context, uri) : getPath(context, uri);
    }

    public static String getTempFileName() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SS").format((Date) new Timestamp(System.currentTimeMillis()));
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Bitmap jpgByteArrayToBitmap(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return byteToHexString(messageDigest.digest());
        } catch (Exception unused) {
            return str;
        }
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotaingImageView(int i2, Bitmap bitmap) {
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Error e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Bitmap rotatingImage(int i2, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static File saveImage(String str, Bitmap bitmap, long j2) {
        File file = new File(str.substring(0, str.lastIndexOf("/")));
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > j2 && i2 > 6) {
            byteArrayOutputStream.reset();
            i2 -= 6;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        }
        LogUtils.LOGE(TAG, "jpg保存质量:" + i2 + "图片大小:" + bitmap.getWidth() + ";" + bitmap.getHeight());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new File(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String saveImageToGallery(android.content.Context r7, android.graphics.Bitmap r8, java.lang.String r9, java.lang.String r10) {
        /*
            android.content.ContentResolver r7 = r7.getContentResolver()
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "title"
            r0.put(r1, r9)
            java.lang.String r1 = "_display_name"
            r0.put(r1, r9)
            java.lang.String r9 = "description"
            r0.put(r9, r10)
            java.lang.String r9 = "mime_type"
            java.lang.String r10 = "image/jpeg"
            r0.put(r9, r10)
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r10 = "date_added"
            r0.put(r10, r9)
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r10 = "datetaken"
            r0.put(r10, r9)
            r9 = 0
            android.net.Uri r10 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L6e
            android.net.Uri r10 = r7.insert(r10, r0)     // Catch: java.lang.Exception -> L6e
            if (r8 == 0) goto L68
            java.io.OutputStream r0 = r7.openOutputStream(r10)     // Catch: java.lang.Exception -> L6c
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L63
            r2 = 50
            r8.compress(r1, r2, r0)     // Catch: java.lang.Throwable -> L63
            r0.close()     // Catch: java.lang.Exception -> L6c
            long r2 = android.content.ContentUris.parseId(r10)     // Catch: java.lang.Exception -> L6c
            r8 = 1
            android.graphics.Bitmap r1 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(r7, r2, r8, r9)     // Catch: java.lang.Exception -> L6c
            r4 = 1112014848(0x42480000, float:50.0)
            r5 = 1112014848(0x42480000, float:50.0)
            r6 = 3
            r0 = r7
            storeThumbnail(r0, r1, r2, r4, r5, r6)     // Catch: java.lang.Exception -> L6c
            goto L75
        L63:
            r8 = move-exception
            r0.close()     // Catch: java.lang.Exception -> L6c
            throw r8     // Catch: java.lang.Exception -> L6c
        L68:
            r7.delete(r10, r9, r9)     // Catch: java.lang.Exception -> L6c
            goto L74
        L6c:
            goto L6f
        L6e:
            r10 = r9
        L6f:
            if (r10 == 0) goto L75
            r7.delete(r10, r9, r9)
        L74:
            r10 = r9
        L75:
            if (r10 == 0) goto L7b
            java.lang.String r9 = r10.toString()
        L7b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.cloudwalk.libproject.util.ImgUtil.saveImageToGallery(android.content.Context, android.graphics.Bitmap, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void saveJPGE_After(Bitmap bitmap, String str, int i2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void saveJpegToGallery(Context context, byte[] bArr, String str) {
        File file = new File(str);
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(File.separatorChar)), (String) null);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file.getAbsolutePath())));
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public static void savePNG_After(Bitmap bitmap, String str, int i2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            if (bitmap.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static int[] scaleImageSize(int[] iArr, int i2) {
        if (iArr[0] <= i2 && iArr[1] <= i2) {
            return iArr;
        }
        double max = i2 / Math.max(iArr[0], iArr[1]);
        return new int[]{(int) (iArr[0] * max), (int) (iArr[1] * max)};
    }

    private static void scanPhoto(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
    }

    public static void startImgIntent(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            activity.startActivityForResult(Intent.createChooser(intent, "选择图片"), i2);
        } else {
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.GET_CONTENT");
            intent2.setType("image/*");
            activity.startActivityForResult(Intent.createChooser(intent2, "选择图片"), i2);
        }
    }

    private static final Bitmap storeThumbnail(ContentResolver contentResolver, Bitmap bitmap, long j2, float f2, float f3, int i2) {
        try {
            Matrix matrix = new Matrix();
            matrix.setScale(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            ContentValues contentValues = new ContentValues(4);
            contentValues.put("kind", Integer.valueOf(i2));
            contentValues.put("image_id", Integer.valueOf((int) j2));
            contentValues.put(SocializeProtocolConstants.HEIGHT, Integer.valueOf(createBitmap.getHeight()));
            contentValues.put(SocializeProtocolConstants.WIDTH, Integer.valueOf(createBitmap.getWidth()));
            OutputStream openOutputStream = contentResolver.openOutputStream(contentResolver.insert(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, contentValues));
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, openOutputStream);
            openOutputStream.close();
            return createBitmap;
        } catch (Error | Exception unused) {
            return null;
        }
    }

    public static Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap bitmap2 = null;
        try {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return bitmap2;
        } catch (Error e2) {
            e2.printStackTrace();
            return bitmap2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
    
        if (r1 < 100.0d) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0116, code lost:
    
        r1 = 100.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        if (r1 < 100.0d) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f6, code lost:
    
        if (r1 < 100.0d) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0114, code lost:
    
        if (r1 < 100.0d) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File weixinCompress(java.io.File r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.cloudwalk.libproject.util.ImgUtil.weixinCompress(java.io.File, java.lang.String):java.io.File");
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i2, int i3) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width < i2 && height < i3) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            float f2 = i2 / width;
            float f3 = i3 / height;
            if (f2 > f3) {
                matrix.postScale(f3, f3);
            } else {
                matrix.postScale(f2, f2);
            }
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            bitmap.recycle();
            return bitmap2;
        } catch (Error e2) {
            e2.printStackTrace();
            return bitmap2;
        }
    }

    public static Bitmap zoomPic(String str, int i2, int i3, Bitmap.Config config) {
        return decodeSampledBitmapFromPath(str, i2, i3, config);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static Bitmap getBitmapByPath(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File((String) str));
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (OutOfMemoryError e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                throw th;
            }
            try {
                bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                str = fileInputStream;
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                str = fileInputStream;
                str.close();
                return bitmap;
            } catch (OutOfMemoryError e5) {
                e = e5;
                e.printStackTrace();
                str = fileInputStream;
                str.close();
                return bitmap;
            }
            try {
                str.close();
            } catch (Exception unused2) {
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = str;
            fileInputStream2.close();
            throw th;
        }
    }

    private static File compress(String str, String str2, int i2, int i3, int i4, long j2) {
        Bitmap compress = compress(str, i2, i3);
        if (i4 > 0) {
            compress = rotatingImage(i4, compress);
        }
        return saveImage(str2, compress, j2);
    }

    public static void saveImageToGallery(Context context, Bitmap bitmap, String str) {
        String str2 = System.currentTimeMillis() + ".jpg";
        File file = new File(str, str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), str2, (String) null);
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file.getAbsolutePath())));
    }
}
