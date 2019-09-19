package lk.codelabs.encap;

public class Application {

    public static void main(String[] args) {


        busStation bStation=new busStation();
        bStation.addBus("Green");
        bStation.addBus((bStation.new Bus("red"));
        bStation.addBus(new busStation().new Bus("Blue"));

        bStation.getBuses();

    }
}
