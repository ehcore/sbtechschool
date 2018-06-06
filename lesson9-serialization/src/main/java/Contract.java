import java.io.*;

public class Contract implements Serializable{
    private static final long serialVersionUID = 4864822339117947047L;
    private int id;
    private String name;
    private String address;

    public Contract(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private Object writeReplace(){
        return new ContractProxy(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    private static class ContractProxy implements Serializable{
        private static final long serialVersionUID = -2470652563074659606L;
        private int id;
        private String name;
        private String address;

        ContractProxy(Contract contract) {
            this.id = contract.id;
            this.name = contract.name;
            this.address = contract.address;
        }

        private Object readResolve(){
            return  new Contract(id,name,address);
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
