package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.SignAppDetailActivity;
import ui.callview.ReportAppView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.g2;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class SignCommitAppPresenter extends ModelPresent<ReportAppView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyAppBean> mAppBeans;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextView f14416b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public TextView f14417c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public TextView f14418d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public View f14419e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public View f14420f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public ImageView f14421g;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14416b = (TextView) view.findViewById(R.id.tv_app_name);
                this.f14419e = view.findViewById(R.id.ll_app_pkg);
                this.f14420f = view.findViewById(R.id.ll_app_vers);
                this.f14417c = (TextView) view.findViewById(R.id.tv_app_pkg);
                this.f14418d = (TextView) view.findViewById(R.id.tv_app_vers);
                this.f14421g = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            aVar.f14421g.setVisibility(8);
            if (SignCommitAppPresenter.this.mAppBeans.size() > 0) {
                SurveyAppBean surveyAppBean = (SurveyAppBean) SignCommitAppPresenter.this.mAppBeans.get(i2);
                aVar.f14416b.setText(surveyAppBean.getAppName());
                if (g2.p(surveyAppBean.getPackageName())) {
                    aVar.f14419e.setVisibility(8);
                } else {
                    aVar.f14419e.setVisibility(0);
                    aVar.f14417c.setText(surveyAppBean.getPackageName());
                }
                if (g2.p(surveyAppBean.getAppVersion())) {
                    aVar.f14420f.setVisibility(8);
                } else {
                    aVar.f14420f.setVisibility(0);
                    aVar.f14418d.setText(surveyAppBean.getAppVersion());
                }
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitAppPresenter.this.mAppBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_app, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(SignCommitAppPresenter.this.mActivity, (Class<?>) SignAppDetailActivity.class);
            intent.putExtra(p1.C0, SignCommitAppPresenter.this.caseInfoId);
            intent.putExtra(p1.f15011c, (Serializable) SignCommitAppPresenter.this.mAppBeans.get(i2));
            SignCommitAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<SurveyAppBean>>> {

        /* JADX INFO: renamed from: ui.presenter.SignCommitAppPresenter$a$a, reason: collision with other inner class name */
        class C0314a extends com.google.gson.d0.a<List<SurveyAppBean>> {
            C0314a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0314a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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

    private void httpReportAppList(HashMap<String, String> map) {
        getSurveyAppList(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.N1), map, new a());
    }

    public void getReportAppList(String str) {
        f1.a("\u8bf7\u7a0d\u540e...", true, this.mActivity);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        httpReportAppList(map);
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
