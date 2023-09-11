package fr.jbogart.fizzbuzz.application;

public class FizzbuzzDTO {

    private final int int1;
    private final int int2;
    private final int limit;
    private final String str1;
    private final String str2;

    public FizzbuzzDTO(int int1, int int2, int limit, String str1, String str2) {
        this.int1 = int1;
        this.int2 = int2;
        this.limit = limit;
        this.str1 = str1;
        this.str2 = str2;
    }

    public Integer getInt1() {
        return int1;
    }

    public Integer getInt2() {
        return int2;
    }

    public Integer getLimit() {
        return limit;
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

}
