package ui.presenter;

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
import com.hicorenational.antifraud.R;
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
import ui.activity.AppSelectedActivity;
import ui.activity.ReportAppAddActivity;
import ui.callview.ReportAppView;
import ui.model.OSSModelPresent;
import util.e2;
import util.g2;
import util.p1;
import util.t1;

/* JADX INFO: loaded from: classes2.dex */
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

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b */
            public TextView f14376b;

            /* JADX INFO: renamed from: c */
            public TextView f14377c;

            /* JADX INFO: renamed from: d */
            public TextView f14378d;

            /* JADX INFO: renamed from: e */
            public View f14379e;

            /* JADX INFO: renamed from: f */
            public View f14380f;

            /* JADX INFO: renamed from: g */
            public ImageView f14381g;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14376b = (TextView) view.findViewById(R.id.tv_app_name);
                this.f14379e = view.findViewById(R.id.ll_app_pkg);
                this.f14377c = (TextView) view.findViewById(R.id.tv_app_pkg);
                this.f14380f = view.findViewById(R.id.ll_app_vers);
                this.f14378d = (TextView) view.findViewById(R.id.tv_app_vers);
                this.f14381g = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, final int i2) {
            if (ReportAppPresenter.this.mAppBeans.size() > 0) {
                SurveyAppBean surveyAppBean = (SurveyAppBean) ReportAppPresenter.this.mAppBeans.get(i2);
                aVar.f14376b.setText(surveyAppBean.getAppName());
                if (g2.p(surveyAppBean.getPackageName())) {
                    aVar.f14379e.setVisibility(8);
                } else {
                    aVar.f14379e.setVisibility(0);
                    aVar.f14377c.setText(surveyAppBean.getPackageName());
                }
                if (g2.p(surveyAppBean.getAppVersion())) {
                    aVar.f14380f.setVisibility(8);
                } else {
                    aVar.f14380f.setVisibility(0);
                    aVar.f14378d.setText(surveyAppBean.getAppVersion());
                }
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
            aVar.f14381g.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onItemDelet(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportAppPresenter.this.mAppBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_app, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(ReportAppPresenter.this.mActivity, (Class<?>) ReportAppAddActivity.class);
            intent.putExtra(p1.C0, ReportAppPresenter.this.caseInfoId);
            intent.putExtra(p1.F0, i2);
            intent.putExtra(p1.f15011c, (Serializable) ReportAppPresenter.this.mAppBeans.get(i2));
            ReportAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(ReportAppPresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(ReportAppPresenter.this.mActivity, (Class<?>) AppSelectedActivity.class);
            intent.putExtra(AppSelectedActivity.f13092h, 2);
            intent.putExtra(p1.f15012d, 2);
            intent.putExtra("extra_select_limite", 1);
            ReportAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(ReportAppPresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(ReportAppPresenter.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    class c extends MiddleSubscriber<APIresult<List<SurveyAppBean>>> {

        class a extends com.google.gson.d0.a<List<SurveyAppBean>> {
            a() {
            }
        }

        c() {
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
        protected void onNextMiddle(APIresult<List<SurveyAppBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    class d extends MiddleSubscriber<APIresult> {
        final /* synthetic */ int a;

        d(int i2) {
            this.a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(this.a, null);
            }
        }
    }

    class e extends MiddleSubscriber<APIresult> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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

    class f implements IOssPicCallback {
        final /* synthetic */ BlockFileBean a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f14384b;

        f(BlockFileBean blockFileBean, int i2) {
            this.a = blockFileBean;
            this.f14384b = i2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onFailRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.a.setFilePath(ossFileInfo.getFilePath());
                this.a.setFileMd5(ossFileInfo.getFileMd5());
                this.a.setFileSHA1(ossFileInfo.getFileSHA1());
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(this.f14384b, null);
            }
        }
    }

    public ReportAppPresenter(Activity activity, String str, ReportAppView reportAppView) {
        super(activity, reportAppView);
        this.mAppBeans = new ArrayList();
        this.caseInfoId = str;
    }

    private String getMd5(String str, String str2) {
        return TextUtils.isEmpty(str) ? t1.a(new File(str2)) : str;
    }

    private void httpHandleApp(SurveyAppBean surveyAppBean, int i2) {
        surveyCaseApp(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.O1), surveyAppBean, new d(i2));
    }

    public void addAppCheck() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a());
    }

    public void addPicCheck() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new b());
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
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.P1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        deleteCaseAppInfo(strB, map, new e());
    }

    public void getSurveyAppList(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getSurveyAppList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.N1), map, new c());
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
        upFileToOss(ossFileRequest, new f(blockFileBean, i2));
    }
}
