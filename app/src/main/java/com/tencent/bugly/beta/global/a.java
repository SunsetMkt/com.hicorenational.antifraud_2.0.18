package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.p;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import util.x1;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return 0;
                }
            }
        } catch (Exception e2) {
            if (!an.a(e2)) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public static String b(String str) {
        return new com.tencent.bugly.beta.utils.c(str).a();
    }

    public static String b(String str, String str2) {
        SharedPreferences sharedPreferences = e.G.C;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static boolean b(String str, boolean z) {
        SharedPreferences sharedPreferences = e.G.C;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static BitmapDrawable a(Bitmap bitmap, int i2, int i3, float f2) {
        DisplayMetrics displayMetrics = e.G.D;
        int i4 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i2 * i3 > i4) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i2, i3);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        canvas.drawRect(0.0f, f2, i2, i3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(bitmapCreateBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00dd A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:81:0x0014, B:84:0x001f, B:86:0x002e, B:95:0x004b, B:97:0x0053, B:99:0x005c, B:102:0x006d, B:119:0x00c5, B:121:0x00cd, B:124:0x00dd, B:128:0x00e9, B:120:0x00c8, B:108:0x00a2, B:105:0x0088, B:101:0x0066, B:92:0x003f), top: B:135:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0053 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:81:0x0014, B:84:0x001f, B:86:0x002e, B:95:0x004b, B:97:0x0053, B:99:0x005c, B:102:0x006d, B:119:0x00c5, B:121:0x00cd, B:124:0x00dd, B:128:0x00e9, B:120:0x00c8, B:108:0x00a2, B:105:0x0088, B:101:0x0066, B:92:0x003f), top: B:135:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, int i2, Object... objArr) {
        File file;
        int iIntValue;
        int i3;
        File file2;
        BitmapFactory.Options options;
        int iMin;
        int i4;
        if (objArr != null && objArr.length > 0) {
            int iCeil = 1;
            if (i2 == 0 || i2 == 1) {
                try {
                    if (i2 == 0) {
                        if (TextUtils.isEmpty((String) objArr[0])) {
                            return null;
                        }
                        file = new File((String) objArr[0]);
                        if (!file.exists() || file.length() > 1048576) {
                            return null;
                        }
                    } else {
                        if (i2 == 1) {
                            iIntValue = ((Integer) objArr[0]).intValue();
                            file = null;
                            i3 = e.G.D.widthPixels;
                            if (i3 <= 0) {
                                options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                if (i2 == 0) {
                                    BitmapFactory.decodeFile(file.getPath(), options);
                                } else if (i2 == 1) {
                                    BitmapFactory.decodeResource(context.getResources(), iIntValue, options);
                                }
                                int i5 = (int) (i3 * (options.outHeight / options.outWidth));
                                int iMin2 = Math.min(i3, i5);
                                double d2 = options.outWidth;
                                double d3 = options.outHeight;
                                int i6 = i3 * i5;
                                if (i6 != -1) {
                                    iCeil = (int) Math.ceil(Math.sqrt(((d2 * d3) / ((double) i3)) * ((double) i5)));
                                }
                                if (iMin2 == -1) {
                                    file2 = file;
                                    iMin = 128;
                                } else {
                                    file2 = file;
                                    double d4 = iMin2;
                                    iMin = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
                                }
                                if (i6 == -1 && iMin2 == -1) {
                                    iCeil = 1;
                                } else if (iMin2 != -1) {
                                    iCeil = iMin;
                                }
                                if (iCeil <= 8) {
                                    i4 = 1;
                                    while (i4 < iCeil) {
                                        i4 <<= 1;
                                    }
                                } else {
                                    i4 = ((iCeil + 7) / 8) * 8;
                                }
                                options.inSampleSize = i4;
                                options.inJustDecodeBounds = false;
                                options.inInputShareable = true;
                                options.inPurgeable = true;
                            } else {
                                file2 = file;
                                options = null;
                            }
                            if (i2 != 0) {
                                return BitmapFactory.decodeFile(file2.getPath(), options);
                            }
                            if (i2 == 1) {
                                return BitmapFactory.decodeResource(context.getResources(), iIntValue, options);
                            }
                            return null;
                        }
                        file = null;
                    }
                    iIntValue = 0;
                    i3 = e.G.D.widthPixels;
                    if (i3 <= 0) {
                    }
                    if (i2 != 0) {
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public static boolean a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(x1.f15111d)) {
                    String strA = aq.a(file, "MD5");
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), strA)) {
                        an.a("md5 error [file md5: %s] [target md5: %s]", strA, str);
                        return false;
                    }
                    Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        if (Class.forName("androidx.core.content.FileProvider") == null) {
                            an.e("can't find class android.support.v4.content.FileProvider", new Object[0]);
                            return false;
                        }
                        Uri uri = (Uri) aq.a("androidx.core.content.FileProvider", "getUriForFile", null, new Class[]{Context.class, String.class, File.class}, new Object[]{context, com.tencent.bugly.crashreport.common.info.a.a(context).f6175d + ".fileProvider", file});
                        if (uri == null) {
                            an.e("file location is " + file.toString(), new Object[0]);
                            an.e("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        an.c("contentUri is " + uri, new Object[0]);
                        intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    }
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent);
                    a("installApkMd5", strA);
                    return true;
                }
            } catch (Exception e2) {
                if (!an.b(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean a(File file, String str, String str2) throws Throwable {
        if (file != null) {
            try {
                if (file.exists()) {
                    String strA = aq.a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), strA)) {
                        return true;
                    }
                    an.a("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", strA, str);
                    return false;
                }
            } catch (Exception unused) {
                an.e("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0061 A[Catch: IOException -> 0x005d, TRY_LEAVE, TryCatch #8 {IOException -> 0x005d, blocks: (B:110:0x0059, B:114:0x0061), top: B:122:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (file != null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            if (file.exists() && !file.isDirectory()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                    try {
                        byte[] bArr = new byte[1048576];
                        while (true) {
                            int i2 = fileInputStream2.read(bArr);
                            if (i2 <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i2);
                        }
                        z = true;
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                return z;
            }
        }
        return false;
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.delete()) {
                an.e("cannot delete file:%s", file2.getAbsolutePath());
            }
        }
    }

    public static synchronized <T extends Parcelable> boolean a(String str, T t) {
        boolean z = false;
        if (t == null) {
            return false;
        }
        byte[] bArrA = aq.a(t);
        if (bArrA != null) {
            if (p.a.a(1002, str, bArrA)) {
                z = true;
            }
        }
        return z;
    }

    public static synchronized <T extends Parcelable> T a(String str, Parcelable.Creator<T> creator) {
        Map<String, byte[]> mapC = p.a.c();
        if (mapC == null) {
            return null;
        }
        byte[] bArr = mapC.get(str);
        if (bArr != null && bArr.length > 0) {
            return (T) aq.a(bArr, creator);
        }
        return null;
    }

    public static synchronized boolean a(String str) {
        return p.a.c(str);
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = e.G.C;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void a(String str, boolean z) {
        SharedPreferences sharedPreferences = e.G.C;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static String a(Context context, String str) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get(str)) == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e2) {
            an.c(a.class, "getManifestMetaDataValue exception:" + e2.getMessage(), new Object[0]);
            return null;
        }
    }
}
