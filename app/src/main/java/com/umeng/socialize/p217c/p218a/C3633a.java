package com.umeng.socialize.p217c.p218a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.p217c.p219b.C3635b;
import com.umeng.socialize.p217c.p219b.C3636c;
import com.umeng.socialize.p217c.p219b.C3637d;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ImageImpl.java */
/* renamed from: com.umeng.socialize.c.a.a */
/* loaded from: classes2.dex */
public class C3633a {
    /* renamed from: a */
    public static byte[] m12617a(UMImage uMImage, int i2) {
        if (uMImage == null) {
            return DefaultClass.getBytes();
        }
        if (uMImage.asBinImage() == null || m12610a(uMImage) < i2) {
            return uMImage.asBinImage();
        }
        if (uMImage.compressStyle == UMImage.CompressStyle.QUALITY) {
            return m12620a(uMImage.asBinImage(), i2, uMImage.compressFormat);
        }
        try {
            byte[] asBinImage = uMImage.asBinImage();
            if (asBinImage == null) {
                return new byte[1];
            }
            if (asBinImage.length <= 0) {
                return uMImage.asBinImage();
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(asBinImage, 0, asBinImage.length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(asBinImage, 0, asBinImage.length);
            while (byteArrayOutputStream.toByteArray().length > i2) {
                double sqrt = Math.sqrt((asBinImage.length * 1.0d) / i2);
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, (int) (decodeByteArray.getWidth() / sqrt), (int) (decodeByteArray.getHeight() / sqrt), true);
                byteArrayOutputStream.reset();
                if (decodeByteArray != null) {
                    decodeByteArray.compress(uMImage.compressFormat, 100, byteArrayOutputStream);
                    asBinImage = byteArrayOutputStream.toByteArray();
                }
            }
            if (byteArrayOutputStream.toByteArray().length > i2) {
                return null;
            }
            return asBinImage;
        } catch (Throwable th) {
            SLog.error(th);
            return DefaultClass.getBytes();
        }
    }

    /* renamed from: b */
    private static byte[] m12623b(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            float rowBytes = (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
                            bitmap.compress(compressFormat, rowBytes > C3636c.f13586b ? (int) ((C3636c.f13586b / rowBytes) * 100) : 100, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                SLog.error(UmengText.IMAGE.CLOSE, e2);
                            }
                            return byteArray;
                        } catch (Exception e3) {
                            e = e3;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            SLog.error(UmengText.IMAGE.BITMAOTOBINARY, e);
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (IOException e4) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e4);
                                }
                            }
                            return DefaultClass.getBytes();
                        } catch (Throwable th) {
                            th = th;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e5) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e5);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m12625c(byte[] bArr) {
        return C3637d.m12636a(bArr);
    }

    /* renamed from: d */
    private static BitmapFactory.Options m12626d(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int ceil = (int) Math.ceil(options.outWidth / UMImage.MAX_WIDTH);
        int ceil2 = (int) Math.ceil(options.outHeight / UMImage.MAX_HEIGHT);
        if (ceil2 <= 1 || ceil <= 1) {
            if (ceil2 > 2) {
                options.inSampleSize = ceil2;
            } else if (ceil > 2) {
                options.inSampleSize = ceil;
            }
        } else if (ceil2 > ceil) {
            options.inSampleSize = ceil2;
        } else {
            options.inSampleSize = ceil;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    /* renamed from: e */
    private static int m12627e(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    /* renamed from: b */
    public static File m12622b(byte[] bArr) {
        try {
            return m12614a(bArr, C3635b.m12631a().m12633b());
        } catch (IOException e2) {
            SLog.error(UmengText.IMAGE.BINARYTOFILE, e2);
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m12624b(File file, Bitmap.CompressFormat compressFormat) {
        if (file != null && file.getAbsoluteFile().exists()) {
            byte[] m12632a = C3635b.m12631a().m12632a(file);
            if (SocializeUtils.assertBinaryInvalid(m12632a)) {
                return C3637d.f13599m[1].equals(C3637d.m12636a(m12632a)) ? m12632a : m12621a(m12632a, compressFormat);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m12619a(String str) {
        return SocializeNetUtils.getNetData(str);
    }

    /* renamed from: a */
    public static Bitmap m12613a(byte[] bArr) {
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    /* renamed from: a */
    private static File m12614a(byte[] bArr, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.close();
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = bufferedOutputStream2;
                        SLog.error(UmengText.IMAGE.GET_FILE_FROM_BINARY, e);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                                SLog.error(UmengText.IMAGE.CLOSE, e3);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (IOException e5) {
            SLog.error(UmengText.IMAGE.CLOSE, e5);
        }
        return file;
    }

    /* renamed from: a */
    public static byte[] m12616a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return m12623b(bitmap, compressFormat);
    }

    /* renamed from: a */
    private static Bitmap m12612a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static byte[] m12615a(Context context, int i2, boolean z, Bitmap.CompressFormat compressFormat) {
        Drawable drawable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!z) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 21) {
                drawable = resources.getDrawable(i2, null);
            } else {
                drawable = resources.getDrawable(i2);
            }
            Bitmap m12612a = m12612a(drawable);
            if (m12612a != null) {
                m12612a.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        byte[] bArr = new byte[0];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i2), null, options);
            if (decodeStream != null) {
                decodeStream.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Error e2) {
            SLog.error(UmengText.IMAGE.TOOBIG, e2);
            return bArr;
        }
    }

    /* renamed from: a */
    public static byte[] m12618a(File file, Bitmap.CompressFormat compressFormat) {
        return m12624b(file, compressFormat);
    }

    /* renamed from: a */
    public static int m12610a(UMImage uMImage) {
        if (uMImage.getImageStyle() == UMImage.FILE_IMAGE) {
            return m12611a(uMImage.asFileImage());
        }
        return m12627e(uMImage.asBinImage());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] m12621a(byte[] r4, android.graphics.Bitmap.CompressFormat r5) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = m12626d(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r2 = 0
            int r3 = r4.length     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r2, r3, r1)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r1.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            if (r4 == 0) goto L1d
            r2 = 100
            r4.compress(r5, r2, r1)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            r4.recycle()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            java.lang.System.gc()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
        L1d:
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            r1.close()     // Catch: java.io.IOException -> L25
            goto L3d
        L25:
            r4 = move-exception
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r5, r4)
            goto L3d
        L2c:
            r4 = move-exception
            goto L33
        L2e:
            r4 = move-exception
            r1 = r0
            goto L3f
        L31:
            r4 = move-exception
            r1 = r0
        L33:
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.FILE_TO_BINARY_ERROR     // Catch: java.lang.Throwable -> L3e
            com.umeng.socialize.utils.SLog.error(r5, r4)     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.io.IOException -> L25
        L3d:
            return r0
        L3e:
            r4 = move-exception
        L3f:
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.io.IOException -> L45
            goto L4b
        L45:
            r5 = move-exception
            java.lang.String r0 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r0, r5)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.p217c.p218a.C3633a.m12621a(byte[], android.graphics.Bitmap$CompressFormat):byte[]");
    }

    /* renamed from: a */
    public static byte[] m12620a(byte[] bArr, int i2, Bitmap.CompressFormat compressFormat) {
        if (bArr == null || bArr.length < i2) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int i3 = 1;
        while (!z && i3 <= 10) {
            int pow = (int) (Math.pow(0.8d, i3) * 100.0d);
            if (decodeByteArray != null) {
                decodeByteArray.compress(compressFormat, pow, byteArrayOutputStream);
            }
            if (byteArrayOutputStream.size() < i2) {
                z = true;
            } else {
                byteArrayOutputStream.reset();
                i3++;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!decodeByteArray.isRecycled()) {
            decodeByteArray.recycle();
        }
        if (byteArray != null && byteArray.length <= 0) {
            SLog.m12716E(UmengText.IMAGE.THUMB_ERROR);
        }
        return byteArray;
    }

    /* renamed from: a */
    private static int m12611a(File file) {
        if (file == null) {
            return 0;
        }
        try {
            return new FileInputStream(file).available();
        } catch (Throwable th) {
            SLog.error(UmengText.IMAGE.GET_IMAGE_SCALE_ERROR, th);
            return 0;
        }
    }
}
