package brainfuck;
/**
 * Object <code>Memory</code> is a memory on which the
 * interpreter will perform operations
 */
public class Memory {

  private byte[] array;
  
  private int pointer;

  private int arraySizie;

  /**
   * Constructor for Memory class
   * @param arraySize a value that determines the size of our memory   
   */
  Memory(int arraySize) {
    this.arraySizie = arraySize;
    this.array = new byte [arraySize];
    this.pointer = 0;
  }

  /**
   * Get the number of the moemory cell currently 
   * indiceted by the pointer 
   * @return Value of variable pointer
   */
  public int getPointer() {
    return pointer;
  }

  public void setPointer(int value) {
    this.pointer = value;
  }

  public int readData() {
    return this.array[pointer];
  }
  
  public void setData(int data) {
    if (data >= -128 && data <= 127) {
      this.array[pointer] = (byte)data;
    }
    else {
      this.array[pointer] = 0;
    }
  }

  public int getArraySizie() {
    return this.arraySizie;
  }

  public static void memoryComplexTest() {
    final String PRINT_POINTER = "Pointer = %d\n";

    Memory mem = new Memory(64 * 1024);
    
    System.console().printf("SOME TEST TO MEMORY CLASS:\n");

    System.console().printf(PRINT_POINTER, mem.pointer);
    
    System.console().printf(PRINT_POINTER, mem.readData());

    mem.setData(64);

    System.console().printf(PRINT_POINTER, mem.readData());
  }
  
  public static void main(String[] args) {
    memoryComplexTest();
  }
}