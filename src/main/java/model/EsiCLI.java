package model;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;
import java.util.List;

public class EsiCLI {
    private final String path = "--path";

    private final String invalidOption = "Invalid Option";
    private String[] args;
    private CmdLineParser parser;
    private String pfad;
    private final String startFrame ="--startframe";

    public EsiCLI() {

    }

    @Argument
    private List<String> arguments = new ArrayList<>();

    @Option(name = path, aliases = "-p", usage = "specifies path")
    private boolean pathBool;

    @Option(name=startFrame , aliases = "-s" ,usage = "specifies start frame")
    private boolean startFramebool;

    public List<String> getArguments() {
        return arguments;
    }

    public void parse(String... args) throws CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        parser.parseArgument(args);
        this.args = args;
        for (String s : arguments) {
            System.err.println("Program argument:" + s);
        }
        for (int i = 0; i < args.length; i++) {
            System.err.println(args[i]);
        }
    }

    // todo: method checks if parameter valid
    public void checkParams() {

    }


}
