package sample;

public class Vooluring {
    String name;
    float Voolutugevus;
    float pinge;
    float takisti;

    Vooluring(String name, float Voolutugevus, float pinge, float takisti) {
        this.name = name;
        this.Voolutugevus = Voolutugevus;
        this.pinge = pinge;
        this.takisti = takisti;

    }

    Vooluring() {
        this.name = "unknown";
        this.Voolutugevus = 0;
        this.pinge = 0;
        this.takisti = 0;
    }


    void give_info() {
        System.out.println("Voolutugevus: " + this.Voolutugevus +"A ,"+
                " Pinge: "+this.pinge +"V ,"+" Takisti: "+ this.takisti+ "Ω");
    }
}