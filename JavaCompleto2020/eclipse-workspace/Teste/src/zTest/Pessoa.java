package zTest;

public class Pessoa implements Comparable<Pessoa>{

    private String name;

    public Pessoa() {
    }

    public Pessoa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pessoa o) {
        return name.compareTo(o.name);
    }


}
