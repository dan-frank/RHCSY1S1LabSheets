class SideEffect {
   public static void main(String[] args) {
      System.out.println("'++' Operator\n");
      int x = 20;
      System.out.println("Starting value: " + x);

      x++;
      System.out.println("'x++' outputs: " + x);
      System.out.println("This adds 1 to x (x + 1)");

      ++x;
      System.out.println("'++x' outputs: " + x);
      System.out.println("This adds x to 1 (1 + x)");

      System.out.println("\nAfter some experimenting, maybe '++x' is calculated before other statements and 'x++' is calculated after.");
      System.out.println("\n\"++x is what's called the prefix (or pre) increment operator and x++ is what's called the postfix (or post) increment operator.\nAs the names imply, ++x will first increment x and then return it. Conversely, x++ will return the value of x and then increment it.\"");



      System.out.println("\nTheory Predictions\n");
      x = 3;
      System.out.println("x = 3\n");

      System.out.println("true & ++x > 3.5");
      System.out.println("Est: true");
      System.out.println("Ans: " + (true & ++x > 3.5));
      System.out.println("x is now: " + x + "\n");

      x = 3;
      System.out.println("false & ++x > 3.5");
      System.out.println("Est: false");
      System.out.println("Ans: " + (false & ++x > 3.5));
      System.out.println("x is now: " + x + "\n");

      x = 3;
      System.out.println("true | x++ > 3.5");
      System.out.println("Est: true");
      System.out.println("Ans: " + (true | x++ > 3.5));
      System.out.println("x is now: " + x + "\n");

      x = 3;
      System.out.println("false | x++ > 3.5");
      System.out.println("Est: false");
      System.out.println("Ans: " + (false | x++ > 3.5));
      System.out.println("x is now: " + x + "\n");

      x = 3;
      System.out.println("x++ < 3.5 & ++x > 3.5");
      System.out.println("Est: true");
      System.out.println("Ans: " + (x++ < 3.5 & ++x > 3.5));
      System.out.println("x is now: " + x + "\n");

      x = 3;
      System.out.println("++x < 3.5 | x++ < 3.5");
      System.out.println("Est: false");
      System.out.println("Ans: " + (++x < 3.5 | x++ < 3.5));
      System.out.println("x is now: " + x);
   }
}
