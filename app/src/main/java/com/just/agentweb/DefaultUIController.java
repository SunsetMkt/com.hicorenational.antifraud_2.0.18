package com.just.agentweb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;

/* loaded from: classes.dex */
public class DefaultUIController extends AbsAgentWebUIController {
    private Activity mActivity;
    private AlertDialog mAlertDialog;
    protected AlertDialog mConfirmDialog;
    private ProgressDialog mProgressDialog;
    private WebParentLayout mWebParentLayout;
    private JsPromptResult mJsPromptResult = null;
    private JsResult mJsResult = null;
    private AlertDialog mPromptDialog = null;
    private AlertDialog mAskOpenOtherAppDialog = null;
    private Resources mResources = null;

    private void onForceDownloadAlertInternal(final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            new AlertDialog.Builder(activity).setTitle(this.mResources.getString(C2605R.string.agentweb_tips)).setMessage(this.mResources.getString(C2605R.string.agentweb_honeycomblow)).setNegativeButton(this.mResources.getString(C2605R.string.agentweb_download), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain());
                    }
                }
            }).setPositiveButton(this.mResources.getString(C2605R.string.agentweb_cancel), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }).create().show();
        }
    }

    private void onJsConfirmInternal(String str, JsResult jsResult) {
        LogUtils.m8083i(this.TAG, "activity:" + this.mActivity.hashCode() + "  ");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            toCancelJsresult(jsResult);
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            toCancelJsresult(jsResult);
            return;
        }
        if (this.mConfirmDialog == null) {
            this.mConfirmDialog = new AlertDialog.Builder(activity).setMessage(str).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                    DefaultUIController defaultUIController2 = DefaultUIController.this;
                    defaultUIController2.toCancelJsresult(defaultUIController2.mJsResult);
                }
            }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                    if (DefaultUIController.this.mJsResult != null) {
                        DefaultUIController.this.mJsResult.confirm();
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toCancelJsresult(defaultUIController.mJsResult);
                }
            }).create();
        }
        this.mConfirmDialog.setMessage(str);
        this.mJsResult = jsResult;
        this.mConfirmDialog.show();
    }

    private void onJsPromptInternal(String str, String str2, JsPromptResult jsPromptResult) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            jsPromptResult.cancel();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            jsPromptResult.cancel();
            return;
        }
        if (this.mPromptDialog == null) {
            final EditText editText = new EditText(activity);
            editText.setText(str2);
            this.mPromptDialog = new AlertDialog.Builder(activity).setView(editText).setTitle(str).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                    DefaultUIController defaultUIController2 = DefaultUIController.this;
                    defaultUIController2.toCancelJsresult(defaultUIController2.mJsPromptResult);
                }
            }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                    if (DefaultUIController.this.mJsPromptResult != null) {
                        DefaultUIController.this.mJsPromptResult.confirm(editText.getText().toString());
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.10
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toCancelJsresult(defaultUIController.mJsPromptResult);
                }
            }).create();
        }
        this.mJsPromptResult = jsPromptResult;
        this.mPromptDialog.show();
    }

    private void showChooserInternal(String[] strArr, final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            this.mAlertDialog = new AlertDialog.Builder(activity).setSingleChoiceItems(strArr, -1, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    LogUtils.m8083i(DefaultUIController.this.TAG, "which:" + i2);
                    if (callback != null) {
                        Message obtain = Message.obtain();
                        obtain.what = i2;
                        callback.handleMessage(obtain);
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain((Handler) null, -1));
                    }
                }
            }).create();
            this.mAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCancelJsresult(JsResult jsResult) {
        if (jsResult != null) {
            jsResult.cancel();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    protected void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {
        this.mActivity = activity;
        this.mWebParentLayout = webParentLayout;
        this.mResources = this.mActivity.getResources();
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onCancelLoading() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = null;
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onForceDownloadAlert(String str, Handler.Callback callback) {
        onForceDownloadAlertInternal(callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsAlert(WebView webView, String str, String str2) {
        AgentWebUtils.toastShowShort(webView.getContext().getApplicationContext(), str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        onJsConfirmInternal(str2, jsResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        onJsPromptInternal(str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onLoading(String str) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(activity);
            }
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(str);
            this.mProgressDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onMainFrameError(WebView webView, int i2, String str, String str2) {
        LogUtils.m8083i(this.TAG, "mWebParentLayout onMainFrameError:" + this.mWebParentLayout);
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.showPageMainFrameError();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onOpenPagePrompt(WebView webView, String str, final Handler.Callback callback) {
        LogUtils.m8083i(this.TAG, "onOpenPagePrompt");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mAskOpenOtherAppDialog == null) {
                this.mAskOpenOtherAppDialog = new AlertDialog.Builder(activity).setMessage(this.mResources.getString(C2605R.string.agentweb_leave_app_and_go_other_page, AgentWebUtils.getApplicationName(activity))).setTitle(this.mResources.getString(C2605R.string.agentweb_tips)).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, -1));
                        }
                    }
                }).setPositiveButton(this.mResources.getString(C2605R.string.agentweb_leave), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, 1));
                        }
                    }
                }).create();
            }
            this.mAskOpenOtherAppDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionsDeny(String[] strArr, String str, String str2) {
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        showChooserInternal(strArr, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMainFrame() {
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.hideErrorLayout();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMessage(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
            AgentWebUtils.toastShowShort(this.mActivity.getApplicationContext(), str);
        }
    }
}
