package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReplyBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ReportRecordsReplyCallview;
import ui.model.ModelPresent;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class ReportRecordsReplyPresenter extends ModelPresent<ReportRecordsReplyCallview> {
    private HolderAdapte mAdapter;
    private List<ReplyBean> mData;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b */
            public View f14407b;

            /* JADX INFO: renamed from: c */
            public TextView f14408c;

            /* JADX INFO: renamed from: d */
            public TextView f14409d;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.v_top);
                this.f14407b = view.findViewById(R.id.v_bottom);
                this.f14408c = (TextView) view.findViewById(R.id.tv_content);
                this.f14409d = (TextView) view.findViewById(R.id.tv_time);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(a aVar, int i2) {
            if (ReportRecordsReplyPresenter.this.mData.size() > 0) {
                if (i2 == 0) {
                    aVar.a.setVisibility(8);
                } else {
                    aVar.a.setVisibility(0);
                }
                if (i2 == ReportRecordsReplyPresenter.this.mData.size() - 1) {
                    aVar.f14407b.setVisibility(8);
                } else {
                    aVar.f14407b.setVisibility(0);
                }
                ReplyBean replyBean = (ReplyBean) ReportRecordsReplyPresenter.this.mData.get(i2);
                if (replyBean != null) {
                    aVar.f14408c.setText(replyBean.getContent());
                    aVar.f14409d.setText(replyBean.getReplyTime());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportRecordsReplyPresenter.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_records_reply, viewGroup, false));
        }
    }

    class a extends MiddleSubscriber<APIresult<List<ReplyBean>>> {

        /* JADX INFO: renamed from: ui.presenter.ReportRecordsReplyPresenter$a$a */
        class C0312a extends com.google.gson.d0.a<List<ReplyBean>> {
            C0312a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0312a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportRecordsReplyCallview) ReportRecordsReplyPresenter.this.mvpView).onfailRequest();
            e2.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<ReplyBean>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((ReportRecordsReplyCallview) ReportRecordsReplyPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public ReportRecordsReplyPresenter(Activity activity, ReportRecordsReplyCallview reportRecordsReplyCallview) {
        super(activity, reportRecordsReplyCallview);
        this.mData = new ArrayList();
    }

    public void getReply(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getReply(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.g2), map, new a());
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<ReplyBean> list) {
        if (list != null) {
            this.mData = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
