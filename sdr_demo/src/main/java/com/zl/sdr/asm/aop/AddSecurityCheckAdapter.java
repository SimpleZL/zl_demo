package com.zl.sdr.asm.aop;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-01-31
 */
public class AddSecurityCheckAdapter extends ClassAdapter {

    public AddSecurityCheckAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = cv.visitMethod(access,name,desc,signature,exceptions);
        MethodVisitor wrappedMv = methodVisitor;
        if (methodVisitor != null){
            if (name.equals("operation")){
                wrappedMv = new AddSecurityCheckMethodAdapter(methodVisitor);
            }
        }
        return wrappedMv;
    }
}
