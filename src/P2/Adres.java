package P2;

public class Adres {
    private int id;
    private String postcode;

    public Adres(int id, String postcode) {
        this.id = id;
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String pc) {
        this.postcode = postcode;
    }

    public String toString() {
        String s = " ";
        return id + "heeft" + postcode;

    }

}
