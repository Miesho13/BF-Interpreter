import java.io.FileNotFoundException;
import java.util.Scanner;


import java.io.File;

public class BrainFuck
{
  private String code;

  private Scanner fileReader;

  private File inputFile;

  private Memory mem;

  private int step;

  private Boolean isTerminated;

  private int loopWhereReturn;

  private int endCommend;

  public static void main(String[] args)
  {

    BrainFuck bf = new BrainFuck(args[0]);

    int howMany = 108;
    while (bf.isTerm() == false)
    {
      bf.singleStep(bf.getCommand(bf.getStep()));

      howMany--;
    }

  }

  BrainFuck(String fileName)
  {
    step = 0;
    mem = new Memory();
    isTerminated = false;

    try
    {
      this.inputFile = new File(fileName);
      this.fileReader = new Scanner(this.inputFile);
      this.code = "";
      while (fileReader.hasNextLine())
      {
        this.code += fileReader.nextLine();
      }
      this.code = code.replace(" ", "");
      this.code = code.replace("\t", "");
      endCommend = code.length();
      System.out.println(endCommend);
      System.out.println(code);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("An erro occurred.");
      e.printStackTrace();
    }    
  }

  public int getStep()
  {
    return step;
  }

  public char getCommand(int index)
  {
    return this.code.charAt(index);
  }

  public void printBuffer()
  {
    System.out.println(this.code);
  }

  public void singleStep(char command)
  {
    
    switch (command)
    {
      case '>':
        mem.incrementDataPtr();
        break;
      case '<':
        mem.decrementDataPointer();
        break;
      case '+':
        mem.increment();
        break;
      case '-':
        mem.decrement();
        break;
      case '.':
        mem.output();
        break;
      case ',':
        mem.input();
        break;
      case '[':
        startLoop();
        break;
      case ']':
        endLoop();
        break;
      default:
        crash();
        break;
    }
    //System.out.println("Step" + step);
    step++;
    if (step >= endCommend)
    {
      //System.out.println("Crash");
      crash();
    }
  }

  public Boolean isTerm()
  {
    return this.isTerminated;
  }

  public void crash()
  {
    this.isTerminated = true;
  }

  public void startLoop()
  {
    this.loopWhereReturn = this.step;
    if ((int)mem.output() == 0)
    {
      while (code.charAt(step) != ']')
      {
        step++;
      }
    }
  }

  public void endLoop()
  {
    step = loopWhereReturn;
  }

}