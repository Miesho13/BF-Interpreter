package brainfuck;

import java.util.*;

import javax.swing.border.EmptyBorder;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;

public class Instance {

  private int instructionCounter;

  private boolean isWorkingFlag;

  private String instrucionVector;

  private Deque<Integer> dqReturnStack;

  private Memory memory;

  private Scanner userInput;


  public Instance(int memorySize) {
    this.instructionCounter = 0;

    this.isWorkingFlag = true;

    this.instrucionVector = "";

    this.dqReturnStack = new LinkedList<Integer>();

    this.memory = new Memory(memorySize);

    this.userInput = new Scanner(System.in);
  }


  public void stopInterpreter() {
    this.isWorkingFlag = false;
  }


  public String getIncturctionVector() {
    return instrucionVector;
  }


  public int getInstructionCounter() {
    return this.instructionCounter;
  }


  public boolean isWokring() {
    return this.isWorkingFlag;
  }


  public void beginLoop() {
    if (memory.readData() == 0) {
      while (this.instrucionVector.charAt(instructionCounter) != ']') {
        instructionCounter++;
      }
      
    }
    else {
      this.dqReturnStack.addFirst(instructionCounter - 1);
    }
  }


  public void endLoop() {
    if (dqReturnStack.isEmpty()) {
      ;
    }
    else
    {
      this.instructionCounter = this.dqReturnStack.peek();
      this.dqReturnStack.pop();
    }
  }

  public void printDequeue() {
    System.out.print("DQ: "+this.dqReturnStack);
  }

  public void oneStep() {
    //System.console().printf("%c  ",instrucionVector.charAt(instructionCounter));
  
    if (this.instrucionVector.length() != 0)
    {
      switch (this.instrucionVector.charAt(this.instructionCounter)) {
        case '>':
          Instruction.incrementDataPointer(this.memory);
          break;
        case '<':
          Instruction.decrementDataPointer(this.memory);
          break;
        case '+':
          Instruction.incrementDataValue(this.memory);
          break;
        case '-':
          Instruction.decrementDataValue(this.memory);
          break;
        case '.':
          Instruction.outputByte(this.memory);
          break;
        case ',':
          Instruction.acceptByte(this.memory, userInput);
          break;
        case '[':
          beginLoop();
          break;
        case ']':
          endLoop();
          break;    
        default:
          stopInterpreter();
          break;
      }
      this.instructionCounter++;
      //System.console().printf("Memory value: %d | ", memory.readData());
    }
    else {
      stopInterpreter();
    }
  }
  

  static void removeBlankSpace(StringBuilder sb) {
    int j = 0;
    for(int i = 0; i < sb.length(); i++) {
      if (!Character.isWhitespace(sb.charAt(i))) {
         sb.setCharAt(j++, sb.charAt(i));
      }
    }
    sb.delete(j, sb.length());
  }


  public void loadFromFile(String filePath) {
    try {
      File code = new File(filePath);

      Scanner fileInput = new Scanner(code);

      StringBuilder sB = new StringBuilder(this.instrucionVector);

      while (fileInput.hasNextLine()) {
        sB.append(fileInput.nextLine());  

      }
      sB.append("\\");
      removeBlankSpace(sB);
      this.instrucionVector = sB.toString();
      fileInput.close();

    }
    catch (FileNotFoundException e) {
      System.console().printf("File not found\n");
      e.printStackTrace();
    
    }
  }

}

