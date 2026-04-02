package util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import bean.APIH5Bean;
import com.hicorenational.antifraud.R;
import interfaces.IBaseBeanCall;
import java.lang.reflect.Type;
import manager.BaseDialog;
import manager.UpdateManager;
import network.APIException;
import network.DownloadInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.UpdateAppView;
import ui.presenter.UpdateAppPresenter;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateUtil implements UpdateAppView {
    private static IBaseBeanCall baseBeanCall = null;
    public static boolean isCheckUpdateAlready = false;
    private static Activity mActivity;
    private static UpdateAppPresenter mPresenter;
    private static UpdateUtil updateUt;
    private static BaseDialog uppVerDlg;

    class a extends UpdateManager.DownLoadBack {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onCompleted(String str) {
            super.onCompleted(str);
            this.a.setText("\u7acb\u5373\u5b89\u88c5");
            this.a.setEnabled(true);
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onDownLoading(int i2) {
            super.onDownLoading(i2);
            if (UpdateUtil.uppVerDlg == null || i2 <= 0 || i2 > 100) {
                return;
            }
            this.a.setText("\u4e0b\u8f7d\u4e2d... " + i2 + "%");
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onError() {
            super.onError();
            e2.a("\u8bf7\u91cd\u65b0\u4e0b\u8f7d");
            this.a.setText("\u7acb\u5373\u66f4\u65b0");
            this.a.setEnabled(true);
            UpdateManager.getInstance().stopThread(true);
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onFinaly() {
            if (UpdateUtil.uppVerDlg == null || !UpdateUtil.uppVerDlg.isShowing()) {
                return;
            }
            UpdateUtil.uppVerDlg.dismiss();
        }
    }

    class b extends MiddleSubscriber<APIresult<APIH5Bean>> {
        final /* synthetic */ DownloadInfo a;

        b(DownloadInfo downloadInfo) {
            this.a = downloadInfo;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            onErrorMiddle(APIException.getApiExcept("\u83b7\u53d6\u66f4\u65b0\u5730\u5740\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~"));
            s1.a("hsc", "h5Url  onErrorMiddle===");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<APIH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                UpdateUtil.this.showDialogUpdate(this.a, null);
                return;
            }
            String value = aPIresult.getData().getValue();
            s1.a("hsc", "h5Url===" + value);
            if (TextUtils.isEmpty(value)) {
                UpdateUtil.this.showDialogUpdate(this.a, null);
            } else {
                UpdateUtil.this.showDialogUpdate(this.a, value);
            }
        }
    }

    private UpdateUtil() {
        mPresenter = new UpdateAppPresenter(mActivity, this);
    }

    public void doUpdateApp(TextView textView, DownloadInfo downloadInfo, String str) {
        if (!w1.f()) {
            e2.a("\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            e2.a("\u66f4\u65b0\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5");
            return;
        }
        textView.setText("\u4e0b\u8f7d\u4e2d... 0%");
        textView.setEnabled(false);
        UpdateManager.getInstance().downloadApp(false, str, "{\"filePath\":\"" + downloadInfo.getUrl() + "\"}", new a(textView));
    }

    private void requestAppDownlaod(DownloadInfo downloadInfo) {
        mPresenter.requestAppDownload(new b(downloadInfo));
    }

    public void showDialogUpdate(final DownloadInfo downloadInfo, final String str) {
        Activity activity;
        if (downloadInfo == null || (activity = mActivity) == null || activity.isFinishing()) {
            return;
        }
        BaseDialog baseDialog = uppVerDlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            uppVerDlg = new BaseDialog(mActivity, R.style.base_dialog_style);
            uppVerDlg.setContentView(R.layout.dialog_update);
            uppVerDlg.setGravityLayout(2);
            uppVerDlg.setWidthDialog(-2.0d);
            uppVerDlg.setHeightDialog(-2.0d);
            uppVerDlg.setCancelable(false);
            uppVerDlg.setCanceledOnTouchOutside(false);
            uppVerDlg.initOnCreate();
            uppVerDlg.show();
            TextView textView = (TextView) uppVerDlg.findViewById(R.id.update_title);
            TextView textView2 = (TextView) uppVerDlg.findViewById(R.id.update_content);
            final TextView textView3 = (TextView) uppVerDlg.findViewById(R.id.update);
            ImageView imageView = (ImageView) uppVerDlg.findViewById(R.id.update_close);
            if (downloadInfo.isIsForcedVersion()) {
                imageView.setVisibility(4);
                c2.b("update_home", "");
            } else {
                imageView.setVisibility(0);
            }
            String version = downloadInfo.getVersion();
            String content = downloadInfo.getContent();
            if (TextUtils.isEmpty(version)) {
                version = "";
            }
            String strReplace = TextUtils.isEmpty(content) ? "" : content.replace("\\n", "\n").replace(d.c.a.b.a.a.f10074g, "");
            textView.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + version);
            textView2.setText(strReplace);
            if (UpdateManager.getInstance().existsApk()) {
                textView3.setText("\u7acb\u5373\u5b89\u88c5");
            }
            textView3.setOnClickListener(new View.OnClickListener() { // from class: util.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(str, textView3, downloadInfo, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: util.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpdateUtil.a(view);
                }
            });
        }
    }

    public static UpdateUtil updateAppOnly(Activity activity, IBaseBeanCall iBaseBeanCall) {
        mActivity = activity;
        baseBeanCall = iBaseBeanCall;
        if (updateUt == null) {
            updateUt = new UpdateUtil();
        }
        mPresenter.principalHttp(baseBeanCall);
        return updateUt;
    }

    private void updateShowMes(boolean z, IBaseBeanCall iBaseBeanCall, APIresult<DownloadInfo> aPIresult) {
        if (iBaseBeanCall != null) {
            if (z) {
                iBaseBeanCall.onsuccess(aPIresult);
            } else {
                iBaseBeanCall.onfail();
            }
        }
    }

    public /* synthetic */ void a(String str, TextView textView, DownloadInfo downloadInfo, View view) {
        if (UpdateManager.getInstance().existsApk()) {
            UpdateManager.getInstance().onReinstall();
        } else {
            util.permissionutil.c.a(mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new f2(this, str, textView, downloadInfo));
        }
    }

    @Override // ui.callview.UpdateAppView
    public void onSuccRequest(APIresult<DownloadInfo> aPIresult, IBaseBeanCall iBaseBeanCall) {
        if (aPIresult != null) {
            if (aPIresult.getCode() != 0) {
                updateShowMes(false, iBaseBeanCall, aPIresult);
                s1.a("updateApp onNext-->", aPIresult.getMsg());
                return;
            }
            DownloadInfo data = aPIresult.getData();
            try {
                if (data.getInnerVersion() > x1.f()) {
                    c2.b(c2.p, data.getFileMD5());
                    requestAppDownlaod(data);
                    updateShowMes(true, iBaseBeanCall, aPIresult);
                } else {
                    UpdateManager.getInstance().deleteApk();
                    updateShowMes(false, iBaseBeanCall, aPIresult);
                }
            } catch (Exception e2) {
                updateShowMes(false, iBaseBeanCall, aPIresult);
                s1.b("updateApp onNext catch>", e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(View view) {
        c2.b("update_home", g2.d("yyyy-MM-dd"));
        IBaseBeanCall iBaseBeanCall = baseBeanCall;
        if (iBaseBeanCall != null) {
            iBaseBeanCall.onClose();
        }
        UpdateManager.getInstance().stopThread(true);
        BaseDialog baseDialog = uppVerDlg;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
    }
}
