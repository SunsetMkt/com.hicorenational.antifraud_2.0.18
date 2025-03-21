package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
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
import p388ui.activity.SignWebsitDetialActivity;
import p388ui.callview.SignCommitWebsitView;
import p388ui.model.ModelPresent;
import p388ui.presenter.SignCommitWebsitePresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class SignCommitWebsitePresenter extends ModelPresent<SignCommitWebsitView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<ReportWebsitBean> websits;

    public class HolderAdapte extends RecyclerView.Adapter<C7087a> {

        /* renamed from: a */
        private Context f24323a;

        /* renamed from: ui.presenter.SignCommitWebsitePresenter$HolderAdapte$a */
        class C7087a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24325a;

            /* renamed from: b */
            public TextView f24326b;

            public C7087a(View view) {
                super(view);
                this.f24325a = view.findViewById(C2113R.id.fl_view);
                this.f24326b = (TextView) view.findViewById(C2113R.id.tv_weburl);
            }
        }

        public HolderAdapte(Context context) {
            this.f24323a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7087a c7087a, final int i2) {
            if (SignCommitWebsitePresenter.this.websits.size() > 0) {
                c7087a.f24326b.setText(((ReportWebsitBean) SignCommitWebsitePresenter.this.websits.get(i2)).getUrl());
            }
            c7087a.f24325a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SignCommitWebsitePresenter.HolderAdapte.this.m25669a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitWebsitePresenter.this.websits.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7087a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7087a(LayoutInflater.from(this.f24323a).inflate(C2113R.layout.item_report_url_priview, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25669a(int i2, View view) {
            Intent intent = new Intent(SignCommitWebsitePresenter.this.mActivity, (Class<?>) SignWebsitDetialActivity.class);
            intent.putExtra(C7292k1.f25338C0, SignCommitWebsitePresenter.this.caseInfoId);
            intent.putExtra(C7292k1.f25391c, (Serializable) SignCommitWebsitePresenter.this.websits.get(i2));
            SignCommitWebsitePresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.SignCommitWebsitePresenter$a */
    class C7088a extends MiddleSubscriber<APIresult<List<ReportWebsitBean>>> {

        /* renamed from: ui.presenter.SignCommitWebsitePresenter$a$a */
        class a extends C2049a<List<ReportWebsitBean>> {
            a() {
            }
        }

        C7088a() {
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
        protected void onNextMiddle(APIresult<List<ReportWebsitBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((SignCommitWebsitView) SignCommitWebsitePresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((SignCommitWebsitView) SignCommitWebsitePresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    public SignCommitWebsitePresenter(Activity activity, String str, SignCommitWebsitView signCommitWebsitView) {
        super(activity, signCommitWebsitView);
        this.websits = new ArrayList();
        this.caseInfoId = str;
    }

    public void getSurveyWebList(String str) {
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17059Y1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getSurveyWebList(m16395a, hashMap, new C7088a());
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<ReportWebsitBean> list) {
        this.websits = list;
        this.mAdapter.notifyDataSetChanged();
    }
}
