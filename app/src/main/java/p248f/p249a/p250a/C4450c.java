package p248f.p249a.p250a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ImageUtil.java */
/* renamed from: f.a.a.c */
/* loaded from: classes2.dex */
class C4450c {
    private C4450c() {
    }

    /* renamed from: a */
    static File m16434a(File file, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str) throws IOException {
        FileOutputStream fileOutputStream;
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            m16433a(file, i2, i3).compress(compressFormat, i4, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return new File(str);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    static Bitmap m16433a(File file, int i2, int i3) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = m16432a(options, i2, i3);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        Matrix matrix = new Matrix();
        if (attributeInt == 6) {
            matrix.postRotate(90.0f);
        } else if (attributeInt == 3) {
            matrix.postRotate(180.0f);
        } else if (attributeInt == 8) {
            matrix.postRotate(270.0f);
        }
        return Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
    }

    /* renamed from: a */
    private static int m16432a(BitmapFactory.Options options, int i2, int i3) {
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
}
