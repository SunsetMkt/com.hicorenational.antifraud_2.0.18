package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.CriminalSocialBean;
import bean.CriminalSocialFileBean;
import bean.CriminalSocialTypeBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
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
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CriminalSocialEditCallView;
import p388ui.model.OSSModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CriminalSocialEditPresenter extends OSSModelPresent<CriminalSocialEditCallView> {

    /* renamed from: ui.presenter.CriminalSocialEditPresenter$a */
    class C6965a extends MiddleSubscriber<APIresult<List<CriminalSocialTypeBean>>> {

        /* renamed from: ui.presenter.CriminalSocialEditPresenter$a$a */
        class a extends C2049a<List<CriminalSocialTypeBean>> {
            a() {
            }
        }

        C6965a() {
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
        protected void onNextMiddle(APIresult<List<CriminalSocialTypeBean>> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onSuccessType(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.CriminalSocialEditPresenter$b */
    class C6966b implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ List f24041a;

        /* renamed from: b */
        final /* synthetic */ CriminalSocialBean f24042b;

        /* renamed from: c */
        final /* synthetic */ OssFileRequest f24043c;

        /* renamed from: d */
        final /* synthetic */ List f24044d;

        C6966b(List list, CriminalSocialBean criminalSocialBean, OssFileRequest ossFileRequest, List list2) {
            this.f24041a = list;
            this.f24042b = criminalSocialBean;
            this.f24043c = ossFileRequest;
            this.f24044d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onfail();
            C7331w1.m26688a("网络异常,提交失败~");
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f24041a.add(ossFileInfo);
            if (this.f24042b.getNetAccountDetails() == null) {
                this.f24042b.setNetAccountDetails(new ArrayList());
            }
            this.f24042b.getNetAccountDetails().add(new CriminalSocialFileBean(ossFileInfo.getLocalPath(), ossFileInfo.getFilePath(), ossFileInfo.getFileMd5(), ossFileInfo.getFileSHA1()));
            if (this.f24041a.size() == this.f24043c.getFilePaths().size()) {
                CriminalSocialEditPresenter.this.confirmHttp(this.f24042b);
            } else {
                this.f24043c.setFilePath((String) this.f24044d.get(this.f24041a.size()));
                CriminalSocialEditPresenter.this.upFileToOss(this.f24043c, this);
            }
        }
    }

    /* renamed from: ui.presenter.CriminalSocialEditPresenter$c */
    class C6967c extends MiddleSubscriber<APIresult> {
        C6967c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                C7331w1.m26688a("添加成功");
                CriminalSocialEditPresenter.this.mActivity.finish();
            }
        }
    }

    public CriminalSocialEditPresenter(Activity activity, CriminalSocialEditCallView criminalSocialEditCallView) {
        super(activity, criminalSocialEditCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmHttp(CriminalSocialBean criminalSocialBean) {
        saveSocial(criminalSocialBean, C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17053W1), new C6967c());
    }

    public void confirm(CriminalSocialBean criminalSocialBean, List<LocalMedia> list) {
        if (list == null || list.size() == 0) {
            confirmHttp(criminalSocialBean);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.isEmpty(list.get(i2).getOriginalPath())) {
                arrayList.add(list.get(i2).getPath());
            }
        }
        if (arrayList.size() <= 0) {
            confirmHttp(criminalSocialBean);
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePaths(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ossFileRequest.setFilePath(arrayList.get(arrayList2.size()));
        upFileToOss(ossFileRequest, new C6966b(arrayList2, criminalSocialBean, ossFileRequest, arrayList));
    }

    public void typeHttp() {
        brandList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17056X1), new C6965a());
    }
}
