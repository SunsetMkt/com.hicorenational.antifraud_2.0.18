package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* renamed from: com.huawei.agconnect.config.impl.f */
/* loaded from: classes.dex */
public class C2253f implements IDecrypt {

    /* renamed from: a */
    private SecretKey f6900a;

    /* renamed from: b */
    private final C2251d f6901b;

    /* renamed from: c */
    private boolean f6902c = false;

    public C2253f(C2251d c2251d) {
        this.f6901b = c2251d;
    }

    /* renamed from: a */
    private void m6431a() {
        try {
            this.f6900a = C2257j.m6436a(this.f6901b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            this.f6900a = null;
        }
        this.f6902c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        if (!this.f6902c) {
            m6431a();
        }
        if (this.f6900a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(C2257j.m6437a(this.f6900a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e2) {
                String str3 = "decrypt exception:" + e2.getMessage();
            }
        }
        return str2;
    }
}
