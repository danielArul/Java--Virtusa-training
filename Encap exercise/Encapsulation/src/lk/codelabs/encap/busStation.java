package lk.codelabs.encap;

import java.util.ArrayList;

public class busStation {

    public static ArrayList<Bus> buses;

    public void getBuses() {
        System.out.println(buses);
    }

    public static void setBuses(ArrayList<Bus> buses) {
        busStation.buses = buses;
    }

    public void addBus(Bus bus){
        buses.add(bus);
    }

    public void addBus(String color){
        buses.add(new Bus(color));
    }

   public void Validate(String color){
        new Object(){
            public void colorValidate() {
                if ("Red".equalsIgnoreCase(color)) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }

            }

        }.colorValidate();

        for(int x=0;x<10;x++){
        System.out.println(x);
        }
   }

    public busStation(String color){
        buses.add(new Bus(color));
    }

//    static {
//
//
//        buses=new ArrayList<>();
//        buses.add(new Bus("Red"));
//        buses.add(new Bus("Green"));
//        buses.add(new Bus("White"));
//        buses.add(new Bus("Blue"));
//        buses.add(new Bus("Pink"));
//
//    }

    public busStation() {
    }

    public class Bus {

        private String model;
        private String color;

        public Bus(String color) {

            this.color = color;
        }


        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Bus{" +
                    "model='" + model + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
