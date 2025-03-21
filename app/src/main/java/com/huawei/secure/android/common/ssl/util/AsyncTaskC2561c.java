package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* renamed from: com.huawei.secure.android.common.ssl.util.c */
/* loaded from: classes.dex */
public class AsyncTaskC2561c extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: b */
    private static final long f8241b = 432000000;

    /* renamed from: c */
    private static final String f8242c = "lastCheckTime";

    /* renamed from: a */
    private static final String f8240a = AsyncTaskC2561c.class.getSimpleName();

    /* renamed from: d */
    private static volatile boolean f8243d = false;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m7966a() {
        if (m7967b()) {
            C2563e.m7987c(f8240a, "checkUpgradeBks, execute check task");
            new AsyncTaskC2561c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    /* renamed from: b */
    private static boolean m7967b() {
        if (f8243d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            C2563e.m7989e(f8240a, "checkUpgradeBks, context is null");
            return false;
        }
        f8243d = true;
        long m7993a = C2565g.m7993a(f8242c, 0L, contextUtil);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m7993a > f8241b) {
            C2565g.m7999b(f8242c, currentTimeMillis, contextUtil);
            return true;
        }
        C2563e.m7987c(f8240a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C2563e.m7984a(f8240a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e2) {
            C2563e.m7986b(f8240a, "doInBackground: exception : " + e2.getMessage());
            inputStream = null;
        }
        C2563e.m7984a(f8240a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            AbstractC2562d.m7977a(inputStream);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            C2563e.m7987c(f8240a, "onPostExecute: upate done");
        } else {
            C2563e.m7986b(f8240a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        C2563e.m7987c(f8240a, "onProgressUpdate");
    }
}
