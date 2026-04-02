package adapter;

import android.text.TextUtils;
import android.view.View;
import bean.TellNumHtyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import util.l1;

/* JADX INFO: loaded from: classes.dex */
public class HistoryPhoneTagAdapter extends BaseQuickAdapter<TellNumHtyBean, BaseViewHolder> {
    private List<TellNumHtyBean> V;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public HistoryPhoneTagAdapter(int i2, List<TellNumHtyBean> list) {
        super(i2, list);
        this.V = list;
    }

    public void a(List<TellNumHtyBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, TellNumHtyBean tellNumHtyBean) {
        String caseCategoryText = tellNumHtyBean.getCaseCategoryText();
        String number = tellNumHtyBean.getNumber();
        String strA = l1.a(number);
        String submitTime = tellNumHtyBean.getSubmitTime();
        if (TextUtils.isEmpty(caseCategoryText)) {
            caseCategoryText = "\u5176\u4ed6\u8bc8\u9a97";
        }
        if (TextUtils.isEmpty(strA)) {
            strA = "\u672a\u77e5";
        }
        baseViewHolder.a(R.id.tv_phone, (CharSequence) number);
        baseViewHolder.a(R.id.casecategory, (CharSequence) caseCategoryText);
        baseViewHolder.a(R.id.phone_type, (CharSequence) strA);
        baseViewHolder.a(R.id.report_time, (CharSequence) submitTime);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        baseViewHolder.itemView.setOnClickListener(new a());
    }
}
