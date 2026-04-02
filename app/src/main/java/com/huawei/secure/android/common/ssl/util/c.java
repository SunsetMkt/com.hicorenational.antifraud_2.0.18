package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f5217b = 432000000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5218c = "lastCheckTime";
    private static final String a = c.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f5219d = false;

    @SuppressLint({"NewApi"})
    public static void a() {
        if (b()) {
            e.c(a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (f5219d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            e.e(a, "checkUpgradeBks, context is null");
            return false;
        }
        f5219d = true;
        long jA = g.a(f5218c, 0L, contextUtil);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA > f5217b) {
            g.b(f5218c, jCurrentTimeMillis, contextUtil);
            return true;
        }
        e.c(a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        e.a(a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e2) {
            e.b(a, "doInBackground: exception : " + e2.getMessage());
            bksFromTss = null;
        }
        e.a(a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        if (bksFromTss != null) {
            d.a(bksFromTss);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(a, "onPostExecute: upate done");
        } else {
            e.b(a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        e.c(a, "onProgressUpdate");
    }
}
