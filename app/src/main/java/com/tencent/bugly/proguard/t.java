package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import util.x1;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class t extends DownloadTask implements Runnable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f6564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private File f6565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f6566m;

    public t(String str, String str2, long j2, long j3, String str3) {
        super(str, "", "", str3);
        this.f6564k = 0L;
        this.f6566m = 0L;
        this.f6565l = new File(str2);
        this.f6000b = this.f6565l.getParent();
        this.f6001c = this.f6565l.getName();
        this.f6003e = j2;
        this.f6004f = j3;
        getStatus();
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f6001c)) {
            return this.f6001c;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                if (str != null && (list = headerFields.get(str)) != null) {
                    for (String str2 : list) {
                        if (str2 != null && "content-disposition".equals(str.toLowerCase())) {
                            Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                            if (matcher.find()) {
                                return matcher.group(1);
                            }
                        }
                    }
                }
            }
        }
        String strSubstring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
        if (!TextUtils.isEmpty(strSubstring)) {
            return strSubstring;
        }
        return UUID.randomUUID() + x1.f15111d;
    }

    protected void b() {
        this.f6007i = 1;
        a();
        s.a.f6562b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(8, this.f6002d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            p.a.b(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f6001c = null;
        this.f6003e = 0L;
        this.f6004f = 0L;
        this.f6007i = 4;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void download() {
        if (getStatus() == 1) {
            b();
            return;
        }
        if (getStatus() == 2) {
            return;
        }
        if (getSaveFile() == null || !getSaveFile().exists()) {
            this.f6003e = 0L;
            this.f6004f = 0L;
            this.f6564k = 0L;
        } else {
            this.f6003e = getSaveFile().length();
        }
        if (this.f6005g) {
            com.tencent.bugly.beta.ui.c.a.a(this);
        }
        this.f6566m = System.currentTimeMillis();
        this.f6007i = 2;
        s.a.f6562b.put(getDownloadUrl(), this);
        s.a.a(this);
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.f6564k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.f6565l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f6004f && !s.a.f6562b.contains(this)) {
            this.f6003e = this.f6004f;
            this.f6007i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f6004f && !s.a.f6562b.contains(this)) {
            this.f6003e = getSaveFile().length();
            this.f6007i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !s.a.f6562b.contains(this)) {
            this.f6007i = 0;
        }
        return this.f6007i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0167, code lost:
    
        if (r0 < 3) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0169, code lost:
    
        com.tencent.bugly.proguard.an.b(com.tencent.bugly.proguard.t.class, "have retry %d times", 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019a, code lost:
    
        if (r5 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x019c, code lost:
    
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0163 A[Catch: all -> 0x017a, Exception -> 0x017d, TryCatch #4 {Exception -> 0x017d, blocks: (B:17:0x0099, B:31:0x00e4, B:48:0x0124, B:56:0x0136, B:70:0x0163, B:71:0x0166, B:67:0x015b, B:73:0x0169), top: B:97:0x015b, outer: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i2;
        Throwable th;
        try {
            URL url = new URL(getDownloadUrl());
            RandomAccessFile randomAccessFile = null;
            InputStream inputStream = null;
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    break;
                }
                i2 = i3 + 1;
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Referer", url.toString());
                    httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpsURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + this.f6003e + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpsURLConnection.connect();
                    this.f6001c = a(httpsURLConnection);
                    File file = new File(this.f6000b);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f6565l = new File(file, this.f6001c);
                    if (this.f6004f == 0) {
                        this.f6004f = httpsURLConnection.getContentLength();
                        if (this.f6004f <= 0) {
                            a(2000, "tLen <= 0 ");
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    p.a.a(this);
                    inputStream = httpsURLConnection.getInputStream();
                    byte[] bArr = new byte[307200];
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f6565l, "rwd");
                    try {
                        randomAccessFile2.seek(this.f6003e);
                        float f2 = 0.0f;
                        do {
                            int i4 = inputStream.read(bArr);
                            if (i4 != -1) {
                                this.f6003e += (long) i4;
                                if (this.f6003e > this.f6004f) {
                                    b();
                                    an.e("mSavedLength > mTotalLength,\u91cd\u65b0\u4e0b\u8f7d!", new Object[0]);
                                    randomAccessFile2.close();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            return;
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                float f3 = (this.f6003e / this.f6004f) * 100.0f;
                                if (f3 - f2 >= 1.0d) {
                                    a();
                                    f2 = f3;
                                }
                                randomAccessFile2.write(bArr, 0, i4);
                                if (getSaveFile() == null || !getSaveFile().exists()) {
                                    break;
                                }
                            } else {
                                b();
                                randomAccessFile2.close();
                                i3 = i2;
                            }
                        } while (getStatus() != 3);
                        randomAccessFile2.close();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (IOException e5) {
                        e = e5;
                        randomAccessFile = randomAccessFile2;
                        try {
                            e.printStackTrace();
                            a(2020, e.getMessage());
                            an.b(t.class, "IOException,stop download!", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    try {
                                        try {
                                            randomAccessFile.close();
                                        } finally {
                                        }
                                    } catch (Exception e6) {
                                        a(2000, e6.getMessage());
                                        e6.printStackTrace();
                                        if (inputStream != null) {
                                            inputStream.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                    return;
                                }
                            }
                            i3 = i2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
                i3 = i2;
            }
        } catch (MalformedURLException e9) {
            an.a(e9.getMessage(), new Object[0]);
            a(2010, e9.getMessage());
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f6007i != 5) {
            this.f6007i = 3;
        }
    }

    public t(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f6564k = 0L;
        this.f6566m = 0L;
        getStatus();
    }

    protected void a(int i2, String str) {
        this.f6007i = 5;
        com.tencent.bugly.beta.ui.c.a.a();
        s.a.f6562b.remove(getDownloadUrl());
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(10, this.f6002d, this, Integer.valueOf(i2), str));
    }

    protected void a() {
        this.f6564k += System.currentTimeMillis() - this.f6566m;
        p.a.a(this);
        this.f6566m = System.currentTimeMillis();
        com.tencent.bugly.beta.ui.c.a.a();
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(9, this.f6002d, this));
    }
}
