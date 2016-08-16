package com.slb.utils;

public class CommandUtils {

    private static CommandUtils command = null;

    private String inputFile = null;
    private boolean dumpToFile = false;
    private boolean dumpToSTDOut = false;
    private int numberOfRuns = 1;
    private int stepSize = 128;

    private CommandUtils() {

    }

    private CommandUtils(String[] args) {
        int argLen = args.length;
        int index = 0;

        while(index < argLen) {
            int classification = classifyArg(args[index]);

            switch(classification) {
                case 1:
                    if(inputFile == null) {
                        inputFile = args[index];
                    } else {
                        System.out.println("WARNING: Unidentified argument '" + args[index] + "'.");
                    }
                    break;
                case 2:
                    if(dumpToSTDOut) {
                        System.out.println("WARNING: Cannot dump to both the file and STDOut. Giving priority to file.");
                        dumpToSTDOut = false;
                    }
                    dumpToFile = true;
                    break;
                case 3:
                    dumpToSTDOut = true;
                    if(dumpToFile) {
                        System.out.println("WARNING: Cannot dump to both the file and STDOut. Giving priority to file.");
                        dumpToSTDOut = false;
                    }
                    break;
                case 4:
                    numberOfRuns = Integer.parseInt(args[++index]);
                    break;
                case 5:
                    stepSize = Integer.parseInt(args[++index]);
                    break;
            }

            index++;
        }
    }

    private int classifyArg(String arg) {
        if(arg.equals("-gf")) {
            return 2;
        } else if(arg.equals("-gs")) {
            return 3;
        } else if(arg.equals("-runs")) {
            return 4;
        } else if(arg.equals("-step")) {
            return 5;
        } else {
            return 1;
        }
    }

    public static CommandUtils getCommand() {
        if(command == null) {
            System.out.println("WARNING: Setup CommandUtils before using it.");
            return command;
        } else {
            return command;
        }
    }

    public static CommandUtils setupCommand(String[] args) {
        if(command == null) {
            command = new CommandUtils(args);
        }

        return command;
    }

    public String getInputFile() {
        return inputFile;
    }

    public boolean isDumpToFile() {
        return dumpToFile;
    }

    public boolean isDumpToSTDOut() {
        return dumpToSTDOut;
    }

    public int getNumberOfRuns() {
        return numberOfRuns;
    }

    public int getStepSize() {
        return stepSize;
    }
}
