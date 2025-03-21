package com.vivo.push.p236e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.C4010u;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: RsaSecurity.java */
/* renamed from: com.vivo.push.e.c */
/* loaded from: classes2.dex */
public final class C3879c implements InterfaceC3877a {

    /* renamed from: a */
    private PrivateKey f14004a = null;

    /* renamed from: b */
    private PublicKey f14005b = null;

    /* renamed from: c */
    private KeyStore f14006c;

    /* renamed from: d */
    private X500Principal f14007d;

    /* renamed from: e */
    private Context f14008e;

    public C3879c(Context context) {
        this.f14008e = context;
        m12945a(this.f14008e);
    }

    /* renamed from: a */
    private synchronized void m12945a(Context context) {
        try {
            m12946b();
            if (!m12948b("PushRsaKeyAlias")) {
                m12947b(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    /* renamed from: b */
    private void m12947b(Context context) {
        try {
            if (context == null) {
                C4010u.m13309d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f14007d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(build);
                keyPairGenerator.generateKeyPair();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
        }
    }

    /* renamed from: c */
    private PrivateKey m12949c(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
        if (this.f14004a != null) {
            return this.f14004a;
        }
        if (context == null) {
            C4010u.m13309d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry m12950d = m12950d(context);
        if (m12950d instanceof KeyStore.PrivateKeyEntry) {
            this.f14004a = ((KeyStore.PrivateKeyEntry) m12950d).getPrivateKey();
            return this.f14004a;
        }
        return null;
    }

    /* renamed from: d */
    private KeyStore.Entry m12950d(Context context) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        try {
            if (context == null) {
                C4010u.m13309d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!m12948b("PushRsaKeyAlias")) {
                m12947b(context);
            }
            return this.f14006c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e2) {
            m12947b(context);
            KeyStore.Entry entry = this.f14006c.getEntry("PushRsaKeyAlias", null);
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.p236e.InterfaceC3877a
    /* renamed from: a */
    public final String mo12940a(String str) {
        try {
            if (TextUtils.isEmpty(str) || m12949c(this.f14008e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey m12949c = m12949c(this.f14008e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(m12949c);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            C4010u.m13309d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private boolean m12948b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f14006c == null) {
                m12946b();
            }
            return this.f14006c.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.p236e.InterfaceC3877a
    /* renamed from: a */
    public final boolean mo12942a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private void m12946b() {
        try {
            this.f14006c = KeyStore.getInstance("AndroidKeyStore");
            this.f14006c.load(null);
            this.f14007d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.p236e.InterfaceC3877a
    /* renamed from: a */
    public final PublicKey mo12941a() {
        try {
            if (this.f14005b != null) {
                return this.f14005b;
            }
            KeyStore.Entry m12950d = m12950d(this.f14008e);
            if (!(m12950d instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            this.f14005b = ((KeyStore.PrivateKeyEntry) m12950d).getCertificate().getPublicKey();
            return this.f14005b;
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13292a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
            return null;
        }
    }
}
