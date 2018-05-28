package it.gov.liceosilvestri.corsoapp.prova;

public class Peer {

    public static final int STATUS_CONNECTED = 1;
    public static final int STATUS_CONNECTING = 2;
    public static final int STATUS_DISCONNECTED = 3;
    public static final int STATUS_NOT_FOUND = 4;

    private String name;
    private String address;
    private int status;

    public Peer(String name, String address, int status) {
        this.name = name;
        this.address = address;
        this.status = status;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }
}
