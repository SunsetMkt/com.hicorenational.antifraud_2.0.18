package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.SignWebsitDetialActivity;
import ui.callview.SignCommitWebsitView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class SignCommitWebsitePresenter extends ModelPresent<SignCommitWebsitView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<ReportWebsitBean> websits;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextView f14433b;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14433b = (TextView) view.findViewById(R.id.tv_weburl);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            if (SignCommitWebsitePresenter.this.websits.size() > 0) {
                aVar.f14433b.setText(((ReportWebsitBean) SignCommitWebsitePresenter.this.websits.get(i2)).getUrl());
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SignCommitWebsitePresenter.this.websits.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_url_priview, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(SignCommitWebsitePresenter.this.mActivity, (Class<?>) SignWebsitDetialActivity.class);
            intent.putExtra(p1.C0, SignCommitWebsitePresenter.this.caseInfoId);
            intent.putExtra(p1.f15011c, (Serializable) SignCommitWebsitePresenter.this.websits.get(i2));
            SignCommitWebsitePresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<ReportWebsitBean>>> {

        /* JADX INFO: renamed from: ui.presenter.SignCommitWebsitePresenter$a$a, reason: collision with other inner class name */
        class C0316a extends com.google.gson.d0.a<List<ReportWebsitBean>> {
            C0316a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0316a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
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
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.Z1);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoID", str);
        getSurveyWebList(strB, map, new a());
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
