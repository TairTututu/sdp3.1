interface ElectricDevice {
    void plugin();
    void unplug();
}

class Iron implements ElectricDevice {
    @Override
    public void plugin(){System.out.println("Iron is connected to plug");}
    @Override
    public void unplug(){System.out.println("Iron is unplugged");}
}

class WaterFilter{
    public void connectToWater(){
        System.out.println("Water filter is connected to supply");
    }
}

class ElectricAdapter implements ElectricDevice {
    private WaterFilter waterFilter;

    public ElectricAdapter(WaterFilter waterFilter) {
        this.waterFilter = waterFilter;
    }

    @Override
    public void plugin() {
        waterFilter.connectToWater();
        System.out.println("Adapter is plugged into the socket.");
    }

    @Override
    public void unplug() {
        System.out.println("Adapter is unplugged from the socket.");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricDevice iron = new Iron();
        WaterFilter waterFilter = new WaterFilter();
        ElectricDevice adapter = new ElectricAdapter(waterFilter);

        iron.plugin();
        iron.unplug();

        adapter.plugin();
        adapter.unplug();
    }
}