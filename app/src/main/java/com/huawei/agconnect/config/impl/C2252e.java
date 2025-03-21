package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* renamed from: com.huawei.agconnect.config.impl.e */
/* loaded from: classes.dex */
public class C2252e implements IDecrypt {

    /* renamed from: a */
    private final ConfigReader f6897a;

    /* renamed from: b */
    private SecretKey f6898b;

    /* renamed from: c */
    private boolean f6899c = false;

    public C2252e(ConfigReader configReader) {
        this.f6897a = configReader;
    }

    /* renamed from: a */
    private void m6428a() {
        try {
            this.f6898b = C2257j.m6436a(new C2251d(this.f6897a.getString("/code/code1", null), this.f6897a.getString("/code/code2", null), this.f6897a.getString("/code/code3", null), this.f6897a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f6898b = null;
        }
        this.f6899c = true;
    }

    /* renamed from: a */
    public static boolean m6429a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    /* renamed from: b */
    private String m6430b(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
        }
        return "";
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.f6899c) {
            m6428a();
        }
        if (this.f6898b != null && m6429a(str)) {
            try {
                return new String(C2257j.m6437a(this.f6898b, Hex.decodeHexString(m6430b(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
        return str2;
    }
}
