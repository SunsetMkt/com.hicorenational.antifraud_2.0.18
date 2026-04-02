package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UMWorkDispatch {
    public static final String GENERAL_CONTENT = "content";
    public static final String GENERAL_HEADER = "header";
    public static final String KEY_EXCEPTION = "exception";
    private static final int MSG_AUTO_PROCESS = 769;
    private static final int MSG_CHECKER_TIMER = 771;
    private static final int MSG_DELAY_PROCESS = 770;
    private static final int MSG_QUIT = 784;
    private static final int MSG_SEND_EVENT = 768;
    private static HandlerThread mNetTask;
    private static a mSender;
    private static Object mSenderInitLock = new Object();
    private static Handler mTaskHandler;

    /* JADX INFO: renamed from: com.umeng.commonsdk.framework.UMWorkDispatch$1 */
    static class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == UMWorkDispatch.MSG_QUIT) {
                UMWorkDispatch.handleQuit();
            }
            switch (i2) {
                case UMWorkDispatch.MSG_SEND_EVENT /* 768 */:
                    UMWorkDispatch.handleEvent(message);
                    break;
                case UMWorkDispatch.MSG_DELAY_PROCESS /* 770 */:
                    UMWorkDispatch.delayProcess();
                    break;
                case UMWorkDispatch.MSG_CHECKER_TIMER /* 771 */:
                    UMWorkDispatch.handleEvent(message);
                    break;
            }
        }
    }

    private UMWorkDispatch() {
    }

    public static void Quit() {
        Handler handler = mTaskHandler;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = MSG_QUIT;
            mTaskHandler.sendMessage(messageObtainMessage);
        }
    }

    public static void delayProcess() {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        ULog.d("--->>> delayProcess Enter...");
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long jMaxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        JSONObject jSONObject = null;
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(jMaxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
                return;
            }
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
        JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
        if (appContext == null || jSONObject2 == null || jSONObject3 == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(jSONObjectBuildEnvelopeWithExtHeader);
    }

    public static synchronized boolean eventHasExist(int i2) {
        if (mTaskHandler == null) {
            return false;
        }
        return mTaskHandler.hasMessages(i2);
    }

    public static void handleEvent(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i2));
        if (callbackFromModuleName != null) {
            ULog.d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i2) + "]");
            callbackFromModuleName.workEvent(obj, i2);
        }
    }

    public static void handleQuit() {
        if (mSender == null || mNetTask == null) {
            return;
        }
        a.c();
        ULog.d("--->>> handleQuit: Quit dispatch thread.");
        mNetTask.quit();
        teardown();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0034 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {, blocks: (B:27:0x0003, B:36:0x0034, B:35:0x002d, B:28:0x0008, B:30:0x000c, B:32:0x001e), top: B:42:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void init() {
        ULog.d("--->>> Dispatch: init Enter...");
        try {
        } catch (Throwable th) {
            UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
        }
        if (mNetTask == null) {
            mNetTask = new HandlerThread("work_thread");
            mNetTask.start();
            if (mTaskHandler == null) {
                mTaskHandler = new Handler(mNetTask.getLooper()) { // from class: com.umeng.commonsdk.framework.UMWorkDispatch.1
                    AnonymousClass1(Looper looper) {
                        super(looper);
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i2 = message.what;
                        if (i2 == UMWorkDispatch.MSG_QUIT) {
                            UMWorkDispatch.handleQuit();
                        }
                        switch (i2) {
                            case UMWorkDispatch.MSG_SEND_EVENT /* 768 */:
                                UMWorkDispatch.handleEvent(message);
                                break;
                            case UMWorkDispatch.MSG_DELAY_PROCESS /* 770 */:
                                UMWorkDispatch.delayProcess();
                                break;
                            case UMWorkDispatch.MSG_CHECKER_TIMER /* 771 */:
                                UMWorkDispatch.handleEvent(message);
                                break;
                        }
                    }
                };
                ULog.d("--->>> Dispatch: init Exit...");
            } else {
                ULog.d("--->>> Dispatch: init Exit...");
            }
        }
    }

    public static void registerConnStateObserver(UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            a.a(uMSenderStateNotify);
        }
    }

    public static synchronized void removeEvent() {
        if (mTaskHandler == null) {
            return;
        }
        mTaskHandler.removeMessages(MSG_CHECKER_TIMER);
    }

    public static void sendDelayProcessMsg(long j2) {
        Handler handler = mTaskHandler;
        if (handler != null) {
            if (handler.hasMessages(MSG_DELAY_PROCESS)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message messageObtainMessage = mTaskHandler.obtainMessage();
            messageObtainMessage.what = MSG_DELAY_PROCESS;
            mTaskHandler.sendMessageDelayed(messageObtainMessage, j2);
        }
    }

    public static void sendEvent(Context context, int i2, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        sendEventInternal(context, MSG_SEND_EVENT, i2, uMLogDataProtocol, obj, 0L);
    }

    public static void sendEventEx(Context context, int i2, UMLogDataProtocol uMLogDataProtocol, Object obj, long j2) {
        sendEventInternal(context, MSG_CHECKER_TIMER, i2, uMLogDataProtocol, obj, j2);
    }

    public static void sendEventInternal(Context context, int i2, int i3, UMLogDataProtocol uMLogDataProtocol, Object obj, long j2) {
        if (context == null || uMLogDataProtocol == null) {
            ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        UMModuleRegister.registerAppContext(context.getApplicationContext());
        if (UMModuleRegister.registerCallback(i3, uMLogDataProtocol)) {
            if (mNetTask == null || mTaskHandler == null) {
                init();
            }
            try {
                if (mTaskHandler != null) {
                    if (UMUtils.isMainProgress(context)) {
                        synchronized (mSenderInitLock) {
                            if (mSender == null) {
                                UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                                mSender = new a(context, mTaskHandler);
                            }
                        }
                    }
                    Message messageObtainMessage = mTaskHandler.obtainMessage();
                    messageObtainMessage.what = i2;
                    messageObtainMessage.arg1 = i3;
                    messageObtainMessage.obj = obj;
                    mTaskHandler.sendMessageDelayed(messageObtainMessage, j2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    private static void teardown() {
        if (mNetTask != null) {
            mNetTask = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler = null;
        }
        if (mSender != null) {
            mSender = null;
        }
    }

    public static void sendEvent(Context context, int i2, UMLogDataProtocol uMLogDataProtocol, Object obj, long j2) {
        sendEventInternal(context, MSG_SEND_EVENT, i2, uMLogDataProtocol, obj, j2);
    }

    public static synchronized boolean eventHasExist() {
        if (mTaskHandler == null) {
            return false;
        }
        return mTaskHandler.hasMessages(MSG_CHECKER_TIMER);
    }

    public static synchronized void removeEvent(int i2) {
        if (mTaskHandler == null) {
            return;
        }
        mTaskHandler.removeMessages(i2);
    }
}
