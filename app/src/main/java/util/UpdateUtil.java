package util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import bean.APIH5Bean;
import com.hicorenational.antifraud.C2113R;
import interfaces.IBaseBeanCall;
import java.lang.reflect.Type;
import manager.BaseDialog;
import manager.UpdateManager;
import network.APIException;
import network.DownloadInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p388ui.callview.UpdateAppView;
import p388ui.presenter.UpdateAppPresenter;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class UpdateUtil implements UpdateAppView {
    private static IBaseBeanCall baseBeanCall = null;
    public static boolean isCheckUpdateAlready = false;
    private static Activity mActivity;
    private static UpdateAppPresenter mPresenter;
    private static UpdateUtil updateUt;
    private static BaseDialog uppVerDlg;

    /* renamed from: util.UpdateUtil$a */
    class C7249a extends UpdateManager.DownLoadBack {

        /* renamed from: a */
        final /* synthetic */ TextView f25094a;

        C7249a(TextView textView) {
            this.f25094a = textView;
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onCompleted(String str) {
            super.onCompleted(str);
            this.f25094a.setText("立即安装");
            this.f25094a.setEnabled(true);
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onDownLoading(int i2) {
            super.onDownLoading(i2);
            if (UpdateUtil.uppVerDlg == null || i2 <= 0 || i2 > 100) {
                return;
            }
            this.f25094a.setText("下载中... " + i2 + "%");
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onError() {
            super.onError();
            C7331w1.m26688a("请重新下载");
            this.f25094a.setText("立即更新");
            this.f25094a.setEnabled(true);
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

    /* renamed from: util.UpdateUtil$b */
    class C7250b extends MiddleSubscriber<APIresult<APIH5Bean>> {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f25096a;

        C7250b(DownloadInfo downloadInfo) {
            this.f25096a = downloadInfo;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            onErrorMiddle(APIException.getApiExcept("获取更新地址失败，请重试~"));
            C7301n1.m26454a("hsc", "h5Url  onErrorMiddle===");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<APIH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                UpdateUtil.this.showDialogUpdate(this.f25096a, null);
                return;
            }
            String value = aPIresult.getData().getValue();
            C7301n1.m26454a("hsc", "h5Url===" + value);
            if (TextUtils.isEmpty(value)) {
                UpdateUtil.this.showDialogUpdate(this.f25096a, null);
            } else {
                UpdateUtil.this.showDialogUpdate(this.f25096a, value);
            }
        }
    }

    private UpdateUtil() {
        mPresenter = new UpdateAppPresenter(mActivity, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateApp(TextView textView, DownloadInfo downloadInfo, String str) {
        if (!C7313q1.m26534f()) {
            C7331w1.m26688a("请检查网络连接");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C7331w1.m26688a("更新异常，请重试");
            return;
        }
        textView.setText("下载中... 0%");
        textView.setEnabled(false);
        UpdateManager.getInstance().downloadApp(false, str, "{\"filePath\":\"" + downloadInfo.getUrl() + "\"}", new C7249a(textView));
    }

    private void requestAppDownlaod(DownloadInfo downloadInfo) {
        mPresenter.requestAppDownload(new C7250b(downloadInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogUpdate(final DownloadInfo downloadInfo, final String str) {
        Activity activity;
        if (downloadInfo == null || (activity = mActivity) == null || activity.isFinishing()) {
            return;
        }
        BaseDialog baseDialog = uppVerDlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            uppVerDlg = new BaseDialog(mActivity, C2113R.style.base_dialog_style);
            uppVerDlg.setContentView(C2113R.layout.dialog_update);
            uppVerDlg.setGravityLayout(2);
            uppVerDlg.setWidthDialog(-2.0d);
            uppVerDlg.setHeightDialog(-2.0d);
            uppVerDlg.setCancelable(false);
            uppVerDlg.setCanceledOnTouchOutside(false);
            uppVerDlg.initOnCreate();
            uppVerDlg.show();
            TextView textView = (TextView) uppVerDlg.findViewById(C2113R.id.update_title);
            TextView textView2 = (TextView) uppVerDlg.findViewById(C2113R.id.update_content);
            final TextView textView3 = (TextView) uppVerDlg.findViewById(C2113R.id.update);
            ImageView imageView = (ImageView) uppVerDlg.findViewById(C2113R.id.update_close);
            if (downloadInfo.isIsForcedVersion()) {
                imageView.setVisibility(4);
                C7325u1.m26630b("update_home", "");
            } else {
                imageView.setVisibility(0);
            }
            String version = downloadInfo.getVersion();
            String content = downloadInfo.getContent();
            if (TextUtils.isEmpty(version)) {
                version = "";
            }
            String replace = TextUtils.isEmpty(content) ? "" : content.replace("\\n", "\n").replace(AbstractC1191a.f2568g, "");
            textView.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + version);
            textView2.setText(replace);
            if (UpdateManager.getInstance().existsApk()) {
                textView3.setText("立即安装");
            }
            textView3.setOnClickListener(new View.OnClickListener() { // from class: util.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpdateUtil.this.m26136a(str, textView3, downloadInfo, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: util.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpdateUtil.m26135a(view);
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

    /* renamed from: a */
    public /* synthetic */ void m26136a(String str, TextView textView, DownloadInfo downloadInfo, View view) {
        if (UpdateManager.getInstance().existsApk()) {
            UpdateManager.getInstance().onReinstall();
        } else {
            C7310c.m26518a(mActivity, new String[]{C7308a.f25521A, C7308a.f25547z}, new C7334x1(this, str, textView, downloadInfo));
        }
    }

    @Override // p388ui.callview.UpdateAppView
    public void onSuccRequest(APIresult<DownloadInfo> aPIresult, IBaseBeanCall iBaseBeanCall) {
        if (aPIresult != null) {
            if (aPIresult.getCode() != 0) {
                updateShowMes(false, iBaseBeanCall, aPIresult);
                C7301n1.m26454a("updateApp onNext-->", aPIresult.getMsg());
                return;
            }
            DownloadInfo data = aPIresult.getData();
            try {
                if (data.getInnerVersion() > C7316r1.m26553f()) {
                    C7325u1.m26630b(C7325u1.f25690p, data.getFileMD5());
                    requestAppDownlaod(data);
                    updateShowMes(true, iBaseBeanCall, aPIresult);
                } else {
                    UpdateManager.getInstance().deleteApk();
                    updateShowMes(false, iBaseBeanCall, aPIresult);
                }
            } catch (Exception e2) {
                updateShowMes(false, iBaseBeanCall, aPIresult);
                C7301n1.m26457b("updateApp onNext catch>", e2.getMessage());
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26135a(View view) {
        C7325u1.m26630b("update_home", C7337y1.m26775d("yyyy-MM-dd"));
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
