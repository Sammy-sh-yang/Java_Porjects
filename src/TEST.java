public class TEST {

//    char operator () {
//        char [] operator = {'+','-','*','/'};
//        for (int i = 0; i < operator.length; i++) {
//            char x = operator[i];
//        }
//    }

    String calculator(String a) {
        String result = a.replace(" ", "");
        String firstOp = ("*/");
        String secondOp = ("+-");


        for (int i = 0; i < a.length(); i++) {
            char index = a.charAt(i);


        }


        if (a.contains("*") || a.contains("/")) {

        }

        return result;
    }


    public static void main(String[] args) {
        // Test case:
//        String a = "1+2+3";
//        String b = " 3/2 ";
//        String c = " 3+5 / 2 ";


        TEST t = new TEST();
        String x = t.calculator(" 3/2 ");
        System.out.println(x);


//        switch (a){
//            case operator:
//
//        }

    }
}
