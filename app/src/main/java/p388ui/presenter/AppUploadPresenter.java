package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.ReportPersonBean;
import bean.ReportResultBean;
import bean.UploadStateInfo;
import bean.module.ModuelConfig;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.IRequest;
import network.MiddleSubscriber;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.EvidenceCommInfo;
import network.request.ReportCaseInfo;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.activity.ReportNewActivity;
import p388ui.callview.AudioCallView;
import p388ui.model.AudioModel;
import p388ui.model.ModelPresent;
import util.C7257b1;

/* loaded from: classes2.dex */
public class AppUploadPresenter extends ModelPresent<AudioCallView> {
    private Activity mActivity;

    /* renamed from: ui.presenter.AppUploadPresenter$a */
    class C6928a implements IRequest<APIresult<ReportResultBean>> {
        C6928a() {
        }

        @Override // network.IRequest
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            ((AudioCallView) AppUploadPresenter.this.mvpView).onNextRequest(aPIresult);
        }

        @Override // network.IRequest
        public void onErrorMiddle() {
            ((AudioCallView) AppUploadPresenter.this.mvpView).onErrorRequest();
        }

        @Override // network.IRequest
        public void onStartMiddle() {
            ((AudioCallView) AppUploadPresenter.this.mvpView).onStartRequest();
        }
    }

    /* renamed from: ui.presenter.AppUploadPresenter$b */
    class C6929b extends MiddleSubscriber<APIresult> {
        C6929b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((AudioCallView) AppUploadPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((AudioCallView) AppUploadPresenter.this.mvpView).onSuccessRequest(aPIresult);
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            super.onStartMiddle(interfaceC4552c);
            C7257b1.m26203a("提交中...", true, AppUploadPresenter.this.mActivity);
        }
    }

    public AppUploadPresenter(Activity activity, AudioCallView audioCallView) {
        super(activity, audioCallView);
        this.mActivity = activity;
    }

    private void doCaseInfo(EvidenceCommInfo evidenceCommInfo, ReportPersonBean reportPersonBean) {
        ReportCaseInfo reportCaseInfo = new ReportCaseInfo();
        if (reportPersonBean != null) {
            reportCaseInfo.setCaseCategory(reportPersonBean.getDefraudType());
            reportCaseInfo.setCaseCategoryText(reportPersonBean.getDupery());
            reportCaseInfo.setRegion(reportPersonBean.getReportDic());
            reportCaseInfo.setCaseDescription(reportPersonBean.getCaseDis());
        }
        setUpId(reportCaseInfo);
        reportCaseInfo.setCommonParams();
        evidenceCommInfo.setReportCaseInfos(reportCaseInfo);
    }

    private void setUpId(ReportCaseInfo reportCaseInfo) {
        if (reportCaseInfo == null || !TextUtils.isEmpty(reportCaseInfo.getId())) {
            return;
        }
        String str = ReportNewActivity.REPORT_UP_ID;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        reportCaseInfo.setId(str);
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo) {
        new AudioModel(this.mActivity).doAudioUpload(reportAppInfo, reportCaseInfo, new C6928a());
    }

    public void evidenceSubmit(EvidenceCommInfo evidenceCommInfo) {
        uploadReportParam(evidenceCommInfo, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17068b0), new C6929b());
    }

    public String[] getAppFileIDs(List<UploadStateInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getFileId());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void reportSubmit(String[] strArr, ReportPersonBean reportPersonBean) {
        EvidenceCommInfo evidenceCommInfo = new EvidenceCommInfo();
        doCaseInfo(evidenceCommInfo, reportPersonBean);
        evidenceCommInfo.setAppFileIDs(strArr);
        evidenceSubmit(evidenceCommInfo);
    }

    public void uploadReportParam(EvidenceCommInfo evidenceCommInfo, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        reportSubmitHttp(evidenceCommInfo, str, middleSubscriber);
    }
}
