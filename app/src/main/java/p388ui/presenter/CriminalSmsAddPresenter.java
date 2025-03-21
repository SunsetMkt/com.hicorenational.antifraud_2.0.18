package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.SmsPictureBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p023b.p024a.p025a.p027e.C0923i;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CriminalSmsAddCallView;
import p388ui.model.OSSModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalSmsAddPresenter extends OSSModelPresent<CriminalSmsAddCallView> {

    /* renamed from: ui.presenter.CriminalSmsAddPresenter$a */
    class C6960a implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ List f24026a;

        /* renamed from: b */
        final /* synthetic */ CriminalSmsBean f24027b;

        /* renamed from: c */
        final /* synthetic */ OssFileRequest f24028c;

        /* renamed from: d */
        final /* synthetic */ List f24029d;

        C6960a(List list, CriminalSmsBean criminalSmsBean, OssFileRequest ossFileRequest, List list2) {
            this.f24026a = list;
            this.f24027b = criminalSmsBean;
            this.f24028c = ossFileRequest;
            this.f24029d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onfail();
            C7331w1.m26688a("网络异常,提交失败~");
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f24026a.add(ossFileInfo);
            if (this.f24027b.getSmsDetails() == null) {
                this.f24027b.setSmsDetails(new ArrayList());
            }
            this.f24027b.getSmsDetails().add(new SmsPictureBean(ossFileInfo.getLocalPath(), ossFileInfo.getFilePath(), ossFileInfo.getFileMd5(), ossFileInfo.getFileSHA1()));
            if (this.f24026a.size() == this.f24028c.getFilePaths().size()) {
                CriminalSmsAddPresenter.this.confirmHttp(this.f24027b);
            } else {
                this.f24028c.setFilePath((String) this.f24029d.get(this.f24026a.size()));
                CriminalSmsAddPresenter.this.upFileToOss(this.f24028c, this);
            }
        }
    }

    /* renamed from: ui.presenter.CriminalSmsAddPresenter$b */
    class C6961b extends MiddleSubscriber<APIresult> {
        C6961b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                C7331w1.m26688a("提交成功");
                CriminalSmsAddPresenter.this.mActivity.finish();
            }
        }
    }

    /* renamed from: ui.presenter.CriminalSmsAddPresenter$c */
    class C6962c extends MiddleSubscriber<APIresult<List<BrandBean>>> {

        /* renamed from: a */
        final /* synthetic */ C0923i.b f24032a;

        /* renamed from: ui.presenter.CriminalSmsAddPresenter$c$a */
        class a extends C2049a<List<BrandBean>> {
            a() {
            }
        }

        C6962c(C0923i.b bVar) {
            this.f24032a = bVar;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<BrandBean>> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onSuccessBrand(aPIresult.getData(), this.f24032a);
            }
        }
    }

    public CriminalSmsAddPresenter(Activity activity, CriminalSmsAddCallView criminalSmsAddCallView) {
        super(activity, criminalSmsAddCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmHttp(CriminalSmsBean criminalSmsBean) {
        saveSms(criminalSmsBean, C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17035Q1), new C6961b());
    }

    public void brandHttp(C0923i.b<BrandBean> bVar) {
        brandList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17041S1), new C6962c(bVar));
    }

    public void confirm(CriminalSmsBean criminalSmsBean, List<LocalMedia> list) {
        if (list == null || list.size() == 0) {
            confirmHttp(criminalSmsBean);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.isEmpty(list.get(i2).getOriginalPath())) {
                arrayList.add(list.get(i2).getPath());
            }
        }
        if (arrayList.size() <= 0) {
            confirmHttp(criminalSmsBean);
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePaths(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ossFileRequest.setFilePath(arrayList.get(arrayList2.size()));
        upFileToOss(ossFileRequest, new C6960a(arrayList2, criminalSmsBean, ossFileRequest, arrayList));
    }
}
