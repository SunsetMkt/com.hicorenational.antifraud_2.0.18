package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.p205ui.C3092c;
import com.tencent.bugly.beta.utils.C3105e;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.C7316r1;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.t */
/* loaded from: classes2.dex */
public class RunnableC3195t extends DownloadTask implements Runnable {

    /* renamed from: k */
    public long f10792k;

    /* renamed from: l */
    private File f10793l;

    /* renamed from: m */
    private long f10794m;

    public RunnableC3195t(String str, String str2, long j2, long j3, String str3) {
        super(str, "", "", str3);
        this.f10792k = 0L;
        this.f10794m = 0L;
        this.f10793l = new File(str2);
        this.f9843b = this.f10793l.getParent();
        this.f9844c = this.f10793l.getName();
        this.f9846e = j2;
        this.f9847f = j3;
        getStatus();
    }

    /* renamed from: a */
    private String m10144a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f9844c)) {
            return this.f9844c;
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
        String substring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
        if (!TextUtils.isEmpty(substring)) {
            return substring;
        }
        return UUID.randomUUID() + C7316r1.f25586d;
    }

    /* renamed from: b */
    protected void m10147b() {
        this.f9850i = 1;
        m10145a();
        C3194s.f10788a.f10789b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        C3105e.m9461a(new RunnableC3081d(8, this.f9845d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            C3191p.f10775a.m10133b(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f9844c = null;
        this.f9846e = 0L;
        this.f9847f = 0L;
        this.f9850i = 4;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void download() {
        if (getStatus() == 1) {
            m10147b();
            return;
        }
        if (getStatus() == 2) {
            return;
        }
        if (getSaveFile() == null || !getSaveFile().exists()) {
            this.f9846e = 0L;
            this.f9847f = 0L;
            this.f10792k = 0L;
        } else {
            this.f9846e = getSaveFile().length();
        }
        if (this.f9848g) {
            C3092c.f9950a.m9357a(this);
        }
        this.f10794m = System.currentTimeMillis();
        this.f9850i = 2;
        C3194s.f10788a.f10789b.put(getDownloadUrl(), this);
        C3194s.f10788a.m10143a(this);
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.f10792k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.f10793l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f9847f && !C3194s.f10788a.f10789b.contains(this)) {
            this.f9846e = this.f9847f;
            this.f9850i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f9847f && !C3194s.f10788a.f10789b.contains(this)) {
            this.f9846e = getSaveFile().length();
            this.f9850i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !C3194s.f10788a.f10789b.contains(this)) {
            this.f9850i = 0;
        }
        return this.f9850i;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0163 A[Catch: all -> 0x017a, Exception -> 0x017d, TryCatch #4 {Exception -> 0x017d, blocks: (B:19:0x0099, B:63:0x00e4, B:48:0x0124, B:75:0x0136, B:115:0x0163, B:116:0x0166, B:89:0x015b, B:78:0x0169), top: B:88:0x015b, outer: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC3195t.run():void");
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f9850i != 5) {
            this.f9850i = 3;
        }
    }

    public RunnableC3195t(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f10792k = 0L;
        this.f10794m = 0L;
        getStatus();
    }

    /* renamed from: a */
    protected void m10146a(int i2, String str) {
        this.f9850i = 5;
        C3092c.f9950a.m9356a();
        C3194s.f10788a.f10789b.remove(getDownloadUrl());
        C3105e.m9461a(new RunnableC3081d(10, this.f9845d, this, Integer.valueOf(i2), str));
    }

    /* renamed from: a */
    protected void m10145a() {
        this.f10792k += System.currentTimeMillis() - this.f10794m;
        C3191p.f10775a.m10130a(this);
        this.f10794m = System.currentTimeMillis();
        C3092c.f9950a.m9356a();
        C3105e.m9461a(new RunnableC3081d(9, this.f9845d, this));
    }
}
