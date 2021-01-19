public class Calculator {
    long var1;
    long var2;
    char char_in;
    String str_out;
    Status status;
    Ope ope;
    NextStatus nextStatus;

    public Calculator() {
        this.var1 = 0;
        this.var2 = 0;
        this.status = Status.I;
        this.ope = Ope.nul;
        this.char_in = 0;
        this.nextStatus = NextStatus.nul;
        this.str_out = "";
    }

    public void clear() {
        this.var1 = 0;
        this.var2 = 0;
        this.status = Status.I;
        this.ope = Ope.nul;
        this.char_in = 0;
        this.nextStatus = NextStatus.nul;
        this.str_out = "";
    }

    void machine() {
        switch (status) {
            case I -> {
                if (nextStatus == NextStatus.num) {
                    status = Status.II;
                    var1 = char_in - '0';
                    str_out = Long.toString(var1);
                }
            }
            case II -> {
                switch (nextStatus) {
                    case num -> {
                        var1 = var1 * 10 + char_in - '0';
                        str_out = Long.toString(var1);
                    }
                    case ope -> {
                        status = Status.III;
                        setOpe();
                    }
                    case equal -> ope = Ope.nul;
                }
            }
            case III -> {
                switch (nextStatus) {
                    case num -> {
                        status = Status.IV;
                        var2 = char_in - '0';
                        str_out = Long.toString(var2);
                    }
                    case ope -> setOpe();
                    case equal -> {
                        status = Status.II;
                        str_out = Long.toString(var1);
                    }
                }
            }
            case IV -> {
                switch (nextStatus) {
                    case num -> {
                        var2 = var2 * 10 + char_in - '0';
                        str_out = Long.toString(var2);
                    }
                    case ope -> {
                        status = Status.III;

                        switch (ope) {
                            case add -> var1 = var1 + var2;
                            case sub -> var1 = var1 - var2;
                            case mul -> var1 = var1 * var2;
                            case div -> var1 = var1 / var2;
                        }

                        setOpe();

                    }

                    case equal -> {
                        status = Status.II;
                        switch (ope) {
                            case add -> var1 = var1 + var2;
                            case sub -> var1 = var1 - var2;
                            case mul -> var1 = var1 * var2;
                            case div -> var1 = var1 / var2;
                        }
                        ope = Ope.nul;
                        str_out = Long.toString(var1);
                    }
                }
            }
        }

    }

    private void setOpe() {
        ope = switch (char_in) {
            case '+' -> Ope.add;
            case '-' -> Ope.sub;
            case '*' -> Ope.mul;
            case '/' -> Ope.div;
            default -> Ope.nul;
        };
        str_out = Long.toString(var1) + char_in;
    }

    void update(char in) {
        this.char_in = in;
        if (in == '=')
            nextStatus = NextStatus.equal;
        else if (in == '+' || in == '-' || in == '*' || in == '/')
            nextStatus = NextStatus.ope;
        else
            nextStatus = NextStatus.num;
    }

    String output() {
        return str_out;
    }

    enum Status {
        I,
        II,
        III,
        IV
    }

    enum Ope {
        add,
        sub,
        mul,
        div,
        nul
    }

    enum NextStatus {
        num,
        ope,
        equal,
        nul
    }

}
