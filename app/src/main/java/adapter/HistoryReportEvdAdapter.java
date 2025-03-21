package adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import network.HistoryListInfo;
import p245d.C4440a;

/* loaded from: classes.dex */
public class HistoryReportEvdAdapter extends BaseQuickAdapter<HistoryListInfo.RowsBean, BaseViewHolder> {

    /* renamed from: V */
    private List<HistoryListInfo.RowsBean> f217V;

    /* renamed from: W */
    private InterfaceC0065b f218W;

    /* renamed from: X */
    private boolean f219X;

    /* renamed from: adapter.HistoryReportEvdAdapter$a */
    class ViewOnClickListenerC0064a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f220a;

        ViewOnClickListenerC0064a(int i2) {
            this.f220a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HistoryReportEvdAdapter.this.f218W != null) {
                HistoryListInfo.RowsBean rowsBean = (HistoryListInfo.RowsBean) HistoryReportEvdAdapter.this.f217V.get(this.f220a);
                HistoryReportEvdAdapter.this.f218W.onItemClickListener(rowsBean);
                rowsBean.getInfo().setRedPoint(0);
                HistoryReportEvdAdapter.this.notifyItemChanged(this.f220a);
            }
        }
    }

    /* renamed from: adapter.HistoryReportEvdAdapter$b */
    public interface InterfaceC0065b {
        void onItemClickListener(HistoryListInfo.RowsBean rowsBean);
    }

    public HistoryReportEvdAdapter(List<HistoryListInfo.RowsBean> list) {
        super(C2113R.layout.item_history_report, list);
        this.f219X = false;
        this.f217V = list;
        this.f219X = C4440a.m16409k();
    }

    public void setOnItemClickListener(InterfaceC0065b interfaceC0065b) {
        this.f218W = interfaceC0065b;
    }

    /* renamed from: a */
    public void m244a(List<HistoryListInfo.RowsBean> list) {
        this.f217V.clear();
        this.f217V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, HistoryListInfo.RowsBean rowsBean) {
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_self);
        TextView textView2 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_case_num);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_dk_tag);
        TextView textView3 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_reply);
        TextView textView4 = (TextView) baseViewHolder.m5224c(C2113R.id.red_tip);
        HistoryListInfo.RowsBean.DetailsBean info = rowsBean.getInfo();
        String evidenceCount = rowsBean.getEvidenceCount();
        info.getCaseNumber();
        String caseCategoryText = info.getCaseCategoryText();
        String caseDescription = info.getCaseDescription();
        String submitTime = info.getSubmitTime();
        info.getRegion();
        if (TextUtils.isEmpty(caseCategoryText)) {
            caseCategoryText = "其他诈骗";
        }
        baseViewHolder.m5211a(C2113R.id.casecategory, (CharSequence) caseCategoryText);
        baseViewHolder.m5211a(C2113R.id.report_size, (CharSequence) ("(" + evidenceCount + "项举报内容)"));
        TextUtils.isEmpty(caseDescription);
        baseViewHolder.m5211a(C2113R.id.report_time, (CharSequence) submitTime);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        imageView.setVisibility(8);
        if (info.getRedPoint() == 1) {
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        if (this.f219X) {
            if (info.getReplyStatus() == 1) {
                textView3.setText("待受理");
                textView3.setTextColor(Color.parseColor("#999999"));
                return;
            } else if (info.getReplyStatus() == 2) {
                textView3.setText("已受理");
                textView3.setTextColor(Color.parseColor("#999999"));
                return;
            } else {
                if (info.getReplyStatus() == 3) {
                    textView3.setText("已回复");
                    textView3.setTextColor(Color.parseColor("#2CAF28"));
                    return;
                }
                return;
            }
        }
        textView3.setVisibility(8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, @SuppressLint({"RecyclerView"}) int i2) {
        super.onBindViewHolder((HistoryReportEvdAdapter) baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0064a(i2));
    }
}
