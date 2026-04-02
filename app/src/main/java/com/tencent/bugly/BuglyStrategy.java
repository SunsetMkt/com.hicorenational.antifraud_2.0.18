package com.tencent.bugly;

import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BuglyStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5983h;
    private a q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5984i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5985j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5986k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Class<?> f5987l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f5988m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f5989n = true;
    private boolean o = true;
    private boolean p = false;
    protected int a = 31;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f5977b = false;

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        return this.f5979d == null ? com.tencent.bugly.crashreport.common.info.a.b().s : this.f5979d;
    }

    public synchronized String getAppPackageName() {
        return this.f5980e == null ? com.tencent.bugly.crashreport.common.info.a.b().f6175d : this.f5980e;
    }

    public synchronized long getAppReportDelay() {
        return this.f5981f;
    }

    public synchronized String getAppVersion() {
        return this.f5978c == null ? com.tencent.bugly.crashreport.common.info.a.b().p : this.f5978c;
    }

    public synchronized int getCallBackType() {
        return this.a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f5977b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.q;
    }

    public synchronized String getDeviceID() {
        return this.f5983h;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f5982g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f5987l;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f5988m;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f5985j;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f5984i;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f5986k;
    }

    public boolean isReplaceOldChannel() {
        return this.f5989n;
    }

    public synchronized boolean isUploadProcess() {
        return this.o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.p;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f5979d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f5980e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f5981f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f5978c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f5988m = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f5977b = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.q = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f5983h = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f5985j = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f5984i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f5986k = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f5982g = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.p = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f5989n = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.o = z;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f5987l = cls;
        return this;
    }
}
