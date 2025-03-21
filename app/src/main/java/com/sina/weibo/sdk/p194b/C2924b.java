package com.sina.weibo.sdk.p194b;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;

/* renamed from: com.sina.weibo.sdk.b.b */
/* loaded from: classes.dex */
public final class C2924b {
    @TargetApi(19)
    /* renamed from: a */
    public static String m8827a(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (m8831b(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if (m8832c(uri)) {
                    return m8828a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (m8834d(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return m8828a(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return m8836e(uri) ? uri.getLastPathSegment() : m8829b(context, uri);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m8830b(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(absolutePath, options);
            String str = options.outMimeType;
            if (!str.contains("jpg") && !str.contains("gif") && !str.contains("png")) {
                if (!str.contains("jpeg")) {
                    return null;
                }
            }
            return "image/*";
        } catch (Exception unused) {
            return "*/*";
        }
    }

    /* renamed from: c */
    private static boolean m8832c(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* renamed from: d */
    private static boolean m8834d(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* renamed from: e */
    public static long m8835e(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return 0L;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    /* renamed from: c */
    public static boolean m8833c(File file) {
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    /* renamed from: b */
    private static boolean m8831b(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* renamed from: e */
    private static boolean m8836e(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* renamed from: b */
    public static String m8829b(Context context, Uri uri) {
        String uri2 = uri.toString();
        return new File(context.getExternalFilesDir(null), uri2.substring(uri2.lastIndexOf("/"))).getAbsolutePath();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r7 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        return m8829b(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r7 == null) goto L20;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m8828a(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            if (r7 == 0) goto L2b
            boolean r10 = r7.moveToFirst()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            if (r10 == 0) goto L2b
            int r10 = r7.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            java.lang.String r8 = r7.getString(r10)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            if (r7 == 0) goto L28
            r7.close()
        L28:
            return r8
        L29:
            goto L35
        L2b:
            if (r7 == 0) goto L3a
            goto L37
        L2e:
            r8 = move-exception
            if (r7 == 0) goto L34
            r7.close()
        L34:
            throw r8
        L35:
            if (r7 == 0) goto L3a
        L37:
            r7.close()
        L3a:
            java.lang.String r8 = m8829b(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.p194b.C2924b.m8828a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }
}
