package com.huawei.hms.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p286h.C5230f1;

/* loaded from: classes.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a */
    private static final String f7975a = "ReadApkFileUtil";

    /* renamed from: c */
    private static String f7977c;

    /* renamed from: d */
    private static String f7978d;

    /* renamed from: e */
    private static String f7979e;

    /* renamed from: b */
    private static final Pattern f7976b = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: f */
    private static String f7980f = null;

    /* renamed from: g */
    private static String f7981g = null;

    /* renamed from: a */
    private static byte[] m7802a(ZipFile zipFile) {
        return m7803a(zipFile, "META-INF/MANIFEST.MF");
    }

    @TargetApi(19)
    /* renamed from: b */
    private static void m7804b(byte[] bArr) {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        if (bArr == null) {
            HMSLog.m7715e(f7975a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        f7977c = null;
        f7978d = null;
        f7979e = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                    try {
                        String m7794a = m7794a(bufferedReader);
                        while (m7794a != null) {
                            if (m7794a.length() != 0) {
                                if (m7794a.startsWith("ApkHash:")) {
                                    f7980f = m7795a(m7794a.substring(m7794a.indexOf(Constants.COLON_SEPARATOR) + 1));
                                }
                                if (m7794a.startsWith(KEY_SIGNATURE)) {
                                    f7977c = m7795a(m7794a.substring(m7794a.indexOf(Constants.COLON_SEPARATOR) + 1));
                                    m7794a = m7794a(bufferedReader);
                                } else if (m7794a.startsWith(KEY_SIGNATURE2)) {
                                    f7978d = m7795a(m7794a.substring(m7794a.indexOf(Constants.COLON_SEPARATOR) + 1));
                                    m7794a = m7794a(bufferedReader);
                                } else if (m7794a.startsWith(KEY_SIGNATURE3)) {
                                    f7979e = m7795a(m7794a.substring(m7794a.indexOf(Constants.COLON_SEPARATOR) + 1));
                                    m7794a = m7794a(bufferedReader);
                                } else {
                                    stringBuffer.append(m7794a);
                                    stringBuffer.append("\r\n");
                                }
                            }
                            m7794a = m7794a(bufferedReader);
                        }
                        f7981g = stringBuffer.toString();
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader;
                        HMSLog.m7715e(f7975a, "loadApkCert Exception!");
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
        }
        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & C5230f1.f20085c;
            int i4 = i2 * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
        }
        return String.valueOf(cArr2);
    }

    /* renamed from: c */
    private static boolean m7807c() {
        try {
        } catch (Exception e2) {
            HMSLog.m7717i(f7975a, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
        }
        if (m7799a(Base64.decode(EMUI11_PK, 0), m7800a(f7981g, "SHA-384"), m7806b(f7979e), "SHA384withRSA")) {
            HMSLog.m7717i(f7975a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        HMSLog.m7717i(f7975a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (f7979e != null) {
            return m7807c();
        }
        if (f7978d != null) {
            return m7805b();
        }
        if (f7977c != null) {
            return m7797a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m7715e(f7975a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(19)
    public static boolean isCertFound(String str) {
        ZipFile zipFile;
        boolean z;
        ZipFile zipFile2 = null;
        zipFile2 = null;
        ZipFile zipFile3 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    z = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z) {
                        m7804b(m7803a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        String str2 = f7975a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("zipFile.close Exception!");
                        sb.append(e2.getMessage());
                        HMSLog.m7715e(str2, sb.toString());
                        zipFile2 = sb;
                    }
                } catch (Exception e3) {
                    e = e3;
                    zipFile3 = zipFile;
                    HMSLog.m7715e(f7975a, "isCertFound Exception!" + e.getMessage());
                    ZipFile zipFile4 = zipFile3;
                    if (zipFile3 != null) {
                        try {
                            zipFile3.close();
                            zipFile4 = zipFile3;
                        } catch (IOException e4) {
                            String str3 = f7975a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("zipFile.close Exception!");
                            sb2.append(e4.getMessage());
                            HMSLog.m7715e(str3, sb2.toString());
                            zipFile4 = sb2;
                        }
                    }
                    z = false;
                    zipFile2 = zipFile4;
                    return z;
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            HMSLog.m7715e(f7975a, "zipFile.close Exception!" + e5.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            zipFile = zipFile2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean verifyApkHash(String str) {
        ZipFile zipFile;
        String str2 = null;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    byte[] m7802a = m7802a(zipFile);
                    ArrayList<String> m7796a = m7796a(m7802a);
                    if (m7796a != null) {
                        m7802a = m7801a(m7796a);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(m7802a);
                    String bytesToString = bytesToString(messageDigest.digest());
                    String str3 = f7980f;
                    if (str3 != null) {
                        if (str3.equals(bytesToString)) {
                            try {
                                zipFile.close();
                            } catch (Exception e2) {
                                HMSLog.m7717i(f7975a, "close stream Exception!" + e2.getMessage());
                            }
                            return true;
                        }
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e3) {
                        HMSLog.m7717i(f7975a, "close stream Exception!" + e3.getMessage());
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    zipFile2 = zipFile;
                    HMSLog.m7717i(f7975a, "verifyApkHash Exception!" + e.getMessage());
                    if (zipFile2 == null) {
                        return false;
                    }
                    try {
                        zipFile2.close();
                        return false;
                    } catch (Exception e5) {
                        str2 = f7975a;
                        HMSLog.m7717i(str2, "close stream Exception!" + e5.getMessage());
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e6) {
                            HMSLog.m7717i(f7975a, "close stream Exception!" + e6.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* renamed from: a */
    private static byte[] m7803a(ZipFile zipFile, String str) {
        Throwable th;
        InputStream inputStream;
        Exception e2;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r4;
        OutputStream outputStream;
        OutputStream outputStream2;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream3 = null;
        if (entry == null) {
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(entry);
            if (inputStream == null) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Exception e3) {
                e2 = e3;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                r4 = byteArrayOutputStream;
                try {
                    HMSLog.m7717i(f7975a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r4);
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    outputStream2 = r4;
                    bufferedInputStream = bufferedInputStream;
                    outputStream = outputStream2;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th2;
            }
            try {
                byte[] bArr = new byte[4096];
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    r4 = new BufferedOutputStream(byteArrayOutputStream);
                } catch (Exception e4) {
                    e2 = e4;
                    r4 = 0;
                } catch (Throwable th5) {
                    th2 = th5;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
                try {
                    for (int read = bufferedInputStream.read(bArr, 0, 4096); read > 0; read = bufferedInputStream.read(bArr, 0, 4096)) {
                        r4.write(bArr, 0, read);
                    }
                    r4.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r4);
                    return byteArray;
                } catch (Exception e5) {
                    e2 = e5;
                    HMSLog.m7717i(f7975a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r4);
                    return null;
                } catch (Throwable th6) {
                    th2 = th6;
                    outputStream = r4;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
            } catch (Exception e6) {
                e2 = e6;
                byteArrayOutputStream = null;
                r4 = byteArrayOutputStream;
                HMSLog.m7717i(f7975a, "getManifestBytes Exception!" + e2.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) r4);
                return null;
            } catch (Throwable th7) {
                th2 = th7;
                byteArrayOutputStream = null;
                outputStream2 = null;
                bufferedInputStream = bufferedInputStream;
                outputStream = outputStream2;
                outputStream3 = outputStream;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th2;
            }
        } catch (Exception e7) {
            e2 = e7;
            inputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    private static ArrayList<String> m7796a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.m7715e(f7975a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (m7798a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.m7715e(f7975a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m7805b() {
        try {
        } catch (Exception e2) {
            HMSLog.m7717i(f7975a, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
        }
        if (m7799a(Base64.decode(EMUI10_PK, 0), m7800a(f7981g, "SHA-256"), m7806b(f7978d), "SHA256withRSA")) {
            HMSLog.m7717i(f7975a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        HMSLog.m7717i(f7975a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static byte[] m7801a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e2) {
                HMSLog.m7717i(f7975a, "getManifestBytesbySorted Exception!" + e2.getMessage());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    /* renamed from: b */
    private static byte[] m7806b(String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i2 = length / 2;
        } else {
            i2 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            int i4 = i3 + 1;
            if (i4 < length) {
                bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i4), 16));
            } else {
                bArr[i3 / 2] = (byte) (Character.digit(str.charAt(i3), 16) << 4);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static boolean m7798a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String m7794a = m7794a(bufferedReader);
        boolean z = false;
        while (m7794a != null) {
            if (m7794a.equals("Name: META-INF/HUAWEI.CER")) {
                z = true;
                String m7794a2 = m7794a(bufferedReader);
                while (true) {
                    if (m7794a2 == null) {
                        break;
                    }
                    if (m7794a2.startsWith("Name:")) {
                        m7794a = m7794a2;
                        break;
                    }
                    m7794a2 = m7794a(bufferedReader);
                }
            }
            if (m7794a.length() != 0) {
                arrayList.add(m7794a);
            }
            m7794a = m7794a(bufferedReader);
        }
        return z;
    }

    /* renamed from: a */
    private static String m7794a(BufferedReader bufferedReader) throws IOException {
        int read;
        if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(10);
        while (read != -1) {
            char c2 = (char) read;
            if (c2 == '\n') {
                break;
            }
            if (sb.length() < 4096) {
                sb.append(c2);
                read = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String sb2 = sb.toString();
        return (sb2.isEmpty() || !sb2.endsWith("\r")) ? sb2 : sb2.substring(0, sb2.length() - 1);
    }

    /* renamed from: a */
    private static boolean m7797a() {
        try {
            if (m7799a(m7806b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), m7800a(f7981g, "SHA-256"), m7806b(f7977c), "SHA256withRSA")) {
                HMSLog.m7717i(f7975a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.m7717i(f7975a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e2) {
            HMSLog.m7717i(f7975a, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m7799a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    @TargetApi(19)
    /* renamed from: a */
    private static byte[] m7800a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    /* renamed from: a */
    private static String m7795a(String str) {
        return str != null ? f7976b.matcher(str).replaceAll("") : "";
    }
}
