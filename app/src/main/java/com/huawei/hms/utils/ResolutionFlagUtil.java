package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class ResolutionFlagUtil {

    /* renamed from: a */
    private static volatile ResolutionFlagUtil f7982a;

    /* renamed from: b */
    private static final Map<String, Long> f7983b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final Object f7984c = new Object();

    private ResolutionFlagUtil() {
    }

    /* renamed from: a */
    private void m7809a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : f7983b.keySet()) {
            Map<String, Long> map = f7983b;
            Long l2 = map.get(str);
            if (l2 == null || l2.longValue() == 0) {
                map.remove(str);
                HMSLog.m7717i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l2.longValue()) {
                map.remove(str);
                HMSLog.m7717i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f7982a != null) {
            return f7982a;
        }
        synchronized (f7984c) {
            if (f7982a == null) {
                f7982a = new ResolutionFlagUtil();
            }
        }
        return f7982a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.m7715e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = f7983b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0L;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.m7715e("ResolutionFlagUtil", "transactionId is null");
        } else {
            f7983b.remove(str);
            HMSLog.m7717i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j2) {
        if (!TextUtils.isEmpty(str) && j2 != 0) {
            m7810a(str, j2);
            return;
        }
        HMSLog.m7715e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j2);
    }

    /* renamed from: a */
    private void m7810a(String str, long j2) {
        Map<String, Long> map = f7983b;
        synchronized (map) {
            m7809a();
            map.put(str, Long.valueOf(j2));
            HMSLog.m7717i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
