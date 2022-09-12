public class Magic {

    public static void main(String[] args) {
        /*
         * Aufrufe: 5,3
         * 4,4
         * -1,-3
         * -5;0
         */
        //magicOne(5,3);

        /*
         * Aufrufe: 7, 12
         * 4, 14
         * -7, -13
         */
        //magicTwo(7, 12);

        /*
         * Aufrufe: 5,3
         * 3,5
         * 4,4
         */
        //magicThree(5, 3);
    }


    public static void magicOne(int a, int b) {
        for(int i = a; i > b; i--) {
            System.out.println(i);
        }
        System.out.println("Finished");
    }

    public static void magicTwo(int a, int b) {
        for(int i = 0; i < b; i = i + 2) {
            if(i == a) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("Finished");
    }

    public static void magicThree(int a, int b) {
        if(a > b) {
            System.out.println("Hier!");
            if(a == b) {
                System.out.println("Bin ich hier?");
            }
        }
        if(b > a) {
            System.out.println("Nein hier!");
        } else if(a == b) {
            System.out.println("Hier gelandet");
        }
    }

}