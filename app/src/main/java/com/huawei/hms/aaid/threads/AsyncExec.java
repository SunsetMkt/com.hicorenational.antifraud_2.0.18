package com.huawei.hms.aaid.threads;

import com.huawei.hms.opendevice.RunnableC2477o;
import com.huawei.hms.opendevice.ThreadFactoryC2465c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class AsyncExec {

    /* renamed from: a */
    private static final ThreadPoolExecutor f7013a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC2465c("SeqIO"), new ThreadPoolExecutor.AbortPolicy());

    public static void submitSeqIO(Runnable runnable) {
        try {
            f7013a.execute(new RunnableC2477o(runnable));
        } catch (Exception e2) {
            String str = "submit seq io task failed, Exception:" + e2;
        }
    }
}
