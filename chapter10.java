// Demonstrate exception handling.
class ExcDemo1 {
  public static void main(String[] args) {
    int[] nums = new int[4];

    try {
      System.out.println("Before exception is generated.");

      // generate an index out-of-bounds exception
      nums[7] = 10;
      System.out.println("this won't be displayed");
    }
    catch (ArrayIndexOutOfBoundsException exc) {
      // catch the exception
      System.out.println("Index out-of-bounds!");
    }
    System.out.println("After catch.");
  }
}

// -----------------------------------------

/* An exception can be generated by one
   method and caught by another. */

class ExcTest {
  // Generate an exception.
  static void genException() {
    int[] nums = new int[4];

    System.out.println("Before exception is generated.");

    // generate an index out-of-bounds exception
    nums[7] = 10;
    System.out.println("this won't be displayed");
  }
}

class ExcDemo2 {
  public static void main(String[] args) {

    try {
      ExcTest.genException();
    } catch (ArrayIndexOutOfBoundsException exc) {
      // catch the exception
      System.out.println("Index out-of-bounds!");
    }
    System.out.println("After catch.");
  }
}

// -----------------------------------------

// Let JVM handle the error.
class NotHandled {
  public static void main(String[] args) {
    int[] nums = new int[4];

    System.out.println("Before exception is generated.");

    // generate an index out-of-bounds exception
    nums[7] = 10;
  }
}

// -----------------------------------------

// This won't work!
class ExcTypeMismatch {
  public static void main(String[] args) {
    int[] nums = new int[4];

    try {
      System.out.println("Before exception is generated.");

      //generate an index out-of-bounds exception
      nums[7] = 10;
      System.out.println("this won't be displayed");
    }

    /* Can't catch an array boundary error with an
       ArithmeticException. */
    catch (ArithmeticException exc) {
      // catch the exception
      System.out.println("Index out-of-bounds!");
    }
    System.out.println("After catch.");
  }
}

// -----------------------------------------

// Handle error and continue.
class ExcDemo3 {
  public static void main(String[] args) {
    int[] numer = { 4, 8, 16, 32, 64, 128 };
    int[] denom = { 2, 0, 4, 4, 0, 8 };

    for(int i=0; i<numer.length; i++) {
      try {
        System.out.println(numer[i] + " / " +
                           denom[i] + " is " +
                           numer[i]/denom[i]);
      }
      catch (ArithmeticException exc) {
        // catch the exception
        System.out.println("Can't divide by Zero!");
      }
    }
  }
}

// -----------------------------------------

// Use multiple catch clauses.
class ExcDemo4 {
  public static void main(String[] args) {
    // Here, numer is longer than denom.
    int[] numer = { 4, 8, 16, 32, 64, 128, 256, 512 };
    int[] denom = { 2, 0, 4, 4, 0, 8 };

    for(int i=0; i<numer.length; i++) {
      try {
        System.out.println(numer[i] + " / " +
                           denom[i] + " is " +
                           numer[i]/denom[i]);
      }
      catch (ArithmeticException exc) {
        // catch the exception
        System.out.println("Can't divide by Zero!");
      }
      catch (ArrayIndexOutOfBoundsException exc) {
        // catch the exception
        System.out.println("No matching element found.");
      }
    }
  }
}

// -----------------------------------------

// Subclasses must precede superclasses in catch clauses.
class ExcDemo5 {
  public static void main(String[] args) {
    // Here, numer is longer than denom.
    int[] numer = { 4, 8, 16, 32, 64, 128, 256, 512 };
    int[] denom = { 2, 0, 4, 4, 0, 8 };

    for(int i=0; i<numer.length; i++) {
      try {
        System.out.println(numer[i] + " / " +
                           denom[i] + " is " +
                           numer[i]/denom[i]);
      }
      catch (ArrayIndexOutOfBoundsException exc) {
        // catch the exception
        System.out.println("No matching element found.");
      }
      catch (Exception exc) {
        System.out.println("Some exception occurred.");
      }
    }
  }
}

// -----------------------------------------

// Use a nested try block.
class NestTrys {
  public static void main(String[] args) {
    // Here, numer is longer than denom.
    int[] numer = { 4, 8, 16, 32, 64, 128, 256, 512 };
    int[] denom = { 2, 0, 4, 4, 0, 8 };

    try { // outer try
      for(int i=0; i<numer.length; i++) {
        try { // nested try
          System.out.println(numer[i] + " / " +
                             denom[i] + " is " +
                             numer[i]/denom[i]);
        }
        catch (ArithmeticException exc) {
          // catch the exception
          System.out.println("Can't divide by Zero!");
        }
      }
    }
    catch (ArrayIndexOutOfBoundsException exc) {
      // catch the exception
      System.out.println("No matching element found.");
      System.out.println("Fatal error - program terminated.");
    }
  }
}

