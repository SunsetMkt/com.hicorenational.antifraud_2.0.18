package p388ui.presenter;

import android.app.Activity;
import bean.ReportResultBean;
import network.IRequest;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import p388ui.activity.PictureActivity;
import p388ui.basemvp.BasePresenter;
import p388ui.model.AudioModel;

/* loaded from: classes2.dex */
public class PicturePresenter extends BasePresenter<PictureActivity, AudioModel> {

    /* renamed from: ui.presenter.PicturePresenter$a */
    class C7036a implements IRequest<APIresult<ReportResultBean>> {
        C7036a() {
        }

        @Override // network.IRequest
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            ((PictureActivity) ((BasePresenter) PicturePresenter.this).mView).onNextRequest(aPIresult);
        }

        @Override // network.IRequest
        public void onErrorMiddle() {
            ((PictureActivity) ((BasePresenter) PicturePresenter.this).mView).onErrorRequest();
        }

        @Override // network.IRequest
        public void onStartMiddle() {
            ((PictureActivity) ((BasePresenter) PicturePresenter.this).mView).onStartRequest();
        }
    }

    public PicturePresenter(Activity activity) {
        attachModel(new AudioModel(activity));
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo) {
        ((AudioModel) this.mModel).doAudioUpload(reportAppInfo, reportCaseInfo, new C7036a());
    }
}
