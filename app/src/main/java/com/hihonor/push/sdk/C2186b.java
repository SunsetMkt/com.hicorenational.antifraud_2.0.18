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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;

/* renamed from: com.hihonor.push.sdk.b */
/* loaded from: classes.dex */
public class C2186b {
    /* renamed from: a */
    public static String m6365a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & C5230f1.f20085c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m6367a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e2) {
            C2189c.m6377a("DeflateUtil", "close", e2);
        }
    }

    /* renamed from: a */
    public static byte[] m6368a(String str) {
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

    /* renamed from: a */
    public static byte[] m6369a(byte[] bArr, int i2) {
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

    /* renamed from: a */
    public static byte[] m6370a(byte[] bArr, byte[] bArr2) {
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

    /* renamed from: b */
    public static int m6371b(Context context) {
        HonorApiAvailability$PackageStates honorApiAvailability$PackageStates;
        if (context == null) {
            throw new NullPointerException("context must not be null.");
        }
        RemoteServiceBean m6361a = m6361a(context);
        String packageName = m6361a.getPackageName();
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
        if (!TextUtils.equals(packageName, DispatchConstants.ANDROID) || TextUtils.isEmpty(m6361a.getPackageSignature())) {
            return 8002006;
        }
        return HonorPushErrorEnum.SUCCESS.statusCode;
    }

    /* renamed from: a */
    public static <TResult> C2185a1<TResult> m6360a(Callable<TResult> callable) {
        ExecutorService executorService = C2221o0.f6811c.f6813b;
        C2219n0 c2219n0 = new C2219n0();
        try {
            executorService.execute(new RunnableC2243z0(c2219n0, callable));
        } catch (Exception e2) {
            c2219n0.m6396a(e2);
        }
        return c2219n0.f6809a;
    }

    /* renamed from: a */
    public static void m6366a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    /* renamed from: a */
    public static <TResult> TResult m6363a(C2185a1<TResult> c2185a1) throws ExecutionException, InterruptedException {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (c2185a1.f6748a) {
                z = c2185a1.f6749b;
            }
            if (!z) {
                C2241y0 c2241y0 = new C2241y0();
                C2221o0 c2221o0 = C2221o0.f6811c;
                c2185a1.m6353a(new C2239x0(c2221o0.f6812a, c2241y0)).m6353a(new C2235v0(c2221o0.f6812a, c2241y0)).m6353a(new C2227r0(c2221o0.f6812a, c2241y0));
                c2241y0.f6855a.await();
            }
            if (c2185a1.m6358e()) {
                return c2185a1.m6356c();
            }
            throw new ExecutionException(c2185a1.m6355b());
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* renamed from: a */
    public static RequestHeader m6359a() throws ApiException {
        String string;
        Context m6393a = C2214l.f6798e.m6393a();
        String str = null;
        try {
            Object obj = m6393a.getPackageManager().getApplicationInfo(m6393a.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            if (obj != null) {
                str = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            C2189c.m6377a("ConfigUtils", "getPushAppId", e2);
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = "checkPushAppId Parameter is " + str;
            String m6364a = m6364a(m6393a, m6393a.getPackageName());
            if (!TextUtils.isEmpty(m6364a)) {
                String str3 = "checkPushCertFingerprint Parameter is " + m6364a;
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setPackageName(m6393a.getPackageName());
                requestHeader.setAppId(str);
                requestHeader.setCertificateFingerprint(m6364a);
                C2193d c2193d = C2193d.f6759b;
                requestHeader.setPushToken(c2193d.m6381b(m6393a));
                synchronized (c2193d) {
                    c2193d.m6379a(m6393a);
                    SharedPreferences sharedPreferences = C2193d.f6758a.f6789a;
                    string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                        String str4 = "getRandomUUID UUID =" + string;
                        C2193d.f6758a.m6389a("key_aaid", string);
                    }
                }
                requestHeader.setAAID(string);
                requestHeader.setSdkVersion(70061303);
                return requestHeader;
            }
            C2189c.m6376a("checkPushConfig Parameter is missing.");
            throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        C2189c.m6376a("checkPushConfig Parameter is missing");
        throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
    }

    /* renamed from: a */
    public static ApiException m6362a(Exception exc) {
        if (exc.getCause() instanceof ApiException) {
            return (ApiException) exc.getCause();
        }
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(-1, exc.getMessage());
    }

    /* renamed from: a */
    public static RemoteServiceBean m6361a(Context context) {
        RemoteServiceBean remoteServiceBean = new RemoteServiceBean();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DispatchConstants.ANDROID, "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                String m6364a = m6364a(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(m6364a);
            }
        }
        return remoteServiceBean;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0050 -> B:12:0x0051). Please report as a decompilation issue!!! */
    /* renamed from: a */
    public static String m6364a(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        SigningInfo signingInfo;
        String str3 = "getCertFingerprint pkgName=" + str + "isOnlyOne=true";
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 30) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, AbstractC1191a.f2490C1);
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
                        String upperCase = Integer.toHexString(b2 & C5230f1.f20085c).toUpperCase(Locale.ENGLISH);
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
