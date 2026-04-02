package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.CriminalSocialBean;
import bean.CriminalSocialFileBean;
import bean.CriminalSocialTypeBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalSocialEditCallView;
import ui.model.OSSModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalSocialEditPresenter extends OSSModelPresent<CriminalSocialEditCallView> {

    class a extends MiddleSubscriber<APIresult<List<CriminalSocialTypeBean>>> {

        /* JADX INFO: renamed from: ui.presenter.CriminalSocialEditPresenter$a$a */
        class C0299a extends com.google.gson.d0.a<List<CriminalSocialTypeBean>> {
            C0299a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0299a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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

    class b implements IOssPicCallback {
        final /* synthetic */ List a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ CriminalSocialBean f14303b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ OssFileRequest f14304c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ List f14305d;

        b(List list, CriminalSocialBean criminalSocialBean, OssFileRequest ossFileRequest, List list2) {
            this.a = list;
            this.f14303b = criminalSocialBean;
            this.f14304c = ossFileRequest;
            this.f14305d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onfail();
            e2.a("\u7f51\u7edc\u5f02\u5e38,\u63d0\u4ea4\u5931\u8d25~");
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.a.add(ossFileInfo);
            if (this.f14303b.getNetAccountDetails() == null) {
                this.f14303b.setNetAccountDetails(new ArrayList());
            }
            this.f14303b.getNetAccountDetails().add(new CriminalSocialFileBean(ossFileInfo.getLocalPath(), ossFileInfo.getFilePath(), ossFileInfo.getFileMd5(), ossFileInfo.getFileSHA1()));
            if (this.a.size() == this.f14304c.getFilePaths().size()) {
                CriminalSocialEditPresenter.this.confirmHttp(this.f14303b);
            } else {
                this.f14304c.setFilePath((String) this.f14305d.get(this.a.size()));
                CriminalSocialEditPresenter.this.upFileToOss(this.f14304c, this);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                e2.a("\u6dfb\u52a0\u6210\u529f");
                CriminalSocialEditPresenter.this.mActivity.finish();
            }
        }
    }

    public CriminalSocialEditPresenter(Activity activity, CriminalSocialEditCallView criminalSocialEditCallView) {
        super(activity, criminalSocialEditCallView);
    }

    public void confirmHttp(CriminalSocialBean criminalSocialBean) {
        saveSocial(criminalSocialBean, e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.X1), new c());
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
        upFileToOss(ossFileRequest, new b(arrayList2, criminalSocialBean, ossFileRequest, arrayList));
    }

    public void typeHttp() {
        brandList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.Y1), new a());
    }
}
