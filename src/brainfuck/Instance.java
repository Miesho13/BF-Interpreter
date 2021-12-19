package brainfuck;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;


public class Instance {

  private int instructionCounter;

  private int stepCounter;

  private boolean isWorkingFlag;

  private String instrucionVector;

  private Deque<Integer> dqReturnStack;

  private Memory memory;

  private Scanner userInput;
  
  private Logger logger;

  public Instance(int memorySize) {

    this.logger = Logger.getLogger(Instance.class.getName());

    this.instructionCounter = 0;

    this.stepCounter = 0;

    this.isWorkingFlag = true;

    this.instrucionVector = "";

    this.dqReturnStack = new LinkedList<Integer>();

    this.memory = new Memory(memorySize);

    this.userInput = new Scanner(System.in);
  }


  public void terminate() {
    this.isWorkingFlag = false;
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
    if (!dqReturnStack.isEmpty()) {
      this.instructionCounter = this.dqReturnStack.peek();
      this.dqReturnStack.pop();
    }
  }


  public void oneStep() {
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
        case '\\':
          terminate();
          break;    
        default:
          
          break;
      }
      this.instructionCounter++;
      this.stepCounter++;
    }
    else {
      terminate();
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
      System.console().printf("BFInterpreter: fatal error: File not found\n");
      e.printStackTrace();
    
    }
  }

  public String getIncturctionVector() {
    return instrucionVector;
  }


  public int getInstructionCounter() {
    return this.instructionCounter;
  }

  public Deque getDqReturnStack() {
    return this.dqReturnStack;
  }

  public void intrepreterDebugLog() {

    StringBuilder tmp = new StringBuilder("");
    tmp.append(this.instrucionVector.charAt(this.instructionCounter - 1) + " ");
    tmp.append("dq" + this.dqReturnStack + "; ");
    tmp.append("Dtata = " + this.memory.readData() + "; ");
    tmp.append("IC = " + (this.instructionCounter - 1) + "; ");
    tmp.append("Step = " + (this.stepCounter -1) + ";\n");
    
    logger.log(Level.INFO, tmp.toString());
  }

}

