package asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  删除类的字段、方法、指令：
 *  只需在职责链传递过程中中断委派，不访问相应的 visit 方法即可，
 *  比如删除方法时只需直接返回 null，而不是返回由 visitMethod方法返回的 MethodVisitor对象。
 * @author: liangzhang212928
 * @Date: 2018-08-06
 */
public class DelLoginClassAdapter extends ClassAdapter {
    public DelLoginClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        if (name.equals("login")) {
            return null;
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
