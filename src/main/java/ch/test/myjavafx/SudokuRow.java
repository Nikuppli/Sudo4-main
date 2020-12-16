package ch.test.myjavafx;

public class SudokuRow {
    public void setA(String a) { this.a = a; }
    public void setB(String b) { this.b = b; }
    public void setC(String c) { this.c = c; }
    public void setD(String d) {
        this.d = d;
    }
    public void setE(String e) {
        this.e = e;
    }
    public void setF(String f) {
        this.f = f;
    }
    public void setG(String g) {
        this.g = g;
    }
    public void setH(String h) {
        this.h = h;
    }
    public void setI(String i) {
        this.i = i;
    }

    public String getA() {
        return a;
    }
    public String getB() {
        return b;
    }
    public String getC() {
        return c;
    }
    public String getD() {
        return d;
    }
    public String getE() {
        return e;
    }
    public String getF() {
        return f;
    }
    public String getG() {
        return g;
    }
    public String getH() {
        return h;
    }
    public String getI() {
        return i;
    }

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public SudokuRow(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        this.a = String.valueOf(a);
        this.b = String.valueOf(b);
        this.c = String.valueOf(c);
        this.d = String.valueOf(d);
        this.e = String.valueOf(e);
        this.f = String.valueOf(f);
        this.g = String.valueOf(g);
        this.h = String.valueOf(h);
        this.i = String.valueOf(i);
    }
}
