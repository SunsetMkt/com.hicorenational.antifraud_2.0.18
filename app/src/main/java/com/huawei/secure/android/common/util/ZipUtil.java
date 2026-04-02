package com.huawei.secure.android.common.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZipUtil {
    private static final String a = "ZipUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5245b = 104857600;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5246c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f5247d = 4096;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5248e = "..";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f5249f = {"..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        r0 = "zipPath is a invalid path: " + d(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        r22 = r9;
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0176, code lost:
    
        com.huawei.secure.android.common.util.IOUtil.closeSecure(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0179, code lost:
    
        if (r10 != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017b, code lost:
    
        a(r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b5  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<File> a(File file, File file2, long j2, boolean z, boolean z2) throws Throwable {
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        Enumeration<? extends ZipEntry> enumerationEntries;
        int i2;
        boolean z3;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        ZipFile zipFile4 = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        zipFile4 = null;
        if (file != null && file2 != null) {
            boolean z4 = true;
            ArrayList arrayList = new ArrayList();
            try {
                if (z2) {
                    LogsUtil.i(a, "not a utf8 zip file, use gbk open zip file : " + file);
                    zipFile = new ZipFile(file, Charset.forName("GBK"));
                } else {
                    zipFile = new ZipFile(file);
                }
                zipFile2 = zipFile;
                try {
                    try {
                        enumerationEntries = zipFile2.entries();
                        i2 = 0;
                        z3 = true;
                    } catch (IOException e2) {
                        e = e2;
                        zipFile3 = zipFile2;
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile4 = zipFile2;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                try {
                } catch (Throwable th3) {
                    th = th3;
                    zipFile3 = zipFile2;
                }
                if (!enumerationEntries.hasMoreElements()) {
                    ZipFile zipFile5 = zipFile2;
                    break;
                }
                try {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String name = zipEntryNextElement.getName();
                    if (!TextUtils.isEmpty(name)) {
                        String strNormalize = Normalizer.normalize(name, Normalizer.Form.NFKC);
                        if (e(strNormalize)) {
                            break;
                        }
                        File file3 = new File(file2, strNormalize.replaceAll("\\\\", "/"));
                        if (z) {
                            try {
                                if (file3.exists() && file3.isFile()) {
                                    e(file3);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                zipFile4 = zipFile2;
                            }
                        }
                        arrayList.add(file3);
                        if (zipEntryNextElement.isDirectory()) {
                            if (!a(file3)) {
                                IOUtil.closeSecure(zipFile2);
                                a(arrayList);
                                return null;
                            }
                            zipFile3 = zipFile2;
                        } else {
                            if (!b(file3)) {
                                IOUtil.closeSecure(zipFile2);
                                a(arrayList);
                                return null;
                            }
                            try {
                                bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntryNextElement));
                                try {
                                    fileOutputStream = new FileOutputStream(file3);
                                    try {
                                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                                        try {
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int i3 = bufferedInputStream.read(bArr);
                                                if (i3 == -1) {
                                                    zipFile3 = zipFile2;
                                                    break;
                                                }
                                                i2 += i3;
                                                zipFile3 = zipFile2;
                                                if (i2 > j2) {
                                                    z3 = false;
                                                    break;
                                                }
                                                try {
                                                    bufferedOutputStream2.write(bArr, 0, i3);
                                                    zipFile2 = zipFile3;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                                    IOUtil.closeSecure((OutputStream) fileOutputStream);
                                                    throw th;
                                                }
                                            }
                                            try {
                                                IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                                                IOUtil.closeSecure((OutputStream) fileOutputStream);
                                            } catch (IOException e4) {
                                                e = e4;
                                                zipFile4 = zipFile3;
                                                try {
                                                    String str = "unzip new IOException : " + e.getMessage();
                                                    IOUtil.closeSecure(zipFile4);
                                                    a(arrayList);
                                                    return arrayList;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    z4 = false;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                zipFile4 = zipFile3;
                                                z4 = z3;
                                                IOUtil.closeSecure(zipFile4);
                                                if (!z4) {
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    fileOutputStream = null;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                bufferedInputStream = null;
                                fileOutputStream = null;
                            }
                        }
                        th = th4;
                        zipFile4 = zipFile2;
                        z4 = z3;
                        IOUtil.closeSecure(zipFile4);
                        if (!z4) {
                            a(arrayList);
                        }
                        throw th;
                    }
                    zipFile3 = zipFile2;
                } catch (IllegalArgumentException e5) {
                    zipFile3 = zipFile2;
                    LogsUtil.i(a, "not a utf8 zip file, IllegalArgumentException : " + e5.getMessage());
                    if (Build.VERSION.SDK_INT >= 24) {
                        List<File> listA = a(file, file2, j2, z, true);
                        IOUtil.closeSecure(zipFile3);
                        if (!z3) {
                            a(arrayList);
                        }
                        return listA;
                    }
                    LogsUtil.e(a, "File is not a utf8 zip file and Build.VERSION_CODES < 24");
                }
                zipFile2 = zipFile3;
            }
        } else {
            return null;
        }
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                c(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                e(file2);
            }
            c(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, 104857600L, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600L, 100, z);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(a, "delete file error");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013d  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unZip(String str, String str2, long j2, int i2, boolean z) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ?? fileOutputStream;
        ?? r11;
        ?? r112;
        ?? r6;
        String strSubstring = str2;
        boolean z2 = false;
        if (!a(str, str2, j2, i2)) {
            return false;
        }
        if (strSubstring.endsWith(File.separator) && str2.length() > File.separator.length()) {
            strSubstring = strSubstring.substring(0, str2.length() - File.separator.length());
        }
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                ?? r1 = 0;
                boolean z3 = true;
                int i3 = 0;
                while (true) {
                    try {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                break;
                            }
                            String strReplaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                            File file = new File(strSubstring, strReplaceAll);
                            String strNormalize = Normalizer.normalize(strReplaceAll, Normalizer.Form.NFKC);
                            if (e(strNormalize)) {
                                String str3 = "zipPath is a invalid path: " + d(strNormalize);
                                z3 = false;
                                break;
                            }
                            if (z && file.exists() && file.isFile()) {
                                e(file);
                            }
                            if (nextEntry.isDirectory()) {
                                d(file);
                                arrayList.add(file);
                                r1 = r1;
                            } else {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    d(parentFile);
                                }
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    while (true) {
                                        try {
                                            int i4 = zipInputStream.read(bArr, 0, 4096);
                                            if (i4 == -1) {
                                                break;
                                            }
                                            i3 += i4;
                                            if (i3 > j2) {
                                                z3 = false;
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, i4);
                                        } catch (IOException e2) {
                                            e = e2;
                                            r6 = fileOutputStream;
                                            r112 = r6;
                                            fileInputStream2 = fileInputStream;
                                            fileOutputStream = r112;
                                            try {
                                                LogsUtil.e(a, "Unzip IOException : " + e.getMessage());
                                                r11 = fileOutputStream;
                                                a(fileInputStream2, bufferedOutputStream, zipInputStream, (FileOutputStream) r11);
                                                if (!z2) {
                                                }
                                                return z2;
                                            } catch (Throwable th) {
                                                th = th;
                                                fileInputStream = fileInputStream2;
                                                a(fileInputStream, bufferedOutputStream, zipInputStream, (FileOutputStream) fileOutputStream);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            a(fileInputStream, bufferedOutputStream, zipInputStream, (FileOutputStream) fileOutputStream);
                                            throw th;
                                        }
                                    }
                                    arrayList.add(file);
                                    bufferedOutputStream.flush();
                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                    IOUtil.closeSecure((OutputStream) fileOutputStream);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    r1 = fileOutputStream;
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    r112 = fileOutputStream;
                                    fileInputStream2 = fileInputStream;
                                    fileOutputStream = r112;
                                    LogsUtil.e(a, "Unzip IOException : " + e.getMessage());
                                    r11 = fileOutputStream;
                                    a(fileInputStream2, bufferedOutputStream, zipInputStream, (FileOutputStream) r11);
                                    if (!z2) {
                                    }
                                    return z2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    a(fileInputStream, bufferedOutputStream, zipInputStream, (FileOutputStream) fileOutputStream);
                                    throw th;
                                }
                            }
                            try {
                                zipInputStream.closeEntry();
                            } catch (IOException e4) {
                                e = e4;
                                BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream2;
                                r6 = r1;
                                bufferedOutputStream = bufferedOutputStream3;
                                r112 = r6;
                                fileInputStream2 = fileInputStream;
                                fileOutputStream = r112;
                                LogsUtil.e(a, "Unzip IOException : " + e.getMessage());
                                r11 = fileOutputStream;
                                a(fileInputStream2, bufferedOutputStream, zipInputStream, (FileOutputStream) r11);
                                if (!z2) {
                                }
                                return z2;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            fileOutputStream = r1;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = r1;
                    }
                }
                IOUtil.closeSecure((InputStream) zipInputStream);
                IOUtil.closeSecure((InputStream) fileInputStream);
                r11 = r1;
                bufferedOutputStream = bufferedOutputStream2;
                fileInputStream2 = fileInputStream;
                z2 = z3;
            } catch (IOException e6) {
                e = e6;
                bufferedOutputStream = null;
                zipInputStream = null;
                r112 = 0;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                zipInputStream = null;
                fileOutputStream = zipInputStream;
                a(fileInputStream, bufferedOutputStream, zipInputStream, (FileOutputStream) fileOutputStream);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedOutputStream = null;
            zipInputStream = null;
            fileOutputStream = 0;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            fileInputStream = null;
            zipInputStream = null;
        }
        a(fileInputStream2, bufferedOutputStream, zipInputStream, (FileOutputStream) r11);
        if (!z2) {
            a(arrayList);
        }
        return z2;
    }

    public static List<File> unZipNew(String str, String str2, long j2, int i2, boolean z) throws SecurityCommonException {
        if (!a(str, str2, j2, i2)) {
            return null;
        }
        if (str2.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str2 = str2.substring(0, str2.length() - File.separator.length());
        }
        return a(c(str), c(str2), j2, z, false);
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(a, "mkdirs error , files exists or IOException.");
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(f5248e)) {
            return true;
        }
        for (String str2 : f5249f) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str) && e(str)) {
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:35:0x00c3
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @androidx.annotation.RequiresApi(api = 24)
    private static boolean a(java.lang.String r19, long r20, int r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.lang.String, long, int, boolean):boolean");
    }

    private static boolean a(String str, String str2, long j2, int i2) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !e(str)) {
            if (!TextUtils.isEmpty(str2) && !e(str2)) {
                if (a(str, j2, i2, false)) {
                    return true;
                }
                LogsUtil.e(a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
