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
import p388ui.activity.ReportWebsiteAddActivity;
import p388ui.callview.ReportWebView;
import p388ui.model.ModelPresent;
import p388ui.presenter.ReportWebsitePresenter;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ReportWebsitePresenter extends ModelPresent<ReportWebView> {
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<ReportWebsitBean> websits;

    public class HolderAdapte extends RecyclerView.Adapter<C7077a> {

        /* renamed from: a */
        private Context f24286a;

        /* renamed from: ui.presenter.ReportWebsitePresenter$HolderAdapte$a */
        class C7077a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24288a;

            /* renamed from: b */
            public TextView f24289b;

            /* renamed from: c */
            public ImageView f24290c;

            public C7077a(View view) {
                super(view);
                this.f24288a = view.findViewById(C2113R.id.fl_view);
                this.f24289b = (TextView) view.findViewById(C2113R.id.tv_weburl);
                this.f24290c = (ImageView) view.findViewById(C2113R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f24286a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7077a c7077a, final int i2) {
            if (ReportWebsitePresenter.this.websits.size() > 0) {
                c7077a.f24289b.setText(((ReportWebsitBean) ReportWebsitePresenter.this.websits.get(i2)).getUrl());
            }
            c7077a.f24288a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportWebsitePresenter.HolderAdapte.this.m25659a(i2, view);
                }
            });
            c7077a.f24290c.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportWebsitePresenter.HolderAdapte.this.m25661b(i2, view);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m25661b(int i2, View view) {
            ((ReportWebView) ReportWebsitePresenter.this.mvpView).onItemDelet(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportWebsitePresenter.this.websits.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7077a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7077a(LayoutInflater.from(this.f24286a).inflate(C2113R.layout.item_report_url, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25659a(int i2, View view) {
            Intent intent = new Intent(ReportWebsitePresenter.this.mActivity, (Class<?>) ReportWebsiteAddActivity.class);
            intent.putExtra(C7292k1.f25338C0, ReportWebsitePresenter.this.caseInfoId);
            intent.putExtra(C7292k1.f25391c, (Serializable) ReportWebsitePresenter.this.websits.get(i2));
            ReportWebsitePresenter.this.mActivity.startActivity(intent);
        }
    }

    /* renamed from: ui.presenter.ReportWebsitePresenter$a */
    class C7078a extends MiddleSubscriber<APIresult<List<ReportWebsitBean>>> {

        /* renamed from: ui.presenter.ReportWebsitePresenter$a$a */
        class a extends C2049a<List<ReportWebsitBean>> {
            a() {
            }
        }

        C7078a() {
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
            if (aPIresult != null && aPIresult.getCode() == 0 && aPIresult.getData() != null) {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(1, aPIresult.getData());
            } else {
                ((ReportWebView) ReportWebsitePresenter.this.mvpView).onSuccessHandle(1, new ArrayList());
                aPIresult.getMsg();
            }
        }
    }

    /* renamed from: ui.presenter.ReportWebsitePresenter$b */
    class C7079b extends MiddleSubscriber<APIresult> {
        C7079b() {
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
        C7257b1.m26193a(this.mActivity, "请稍等...");
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17066a2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoId", str);
        hashMap.put("urlInfoID", str2);
        deleteCaseWebUrl(m16395a, hashMap, new C7079b());
    }

    public void getSurveyWebList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17059Y1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("caseInfoID", str);
        getSurveyWebList(m16395a, hashMap, new C7078a());
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