// -----------------------------------------

// Manually throw an exception.
class ThrowDemo {
  public static void main(String[] args) {
    try {
      System.out.println("Before throw.");
      throw new ArithmeticException();
    }
    catch (ArithmeticException exc) {
      // catch the exception
      System.out.println("Exception caught.");
    }
    System.out.println("After try/catch block.");
  }
}

// -----------------------------------------

// Rethrow an exception.
class Rethrow {
  public static void genException() {
    // here, numer is longer than denom
    int[] numer = { 4, 8, 16, 32, 64, 128, 256, 512 };
    int[] denom = { 2, 0, 4, 4, 0, 8 };

    for(int i=0; i<numer.length; i++) {
      try {
        System.out.println(numer[i] + " / " +
                           denom[i] + " is " +
                           numer[i]/denom[i]);
      }
      catch (ArithmeticException exc) {
        // catch the exception
        System.out.println("Can't divide by Zero!");
      }
      catch (ArrayIndexOutOfBoundsException exc) {
        // catch the exception
        System.out.println("No matching element found.");
        throw exc; // rethrow the exception
      }
    }
  }
}

class RethrowDemo {
  public static void main(String[] args) {
    try {
      Rethrow.genException();
    }
    catch(ArrayIndexOutOfBoundsException exc) {
      // recatch exception
      System.out.println("Fatal error - " +
                         "program terminated.");
    }
  }
}

// -----------------------------------------

// Using two Throwable methods.

class ExcTest {
  static void genException() {
    int[] nums = new int[4];

    System.out.println("Before exception is generated.");

    // generate an index out-of-bounds exception
    nums[7] = 10;
    System.out.println("this won't be displayed");
  }
}

class UseThrowableMethods {
  public static void main(String[] args) {

    try {
      ExcTest.genException();
    }
    catch (ArrayIndexOutOfBoundsException exc) {
      // catch the exception
      System.out.println("Standard message is: ");
      System.out.println(exc);
      System.out.println("\nStack trace: ");
      exc.printStackTrace();
    }
    System.out.println("After catch.");
  }
}

// -----------------------------------------

// Use finally.
class UseFinally {
  public static void genException(int what) {
    int t;
    int[] nums = new int[2];

    System.out.println("Receiving " + what);
    try {
      switch(what) {
        case 0:
          t = 10 / what; // generate div-by-zero error
          break;
        case 1:
          nums[4] = 4; // generate array index error.
          break;
        case 2:
          return; // return from try block
      }
    }
    catch (ArithmeticException exc) {
      // catch the exception
      System.out.println("Can't divide by Zero!");
      return; // return from catch
    }
    catch (ArrayIndexOutOfBoundsException exc) {
      // catch the exception
      System.out.println("No matching element found.");
    }
    finally {
      System.out.println("Leaving try.");
    }
  }
}

class FinallyDemo {
  public static void main(String[] args) {

    for(int i=0; i < 3; i++) {
      UseFinally.genException(i);
      System.out.println();
    }
  }
}

// -----------------------------------------

// Use throws.
class ThrowsDemo {
  public static char prompt(String str)
    throws java.io.IOException {

    System.out.print(str + ": ");
    return (char) System.in.read();
  }

  public static void main(String[] args) {
    char ch;

    try {
      ch = prompt("Enter a letter");
    }
    catch(java.io.IOException exc) {
      System.out.println("I/O exception occurred.");
      ch = 'X';
    }

    System.out.println("You pressed " + ch);
  }
}

// -----------------------------------------

// Use the multi-catch feature.  Note: This code requires JDK 7 or
// later to compile.
class MultiCatch {
  public static void main(String[] args) {
    int a=88, b=0;
    int result;
    char[] chrs = { 'A', 'B', 'C' };

    for(int i=0; i < 2; i++) {
      try {
        if(i == 0)
          result = a / b; // generate an ArithmeticException
        else
          chrs[5] = 'X'; // generate an ArrayIndexOutOfBoundsException

      // This catch clause catches both exceptions.
      }
      catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
        System.out.println("Exception caught: " + e);
      }
    }

    System.out.println("After multi-catch.");
  }
}

