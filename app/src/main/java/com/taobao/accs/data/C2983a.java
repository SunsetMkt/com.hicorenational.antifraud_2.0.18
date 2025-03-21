package com.taobao.accs.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.p199ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.C3393cw;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.C6011a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.a */
/* loaded from: classes2.dex */
public class C2983a {
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;

    /* renamed from: a */
    private static final char[] f9457a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private String f9458b;

    /* renamed from: c */
    private int f9459c;

    /* renamed from: d */
    private String f9460d;

    /* renamed from: e */
    private long f9461e;

    /* renamed from: g */
    private ScheduledFuture<?> f9463g;

    /* renamed from: f */
    private volatile int f9462f = 0;

    /* renamed from: h */
    private Map<Integer, byte[]> f9464h = new TreeMap(new C2984b(this));

    public C2983a(String str, int i2, String str2) {
        this.f9458b = str;
        this.f9459c = i2;
        this.f9460d = str2;
    }

    /* renamed from: a */
    public void m9003a(long j2) {
        if (j2 <= 0) {
            j2 = 30000;
        }
        this.f9463g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new RunnableC2985c(this), j2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public byte[] m9004a(int i2, int i3, byte[] bArr) {
        long j2;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d("AssembleMessage", "putBurst", Constants.KEY_DATA_ID, this.f9458b, "index", Integer.valueOf(i2));
        }
        if (i3 != this.f9459c) {
            ALog.m9182e("AssembleMessage", "putBurst fail as burstNums not match", new Object[0]);
            return null;
        }
        if (i2 >= 0 && i2 < i3) {
            synchronized (this) {
                if (this.f9462f != 0) {
                    ALog.m9182e("AssembleMessage", "putBurst fail", NotificationCompat.CATEGORY_STATUS, Integer.valueOf(this.f9462f));
                } else {
                    if (this.f9464h.get(Integer.valueOf(i2)) != null) {
                        ALog.m9182e("AssembleMessage", "putBurst fail as exist old", new Object[0]);
                        return null;
                    }
                    if (this.f9464h.isEmpty()) {
                        this.f9461e = System.currentTimeMillis();
                    }
                    this.f9464h.put(Integer.valueOf(i2), bArr);
                    if (this.f9464h.size() == this.f9459c) {
                        byte[] bArr2 = null;
                        for (byte[] bArr3 : this.f9464h.values()) {
                            if (bArr2 == null) {
                                bArr2 = bArr3;
                            } else {
                                byte[] bArr4 = new byte[bArr2.length + bArr3.length];
                                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                                System.arraycopy(bArr3, 0, bArr4, bArr2.length, bArr3.length);
                                bArr2 = bArr4;
                            }
                        }
                        if (!TextUtils.isEmpty(this.f9460d)) {
                            String str = new String(m9000a(C6011a.m24950a(bArr2)));
                            if (!this.f9460d.equals(str)) {
                                ALog.m9186w("AssembleMessage", "putBurst fail", Constants.KEY_DATA_ID, this.f9458b, "dataMd5", this.f9460d, "finalDataMd5", str);
                                this.f9462f = 3;
                                bArr2 = null;
                            }
                        }
                        long j3 = 0;
                        if (bArr2 != null) {
                            j3 = bArr2.length;
                            j2 = System.currentTimeMillis() - this.f9461e;
                            this.f9462f = 2;
                            ALog.m9183i("AssembleMessage", "putBurst completed", Constants.KEY_DATA_ID, this.f9458b, "length", Long.valueOf(j3), "cost", Long.valueOf(j2));
                        } else {
                            j2 = 0;
                        }
                        AssembleMonitor assembleMonitor = new AssembleMonitor(this.f9458b, String.valueOf(this.f9462f));
                        assembleMonitor.assembleLength = j3;
                        assembleMonitor.assembleTimes = j2;
                        AppMonitor.getInstance().commitStat(assembleMonitor);
                        this.f9464h.clear();
                        if (this.f9463g != null) {
                            this.f9463g.cancel(false);
                        }
                        return bArr2;
                    }
                }
                return null;
            }
        }
        ALog.m9182e("AssembleMessage", "putBurst fail as burstIndex invalid", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private static char[] m9000a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = f9457a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & C3393cw.f11873m];
        }
        return cArr;
    }
}
