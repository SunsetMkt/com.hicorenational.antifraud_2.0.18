package p388ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportCaseBean;
import bean.ReportIDInfoBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.C2113R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.activity.ReportCaseInfoActivity;
import p388ui.activity.ReportRecordsReplyActivity;
import p388ui.callview.ReportRecordView;
import p388ui.model.ModelPresent;
import p388ui.presenter.ReportRecordPresenter;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class ReportRecordPresenter extends ModelPresent<ReportRecordView> {
    private List<ReportCaseBean.RowsBean> caseBeans;
    private boolean hasLocal;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<C7073a> {

        /* renamed from: a */
        private Context f24263a;

        /* renamed from: ui.presenter.ReportRecordPresenter$HolderAdapte$a */
        class C7073a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            public View f24265a;

            /* renamed from: b */
            public View f24266b;

            /* renamed from: c */
            public TextView f24267c;

            /* renamed from: d */
            public TextView f24268d;

            /* renamed from: e */
            public TextView f24269e;

            /* renamed from: f */
            public TextView f24270f;

            /* renamed from: g */
            public TextView f24271g;

            /* renamed from: h */
            public ImageView f24272h;

            /* renamed from: i */
            public TextView f24273i;

            /* renamed from: j */
            public TextView f24274j;

            public C7073a(View view) {
                super(view);
                this.f24265a = view.findViewById(C2113R.id.fl_view);
                this.f24267c = (TextView) view.findViewById(C2113R.id.tv_case_name);
                this.f24268d = (TextView) view.findViewById(C2113R.id.tv_victim_name);
                this.f24269e = (TextView) view.findViewById(C2113R.id.tv_id_type);
                this.f24270f = (TextView) view.findViewById(C2113R.id.tv_peop_idcard);
                this.f24271g = (TextView) view.findViewById(C2113R.id.tv_peop_time);
                this.f24272h = (ImageView) view.findViewById(C2113R.id.iv_item_tips);
                this.f24266b = view.findViewById(C2113R.id.ll_red_state);
                this.f24273i = (TextView) view.findViewById(C2113R.id.red_tip);
                this.f24274j = (TextView) view.findViewById(C2113R.id.tv_reply);
            }
        }

        public HolderAdapte(Context context) {
            this.f24263a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C7073a c7073a, final int i2) {
            ReportCaseBean.RowsBean rowsBean;
            if (ReportRecordPresenter.this.caseBeans.size() > 0 && (rowsBean = (ReportCaseBean.RowsBean) ReportRecordPresenter.this.caseBeans.get(i2)) != null) {
                c7073a.f24267c.setText(rowsBean.getCaseName());
                c7073a.f24268d.setText(TextUtils.isEmpty(rowsBean.getName()) ? "未填写" : rowsBean.getName());
                if (TextUtils.isEmpty(rowsBean.getDocumentNumber())) {
                    c7073a.f24269e.setText("证件号");
                    c7073a.f24270f.setText("未填写");
                } else {
                    c7073a.f24269e.setText("证件号 (" + rowsBean.getDocumentTypeText() + ")： ");
                    c7073a.f24270f.setText(rowsBean.getDocumentNumber());
                }
                c7073a.f24271g.setText(rowsBean.getProcessTime());
                c7073a.f24266b.setVisibility(8);
                if (rowsBean.getStatus() == 0 || rowsBean.getStatus() == 3 || rowsBean.getStatus() == 5) {
                    c7073a.f24272h.setImageResource(C2113R.drawable.iv_case_comit);
                    if (ReportRecordPresenter.this.hasLocal) {
                        c7073a.f24266b.setVisibility(0);
                        if (rowsBean.getReplyStatus() > 0) {
                            c7073a.f24274j.setText("已反馈");
                            c7073a.f24274j.setTextColor(Color.parseColor("#2CAF28"));
                            if (rowsBean.getRedPoint() > 0) {
                                c7073a.f24273i.setVisibility(0);
                            } else {
                                c7073a.f24273i.setVisibility(8);
                            }
                        } else {
                            c7073a.f24274j.setText("待反馈");
                            c7073a.f24274j.setTextColor(ReportRecordPresenter.this.mActivity.getResources().getColor(C2113R.color.colorGray));
                        }
                    } else {
                        c7073a.f24266b.setVisibility(8);
                    }
                } else if (rowsBean.getStatus() == 6) {
                    c7073a.f24272h.setImageResource(C2113R.drawable.iv_case_back);
                }
                if (rowsBean.getIsExpired() == 1) {
                    c7073a.f24272h.setImageResource(C2113R.drawable.ic_case_exprd);
                    c7073a.f24266b.setVisibility(8);
                }
            }
            c7073a.f24265a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportRecordPresenter.HolderAdapte.this.m25656a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportRecordPresenter.this.caseBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public C7073a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C7073a(LayoutInflater.from(this.f24263a).inflate(C2113R.layout.item_report_record, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m25656a(int i2, View view) {
            ReportCaseBean.RowsBean rowsBean = (ReportCaseBean.RowsBean) ReportRecordPresenter.this.caseBeans.get(i2);
            if (rowsBean.getIsExpired() == 1) {
                return;
            }
            if (rowsBean.getStatus() == 6) {
                ReportRecordPresenter.this.onsuccessReportID(rowsBean);
                return;
            }
            if ((rowsBean.getStatus() == 0 || rowsBean.getStatus() == 3 || rowsBean.getStatus() == 5) && rowsBean.getReplyStatus() > 0) {
                rowsBean.setRedPoint(1);
                notifyItemChanged(i2);
                Intent intent = new Intent(ReportRecordPresenter.this.mActivity, (Class<?>) ReportRecordsReplyActivity.class);
                intent.putExtra(C7292k1.f25338C0, rowsBean.getId());
                ReportRecordPresenter.this.mActivity.startActivity(intent);
            }
        }
    }

    /* renamed from: ui.presenter.ReportRecordPresenter$a */
    class C7074a extends MiddleSubscriber<APIresult<ReportCaseBean>> {
        C7074a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportCaseBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportRecordView) ReportRecordPresenter.this.mvpView).onfailRequest();
            C7331w1.m26688a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<ReportCaseBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportRecordView) ReportRecordPresenter.this.mvpView).onSuccessRequest(aPIresult.getData());
            }
        }
    }

    public ReportRecordPresenter(Activity activity, ReportRecordView reportRecordView) {
        super(activity, reportRecordView);
        this.caseBeans = new ArrayList();
        this.hasLocal = false;
        this.hasLocal = C4440a.m16409k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onsuccessReportID(ReportCaseBean.RowsBean rowsBean) {
        ReportIDInfoBean reportIDInfoBean = new ReportIDInfoBean();
        reportIDInfoBean.setCaseName(rowsBean.getCaseName());
        reportIDInfoBean.setCaseNumber(rowsBean.getCaseNumber());
        reportIDInfoBean.setCaseCategoryText(rowsBean.getCaseCategoryText());
        reportIDInfoBean.setProcessTime(rowsBean.getProcessTime());
        Intent intent = new Intent(this.mActivity, (Class<?>) ReportCaseInfoActivity.class);
        intent.putExtra(C7292k1.f25338C0, rowsBean.getId());
        intent.putExtra(C7292k1.f25388b, reportIDInfoBean);
        this.mActivity.startActivity(intent);
        this.mActivity.finish();
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void reportUserCases() {
        reportUserCases(C4440a.m16395a(ModuelConfig.MODEL_CASEXC, 4, C4445b.f17078d2), new C7074a());
    }

    public void setListData(List<ReportCaseBean.RowsBean> list) {
        if (list != null) {
            this.caseBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
