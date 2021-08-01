/**
 * Object <code>Memory</code> is a memory on which the
 * interpreter will perform operations
 */
public class Memory {

  private char[] array;
  
  private int pointer;
  /**
   * Constructor for Memory class
   * @param arraySize a value that determines the size of our memory   
   */
  Memory(int arraySize) {
    this.array = new char [arraySize];
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

  public void incrementPointer() {
    this.pointer++;
  }

  public void decrementPointer() {
    this.pointer--;
  }

  public char readDataFromMemory() {
    return this.array[pointer];
  }
  
  public void setDataInMemory(int data) {
    this.array[pointer] = (char)data;
  }

  public static void main(String[] args) {

    Memory mem = new Memory(64 * 1024);
    
    System.console().printf("SOME TEST TO MEMORY CLASS:\n");

    System.console().printf("Pointer = %d\n", mem.pointer);
    
    mem.incrementPointer();
    System.console().printf("Pointer = %d\n", mem.pointer);

    mem.decrementPointer();
    System.console().printf("Pointer = %d\n", mem.pointer);

    System.console().printf("Pointer = %d\n", (int)mem.readDataFromMemory());
    mem.setDataInMemory(64);
    System.console().printf("Pointer = %d\n", (int)mem.readDataFromMemory());

  }
}