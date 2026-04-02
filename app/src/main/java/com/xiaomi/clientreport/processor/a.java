package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.bb;
import com.xiaomi.push.bl;
import com.xiaomi.push.h;
import com.xiaomi.push.w;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes2.dex */
public class a implements IEventProcessor {
    protected Context a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f86a;

    public a(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() throws Throwable {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.f86a;
        if (map == null) {
            return;
        }
        if (map.size() > 0) {
            Iterator<String> it = this.f86a.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f86a.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m61a(aVarArr);
                }
            }
        }
        this.f86a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] bArrA;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.a).m57a().isEventEncrypted()) {
                return bb.b(bArr);
            }
            String strA = bl.a(this.a);
            if (!TextUtils.isEmpty(strA) && (bArrA = bl.a(strA)) != null && bArrA.length > 0) {
                try {
                    return bb.b(Base64.decode(h.a(bArrA, bArr), 2));
                } catch (InvalidAlgorithmParameterException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                } catch (InvalidKeyException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                } catch (NoSuchAlgorithmException e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                } catch (BadPaddingException e5) {
                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                } catch (IllegalBlockSizeException e6) {
                    com.xiaomi.channel.commonutils.logger.b.a(e6);
                } catch (NoSuchPaddingException e7) {
                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map) {
        this.f86a = map;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] bArrA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.a).m57a().isEventEncrypted()) {
            return bb.m176a(str);
        }
        String strA = bl.a(this.a);
        byte[] bArrM176a = bb.m176a(str);
        if (!TextUtils.isEmpty(strA) && bArrM176a != null && bArrM176a.length > 1 && (bArrA = bl.a(strA)) != null) {
            try {
                if (bArrA.length > 1) {
                    return h.b(bArrA, Base64.encode(bArrM176a, 2));
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        return null;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    public void a(List<String> list) {
        bl.a(this.a, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[PHI: r3 r4 r5
  0x0036: PHI (r3v10 java.nio.channels.FileLock) = (r3v3 java.nio.channels.FileLock), (r3v1 java.nio.channels.FileLock), (r3v1 java.nio.channels.FileLock) binds: [B:65:0x0108, B:32:0x0091, B:19:0x0034] A[DONT_GENERATE, DONT_INLINE]
  0x0036: PHI (r4v14 java.io.RandomAccessFile) = (r4v3 java.io.RandomAccessFile), (r4v1 java.io.RandomAccessFile), (r4v1 java.io.RandomAccessFile) binds: [B:65:0x0108, B:32:0x0091, B:19:0x0034] A[DONT_GENERATE, DONT_INLINE]
  0x0036: PHI (r5v9 java.io.File) = (r5v3 java.io.File), (r5v1 java.io.File), (r5v1 java.io.File) binds: [B:65:0x0108, B:32:0x0091, B:19:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.xiaomi.clientreport.processor.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() throws Throwable {
        RandomAccessFile randomAccessFile;
        bl.a(this.a, "event", "eventUploading");
        File[] fileArrM184a = bl.m184a(this.a, "eventUploading");
        if (fileArrM184a == null || fileArrM184a.length <= 0) {
            return;
        }
        FileLock fileLockLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        for (File file2 : fileArrM184a) {
            if (file2 == null) {
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                w.a(randomAccessFile2);
                if (file != null) {
                    file.delete();
                }
            } else {
                try {
                    try {
                        if (file2.length() > 5242880) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                            a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                            file2.delete();
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                }
                            }
                            w.a(randomAccessFile2);
                            if (file != null) {
                            }
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            File file3 = new File(absolutePath + ".lock");
                            try {
                                w.m763a(file3);
                                randomAccessFile = new RandomAccessFile(file3, "rw");
                            } catch (Exception e4) {
                                e = e4;
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                fileLockLock = randomAccessFile.getChannel().lock();
                                a(a(absolutePath));
                                file2.delete();
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e5) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                                    }
                                }
                                w.a(randomAccessFile);
                                file3.delete();
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                            } catch (Exception e6) {
                                e = e6;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e7) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e7);
                                    }
                                }
                                w.a(randomAccessFile2);
                                if (file != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                if (fileLockLock != null && fileLockLock.isValid()) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e8) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e8);
                                    }
                                }
                                w.a(randomAccessFile2);
                                if (file != null) {
                                    file.delete();
                                    throw th;
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            }
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File file = new File(this.a.getFilesDir(), "event");
        String str = file.getAbsolutePath() + File.separator + a(aVar);
        for (int i2 = 0; i2 < 100; i2++) {
            String str2 = str + i2;
            if (bl.m183a(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    private void a(String str, String str2) {
        EventClientReport eventClientReportA = com.xiaomi.clientreport.manager.a.a(this.a).a(5001, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventClientReportA.toJsonString());
        a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> a(String str) throws Throwable {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        if (i2 != 4) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        if (y.a(bArr) != -573785174) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        int i3 = fileInputStream.read(bArr2);
                        if (i3 == -1) {
                            break;
                        }
                        if (i3 != 4) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer error");
                            break;
                        }
                        int iA = y.a(bArr2);
                        if (iA < 1 || iA > 4096) {
                            break;
                        }
                        byte[] bArr3 = new byte[iA];
                        if (fileInputStream.read(bArr3) != iA) {
                            com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause buffer size not equal length");
                            break;
                        }
                        String strBytesToString = bytesToString(bArr3);
                        if (!TextUtils.isEmpty(strBytesToString)) {
                            arrayList.add(strBytesToString);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        w.a((Closeable) fileInputStream2);
                    } catch (Throwable th) {
                        th = th;
                        w.a((Closeable) fileInputStream);
                        throw th;
                    }
                }
                w.a((Closeable) fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m61a(com.xiaomi.clientreport.data.a[] aVarArr) throws Throwable {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0) {
                return;
            }
        } while (aVarArr[0] != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7 */
    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) throws Throwable {
        Closeable closeable;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        int i2;
        int i3;
        String strB = b(aVarArr[0]);
        FileLock fileLockIsEmpty = TextUtils.isEmpty(strB);
        try {
            if (fileLockIsEmpty != 0) {
                return null;
            }
            try {
                File file = new File(strB + ".lock");
                w.m763a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLockIsEmpty = randomAccessFile.getChannel().lock();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(strB), true));
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        w.a(closeable);
                        a(randomAccessFile, fileLockIsEmpty);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileLockIsEmpty = 0;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLockIsEmpty = 0;
                    closeable = null;
                }
            } catch (Exception e4) {
                e = e4;
                fileLockIsEmpty = 0;
                randomAccessFile = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileLockIsEmpty = 0;
                randomAccessFile = null;
                closeable = null;
            }
            try {
                i3 = 0;
            } catch (Exception e5) {
                e = e5;
                com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
            }
            for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                if (aVar != null) {
                    byte[] bArrStringToBytes = stringToBytes(aVar.toJsonString());
                    if (bArrStringToBytes != null && bArrStringToBytes.length >= 1 && bArrStringToBytes.length <= 4096) {
                        if (!bl.m183a(this.a, strB)) {
                            int length = aVarArr.length - i3;
                            com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                            System.arraycopy(aVarArr, i3, aVarArr2, 0, length);
                            w.a(bufferedOutputStream);
                            a(randomAccessFile, (FileLock) fileLockIsEmpty);
                            return aVarArr2;
                        }
                        bufferedOutputStream.write(y.a(-573785174));
                        bufferedOutputStream.write(y.a(bArrStringToBytes.length));
                        bufferedOutputStream.write(bArrStringToBytes);
                        bufferedOutputStream.flush();
                        i3++;
                        w.a(bufferedOutputStream);
                        a(randomAccessFile, fileLockIsEmpty);
                        return null;
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                }
            }
            w.a(bufferedOutputStream);
            a(randomAccessFile, fileLockIsEmpty);
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        w.a(randomAccessFile);
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo60a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f86a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String strA = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f86a.get(strA);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f86a.put(strA, arrayList);
        }
    }
}
