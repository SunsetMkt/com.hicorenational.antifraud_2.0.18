package ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class SettingItemView extends LinearLayout {
    private ViewGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f14625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f14626c;

    class a implements View.OnClickListener {
        final /* synthetic */ View.OnClickListener a;

        a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public SettingItemView(Context context) {
        super(context);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_settings_item, (ViewGroup) this, true);
        this.a = (ViewGroup) findViewById(R.id.container_settings);
        this.f14625b = (TextView) findViewById(R.id.tv_settings_title);
        this.f14626c = (TextView) findViewById(R.id.tv_settings_value);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SettingItemView);
            String string = typedArrayObtainStyledAttributes.getString(0);
            String string2 = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
            this.f14625b.setText(string);
            this.f14626c.setText(string2);
        }
    }

    public void setItemEnable(boolean z) {
        this.a.setEnabled(z);
    }

    public void setSettingItemClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.a;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new a(onClickListener));
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f14625b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setValue(String str) {
        TextView textView = this.f14626c;
        if (textView != null) {
            textView.setText(str);
            this.f14626c.setTextColor(ContextCompat.getColor(getContext(), R.color.colorGray));
        }
    }

    public void setWarning(String str) {
        TextView textView = this.f14626c;
        if (textView != null) {
            textView.setText(str);
            this.f14626c.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }
    }

    public SettingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SettingItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }
}
