package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import com.huawei.hms.framework.common.ContainerUtils;
import com.just.agentweb.DefaultWebClient;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p014u.C0052a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;
import util.permissionutil.C7308a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.m */
/* loaded from: classes2.dex */
public class C3295m {

    /* renamed from: a */
    private static String f11327a = "";

    /* renamed from: b */
    private static String f11328b = "";

    /* renamed from: c */
    private static String f11329c = "";

    /* renamed from: d */
    private static String f11330d = "";

    /* renamed from: e */
    private static int f11331e = -1;

    /* renamed from: f */
    private static String f11332f = "0123456789ABCDEF";

    /* renamed from: a */
    private static char m10659a(int i2) {
        int i3 = i2 & 15;
        return (char) (i3 < 10 ? i3 + 48 : (i3 - 10) + 97);
    }

    /* renamed from: a */
    public static Bundle m10664a(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] m10683a = m10683a(str2, ContainerUtils.KEY_VALUE_DELIMITER);
                if (m10683a.length == 2) {
                    bundle.putString(URLDecoder.decode(m10683a[0]), URLDecoder.decode(m10683a[1]));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static Bundle m10684b(String str) {
        try {
            URL url = new URL(str.replace("auth://", DefaultWebClient.HTTP_SCHEME));
            Bundle m10664a = m10664a(url.getQuery());
            m10664a.putAll(m10664a(url.getRef()));
            return m10664a;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    /* renamed from: c */
    public static JSONObject m10692c(String str) {
        try {
            URL url = new URL(str.replace("auth://", DefaultWebClient.HTTP_SCHEME));
            JSONObject m10675a = m10675a((JSONObject) null, url.getQuery());
            m10675a(m10675a, url.getRef());
            return m10675a;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    /* renamed from: d */
    public static JSONObject m10696d(String str) throws JSONException {
        if (str.equals(C0052a.f159k)) {
            str = "{value : false}";
        }
        if (str.equals(C0052a.f158j)) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    /* renamed from: e */
    public static boolean m10700e(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: f */
    public static String m10701f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            SLog.m10501e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e2);
            return "";
        }
    }

    /* renamed from: g */
    private static boolean m10705g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (C3293k.m10628a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    String m10674a = m10674a(messageDigest.digest());
                    messageDigest.reset();
                    if (m10674a.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    SLog.m10500e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: h */
    public static final boolean m10708h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(DefaultWebClient.HTTP_SCHEME) || str.startsWith(DefaultWebClient.HTTPS_SCHEME);
    }

    /* renamed from: i */
    public static boolean m10710i(String str) {
        return str != null && new File(str).exists();
    }

    /* renamed from: j */
    public static byte[] m10711j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            SLog.m10501e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e2);
            return new byte[0];
        }
    }

    /* renamed from: k */
    public static String m10712k(String str) {
        return m10670a(str, 2);
    }

    /* renamed from: l */
    public static File m10713l(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() == null || file.getParentFile().exists()) {
                file.createNewFile();
            } else if (file.getParentFile().mkdirs()) {
                file.createNewFile();
            } else {
                SLog.m10498d("openSDK_LOG.Util", "createFile failed" + str);
            }
        }
        return file;
    }

