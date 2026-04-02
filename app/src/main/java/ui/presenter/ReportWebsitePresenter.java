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
import ui.activity.ReportWebsiteAddActivity;
import ui.callview.ReportWebView;
import ui.model.ModelPresent;
import util.e2;
import util.f1;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class ReportWebsitePresenter extends ModelPresent<ReportWebView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<ReportWebsitBean> websits;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextView f14412b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ImageView f14413c;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14412b = (TextView) view.findViewById(R.id.tv_weburl);
                this.f14413c = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            if (ReportWebsitePresenter.this.websits.size() > 0) {
                aVar.f14412b.setText(((ReportWebsitBean) ReportWebsitePresenter.this.websits.get(i2)).getUrl());
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
            aVar.f14413c.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((ReportWebView) ReportWebsitePresenter.this.mvpView).onItemDelet(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportWebsitePresenter.this.websits.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_url, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(ReportWebsitePresenter.this.mActivity, (Class<?>) ReportWebsiteAddActivity.class);
            intent.putExtra(p1.C0, ReportWebsitePresenter.this.caseInfoId);
            intent.putExtra(p1.f15011c, (Serializable) ReportWebsitePresenter.this.websits.get(i2));
            ReportWebsitePresenter.this.mActivity.startActivity(intent);
        }
    }

    class a extends MiddleSubscriber<APIresult<List<ReportWebsitBean>>> {

        /* JADX INFO: renamed from: ui.presenter.ReportWebsitePresenter$a$a, reason: collision with other inner class name */
        class C0313a extends com.google.gson.d0.a<List<ReportWebsitBean>> {
            C0313a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0313a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<ReportWebsitBean>> aPIresult) {
            if (aPIresult != null && aPIresult.getCode() == 0 && aPIresult.getData() != null) {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            } else {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
                aPIresult.getMsg();
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
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
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(4, null);
            }
        }
    }

    public ReportWebsitePresenter(Activity activity, String str, ReportWebView reportWebView) {
        super(activity, reportWebView);
        this.websits = new ArrayList();
        this.caseInfoId = str;
    }

    public void deleteCaseWebUrl(String str, String str2) {
        f1.a(this.mActivity, "\u8bf7\u7a0d\u7b49...");
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.b2);
        HashMap<String, String> map = new HashMap<>();
        map.put("caseInfoId", str);
        map.put("urlInfoID", str2);
        deleteCaseWebUrl(strB, map, new b());
    }

    public void getSurveyWebList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
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
