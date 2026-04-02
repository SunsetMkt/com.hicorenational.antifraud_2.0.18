package com.umeng.socialize.net.dplus.cache1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IReader<T> {
    private String a;
    public T result;

    public IReader(String str) {
        this.a = str;
    }

    public static double formatSize(long j2) {
        return (j2 / 1024.0d) / 1024.0d;
    }

    public abstract void create(String str);

    public String getLogFileName() {
        return this.a;
    }
}
