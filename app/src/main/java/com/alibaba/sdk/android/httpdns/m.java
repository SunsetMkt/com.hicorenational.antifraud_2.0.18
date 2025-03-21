package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class m implements Callable<String[]> {

    /* renamed from: a, reason: collision with root package name */
    private static m f4062a;

    /* renamed from: d, reason: collision with root package name */
    private int f4063d;

    /* renamed from: d, reason: collision with other field name */
    private long f23d = 0;

    public static m a() {
        if (f4062a == null) {
            f4062a = new m();
        }
        return f4062a;
    }

    public void a(int i2) {
        this.f4063d = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c A[Catch: all -> 0x014f, TRY_LEAVE, TryCatch #7 {all -> 0x014f, blocks: (B:19:0x0051, B:20:0x0056, B:22:0x005c, B:24:0x0060, B:25:0x009e, B:52:0x010e, B:54:0x011c, B:56:0x0122, B:59:0x0135, B:29:0x00af, B:30:0x00b4, B:32:0x00ba, B:34:0x00be), top: B:5:0x0008, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013a A[Catch: all -> 0x0167, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:61:0x013a, B:69:0x013f, B:64:0x0147, B:46:0x014b, B:44:0x00ff, B:75:0x0152, B:85:0x0157, B:78:0x015f, B:83:0x0166, B:82:0x0163, B:37:0x00ee, B:50:0x00f3, B:40:0x00fb), top: B:2:0x0001, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0147 A[Catch: IOException -> 0x0143, all -> 0x0167, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:61:0x013a, B:69:0x013f, B:64:0x0147, B:46:0x014b, B:44:0x00ff, B:75:0x0152, B:85:0x0157, B:78:0x015f, B:83:0x0166, B:82:0x0163, B:37:0x00ee, B:50:0x00f3, B:40:0x00fb), top: B:2:0x0001, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0152 A[Catch: all -> 0x0167, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:61:0x013a, B:69:0x013f, B:64:0x0147, B:46:0x014b, B:44:0x00ff, B:75:0x0152, B:85:0x0157, B:78:0x015f, B:83:0x0166, B:82:0x0163, B:37:0x00ee, B:50:0x00f3, B:40:0x00fb), top: B:2:0x0001, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f A[Catch: IOException -> 0x015b, all -> 0x0167, TRY_LEAVE, TryCatch #12 {IOException -> 0x015b, blocks: (B:85:0x0157, B:78:0x015f), top: B:84:0x0157, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedReader] */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String[] call() {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.m.call():java.lang.String[]");
    }
}
