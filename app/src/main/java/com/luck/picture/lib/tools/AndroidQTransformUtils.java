package com.luck.picture.lib.tools;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import java.io.File;
import java.io.InputStream;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidQTransformUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c A[PHI: r3
  0x006c: PHI (r3v6 okio.BufferedSource) = (r3v13 okio.BufferedSource), (r3v14 okio.BufferedSource) binds: [B:32:0x006a, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String copyPathToAndroidQ(Context context, String str, int i2, int i3, String str2, String str3) throws Throwable {
        BufferedSource bufferedSourceBuffer;
        BufferedSource bufferedSource;
        Uri uri;
        String strCreateFilePath;
        File file;
        boolean zBufferCopy;
        CacheResourcesEngine cacheResourcesEngine = PictureSelectionConfig.cacheResourcesEngine;
        if (cacheResourcesEngine != null) {
            String strOnCachePath = cacheResourcesEngine.onCachePath(context, str);
            if (!TextUtils.isEmpty(strOnCachePath)) {
                return strOnCachePath;
            }
        }
        ?? r0 = 0;
        try {
            try {
                uri = Uri.parse(str);
                strCreateFilePath = PictureFileUtils.createFilePath(context, DESUtils.encode(DESUtils.DES_KEY_STRING, str, i2, i3), str2, str3);
                file = new File(strCreateFilePath);
            } catch (Exception e2) {
                e = e2;
                bufferedSourceBuffer = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    PictureFileUtils.close(r0);
                }
                throw th;
            }
            if (file.exists()) {
                return strCreateFilePath;
            }
            bufferedSourceBuffer = Okio.buffer(Okio.source((InputStream) Objects.requireNonNull(context.getContentResolver().openInputStream(uri))));
            try {
                zBufferCopy = PictureFileUtils.bufferCopy(bufferedSourceBuffer, file);
                context = bufferedSourceBuffer;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                context = bufferedSourceBuffer;
                if (bufferedSourceBuffer != null) {
                }
                return null;
            }
            if (zBufferCopy) {
                if (bufferedSourceBuffer != null && bufferedSourceBuffer.isOpen()) {
                    PictureFileUtils.close(bufferedSourceBuffer);
                }
                return strCreateFilePath;
            }
            if (bufferedSourceBuffer != null) {
                boolean zIsOpen = bufferedSourceBuffer.isOpen();
                bufferedSource = bufferedSourceBuffer;
                context = bufferedSourceBuffer;
                if (zIsOpen) {
                    PictureFileUtils.close(bufferedSource);
                    context = bufferedSource;
                }
            }
            return null;
            e.printStackTrace();
            context = bufferedSourceBuffer;
            if (bufferedSourceBuffer != null) {
                boolean zIsOpen2 = bufferedSourceBuffer.isOpen();
                bufferedSource = bufferedSourceBuffer;
                context = bufferedSourceBuffer;
                if (zIsOpen2) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r0 = context;
            if (r0 != 0 && r0.isOpen()) {
                PictureFileUtils.close(r0);
            }
            throw th;
        }
    }

    public static boolean copyPathToDCIM(Context context, File file, Uri uri) {
        try {
            return PictureFileUtils.bufferCopy(file, context.getContentResolver().openOutputStream(uri));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
