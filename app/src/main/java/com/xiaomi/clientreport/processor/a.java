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

/* loaded from: classes2.dex */
public class a implements IEventProcessor {

    /* renamed from: a, reason: collision with root package name */
    protected Context f12333a;

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f86a;

    public a(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.f12333a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f86a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f86a.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f86a.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m63a(aVarArr);
                }
            }
        }
        this.f86a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] a2;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.f12333a).m59a().isEventEncrypted()) {
                return bb.b(bArr);
            }
            String a3 = bl.a(this.f12333a);
            if (!TextUtils.isEmpty(a3) && (a2 = bl.a(a3)) != null && a2.length > 0) {
                try {
                    return bb.b(Base64.decode(h.a(a2, bArr), 2));
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
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f86a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.f12333a).m59a().isEventEncrypted()) {
            return bb.m178a(str);
        }
        String a3 = bl.a(this.f12333a);
        byte[] m178a = bb.m178a(str);
        if (!TextUtils.isEmpty(a3) && m178a != null && m178a.length > 1 && (a2 = bl.a(a3)) != null) {
            try {
                if (a2.length > 1) {
                    return h.b(a2, Base64.encode(m178a, 2));
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
        bl.a(this.f12333a, list);
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        int i2;
        RandomAccessFile randomAccessFile;
        bl.a(this.f12333a, "event", "eventUploading");
        File[] m186a = bl.m186a(this.f12333a, "eventUploading");
        if (m186a == null || m186a.length <= 0) {
            return;
        }
        int length = m186a.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        while (i2 < length) {
            File file2 = m186a[i2];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                w.a(randomAccessFile2);
                i2 = file == null ? i2 + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                if (file2.length() > 5242880) {
                    com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                    a(file2.getName(), Formatter.formatFileSize(this.f12333a, file2.length()));
                    file2.delete();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    w.a(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath + ".lock");
                    try {
                        w.m765a(file3);
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                    } catch (Exception e5) {
                        e = e5;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        a(a(absolutePath));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                com.xiaomi.channel.commonutils.logger.b.a(e6);
                            }
                        }
                        w.a(randomAccessFile);
                        file3.delete();
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                    } catch (Exception e7) {
                        e = e7;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                com.xiaomi.channel.commonutils.logger.b.a(e8);
                            }
                        }
                        w.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                                com.xiaomi.channel.commonutils.logger.b.a(e9);
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
            }
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File file = new File(this.f12333a.getFilesDir(), "event");
        String str = file.getAbsolutePath() + File.separator + a(aVar);
        for (int i2 = 0; i2 < 100; i2++) {
            String str2 = str + i2;
            if (bl.m185a(this.f12333a, str2)) {
                return str2;
            }
        }
        return null;
    }

    private void a(String str, String str2) {
        EventClientReport a2 = com.xiaomi.clientreport.manager.a.a(this.f12333a).a(5001, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.toJsonString());
        a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> a(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
        L15:
            int r9 = r5.read(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r4 = -1
            if (r9 != r4) goto L1d
            goto L6e
        L1d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L25
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L25:
            int r9 = com.xiaomi.push.y.a(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r7 = -573785174(0xffffffffddccbbaa, float:-1.8440715E18)
            if (r9 == r7) goto L32
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L32:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r9 != r4) goto L39
            goto L6e
        L39:
            if (r9 == r1) goto L41
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L41:
            int r9 = com.xiaomi.push.y.a(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r4 = 1
            if (r9 < r4) goto L69
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L4d
            goto L69
        L4d:
            byte[] r4 = new byte[r9]     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r6 = r5.read(r4)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r6 == r9) goto L5b
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L5b:
            java.lang.String r9 = r8.bytesToString(r4)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L15
        L69:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
        L6e:
            com.xiaomi.push.w.a(r5)
            goto L81
        L72:
            r9 = move-exception
            goto L82
        L74:
            r9 = move-exception
            r4 = r5
            goto L7b
        L77:
            r9 = move-exception
            r5 = r4
            goto L82
        L7a:
            r9 = move-exception
        L7b:
            com.xiaomi.channel.commonutils.logger.b.a(r9)     // Catch: java.lang.Throwable -> L77
            com.xiaomi.push.w.a(r4)
        L81:
            return r0
        L82:
            com.xiaomi.push.w.a(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.a.a(java.lang.String):java.util.List");
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m63a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("event data write to cache file failed because data null");
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
    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        Closeable closeable;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String b2 = b(aVarArr[0]);
        FileLock isEmpty = TextUtils.isEmpty(b2);
        try {
            if (isEmpty != 0) {
                return null;
            }
            try {
                File file = new File(b2 + ".lock");
                w.m765a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    isEmpty = randomAccessFile.getChannel().lock();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b2), true));
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        w.a(closeable);
                        a(randomAccessFile, isEmpty);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    isEmpty = 0;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    isEmpty = 0;
                    closeable = null;
                }
            } catch (Exception e4) {
                e = e4;
                isEmpty = 0;
                randomAccessFile = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                isEmpty = 0;
                randomAccessFile = null;
                closeable = null;
            }
            try {
                int i2 = 0;
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                        if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                            if (!bl.m185a(this.f12333a, b2)) {
                                int length = aVarArr.length - i2;
                                com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                System.arraycopy(aVarArr, i2, aVarArr2, 0, length);
                                w.a(bufferedOutputStream);
                                a(randomAccessFile, (FileLock) isEmpty);
                                return aVarArr2;
                            }
                            bufferedOutputStream.write(y.a(-573785174));
                            bufferedOutputStream.write(y.a(stringToBytes.length));
                            bufferedOutputStream.write(stringToBytes);
                            bufferedOutputStream.flush();
                            i2++;
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                    }
                }
            } catch (Exception e5) {
                e = e5;
                com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                w.a(bufferedOutputStream);
                a(randomAccessFile, isEmpty);
                return null;
            }
            w.a(bufferedOutputStream);
            a(randomAccessFile, isEmpty);
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
    /* renamed from: a, reason: collision with other method in class */
    public void mo62a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f86a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f86a.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f86a.put(a2, arrayList);
        }
    }
}
