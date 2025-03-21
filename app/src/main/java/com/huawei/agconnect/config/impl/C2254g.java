package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;

/* renamed from: com.huawei.agconnect.config.impl.g */
/* loaded from: classes.dex */
public class C2254g implements AesDecrypt {

    /* renamed from: a */
    private final Context f6903a;

    /* renamed from: b */
    private final String f6904b;

    /* renamed from: c */
    private IDecrypt f6905c;

    public C2254g(Context context, String str) {
        this.f6903a = context;
        this.f6904b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.f6905c == null) {
            this.f6905c = decryptComponent();
        }
        return this.f6905c.decrypt(C2259l.m6444a(this.f6903a, this.f6904b, "agc_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        return new C2253f(new C2251d(C2259l.m6444a(this.f6903a, this.f6904b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), C2259l.m6444a(this.f6903a, this.f6904b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), C2259l.m6444a(this.f6903a, this.f6904b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), C2259l.m6444a(this.f6903a, this.f6904b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", 5000));
    }
}
