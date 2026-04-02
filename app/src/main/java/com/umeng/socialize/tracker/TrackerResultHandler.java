package com.umeng.socialize.tracker;

/* JADX INFO: loaded from: classes2.dex */
public interface TrackerResultHandler {
    void codeGenerateFailed(Throwable th);

    void codeGenerateSuccess(String str);
}
