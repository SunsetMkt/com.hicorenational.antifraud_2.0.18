package com.vivo.push.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.u;
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

/* JADX INFO: compiled from: RsaSecurity.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {
    private PrivateKey a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PublicKey f8502b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private KeyStore f8503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private X500Principal f8504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f8505e;

    public c(Context context) {
        this.f8505e = context;
        a(this.f8505e);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    private void b(Context context) {
        try {
            if (context == null) {
                u.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f8504d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
                keyPairGenerator.generateKeyPair();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
        }
    }

    private PrivateKey c(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
        if (this.a != null) {
            return this.a;
        }
        if (context == null) {
            u.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry entryD = d(context);
        if (entryD instanceof KeyStore.PrivateKeyEntry) {
            this.a = ((KeyStore.PrivateKeyEntry) entryD).getPrivateKey();
            return this.a;
        }
        return null;
    }

    private KeyStore.Entry d(Context context) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        try {
            if (context == null) {
                u.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.f8503c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e2) {
            b(context);
            KeyStore.Entry entry = this.f8503c.getEntry("PushRsaKeyAlias", null);
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.e.a
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || c(this.f8505e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey privateKeyC = c(this.f8505e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKeyC);
            signature.update(bytes);
            String strEncodeToString = Base64.encodeToString(signature.sign(), 2);
            u.d("RsaSecurity", str.hashCode() + " = " + strEncodeToString);
            return strEncodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f8503c == null) {
                b();
            }
            return this.f8503c.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.e.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    private void b() {
        try {
            this.f8503c = KeyStore.getInstance("AndroidKeyStore");
            this.f8503c.load(null);
            this.f8504d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.e.a
    public final PublicKey a() {
        try {
            if (this.f8502b != null) {
                return this.f8502b;
            }
            KeyStore.Entry entryD = d(this.f8505e);
            if (!(entryD instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            this.f8502b = ((KeyStore.PrivateKeyEntry) entryD).getCertificate().getPublicKey();
            return this.f8502b;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
            return null;
        }
    }
}
