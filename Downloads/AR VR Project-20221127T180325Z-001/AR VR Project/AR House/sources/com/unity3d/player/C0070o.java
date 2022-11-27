package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.unity3d.player.o */
final class C0070o {

    /* renamed from: a */
    private HashMap f235a = new HashMap();

    /* renamed from: b */
    private Class f236b = null;

    /* renamed from: c */
    private Object f237c = null;

    /* renamed from: com.unity3d.player.o$a */
    class C0071a {

        /* renamed from: a */
        public Class[] f238a;

        /* renamed from: b */
        public Method f239b = null;

        public C0071a(Class[] clsArr) {
            this.f238a = clsArr;
        }
    }

    public C0070o(Class cls, Object obj) {
        this.f236b = cls;
        this.f237c = obj;
    }

    /* renamed from: a */
    private void m180a(String str, C0071a aVar) {
        try {
            aVar.f239b = this.f236b.getMethod(str, aVar.f238a);
        } catch (Exception e) {
            C0057g.Log(6, "Exception while trying to get method " + str + ". " + e.getLocalizedMessage());
            aVar.f239b = null;
        }
    }

    /* renamed from: a */
    public final Object mo235a(String str, Object... objArr) {
        StringBuilder sb;
        if (!this.f235a.containsKey(str)) {
            sb = new StringBuilder("No definition for method ");
            sb.append(str);
            str = " can be found";
        } else {
            C0071a aVar = (C0071a) this.f235a.get(str);
            if (aVar.f239b == null) {
                m180a(str, aVar);
            }
            if (aVar.f239b == null) {
                sb = new StringBuilder("Unable to create method: ");
            } else {
                try {
                    return objArr.length == 0 ? aVar.f239b.invoke(this.f237c, new Object[0]) : aVar.f239b.invoke(this.f237c, objArr);
                } catch (Exception e) {
                    C0057g.Log(6, "Error trying to call delegated method " + str + ". " + e.getLocalizedMessage());
                    return null;
                }
            }
        }
        sb.append(str);
        C0057g.Log(6, sb.toString());
        return null;
    }

    /* renamed from: a */
    public final void mo236a(String str, Class[] clsArr) {
        this.f235a.put(str, new C0071a(clsArr));
    }
}
