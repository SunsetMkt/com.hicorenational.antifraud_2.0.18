package p388ui.presenter;

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
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.ReportRecordsReplyCallview;
import p388ui.model.ModelPresent;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ReportRecordsReplyPresenter extends ModelPresent<ReportRecordsReplyCallview> {
    private HolderAdapte mAdapter;
    private List<ReplyBean> mData;

    public class HolderAdapte extends RecyclerView.Adapter<C7075a> {

        /* renamed from: a */
        private Context f24277a;

        /* renamed from: ui.presenter.ReportRecordsReplyPresenter$HolderAdapte$a */
        class C7075a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24279a;

            /* renamed from: b */
            public View f24280b;

            /* renamed from: c */
            public TextView f24281c;

            /* renamed from: d */
            public TextView f24282d;

            public C7075a(View view) {
                super(view);
                this.f24279a = view.findViewById(C2113R.id.v_top);
                this.f24280b = view.findViewById(C2113R.id.v_bottom);
                this.f24281c = (TextView) view.findViewById(C2113R.id.tv_content);
                this.f24282d = (TextView) view.findViewById(C2113R.id.tv_time);
            }
        }

        public HolderAdapte(Context context) {
            this.f24277a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7075a c7075a, int i2) {
            if (ReportRecordsReplyPresenter.this.mData.size() > 0) {
                if (i2 == 0) {
                    c7075a.f24279a.setVisibility(8);
                } else {
                    c7075a.f24279a.setVisibility(0);
                }
                if (i2 == ReportRecordsReplyPresenter.this.mData.size() - 1) {
                    c7075a.f24280b.setVisibility(8);
                } else {
                    c7075a.f24280b.setVisibility(0);
                }
                ReplyBean replyBean = (ReplyBean) ReportRecordsReplyPresenter.this.mData.get(i2);
                if (replyBean != null) {
                    c7075a.f24281c.setText(replyBean.getContent());
                    c7075a.f24282d.setText(replyBean.getReplyTime());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportRecordsReplyPresenter.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7075a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7075a(LayoutInflater.from(this.f24277a).inflate(C2113R.layout.item_report_records_reply, viewGroup, false));
        }
    }

    /* renamed from: ui.presenter.ReportRecordsReplyPresenter$a */
    class C7076a extends MiddleSubscriber<APIresult<List<ReplyBean>>> {

        /* renamed from: ui.presenter.ReportRecordsReplyPresenter$a$a */
        class a extends C2049a<List<ReplyBean>> {
            a() {
            }
        }

        C7076a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportRecordsReplyCallview) ReportRecordsReplyPresenter.this.mvpView).onfailRequest();
            C7331w1.m26688a(aPIException.getMessage());
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
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", str);
        getReply(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17086f2), hashMap, new C7076a());
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
