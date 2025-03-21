package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.C3113a;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyStrategy {

    /* renamed from: c */
    private String f9811c;

    /* renamed from: d */
    private String f9812d;

    /* renamed from: e */
    private String f9813e;

    /* renamed from: f */
    private long f9814f;

    /* renamed from: g */
    private String f9815g;

    /* renamed from: h */
    private String f9816h;

    /* renamed from: q */
    private C3070a f9825q;

    /* renamed from: i */
    private boolean f9817i = true;

    /* renamed from: j */
    private boolean f9818j = true;

    /* renamed from: k */
    private boolean f9819k = true;

    /* renamed from: l */
    private Class<?> f9820l = null;

    /* renamed from: m */
    private boolean f9821m = true;

    /* renamed from: n */
    private boolean f9822n = true;

    /* renamed from: o */
    private boolean f9823o = true;

    /* renamed from: p */
    private boolean f9824p = false;

    /* renamed from: a */
    protected int f9809a = 31;

    /* renamed from: b */
    protected boolean f9810b = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.BuglyStrategy$a */
    public static class C3070a {
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
        return this.f9812d == null ? C3113a.m9532b().f10211s : this.f9812d;
    }

    public synchronized String getAppPackageName() {
        return this.f9813e == null ? C3113a.m9532b().f10196d : this.f9813e;
    }

    public synchronized long getAppReportDelay() {
        return this.f9814f;
    }

    public synchronized String getAppVersion() {
        return this.f9811c == null ? C3113a.m9532b().f10208p : this.f9811c;
    }

    public synchronized int getCallBackType() {
        return this.f9809a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f9810b;
    }

    public synchronized C3070a getCrashHandleCallback() {
        return this.f9825q;
    }

    public synchronized String getDeviceID() {
        return this.f9816h;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f9815g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f9820l;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f9821m;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f9818j;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f9817i;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f9819k;
    }

    public boolean isReplaceOldChannel() {
        return this.f9822n;
    }

    public synchronized boolean isUploadProcess() {
        return this.f9823o;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f9824p;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f9812d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f9813e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f9814f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f9811c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f9821m = z;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.f9809a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f9810b = z;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C3070a c3070a) {
        this.f9825q = c3070a;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f9816h = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f9818j = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f9817i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f9819k = z;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f9815g = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.f9824p = z;
        return this;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f9822n = z;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.f9823o = z;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f9820l = cls;
        return this;
    }
}
