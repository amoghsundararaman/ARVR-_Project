package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

/* renamed from: com.unity3d.player.l */
public final class C0168l extends View {

    /* renamed from: a */
    final int f225a;

    /* renamed from: b */
    final int f226b = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());

    /* renamed from: c */
    Bitmap f227c;

    /* renamed from: d */
    Bitmap f228d;

    /* renamed from: com.unity3d.player.l$1 */
    static /* synthetic */ class C01691 {

        /* renamed from: a */
        static final /* synthetic */ int[] f229a = new int[C0170a.m154a().length];

        static {
            try {
                f229a[C0170a.f230a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f229a[C0170a.f231b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f229a[C0170a.f232c - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.unity3d.player.l$a */
    enum C0170a {
        ;

        static {
            f230a = 1;
            f231b = 2;
            f232c = 3;
            f233d = new int[]{f230a, f231b, f232c};
        }

        /* renamed from: a */
        public static int[] m154a() {
            return (int[]) f233d.clone();
        }
    }

    public C0168l(Context context, int i) {
        super(context);
        this.f225a = i;
        if (this.f226b != 0) {
            forceLayout();
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f227c != null) {
            this.f227c.recycle();
            this.f227c = null;
        }
        if (this.f228d != null) {
            this.f228d.recycle();
            this.f228d = null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bb, code lost:
        r3 = (int) (((float) r0) * r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
            r10 = this;
            r1 = 1
            r2 = 0
            int r0 = r10.f226b
            if (r0 != 0) goto L_0x0007
        L_0x0006:
            return
        L_0x0007:
            android.graphics.Bitmap r0 = r10.f227c
            if (r0 != 0) goto L_0x001e
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inScaled = r2
            android.content.res.Resources r3 = r10.getResources()
            int r4 = r10.f226b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r3, r4, r0)
            r10.f227c = r0
        L_0x001e:
            android.graphics.Bitmap r0 = r10.f227c
            int r6 = r0.getWidth()
            android.graphics.Bitmap r0 = r10.f227c
            int r4 = r0.getHeight()
            int r5 = r10.getWidth()
            int r3 = r10.getHeight()
            if (r5 == 0) goto L_0x0006
            if (r3 == 0) goto L_0x0006
            float r0 = (float) r6
            float r7 = (float) r4
            float r7 = r0 / r7
            float r0 = (float) r5
            float r8 = (float) r3
            float r0 = r0 / r8
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x00b0
            r0 = r1
        L_0x0042:
            int[] r8 = com.unity3d.player.C0168l.C01691.f229a
            int r9 = r10.f225a
            int r9 = r9 + -1
            r8 = r8[r9]
            switch(r8) {
                case 1: goto L_0x00b2;
                case 2: goto L_0x00bf;
                case 3: goto L_0x00bf;
                default: goto L_0x004d;
            }
        L_0x004d:
            r0 = r4
            r3 = r6
        L_0x004f:
            android.graphics.Bitmap r4 = r10.f228d
            if (r4 == 0) goto L_0x0071
            android.graphics.Bitmap r4 = r10.f228d
            int r4 = r4.getWidth()
            if (r4 != r3) goto L_0x0063
            android.graphics.Bitmap r4 = r10.f228d
            int r4 = r4.getHeight()
            if (r4 == r0) goto L_0x0006
        L_0x0063:
            android.graphics.Bitmap r4 = r10.f228d
            android.graphics.Bitmap r5 = r10.f227c
            if (r4 == r5) goto L_0x0071
            android.graphics.Bitmap r4 = r10.f228d
            r4.recycle()
            r4 = 0
            r10.f228d = r4
        L_0x0071:
            android.graphics.Bitmap r4 = r10.f227c
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r4, r3, r0, r1)
            r10.f228d = r0
            android.graphics.Bitmap r0 = r10.f228d
            android.content.res.Resources r3 = r10.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r3 = r3.densityDpi
            r0.setDensity(r3)
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.<init>(r3)
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r4 = r10.getResources()
            android.graphics.Bitmap r5 = r10.f228d
            r3.<init>(r4, r5)
            r4 = 17
            r3.setGravity(r4)
            android.graphics.drawable.LayerDrawable r4 = new android.graphics.drawable.LayerDrawable
            r5 = 2
            android.graphics.drawable.Drawable[] r5 = new android.graphics.drawable.Drawable[r5]
            r5[r2] = r0
            r5[r1] = r3
            r4.<init>(r5)
            r10.setBackground(r4)
            goto L_0x0006
        L_0x00b0:
            r0 = r2
            goto L_0x0042
        L_0x00b2:
            if (r5 >= r6) goto L_0x00d5
            float r0 = (float) r5
            float r0 = r0 / r7
            int r0 = (int) r0
            r4 = r5
        L_0x00b8:
            if (r3 >= r0) goto L_0x00d2
            r0 = r3
        L_0x00bb:
            float r3 = (float) r0
            float r3 = r3 * r7
            int r3 = (int) r3
            goto L_0x004f
        L_0x00bf:
            int r4 = r10.f225a
            int r6 = com.unity3d.player.C0168l.C0170a.f232c
            if (r4 != r6) goto L_0x00ce
            r4 = r1
        L_0x00c6:
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x00d0
            float r0 = (float) r5
            float r0 = r0 / r7
            int r0 = (int) r0
            r3 = r5
            goto L_0x004f
        L_0x00ce:
            r4 = r2
            goto L_0x00c6
        L_0x00d0:
            r0 = r3
            goto L_0x00bb
        L_0x00d2:
            r3 = r4
            goto L_0x004f
        L_0x00d5:
            r0 = r4
            r4 = r6
            goto L_0x00b8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C0168l.onLayout(boolean, int, int, int, int):void");
    }
}
