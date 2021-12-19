import brainfuck.*;


public class BFInterpreter {

  static final  int MEMORYSIZE = 64 * 1024;

  public static void main(String[] arg)  {
    
    if (arg.length == 0) {
      noArgumentError();  
    }
    else if (arg.length > 1) {
      toManyArgumentError();
    }
    else if (arg[0].equals("-h") || arg[0].equals("--help")) {
      helpFlag();
    }
    else {
      Instance instance = new Instance(MEMORYSIZE);
      instance.loadFromFile(arg[0]);
      while(instance.isWokring()) {
        instance.oneStep();
        //instance.intrepreterDebugLog();
      }
    }

    System.console().printf("\nInterpret END");
  }

  static void noArgumentError() {
    System.console().printf("BFInterpreter: fatal error: no input fles\n");
    
  }

  static void toManyArgumentError() {
    System.console().printf("BFInterpreter: fatal error: to many arguments\n");
  }

  static void helpFlag() {
    System.console().printf("Usage: BFInterpreter [file to interpret]\n");
  }
}