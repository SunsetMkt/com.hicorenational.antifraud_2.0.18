package com.luck.picture.lib;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PictureSelectorExternalUtils {
    public static ExifInterface getExifInterface(Context context, String str) {
        InputStream inputStream;
        ExifInterface exifInterface;
        InputStream inputStream2 = null;
        try {
            try {
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(str)) {
                    inputStream = context.getContentResolver().openInputStream(Uri.parse(str));
                    if (inputStream != null) {
                        try {
                            inputStream2 = inputStream;
                            exifInterface = new ExifInterface(inputStream);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            PictureFileUtils.close(inputStream);
                            return null;
                        }
                    } else {
                        inputStream2 = inputStream;
                        exifInterface = null;
                    }
                } else {
                    exifInterface = new ExifInterface(str);
                }
                PictureFileUtils.close(inputStream2);
                return exifInterface;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                PictureFileUtils.close(inputStream2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = context;
            PictureFileUtils.close(inputStream2);
            throw th;
        }
    }
}