// -----------------------------------------

// Use a custom exception.

// Create an exception.
class NonIntResultException extends Exception {
  int n;
  int d;

  NonIntResultException(int i, int j) {
    super("Result is not an integer.");
    n = i;
    d = j;
  }

  public String toString() {
    return "Result of " + n + " / " + d +
           " is non-integer.";
  }
}

class CustomExceptDemo {
  public static void main(String[] args) {

    // Here, numer contains some odd values.
    int[] numer = { 4, 8, 15, 32, 64, 127, 256, 512 };
    int[] denom = { 2, 0, 4, 4, 0, 8 };

    for(int i=0; i<numer.length; i++) {
      try {
        if((numer[i]%denom[i]) != 0)
          throw new
            NonIntResultException(numer[i], denom[i]);

        System.out.println(numer[i] + " / " +
                           denom[i] + " is " +
                           numer[i]/denom[i]);
      }
      catch (ArithmeticException exc) {
        // catch the exception
        System.out.println("Can't divide by Zero!");
      }
      catch (ArrayIndexOutOfBoundsException exc) {
        // catch the exception
        System.out.println("No matching element found.");
      }
      catch (NonIntResultException exc) {
        System.out.println(exc);
      }
    }
  }
}

// -----------------------------------------

/*
    Try This 10-1

    Add exception handling to the stack classes.
*/

// An exception for stack-full errors.
class StackFullException extends Exception {
  int size;

  StackFullException(int s) {
    super("Stack Full");
    size = s;
  }

  public String toString() {
    return "\nStack is full. Maximum size is " + size;
  }
}

// An exception for stack-empty errors.
class StackEmptyException extends Exception {

  StackEmptyException() {
    super("Stack Empty");
  }

  public String toString() {
    return "\nStack is empty.";
  }
}

// A fixed-length stack for characters that uses exceptions.
class FixedLengthStack implements ISimpleStack {
  private char[] data; // this array holds the stack
  private int tos; // index of top of stack

  // Construct an empty stack given its size.
  FixedLengthStack(int size) {
    data = new char[size]; // create the array to hold the stack
    tos = 0;
  }

  // Construct a stack from a stack.
  FixedLengthStack(FixedLengthStack otherStack) {
    // size of new stack equals that of otherStack
    data = new char[otherStack.data.length];

    // set tos to the same position
    tos = otherStack.tos;

    // copy the contents
    for(int i = 0; i < tos; i++)
      data[i] = otherStack.data[i];
  }

  // Construct a stack with initial values.
  FixedLengthStack(char[] chrs) throws StackFullException {
    // create the array to hold the initial values
    data = new char[chrs.length];
    tos = 0;

    // initialize the stack by pushing the contents
    // of chrs onto it
    for(char ch : chrs)
      push(ch);
  }

  // Push a character onto the stack.
  public void push(char ch) throws StackFullException {
    if(isFull())
      throw new StackFullException(data.length);

    data[tos] = ch;
    tos++;
  }

  // Pop a character from the stack.
  public char pop() throws StackEmptyException {
    if(isEmpty())
      throw new StackEmptyException();

    tos--;
    return data[tos];
  }

  // Return true if the stack is empty.
  public boolean isEmpty() {
    return tos==0;
  }

  // Return true if the stack is full.
  public boolean isFull() {
    return tos==data.length;
  }
}

// A simple stack interface that throws exceptions.
public interface ISimpleStack {

  // Push a character onto the stack.
  void push(char ch) throws StackFullException;

  // Pop a character from the stack.
  char pop() throws StackEmptyException;

  // Return true if the stack is empty.
  boolean isEmpty();

  // Return true if the stack is full.
  boolean isFull();
}

// Demonstrate the stack exceptions.
class SimpleStackExcDemo {
  public static void main(String[] args) {
    FixedLengthStack stack = new FixedLengthStack(5);
    char ch;
    int i;

    try {
      // overrun the stack
      for(i=0; i < 6; i++) {
        System.out.print("Attempting to push : " +
                         (char) ('A' + i));
        stack.push((char) ('A' + i));
        System.out.println(" - OK");
      }
      System.out.println();
    }
    catch (StackFullException exc) {
      System.out.println(exc);
    }

    System.out.println();

    try {
      // over-empty the stack
      for(i=0; i < 6; i++) {
        System.out.print("Popping next char: ");
        ch = stack.pop();
        System.out.println(ch);
      }
    }
    catch (StackEmptyException exc) {
      System.out.println(exc);
    }
  }
}