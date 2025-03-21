package p388ui.presenter;

import android.app.Activity;
import bean.ReportResultBean;
import network.IRequest;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import p388ui.activity.AppActivity;
import p388ui.basemvp.BasePresenter;
import p388ui.model.AudioModel;

/* loaded from: classes2.dex */
public class AppPresenter extends BasePresenter<AppActivity, AudioModel> {

    /* renamed from: ui.presenter.AppPresenter$a */
    class C6924a implements IRequest<APIresult<ReportResultBean>> {
        C6924a() {
        }

        @Override // network.IRequest
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            ((AppActivity) ((BasePresenter) AppPresenter.this).mView).onNextRequest(aPIresult);
        }

        @Override // network.IRequest
        public void onErrorMiddle() {
            ((AppActivity) ((BasePresenter) AppPresenter.this).mView).onErrorRequest();
        }

        @Override // network.IRequest
        public void onStartMiddle() {
            ((AppActivity) ((BasePresenter) AppPresenter.this).mView).onStartRequest();
        }
    }

    public AppPresenter(Activity activity) {
        attachModel(new AudioModel(activity));
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo) {
        ((AudioModel) this.mModel).doAudioUpload(reportAppInfo, reportCaseInfo, new C6924a());
    }
}
