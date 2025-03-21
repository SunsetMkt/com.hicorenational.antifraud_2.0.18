package p388ui.presenter;

import android.app.Activity;
import bean.ReportResultBean;
import network.IRequest;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import p388ui.activity.AudioActivity;
import p388ui.basemvp.BasePresenter;
import p388ui.model.AudioModel;

/* loaded from: classes2.dex */
public class AudioPresenter extends BasePresenter<AudioActivity, AudioModel> {

    /* renamed from: ui.presenter.AudioPresenter$a */
    class C6930a implements IRequest<APIresult<ReportResultBean>> {
        C6930a() {
        }

        @Override // network.IRequest
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            ((AudioActivity) ((BasePresenter) AudioPresenter.this).mView).onNextRequest(aPIresult);
        }

        @Override // network.IRequest
        public void onErrorMiddle() {
            ((AudioActivity) ((BasePresenter) AudioPresenter.this).mView).onErrorRequest();
        }

        @Override // network.IRequest
        public void onStartMiddle() {
            ((AudioActivity) ((BasePresenter) AudioPresenter.this).mView).onStartRequest();
        }
    }

    public AudioPresenter(Activity activity) {
        attachModel(new AudioModel(activity));
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo) {
        ((AudioModel) this.mModel).doAudioUpload(reportAppInfo, reportCaseInfo, new C6930a());
    }
}
