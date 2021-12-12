import java.util.Scanner;

public final class Instruction {

  Instruction () {
    // not called
  }
  
  public static int incrementDataPointer(Memory array) {
    int p = array.getPointer();

    if ((p - 1) >= array.getArraySizie()) {
      return -1;
    }
    else {
      p++;
      array.setPointer(p);
      return 0;
    }
  }

  public static int decrementDataPointer(Memory array) {
    int p = array.getPointer();

    if(p <= 0) {
      return -1;
    }
    else {
      p--;
      array.setPointer(p);
      return 0;
    }
  }

  public static int incrementDataValue(Memory array) {
    int data = array.readData();

    if (data >= 126) {
      return -1;
    }
    else {
      data++;
      array.setData(data);
      
      return 0;
    }
  }

  public static int decrementDataValue(Memory array) {
    int data = array.readData();

    if (data <= -127) {
      return -1;
    }
    else {
      data--;
      array.setData(data);

      return 0;
    }
  }

  public static int outputByte(Memory array) {
    int data = array.readData();
    
    System.console().printf("%c", data);
    
    return 0;
  }

  public static int acceptByte(Memory array, Scanner in) {
    char data = in.nextLine().charAt(0);
    array.setData(data);
    return 0;
  }
}