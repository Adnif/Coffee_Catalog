package unj.cs.hw4.data;
import java.util.Arrays;
import java.util.List;

import unj.cs.hw4.R;
import unj.cs.hw4.model.Coffee;

public class Datasource {

    public static Coffee[] coffees = new Coffee[]{
            new Coffee(R.string.affogato,R.drawable.affogato,R.string.affogatos,R.string.affogatol,false),
            new Coffee(R.string.americano,R.drawable.americano,R.string.americanos,R.string.americanol,false),
            new Coffee(R.string.caffe_latte,R.drawable.latte,R.string.caffe_lattes,R.string.caffe_lattel,false),
            new Coffee(R.string.caffe_mocha,R.drawable.mochas,R.string.caffe_mochas,R.string.caffe_mochal,false),
            new Coffee(R.string.caffe_aulait,R.drawable.aulait,R.string.caffe_aulaits,R.string.caffe_aulaitl,false),
            new Coffee(R.string.cappucino,R.drawable.cappucino,R.string.cappucinos,R.string.cappucinol,false),
            new Coffee(R.string.espresso,R.drawable.espresso,R.string.espressos,R.string.espressol,false),
            new Coffee(R.string.frappe,R.drawable.frappe,R.string.frappes,R.string.frappel,false),
            new Coffee(R.string.irish_coffee,R.drawable.irish,R.string.irish_coffees,R.string.irish_coffel,false),
            new Coffee(R.string.flat_white,R.drawable.flatewhite,R.string.flat_whites,R.string.flatwhitel,false)
    };

    public List<Coffee> loadCoffees = Arrays.asList(coffees);

    public List<Coffee> loadCoffee(){
        return loadCoffees;
    }
}
