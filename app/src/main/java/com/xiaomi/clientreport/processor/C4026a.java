package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.data.C4024a;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.manager.C4025a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4110bl;
import com.xiaomi.push.C4260h;
import com.xiaomi.push.C4408w;
import com.xiaomi.push.C4410y;
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

/* renamed from: com.xiaomi.clientreport.processor.a */
/* loaded from: classes2.dex */
public class C4026a implements IEventProcessor {

    /* renamed from: a */
    protected Context f14333a;

    /* renamed from: a */
    private HashMap<String, ArrayList<C4024a>> f14334a;

    public C4026a(Context context) {
        m13399a(context);
    }

    /* renamed from: a */
    public void m13399a(Context context) {
        this.f14333a = context;
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC4029d
    /* renamed from: b */
    public void mo13403b() {
        HashMap<String, ArrayList<C4024a>> hashMap = this.f14334a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f14334a.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<C4024a> arrayList = this.f14334a.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    C4024a[] c4024aArr = new C4024a[arrayList.size()];
                    arrayList.toArray(c4024aArr);
                    m13402a(c4024aArr);
                }
            }
        }
        this.f14334a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] m13924a;
        if (bArr != null && bArr.length >= 1) {
            if (!C4025a.m13366a(this.f14333a).m13381a().isEventEncrypted()) {
                return C4100bb.m13889b(bArr);
            }
            String m13918a = C4110bl.m13918a(this.f14333a);
            if (!TextUtils.isEmpty(m13918a) && (m13924a = C4110bl.m13924a(m13918a)) != null && m13924a.length > 0) {
                try {
                    return C4100bb.m13889b(Base64.decode(C4260h.m15241a(m13924a, bArr), 2));
                } catch (InvalidAlgorithmParameterException e2) {
                    AbstractC4022b.m13351a(e2);
                } catch (InvalidKeyException e3) {
                    AbstractC4022b.m13351a(e3);
                } catch (NoSuchAlgorithmException e4) {
                    AbstractC4022b.m13351a(e4);
                } catch (BadPaddingException e5) {
                    AbstractC4022b.m13351a(e5);
                } catch (IllegalBlockSizeException e6) {
                    AbstractC4022b.m13351a(e6);
                } catch (NoSuchPaddingException e7) {
                    AbstractC4022b.m13351a(e7);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<C4024a>> hashMap) {
        this.f14334a = hashMap;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] m13924a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!C4025a.m13366a(this.f14333a).m13381a().isEventEncrypted()) {
            return C4100bb.m13887a(str);
        }
        String m13918a = C4110bl.m13918a(this.f14333a);
        byte[] m13887a = C4100bb.m13887a(str);
        if (!TextUtils.isEmpty(m13918a) && m13887a != null && m13887a.length > 1 && (m13924a = C4110bl.m13924a(m13918a)) != null) {
            try {
                if (m13924a.length > 1) {
                    return C4260h.m15242b(m13924a, Base64.encode(m13887a, 2));
                }
            } catch (Exception e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m13392a(C4024a c4024a) {
        return String.valueOf(c4024a.production);
    }

    /* renamed from: a */
    public void mo13401a(List<String> list) {
        C4110bl.m13921a(this.f14333a, list);
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC4028c
    /* renamed from: a */
    public void mo13398a() {
        int i2;
        RandomAccessFile randomAccessFile;
        C4110bl.m13920a(this.f14333a, "event", "eventUploading");
        File[] m13925a = C4110bl.m13925a(this.f14333a, "eventUploading");
        if (m13925a == null || m13925a.length <= 0) {
            return;
        }
        int length = m13925a.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        while (i2 < length) {
            File file2 = m13925a[i2];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        AbstractC4022b.m13351a(e2);
                    }
                }
                C4408w.m16356a(randomAccessFile2);
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
                    AbstractC4022b.m13361d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                    m13395a(file2.getName(), Formatter.formatFileSize(this.f14333a, file2.length()));
                    file2.delete();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            AbstractC4022b.m13351a(e4);
                        }
                    }
                    C4408w.m16356a(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath + ".lock");
                    try {
                        C4408w.m16360a(file3);
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                    } catch (Exception e5) {
                        e = e5;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        mo13401a(m13393a(absolutePath));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                AbstractC4022b.m13351a(e6);
                            }
                        }
                        C4408w.m16356a(randomAccessFile);
                        file3.delete();
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                    } catch (Exception e7) {
                        e = e7;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        AbstractC4022b.m13351a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                AbstractC4022b.m13351a(e8);
                            }
                        }
                        C4408w.m16356a(randomAccessFile2);
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
                                AbstractC4022b.m13351a(e9);
                            }
                        }
                        C4408w.m16356a(randomAccessFile2);
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

    /* renamed from: b */
    private String m13397b(C4024a c4024a) {
        File file = new File(this.f14333a.getFilesDir(), "event");
        String str = file.getAbsolutePath() + File.separator + m13392a(c4024a);
        for (int i2 = 0; i2 < 100; i2++) {
            String str2 = str + i2;
            if (C4110bl.m13923a(this.f14333a, str2)) {
                return str2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m13395a(String str, String str2) {
        EventClientReport m13382a = C4025a.m13366a(this.f14333a).m13382a(5001, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m13382a.toJsonString());
        mo13401a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> m13393a(java.lang.String r9) {
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
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L25:
            int r9 = com.xiaomi.push.C4410y.m16368a(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r7 = -573785174(0xffffffffddccbbaa, float:-1.8440715E18)
            if (r9 == r7) goto L32
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L32:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r9 != r4) goto L39
            goto L6e
        L39:
            if (r9 == r1) goto L41
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L41:
            int r9 = com.xiaomi.push.C4410y.m16368a(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
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
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L6e
        L5b:
            java.lang.String r9 = r8.bytesToString(r4)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            goto L15
        L69:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
        L6e:
            com.xiaomi.push.C4408w.m16356a(r5)
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
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13351a(r9)     // Catch: java.lang.Throwable -> L77
            com.xiaomi.push.C4408w.m16356a(r4)
        L81:
            return r0
        L82:
            com.xiaomi.push.C4408w.m16356a(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C4026a.m13393a(java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public void m13402a(C4024a[] c4024aArr) {
        if (c4024aArr == null || c4024aArr.length == 0 || c4024aArr[0] == null) {
            AbstractC4022b.m13347a("event data write to cache file failed because data null");
            return;
        }
        do {
            c4024aArr = m13396a(c4024aArr);
            if (c4024aArr == null || c4024aArr.length <= 0) {
                return;
            }
        } while (c4024aArr[0] != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* renamed from: a */
    private C4024a[] m13396a(C4024a[] c4024aArr) {
        Closeable closeable;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String m13397b = m13397b(c4024aArr[0]);
        FileLock isEmpty = TextUtils.isEmpty(m13397b);
        try {
            if (isEmpty != 0) {
                return null;
            }
            try {
                File file = new File(m13397b + ".lock");
                C4408w.m16360a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    isEmpty = randomAccessFile.getChannel().lock();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(m13397b), true));
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        C4408w.m16356a(closeable);
                        m13394a(randomAccessFile, isEmpty);
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
                for (C4024a c4024a : c4024aArr) {
                    if (c4024a != null) {
                        byte[] stringToBytes = stringToBytes(c4024a.toJsonString());
                        if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                            if (!C4110bl.m13923a(this.f14333a, m13397b)) {
                                int length = c4024aArr.length - i2;
                                C4024a[] c4024aArr2 = new C4024a[length];
                                System.arraycopy(c4024aArr, i2, c4024aArr2, 0, length);
                                C4408w.m16356a(bufferedOutputStream);
                                m13394a(randomAccessFile, (FileLock) isEmpty);
                                return c4024aArr2;
                            }
                            bufferedOutputStream.write(C4410y.m16369a(-573785174));
                            bufferedOutputStream.write(C4410y.m16369a(stringToBytes.length));
                            bufferedOutputStream.write(stringToBytes);
                            bufferedOutputStream.flush();
                            i2++;
                        }
                        AbstractC4022b.m13361d("event data throw a invalid item ");
                    }
                }
            } catch (Exception e5) {
                e = e5;
                AbstractC4022b.m13349a("event data write to cache file failed cause exception", e);
                C4408w.m16356a(bufferedOutputStream);
                m13394a(randomAccessFile, isEmpty);
                return null;
            }
            C4408w.m16356a(bufferedOutputStream);
            m13394a(randomAccessFile, isEmpty);
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    private void m13394a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
        C4408w.m16356a(randomAccessFile);
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC4029d
    /* renamed from: a */
    public void mo13400a(C4024a c4024a) {
        if ((c4024a instanceof EventClientReport) && this.f14334a != null) {
            EventClientReport eventClientReport = (EventClientReport) c4024a;
            String m13392a = m13392a((C4024a) eventClientReport);
            ArrayList<C4024a> arrayList = this.f14334a.get(m13392a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f14334a.put(m13392a, arrayList);
        }
    }
}
