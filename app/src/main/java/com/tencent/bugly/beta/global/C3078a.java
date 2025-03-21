package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
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
import com.tencent.bugly.beta.utils.C3103c;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.C3191p;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Map;
import util.C7316r1;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.a */
/* loaded from: classes2.dex */
public class C3078a {
    /* renamed from: a */
    public static int m9321a(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            if (!C3151an.m9916a(e2)) {
                e2.printStackTrace();
            }
        }
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
        return 0;
    }

    /* renamed from: b */
    public static String m9336b(String str) {
        return new C3103c(str).m9433a();
    }

    /* renamed from: b */
    public static String m9337b(String str, String str2) {
        SharedPreferences sharedPreferences = C3082e.f9867G.f9871C;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* renamed from: b */
    public static boolean m9338b(String str, boolean z) {
        SharedPreferences sharedPreferences = C3082e.f9867G.f9871C;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    /* renamed from: a */
    public static int m9322a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static BitmapDrawable m9325a(Bitmap bitmap, int i2, int i3, float f2) {
        DisplayMetrics displayMetrics = C3082e.f9867G.f9872D;
        int i4 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i2 * i3 > i4) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
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
        return new BitmapDrawable(createBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:11:0x0014, B:15:0x001f, B:17:0x002e, B:20:0x004b, B:22:0x0053, B:24:0x005c, B:25:0x006d, B:37:0x00c5, B:39:0x00cd, B:41:0x00dd, B:45:0x00e9, B:48:0x00c8, B:52:0x00a2, B:53:0x0088, B:55:0x0066, B:59:0x003f), top: B:9:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: Exception -> 0x003a, TryCatch #0 {Exception -> 0x003a, blocks: (B:11:0x0014, B:15:0x001f, B:17:0x002e, B:20:0x004b, B:22:0x0053, B:24:0x005c, B:25:0x006d, B:37:0x00c5, B:39:0x00cd, B:41:0x00dd, B:45:0x00e9, B:48:0x00c8, B:52:0x00a2, B:53:0x0088, B:55:0x0066, B:59:0x003f), top: B:9:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m9323a(android.content.Context r18, int r19, java.lang.Object... r20) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C3078a.m9323a(android.content.Context, int, java.lang.Object[]):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static boolean m9331a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(C7316r1.f25586d)) {
                    String m9956a = C3154aq.m9956a(file, "MD5");
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), m9956a)) {
                        C3151an.m9915a("md5 error [file md5: %s] [target md5: %s]", m9956a, str);
                        return false;
                    }
                    Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        if (Class.forName("androidx.core.content.FileProvider") == null) {
                            C3151an.m9923e("can't find class android.support.v4.content.FileProvider", new Object[0]);
                            return false;
                        }
                        Uri uri = (Uri) C3154aq.m9950a("androidx.core.content.FileProvider", "getUriForFile", null, new Class[]{Context.class, String.class, File.class}, new Object[]{context, C3113a.m9531a(context).f10196d + ".fileProvider", file});
                        if (uri == null) {
                            C3151an.m9923e("file location is " + file.toString(), new Object[0]);
                            C3151an.m9923e("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        C3151an.m9921c("contentUri is " + uri, new Object[0]);
                        intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    }
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    context.startActivity(intent);
                    m9329a("installApkMd5", m9956a);
                    return true;
                }
            } catch (Exception e2) {
                if (!C3151an.m9919b(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m9333a(File file, String str, String str2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String m9956a = C3154aq.m9956a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), m9956a)) {
                        return true;
                    }
                    C3151an.m9915a("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", m9956a, str);
                    return false;
                }
            } catch (Exception unused) {
                C3151an.m9923e("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0061 A[Catch: IOException -> 0x005d, TRY_LEAVE, TryCatch #8 {IOException -> 0x005d, blocks: (B:44:0x0059, B:37:0x0061), top: B:43:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9332a(java.io.File r3, java.io.File r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L69
            r1 = 0
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 == 0) goto L69
            boolean r2 = r3.isDirectory()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 == 0) goto L12
            goto L69
        L12:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
        L20:
            int r1 = r2.read(r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            if (r1 <= 0) goto L2a
            r3.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            goto L20
        L2a:
            r0 = 1
            r2.close()     // Catch: java.io.IOException -> L32
            r3.close()     // Catch: java.io.IOException -> L32
            goto L55
        L32:
            r3 = move-exception
            r3.printStackTrace()
            goto L55
        L37:
            r4 = move-exception
            goto L3d
        L39:
            r4 = move-exception
            goto L41
        L3b:
            r4 = move-exception
            r3 = r1
        L3d:
            r1 = r2
            goto L57
        L3f:
            r4 = move-exception
            r3 = r1
        L41:
            r1 = r2
            goto L48
        L43:
            r4 = move-exception
            r3 = r1
            goto L57
        L46:
            r4 = move-exception
            r3 = r1
        L48:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L32
        L50:
            if (r3 == 0) goto L55
            r3.close()     // Catch: java.io.IOException -> L32
        L55:
            return r0
        L56:
            r4 = move-exception
        L57:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5d
            goto L5f
        L5d:
            r3 = move-exception
            goto L65
        L5f:
            if (r3 == 0) goto L68
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L68
        L65:
            r3.printStackTrace()
        L68:
            throw r4
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C3078a.m9332a(java.io.File, java.io.File):boolean");
    }

    /* renamed from: a */
    public static Bitmap m9324a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static void m9328a(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.delete()) {
                C3151an.m9923e("cannot delete file:%s", file2.getAbsolutePath());
            }
        }
    }

    /* renamed from: a */
    public static synchronized <T extends Parcelable> boolean m9335a(String str, T t) {
        synchronized (C3078a.class) {
            boolean z = false;
            if (t == null) {
                return false;
            }
            byte[] m9973a = C3154aq.m9973a(t);
            if (m9973a != null) {
                if (C3191p.f10775a.m10129a(1002, str, m9973a)) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    public static synchronized <T extends Parcelable> T m9326a(String str, Parcelable.Creator<T> creator) {
        synchronized (C3078a.class) {
            Map<String, byte[]> m10135c = C3191p.f10775a.m10135c();
            if (m10135c == null) {
                return null;
            }
            byte[] bArr = m10135c.get(str);
            if (bArr != null && bArr.length > 0) {
                return (T) C3154aq.m9951a(bArr, creator);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m9334a(String str) {
        boolean m10136c;
        synchronized (C3078a.class) {
            m10136c = C3191p.f10775a.m10136c(str);
        }
        return m10136c;
    }

    /* renamed from: a */
    public static void m9329a(String str, String str2) {
        SharedPreferences sharedPreferences = C3082e.f9867G.f9871C;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: a */
    public static void m9330a(String str, boolean z) {
        SharedPreferences sharedPreferences = C3082e.f9867G.f9871C;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    /* renamed from: a */
    public static String m9327a(Context context, String str) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get(str)) == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e2) {
            C3151an.m9920c(C3078a.class, "getManifestMetaDataValue exception:" + e2.getMessage(), new Object[0]);
            return null;
        }
    }
}
