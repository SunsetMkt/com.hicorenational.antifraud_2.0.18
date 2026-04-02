package com.tencent.bugly.crashreport;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    boolean appendLogToNative(String str, String str2, String str3);

    String getLogFromNative();

    boolean setNativeIsAppForeground(boolean z);
}
