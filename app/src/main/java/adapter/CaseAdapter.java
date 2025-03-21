package adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import bean.CaseHistoryBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class CaseAdapter extends BaseQuickAdapter<CaseHistoryBean.Rows, BaseViewHolder> {
    public CaseAdapter(List<CaseHistoryBean.Rows> list) {
        super(C2113R.layout.item_case, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CaseHistoryBean.Rows rows) {
        Group group = (Group) baseViewHolder.m5224c(C2113R.id.group_normal_part);
        Group group2 = (Group) baseViewHolder.m5224c(C2113R.id.group_new_part);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_top);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_history_dot);
        baseViewHolder.m5211a(C2113R.id.tv_case_name, (CharSequence) rows.getCaseName());
        baseViewHolder.m5211a(C2113R.id.tv_case_time, (CharSequence) rows.getProcessTime());
        textView.setVisibility(8);
        int status = rows.getStatus();
        if (status == 1 || status == 2) {
            group.setVisibility(8);
            group2.setVisibility(0);
            imageView.setVisibility(0);
            imageView.setImageResource(C2113R.mipmap.ic_case_new);
            String caseNumber = rows.getCaseNumber();
            if (TextUtils.isEmpty(caseNumber)) {
                caseNumber = "";
            }
            String caseCategoryText = rows.getCaseCategoryText();
            if (TextUtils.isEmpty(caseCategoryText)) {
                caseCategoryText = "";
            }
            baseViewHolder.m5211a(C2113R.id.tv_case_code, (CharSequence) caseNumber).m5211a(C2113R.id.tv_number, (CharSequence) caseCategoryText).m5194a(C2113R.id.iv_clear);
        } else if (status == 3) {
            group.setVisibility(0);
            group2.setVisibility(8);
            imageView.setVisibility(0);
            imageView.setImageResource(C2113R.mipmap.ic_case_wait);
            textView.setVisibility(0);
            baseViewHolder.m5211a(C2113R.id.tv_case_victim, (CharSequence) rows.getName()).m5211a(C2113R.id.tv_victim_id, (CharSequence) rows.getDocumentNumber());
            if (!TextUtils.isEmpty(rows.getDocumentTypeText())) {
                baseViewHolder.m5211a(C2113R.id.tv_victim_id_label, (CharSequence) ("证件号 (" + rows.getDocumentTypeText() + ")："));
            }
        } else if (status == 5) {
            group.setVisibility(0);
            group2.setVisibility(8);
            imageView.setVisibility(0);
            imageView.setImageResource(C2113R.mipmap.ic_case_wait);
            baseViewHolder.m5211a(C2113R.id.tv_case_victim, (CharSequence) rows.getName()).m5211a(C2113R.id.tv_victim_id, (CharSequence) rows.getDocumentNumber());
            if (!TextUtils.isEmpty(rows.getDocumentTypeText())) {
                baseViewHolder.m5211a(C2113R.id.tv_victim_id_label, (CharSequence) ("证件号 (" + rows.getDocumentTypeText() + ")："));
            }
        } else if (status == 6) {
            group.setVisibility(0);
            group2.setVisibility(8);
            imageView.setVisibility(0);
            imageView.setImageResource(C2113R.mipmap.ic_case_back);
            baseViewHolder.m5211a(C2113R.id.tv_case_victim, (CharSequence) rows.getName()).m5211a(C2113R.id.tv_victim_id, (CharSequence) rows.getDocumentNumber());
            if (!TextUtils.isEmpty(rows.getDocumentTypeText())) {
                baseViewHolder.m5211a(C2113R.id.tv_victim_id_label, (CharSequence) ("证件号 (" + rows.getDocumentTypeText() + ")："));
            }
        }
        if (rows.getIsExpired() == 1) {
            textView.setVisibility(8);
            group.setVisibility(0);
            group2.setVisibility(8);
            imageView.setVisibility(0);
            imageView.setImageResource(C2113R.mipmap.ic_case_exper);
            baseViewHolder.m5211a(C2113R.id.tv_case_victim, (CharSequence) rows.getName()).m5211a(C2113R.id.tv_victim_id, (CharSequence) rows.getDocumentNumber());
            if (TextUtils.isEmpty(rows.getDocumentTypeText())) {
                return;
            }
            baseViewHolder.m5211a(C2113R.id.tv_victim_id_label, (CharSequence) ("证件号 (" + rows.getDocumentTypeText() + ")："));
        }
    }
}
