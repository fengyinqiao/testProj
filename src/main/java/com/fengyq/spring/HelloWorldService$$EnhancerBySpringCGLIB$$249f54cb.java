/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.fengyq.spring.HelloWorldService
 *//*

package com.fengyq.spring;

import com.fengyq.spring.HelloWorldService;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.TargetClassAware;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Factory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.NoOp;

public class HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb
extends HelloWorldService
implements SpringProxy,
Advised,
Factory {
    private boolean CGLIB$BOUND;
    public static Object CGLIB$FACTORY_DATA;
    private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
    private static final Callback[] CGLIB$STATIC_CALLBACKS;
    private MethodInterceptor CGLIB$CALLBACK_0;
    private MethodInterceptor CGLIB$CALLBACK_1;
    private NoOp CGLIB$CALLBACK_2;
    private Dispatcher CGLIB$CALLBACK_3;
    private Dispatcher CGLIB$CALLBACK_4;
    private MethodInterceptor CGLIB$CALLBACK_5;
    private MethodInterceptor CGLIB$CALLBACK_6;
    private static Object CGLIB$CALLBACK_FILTER;
    private static final Method CGLIB$hello$0$Method;
    private static final MethodProxy CGLIB$hello$0$Proxy;
    private static final Object[] CGLIB$emptyArgs;
    private static final Method CGLIB$hello2$1$Method;
    private static final MethodProxy CGLIB$hello2$1$Proxy;
    private static final Method CGLIB$equals$2$Method;
    private static final MethodProxy CGLIB$equals$2$Proxy;
    private static final Method CGLIB$toString$3$Method;
    private static final MethodProxy CGLIB$toString$3$Proxy;
    private static final Method CGLIB$hashCode$4$Method;
    private static final MethodProxy CGLIB$hashCode$4$Proxy;
    private static final Method CGLIB$clone$5$Method;
    private static final MethodProxy CGLIB$clone$5$Proxy;

    public HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb() {
        try {
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb = this;
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(helloWorldService$$EnhancerBySpringCGLIB$$249f54cb);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    static {
        HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$STATICHOOK4();
        HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$STATICHOOK3();
    }

    public final boolean equals(Object object) {
        try {
            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_5;
            if (methodInterceptor == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                methodInterceptor = this.CGLIB$CALLBACK_5;
            }
            if (methodInterceptor != null) {
                Object object2;
                return methodInterceptor.intercept(this, CGLIB$equals$2$Method, new Object[]{object}, CGLIB$equals$2$Proxy) == null ? false : (Boolean)object2;
            }
            return super.equals(object);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
            if (methodInterceptor == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                methodInterceptor = this.CGLIB$CALLBACK_0;
            }
            if (methodInterceptor != null) {
                return (String)methodInterceptor.intercept(this, CGLIB$toString$3$Method, CGLIB$emptyArgs, CGLIB$toString$3$Proxy);
            }
            return super.toString();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_6;
            if (methodInterceptor == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                methodInterceptor = this.CGLIB$CALLBACK_6;
            }
            if (methodInterceptor != null) {
                Object object;
                return methodInterceptor.intercept(this, CGLIB$hashCode$4$Method, CGLIB$emptyArgs, CGLIB$hashCode$4$Proxy) == null ? 0 : ((Number)object).intValue();
            }
            return super.hashCode();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    protected final Object clone() throws CloneNotSupportedException {
        try {
            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
            if (methodInterceptor == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                methodInterceptor = this.CGLIB$CALLBACK_0;
            }
            if (methodInterceptor != null) {
                return methodInterceptor.intercept(this, CGLIB$clone$5$Method, CGLIB$emptyArgs, CGLIB$clone$5$Proxy);
            }
            return super.clone();
        }
        catch (CloneNotSupportedException | Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int indexOf(Advice advice) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).indexOf(advice);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int indexOf(Advisor advisor) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).indexOf(advisor);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public Object newInstance(Callback[] arrcallback) {
        try {
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$SET_THREAD_CALLBACKS(arrcallback);
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$SET_THREAD_CALLBACKS(null);
            return new HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    */
/*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     *//*

    public Object newInstance(Class[] var1_1, Object[] var2_2, Callback[] var3_3) {
        try {
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$SET_THREAD_CALLBACKS(var3_3);
            switch (var1_1.length) {
                case 0: {
                    ** break;
                }
            }
            throw new IllegalArgumentException("Constructor not found");
lbl7: // 1 sources:
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$SET_THREAD_CALLBACKS(null);
            return new HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb();
        }
        catch (Error | RuntimeException v0) {
            throw v0;
        }
        catch (Throwable v1) {
            throw new UndeclaredThrowableException(v1);
        }
    }

    public Object newInstance(Callback callback) {
        try {
            throw new IllegalStateException("More than one callback object required");
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean isFrozen() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).isFrozen();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    final Object CGLIB$clone$5() throws CloneNotSupportedException {
        return super.clone();
    }

    final void CGLIB$hello$0(String string) throws IOException {
        super.hello(string);
    }

    public final String toProxyConfigString() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).toProxyConfigString();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Class[] getProxiedInterfaces() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).getProxiedInterfaces();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean isInterfaceProxied(Class class_) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).isInterfaceProxied(class_);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean replaceAdvisor(Advisor advisor, Advisor advisor2) throws AopConfigException {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).replaceAdvisor(advisor, advisor2);
        }
        catch (Error | RuntimeException | AopConfigException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Class getTargetClass() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((TargetClassAware)dispatcher.loadObject()).getTargetClass();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final TargetSource getTargetSource() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).getTargetSource();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean isProxyTargetClass() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).isProxyTargetClass();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void setTargetSource(TargetSource targetSource) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).setTargetSource(targetSource);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void setPreFiltered(boolean bl) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).setPreFiltered(bl);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void setExposeProxy(boolean bl) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).setExposeProxy(bl);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
        switch (((Object)signature).toString().hashCode()) {
            case -2084786067: {
                String string;
                if (!string.equals("hello(Ljava/lang/String;)V")) break;
                return CGLIB$hello$0$Proxy;
            }
            case -508378822: {
                String string;
                if (!string.equals("clone()Ljava/lang/Object;")) break;
                return CGLIB$clone$5$Proxy;
            }
            case 891876447: {
                String string;
                if (!string.equals("hello2(Ljava/lang/String;)V")) break;
                return CGLIB$hello2$1$Proxy;
            }
            case 1826985398: {
                String string;
                if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
                return CGLIB$equals$2$Proxy;
            }
            case 1913648695: {
                String string;
                if (!string.equals("toString()Ljava/lang/String;")) break;
                return CGLIB$toString$3$Proxy;
            }
            case 1984935277: {
                String string;
                if (!string.equals("hashCode()I")) break;
                return CGLIB$hashCode$4$Proxy;
            }
            default: {
            }
        }
        return null;
    }

    private static final void CGLIB$BIND_CALLBACKS(Object object) {
        HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb = (HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb)object;
        if (!helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BOUND) {
            helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BOUND = true;
            Object object2 = CGLIB$THREAD_CALLBACKS.get();
            if (object2 != null || (object2 = CGLIB$STATIC_CALLBACKS) != null) {
                Callback[] arrcallback = (Callback[])object2;
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2 = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_6 = (MethodInterceptor)arrcallback[6];
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_5 = (MethodInterceptor)arrcallback[5];
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_4 = (Dispatcher)arrcallback[4];
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_3 = (Dispatcher)arrcallback[3];
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_2 = (NoOp)arrcallback[2];
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_1 = (MethodInterceptor)arrcallback[1];
                helloWorldService$$EnhancerBySpringCGLIB$$249f54cb2.CGLIB$CALLBACK_0 = (MethodInterceptor)arrcallback[0];
            }
        }
    }

    final boolean CGLIB$equals$2(Object object) {
        return super.equals(object);
    }

    final String CGLIB$toString$3() {
        return super.toString();
    }

    final int CGLIB$hashCode$4() {
        return super.hashCode();
    }

    static void CGLIB$STATICHOOK3() {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];
        Class<?> class_ = Class.forName("com.fengyq.spring.HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb");
        Class<?> class_2 = Class.forName("com.fengyq.spring.HelloWorldService");
        Method[] arrmethod = ReflectUtils.findMethods(new String[]{"hello", "(Ljava/lang/String;)V", "hello2", "(Ljava/lang/String;)V"}, class_2.getDeclaredMethods());
        CGLIB$hello$0$Method = arrmethod[0];
        CGLIB$hello$0$Proxy = MethodProxy.create(class_2, class_, "(Ljava/lang/String;)V", "hello", "CGLIB$hello$0");
        CGLIB$hello2$1$Method = arrmethod[1];
        CGLIB$hello2$1$Proxy = MethodProxy.create(class_2, class_, "(Ljava/lang/String;)V", "hello2", "CGLIB$hello2$1");
        class_2 = Class.forName("java.lang.Object");
        Method[] arrmethod2 = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, class_2.getDeclaredMethods());
        CGLIB$equals$2$Method = arrmethod2[0];
        CGLIB$equals$2$Proxy = MethodProxy.create(class_2, class_, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$2");
        CGLIB$toString$3$Method = arrmethod2[1];
        CGLIB$toString$3$Proxy = MethodProxy.create(class_2, class_, "()Ljava/lang/String;", "toString", "CGLIB$toString$3");
        CGLIB$hashCode$4$Method = arrmethod2[2];
        CGLIB$hashCode$4$Proxy = MethodProxy.create(class_2, class_, "()I", "hashCode", "CGLIB$hashCode$4");
        CGLIB$clone$5$Method = arrmethod2[3];
        CGLIB$clone$5$Proxy = MethodProxy.create(class_2, class_, "()Ljava/lang/Object;", "clone", "CGLIB$clone$5");
    }

    final void CGLIB$hello2$1(String string) throws IOException {
        super.hello2(string);
    }

    static void CGLIB$STATICHOOK4() {
        try {
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void hello(String string) throws IOException {
        try {
            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
            if (methodInterceptor == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                methodInterceptor = this.CGLIB$CALLBACK_0;
            }
            if (methodInterceptor != null) {
                Object object = methodInterceptor.intercept(this, CGLIB$hello$0$Method, new Object[]{string}, CGLIB$hello$0$Proxy);
                return;
            }
            super.hello(string);
            return;
        }
        catch (IOException | Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void hello2(String string) throws IOException {
        try {
            MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
            if (methodInterceptor == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                methodInterceptor = this.CGLIB$CALLBACK_0;
            }
            if (methodInterceptor != null) {
                Object object = methodInterceptor.intercept(this, CGLIB$hello2$1$Method, new Object[]{string}, CGLIB$hello2$1$Proxy);
                return;
            }
            super.hello2(string);
            return;
        }
        catch (IOException | Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final Advisor[] getAdvisors() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).getAdvisors();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void addAdvisor(int n, Advisor advisor) throws AopConfigException {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).addAdvisor(n, advisor);
            return;
        }
        catch (Error | RuntimeException | AopConfigException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void addAdvisor(Advisor advisor) throws AopConfigException {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).addAdvisor(advisor);
            return;
        }
        catch (Error | RuntimeException | AopConfigException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean isExposeProxy() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).isExposeProxy();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void addAdvice(Advice advice) throws AopConfigException {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).addAdvice(advice);
            return;
        }
        catch (Error | RuntimeException | AopConfigException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void addAdvice(int n, Advice advice) throws AopConfigException {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).addAdvice(n, advice);
            return;
        }
        catch (Error | RuntimeException | AopConfigException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean isPreFiltered() {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).isPreFiltered();
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean removeAdvisor(Advisor advisor) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).removeAdvisor(advisor);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void removeAdvisor(int n) throws AopConfigException {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            ((Advised)dispatcher.loadObject()).removeAdvisor(n);
            return;
        }
        catch (Error | RuntimeException | AopConfigException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final boolean removeAdvice(Advice advice) {
        try {
            Dispatcher dispatcher = this.CGLIB$CALLBACK_4;
            if (dispatcher == null) {
                HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
                dispatcher = this.CGLIB$CALLBACK_4;
            }
            return ((Advised)dispatcher.loadObject()).removeAdvice(advice);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public void setCallbacks(Callback[] arrcallback) {
        try {
            Callback[] arrcallback2 = arrcallback;
            this.CGLIB$CALLBACK_0 = (MethodInterceptor)arrcallback2[0];
            this.CGLIB$CALLBACK_1 = (MethodInterceptor)arrcallback2[1];
            this.CGLIB$CALLBACK_2 = (NoOp)arrcallback2[2];
            this.CGLIB$CALLBACK_3 = (Dispatcher)arrcallback2[3];
            this.CGLIB$CALLBACK_4 = (Dispatcher)arrcallback2[4];
            this.CGLIB$CALLBACK_5 = (MethodInterceptor)arrcallback2[5];
            Callback[] arrcallback3 = arrcallback2;
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb = this;
            this.CGLIB$CALLBACK_6 = (MethodInterceptor)arrcallback2[6];
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public Callback[] getCallbacks() {
        try {
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb = this;
            return new Callback[]{this.CGLIB$CALLBACK_0, this.CGLIB$CALLBACK_1, this.CGLIB$CALLBACK_2, this.CGLIB$CALLBACK_3, this.CGLIB$CALLBACK_4, this.CGLIB$CALLBACK_5, this.CGLIB$CALLBACK_6};
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public void setCallback(int n, Callback callback) {
        try {
            switch (n) {
                case 0: {
                    this.CGLIB$CALLBACK_0 = (MethodInterceptor)callback;
                    break;
                }
                case 1: {
                    this.CGLIB$CALLBACK_1 = (MethodInterceptor)callback;
                    break;
                }
                case 2: {
                    this.CGLIB$CALLBACK_2 = (NoOp)callback;
                    break;
                }
                case 3: {
                    this.CGLIB$CALLBACK_3 = (Dispatcher)callback;
                    break;
                }
                case 4: {
                    this.CGLIB$CALLBACK_4 = (Dispatcher)callback;
                    break;
                }
                case 5: {
                    this.CGLIB$CALLBACK_5 = (MethodInterceptor)callback;
                    break;
                }
                case 6: {
                    this.CGLIB$CALLBACK_6 = (MethodInterceptor)callback;
                    break;
                }
            }
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] arrcallback) {
        CGLIB$THREAD_CALLBACKS.set(arrcallback);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] arrcallback) {
        CGLIB$STATIC_CALLBACKS = arrcallback;
    }

    public Callback getCallback(int n) {
        try {
            Callback callback;
            HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$BIND_CALLBACKS(this);
            switch (n) {
                case 0: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_0;
                    break;
                }
                case 1: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_1;
                    break;
                }
                case 2: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_2;
                    break;
                }
                case 3: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_3;
                    break;
                }
                case 4: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_4;
                    break;
                }
                case 5: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_5;
                    break;
                }
                case 6: {
                    HelloWorldService$$EnhancerBySpringCGLIB$$249f54cb helloWorldService$$EnhancerBySpringCGLIB$$249f54cb;
                    callback = helloWorldService$$EnhancerBySpringCGLIB$$249f54cb.CGLIB$CALLBACK_6;
                    break;
                }
                default: {
                    callback = null;
                }
            }
            return callback;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

*/
