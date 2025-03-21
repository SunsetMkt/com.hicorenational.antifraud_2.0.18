package anet.channel.security;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.ALog;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anet.channel.security.b */
/* loaded from: classes.dex */
class C0806b implements ISecurity {

    /* renamed from: a */
    private static String f958a = "awcn.DefaultSecurityGuard";

    /* renamed from: b */
    private static boolean f959b = false;

    /* renamed from: c */
    private static Map<String, Integer> f960c;

    /* renamed from: d */
    private String f961d;

    static {
        try {
            Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            f959b = true;
            f960c = new HashMap();
            f960c.put(ISecurity.SIGN_ALGORITHM_HMAC_SHA1, 3);
            f960c.put(ISecurity.CIPHER_ALGORITHM_AES128, 16);
        } catch (Throwable unused) {
            f959b = false;
        }
    }

    C0806b(String str) {
        this.f961d = null;
        this.f961d = str;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        Integer num;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (!f959b || context == null || bArr == null || TextUtils.isEmpty(str2) || !f960c.containsKey(str) || (num = f960c.get(str)) == null) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager != null && (staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp()) != null) {
                return staticDataEncryptComp.staticBinarySafeDecryptNoB64(num.intValue(), str2, bArr, this.f961d);
            }
        } catch (Throwable th) {
            ALog.m714e(f958a, "staticBinarySafeDecryptNoB64", null, th, new Object[0]);
        }
        return null;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] getBytes(Context context, String str) {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
                return null;
            }
            return dynamicDataStoreComp.getByteArray(str);
        } catch (Throwable th) {
            ALog.m714e(f958a, "getBytes", null, th, new Object[0]);
            return null;
        }
    }

    @Override // anet.channel.security.ISecurity
    public boolean isSecOff() {
        return false;
    }

    @Override // anet.channel.security.ISecurity
    public boolean saveBytes(Context context, String str, byte[] bArr) {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (context == null || bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
                return false;
            }
            return dynamicDataStoreComp.putByteArray(str, bArr) != 0;
        } catch (Throwable th) {
            ALog.m714e(f958a, "saveBytes", null, th, new Object[0]);
            return false;
        }
    }

    @Override // anet.channel.security.ISecurity
    public String sign(Context context, String str, String str2, String str3) {
        if (f959b && context != null && !TextUtils.isEmpty(str2) && f960c.containsKey(str)) {
            try {
                ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(context).getSecureSignatureComp();
                if (secureSignatureComp != null) {
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = str2;
                    securityGuardParamContext.paramMap.put("INPUT", str3);
                    securityGuardParamContext.requestType = f960c.get(str).intValue();
                    return secureSignatureComp.signRequest(securityGuardParamContext, this.f961d);
                }
            } catch (Throwable th) {
                ALog.m714e(f958a, "Securityguard sign request failed.", null, th, new Object[0]);
            }
        }
        return null;
    }
}
