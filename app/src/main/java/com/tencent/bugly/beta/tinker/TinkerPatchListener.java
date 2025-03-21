package com.tencent.bugly.beta.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerPatchListener extends DefaultPatchListener {
    protected static final long NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN = 62914560;
    private static final String TAG = "Tinker.TinkerPatchListener";
    private final int maxMemory;
    private final PatchListener userPatchListener;

    public TinkerPatchListener(Context context) {
        super(context);
        this.maxMemory = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        TinkerLog.i(TAG, "application maxMemory:" + this.maxMemory, new Object[0]);
        this.userPatchListener = TinkerManager.userPatchListener;
    }

    public int patchCheck(String str, String str2) {
        PatchListener patchListener = this.userPatchListener;
        if (patchListener != null) {
            patchListener.onPatchReceived(str);
            return super.patchCheck(str, str2);
        }
        File file = new File(str);
        TinkerLog.i(TAG, "receive a patch file: %s, file size:%d", new Object[]{str, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize(file))});
        int patchCheck = super.patchCheck(str, str2);
        if (patchCheck == 0) {
            patchCheck = TinkerUtils.checkForPatchRecover(NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN, this.maxMemory);
        }
        if (patchCheck == 0 && this.context.getSharedPreferences("tinker_share_config", 0).getInt(str2, 0) >= 3) {
            patchCheck = -23;
        }
        if (patchCheck == 0) {
            Properties fastGetPatchPackageMeta = ShareTinkerInternals.fastGetPatchPackageMeta(file);
            if (fastGetPatchPackageMeta == null) {
                patchCheck = -24;
            } else {
                TinkerLog.i(TAG, "get platform:" + fastGetPatchPackageMeta.getProperty("platform"), new Object[0]);
            }
        }
        TinkerReport.onTryApply(patchCheck == 0);
        return patchCheck;
    }
}
