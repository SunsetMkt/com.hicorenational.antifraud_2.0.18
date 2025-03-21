package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import com.umeng.analytics.pro.bh;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecretUtil.java */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7142a = "l";

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, String> f7143b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f7144c = new Object();

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static byte[] a(String str, String str2, String str3, String str4) {
        return Build.VERSION.SDK_INT >= 26 ? BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true) : BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (f7144c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f7142a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(e.c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.i(f7142a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String a2 = d.a(generateSecureRandom);
            String a3 = d.a(generateSecureRandom2);
            String a4 = d.a(generateSecureRandom3);
            String a5 = d.a(generateSecureRandom4);
            a(a2, a3, a4, a5, WorkKeyCryptUtil.encryptWorkKey(d.a(EncryptUtil.generateSecureRandom(32)), a(a2, a3, a4, a5)), context);
            HMSLog.i(f7142a, "generate D.");
        }
    }

    private static void d(Context context) {
        if (i()) {
            HMSLog.i(f7142a, "secretKeyCache not empty.");
            return;
        }
        f7143b.clear();
        String c2 = e.c(context);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String a2 = m.a(c2 + "/files/math/m");
        String a3 = m.a(c2 + "/files/panda/p");
        String a4 = m.a(c2 + "/files/panda/d");
        String a5 = m.a(c2 + "/files/math/t");
        String a6 = m.a(c2 + "/files/s");
        if (n.a(a2, a3, a4, a5, a6)) {
            f7143b.put("m", a2);
            f7143b.put(bh.aA, a3);
            f7143b.put("d", a4);
            f7143b.put("t", a5);
            f7143b.put(bh.aE, a6);
        }
    }

    private static synchronized String e(Context context) {
        synchronized (l.class) {
            String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
            if (n.a(decryptWorkKey)) {
                HMSLog.i(f7142a, "keyS has been upgraded, no require operate again.");
                return decryptWorkKey;
            }
            String decryptWorkKey2 = WorkKeyCryptUtil.decryptWorkKey(f(), h());
            if (n.a(decryptWorkKey2)) {
                HMSLog.i(f7142a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, b()), context);
                return decryptWorkKey2;
            }
            String decryptWorkKey3 = WorkKeyCryptUtil.decryptWorkKey(f(), BaseKeyUtil.exportRootKey(d(), e(), c(), g(), 32, false));
            if (!n.a(decryptWorkKey3)) {
                HMSLog.e(f7142a, "all mode unable to decrypt root key.");
                return "";
            }
            HMSLog.i(f7142a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
            a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, b()), context);
            return decryptWorkKey3;
        }
    }

    private static String f() {
        return a(bh.aE);
    }

    private static String g() {
        return a("t");
    }

    private static RootKeyUtil h() {
        return RootKeyUtil.newInstance(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f7142a, "work key is empty, execute init.");
            c(context);
        }
        String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
        return n.a(decryptWorkKey) ? decryptWorkKey : e(context);
    }

    public static byte[] a(Context context) {
        byte[] a2 = d.a(context.getString(R.string.push_cat_head));
        byte[] a3 = d.a(context.getString(R.string.push_cat_body));
        return a(a(a(a2, a3), d.a(a())));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
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

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] >> 2);
        }
        return bArr;
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c2 = e.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            a("m", str, c2 + "/files/math/m");
            a(bh.aA, str2, c2 + "/files/panda/p");
            a("d", str3, c2 + "/files/panda/d");
            a("t", str4, c2 + "/files/math/t");
            a(bh.aE, str5, c2 + "/files/s");
        } catch (IOException unused) {
            HMSLog.e(f7142a, "save key IOException.");
        }
    }

    private static String d() {
        return a("m");
    }

    private static String e() {
        return a(bh.aA);
    }

    private static String c() {
        return a("d");
    }

    private static void a(String str, Context context) {
        String c2 = e.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            a(bh.aE, str, c2 + "/files/s");
        } catch (IOException unused) {
            HMSLog.e(f7142a, "save keyS IOException.");
        }
    }

    private static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HMSLog.i(f7142a, "save local secret key.");
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str3);
            m.a(file);
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
            f7143b.put(str, str2);
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

    private static String a(String str) {
        String str2 = f7143b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
