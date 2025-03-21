package p388ui.presenter;

import android.app.Activity;
import bean.ReportResultBean;
import network.IRequest;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import p388ui.activity.VideoActivity;
import p388ui.basemvp.BasePresenter;
import p388ui.model.AudioModel;

/* loaded from: classes2.dex */
public class VideoPresenter extends BasePresenter<VideoActivity, AudioModel> {

    /* renamed from: ui.presenter.VideoPresenter$a */
    class C7109a implements IRequest<APIresult<ReportResultBean>> {
        C7109a() {
        }

        @Override // network.IRequest
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            ((VideoActivity) ((BasePresenter) VideoPresenter.this).mView).onNextRequest(aPIresult);
        }

        @Override // network.IRequest
        public void onErrorMiddle() {
            ((VideoActivity) ((BasePresenter) VideoPresenter.this).mView).onErrorRequest();
        }

        @Override // network.IRequest
        public void onStartMiddle() {
            ((VideoActivity) ((BasePresenter) VideoPresenter.this).mView).onStartRequest();
        }
    }

    public VideoPresenter(Activity activity) {
        attachModel(new AudioModel(activity));
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo) {
        ((AudioModel) this.mModel).doAudioUpload(reportAppInfo, reportCaseInfo, new C7109a());
    }
}
