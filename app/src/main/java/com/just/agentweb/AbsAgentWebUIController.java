package com.just.agentweb;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;

/* loaded from: classes.dex */
public abstract class AbsAgentWebUIController {
    public static boolean HAS_DESIGN_LIB = false;
    private Activity mActivity;
    protected AbsAgentWebUIController mAgentWebUIControllerDelegate;
    private WebParentLayout mWebParentLayout;
    private volatile boolean mIsBindWebParent = false;
    protected String TAG = getClass().getSimpleName();

    static {
        try {
            Class.forName("com.google.android.material.snackbar.Snackbar");
            Class.forName("com.google.android.material.bottomsheet.BottomSheetDialog");
            HAS_DESIGN_LIB = true;
        } catch (Throwable unused) {
            HAS_DESIGN_LIB = false;
        }
    }

    protected abstract void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity);

    final synchronized void bindWebParent(WebParentLayout webParentLayout, Activity activity) {
        if (!this.mIsBindWebParent) {
            this.mIsBindWebParent = true;
            this.mWebParentLayout = webParentLayout;
            this.mActivity = activity;
            bindSupportWebParent(webParentLayout, activity);
        }
    }

    protected AbsAgentWebUIController create() {
        return HAS_DESIGN_LIB ? new DefaultDesignUIController() : new DefaultUIController();
    }

    protected AbsAgentWebUIController getDelegate() {
        AbsAgentWebUIController absAgentWebUIController = this.mAgentWebUIControllerDelegate;
        if (absAgentWebUIController != null) {
            return absAgentWebUIController;
        }
        AbsAgentWebUIController create = create();
        this.mAgentWebUIControllerDelegate = create;
        return create;
    }

    public abstract void onCancelLoading();

    public abstract void onForceDownloadAlert(String str, Handler.Callback callback);

    public abstract void onJsAlert(WebView webView, String str, String str2);

    public abstract void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult);

    public abstract void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

    public abstract void onLoading(String str);

    public abstract void onMainFrameError(WebView webView, int i2, String str, String str2);

    public abstract void onOpenPagePrompt(WebView webView, String str, Handler.Callback callback);

    public abstract void onPermissionsDeny(String[] strArr, String str, String str2);

    public abstract void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback);

    public abstract void onShowMainFrame();

    public abstract void onShowMessage(String str, String str2);

    protected void toDismissDialog(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }

    protected void toShowDialog(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }
}
