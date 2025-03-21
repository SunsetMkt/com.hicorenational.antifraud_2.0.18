package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.InterfaceC3286d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.share.a */
/* loaded from: classes2.dex */
public class C3229a {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final boolean m10345b(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            SLog.m10501e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e2);
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (options.mCancel || i4 == -1 || i5 == -1) {
            return false;
        }
        int i6 = i4 > i5 ? i4 : i5;
        if (i4 >= i5) {
            i4 = i5;
        }
        SLog.m10498d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i6 > i3 || i4 > i2;
    }

    /* renamed from: a */
    public static final void m10342a(final Context context, final String str, final InterfaceC3286d interfaceC3286d) {
        SLog.m10502i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            interfaceC3286d.mo10333a(1, (String) null);
        } else if (!C3295m.m10677a()) {
            interfaceC3286d.mo10333a(2, (String) null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i2 = message.what;
                    if (i2 == 101) {
                        interfaceC3286d.mo10334a(0, (ArrayList<String>) message.obj);
                    } else if (i2 != 102) {
                        super.handleMessage(message);
                    } else {
                        interfaceC3286d.mo10333a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                /* JADX WARN: Removed duplicated region for block: B:14:0x00e4  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x00e6 A[Catch: Exception -> 0x0175, TryCatch #0 {Exception -> 0x0175, blocks: (B:3:0x0004, B:5:0x000e, B:7:0x0017, B:8:0x0087, B:10:0x00ad, B:12:0x00c4, B:15:0x0121, B:17:0x012d, B:19:0x0135, B:21:0x013b, B:24:0x00e6, B:26:0x00ec, B:30:0x00b3, B:33:0x0038, B:35:0x003e, B:37:0x0051), top: B:2:0x0004 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 399
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.C3229a.AnonymousClass2.run():void");
                }
            }).start();
        }
    }

    /* renamed from: a */
    private static Bitmap m10339a(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f2 = i2 / width;
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: b */
    private static int m10344b(BitmapFactory.Options options, int i2, int i3) {
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
        if (i2 == -1) {
            min = 128;
        } else {
            double d4 = i2;
            min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? ceil : min;
    }

    /* renamed from: a */
    protected static final String m10341a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return stringBuffer2;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap m10340a(java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = "openSDK_LOG.AsynScaleCompressImage"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r3 = 1
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L16
            goto L1c
        L16:
            r3 = move-exception
            java.lang.String r4 = "scaleBitmap exception1:"
            com.tencent.open.log.SLog.m10501e(r0, r4, r3)
        L1c:
            int r3 = r1.outWidth
            int r4 = r1.outHeight
            boolean r5 = r1.mCancel
            if (r5 != 0) goto L69
            r5 = -1
            if (r3 == r5) goto L69
            if (r4 != r5) goto L2a
            goto L69
        L2a:
            if (r3 <= r4) goto L2d
            goto L2e
        L2d:
            r3 = r4
        L2e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r1.inPreferredConfig = r4
            if (r3 <= r7) goto L3c
            int r3 = r7 * r7
            int r3 = m10338a(r1, r5, r3)
            r1.inSampleSize = r3
        L3c:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L44 java.lang.Exception -> L4b
            goto L52
        L44:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            com.tencent.open.log.SLog.m10501e(r0, r3, r6)
            goto L51
        L4b:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            com.tencent.open.log.SLog.m10501e(r0, r3, r6)
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "scaleBitmap return null"
            com.tencent.open.log.SLog.m10500e(r0, r6)
            return r2
        L5a:
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            if (r0 <= r1) goto L61
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 <= r7) goto L68
            android.graphics.Bitmap r6 = m10339a(r6, r7)
        L68:
            return r6
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.C3229a.m10340a(java.lang.String, int):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static final int m10338a(BitmapFactory.Options options, int i2, int i3) {
        int m10344b = m10344b(options, i2, i3);
        if (m10344b > 8) {
            return ((m10344b + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < m10344b) {
            i4 <<= 1;
        }
        return i4;
    }
}
