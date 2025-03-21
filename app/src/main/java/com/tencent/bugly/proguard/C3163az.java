package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.az */
/* loaded from: classes2.dex */
public class C3163az implements InterfaceC3166bb {

    /* renamed from: a */
    private String f10615a = null;

    @Override // com.tencent.bugly.proguard.InterfaceC3166bb
    /* renamed from: a */
    public byte[] mo10022a(byte[] bArr) throws Exception {
        if (this.f10615a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f10615a.getBytes("UTF-8"))), new IvParameterSpec(this.f10615a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3166bb
    /* renamed from: b */
    public byte[] mo10023b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f10615a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f10615a.getBytes("UTF-8"))), new IvParameterSpec(this.f10615a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3166bb
    /* renamed from: a */
    public void mo10021a(String str) {
        if (str != null) {
            this.f10615a = str;
        }
    }
}
