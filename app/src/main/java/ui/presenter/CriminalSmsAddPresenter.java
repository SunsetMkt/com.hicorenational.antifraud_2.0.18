package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.SmsPictureBean;
import bean.module.ModuelConfig;
import c.a.a.e.i;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalSmsAddCallView;
import ui.model.OSSModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CriminalSmsAddPresenter extends OSSModelPresent<CriminalSmsAddCallView> {

    class a implements IOssPicCallback {
        final /* synthetic */ List a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ CriminalSmsBean f14297b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ OssFileRequest f14298c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ List f14299d;

        a(List list, CriminalSmsBean criminalSmsBean, OssFileRequest ossFileRequest, List list2) {
            this.a = list;
            this.f14297b = criminalSmsBean;
            this.f14298c = ossFileRequest;
            this.f14299d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onfail();
            e2.a("\u7f51\u7edc\u5f02\u5e38,\u63d0\u4ea4\u5931\u8d25~");
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.a.add(ossFileInfo);
            if (this.f14297b.getSmsDetails() == null) {
                this.f14297b.setSmsDetails(new ArrayList());
            }
            this.f14297b.getSmsDetails().add(new SmsPictureBean(ossFileInfo.getLocalPath(), ossFileInfo.getFilePath(), ossFileInfo.getFileMd5(), ossFileInfo.getFileSHA1()));
            if (this.a.size() == this.f14298c.getFilePaths().size()) {
                CriminalSmsAddPresenter.this.confirmHttp(this.f14297b);
            } else {
                this.f14298c.setFilePath((String) this.f14299d.get(this.a.size()));
                CriminalSmsAddPresenter.this.upFileToOss(this.f14298c, this);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                e2.a("\u63d0\u4ea4\u6210\u529f");
                CriminalSmsAddPresenter.this.mActivity.finish();
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<List<BrandBean>>> {
        final /* synthetic */ i.b a;

        class a extends com.google.gson.d0.a<List<BrandBean>> {
            a() {
            }
        }

        c(i.b bVar) {
            this.a = bVar;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<BrandBean>> aPIresult) {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onSuccessBrand(aPIresult.getData(), this.a);
            }
        }
    }

    public CriminalSmsAddPresenter(Activity activity, CriminalSmsAddCallView criminalSmsAddCallView) {
        super(activity, criminalSmsAddCallView);
    }

    public void confirmHttp(CriminalSmsBean criminalSmsBean) {
        saveSms(criminalSmsBean, e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.R1), new b());
    }

    public void brandHttp(i.b<BrandBean> bVar) {
        brandList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.T1), new c(bVar));
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
        upFileToOss(ossFileRequest, new a(arrayList2, criminalSmsBean, ossFileRequest, arrayList));
    }
}
