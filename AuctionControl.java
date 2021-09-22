package observerpat;

import java.io.Console;
import java.util.Scanner;

public class AuctionControl {
    BidderConsole console;
    Scanner iNum;
    Scanner iString;
    int highestBid;

    public AuctionControl() {
        iNum = new Scanner(System.in);
        iString = new Scanner(System.in);

//        console = new Console();
    }

    public void startPhase() {
        while (true) {
            System.out.println("Auction Pre-Starting Phase:");
            System.out.println("1) Choose minimum Bid");
            System.out.println("2) Add Bidders");
            System.out.println("3) Remove Bidders");
            System.out.println("4) View All Bidders");
            System.out.println("5) Start Auction");
            System.out.print("Enter option: ");

            int option = iNum.nextInt();
            String newName;

            if(option ==1)
            {

                highestBid = iNum.nextInt();

                console = new BidderConsole(highestBid);

            }

            if(option==2)
            {
                System.out.print("Enter Name: ");
                newName = iString.nextLine();
                console.addBidder(new ClientBid(newName));
            }

            else if (option==3)
            {
                System.out.print("Enter Name: ");
                newName = iString.nextLine();
                console.removeBidder(newName);
            }

            else if(option==4)
            {
                console.viewBidder();
            }

            else if (option == 5)
            {
                break;
            }
        }
    }

    public void BiddingPhase() {
        System.out.println("Bidding phase started \n Bet must be above" + highestBid);
        while (true) {
            System.out.println("1)Place Bid\n 2) End Bid");
            System.out.print("Enter option: ");

            int option = iNum.nextInt();

            if(option==1)
            {
                System.out.print("Enter Name: ");
                String name = iString.nextLine();
                System.out.print("Enter Bid: ");
                int bid = iNum.nextInt();

                console.setBid(name, bid);
            }

            if(option==2)
            {
                if (console.highestBid == highestBid) System.out.println("--> Item Unsold");
                else System.out.println("--> Item sold to " + console.highestBidder + " for $" + console.highestBid);
                break;
            }
        }
    }

}
