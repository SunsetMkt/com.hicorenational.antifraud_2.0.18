package cn.cloudwalk.libproject.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.umeng.analytics.pro.bl;
import java.io.IOException;

/* loaded from: classes.dex */
public class ThumbnailUtil {
    static final String TAG = "ThumbnailUtil";

    public static Bitmap getDicmThumbnail(Uri uri, Context context) {
        String[] realPathFromURI = getRealPathFromURI(uri, context);
        if (realPathFromURI == null || realPathFromURI.length < 2) {
            return null;
        }
        return getThumbnail(context.getContentResolver(), Long.parseLong(realPathFromURI[1]));
    }

    public static String[] getRealPathFromURI(Uri uri, Context context) {
        Cursor cursor;
        String[] strArr;
        String[] strArr2 = {"_data", bl.f10170d};
        try {
            cursor = context.getContentResolver().query(uri, strArr2, null, null, null);
            try {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow(strArr2[0]);
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(strArr2[1]);
                cursor.moveToFirst();
                strArr = new String[]{cursor.getString(columnIndexOrThrow), cursor.getLong(columnIndexOrThrow2) + ""};
                try {
                    cursor.close();
                } catch (Exception e2) {
                    e = e2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    e.printStackTrace();
                    return strArr;
                }
            } catch (Exception e3) {
                e = e3;
                strArr = null;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
            strArr = null;
        }
        return strArr;
    }

    public static Bitmap getThumbnail(ContentResolver contentResolver, long j2) {
        int i2 = 0;
        Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data"}, "_id=?", new String[]{String.valueOf(j2)}, null);
        if (query == null || query.getCount() <= 0) {
            return null;
        }
        query.moveToFirst();
        String string = query.getString(0);
        query.close();
        try {
            int attributeInt = new ExifInterface(string).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt != 0) {
                if (attributeInt == 3) {
                    i2 = 180;
                } else if (attributeInt == 6) {
                    i2 = 90;
                } else if (attributeInt == 8) {
                    i2 = SubsamplingScaleImageView.ORIENTATION_270;
                }
            }
        } catch (IOException e2) {
            LogUtils.LOGE(TAG, e2.toString());
        }
        Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, j2, 1, null);
        int width = thumbnail.getWidth();
        int height = thumbnail.getHeight();
        if (i2 != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2);
            thumbnail = Bitmap.createBitmap(thumbnail, 0, 0, width, height, matrix, true);
        }
        LogUtils.LOGE(TAG, "缩略图长宽:" + width + "" + height);
        return thumbnail;
    }
}
