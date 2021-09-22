package observerpat;

public class ClientBid implements IClient {

    String name;

    public ClientBid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String highestBidder, int currentBid) {
        if (highestBidder.equals(this.name)) {
            System.out.println("--> " + name + "'s console: You are the highest bidder with current bid of $" + currentBid);
        }
        else {
            System.out.println(
                    "--> "+ name + " 's console: " + highestBidder + " is the highest bidder with current bid of $" + currentBid);
        }
    }
}
