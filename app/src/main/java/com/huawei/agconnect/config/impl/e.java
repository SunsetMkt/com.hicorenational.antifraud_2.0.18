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

/* JADX INFO: loaded from: classes.dex */
public class e implements IDecrypt {
    private final ConfigReader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SecretKey f4326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4327c = false;

    public e(ConfigReader configReader) {
        this.a = configReader;
    }

    private void a() {
        try {
            this.f4326b = j.a(new d(this.a.getString("/code/code1", null), this.a.getString("/code/code2", null), this.a.getString("/code/code3", null), this.a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f4326b = null;
        }
        this.f4327c = true;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    private String b(String str) {
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
        if (!this.f4327c) {
            a();
        }
        if (this.f4326b != null && a(str)) {
            try {
                return new String(j.a(this.f4326b, Hex.decodeHexString(b(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
            }
        }
        return str2;
    }
}
