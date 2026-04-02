package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public class f implements IDecrypt {
    private SecretKey a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f4328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4329c = false;

    public f(d dVar) {
        this.f4328b = dVar;
    }

    private void a() {
        try {
            this.a = j.a(this.f4328b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.a = null;
        }
        this.f4329c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.f4329c) {
            a();
        }
        if (this.a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(j.a(this.a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e2) {
                String str3 = "decrypt exception:" + e2.getMessage();
            }
        }
        return str2;
    }
}
