package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import anet.channel.util.HttpConstant;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import h.f1;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f9280a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f9281b = false;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (an.a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static byte[] b(byte[] bArr, int i2, String str) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        try {
            bb a2 = ba.a(i2);
            if (a2 == null) {
                return null;
            }
            a2.a(str);
            return a2.a(bArr);
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            an.d("encrytype %d %s", Integer.valueOf(i2), str);
            return null;
        }
    }

    public static byte[] c(long j2) {
        try {
            return ("" + j2).getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Parcel d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static long c(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static boolean c(Context context, String str) {
        an.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            an.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            an.a(th);
            return false;
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(long j2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j2));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static byte[] b(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        an.c("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            av a2 = au.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.b(bArr);
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static byte[] b(byte[] bArr, int i2, int i3, String str) {
        try {
            return b(b(bArr, i3, str), i2);
        } catch (Exception e2) {
            if (an.a(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i2, String str) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        an.c("rqdp{  enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i2));
        try {
            bb a2 = ba.a(i2);
            if (a2 == null) {
                return null;
            }
            a2.a(str);
            return a2.b(bArr);
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean c(String str) {
        if (a(str)) {
            return false;
        }
        if (str.length() > 255) {
            an.a("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith(HttpConstant.HTTP)) {
            return true;
        }
        an.a("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th) {
            if (an.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:5|(3:76|77|(16:81|82|83|8|9|10|11|(1:(2:13|(1:15)(1:16)))(0)|17|(2:18|(1:20)(1:21))|22|(2:32|33)|24|25|26|27))|7|8|9|10|11|(0)(0)|17|(3:18|(0)(0)|20)|22|(0)|24|25|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b A[Catch: all -> 0x0094, LOOP:0: B:13:0x005b->B:15:0x0061, LOOP_START, TryCatch #2 {all -> 0x0094, blocks: (B:11:0x004a, B:13:0x005b, B:15:0x0061, B:18:0x0065, B:20:0x006b, B:22:0x006f), top: B:10:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: all -> 0x0094, LOOP:1: B:18:0x0065->B:20:0x006b, LOOP_END, TryCatch #2 {all -> 0x0094, blocks: (B:11:0x004a, B:13:0x005b, B:15:0x0061, B:18:0x0065, B:20:0x006b, B:22:0x006f), top: B:10:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[EDGE_INSN: B:21:0x006f->B:22:0x006f BREAK  A[LOOP:1: B:18:0x0065->B:20:0x006b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e A[Catch: all -> 0x00bb, TRY_LEAVE, TryCatch #7 {all -> 0x00bb, blocks: (B:40:0x0098, B:42:0x009e), top: B:39:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.io.File r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 == 0) goto Ld6
            int r1 = r7.length()
            if (r1 != 0) goto Lb
            goto Ld6
        Lb:
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "rqdp{  ZF start}"
            com.tencent.bugly.proguard.an.c(r3, r2)
            java.lang.String r2 = "rqdp{  ZF end}"
            if (r6 == 0) goto L31
            boolean r3 = r6.exists()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L31
            boolean r3 = r6.canRead()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L31
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L96
            goto L33
        L2d:
            r6 = move-exception
            r8 = r0
            r4 = r8
            goto L98
        L31:
            r6 = r8
            r8 = r0
        L33:
            java.lang.String r3 = "UTF-8"
            byte[] r7 = r7.getBytes(r3)     // Catch: java.lang.Throwable -> L96
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L96
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L96
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L96
            r7.<init>()     // Catch: java.lang.Throwable -> L96
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L96
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L96
            r5 = 8
            r4.setMethod(r5)     // Catch: java.lang.Throwable -> L94
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L94
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L94
            r4.putNextEntry(r5)     // Catch: java.lang.Throwable -> L94
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L94
            if (r8 == 0) goto L65
        L5b:
            int r5 = r8.read(r6)     // Catch: java.lang.Throwable -> L94
            if (r5 <= 0) goto L65
            r4.write(r6, r1, r5)     // Catch: java.lang.Throwable -> L94
            goto L5b
        L65:
            int r5 = r3.read(r6)     // Catch: java.lang.Throwable -> L94
            if (r5 <= 0) goto L6f
            r4.write(r6, r1, r5)     // Catch: java.lang.Throwable -> L94
            goto L65
        L6f:
            r4.closeEntry()     // Catch: java.lang.Throwable -> L94
            r4.flush()     // Catch: java.lang.Throwable -> L94
            r4.finish()     // Catch: java.lang.Throwable -> L94
            byte[] r6 = r7.toByteArray()     // Catch: java.lang.Throwable -> L94
            if (r8 == 0) goto L86
            r8.close()     // Catch: java.io.IOException -> L82
            goto L86
        L82:
            r7 = move-exception
            r7.printStackTrace()
        L86:
            r4.close()     // Catch: java.io.IOException -> L8a
            goto L8e
        L8a:
            r7 = move-exception
            r7.printStackTrace()
        L8e:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.an.c(r2, r7)
            return r6
        L94:
            r6 = move-exception
            goto L98
        L96:
            r6 = move-exception
            r4 = r0
        L98:
            boolean r7 = com.tencent.bugly.proguard.an.a(r6)     // Catch: java.lang.Throwable -> Lbb
            if (r7 != 0) goto La1
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
        La1:
            if (r8 == 0) goto Lab
            r8.close()     // Catch: java.io.IOException -> La7
            goto Lab
        La7:
            r6 = move-exception
            r6.printStackTrace()
        Lab:
            if (r4 == 0) goto Lb5
            r4.close()     // Catch: java.io.IOException -> Lb1
            goto Lb5
        Lb1:
            r6 = move-exception
            r6.printStackTrace()
        Lb5:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.an.c(r2, r6)
            return r0
        Lbb:
            r6 = move-exception
            if (r8 == 0) goto Lc6
            r8.close()     // Catch: java.io.IOException -> Lc2
            goto Lc6
        Lc2:
            r7 = move-exception
            r7.printStackTrace()
        Lc6:
            if (r4 == 0) goto Ld0
            r4.close()     // Catch: java.io.IOException -> Lcc
            goto Ld0
        Lcc:
            r7 = move-exception
            r7.printStackTrace()
        Ld0:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.an.c(r2, r7)
            throw r6
        Ld6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aq.a(java.io.File, java.lang.String, java.lang.String):byte[]");
    }

    public static String c(String str, String str2) {
        return (com.tencent.bugly.crashreport.common.info.a.b() == null || com.tencent.bugly.crashreport.common.info.a.b().P == null) ? "" : com.tencent.bugly.crashreport.common.info.a.b().P.getString(str, str2);
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Throwable th) {
            if (an.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String b(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (f9280a == null) {
            f9280a = new HashMap();
            ArrayList<String> a2 = a(context, "getprop");
            if (a2 != null && a2.size() > 0) {
                an.b(aq.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                Iterator<String> it = a2.iterator();
                while (it.hasNext()) {
                    Matcher matcher = compile.matcher(it.next());
                    if (matcher.find()) {
                        f9280a.put(matcher.group(1), matcher.group(2));
                    }
                }
                an.b(aq.class, "System properties number: %d.", Integer.valueOf(f9280a.size()));
            }
        }
        return f9280a.containsKey(str) ? f9280a.get(str) : "fail";
    }

    public static void b(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static void b(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        an.c("[Util] Zip %d bytes data with type %s", objArr);
        try {
            av a2 = au.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.a(bArr);
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i2, int i3, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(a(bArr, i2), i3, str);
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() == stringArrayList2.size()) {
            hashMap = new HashMap(stringArrayList.size());
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                hashMap.put(stringArrayList.get(i2), stringArrayList2.get(i2));
            }
        } else {
            an.e("map parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & f1.f16099c);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static boolean b(Context context) {
        try {
        } catch (SecurityException unused) {
            an.e("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return com.tencent.bugly.crashreport.common.info.a.b().a();
        }
        String packageName = context.getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            return (runningTasks == null || runningTasks.isEmpty() || !runningTasks.get(0).topActivity.getPackageName().equals(packageName)) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public static String a(File file, String str) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            ?? canRead = file.canRead();
            try {
                try {
                    if (canRead != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                MessageDigest messageDigest = MessageDigest.getInstance(str);
                                byte[] bArr = new byte[102400];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    messageDigest.update(bArr, 0, read);
                                }
                                String a2 = a(messageDigest.digest());
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return a2;
                            } catch (IOException e3) {
                                e = e3;
                                if (!an.a(e)) {
                                    e.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (NoSuchAlgorithmException e4) {
                                e = e4;
                                if (!an.a(e)) {
                                    e.printStackTrace();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            fileInputStream = null;
                        } catch (NoSuchAlgorithmException e6) {
                            e = e6;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            canRead = 0;
                            if (canRead != 0) {
                                try {
                                    canRead.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] b(int i2, byte[] bArr, byte[] bArr2) {
        Key generatePrivate;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            if (i2 == 1) {
                generatePrivate = keyFactory.generatePublic(new X509EncodedKeySpec(bArr2));
            } else {
                generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(i2, generatePrivate);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            if (an.b(e2)) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static void b(String str, String str2) {
        if (com.tencent.bugly.crashreport.common.info.a.b() == null || com.tencent.bugly.crashreport.common.info.a.b().P == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a.b().P.edit().putString(str, str2).apply();
    }

    public static boolean a(File file, File file2, int i2) {
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream;
        an.c("rqdp{  ZF start}", new Object[0]);
        if (file != null && file2 != null && !file.equals(file2)) {
            if (file.exists() && file.canRead()) {
                try {
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Throwable th) {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                }
                if (!file2.exists() || !file2.canRead()) {
                    return false;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                    } catch (Throwable th2) {
                        th = th2;
                        zipOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    zipOutputStream = null;
                }
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    byte[] bArr = new byte[i2 > 1000 ? i2 : 1000];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    an.c("rqdp{  ZF end}", new Object[0]);
                    return true;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        an.c("rqdp{  ZF end}", new Object[0]);
                        return false;
                    } catch (Throwable th5) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        an.c("rqdp{  ZF end}", new Object[0]);
                        throw th5;
                    }
                }
            }
            an.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        an.d("rqdp{  err ZF 1R!}", new Object[0]);
        return false;
    }

    public static ArrayList<String> a(Context context, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (AppInfo.f(context)) {
            return new ArrayList<>(Arrays.asList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ArrayList arrayList2 = new ArrayList(Arrays.asList((new File("/system/bin/sh").exists() && new File("/system/bin/sh").canExecute()) ? "/system/bin/sh" : "sh", "-c"));
            arrayList2.add(str);
            Process exec = Runtime.getRuntime().exec((String[]) arrayList2.toArray(new String[3]));
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        if (r7 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r6, java.lang.String r7, java.lang.String r8, int r9) {
        /*
            r6 = 1
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r1 = 0
            r0[r1] = r7
            java.lang.String r2 = "rqdp{  sv sd start} %s"
            com.tencent.bugly.proguard.an.c(r2, r0)
            if (r8 == 0) goto L7f
            java.lang.String r0 = r8.trim()
            int r0 = r0.length()
            if (r0 > 0) goto L18
            goto L7f
        L18:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r7 = r0.exists()     // Catch: java.lang.Throwable -> L6e
            if (r7 != 0) goto L33
            java.io.File r7 = r0.getParentFile()     // Catch: java.lang.Throwable -> L6e
            if (r7 == 0) goto L30
            java.io.File r7 = r0.getParentFile()     // Catch: java.lang.Throwable -> L6e
            r7.mkdirs()     // Catch: java.lang.Throwable -> L6e
        L30:
            r0.createNewFile()     // Catch: java.lang.Throwable -> L6e
        L33:
            r7 = 0
            long r2 = r0.length()     // Catch: java.lang.Throwable -> L5a
            long r4 = (long) r9     // Catch: java.lang.Throwable -> L5a
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 < 0) goto L44
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a
            r6.<init>(r0, r1)     // Catch: java.lang.Throwable -> L5a
            r7 = r6
            goto L4a
        L44:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a
            r9.<init>(r0, r6)     // Catch: java.lang.Throwable -> L5a
            r7 = r9
        L4a:
            java.lang.String r6 = "UTF-8"
            byte[] r6 = r8.getBytes(r6)     // Catch: java.lang.Throwable -> L5a
            r7.write(r6)     // Catch: java.lang.Throwable -> L5a
            r7.flush()     // Catch: java.lang.Throwable -> L5a
        L56:
            r7.close()     // Catch: java.lang.Throwable -> L6e
            goto L78
        L5a:
            r6 = move-exception
            boolean r8 = com.tencent.bugly.proguard.an.a(r6)     // Catch: java.lang.Throwable -> L67
            if (r8 != 0) goto L64
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L67
        L64:
            if (r7 == 0) goto L78
            goto L56
        L67:
            r6 = move-exception
            if (r7 == 0) goto L6d
            r7.close()     // Catch: java.lang.Throwable -> L6e
        L6d:
            throw r6     // Catch: java.lang.Throwable -> L6e
        L6e:
            r6 = move-exception
            boolean r7 = com.tencent.bugly.proguard.an.a(r6)
            if (r7 != 0) goto L78
            r6.printStackTrace()
        L78:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "rqdp{  sv sd end}"
            com.tencent.bugly.proguard.an.c(r7, r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aq.a(android.content.Context, java.lang.String, java.lang.String, int):void");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj2, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("pluginNum", arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                bundle.putString("pluginKey" + i2, (String) arrayList.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                bundle.putString("pluginVal" + i3 + "plugInId", ((PlugInBean) arrayList2.get(i3)).f8971a);
                bundle.putString("pluginVal" + i3 + "plugInUUID", ((PlugInBean) arrayList2.get(i3)).f8973c);
                bundle.putString("pluginVal" + i3 + "plugInVersion", ((PlugInBean) arrayList2.get(i3)).f8972b);
            }
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i2 = 0; i2 < intValue; i2++) {
            arrayList.add(readBundle.getString("pluginKey" + i2));
        }
        for (int i3 = 0; i3 < intValue; i3++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i3 + "plugInId"), readBundle.getString("pluginVal" + i3 + "plugInVersion"), readBundle.getString("pluginVal" + i3 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                hashMap.put(arrayList.get(i4), PlugInBean.class.cast(arrayList2.get(i4)));
            }
        } else {
            an.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel d2 = d(bArr);
        try {
            return creator.createFromParcel(d2);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (d2 != null) {
                    d2.recycle();
                }
                return null;
            } finally {
                if (d2 != null) {
                    d2.recycle();
                }
            }
        }
    }

    public static String a(Context context, int i2, String str) {
        Process process = null;
        if (!AppInfo.a(context, "android.permission.READ_LOGS")) {
            an.d("no read_log permission!", new Object[0]);
            return null;
        }
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        StringBuilder sb = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                if (i2 > 0 && sb.length() > i2) {
                    sb.delete(0, sb.length() - i2);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                sb.append("\n[error:" + th.toString() + "]");
                String sb2 = sb.toString();
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return sb2;
            } finally {
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
    }

    public static Map<String, String> a(int i2, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z || id != entry.getKey().getId()) {
                int i3 = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i3];
                        if (i2 > 0 && sb.length() >= i2) {
                            sb.append("\n[Stack over limit size :" + i2 + " , has been cut!]");
                            break;
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i3++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053 A[Catch: all -> 0x0057, Exception -> 0x0059, TRY_ENTER, TryCatch #2 {Exception -> 0x0059, blocks: (B:9:0x001c, B:17:0x0035, B:18:0x0038, B:24:0x0053, B:25:0x0056), top: B:4:0x0004, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized byte[] a(int r7) {
        /*
            java.lang.Class<com.tencent.bugly.proguard.aq> r0 = com.tencent.bugly.proguard.aq.class
            monitor-enter(r0)
            r1 = 0
            int r2 = r7 / 8
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            java.lang.String r6 = "/dev/urandom"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            r3.readFully(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L50
            r3.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            monitor-exit(r0)
            return r2
        L21:
            r2 = move-exception
            goto L28
        L23:
            r7 = move-exception
            r3 = r1
            goto L51
        L26:
            r2 = move-exception
            r3 = r1
        L28:
            java.lang.String r4 = "Failed to read from /dev/urandom : %s"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L50
            r6 = 0
            r5[r6] = r2     // Catch: java.lang.Throwable -> L50
            com.tencent.bugly.proguard.an.e(r4, r5)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L38
            r3.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
        L38:
            java.lang.String r2 = "AES"
            javax.crypto.KeyGenerator r2 = javax.crypto.KeyGenerator.getInstance(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r3.<init>()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r2.init(r7, r3)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            javax.crypto.SecretKey r7 = r2.generateKey()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            byte[] r7 = r7.getEncoded()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            monitor-exit(r0)
            return r7
        L50:
            r7 = move-exception
        L51:
            if (r3 == 0) goto L56
            r3.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
        L56:
            throw r7     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
        L57:
            r7 = move-exception
            goto L65
        L59:
            r7 = move-exception
            boolean r2 = com.tencent.bugly.proguard.an.b(r7)     // Catch: java.lang.Throwable -> L57
            if (r2 != 0) goto L63
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L57
        L63:
            monitor-exit(r0)
            return r1
        L65:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aq.a(int):byte[]");
    }

    @TargetApi(19)
    public static byte[] a(int i2, byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            if (Build.VERSION.SDK_INT >= 21 && !f9281b) {
                try {
                    cipher.init(i2, secretKeySpec, new GCMParameterSpec(cipher.getBlockSize() * 8, bArr2));
                    return cipher.doFinal(bArr);
                } catch (InvalidAlgorithmParameterException e2) {
                    f9281b = true;
                    throw e2;
                }
            }
            cipher.init(i2, secretKeySpec, new IvParameterSpec(bArr2));
            return cipher.doFinal(bArr);
        } catch (Exception e3) {
            if (an.b(e3)) {
                return null;
            }
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str, long j2) {
        an.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j2) {
                    return false;
                }
                an.c("[Util] Lock file (%s) is expired, unlock it.", str);
                c(context, str);
            }
            if (file.createNewFile()) {
                an.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            an.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            an.a(th);
            return false;
        }
    }

    public static String a(File file, int i2, boolean z) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                    if (i2 > 0 && sb.length() > i2) {
                        if (z) {
                            sb.delete(i2, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        an.a(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                an.a(e2);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
                an.a(e3);
            }
            return sb2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static BufferedReader a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                an.a(th);
            }
        }
        return null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (NullPointerException e2) {
            an.a(e2);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            an.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        am a2 = am.a();
        if (a2 != null) {
            return a2.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
