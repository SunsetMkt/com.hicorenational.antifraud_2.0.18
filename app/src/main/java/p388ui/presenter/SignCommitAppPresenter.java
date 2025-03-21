package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SurveyAppBean;
import bean.module.ModuelConfig;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
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
import p388ui.activity.SignAppDetailActivity;
import p388ui.callview.ReportAppView;
import p388ui.model.ModelPresent;
import p388ui.presenter.SignCommitAppPresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;

/* loaded from: classes2.dex */
public class SignCommitAppPresenter extends ModelPresent<ReportAppView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyAppBean> mAppBeans;

    public class HolderAdapte extends RecyclerView.Adapter<C7082a> {

        /* renamed from: a */
        private Context f24297a;

        /* renamed from: ui.presenter.SignCommitAppPresenter$HolderAdapte$a */
        class C7082a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24299a;

            /* renamed from: b */
            public TextView f24300b;

            /* renamed from: c */
            public TextView f24301c;

            /* renamed from: d */
            public TextView f24302d;

            /* renamed from: e */
            public View f24303e;

            /* renamed from: f */
            public View f24304f;

            /* renamed from: g */
            public ImageView f24305g;

            public C7082a(View view) {
                super(view);
                this.f24299a = view.findViewById(C2113R.id.fl_view);
                this.f24300b = (TextView) view.findViewById(C2113R.id.tv_app_name);
                this.f24303e = view.findViewById(C2113R.id.ll_app_pkg);
                this.f24304f = view.findViewById(C2113R.id.ll_app_vers);
                this.f24301c = (TextView) view.findViewById(C2113R.id.tv_app_pkg);
                this.f24302d = (TextView) view.findViewById(C2113R.id.tv_app_vers);
                this.f24305g = (ImageView) view.findViewById(C2113R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f24297a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7082a c7082a, final int i2) {
            c7082a.f24305g.setVisibility(8);
            if (SignCommitAppPresenter.this.mAppBeans.size() > 0) {
                SurveyAppBean surveyAppBean = (SurveyAppBean) SignCommitAppPresenter.this.mAppBeans.get(i2);
                c7082a.f24300b.setText(surveyAppBean.getAppName());
                if (C7337y1.m26791p(surveyAppBean.getPackageName())) {
                    c7082a.f24303e.setVisibility(8);
                } else {
                    c7082a.f24303e.setVisibility(0);
                    c7082a.f24301c.setText(surveyAppBean.getPackageName());
                }
                if (C7337y1.m26791p(surveyAppBean.getAppVersion())) {
                    c7082a.f24304f.setVisibility(8);
                } else {
                    c7082a.f24304f.setVisibility(0);
                    c7082a.f24302d.setText(surveyAppBean.getAppVersion());
                }
            }
            c7082a.f24299a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SignCommitAppPresenter.HolderAdapte.this.m25665a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitAppPresenter.this.mAppBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7082a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7082a(LayoutInflater.from(this.f24297a).inflate(C2113R.layout.item_report_app, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25665a(int i2, View view) {
            Intent intent = new Intent(SignCommitAppPresenter.this.mActivity, (Class<?>) SignAppDetailActivity.class);
            intent.putExtra(C7292k1.f25338C0, SignCommitAppPresenter.this.caseInfoId);
            intent.putExtra(C7292k1.f25391c, (Serializable) SignCommitAppPresenter.this.mAppBeans.get(i2));
            SignCommitAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.SignCommitAppPresenter$a */
    class C7083a extends MiddleSubscriber<APIresult<List<SurveyAppBean>>> {

        /* renamed from: ui.presenter.SignCommitAppPresenter$a$a */
        class a extends C2049a<List<SurveyAppBean>> {
            a() {
            }
        }

        C7083a() {
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
                ((ReportAppView) SignCommitAppPresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((ReportAppView) SignCommitAppPresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    public SignCommitAppPresenter(Activity activity, String str, ReportAppView reportAppView) {
        super(activity, reportAppView);
        this.mAppBeans = new ArrayList();
        this.caseInfoId = str;
    }

    private void httpReportAppList(HashMap<String, String> hashMap) {
        getSurveyAppList(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17023M1), hashMap, new C7083a());
    }

    public void getReportAppList(String str) {
        C7257b1.m26203a("请稍后...", true, this.mActivity);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        httpReportAppList(hashMap);
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
}
