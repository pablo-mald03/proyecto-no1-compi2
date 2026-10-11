package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;


import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;


public class ZAccessControlService {

    private final EditorContext context;

    public ZAccessControlService(EditorContext context) {
        this.context = context;
    }

    /**
     * Returns true if `member` is accessible from the given context.
     */
    public boolean isAccessible(Symbol member, Symbol accessingClass) {
        if (member == null) return false;

        if (accessingClass != null
                && accessingClass.getName().equals(member.getDeclaringClass())) {
            return true;
        }

        switch (member.getAccessModifier()) {
            case PUBLIC:
                return true;
            case PROTECTED:
                return isSubclassOf(accessingClass, member.getDeclaringClass());
            case PRIVATE:
                return false;
            default:
                return false;
        }
    }

    /**
     * Same-file check. Both symbols carry filePath.
     */
    private boolean sameFile(Symbol member) {
        String memberFile = member.getFilePath();
        String currentFile = context.getFilePath();
        return memberFile != null && memberFile.equals(currentFile);
    }

    /**
     * Method check: walks the parent chain of `accessingClass` looking for
     */
    private boolean isSubclassOf(Symbol accessingClass, String className) {
        if (accessingClass == null || className == null) return false;

        Symbol current = accessingClass;
        while (current != null && current.getParentName() != null) {
            if (className.equals(current.getParentName())) return true;
            current = current.getParentSymbol();
        }
        return false;
    }
}