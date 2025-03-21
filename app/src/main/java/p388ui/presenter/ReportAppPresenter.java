package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.BlockFileBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.SurveyAppBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import interfaces.IOssPicCallback;
import interfaces.PermissionsListener;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p357j.C5846e;
import p388ui.activity.AppSelectedActivity;
import p388ui.activity.ReportAppAddActivity;
import p388ui.callview.ReportAppView;
import p388ui.model.OSSModelPresent;
import p388ui.presenter.ReportAppPresenter;
import util.C7292k1;
import util.C7304o1;
import util.C7331w1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class ReportAppPresenter extends OSSModelPresent<ReportAppView> {
    private BlockFileBean blockApp;
    private BlockFileBean blockLogo;
    private BlockFileBean blockQrcode;
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyAppBean> mAppBeans;
    boolean upApp;
    boolean upLogo;
    boolean upZXing;

    public class HolderAdapte extends RecyclerView.Adapter<C7058a> {

        /* renamed from: a */
        private Context f24224a;

        /* renamed from: ui.presenter.ReportAppPresenter$HolderAdapte$a */
        class C7058a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24226a;

            /* renamed from: b */
            public TextView f24227b;

            /* renamed from: c */
            public TextView f24228c;

            /* renamed from: d */
            public TextView f24229d;

            /* renamed from: e */
            public View f24230e;

            /* renamed from: f */
            public View f24231f;

            /* renamed from: g */
            public ImageView f24232g;

            public C7058a(View view) {
                super(view);
                this.f24226a = view.findViewById(C2113R.id.fl_view);
                this.f24227b = (TextView) view.findViewById(C2113R.id.tv_app_name);
                this.f24230e = view.findViewById(C2113R.id.ll_app_pkg);
                this.f24228c = (TextView) view.findViewById(C2113R.id.tv_app_pkg);
                this.f24231f = view.findViewById(C2113R.id.ll_app_vers);
                this.f24229d = (TextView) view.findViewById(C2113R.id.tv_app_vers);
                this.f24232g = (ImageView) view.findViewById(C2113R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f24224a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7058a c7058a, final int i2) {
            if (ReportAppPresenter.this.mAppBeans.size() > 0) {
                SurveyAppBean surveyAppBean = (SurveyAppBean) ReportAppPresenter.this.mAppBeans.get(i2);
                c7058a.f24227b.setText(surveyAppBean.getAppName());
                if (C7337y1.m26791p(surveyAppBean.getPackageName())) {
                    c7058a.f24230e.setVisibility(8);
                } else {
                    c7058a.f24230e.setVisibility(0);
                    c7058a.f24228c.setText(surveyAppBean.getPackageName());
                }
                if (C7337y1.m26791p(surveyAppBean.getAppVersion())) {
                    c7058a.f24231f.setVisibility(8);
                } else {
                    c7058a.f24231f.setVisibility(0);
                    c7058a.f24229d.setText(surveyAppBean.getAppVersion());
                }
            }
            c7058a.f24226a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportAppPresenter.HolderAdapte.this.m25650a(i2, view);
                }
            });
            c7058a.f24232g.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportAppPresenter.HolderAdapte.this.m25652b(i2, view);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m25652b(int i2, View view) {
            ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onItemDelet(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportAppPresenter.this.mAppBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7058a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7058a(LayoutInflater.from(this.f24224a).inflate(C2113R.layout.item_report_app, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25650a(int i2, View view) {
            Intent intent = new Intent(ReportAppPresenter.this.mActivity, (Class<?>) ReportAppAddActivity.class);
            intent.putExtra(C7292k1.f25338C0, ReportAppPresenter.this.caseInfoId);
            intent.putExtra(C7292k1.f25344F0, i2);
            intent.putExtra(C7292k1.f25391c, (Serializable) ReportAppPresenter.this.mAppBeans.get(i2));
            ReportAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.ReportAppPresenter$a */
    class C7059a implements PermissionsListener {
        C7059a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(ReportAppPresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(ReportAppPresenter.this.mActivity, (Class<?>) AppSelectedActivity.class);
            intent.putExtra(AppSelectedActivity.f21819h, 2);
            intent.putExtra(C7292k1.f25394d, 2);
            intent.putExtra("extra_select_limite", 1);
            ReportAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.ReportAppPresenter$b */
    class C7060b implements PermissionsListener {
        C7060b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(ReportAppPresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(ReportAppPresenter.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    /* renamed from: ui.presenter.ReportAppPresenter$c */
    class C7061c extends MiddleSubscriber<APIresult<List<SurveyAppBean>>> {

        /* renamed from: ui.presenter.ReportAppPresenter$c$a */
        class a extends C2049a<List<SurveyAppBean>> {
            a() {
            }
        }

        C7061c() {
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
        protected void onNextMiddle(APIresult<List<SurveyAppBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.ReportAppPresenter$d */
    class C7062d extends MiddleSubscriber<APIresult> {

        /* renamed from: a */
        final /* synthetic */ int f24238a;

        C7062d(int i2) {
            this.f24238a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(this.f24238a, null);
            }
        }
    }

    /* renamed from: ui.presenter.ReportAppPresenter$e */
    class C7063e extends MiddleSubscriber<APIresult> {
        C7063e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(4, null);
            }
        }
    }

    /* renamed from: ui.presenter.ReportAppPresenter$f */
    class C7064f implements IOssPicCallback {

        /* renamed from: a */
        final /* synthetic */ BlockFileBean f24241a;

        /* renamed from: b */
        final /* synthetic */ int f24242b;

        C7064f(BlockFileBean blockFileBean, int i2) {
            this.f24241a = blockFileBean;
            this.f24242b = i2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onFailRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f24241a.setFilePath(ossFileInfo.getFilePath());
                this.f24241a.setFileMd5(ossFileInfo.getFileMd5());
                this.f24241a.setFileSHA1(ossFileInfo.getFileSHA1());
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(this.f24242b, null);
            }
        }
    }

    public ReportAppPresenter(Activity activity, String str, ReportAppView reportAppView) {
        super(activity, reportAppView);
        this.mAppBeans = new ArrayList();
        this.caseInfoId = str;
    }

    private String getMd5(String str, String str2) {
        return TextUtils.isEmpty(str) ? C7304o1.m26466a(new File(str2)) : str;
    }

    private void httpHandleApp(SurveyAppBean surveyAppBean, int i2) {
        surveyCaseApp(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17026N1), surveyAppBean, new C7062d(i2));
    }

    public void addAppCheck() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C7059a());
    }

    public void addPicCheck() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C7060b());
    }

    public void addSurveyApp(String str, String str2, String str3) {
        if (!this.upApp) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(12, null);
            return;
        }
        this.blockApp = new BlockFileBean();
        this.blockApp.setFileID(str);
        this.blockApp.setLocalPath(str2);
        this.blockApp.setFileName(str3);
        uploadFile(12, this.blockApp);
    }

    public void addSurveyLogo(String str, String str2, String str3) {
        if (!this.upLogo) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(10, null);
            return;
        }
        this.blockLogo = new BlockFileBean();
        this.blockLogo.setFileID(str);
        this.blockLogo.setLocalPath(str2);
        this.blockLogo.setFileName(str3);
        uploadFile(10, this.blockLogo);
    }

    public void addSurveyQrcode(String str, String str2, String str3) {
        if (!this.upZXing) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(11, null);
            return;
        }
        this.blockQrcode = new BlockFileBean();
        this.blockQrcode.setFileID(str);
        this.blockQrcode.setLocalPath(str2);
        this.blockQrcode.setFileName(str3);
        uploadFile(11, this.blockQrcode);
    }

    public void deleteCaseAppInfo(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17029O1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        deleteCaseAppInfo(m16395a, hashMap, new C7063e());
    }

    public void getSurveyAppList(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getSurveyAppList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17023M1), hashMap, new C7061c());
    }

    public void handleAppInfo(SurveyAppBean surveyAppBean, int i2) {
        surveyAppBean.setPackageFile(this.blockApp);
        surveyAppBean.setQrCodeFile(this.blockQrcode);
        surveyAppBean.setAppLogoFile(this.blockLogo);
        httpHandleApp(surveyAppBean, i2);
    }

    public void handleUpdate(SurveyAppBean surveyAppBean, boolean z, boolean z2, boolean z3) {
        this.upLogo = z3;
        this.upZXing = z2;
        this.upApp = z;
        if (TextUtils.isEmpty(surveyAppBean.getAppLogoPath())) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(10, null);
        } else {
            addSurveyLogo(surveyAppBean.getAppLogoFileID(), surveyAppBean.getAppLogoPath(), surveyAppBean.getAppLogoName());
        }
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<SurveyAppBean> list) {
        if (list != null) {
            this.mAppBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void uploadFile(int i2, BlockFileBean blockFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(blockFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new C7064f(blockFileBean, i2));
    }
}
