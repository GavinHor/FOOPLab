package lab3;

enum LinkType {
    SUPERCLASS(" <|--"),
    DEPENDANCY(" ..> ");

    public final String linkString;

    LinkType(String linkString) {
        this.linkString = linkString;
    }
}


record Link(Class<?> from, Class<?> to, LinkType type) {
}

