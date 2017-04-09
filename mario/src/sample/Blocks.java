package sample;

import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harut on 4/9/17.
 */
public class Blocks {
    List<Bloc> blocs;


    public Blocks() {
        blocs = new ArrayList<>();
        blocs.add(new Bloc(500, Background.FOOTER - 80));
        blocs.add(new Bloc(650,Background.FOOTER - 80));
        blocs.add(new Bloc(680,Background.FOOTER - 80));
        blocs.add(new Bloc(710,Background.FOOTER - 80));
        blocs.add(new Bloc(740,Background.FOOTER - 80));
        blocs.add(new Bloc(770,Background.FOOTER - 80));

        blocs.forEach(bloc -> {
            bloc.run();
        });

    }
}
