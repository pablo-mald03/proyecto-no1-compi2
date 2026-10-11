package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;


import lombok.Getter;

/**
 * Principal member class result helper class
 *
 */
@Getter
public class MemberLookupResult {
    public enum Kind {FOUND, NOT_FOUND, INACCESSIBLE}

    private final Kind kind;
    private final Symbol member;

    private MemberLookupResult(Kind kind, Symbol member) {
        this.kind = kind;
        this.member = member;
    }

    public static MemberLookupResult found(Symbol m) {
        return new MemberLookupResult(Kind.FOUND, m);
    }

    public static MemberLookupResult notFound() {
        return new MemberLookupResult(Kind.NOT_FOUND, null);
    }

    public static MemberLookupResult inaccessible(Symbol m) {
        return new MemberLookupResult(Kind.INACCESSIBLE, m);
    }

    public boolean isFound() {
        return kind == Kind.FOUND;
    }

    public boolean isInaccessible() {
        return kind == Kind.INACCESSIBLE;
    }

}