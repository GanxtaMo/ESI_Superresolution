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
    @Argument
    private List<String> arguments = new ArrayList<>();

    @Option(name = path, aliases = "-p", usage = "specifies path")
    private boolean pathBool;


    public EsiCLI(final String... args) {
        this.args = args;

    }

    public void parse(String... args) throws CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        parser.parseArgument(args);
    }


}
