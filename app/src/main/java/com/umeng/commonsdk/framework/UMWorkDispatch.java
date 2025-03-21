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

/* loaded from: classes2.dex */
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
    private static C3469a mSender;
    private static Object mSenderInitLock = new Object();
    private static Handler mTaskHandler;

    /* renamed from: com.umeng.commonsdk.framework.UMWorkDispatch$1 */
    static class HandlerC34681 extends Handler {
        HandlerC34681(Looper looper) {
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
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = MSG_QUIT;
            mTaskHandler.sendMessage(obtainMessage);
        }
    }

    public static void delayProcess() {
        JSONObject buildEnvelopeWithExtHeader;
        ULog.m11768d("--->>> delayProcess Enter...");
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long maxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        JSONObject jSONObject = null;
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(maxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
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
        if (appContext == null || jSONObject2 == null || jSONObject3 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(buildEnvelopeWithExtHeader);
    }

    public static synchronized boolean eventHasExist(int i2) {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return false;
            }
            return mTaskHandler.hasMessages(i2);
        }
    }

    public static void handleEvent(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i2));
        if (callbackFromModuleName != null) {
            ULog.m11768d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i2) + "]");
            callbackFromModuleName.workEvent(obj, i2);
        }
    }

    public static void handleQuit() {
        if (mSender == null || mNetTask == null) {
            return;
        }
        C3469a.m11576c();
        ULog.m11768d("--->>> handleQuit: Quit dispatch thread.");
        mNetTask.quit();
        teardown();
    }

    private static synchronized void init() {
        synchronized (UMWorkDispatch.class) {
            ULog.m11768d("--->>> Dispatch: init Enter...");
            try {
                if (mNetTask == null) {
                    mNetTask = new HandlerThread("work_thread");
                    mNetTask.start();
                    if (mTaskHandler == null) {
                        mTaskHandler = new Handler(mNetTask.getLooper()) { // from class: com.umeng.commonsdk.framework.UMWorkDispatch.1
                            HandlerC34681(Looper looper) {
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
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
            ULog.m11768d("--->>> Dispatch: init Exit...");
        }
    }

    public static void registerConnStateObserver(UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            C3469a.m11570a(uMSenderStateNotify);
        }
    }

    public static synchronized void removeEvent() {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return;
            }
            mTaskHandler.removeMessages(MSG_CHECKER_TIMER);
        }
    }

    public static void sendDelayProcessMsg(long j2) {
        Handler handler = mTaskHandler;
        if (handler != null) {
            if (handler.hasMessages(MSG_DELAY_PROCESS)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message obtainMessage = mTaskHandler.obtainMessage();
            obtainMessage.what = MSG_DELAY_PROCESS;
            mTaskHandler.sendMessageDelayed(obtainMessage, j2);
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
            ULog.m11768d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
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
                                mSender = new C3469a(context, mTaskHandler);
                            }
                        }
                    }
                    Message obtainMessage = mTaskHandler.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.arg1 = i3;
                    obtainMessage.obj = obj;
                    mTaskHandler.sendMessageDelayed(obtainMessage, j2);
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
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return false;
            }
            return mTaskHandler.hasMessages(MSG_CHECKER_TIMER);
        }
    }

    public static synchronized void removeEvent(int i2) {
        synchronized (UMWorkDispatch.class) {
            if (mTaskHandler == null) {
                return;
            }
            mTaskHandler.removeMessages(i2);
        }
    }
}
