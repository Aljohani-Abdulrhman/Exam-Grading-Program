
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;


public class OTSTest {

	public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here   
        OTSEngine ots;
        StringBuilder results = new StringBuilder();
        File file = new File("input.txt");
        Scanner read = new Scanner(file);
        String[] commandArgument = read.nextLine().split(",");
        if (commandArgument[0].trim().equals("initializeSizeOfArrays")) {
            ots = new OTSEngine(Integer.parseInt(commandArgument[1]), Integer.parseInt(commandArgument[2]), Integer.parseInt(commandArgument[3]), Integer.parseInt(commandArgument[4]));
        } else {
            ots = new OTSEngine(30, 30, 30, 30);
        }

        while (read.hasNextLine()) {
            commandArgument = read.nextLine().split(",");
            switch (commandArgument[0].trim()) {
                case "addLogisticPartner": {
                    int id = Integer.parseInt(commandArgument[1].trim());
                    String name = commandArgument[2].trim();
                    String nationality = commandArgument[3].trim();
                    Date dateOfBirth = new Date(Integer.parseInt(commandArgument[4].trim()), Integer.parseInt(commandArgument[5].trim()), Integer.parseInt(commandArgument[6].trim()));
                    char gender = commandArgument[7].trim().charAt(0);
                    int phone = Integer.parseInt(commandArgument[8].trim());
                    String address = commandArgument[9].trim();
                    String company = commandArgument[10].trim();
                    int regNumber = Integer.parseInt(commandArgument[11].trim());
                    boolean operational = Boolean.getBoolean(commandArgument[12].trim());
                    double ratePerKG = Double.parseDouble(commandArgument[13].trim());
                    results.append(ots.addLogisticPartner(id, name, nationality, dateOfBirth, id, phone, id, gender, company, regNumber, operational, ratePerKG, phone, address)).append("\n");
                    break;
                }
                case "addSeller": {
                    int id = Integer.parseInt(commandArgument[1].trim());
                    String name = commandArgument[2].trim();
                    String nationality = commandArgument[3].trim();
                    Date dateOfBirth = new Date(Integer.parseInt(commandArgument[4].trim()), Integer.parseInt(commandArgument[5].trim()), Integer.parseInt(commandArgument[6].trim()));
                    char gender = commandArgument[7].trim().charAt(0);
                    int phone = Integer.parseInt(commandArgument[8].trim());
                    String address = commandArgument[9].trim();
                    String company = commandArgument[10].trim();
                    int regNumber = Integer.parseInt(commandArgument[11].trim());
                    boolean operational = Boolean.getBoolean(commandArgument[12].trim());
                    int licenseNo = Integer.parseInt(commandArgument[13].trim());
                    results.append(ots.addSeller(id, name, nationality, dateOfBirth, id, phone, id, gender, licenseNo, company, regNumber, operational, phone, address)).append("\n");
                    break;
                }
                case "addBuyer": {
                    int id = Integer.parseInt(commandArgument[1].trim());
                    String name = commandArgument[2].trim();
                    String nationality = commandArgument[3].trim();
                    Date dateOfBirth = new Date(Integer.parseInt(commandArgument[4].trim()), Integer.parseInt(commandArgument[5].trim()), Integer.parseInt(commandArgument[6].trim()));
                    char gender = commandArgument[7].trim().charAt(0);
                    int phone = Integer.parseInt(commandArgument[8].trim());
                    String address = commandArgument[9].trim();
                    results.append(ots.addBuyer(id, name, nationality, dateOfBirth, id, phone, id, gender, phone, address)).append("\n");
                    break;
                }
                case "addItem": {
                    int itemId = Integer.parseInt(commandArgument[1].trim());
                    String itemName = commandArgument[2].trim();
                    double price = Double.parseDouble(commandArgument[3].trim());
                    int inStock = Integer.parseInt(commandArgument[4].trim());
                    int sellerId = Integer.parseInt(commandArgument[5].trim());
                    results.append(ots.addItem(itemId, itemName, price, inStock, sellerId)).append("\n");
                    break;
                }
                case "initializeOrder": {
                    int buyerId = Integer.parseInt(commandArgument[1].trim());
                    int totItem = Integer.parseInt(commandArgument[2].trim());
                    results.append(ots.initializeOrder(buyerId, totItem)).append("\n");
                    break;
                }
                case "addItemToOrder": {
                    int orderId = Integer.parseInt(commandArgument[1].trim());
                    int buyerId = Integer.parseInt(commandArgument[2].trim());
                    int itemId = Integer.parseInt(commandArgument[3].trim());
                    results.append(ots.addItemToOrder(orderId, buyerId, itemId)).append("\n");
                    break;
                }
                case "associateLogisticPartnerToOrder": {
                    int orderId = Integer.parseInt(commandArgument[1].trim());
                    int logisticPartnerId = Integer.parseInt(commandArgument[2].trim());
                    double weightOfPackageInKG = Double.parseDouble(commandArgument[3].trim());
                    results.append(ots.associateLogisticPartnerToOrder(orderId, logisticPartnerId, weightOfPackageInKG)).append("\n");
                    break;
                }
                case "updateOrderStatus": {
                    int orderId = Integer.parseInt(commandArgument[1].trim());
                    String orderDesc = commandArgument[2].trim();
                    results.append(ots.updateOrderStatus(orderId, orderDesc)).append("\n");
                    break;
                }
                case "printOrderOfBuyer": {
                    results.append("*********************************Details of order**************************************************************************");
                    int buyerId = Integer.parseInt(commandArgument[1].trim());
                    int orderId = Integer.parseInt(commandArgument[2].trim());
                    results.append(ots.printOrderOfBuyer(buyerId, orderId)).append("\n");
                    break;
                }
                case "printSpecificItemsForSeller": {
                    results.append("********************************* Seller's Items**************************************************************************");
                    int sellerId = Integer.parseInt(commandArgument[1].trim());
                    results.append(ots.printSpecificItemsForSeller(sellerId)).append("\n");
                    break;
                }
                case "printTransactionsOfSeller": {
                    results.append("**********************************The records of the transactions of seller************************************************");
                    int sellerId = Integer.parseInt(commandArgument[1].trim());
                    results.append(ots.printTransactionsOfSeller(sellerId)).append("\n");
                    break;
                }
                case "printTransactionsOfBuyer": {
                    results.append("**********************************The records of the transactions of buyer************************************************");
                    int buyerId = Integer.parseInt(commandArgument[1].trim());
                    results.append(ots.printTransactionsOfBuyer(buyerId)).append("\n");
                    break;
                }
            }
        }

        read.close();
        System.out.println(results);
        File outputFile = new File("output.txt");
        PrintWriter out = new PrintWriter(outputFile);
        out.print(results);
        out.close();
    }

}
