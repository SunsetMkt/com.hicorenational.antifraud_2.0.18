package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.hatool.x */
/* loaded from: classes.dex */
public class C2456x {

    /* renamed from: a */
    private String f7643a = AbstractC2443q0.m7311i().getFilesDir().getPath();

    C2456x() {
    }

    /* renamed from: a */
    private String m7402a(String str) {
        return this.f7643a + "/hms/component/".replace("component", str);
    }

    /* renamed from: a */
    private void m7403a(String str, String str2) {
        File file = new File(m7402a(str));
        File file2 = new File(m7402a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            C2452v.m7385c("hmsSdk", "file directory is mkdirs");
        }
        if (m7404a(file2)) {
            C2426k1.m7203a(file2, str2);
        } else {
            C2452v.m7390f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    /* renamed from: a */
    private boolean m7404a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            C2452v.m7390f("hmsSdk", "create new file error!");
            return false;
        }
    }

    /* renamed from: a */
    private char[] m7405a(String str, String str2, String str3, String str4) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        if (length > hexStr2ByteArray2.length) {
            length = hexStr2ByteArray2.length;
        }
        if (length > hexStr2ByteArray3.length) {
            length = hexStr2ByteArray3.length;
        }
        if (length > hexStr2ByteArray4.length) {
            length = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = (char) (((hexStr2ByteArray[i2] ^ hexStr2ByteArray2[i2]) ^ hexStr2ByteArray3[i2]) ^ hexStr2ByteArray4[i2]);
        }
        return cArr;
    }

    /* renamed from: b */
    private String m7406b(String str) {
        File file = new File(m7402a(str), "hianalytics_" + str);
        if (m7404a(file)) {
            return C2426k1.m7200a(file);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        C2426k1.m7203a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    /* renamed from: b */
    private boolean m7407b() {
        long m7068a = C2403d.m7068a(AbstractC2443q0.m7311i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != m7068a) {
            return System.currentTimeMillis() - m7068a > 31536000000L;
        }
        C2452v.m7385c("hmsSdk", "First init components");
        return true;
    }

    /* renamed from: b */
    private static boolean m7408b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    C2452v.m7385c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                m7408b(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: c */
    public static boolean m7409c() {
        return m7408b(new File(AbstractC2443q0.m7311i().getFilesDir().getPath() + "/hms"));
    }

    /* renamed from: d */
    private String m7410d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    /* renamed from: a */
    public String m7411a() {
        String m7406b;
        String m7406b2;
        String m7406b3;
        String m7406b4;
        String m7410d = m7410d();
        if (m7407b()) {
            C2452v.m7385c("hmsSdk", "refresh components");
            m7406b = EncryptUtil.generateSecureRandomStr(128);
            m7403a("aprpap", m7406b);
            m7406b2 = EncryptUtil.generateSecureRandomStr(128);
            m7403a("febdoc", m7406b2);
            m7406b3 = EncryptUtil.generateSecureRandomStr(128);
            m7403a("marfil", m7406b3);
            m7406b4 = EncryptUtil.generateSecureRandomStr(128);
            m7403a("maywnj", m7406b4);
            C2403d.m7073b(AbstractC2443q0.m7311i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            m7406b = m7406b("aprpap");
            m7406b2 = m7406b("febdoc");
            m7406b3 = m7406b("marfil");
            m7406b4 = m7406b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(m7405a(m7406b, m7406b2, m7406b3, m7410d), HexUtil.hexStr2ByteArray(m7406b4), 10000, 16));
    }
}
