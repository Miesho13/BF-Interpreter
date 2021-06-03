import java.util.Scanner;

public class Memory 
{
  private char array[];
  private int ptr;
  private Scanner in;

  public static void main(String[] args)
  {
    Memory mem = new Memory();
    mem.output();
    mem.incrementDataPtr();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.increment();
    mem.output();
    mem.incrementDataPtr();
    mem.input();
    mem.output();

  }

  Memory()
  {
    array = new char [1024 * 64];
    ptr = 0;
    in = new Scanner(System.in); 
  }

  public void incrementDataPtr()
  {
    ptr += 1;
  }

  public void decrementDataPointer()
  {
    if (ptr <= 0)
    {
      ptr = 0;
    }
    else
    {
      ptr -= 1;
    }
  }

  public void increment()
  {
    this.array[this.ptr] += 1;
  }

  public void decrement()
  {
    this.array[this.ptr] -= 1;
  }

  public char output()
  {
    System.out.println(array[ptr]);
    return array[ptr];
  }

  public void input()
  {
    array[ptr] = in.nextLine().charAt(0);
  }
  
}
