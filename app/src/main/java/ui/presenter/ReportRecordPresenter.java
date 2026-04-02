package ui.presenter;

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
import com.hicorenational.antifraud.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.ReportCaseInfoActivity;
import ui.activity.ReportRecordsReplyActivity;
import ui.callview.ReportRecordView;
import ui.model.ModelPresent;
import util.e2;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class ReportRecordPresenter extends ModelPresent<ReportRecordView> {
    private List<ReportCaseBean.RowsBean> caseBeans;
    private boolean hasLocal;
    private HolderAdapte mAdapter;

    public class HolderAdapte extends RecyclerView.Adapter<a> {
        private Context a;

        class a extends RecyclerView.ViewHolder {
            public View a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public View f14396b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public TextView f14397c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public TextView f14398d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public TextView f14399e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public TextView f14400f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public TextView f14401g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public ImageView f14402h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public TextView f14403i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public TextView f14404j;

            public a(View view) {
                super(view);
                this.a = view.findViewById(R.id.fl_view);
                this.f14397c = (TextView) view.findViewById(R.id.tv_case_name);
                this.f14398d = (TextView) view.findViewById(R.id.tv_victim_name);
                this.f14399e = (TextView) view.findViewById(R.id.tv_id_type);
                this.f14400f = (TextView) view.findViewById(R.id.tv_peop_idcard);
                this.f14401g = (TextView) view.findViewById(R.id.tv_peop_time);
                this.f14402h = (ImageView) view.findViewById(R.id.iv_item_tips);
                this.f14396b = view.findViewById(R.id.ll_red_state);
                this.f14403i = (TextView) view.findViewById(R.id.red_tip);
                this.f14404j = (TextView) view.findViewById(R.id.tv_reply);
            }
        }

        public HolderAdapte(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            ReportCaseBean.RowsBean rowsBean;
            if (ReportRecordPresenter.this.caseBeans.size() > 0 && (rowsBean = (ReportCaseBean.RowsBean) ReportRecordPresenter.this.caseBeans.get(i2)) != null) {
                aVar.f14397c.setText(rowsBean.getCaseName());
                aVar.f14398d.setText(TextUtils.isEmpty(rowsBean.getName()) ? "\u672a\u586b\u5199" : rowsBean.getName());
                if (TextUtils.isEmpty(rowsBean.getDocumentNumber())) {
                    aVar.f14399e.setText("\u8bc1\u4ef6\u53f7");
                    aVar.f14400f.setText("\u672a\u586b\u5199");
                } else {
                    aVar.f14399e.setText("\u8bc1\u4ef6\u53f7 (" + rowsBean.getDocumentTypeText() + ")\uff1a ");
                    aVar.f14400f.setText(rowsBean.getDocumentNumber());
                }
                aVar.f14401g.setText(rowsBean.getProcessTime());
                aVar.f14396b.setVisibility(8);
                if (rowsBean.getStatus() == 0 || rowsBean.getStatus() == 3 || rowsBean.getStatus() == 5) {
                    aVar.f14402h.setImageResource(R.drawable.iv_case_comit);
                    if (ReportRecordPresenter.this.hasLocal) {
                        aVar.f14396b.setVisibility(0);
                        if (rowsBean.getReplyStatus() > 0) {
                            aVar.f14404j.setText("\u5df2\u53cd\u9988");
                            aVar.f14404j.setTextColor(Color.parseColor("#2CAF28"));
                            if (rowsBean.getRedPoint() > 0) {
                                aVar.f14403i.setVisibility(0);
                            } else {
                                aVar.f14403i.setVisibility(8);
                            }
                        } else {
                            aVar.f14404j.setText("\u5f85\u53cd\u9988");
                            aVar.f14404j.setTextColor(ReportRecordPresenter.this.mActivity.getResources().getColor(R.color.colorGray));
                        }
                    } else {
                        aVar.f14396b.setVisibility(8);
                    }
                } else if (rowsBean.getStatus() == 6) {
                    aVar.f14402h.setImageResource(R.drawable.iv_case_back);
                }
                if (rowsBean.getIsExpired() == 1) {
                    aVar.f14402h.setImageResource(R.drawable.ic_case_exprd);
                    aVar.f14396b.setVisibility(8);
                }
            }
            aVar.a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportRecordPresenter.this.caseBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.item_report_record, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
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
                intent.putExtra(p1.C0, rowsBean.getId());
                ReportRecordPresenter.this.mActivity.startActivity(intent);
            }
        }
    }

    class a extends MiddleSubscriber<APIresult<ReportCaseBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportCaseBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ReportRecordView) ReportRecordPresenter.this.mvpView).onfailRequest();
            e2.a(aPIException.getMessage());
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
        this.hasLocal = e.a.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onsuccessReportID(ReportCaseBean.RowsBean rowsBean) {
        ReportIDInfoBean reportIDInfoBean = new ReportIDInfoBean();
        reportIDInfoBean.setCaseName(rowsBean.getCaseName());
        reportIDInfoBean.setCaseNumber(rowsBean.getCaseNumber());
        reportIDInfoBean.setCaseCategoryText(rowsBean.getCaseCategoryText());
        reportIDInfoBean.setProcessTime(rowsBean.getProcessTime());
        Intent intent = new Intent(this.mActivity, (Class<?>) ReportCaseInfoActivity.class);
        intent.putExtra(p1.C0, rowsBean.getId());
        intent.putExtra(p1.f15010b, reportIDInfoBean);
        this.mActivity.startActivity(intent);
        this.mActivity.finish();
    }

    public void initRecyclePeop(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void reportUserCases() {
        reportUserCases(e.a.b(ModuelConfig.MODEL_CASEXC, 4, f.b.e2), new a());
    }

    public void setListData(List<ReportCaseBean.RowsBean> list) {
        if (list != null) {
            this.caseBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
