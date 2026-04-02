package adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import bean.CaseHistoryBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseOverAdapter extends BaseQuickAdapter<CaseHistoryBean.Rows, BaseViewHolder> {
    private boolean V;

    public CaseOverAdapter(List<CaseHistoryBean.Rows> list) {
        super(R.layout.item_case_over, list);
        this.V = false;
        this.V = e.a.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, CaseHistoryBean.Rows rows) {
        baseViewHolder.a(R.id.tv_case_name, (CharSequence) rows.getCaseName()).a(R.id.tv_case_victim, (CharSequence) rows.getName()).a(R.id.tv_victim_id, (CharSequence) rows.getDocumentNumber()).a(R.id.tv_case_time, (CharSequence) rows.getProcessTime());
        if (!TextUtils.isEmpty(rows.getDocumentTypeText())) {
            baseViewHolder.a(R.id.tv_victim_id_label, (CharSequence) ("\u8bc1\u4ef6\u53f7 (" + rows.getDocumentTypeText() + ")\uff1a"));
        }
        if (rows.getStopPaymentCount() > 0) {
            baseViewHolder.c(R.id.group_stop_payment).setVisibility(0);
            baseViewHolder.a(R.id.tv_stop_payment, (CharSequence) (rows.getStopPaymentCount() + ""));
        } else {
            baseViewHolder.c(R.id.group_stop_payment).setVisibility(8);
        }
        if (!this.V) {
            baseViewHolder.c(R.id.ll_reply, false);
            return;
        }
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_reply);
        if (rows.getReplyStatus() > 0) {
            textView.setText("\u5df2\u53cd\u9988");
            textView.setTextColor(Color.parseColor("#2CAF28"));
        } else {
            textView.setText("\u5f85\u53cd\u9988");
            textView.setTextColor(this.x.getResources().getColor(R.color.colorGray));
        }
        baseViewHolder.c(R.id.ll_reply, true);
    }
}
