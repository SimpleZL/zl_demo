package asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.FieldVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-08-06
 */
public class AccessClassAdapter extends ClassAdapter {
    public AccessClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        int privateAcess = Opcodes.ACC_PRIVATE;
        return cv.visitField(privateAcess, name, desc, signature, value);
    }
}
