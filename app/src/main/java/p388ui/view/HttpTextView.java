package p388ui.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class HttpTextView extends AppCompatTextView {

    /* renamed from: a */
    private String f24507a;

    /* renamed from: b */
    Pattern f24508b;

    /* renamed from: c */
    Matcher f24509c;

    /* renamed from: d */
    LinkedList<String> f24510d;

    /* renamed from: e */
    LinkedList<C7171b> f24511e;

    /* renamed from: f */
    int f24512f;

    /* renamed from: g */
    private boolean f24513g;

    /* renamed from: h */
    private String f24514h;

    /* renamed from: ui.view.HttpTextView$a */
    class C7170a extends ClickableSpan {

        /* renamed from: a */
        private String f24515a;

        public C7170a(String str) {
            this.f24515a = str;
            HttpTextView.this.f24514h = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Toast.makeText(view.getContext(), this.f24515a, 0).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-11436114);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: ui.view.HttpTextView$b */
    class C7171b {

        /* renamed from: a */
        public int f24517a;

        /* renamed from: b */
        public int f24518b;

        C7171b() {
        }
    }

    public HttpTextView(Context context) {
        this(context, null);
    }

    public boolean getIsNeedToRegionUrl() {
        return this.f24513g;
    }

    public String getUrlText() {
        String str = this.f24514h;
        if (str == null) {
            return null;
        }
        return str;
    }

    public void setOpenRegionUrl(boolean z) {
        this.f24513g = z;
    }

    public void setUrlText(CharSequence charSequence) {
        if (!this.f24513g) {
            super.setText(charSequence);
        } else {
            super.setText(m25762a(charSequence));
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public HttpTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private C7245u m25762a(CharSequence charSequence) {
        CharSequence charSequence2;
        this.f24510d.clear();
        this.f24511e.clear();
        if (charSequence == null) {
            charSequence = "";
        }
        C7245u c7245u = new C7245u(charSequence);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) c7245u.getSpans(0, charSequence.length(), ClickableSpan.class);
        if (clickableSpanArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            for (ClickableSpan clickableSpan : clickableSpanArr) {
                i3 = c7245u.getSpanStart(clickableSpanArr[0]);
                i2 = c7245u.getSpanEnd(clickableSpan);
            }
            CharSequence subSequence = charSequence.subSequence(i2, charSequence.length());
            charSequence2 = charSequence.subSequence(i3, i2);
            charSequence = subSequence;
        } else {
            charSequence2 = null;
        }
        this.f24509c = this.f24508b.matcher(charSequence);
        while (this.f24509c.find()) {
            C7171b c7171b = new C7171b();
            c7171b.f24517a = this.f24509c.start();
            c7171b.f24518b = this.f24509c.end();
            this.f24510d.add(this.f24509c.group());
            this.f24511e.add(c7171b);
        }
        return m25763a(charSequence2, charSequence);
    }

    public HttpTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24507a = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
        this.f24508b = Pattern.compile(this.f24507a);
        this.f24512f = 33;
        this.f24513g = true;
        this.f24510d = new LinkedList<>();
        this.f24511e = new LinkedList<>();
    }

    /* renamed from: a */
    private C7245u m25763a(CharSequence charSequence, CharSequence charSequence2) {
        C7245u c7245u;
        if (charSequence != null) {
            c7245u = new C7245u(charSequence);
        } else {
            c7245u = new C7245u();
        }
        if (this.f24510d.size() > 0) {
            if (this.f24510d.size() == 1) {
                c7245u.append((CharSequence) charSequence2.toString().substring(0, this.f24511e.get(0).f24517a));
                String str = this.f24510d.get(0);
                c7245u.append((CharSequence) str, (Object) new C7170a(str), this.f24512f);
                c7245u.append((CharSequence) charSequence2.toString().substring(this.f24511e.get(0).f24518b));
            } else {
                for (int i2 = 0; i2 < this.f24510d.size(); i2++) {
                    if (i2 == 0) {
                        c7245u.append((CharSequence) charSequence2.toString().substring(0, this.f24511e.get(0).f24517a));
                    }
                    if (i2 == this.f24510d.size() - 1) {
                        c7245u.append((CharSequence) this.f24510d.get(i2), (Object) new C7170a(this.f24510d.get(i2)), this.f24512f);
                        c7245u.append((CharSequence) charSequence2.toString().substring(this.f24511e.get(i2).f24518b));
                    }
                    if (i2 != this.f24510d.size() - 1) {
                        c7245u.append((CharSequence) this.f24510d.get(i2), (Object) new C7170a(this.f24510d.get(i2)), this.f24512f);
                        c7245u.append((CharSequence) charSequence2.toString().substring(this.f24511e.get(i2).f24518b, this.f24511e.get(i2 + 1).f24517a));
                    }
                }
            }
        } else {
            c7245u.append(charSequence2);
        }
        return c7245u;
    }
}
