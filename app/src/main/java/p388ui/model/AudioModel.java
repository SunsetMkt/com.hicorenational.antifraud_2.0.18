package p388ui.model;

import android.app.Activity;
import android.text.TextUtils;
import bean.ReportResultBean;
import bean.module.ModuelConfig;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.IRequest;
import network.MiddleSubscriber;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import network.request.ReportFileInfo;
import p245d.C4440a;
import p247e.C4445b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p388ui.basemvp.BaseView;
import util.C7304o1;
import util.C7328v1;

/* loaded from: classes2.dex */
public class AudioModel extends ModelPresent {

    /* renamed from: ui.model.AudioModel$a */
    class C6911a extends MiddleSubscriber<APIresult<ReportResultBean>> {

        /* renamed from: a */
        final /* synthetic */ IRequest f23930a;

        C6911a(IRequest iRequest) {
            this.f23930a = iRequest;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportResultBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            this.f23930a.onErrorMiddle();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            this.f23930a.onNextMiddle(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(InterfaceC4552c interfaceC4552c) {
            this.f23930a.onStartMiddle();
        }
    }

    public AudioModel(Activity activity) {
        super(activity, (BaseView) null);
    }

    private void confirmHttp(HashMap<String, Object> hashMap, IRequest<APIresult<ReportResultBean>> iRequest) {
        reportUploadFile(hashMap, C4440a.m16395a(ModuelConfig.MODEL_REPORT, 5, C4445b.f17064a0), new C6911a(iRequest));
    }

    private void uploadParam(ReportFileInfo reportFileInfo, IRequest<APIresult<ReportResultBean>> iRequest) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", TextUtils.isEmpty(reportFileInfo.getCaseinfo().getId()) ? "" : reportFileInfo.getCaseinfo().getId());
        hashMap.put("appReportDetail", reportFileInfo.getAppReportDetail());
        hashMap.put("reportDetail", reportFileInfo.getReportDetail());
        confirmHttp(hashMap, iRequest);
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo, IRequest<APIresult<ReportResultBean>> iRequest) {
        File file = new File(reportAppInfo.getFileLocalPath());
        if (TextUtils.isEmpty(reportAppInfo.getFileMd5())) {
            reportAppInfo.setFileMd5(C7304o1.m26466a(file));
        }
        if (TextUtils.isEmpty(reportAppInfo.getOccurTime())) {
            reportAppInfo.setOccurTime(C7328v1.m26646a(file.lastModified()) + "");
        }
        int source = reportAppInfo.getSource();
        ReportFileInfo reportFileInfo = new ReportFileInfo();
        reportFileInfo.setCaseinfo(reportCaseInfo);
        if (source == 1) {
            reportFileInfo.setAppReportDetail(reportAppInfo);
        } else if (source == 2 || source == 3 || source == 5) {
            reportFileInfo.setReportDetail(reportAppInfo);
        }
        uploadParam(reportFileInfo, iRequest);
    }
}
