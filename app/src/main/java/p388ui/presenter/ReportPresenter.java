package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.CallBean;
import bean.ReportPersonBean;
import bean.SmsBean;
import bean.SocialAccBean;
import bean.SocialTradBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.ReportCallInfo;
import network.ReportSmsInfo;
import network.account.APIresult;
import network.request.EvidenceCommInfo;
import network.request.ReportCaseInfo;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.activity.ReportNewActivity;
import p388ui.callview.ReportCallView;
import p388ui.model.ModelPresent;
import p388ui.view.HttpTextView;
import util.C7257b1;

/* loaded from: classes2.dex */
public class ReportPresenter extends ModelPresent<ReportCallView> {
    boolean isilent;

    /* renamed from: ui.presenter.ReportPresenter$a */
    class C7071a extends MiddleSubscriber<APIresult<HistoryListInfo.RowsBean>> {
        C7071a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HistoryListInfo.RowsBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportCallView) ReportPresenter.this.mvpView).onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HistoryListInfo.RowsBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportCallView) ReportPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            super.onStartMiddle(interfaceC4552c);
        }
    }

    /* renamed from: ui.presenter.ReportPresenter$b */
    class C7072b extends MiddleSubscriber<APIresult> {
        C7072b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
        }
    }

    public ReportPresenter(Activity activity, ReportCallView reportCallView) {
        super(activity, reportCallView);
        this.isilent = false;
    }

    private void doCalls(List<CallBean> list, EvidenceCommInfo evidenceCommInfo) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ReportCallInfo reportCallInfo = new ReportCallInfo();
            reportCallInfo.setVictimTel(list.get(i2).getVictimTel());
            reportCallInfo.setTalkTime(list.get(i2).getTalkTime());
            reportCallInfo.setNumber(list.get(i2).getNumber());
            reportCallInfo.setOccurTime(list.get(i2).getCrime_time());
            arrayList.add(reportCallInfo);
        }
        evidenceCommInfo.setTelReportDetails(arrayList);
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

    private void doSMS(List<SmsBean> list, EvidenceCommInfo evidenceCommInfo) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ReportSmsInfo reportSmsInfo = new ReportSmsInfo();
            reportSmsInfo.setVictimTel(list.get(i2).getVictimTel());
            reportSmsInfo.setNumber(list.get(i2).getSmsNum());
            reportSmsInfo.setOccurTime(list.get(i2).getStringDate());
            String smsContent = list.get(i2).getSmsContent();
            try {
                HttpTextView httpTextView = new HttpTextView(this.mActivity);
                httpTextView.setUrlText(smsContent);
                String urlText = httpTextView.getUrlText();
                if (TextUtils.isEmpty(urlText)) {
                    urlText = "";
                }
                reportSmsInfo.setContent(smsContent);
                reportSmsInfo.setUrl(urlText);
            } catch (Exception unused) {
                reportSmsInfo.setContent(smsContent);
                reportSmsInfo.setUrl("");
            }
            arrayList.add(reportSmsInfo);
        }
        evidenceCommInfo.setSmsReportDetails(arrayList);
    }

    private void doSocials(List<SocialAccBean> list, EvidenceCommInfo evidenceCommInfo) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            SocialTradBean socialTradBean = new SocialTradBean();
            socialTradBean.setAccount(list.get(i2).getAccountNum());
            socialTradBean.setAccountType(list.get(i2).getAccountName());
            socialTradBean.setOccurTime("");
            arrayList.add(socialTradBean);
        }
        evidenceCommInfo.setSocialReportDetails(arrayList);
    }

    private void doTrads(List<SocialAccBean> list, EvidenceCommInfo evidenceCommInfo) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            SocialTradBean socialTradBean = new SocialTradBean();
            socialTradBean.setAccount(list.get(i2).getAccountNum());
            socialTradBean.setPaymentType(list.get(i2).getAccountName());
            socialTradBean.setOccurTime("");
            arrayList.add(socialTradBean);
        }
        evidenceCommInfo.setPaymentReportDetails(arrayList);
    }

    private void doWebUrls(List<String> list, EvidenceCommInfo evidenceCommInfo) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashSet.add(list.get(i2));
        }
        for (String str : new ArrayList(hashSet)) {
            ReportSmsInfo reportSmsInfo = new ReportSmsInfo();
            reportSmsInfo.setOccurTime("");
            reportSmsInfo.setUrl(str);
            arrayList.add(reportSmsInfo);
        }
        evidenceCommInfo.setWebsiteReportDtails(arrayList);
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

    public void cancleUploadFile(boolean z) {
        String str = ReportNewActivity.REPORT_UP_ID;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17076d0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        cancleUploadFile(m16395a, hashMap, new C7072b());
    }

    public void evidenceSubmit(EvidenceCommInfo evidenceCommInfo) {
        if (!this.isilent) {
            C7257b1.m26203a("提交中...", true, this.mActivity);
        }
        uploadReportParam(evidenceCommInfo, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17068b0), new C7071a());
    }

    public void reportSubmit(List<CallBean> list, List<SmsBean> list2, List<String> list3, List<SocialAccBean> list4, List<SocialAccBean> list5, ReportPersonBean reportPersonBean) {
        EvidenceCommInfo evidenceCommInfo = new EvidenceCommInfo();
        doCaseInfo(evidenceCommInfo, reportPersonBean);
        doCalls(list, evidenceCommInfo);
        doSMS(list2, evidenceCommInfo);
        doWebUrls(list3, evidenceCommInfo);
        doSocials(list4, evidenceCommInfo);
        doTrads(list5, evidenceCommInfo);
        evidenceSubmit(evidenceCommInfo);
    }

    public void setIsilent(boolean z) {
        this.isilent = z;
    }

    public void uploadReportParam(EvidenceCommInfo evidenceCommInfo, String str, MiddleSubscriber<APIresult<HistoryListInfo.RowsBean>> middleSubscriber) {
        reportSubmit(evidenceCommInfo, str, middleSubscriber);
    }
}
