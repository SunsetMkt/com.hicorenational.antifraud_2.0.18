package adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import bean.CaseHistoryBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p245d.C4440a;

/* loaded from: classes.dex */
public class CaseOverAdapter extends BaseQuickAdapter<CaseHistoryBean.Rows, BaseViewHolder> {

    /* renamed from: V */
    private boolean f186V;

    public CaseOverAdapter(List<CaseHistoryBean.Rows> list) {
        super(C2113R.layout.item_case_over, list);
        this.f186V = false;
        this.f186V = C4440a.m16409k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CaseHistoryBean.Rows rows) {
        baseViewHolder.m5211a(C2113R.id.tv_case_name, (CharSequence) rows.getCaseName()).m5211a(C2113R.id.tv_case_victim, (CharSequence) rows.getName()).m5211a(C2113R.id.tv_victim_id, (CharSequence) rows.getDocumentNumber()).m5211a(C2113R.id.tv_case_time, (CharSequence) rows.getProcessTime());
        if (!TextUtils.isEmpty(rows.getDocumentTypeText())) {
            baseViewHolder.m5211a(C2113R.id.tv_victim_id_label, (CharSequence) ("证件号 (" + rows.getDocumentTypeText() + ")："));
        }
        if (rows.getStopPaymentCount() > 0) {
            baseViewHolder.m5224c(C2113R.id.group_stop_payment).setVisibility(0);
            baseViewHolder.m5211a(C2113R.id.tv_stop_payment, (CharSequence) (rows.getStopPaymentCount() + ""));
        } else {
            baseViewHolder.m5224c(C2113R.id.group_stop_payment).setVisibility(8);
        }
        if (!this.f186V) {
            baseViewHolder.m5226c(C2113R.id.ll_reply, false);
            return;
        }
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_reply);
        if (rows.getReplyStatus() > 0) {
            textView.setText("已反馈");
            textView.setTextColor(Color.parseColor("#2CAF28"));
        } else {
            textView.setText("待反馈");
            textView.setTextColor(this.f5580x.getResources().getColor(C2113R.color.colorGray));
        }
        baseViewHolder.m5226c(C2113R.id.ll_reply, true);
    }
}
