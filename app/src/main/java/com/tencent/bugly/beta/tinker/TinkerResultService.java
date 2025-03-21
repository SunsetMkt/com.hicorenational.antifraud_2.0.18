package com.tencent.bugly.beta.tinker;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerResultService extends DefaultTinkerResultService {
    private static final String TAG = "Tinker.TinkerResultService";

    /* JADX INFO: Access modifiers changed from: private */
    public void restartProcess() {
        TinkerLog.i(TAG, "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
    }

    public void onPatchResult(final PatchResult patchResult) {
        TinkerManager.TinkerPatchResultListener tinkerPatchResultListener = TinkerManager.patchResultListener;
        if (tinkerPatchResultListener != null) {
            tinkerPatchResultListener.onPatchResult(patchResult);
        }
        if (patchResult == null) {
            TinkerLog.e(TAG, "TinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        TinkerLog.i(TAG, "TinkerResultService receive result: %s", new Object[]{patchResult.toString()});
        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.beta.tinker.TinkerResultService.1
            @Override // java.lang.Runnable
            public void run() {
                if (patchResult.isSuccess) {
                    TinkerManager.getInstance().onApplySuccess(patchResult.toString());
                } else {
                    TinkerManager.getInstance().onApplyFailure(patchResult.toString());
                }
            }
        });
        if (patchResult.isSuccess) {
            deleteRawPatchFile(new File(patchResult.rawPatchFilePath));
            if (!checkIfNeedKill(patchResult)) {
                TinkerLog.i(TAG, "I have already install the newly patch version!", new Object[0]);
                return;
            }
            if (TinkerManager.isPatchRestartOnScreenOff()) {
                if (TinkerUtils.isBackground()) {
                    TinkerLog.i(TAG, "it is in background, just restart process", new Object[0]);
                    restartProcess();
                } else {
                    TinkerLog.i(TAG, "tinker wait screen to restart process", new Object[0]);
                    new TinkerUtils.ScreenState(getApplicationContext(), new TinkerUtils.ScreenState.IOnScreenOff() { // from class: com.tencent.bugly.beta.tinker.TinkerResultService.2
                        @Override // com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState.IOnScreenOff
                        public void onScreenOff() {
                            TinkerResultService.this.restartProcess();
                        }
                    });
                }
            }
        }
    }
}
