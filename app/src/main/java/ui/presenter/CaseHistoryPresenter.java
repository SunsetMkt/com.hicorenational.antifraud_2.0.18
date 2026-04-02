package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.http.RegionConfigHttp;
import ui.callview.CaseHistoryCallView;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class CaseHistoryPresenter extends ModelPresent<CaseHistoryCallView> {
    private HolderAdapte mAdapter;
    private List<ReplyBean> mData;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b */
            public View f14288b;

            /* JADX INFO: renamed from: c */
            public TextView f14289c;

            /* JADX INFO: renamed from: d */
            public TextView f14290d;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.v_top);
                this.f14288b = view.findViewById(R.id.v_bottom);
                this.f14289c = (TextView) view.findViewById(R.id.tv_content);
                this.f14290d = (TextView) view.findViewById(R.id.tv_time);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, int i2) {
            if (CaseHistoryPresenter.this.mData.size() > 0) {
                if (i2 == 0) {
                    aVar.a.setVisibility(8);
                } else {
                    aVar.a.setVisibility(0);
                }
                if (i2 == CaseHistoryPresenter.this.mData.size() - 1) {
                    aVar.f14288b.setVisibility(8);
                } else {
                    aVar.f14288b.setVisibility(0);
                }
                ReplyBean replyBean = (ReplyBean) CaseHistoryPresenter.this.mData.get(i2);
                if (replyBean != null) {
                    aVar.f14289c.setText(replyBean.getContent());
                    aVar.f14290d.setText(replyBean.getReplyTime());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CaseHistoryPresenter.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_records_reply, viewGroup, false));
        }
    }

    class a extends MiddleSubscriber<APIresult<CaseDetailBean>> {
        a() {
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
            e2.e(aPIException.getMessage());
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

    class b extends com.google.gson.d0.a<ArrayList<StopPaymentBean>> {
        b() {
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            e2.e(aPIException.getMessage());
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

    class d extends MiddleSubscriber<APIresult> {
        d() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            e2.e(aPIException.getMessage());
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
        String strB = e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.T0);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getDetail(strB, map, new a());
    }

    public void initRecycler(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void returnCase(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        getOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.V0), map, new d());
    }

    public void setListData(List<ReplyBean> list) {
        if (list != null) {
            this.mData = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void submitCase(String str, ArrayList<AccountListBean> arrayList) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        map.put("areaCode", RegionConfigHttp.getNodeRegionId());
        if (arrayList != null && arrayList.size() > 0) {
            com.google.gson.e eVar = new com.google.gson.e();
            map.put("stopPayments", (ArrayList) eVar.a(eVar.a(arrayList), new b().getType()));
        }
        getOperation(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.U0), map, new c());
    }
}
