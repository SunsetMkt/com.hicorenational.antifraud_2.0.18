package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ay */
/* loaded from: classes2.dex */
public class C3162ay implements InterfaceC3166bb {

    /* renamed from: a */
    private String f10614a = null;

    @Override // com.tencent.bugly.proguard.InterfaceC3166bb
    /* renamed from: a */
    public byte[] mo10022a(byte[] bArr) throws Exception {
        if (this.f10614a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + AbstractC1191a.f2568g);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f10614a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(this.f10614a.getBytes()));
        byte[] doFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b3 : doFinal) {
            stringBuffer2.append(((int) b3) + AbstractC1191a.f2568g);
        }
        return doFinal;
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3166bb
    /* renamed from: b */
    public byte[] mo10023b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.f10614a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + AbstractC1191a.f2568g);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f10614a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(this.f10614a.getBytes()));
        byte[] doFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b3 : doFinal) {
            stringBuffer2.append(((int) b3) + AbstractC1191a.f2568g);
        }
        return doFinal;
    }

    @Override // com.tencent.bugly.proguard.InterfaceC3166bb
    /* renamed from: a */
    public void mo10021a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f10614a = str.substring(0, 16);
        }
    }
}
