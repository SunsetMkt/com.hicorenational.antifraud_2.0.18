package com.luck.picture.lib.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.android.SystemUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MediaUtils {
    public static final String HUAWEI_RECORD_PATH = "Sounds/CallRecord";
    public static final String HUAWEI_RECORD_PATH_pt = "Sounds";
    public static final String LETV_RECORD_PATH = "Recorder/remote";
    public static final String LETV_RECORD_PATH_pt = "Recorder";
    public static final String OPPO_RECORD_PATH = "Recordings/Call Recordings";
    public static final String OPPO_RECORD_PATH_6 = "Recordings";
    public static final String SANUNG_RECORD_PATH = "Sounds";
    public static final String VIVO_RECORD_PATH = "录音/通话录音";
    public static final String VIVO_RECORD_PATH_OT = "Record";
    public static final String VIVO_RECORD_PATH_OT_pt = "Record/Call";
    public static final String VIVO_RECORD_PATH_pt = "录音";
    public static final String XIAOMI_RECORD_PATH = "MIUI/sound_recorder/call_rec";
    public static final String XIAOMI_RECORD_PATH_pt = "MIUI/sound_recorder";

    @Nullable
    public static Uri createImageUri(Context context) {
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", valueOf);
        contentValues.put("mime_type", "image/jpeg");
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", PictureMimeType.DCIM);
            uriArr[0] = context.getContentResolver().insert(MediaStore.Images.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = context.getContentResolver().insert(MediaStore.Images.Media.getContentUri(UMModuleRegister.INNER), contentValues);
        }
        return uriArr[0];
    }

    @Nullable
    public static Uri createVideoUri(Context context) {
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        contentValues.put("datetaken", valueOf);
        contentValues.put("mime_type", "video/mp4");
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", PictureMimeType.DCIM);
            uriArr[0] = context.getContentResolver().insert(MediaStore.Video.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = context.getContentResolver().insert(MediaStore.Video.Media.getContentUri(UMModuleRegister.INNER), contentValues);
        }
        return uriArr[0];
    }

    public static long extractDuration(Context context, boolean z, String str) {
        return z ? getLocalDuration(context, Uri.parse(str)) : getLocalDuration(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r1 == null) goto L15;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAudioFilePathFromUri(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            android.content.Context r8 = r8.getApplicationContext()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            if (r1 == 0) goto L24
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.String r8 = "_data"
            int r8 = r1.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.String r8 = r1.getString(r8)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0 = r8
        L24:
            if (r1 == 0) goto L33
        L26:
            r1.close()
            goto L33
        L2a:
            r8 = move-exception
            goto L34
        L2c:
            r8 = move-exception
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L33
            goto L26
        L33:
            return r0
        L34:
            if (r1 == 0) goto L39
            r1.close()
        L39:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.tools.MediaUtils.getAudioFilePathFromUri(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static boolean getFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = Build.BRAND;
        if (str2.equalsIgnoreCase("xiaomi")) {
            if (str.contains("MIUI/sound_recorder/call_rec") || str.contains(XIAOMI_RECORD_PATH_pt)) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("oppo")) {
            if (str.contains("Recordings/Call Recordings") || str.contains("Recordings")) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("huawei") || str2.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR)) {
            if (str.contains("Sounds/CallRecord") || str.contains("Sounds")) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("vivo")) {
            if (str.contains("录音/通话录音") || str.contains(VIVO_RECORD_PATH_pt) || str.contains(VIVO_RECORD_PATH_OT) || str.contains(VIVO_RECORD_PATH_OT_pt)) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("sansung")) {
            if (str.contains("Sounds")) {
                return true;
            }
        } else if (str2.equalsIgnoreCase("Letv") && (str.contains("Recorder/remote") || str.contains(LETV_RECORD_PATH_pt))) {
            return true;
        }
        return false;
    }

    public static int getImageOrientationForUrl(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        ExifInterface exifInterface = null;
        InputStream inputStream3 = null;
        try {
            try {
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(str)) {
                    inputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (inputStream != null) {
                        try {
                            exifInterface = new ExifInterface(inputStream);
                        } catch (Exception e2) {
                            e = e2;
                            inputStream3 = inputStream;
                            e.printStackTrace();
                            PictureFileUtils.close(inputStream3);
                            return 0;
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            PictureFileUtils.close(inputStream2);
                            throw th;
                        }
                    }
                } else {
                    exifInterface = new ExifInterface(str);
                    inputStream = null;
                }
                int attributeInt = exifInterface != null ? exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1) : 0;
                PictureFileUtils.close(inputStream);
                return attributeInt;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int[] getImageSizeForUri(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptor;
        int[] iArr = new int[2];
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        try {
            try {
                parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                if (parcelFileDescriptor != null) {
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                        parcelFileDescriptor2 = null;
                        iArr[0] = options.outWidth;
                        iArr[1] = options.outHeight;
                    } catch (Exception e2) {
                        e = e2;
                        parcelFileDescriptor2 = parcelFileDescriptor;
                        e.printStackTrace();
                        PictureFileUtils.close(parcelFileDescriptor2);
                        return iArr;
                    } catch (Throwable th) {
                        th = th;
                        PictureFileUtils.close(parcelFileDescriptor);
                        throw th;
                    }
                }
                PictureFileUtils.close(parcelFileDescriptor);
            } catch (Exception e3) {
                e = e3;
            }
            return iArr;
        } catch (Throwable th2) {
            th = th2;
            parcelFileDescriptor = parcelFileDescriptor2;
        }
    }

    public static int[] getImageSizeForUrl(String str) {
        int[] iArr = new int[2];
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 1);
            int attributeInt2 = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, 1);
            iArr[0] = attributeInt;
            iArr[1] = attributeInt2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r1 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getImageSizeForUrlToAndroidQ(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 2
            int[] r0 = new int[r0]
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r3 = 26
            if (r2 < r3) goto L3a
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            android.database.Cursor r1 = r4.query(r5, r1, r1, r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r1 == 0) goto L3a
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r4 = 0
            java.lang.String r5 = "width"
            int r5 = r1.getColumnIndexOrThrow(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            int r5 = r1.getInt(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r0[r4] = r5     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r4 = 1
            java.lang.String r5 = "height"
            int r5 = r1.getColumnIndexOrThrow(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            int r5 = r1.getInt(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r0[r4] = r5     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
        L3a:
            if (r1 == 0) goto L49
        L3c:
            r1.close()
            goto L49
        L40:
            r4 = move-exception
            goto L4a
        L42:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L49
            goto L3c
        L49:
            return r0
        L4a:
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.tools.MediaUtils.getImageSizeForUrlToAndroidQ(android.content.Context, java.lang.String):int[]");
    }

    public static int getLastImageId(Context context, String str) {
        Cursor cursor = null;
        try {
            try {
                cursor = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data like ?", new String[]{PictureFileUtils.getDCIMCameraPath(context, str) + "%"}, "_id DESC");
                if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                }
                int i2 = cursor.getInt(cursor.getColumnIndex(bl.f10170d));
                if (DateUtils.dateDiffer(cursor.getLong(cursor.getColumnIndex("date_added"))) > 1) {
                    i2 = -1;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return i2;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static long getLocalDuration(Context context, Uri uri) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String getRecordFolder(Context context) {
        File externalFilesDir = SdkVersionUtils.checkedAndroid_Q() ? context.getExternalFilesDir("") : Environment.getExternalStorageDirectory();
        String str = Build.BRAND;
        if (str.equalsIgnoreCase("xiaomi")) {
            return XIAOMI_RECORD_PATH_pt;
        }
        if (str.equalsIgnoreCase("oppo")) {
            return "Recordings";
        }
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR)) {
            if (str.equalsIgnoreCase("vivo")) {
                return new File(externalFilesDir, VIVO_RECORD_PATH_pt).exists() ? VIVO_RECORD_PATH_pt : VIVO_RECORD_PATH_OT;
            }
            if (!str.equalsIgnoreCase("sansung")) {
                if (str.equalsIgnoreCase("Letv")) {
                    return LETV_RECORD_PATH_pt;
                }
                return null;
            }
        }
        return "Sounds";
    }

    public static int getVideoOrientationForUri(Context context, Uri uri) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            int i2 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(24));
            if (i2 != 90) {
                return i2 != 270 ? 0 : 8;
            }
            return 6;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getVideoOrientationForUrl(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i2 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(24));
            if (i2 != 90) {
                return i2 != 270 ? 0 : 8;
            }
            return 6;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int[] getVideoSizeForUri(Context context, Uri uri) {
        int[] iArr = new int[2];
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            iArr[0] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            iArr[1] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public static int[] getVideoSizeForUrl(String str) {
        int[] iArr = new int[2];
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            iArr[0] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            iArr[1] = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iArr;
    }

    public static boolean isLongImg(int i2, int i3) {
        return i3 > i2 * 3;
    }

    public static boolean isLongImg(LocalMedia localMedia) {
        if (localMedia != null) {
            return localMedia.getHeight() > localMedia.getWidth() * 3;
        }
        return false;
    }

    public static void removeMedia(Context context, int i2) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString(i2)});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int setOrientation(Context context, LocalMedia localMedia) {
        if (localMedia.getOrientation() != -1) {
            return localMedia.getOrientation();
        }
        int i2 = 0;
        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
            i2 = getImageOrientationForUrl(context, localMedia.getPath());
        } else if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
            i2 = PictureMimeType.isContent(localMedia.getPath()) ? getVideoOrientationForUri(context, Uri.parse(localMedia.getPath())) : getVideoOrientationForUrl(localMedia.getPath());
        }
        if (i2 == 6 || i2 == 8) {
            int width = localMedia.getWidth();
            localMedia.setWidth(localMedia.getHeight());
            localMedia.setHeight(width);
        }
        localMedia.setOrientation(i2);
        return i2;
    }

    private static long getLocalDuration(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }
}
