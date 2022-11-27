package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.unity3d.player.k */
public final class C0164k extends Dialog implements TextWatcher, View.OnClickListener {

    /* renamed from: c */
    private static int f216c = 1627389952;

    /* renamed from: d */
    private static int f217d = -1;

    /* renamed from: e */
    private static int f218e = 134217728;

    /* renamed from: f */
    private static int f219f = 67108864;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f220a = null;

    /* renamed from: b */
    private UnityPlayer f221b = null;

    public C0164k(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        super(context);
        this.f220a = context;
        this.f221b = unityPlayer;
        getWindow().setGravity(80);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(createSoftInputView());
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        if (C0163j.f212a) {
            getWindow().clearFlags(f218e);
            getWindow().clearFlags(f219f);
        }
        EditText editText = (EditText) findViewById(1057292289);
        m148a(editText, str, i, z, z2, z3, str2, i2);
        ((Button) findViewById(1057292290)).setOnClickListener(this);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    C0164k.this.getWindow().setSoftInputMode(5);
                }
            }
        });
    }

    /* renamed from: a */
    private static int m145a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z2 ? 131072 : 0) | (z ? 32768 : 524288);
        if (z3) {
            i2 = 128;
        }
        int i4 = i2 | i3;
        if (i < 0 || i > 10) {
            return i4;
        }
        int[] iArr = {1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17};
        return (iArr[i] & 2) != 0 ? iArr[i] : i4 | iArr[i];
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m146a() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    /* renamed from: a */
    private void m148a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f216c);
        editText.setInputType(m145a(i, z, z2, z3));
        editText.setImeOptions(33554432);
        if (i2 > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m150a(String str, boolean z) {
        ((EditText) findViewById(1057292289)).setSelection(0, 0);
        this.f221b.reportSoftInputStr(str, 1, z);
    }

    /* renamed from: a */
    public final void mo1672a(int i) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return;
        }
        if (i > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            return;
        }
        editText.setFilters(new InputFilter[0]);
    }

    /* renamed from: a */
    public final void mo1673a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void afterTextChanged(Editable editable) {
        this.f221b.reportSoftInputStr(editable.toString(), 0, false);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f220a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f217d);
        C01662 r0 = new EditText(this.f220a) {
            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    C0164k.this.m150a(C0164k.this.m146a(), true);
                    return true;
                } else if (i != 84) {
                    return super.onKeyPreIme(i, keyEvent);
                } else {
                    return true;
                }
            }

            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) C0164k.this.f220a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        r0.setLayoutParams(layoutParams);
        r0.setId(1057292289);
        relativeLayout.addView(r0);
        Button button = new Button(this.f220a);
        button.setText(this.f220a.getResources().getIdentifier("ok", "string", "android"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    C0164k.this.m150a(C0164k.this.m146a(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    public final void onBackPressed() {
        m150a(m146a(), true);
    }

    public final void onClick(View view) {
        m150a(m146a(), false);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