    /* renamed from: m */
    public static boolean m10714m(String str) {
        String m10685b = m10685b();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(m10685b) || !str.contains(m10685b)) ? false : true;
    }

    /* renamed from: e */
    public static String m10698e(Context context, String str) {
        if (context == null) {
            return "";
        }
        f11329c = m10695d(context, str);
        return f11329c;
    }

    /* renamed from: h */
    public static File m10707h(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return context.getExternalFilesDir(str);
        }
        File[] externalFilesDirs = context.getExternalFilesDirs(str);
        if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
            return null;
        }
        return externalFilesDirs[0];
    }

    /* renamed from: f */
    public static boolean m10703f(Context context, String str) {
        boolean z = !m10694c(context) || C3293k.m10634a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z && C3293k.m10634a(context, Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        return z ? C3293k.m10645c(context, str) < 0 : z;
    }

    /* renamed from: i */
    private static boolean m10709i(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            return context.checkSelfPermission(str) != 0;
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.Util", "checkSelfPermission exception", e2);
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m10699e(Context context) {
        return C3293k.m10645c(context, "8.1.8") >= 0;
    }

    /* renamed from: b */
    public static boolean m10688b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || m10709i(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        NetworkInfo[] networkInfoArr = null;
        try {
            networkInfoArr = connectivityManager.getAllNetworkInfo();
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e2);
        }
        if (networkInfoArr != null && networkInfoArr.length != 0) {
            for (NetworkInfo networkInfo : networkInfoArr) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static String m10691c(Context context, String str) {
        if (context == null) {
            return "";
        }
        m10687b(context, str);
        return f11328b;
    }

    /* renamed from: f */
    public static boolean m10702f(Context context) {
        return C3293k.m10645c(context, "5.9.5") >= 0;
    }

    /* renamed from: a */
    public static String[] m10683a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        return indexOf == -1 ? new String[]{str} : new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    /* renamed from: c */
    public static boolean m10694c(Context context) {
        double d2;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d2 = 0.0d;
        }
        return d2 > 6.5d;
    }

    /* renamed from: d */
    public static String m10695d(Context context, String str) {
        if (context == null) {
            return "";
        }
        m10687b(context, str);
        return f11327a;
    }

    /* renamed from: a */
    public static JSONObject m10675a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e2) {
                        SLog.m10500e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: d */
    public static boolean m10697d(Context context) {
        return C3293k.m10645c(context, "8.1.5") >= 0;
    }

    /* renamed from: g */
    public static String m10704g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(m10711j(str));
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(m10659a(b2 >>> 4));
                sb.append(m10659a(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            SLog.m10500e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    /* renamed from: b */
    public static void m10687b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            f11328b = packageInfo.versionName;
            f11327a = f11328b.substring(0, f11328b.lastIndexOf(46));
            f11330d = f11328b.substring(f11328b.lastIndexOf(46) + 1, f11328b.length());
            f11331e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            SLog.m10500e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (Exception e3) {
            SLog.m10500e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m10690c(android.content.Context r12, android.net.Uri r13) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.C3295m.m10690c(android.content.Context, android.net.Uri):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m10678a(Context context, String str) {
        boolean z;
        try {
            z = m10705g(context);
            try {
                if (z) {
                    m10676a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    m10676a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused) {
                if (z) {
                    try {
                        try {
                            try {
                                m10676a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused2) {
                                m10676a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            }
                        } catch (Exception unused3) {
                            m10676a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        }
                    } catch (Exception unused4) {
                        return false;
                    }
                }
                try {
                    try {
                        m10676a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused5) {
                        m10676a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                } catch (Exception unused6) {
                    return false;
                }
            }
        } catch (Exception unused7) {
            z = false;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public static String m10686b(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return m10690c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                String str2 = split2[0];
                if ("image".equals(str2)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str2)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return m10690c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
            }
            return null;
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            return m10690c(context, uri);
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    /* renamed from: g */
    public static boolean m10706g(Context context, String str) {
        boolean z = !m10694c(context) || C3293k.m10634a(context, Constants.PACKAGE_QQ_PAD) == null;
        return z ? C3293k.m10645c(context, str) < 0 : z;
    }

    /* renamed from: a */
    private static void m10676a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(CommonNetImpl.FLAG_AUTH);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static boolean m10677a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    /* renamed from: a */
    public static String m10674a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            String num = Integer.toString(b2 & C5230f1.f20085c, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static final String m10669a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    /* renamed from: a */
    public static final String m10671a(String str, int i2, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i2) {
                return str;
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < str.length()) {
                int i5 = i3 + 1;
                i4 += str.substring(i3, i5).getBytes(str2).length;
                if (i4 > i2) {
                    String substring = str.substring(0, i3);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i3 = i5;
            }
            return str;
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    /* renamed from: b */
    public static String m10685b() {
        File m10609e = C3289g.m10609e();
        if (m10609e == null) {
            return null;
        }
        if (!m10609e.exists()) {
            m10609e.mkdirs();
        }
        return m10609e.toString();
    }

    /* renamed from: a */
    public static Bundle m10663a(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("result", str);
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m10667a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, str4);
        bundle.putString("app_id", str5);
        bundle.putString("type", str6);
        bundle.putString("login_status", str7);
        bundle.putString("need_user_auth", str8);
        bundle.putString("to_uin", str9);
        bundle.putString("call_source", str10);
        bundle.putString("to_type", str11);
        bundle.putString("platform", "1");
        return bundle;
    }

    /* renamed from: b */
    public static boolean m10689b(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return m10681a(file, m10713l(str2));
            } catch (IOException e2) {
                SLog.m10499d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + AbstractC1191a.f2568g, e2);
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m10693c() {
        Context m10603a = C3289g.m10603a();
        return m10603a != null && m10603a.getPackageManager().checkPermission(C7308a.f25521A, m10603a.getPackageName()) == 0;
    }

    /* renamed from: a */
    public static Bundle m10665a(String str, String str2, String str3, String str4, String str5) {
        return m10667a(str, str3, str4, str2, str5, "", "", "", "", "", "");
    }

    /* renamed from: a */
    public static Bundle m10666a(String str, String str2, String str3, String str4, String str5, String str6) {
        return m10668a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    /* renamed from: a */
    public static Bundle m10668a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return m10663a(m10667a(str, str2, str3, str4, str5, str7, str8, str9, str10, str11, str12), str6);
    }

    /* renamed from: a */
    public static boolean m10680a(Context context, boolean z) {
        return (m10694c(context) && C3293k.m10634a(context, Constants.PACKAGE_QQ_PAD) != null) || C3293k.m10645c(context, "4.1") >= 0 || C3293k.m10634a(context, Constants.PACKAGE_TIM) != null;
    }

    /* renamed from: a */
    public static long m10660a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        if (query != null) {
            try {
            } catch (Exception e2) {
                SLog.m10501e("openSDK_LOG.Util", "cursor exception", e2);
            }
            if (query.getCount() != 0) {
                try {
                    try {
                        r2 = query.moveToFirst() ? query.getLong(query.getColumnIndexOrThrow("_size")) : 0L;
                        query.close();
                    } catch (Exception e3) {
                        SLog.m10501e("openSDK_LOG.Util", "cursor exception", e3);
                        query.close();
                    }
                    return r2;
                } catch (Throwable th) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        SLog.m10501e("openSDK_LOG.Util", "cursor exception", e4);
                    }
                    throw th;
                }
            }
        }
        return 0L;
    }

    /* renamed from: a */
    public static String m10670a(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), i2);
            } catch (UnsupportedEncodingException e2) {
                SLog.m10500e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
            }
        }
        return "";
    }

    /* renamed from: a */
    public static Drawable m10661a(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        Drawable drawable = null;
        if (context == null) {
            SLog.m10500e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            try {
                inputStream.close();
            } catch (Exception e3) {
                SLog.m10500e("openSDK_LOG.Util", "inputStream close exception: " + e3.getMessage());
            }
            throw th;
        }
        try {
            try {
                drawable = Drawable.createFromStream(inputStream, str);
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    sb = new StringBuilder();
                    sb.append("inputStream close exception: ");
                    sb.append(e.getMessage());
                    SLog.m10500e("openSDK_LOG.Util", sb.toString());
                    return drawable;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            SLog.m10500e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
            try {
                inputStream.close();
            } catch (Exception e6) {
                e = e6;
                sb = new StringBuilder();
                sb.append("inputStream close exception: ");
                sb.append(e.getMessage());
                SLog.m10500e("openSDK_LOG.Util", sb.toString());
                return drawable;
            }
            return drawable;
        }
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0056 -> B:25:0x0098). Please report as a decompilation issue!!! */
    /* renamed from: a */
    public static boolean m10681a(File file, File file2) {
        int read;
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        file2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            byte[] bArr = new byte[102400];
                            while (true) {
                                read = file2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                                fileOutputStream2.flush();
                            }
                            z = true;
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                                SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e2);
                            }
                            file2.close();
                            fileOutputStream = read;
                            file2 = file2;
                        } catch (IOException e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            file2 = file2;
                            SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e4);
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                                fileOutputStream = fileOutputStream;
                                file2 = file2;
                            }
                            return z;
                        } catch (OutOfMemoryError e5) {
                            e = e5;
                            fileOutputStream = fileOutputStream2;
                            file2 = file2;
                            SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e6);
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                                fileOutputStream = fileOutputStream;
                                file2 = file2;
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e7);
                                }
                            }
                            if (file2 != 0) {
                                try {
                                    file2.close();
                                    throw th;
                                } catch (IOException e8) {
                                    SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e8);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e9) {
                        e = e9;
                        file2 = 0;
                    } catch (OutOfMemoryError e10) {
                        e = e10;
                        file2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        file2 = 0;
                    }
                } catch (IOException e11) {
                    e = e11;
                    file2 = 0;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    file2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    file2 = 0;
                }
            } catch (IOException e13) {
                SLog.m10501e("openSDK_LOG.Util", "copyFile error, ", e13);
                fileOutputStream = fileOutputStream;
                file2 = file2;
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    public static boolean m10679a(Context context, String str, String str2) {
        boolean m10689b;
        if (Build.VERSION.SDK_INT < 19) {
            m10689b = context.getPackageManager().checkPermission(C7308a.f25521A, context.getPackageName()) == 0 ? m10689b(str, str2) : false;
        } else {
            m10689b = m10689b(str, str2);
        }
        SLog.m10502i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + m10689b);
        return m10689b;
    }

    /* renamed from: a */
    public static String m10672a(String str, Activity activity, String str2, IUiListener iUiListener) {
        String str3;
        try {
            boolean m10714m = m10714m(str2);
            SLog.m10502i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + m10714m + ",hasSDPermission=" + m10693c());
            if (!m10714m) {
                File m10604a = C3289g.m10604a("Images");
                if (m10604a != null) {
                    str3 = m10604a.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    File cacheDir = C3289g.m10603a().getCacheDir();
                    if (cacheDir == null) {
                        SLog.m10500e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = m10689b(absolutePath, str4) ? str4 : null;
            }
            Uri m10662a = m10662a(activity, str, str2);
            if (m10662a == null) {
                return null;
            }
            return m10662a.toString();
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.Util", "getMediaFileUri error", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m10682a(Map<String, Object> map, String str, boolean z) {
        if (map == null) {
            SLog.m10500e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        }
        if (!map.containsKey(str)) {
            SLog.m10500e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z;
        }
        Object obj = map.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    /* renamed from: a */
    public static String m10673a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.m10500e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        }
        if (!map.containsKey(str)) {
            SLog.m10500e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        }
        Object obj = map.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    /* renamed from: a */
    public static Uri m10662a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.m10500e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_TIM, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_PAD, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_SPEED, uriForFile, 3);
            return uriForFile;
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e2);
            return null;
        }
    }
}
