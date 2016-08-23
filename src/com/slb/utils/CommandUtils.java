package com.slb.utils;

public class CommandUtils {

    private static CommandUtils command      = null;
    private        String       inputFile    = null;
    private        boolean      dumpToFile   = false;
    private        boolean      dumpToSTDOut = false;
    private        int          numberOfRuns = 1;
    private        int          stepSize     = 128;
    private        int          limit        = 10;

    private CommandUtils(String[] args) {

        int argLen         = args.length;
        int index          = 0;
        int classification = 0;

        while(index < argLen) {
            classification = classifyArg(args[index]);

            switch(classification) {
                case Globals.ARG_INPUT_FILE:
                    if(inputFile == null) {
                        inputFile = args[index];
                    } else {
                        System.out.println(String.format(Globals.WARNING_ILLEGAL_ARG, args[index]));
                    }
                    break;

                case Globals.ARG_DUMP_FILE:
                    if(dumpToSTDOut) {
                        System.out.println(Globals.COMMAND_DUMP_CONFLICT);
                        dumpToSTDOut = false;
                    }
                    dumpToFile = true;
                    break;

                case Globals.ARG_DUMP_STDOUT:
                    dumpToSTDOut = true;
                    if(dumpToFile) {
                        System.out.println(Globals.COMMAND_DUMP_CONFLICT);
                        dumpToSTDOut = false;
                    }
                    break;

                case Globals.ARG_NUM_RUNS:
                    numberOfRuns = Integer.parseInt(args[++index]);
                    break;

                case Globals.ARG_STEP_SIZE:
                    stepSize = Integer.parseInt(args[++index]);
                    break;

                case Globals.ARG_RUN_LIMIT:
                    limit = Integer.parseInt(args[++index]);
                    break;
            }

            index++;
        }
    }

    private int classifyArg(String arg) {

        switch(arg) {
            case Globals.COMMAND_DUMP_FILE:
                return Globals.ARG_DUMP_FILE;

            case Globals.COMMAND_DUMP_STDOUT:
                return Globals.ARG_DUMP_STDOUT;

            case Globals.COMMAND_RUNS:
                return Globals.ARG_NUM_RUNS;

            case Globals.COMMAND_STEP:
                return Globals.ARG_STEP_SIZE;

            case Globals.COMMAND_LIMIT:
                return Globals.ARG_RUN_LIMIT;

            default:
                return Globals.ARG_INPUT_FILE;
        }
    }

    public static CommandUtils getCommand() {

        if(command == null) {
            System.out.println(Globals.WARNING_SETUP_COMMANDUTIL);
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

    public int getLimit() {

        return limit;
    }
}
