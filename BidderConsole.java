package observerpat;

import java.util.ArrayList;
import java.util.List;

public class BidderConsole {
    List<IClient> allBidders;
    int highestBid;
    String highestBidder;

    public BidderConsole(int hb) {
        allBidders = new ArrayList<>();
        highestBid = hb;
    }

    public void addBidder(IClient newBidder) {
        allBidders.add(newBidder);
        System.out.println("--> New bidder has been added");
    }

    public void removeBidder(String bidderName) {
        for (IClient bidder: allBidders) {
            if (bidder.getName().equals(bidderName)) {
                allBidders.remove(bidder);
                System.out.println("--> " + bidderName + " has been removed");
                return;
            }
        }

        System.out.println("-->Invalid Bidder");
    }

    public void viewBidder() {
        for (IClient bidder: allBidders) System.out.println("--> " + bidder.getName());
    }

    public void notifyAllbidders() {
        for (IClient bidder: allBidders) {
            bidder.update(highestBidder, highestBid);
        }
    }

    public void setBid(String currentBidderName, int currentBid) {

        for (IClient bidder: allBidders) {
            if (bidder.getName().equals(currentBidderName)) {
                if(currentBid <= highestBid) {
                    System.out.println("Bid can not be less than or equal "+ highestBid +" or current bid ");
                }
                else {
                    highestBid = currentBid;
                    highestBidder = currentBidderName;
                    notifyAllbidders();
                }
                return;
            }
        }
        System.out.println("Invalid Bidder Name!");
    }
}
