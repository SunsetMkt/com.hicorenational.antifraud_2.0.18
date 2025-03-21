package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability$PackageStates;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class b {
    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & h.f1.f16099c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e2) {
            c.a("DeflateUtil", "close", e2);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
            for (int i2 = 0; i2 < length; i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i3 = i2 * 2;
                sb.append(new String(new byte[]{bytes[i3]}, StandardCharsets.UTF_8));
                bArr[i2] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i3 + 1]}, StandardCharsets.UTF_8)).byteValue());
            }
        } catch (NumberFormatException e2) {
            String str2 = "hex string 2 byte array exception : " + e2.getMessage();
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null) {
            return bArr;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i2 < 0) {
                bArr[i3] = (byte) (bArr[i3] << (-i2));
            } else {
                bArr[i3] = (byte) (bArr[i3] >> i2);
            }
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null) {
            int length = bArr.length;
            if (bArr2.length != length) {
                return null;
            }
            bArr3 = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            }
        }
        return bArr3;
    }

    public static int b(Context context) {
        HonorApiAvailability$PackageStates honorApiAvailability$PackageStates;
        if (context == null) {
            throw new NullPointerException("context must not be null.");
        }
        RemoteServiceBean a2 = a(context);
        String packageName = a2.getPackageName();
        String str = "service package name is " + packageName;
        if (TextUtils.isEmpty(packageName)) {
            honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
        } else {
            try {
                honorApiAvailability$PackageStates = context.getPackageManager().getApplicationInfo(packageName, 0).enabled ? HonorApiAvailability$PackageStates.ENABLED : HonorApiAvailability$PackageStates.DISABLED;
            } catch (PackageManager.NameNotFoundException unused) {
                honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
            }
        }
        if (HonorApiAvailability$PackageStates.NOT_INSTALLED.equals(honorApiAvailability$PackageStates)) {
            return 8002008;
        }
        if (HonorApiAvailability$PackageStates.DISABLED.equals(honorApiAvailability$PackageStates)) {
            return 8002007;
        }
        if (!TextUtils.equals(packageName, DispatchConstants.ANDROID) || TextUtils.isEmpty(a2.getPackageSignature())) {
            return 8002006;
        }
        return HonorPushErrorEnum.SUCCESS.statusCode;
    }

    public static <TResult> a1<TResult> a(Callable<TResult> callable) {
        ExecutorService executorService = o0.f6312c.f6314b;
        n0 n0Var = new n0();
        try {
            executorService.execute(new z0(n0Var, callable));
        } catch (Exception e2) {
            n0Var.a(e2);
        }
        return n0Var.f6310a;
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static <TResult> TResult a(a1<TResult> a1Var) throws ExecutionException, InterruptedException {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (a1Var.f6249a) {
                z = a1Var.f6250b;
            }
            if (!z) {
                y0 y0Var = new y0();
                o0 o0Var = o0.f6312c;
                a1Var.a(new x0(o0Var.f6313a, y0Var)).a(new v0(o0Var.f6313a, y0Var)).a(new r0(o0Var.f6313a, y0Var));
                y0Var.f6356a.await();
            }
            if (a1Var.e()) {
                return a1Var.c();
            }
            throw new ExecutionException(a1Var.b());
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static RequestHeader a() throws ApiException {
        String string;
        Context a2 = l.f6299e.a();
        String str = null;
        try {
            Object obj = a2.getPackageManager().getApplicationInfo(a2.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            if (obj != null) {
                str = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            c.a("ConfigUtils", "getPushAppId", e2);
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = "checkPushAppId Parameter is " + str;
            String a3 = a(a2, a2.getPackageName());
            if (!TextUtils.isEmpty(a3)) {
                String str3 = "checkPushCertFingerprint Parameter is " + a3;
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setPackageName(a2.getPackageName());
                requestHeader.setAppId(str);
                requestHeader.setCertificateFingerprint(a3);
                d dVar = d.f6260b;
                requestHeader.setPushToken(dVar.b(a2));
                synchronized (dVar) {
                    dVar.a(a2);
                    SharedPreferences sharedPreferences = d.f6259a.f6290a;
                    string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                        String str4 = "getRandomUUID UUID =" + string;
                        d.f6259a.a("key_aaid", string);
                    }
                }
                requestHeader.setAAID(string);
                requestHeader.setSdkVersion(70061303);
                return requestHeader;
            }
            c.a("checkPushConfig Parameter is missing.");
            throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        c.a("checkPushConfig Parameter is missing");
        throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
    }

    public static ApiException a(Exception exc) {
        if (exc.getCause() instanceof ApiException) {
            return (ApiException) exc.getCause();
        }
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(-1, exc.getMessage());
    }

    public static RemoteServiceBean a(Context context) {
        RemoteServiceBean remoteServiceBean = new RemoteServiceBean();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DispatchConstants.ANDROID, "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                String a2 = a(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(a2);
            }
        }
        return remoteServiceBean;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0050 -> B:12:0x0051). Please report as a decompilation issue!!! */
    public static String a(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        SigningInfo signingInfo;
        String str3 = "getCertFingerprint pkgName=" + str + "isOnlyOne=true";
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 30) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, c.c.a.b.a.a.C1);
            if (packageInfo != null && (signingInfo = packageInfo.signingInfo) != null) {
                if (signingInfo.hasMultipleSigners()) {
                    signatureArr = signingInfo.getApkContentsSigners();
                } else {
                    signatureArr = signingInfo.getSigningCertificateHistory();
                }
            }
            signatureArr = null;
        } else {
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 != null) {
                signatureArr = packageInfo2.signatures;
            }
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            int length = signatureArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                try {
                    byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[i2].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        String upperCase = Integer.toHexString(b2 & h.f1.f16099c).toUpperCase(Locale.ENGLISH);
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                    }
                    str2 = sb.toString();
                } catch (NoSuchAlgorithmException unused) {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                    break;
                }
                i2++;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(0);
    }
}
