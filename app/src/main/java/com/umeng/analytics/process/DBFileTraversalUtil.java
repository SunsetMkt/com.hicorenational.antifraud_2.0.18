package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class DBFileTraversalUtil {

    /* renamed from: a */
    private static ExecutorService f12283a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static FileLockUtil f12284b = new FileLockUtil();

    /* renamed from: com.umeng.analytics.process.DBFileTraversalUtil$a */
    public interface InterfaceC3427a {
        /* renamed from: a */
        void mo11443a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final InterfaceC3427a interfaceC3427a) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f12283a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        for (File file2 : file.listFiles()) {
                            if (file2.getName().endsWith(InterfaceC3431a.f12306d)) {
                                DBFileTraversalUtil.f12284b.doFileOperateion(file2, fileLockCallback);
                                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                            }
                        }
                        if (interfaceC3427a != null) {
                            interfaceC3427a.mo11443a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}
