package p388ui.presenter;

import android.content.Context;
import bean.CallWarnBean;
import bean.ReportPersonBean;
import bean.SMSWarnBean;
import bean.SmsBean;
import bean.module.ModuelConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.HistoryListInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.basemvp.BaseView;
import p388ui.callview.CallWarnCallView;
import p388ui.callview.ReportCallView;
import p388ui.callview.SMSWarnCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class WarnPresenter extends ModelPresent {
    CallWarnCallView mWarnCallView;
    SMSWarnCallView mWarnSmsView;

    /* renamed from: ui.presenter.WarnPresenter$a */
    class C7111a extends MiddleSubscriber<APIresult<CallWarnBean>> {
        C7111a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CallWarnBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            WarnPresenter.this.mWarnCallView.onSuccRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CallWarnBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            try {
                if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                    WarnPresenter.this.mWarnCallView.onSuccRequest(null);
                } else {
                    WarnPresenter.this.mWarnCallView.onSuccRequest(aPIresult.getData());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                WarnPresenter.this.mWarnCallView.onSuccRequest(null);
            }
        }
    }

    /* renamed from: ui.presenter.WarnPresenter$b */
    class C7112b extends MiddleSubscriber<APIresult<SMSWarnBean>> {
        C7112b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SMSWarnBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            WarnPresenter.this.mWarnSmsView.onSuccRequest(new SMSWarnBean());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SMSWarnBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                WarnPresenter.this.mWarnSmsView.onSuccRequest(new SMSWarnBean());
            } else {
                WarnPresenter.this.mWarnSmsView.onSuccRequest(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.WarnPresenter$c */
    class C7113c implements ReportCallView {
        C7113c() {
        }

        @Override // p388ui.callview.ReportCallView
        public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
            C7331w1.m26688a("举报成功");
        }

        @Override // p388ui.callview.ReportCallView
        public void onfailRequest() {
        }
    }

    public WarnPresenter(Context context, CallWarnCallView callWarnCallView) {
        super(context, (BaseView) null);
        this.mWarnCallView = callWarnCallView;
    }

    public void oneKeyReportSMS(SmsBean smsBean, List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(smsBean);
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setDupery("其他诈骗");
        reportPersonBean.setDefraudType(22);
        reportPersonBean.setCaseDis("短信预警一键举报");
        ReportPresenter reportPresenter = new ReportPresenter(this.mActivity, new C7113c());
        reportPresenter.setIsilent(true);
        reportPresenter.reportSubmit(null, arrayList, list, null, null, reportPersonBean);
    }

    public void requestOKHttp(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_WARN, 6, C4445b.f17084f0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tel", str);
        requestOKHttp(m16395a, hashMap, new C7111a());
    }

    public void requestSMSHttp(String str, String str2) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_WARN, 6, C4445b.f17100k0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tel", str);
        hashMap.put("smsContent", str2);
        requestSMSHttp(m16395a, hashMap, new C7112b());
    }

    public WarnPresenter(Context context, SMSWarnCallView sMSWarnCallView) {
        super(context, (BaseView) null);
        this.mWarnSmsView = sMSWarnCallView;
    }
}
