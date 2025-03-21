package p388ui.presenter;

import bean.SurveyPeopleBean;
import interfaces.IClickListener;
import p388ui.presenter.ReportCaseInfoPresenter;

/* compiled from: ReportCaseInfoPresenter.java */
/* renamed from: ui.presenter.f0 */
/* loaded from: classes2.dex */
class C7139f0 implements IClickListener {

    /* renamed from: a */
    final /* synthetic */ int f24407a;

    /* renamed from: b */
    final /* synthetic */ ReportCaseInfoPresenter.HolderAdapte f24408b;

    C7139f0(ReportCaseInfoPresenter.HolderAdapte holderAdapte, int i2) {
        this.f24408b = holderAdapte;
        this.f24407a = i2;
    }

    @Override // interfaces.IClickListener
    public void cancelBtn() {
        SurveyPeopleBean surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(this.f24407a);
        if (surveyPeopleBean != null) {
            ReportCaseInfoPresenter.this.deletePeople(surveyPeopleBean.getVictimInfoID());
        }
    }

    @Override // interfaces.IClickListener
    public void clickOKBtn() {
    }
}
