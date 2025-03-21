package util;

import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import interfaces.IEditAfterListener;
import java.util.regex.Pattern;

/* compiled from: EditUtil.java */
/* renamed from: util.d1 */
/* loaded from: classes2.dex */
public class C7268d1 {

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$a */
    static class a implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ IEditAfterListener f25284a;

        a(IEditAfterListener iEditAfterListener) {
            this.f25284a = iEditAfterListener;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f25284a.editLength(editable.toString().length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$b */
    static class b implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ int f25285a;

        /* renamed from: b */
        final /* synthetic */ EditText f25286b;

        /* renamed from: c */
        final /* synthetic */ IEditAfterListener f25287c;

        b(int i2, EditText editText, IEditAfterListener iEditAfterListener) {
            this.f25285a = i2;
            this.f25286b = editText;
            this.f25287c = iEditAfterListener;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IEditAfterListener iEditAfterListener = this.f25287c;
            if (iEditAfterListener != null) {
                iEditAfterListener.editLength(editable.toString().length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int indexOf;
            if (this.f25285a <= 0 || (indexOf = charSequence.toString().indexOf(".")) <= -1) {
                return;
            }
            if (charSequence.toString().indexOf(".") == 0) {
                String str = "0" + charSequence.toString();
                this.f25286b.setText(str);
                this.f25286b.setSelection(str.length());
            }
            int i5 = indexOf + 1;
            if (charSequence.length() - i5 > this.f25285a) {
                String charSequence2 = charSequence.toString().subSequence(0, i5 + this.f25285a).toString();
                this.f25286b.setText(charSequence2);
                this.f25286b.setSelection(Math.min(i2 + 1, charSequence2.length()));
            }
        }
    }

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$c */
    static class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (1 == motionEvent.getAction()) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$d */
    static class d implements InputFilter {
        d() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuffer stringBuffer = new StringBuffer();
            int i6 = i2;
            while (i6 < i3) {
                char charAt = charSequence.charAt(i6);
                if (C7268d1.m26311a(charAt)) {
                    C7331w1.m26688a("不能含有第三方表情");
                    i6++;
                } else {
                    stringBuffer.append(charAt);
                }
                i6++;
            }
            if (!(charSequence instanceof Spanned)) {
                return stringBuffer;
            }
            SpannableString spannableString = new SpannableString(stringBuffer);
            TextUtils.copySpansFrom((Spanned) charSequence, i2, i3, null, spannableString, 0);
            return spannableString;
        }
    }

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$e */
    static class e implements InputFilter {
        e() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuffer stringBuffer = new StringBuffer();
            int i6 = i2;
            while (i6 < i3) {
                char charAt = charSequence.charAt(i6);
                if (C7268d1.m26316b(charAt)) {
                    C7331w1.m26688a("不能含有特殊字符");
                    i6++;
                } else {
                    stringBuffer.append(charAt);
                }
                i6++;
            }
            if (!(charSequence instanceof Spanned)) {
                return stringBuffer;
            }
            SpannableString spannableString = new SpannableString(stringBuffer);
            TextUtils.copySpansFrom((Spanned) charSequence, i2, i3, null, spannableString, 0);
            return spannableString;
        }
    }

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$f */
    static class f extends NumberKeyListener {
        f() {
        }

        @Override // android.text.method.NumberKeyListener
        protected char[] getAcceptedChars() {
            return "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM`~!@#$%^&*()_\\-+=<>?:\"{}|,./;'\\\\\\[\\]".toCharArray();
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 128;
        }
    }

    /* compiled from: EditUtil.java */
    /* renamed from: util.d1$g */
    static class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    /* renamed from: a */
    public static void m26310a(EditText editText, IEditAfterListener iEditAfterListener) {
        editText.addTextChangedListener(new a(iEditAfterListener));
    }

    /* renamed from: a */
    public static boolean m26311a(char c2) {
        if (c2 == 0 || c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return false;
        }
        if (c2 >= ' ' && c2 <= 55295) {
            return false;
        }
        if (c2 < 57344 || c2 > 65533) {
            return c2 < 0 || c2 > 65535;
        }
        return false;
    }

    /* renamed from: b */
    public static void m26315b(EditText editText, int i2) {
        try {
            if (i2 > 0) {
                editText.setFilters(new InputFilter[]{m26305a(), m26313b(), new InputFilter.LengthFilter(i2)});
            } else {
                editText.setFilters(new InputFilter[]{m26305a(), m26313b()});
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public static void m26317c(EditText editText) {
        editText.setOnTouchListener(new g());
    }

    /* renamed from: a */
    public static void m26309a(EditText editText, int i2, IEditAfterListener iEditAfterListener) {
        editText.addTextChangedListener(new b(i2, editText, iEditAfterListener));
    }

    /* renamed from: a */
    public static String m26306a(String str, int i2) {
        int i3;
        String str2 = "";
        int i4 = 0;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() == 16) {
                return (str.contains(".") && str.indexOf(".") == 15) ? str.substring(0, 16) : str;
            }
            if (str.length() == 15 && !str.contains(".")) {
                return str;
            }
            int indexOf = str.indexOf(".");
            if (str.indexOf("0") == 0 && indexOf != 1) {
                str = Double.parseDouble(str) + "";
            }
            int indexOf2 = str.indexOf(".");
            if (indexOf2 > -1) {
                i3 = str.length() - (indexOf2 + 1);
            } else {
                str = str + ".";
                i3 = 0;
            }
            while (i4 < i2 - i3) {
                str2 = str2 + "0";
                i4++;
            }
            return str + str2;
        }
        while (i4 < i2) {
            str2 = str2 + "0";
            i4++;
        }
        return "0." + str2;
    }

    /* renamed from: b */
    public static InputFilter m26313b() {
        return new e();
    }

    /* renamed from: b */
    public static boolean m26316b(char c2) {
        return Character.getType(c2) > 10;
    }

    /* renamed from: b */
    public static void m26314b(EditText editText) {
        try {
            editText.setKeyListener(new f());
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m26307a(EditText editText) {
        editText.setOnTouchListener(new c());
    }

    /* renamed from: a */
    public static void m26308a(EditText editText, int i2) {
        try {
            if (i2 > 0) {
                editText.setFilters(new InputFilter[]{m26305a(), new InputFilter.LengthFilter(i2)});
            } else {
                editText.setFilters(new InputFilter[]{m26305a()});
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static InputFilter m26305a() {
        return new d();
    }

    /* renamed from: a */
    public static boolean m26312a(String str) {
        return Pattern.compile("^[0-9]*$").matcher(str).matches() || Pattern.compile("^[A-Za-z]+$").matcher(str).matches() || Pattern.compile("^[`~!@#$%^&*()_\\-+=<>?:\"{}|,./;'\\\\\\[\\]]*$").matcher(str).matches();
    }
}
