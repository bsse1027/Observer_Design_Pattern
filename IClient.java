package observerpat;

public interface IClient {
    //public String name;
    public String getName();
    public abstract void update(String highestBidder, int highestBid);

}
