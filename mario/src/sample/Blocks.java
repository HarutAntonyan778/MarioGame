package sample;

import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by harut on 4/9/17.
 */
public class Blocks {
    List<Bloc> blocs;
    List<CoinBloc> coinBlocs;


    public Blocks() {
        blocs = new ArrayList<>();
        blocs.add(new CoinBloc(500, Background.FOOTER - 80));
        blocs.add(new Bloc(660,Background.FOOTER - 80));
        blocs.add(new CoinBloc(690,Background.FOOTER - 80));
        blocs.add(new Bloc(720,Background.FOOTER - 80));
        blocs.add(new CoinBloc(750,Background.FOOTER - 80));
        blocs.add(new Bloc(780,Background.FOOTER - 80));
        blocs.add(new CoinBloc(720,Background.FOOTER - 180));


        blocs.forEach(bloc -> {
            bloc.run();
        });



    }
}
