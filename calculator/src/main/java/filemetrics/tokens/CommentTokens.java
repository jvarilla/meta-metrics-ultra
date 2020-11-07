package filemetrics.tokens;

public enum CommentTokens {
    LINE_START("//"),
    BLOCK_START("/*"),
    BLOCK_END("*/"),
    JAVADOC_START("/**"),
    JAVADOC_END("**/");

    private String text;

    CommentTokens(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return this.text;
    }

}
