class App {
  public static void main(String args[]){
    System.out.println(App.finalCosts(
      pickUpConfirmation(pickUpDate, numberOfDays), 
      basicRentalCost(numberOfDays, baseCost), 
      optionsCost(
        tollCost(numberOfDays, tollConfirm, tollPrice),
        gpsCost(numberOfDays, gpsConfirm, gpsPrice),
        roadsideCost(numberOfDays, roadsideConfirm, roadsidePrice)),
      underageSurchargeCost(numberOfDays, driverAge, underageSurcharge, baseCost),
      totalCost(
        basicRentalCost(numberOfDays, baseCost), 
        optionsCost(
          tollCost(numberOfDays, tollConfirm, tollPrice),
          gpsCost(numberOfDays, gpsConfirm, gpsPrice),
          roadsideCost(numberOfDays, roadsideConfirm, roadsidePrice)), 
        underageSurchargeCost(numberOfDays, driverAge, underageSurcharge, baseCost))));
  }

  private static String pickUpDate = "5/24/2022";
  private static int numberOfDays = 4;
  private static double baseCost = 29.99;
  private static boolean tollConfirm = true;
  private static boolean gpsConfirm = true;
  private static boolean roadsideConfirm = true;
  private static double tollPrice = 3.95;
  private static double gpsPrice = 2.95;
  private static double roadsidePrice = 3.95;
  private static int driverAge = 24;
  private static double underageSurcharge = 0.30;


  public static String finalCosts(String pickupDate, double basicRentalCost, double optionsCost, double underageSurchargeCost, double totalCost){
    StringBuilder costs = new StringBuilder();
    costs.append(pickupDate);
    costs.append(String.format(" Your base rental cost is $%f", basicRentalCost));
    costs.append(String.format(" The cost for selected options is $%f", optionsCost));
    costs.append(String.format(" The additional cost for an underage driver is $%f", underageSurchargeCost));
    costs.append(String.format(" The total cost for your rental will be $%f", totalCost));

    return costs.toString();
  }

  private static double basicRentalCost(int numberOfDays, double baseCost) {
    return numberOfDays * baseCost;
  }

  private static String pickUpConfirmation(String pickupDate, int numberOfDays) {
    StringBuilder pickUp = new StringBuilder();
    pickUp.append(String.format("Picking up on %s", pickupDate));
    pickUp.append(String.format(" for %d days", numberOfDays));
    return pickUp.toString();
  }

  private static double tollCost(int numberOfDays, boolean tollConfirm, double tollPrice){
    if (tollConfirm) {
      return numberOfDays * tollPrice;
    } else {
      return 0;
    }
  }

  private static double gpsCost(int numberOfDays, boolean gpsConfirm, double gpsPrice){
    if (gpsConfirm) {
      return numberOfDays * gpsPrice;
    } else {
      return 0;
    }
  }

  private static double roadsideCost(int numberOfDays, boolean roadsideConfirm, double roadsidePrice){
    if (roadsideConfirm) {
      return numberOfDays * roadsidePrice;
    } else {
      return 0;
    }
  }

  private static double optionsCost(double tollCost, double gpsCost, double roadsideCost) {
    return tollCost + gpsCost + roadsideCost;
  }

  private static double underageSurchargeCost(int numberOfDays, int driverAge, double underageSurcharge, double baseCost) {
    double surchargeCost;
    if (driverAge < 25) {
      return numberOfDays * baseCost * underageSurcharge;
    } else {
      return 0;
    }
  }

  private static double totalCost(double basicRentalCost, double optionsCost, double underageSurchargeCost){
    return basicRentalCost + optionsCost + underageSurchargeCost;
  }
}
