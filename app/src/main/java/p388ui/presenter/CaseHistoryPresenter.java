package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import bean.CaseDetailBean;
import bean.ReplyBean;
import bean.StopPaymentBean;
import bean.module.ModuelConfig;
import com.google.gson.C2051e;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.CaseHistoryCallView;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class CaseHistoryPresenter extends ModelPresent<CaseHistoryCallView> {
    private HolderAdapte mAdapter;
    private List<ReplyBean> mData;

    public class HolderAdapte extends RecyclerView.Adapter<C6937a> {

        /* renamed from: a */
        private Context f23992a;

        /* renamed from: ui.presenter.CaseHistoryPresenter$HolderAdapte$a */
        class C6937a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f23994a;

            /* renamed from: b */
            public View f23995b;

            /* renamed from: c */
            public TextView f23996c;

            /* renamed from: d */
            public TextView f23997d;

            public C6937a(View view) {
                super(view);
                this.f23994a = view.findViewById(C2113R.id.v_top);
                this.f23995b = view.findViewById(C2113R.id.v_bottom);
                this.f23996c = (TextView) view.findViewById(C2113R.id.tv_content);
                this.f23997d = (TextView) view.findViewById(C2113R.id.tv_time);
            }
        }

        public HolderAdapte(Context context) {
            this.f23992a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C6937a c6937a, int i2) {
            if (CaseHistoryPresenter.this.mData.size() > 0) {
                if (i2 == 0) {
                    c6937a.f23994a.setVisibility(8);
                } else {
                    c6937a.f23994a.setVisibility(0);
                }
                if (i2 == CaseHistoryPresenter.this.mData.size() - 1) {
                    c6937a.f23995b.setVisibility(8);
                } else {
                    c6937a.f23995b.setVisibility(0);
                }
                ReplyBean replyBean = (ReplyBean) CaseHistoryPresenter.this.mData.get(i2);
                if (replyBean != null) {
                    c6937a.f23996c.setText(replyBean.getContent());
                    c6937a.f23997d.setText(replyBean.getReplyTime());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CaseHistoryPresenter.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C6937a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C6937a(LayoutInflater.from(this.f23992a).inflate(C2113R.layout.item_report_records_reply, viewGroup, false));
        }
    }

    /* renamed from: ui.presenter.CaseHistoryPresenter$a */
    class C6938a extends MiddleSubscriber<APIresult<CaseDetailBean>> {
        C6938a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return CaseDetailBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<CaseDetailBean> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseHistoryCallView) CaseHistoryPresenter.this.mvpView).onSuccessDetail(aPIresult.getData());
            }
        }
    }

    /* renamed from: ui.presenter.CaseHistoryPresenter$b */
    class C6939b extends C2049a<ArrayList<StopPaymentBean>> {
        C6939b() {
        }
    }

    /* renamed from: ui.presenter.CaseHistoryPresenter$c */
    class C6940c extends MiddleSubscriber<APIresult> {
        C6940c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseHistoryCallView) CaseHistoryPresenter.this.mvpView).onSuccessCommit();
            }
        }
    }

    /* renamed from: ui.presenter.CaseHistoryPresenter$d */
    class C6941d extends MiddleSubscriber<APIresult> {
        C6941d() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((CaseHistoryCallView) CaseHistoryPresenter.this.mvpView).onSuccessBack();
            }
        }
    }

    public CaseHistoryPresenter(Activity activity, CaseHistoryCallView caseHistoryCallView) {
        super(activity, caseHistoryCallView);
        this.mData = new ArrayList();
    }

    public void getDetail(String str) {
        String m16395a = C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17040S0);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getDetail(m16395a, hashMap, new C6938a());
    }

    public void initRecycler(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void returnCase(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", str);
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17046U0), hashMap, new C6941d());
    }

    public void setListData(List<ReplyBean> list) {
        if (list != null) {
            this.mData = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void submitCase(String str, ArrayList<AccountListBean> arrayList) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", str);
        hashMap.put("areaCode", RegionConfigHttp.getNodeRegionId());
        if (arrayList != null && arrayList.size() > 0) {
            C2051e c2051e = new C2051e();
            hashMap.put("stopPayments", (ArrayList) c2051e.m5570a(c2051e.m5572a(arrayList), new C6939b().getType()));
        }
        getOperation(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17043T0), hashMap, new C6940c());
    }
}
