package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.C2268R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import com.umeng.analytics.pro.C3351bh;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecretUtil.java */
/* renamed from: com.huawei.hms.opendevice.l */
/* loaded from: classes.dex */
public abstract class AbstractC2474l {

    /* renamed from: a */
    private static final String f7672a = "l";

    /* renamed from: b */
    private static Map<String, String> f7673b = new HashMap();

    /* renamed from: c */
    private static final Object f7674c = new Object();

    /* renamed from: a */
    private static String m7481a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    /* renamed from: a */
    private static byte[] m7487a(String str, String str2, String str3, String str4) {
        return Build.VERSION.SDK_INT >= 26 ? BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true) : BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    /* renamed from: b */
    private static byte[] m7491b() {
        return m7487a(m7494d(), m7496e(), m7492c(), m7499g());
    }

    /* renamed from: c */
    public static void m7493c(Context context) {
        synchronized (f7674c) {
            m7495d(context.getApplicationContext());
            if (m7501i()) {
                HMSLog.m7717i(f7672a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(AbstractC2467e.m7457c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.m7717i(f7672a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String m7451a = AbstractC2466d.m7451a(generateSecureRandom);
            String m7451a2 = AbstractC2466d.m7451a(generateSecureRandom2);
            String m7451a3 = AbstractC2466d.m7451a(generateSecureRandom3);
            String m7451a4 = AbstractC2466d.m7451a(generateSecureRandom4);
            m7485a(m7451a, m7451a2, m7451a3, m7451a4, WorkKeyCryptUtil.encryptWorkKey(AbstractC2466d.m7451a(EncryptUtil.generateSecureRandom(32)), m7487a(m7451a, m7451a2, m7451a3, m7451a4)), context);
            HMSLog.m7717i(f7672a, "generate D.");
        }
    }

    /* renamed from: d */
    private static void m7495d(Context context) {
        if (m7501i()) {
            HMSLog.m7717i(f7672a, "secretKeyCache not empty.");
            return;
        }
        f7673b.clear();
        String m7457c = AbstractC2467e.m7457c(context);
        if (TextUtils.isEmpty(m7457c)) {
            return;
        }
        String m7502a = AbstractC2475m.m7502a(m7457c + "/files/math/m");
        String m7502a2 = AbstractC2475m.m7502a(m7457c + "/files/panda/p");
        String m7502a3 = AbstractC2475m.m7502a(m7457c + "/files/panda/d");
        String m7502a4 = AbstractC2475m.m7502a(m7457c + "/files/math/t");
        String m7502a5 = AbstractC2475m.m7502a(m7457c + "/files/s");
        if (C2476n.m7504a(m7502a, m7502a2, m7502a3, m7502a4, m7502a5)) {
            f7673b.put("m", m7502a);
            f7673b.put(C3351bh.f11576aA, m7502a2);
            f7673b.put("d", m7502a3);
            f7673b.put("t", m7502a4);
            f7673b.put(C3351bh.f11580aE, m7502a5);
        }
    }

    /* renamed from: e */
    private static synchronized String m7497e(Context context) {
        synchronized (AbstractC2474l.class) {
            String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(m7498f(), m7491b());
            if (C2476n.m7504a(decryptWorkKey)) {
                HMSLog.m7717i(f7672a, "keyS has been upgraded, no require operate again.");
                return decryptWorkKey;
            }
            String decryptWorkKey2 = WorkKeyCryptUtil.decryptWorkKey(m7498f(), m7500h());
            if (C2476n.m7504a(decryptWorkKey2)) {
                HMSLog.m7717i(f7672a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                m7483a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, m7491b()), context);
                return decryptWorkKey2;
            }
            String decryptWorkKey3 = WorkKeyCryptUtil.decryptWorkKey(m7498f(), BaseKeyUtil.exportRootKey(m7494d(), m7496e(), m7492c(), m7499g(), 32, false));
            if (!C2476n.m7504a(decryptWorkKey3)) {
                HMSLog.m7715e(f7672a, "all mode unable to decrypt root key.");
                return "";
            }
            HMSLog.m7717i(f7672a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
            m7483a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, m7491b()), context);
            return decryptWorkKey3;
        }
    }

    /* renamed from: f */
    private static String m7498f() {
        return m7482a(C3351bh.f11580aE);
    }

    /* renamed from: g */
    private static String m7499g() {
        return m7482a("t");
    }

    /* renamed from: h */
    private static RootKeyUtil m7500h() {
        return RootKeyUtil.newInstance(m7494d(), m7496e(), m7492c(), m7499g());
    }

    /* renamed from: i */
    private static boolean m7501i() {
        return !TextUtils.isEmpty(m7498f());
    }

    /* renamed from: b */
    public static String m7490b(Context context) {
        if (!m7501i()) {
            HMSLog.m7717i(f7672a, "work key is empty, execute init.");
            m7493c(context);
        }
        String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(m7498f(), m7491b());
        return C2476n.m7504a(decryptWorkKey) ? decryptWorkKey : m7497e(context);
    }

    /* renamed from: a */
    public static byte[] m7486a(Context context) {
        byte[] m7452a = AbstractC2466d.m7452a(context.getString(C2268R.string.push_cat_head));
        byte[] m7452a2 = AbstractC2466d.m7452a(context.getString(C2268R.string.push_cat_body));
        return m7488a(m7489a(m7489a(m7452a, m7452a2), AbstractC2466d.m7452a(m7481a())));
    }

    /* renamed from: a */
    private static byte[] m7489a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    /* renamed from: a */
    private static byte[] m7488a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] >> 2);
        }
        return bArr;
    }

    /* renamed from: a */
    private static void m7485a(String str, String str2, String str3, String str4, String str5, Context context) {
        String m7457c = AbstractC2467e.m7457c(context.getApplicationContext());
        if (TextUtils.isEmpty(m7457c)) {
            return;
        }
        try {
            m7484a("m", str, m7457c + "/files/math/m");
            m7484a(C3351bh.f11576aA, str2, m7457c + "/files/panda/p");
            m7484a("d", str3, m7457c + "/files/panda/d");
            m7484a("t", str4, m7457c + "/files/math/t");
            m7484a(C3351bh.f11580aE, str5, m7457c + "/files/s");
        } catch (IOException unused) {
            HMSLog.m7715e(f7672a, "save key IOException.");
        }
    }

    /* renamed from: d */
    private static String m7494d() {
        return m7482a("m");
    }

    /* renamed from: e */
    private static String m7496e() {
        return m7482a(C3351bh.f11576aA);
    }

    /* renamed from: c */
    private static String m7492c() {
        return m7482a("d");
    }

    /* renamed from: a */
    private static void m7483a(String str, Context context) {
        String m7457c = AbstractC2467e.m7457c(context.getApplicationContext());
        if (TextUtils.isEmpty(m7457c)) {
            return;
        }
        try {
            m7484a(C3351bh.f11580aE, str, m7457c + "/files/s");
        } catch (IOException unused) {
            HMSLog.m7715e(f7672a, "save keyS IOException.");
        }
    }

    /* renamed from: a */
    private static void m7484a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HMSLog.m7717i(f7672a, "save local secret key.");
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str3);
            AbstractC2475m.m7503a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            f7673b.put(str, str2);
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter2);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m7482a(String str) {
        String str2 = f7673b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
