package com.luck.picture.lib.tools;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.just.agentweb.AgentWebPermissions;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes.dex */
public class PictureFileUtils {
    public static final String POSTFIX = ".jpg";
    public static final String POST_AUDIO = ".mp3";
    public static final String POST_VIDEO = ".mp4";
    static final String TAG = "PictureFileUtils";
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    private PictureFileUtils() {
    }

    public static boolean bufferCopy(BufferedSource bufferedSource, File file) {
        BufferedSink bufferedSink = null;
        try {
            try {
                bufferedSink = Okio.buffer(Okio.sink(file));
                bufferedSink.writeAll(bufferedSource);
                bufferedSink.flush();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                close(bufferedSource);
                close(bufferedSink);
                return false;
            }
        } finally {
            close(bufferedSource);
            close(bufferedSink);
        }
    }

    public static void close(@Nullable Closeable closeable) {
        if (closeable == null || !(closeable instanceof Closeable)) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static void copyFile(@NonNull String str, @NonNull String str2) throws IOException {
        FileChannel fileChannel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(new File(str)).getChannel();
            try {
                fileChannel = new FileOutputStream(new File(str2)).getChannel();
                try {
                    channel.transferTo(0L, channel.size(), fileChannel);
                    channel.close();
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Throwable th) {
                    fileChannel2 = channel;
                    th = th;
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                fileChannel2 = channel;
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    @Nullable
    public static File createCameraFile(Context context, int i2, String str, String str2, String str3) {
        return createMediaFile(context, i2, str, str2, str3);
    }

    public static String createFilePath(Context context, String str, String str2, String str3) {
        String lastImgSuffix = PictureMimeType.getLastImgSuffix(str2);
        if (PictureMimeType.eqVideo(str2)) {
            String str4 = getVideoDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("VID_") + lastImgSuffix;
                }
                return str4 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "VID_" + str.toUpperCase() + lastImgSuffix;
            }
            return str4 + str3;
        }
        if (PictureMimeType.eqAudio(str2)) {
            String str5 = getAudioDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("AUD_") + lastImgSuffix;
                }
                return str5 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "AUD_" + str.toUpperCase() + lastImgSuffix;
            }
            return str5 + str3;
        }
        String str6 = getDiskCacheDir(context) + File.separator;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = DateUtils.getCreateFileName("IMG_") + lastImgSuffix;
            }
            return str6 + str3;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "IMG_" + str.toUpperCase() + lastImgSuffix;
        }
        return str6 + str3;
    }

    @Nullable
    private static File createMediaFile(Context context, int i2, String str, String str2, String str3) {
        return createOutFile(context, i2, str, str2, str3);
    }

    @Nullable
    private static File createOutFile(Context context, int i2, String str, String str2, String str3) {
        File file;
        File file2;
        if (TextUtils.isEmpty(str3)) {
            File externalStoragePublicDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : getRootDirFile(context, i2);
            if (externalStoragePublicDirectory != null) {
                if (!externalStoragePublicDirectory.exists()) {
                    externalStoragePublicDirectory.mkdirs();
                }
                file2 = new File(externalStoragePublicDirectory.getAbsolutePath() + File.separator + AgentWebPermissions.ACTION_CAMERA + File.separator);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            } else {
                file2 = null;
            }
            file = file2;
        } else {
            file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        if (file == null) {
            throw new NullPointerException("The media output path cannot be null");
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (i2 == 2) {
            if (isEmpty) {
                str = DateUtils.getCreateFileName("VID_") + ".mp4";
            }
            return new File(file, str);
        }
        if (i2 == 3) {
            if (isEmpty) {
                str = DateUtils.getCreateFileName("AUD_") + POST_AUDIO;
            }
            return new File(file, str);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = ".jpg";
        }
        if (isEmpty) {
            str = DateUtils.getCreateFileName("IMG_") + str2;
        }
        return new File(file, str);
    }

    public static void deleteAllCacheDirFile(final Context context) {
        mHandler.post(new Runnable() { // from class: com.luck.picture.lib.tools.PictureFileUtils.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                File[] listFiles2;
                File[] listFiles3;
                File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                if (externalFilesDir != null && (listFiles3 = externalFilesDir.listFiles()) != null) {
                    for (File file : listFiles3) {
                        if (file.isFile()) {
                            file.delete();
                        }
                    }
                }
                File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
                if (externalFilesDir2 != null && (listFiles2 = externalFilesDir2.listFiles()) != null) {
                    for (File file2 : listFiles2) {
                        if (file2.isFile()) {
                            file2.delete();
                        }
                    }
                }
                File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
                if (externalFilesDir3 == null || (listFiles = externalFilesDir3.listFiles()) == null) {
                    return;
                }
                for (File file3 : listFiles) {
                    if (file3.isFile()) {
                        file3.delete();
                    }
                }
            }
        });
    }

    public static void deleteCacheDirFile(Context context, int i2) {
        File[] listFiles;
        File externalFilesDir = context.getExternalFilesDir(i2 == PictureMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null || (listFiles = externalFilesDir.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    public static String extSuffix(InputStream inputStream) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return ".jpg";
        }
    }

    public static String getAudioDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        return externalFilesDir == null ? "" : externalFilesDir.getPath();
    }

    @Nullable
    public static String getDCIMCameraPath(Context context, String str) {
        try {
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                return "%" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
            }
            if (PictureMimeType.eqVideo(str)) {
                return "%" + context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
            }
            if (PictureMimeType.eqAudio(str)) {
                return "%" + context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            }
            return "%" + context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
    
        if (r8 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002d, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004c, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L34
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L34
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L4d
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L4d
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L4d
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L36
        L2b:
            if (r8 == 0) goto L4c
        L2d:
            r8.close()
            goto L4c
        L31:
            r9 = move-exception
            r8 = r7
            goto L4e
        L34:
            r9 = move-exception
            r8 = r7
        L36:
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r11 = "getDataColumn: _data - [%s]"
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4d
            r1 = 0
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L4d
            r0[r1] = r9     // Catch: java.lang.Throwable -> L4d
            java.lang.String.format(r10, r11, r0)     // Catch: java.lang.Throwable -> L4d
            if (r8 == 0) goto L4c
            goto L2d
        L4c:
            return r7
        L4d:
            r9 = move-exception
        L4e:
            if (r8 == 0) goto L53
            r8.close()
        L53:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.tools.PictureFileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String getDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return externalFilesDir == null ? "" : externalFilesDir.getPath();
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    if (SdkVersionUtils.checkedAndroid_Q()) {
                        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + split[1];
                    }
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
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
                return isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    @Nullable
    private static File getRootDirFile(Context context, int i2) {
        return i2 != 2 ? i2 != 3 ? context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : context.getExternalFilesDir(Environment.DIRECTORY_MUSIC) : context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
    }

    public static String getVideoDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        return externalFilesDir == null ? "" : externalFilesDir.getPath();
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri parUri(Context context, File file) {
        return Build.VERSION.SDK_INT > 23 ? FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file) : Uri.fromFile(file);
    }

    public static int readPictureDegree(Context context, String str) {
        try {
            int attributeInt = (SdkVersionUtils.checkedAndroid_Q() ? new ExifInterface(context.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor()) : new ExifInterface(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean bufferCopy(BufferedSource bufferedSource, OutputStream outputStream) {
        BufferedSink bufferedSink = null;
        try {
            try {
                bufferedSink = Okio.buffer(Okio.sink(outputStream));
                bufferedSink.writeAll(bufferedSource);
                bufferedSink.flush();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                close(bufferedSource);
                close(bufferedSink);
                return false;
            }
        } finally {
            close(bufferedSource);
            close(bufferedSink);
        }
    }

    public static boolean bufferCopy(File file, OutputStream outputStream) {
        Source source;
        BufferedSink bufferedSink;
        BufferedSink bufferedSink2 = null;
        try {
            source = Okio.buffer(Okio.source(file));
        } catch (Exception e2) {
            e = e2;
            bufferedSink = null;
        } catch (Throwable th) {
            th = th;
            source = null;
        }
        try {
            bufferedSink2 = Okio.buffer(Okio.sink(outputStream));
            bufferedSink2.writeAll(source);
            bufferedSink2.flush();
            close(source);
            close(outputStream);
            close(bufferedSink2);
            return true;
        } catch (Exception e3) {
            e = e3;
            BufferedSink bufferedSink3 = bufferedSink2;
            bufferedSink2 = source;
            bufferedSink = bufferedSink3;
            try {
                e.printStackTrace();
                close(bufferedSink2);
                close(outputStream);
                close(bufferedSink);
                return false;
            } catch (Throwable th2) {
                th = th2;
                BufferedSink bufferedSink4 = bufferedSink2;
                bufferedSink2 = bufferedSink;
                source = bufferedSink4;
                close(source);
                close(outputStream);
                close(bufferedSink2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            close(source);
            close(outputStream);
            close(bufferedSink2);
            throw th;
        }
    }
}
