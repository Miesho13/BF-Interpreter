import java.util.Scanner;

public class Instruction {
  
  public static void incrementP(Memory mem) {
    mem.incrementPointer();
  }

  public static void decrementP(Memory mem) {
    mem.decrementPointer();
  }

  public static void incrementData(Memory mem) {
    int data = (int)mem.readDataFromMemory();

    data++;

    mem.setDataInMemory((char)data);
  }

  public static void printByteOnOutStream(Memory mem) {
    System.console().printf("%c", mem.readDataFromMemory());
  }

  public static void scanByteOfInput(Memory mem, Scanner scan) {
    char scanData = scan.nextLine().charAt(0);

    mem.setDataInMemory(scanData);
  }

  public static void jump(Memory mem, int where) {
    mem.setPointer(where);
  }

}