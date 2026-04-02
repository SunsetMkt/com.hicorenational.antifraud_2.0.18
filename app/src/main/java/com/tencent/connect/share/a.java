package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e2);
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
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i6 > i3 || i4 > i2;
    }

    public static final void a(final Context context, final String str, final d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!m.a()) {
            dVar.a(2, (String) null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i2 = message.what;
                    if (i2 == 101) {
                        dVar.a(0, (ArrayList<String>) message.obj);
                    } else if (i2 != 102) {
                        super.handleMessage(message);
                    } else {
                        dVar.a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                /* JADX WARN: Removed duplicated region for block: B:22:0x00e4  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x00e6 A[Catch: Exception -> 0x0175, TryCatch #0 {Exception -> 0x0175, blocks: (B:3:0x0004, B:5:0x000e, B:7:0x0017, B:13:0x0087, B:15:0x00ad, B:20:0x00c4, B:29:0x0121, B:31:0x012d, B:33:0x0135, B:35:0x013b, B:23:0x00e6, B:25:0x00ec, B:16:0x00b3, B:8:0x0038, B:10:0x003e, B:12:0x0051), top: B:41:0x0004 }] */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0120  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    String str2;
                    String str3;
                    String strA;
                    boolean zM;
                    ArrayList arrayList;
                    String str4;
                    try {
                        Bitmap bitmapA = a.a(str, 840);
                        if (bitmapA != null) {
                            File fileA = g.a("Images");
                            if (fileA != null) {
                                str3 = fileA.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR + File.separator;
                                str2 = null;
                            } else {
                                File fileD = g.d();
                                if (fileD == null) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message messageObtainMessage = handler.obtainMessage();
                                    messageObtainMessage.arg1 = 102;
                                    handler.sendMessage(messageObtainMessage);
                                    return;
                                }
                                String absolutePath = fileD.getAbsolutePath();
                                String str5 = absolutePath + File.separator + Constants.QQ_SHARE_TEMP_DIR + File.separator;
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + str5);
                                str2 = absolutePath;
                                str3 = str5;
                            }
                            String str6 = "share2qq_temp" + m.g(str) + ".jpg";
                            String str7 = str;
                            if (a.b(str, 840, 840)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                strA = a.a(bitmapA, str3, str6);
                                if (!TextUtils.isEmpty(strA)) {
                                }
                                zM = m.m(strA);
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + zM);
                                arrayList = new ArrayList(2);
                                if (!zM) {
                                    str4 = strA;
                                } else if (TextUtils.isEmpty(str2)) {
                                    str4 = str3 + str6;
                                    boolean zA = m.a(context, strA, str4);
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str4 + ",isSuccess=" + zA);
                                    if (!zA) {
                                        str4 = null;
                                    }
                                }
                                arrayList.add(strA);
                                arrayList.add(str4);
                                if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + ((String) arrayList.get(1)) + "]");
                                    Message messageObtainMessage2 = handler.obtainMessage(101);
                                    messageObtainMessage2.obj = arrayList;
                                    handler.sendMessage(messageObtainMessage2);
                                    return;
                                }
                            } else {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            }
                            strA = str7;
                            zM = m.m(strA);
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + zM);
                            arrayList = new ArrayList(2);
                            if (!zM) {
                            }
                            arrayList.add(strA);
                            arrayList.add(str4);
                            if (arrayList.size() >= 2) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + ((String) arrayList.get(1)) + "]");
                                Message messageObtainMessage22 = handler.obtainMessage(101);
                                messageObtainMessage22.obj = arrayList;
                                handler.sendMessage(messageObtainMessage22);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e2);
                    }
                    SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message messageObtainMessage3 = handler.obtainMessage(102);
                    messageObtainMessage3.arg1 = 3;
                    handler.sendMessage(messageObtainMessage3);
                }
            }).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i2) {
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

    private static int b(BitmapFactory.Options options, int i2, int i3) {
        int iMin;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int iCeil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / ((double) i3)));
        if (i2 == -1) {
            iMin = 128;
        } else {
            double d4 = i2;
            iMin = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? iCeil : iMin;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String string = stringBuffer.toString();
        File file2 = new File(string);
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
            return string;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final Bitmap a(String str, int i2) {
        Bitmap bitmapDecodeFile;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e2);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return null;
        }
        if (i3 <= i4) {
            i3 = i4;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i3 > i2) {
            options.inSampleSize = a(options, -1, i2 * i2);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        } catch (Exception e3) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception2:", e3);
            bitmapDecodeFile = null;
        } catch (OutOfMemoryError e4) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap OutOfMemoryError:", e4);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
            return null;
        }
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        if (i5 <= i6) {
            i5 = i6;
        }
        return i5 > i2 ? a(bitmapDecodeFile, i2) : bitmapDecodeFile;
    }

    public static final int a(BitmapFactory.Options options, int i2, int i3) {
        int iB = b(options, i2, i3);
        if (iB > 8) {
            return ((iB + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < iB) {
            i4 <<= 1;
        }
        return i4;
    }
}
