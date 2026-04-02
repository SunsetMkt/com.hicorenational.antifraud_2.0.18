package ui.presenter;

import bean.SurveyPeopleBean;
import interfaces.IClickListener;
import ui.presenter.ReportCaseInfoPresenter;

/* JADX INFO: compiled from: ReportCaseInfoPresenter.java */
/* JADX INFO: loaded from: classes2.dex */
class l0 implements IClickListener {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ReportCaseInfoPresenter.HolderAdapte f14463b;

    l0(ReportCaseInfoPresenter.HolderAdapte holderAdapte, int i2) {
        this.f14463b = holderAdapte;
        this.a = i2;
    }

    @Override // interfaces.IClickListener
    public void cancelBtn() {
        SurveyPeopleBean surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(this.a);
        if (surveyPeopleBean != null) {
            ReportCaseInfoPresenter.this.deletePeople(surveyPeopleBean.getVictimInfoID());
        }
    }

    @Override // interfaces.IClickListener
    public void clickOKBtn() {
    }
}
