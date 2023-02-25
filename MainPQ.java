import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainPQ {

    
    public static void readAndBuilt() {


        //String filename = "properties.txt";
        HashMap<String, ArrayList<String>> realEstates = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zcind\\IdeaProjects\\YAP441\\src\\properties.txt"))) {
            String line;
            String currentRealEstate = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("�sim:")) {
                    currentRealEstate = line.substring(line.indexOf(":") + 1).trim();
                    realEstates.put(currentRealEstate, new ArrayList<>());
                } else if (currentRealEstate != null) {
                    String[] parts = line.split(":");
                    if (parts.length > 1) {
                        String propertyName = parts[0].trim();
                        String propertyValue = parts[1].trim();
                        realEstates.get(currentRealEstate).add(propertyName + ": " + propertyValue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        // print the properties for each real estate
        for (String realEstate : realEstates.keySet()) {
            //System.out.println("Properties for " + realEstate + ":");
            for (String property : realEstates.get(realEstate)) {
                String s = property.split(":")[1].trim();
                switch (property.split(":")[0].trim()) {

                    case "Kullanim Durumu":
                        System.out.println(s);
                }

            }
            //System.out.println();
        }

         */


        PropertyPriorityQueue ppq = new PropertyPriorityQueue(5000);
        for (String realEstate : realEstates.keySet()) {
            //System.out.println(realEstate);
            Property current = new Property(realEstate);

            for (String property : realEstates.get(realEstate)) {
                String s = property.split(":")[1].trim();
                switch (property.split(":")[0].trim()) {

                    case "Fiyat":
                        current.setPrice(s);
                    case "Ilan no":
                        current.setNo(s);
                    case "Son Guncelleme Tarihi":
                        current.setLastUptadeDate(s);
                    case "Ilan Durumu":
                        current.setStatus(s);
                    case "Konut Sekli":
                        current.setType(s);
                    case "Oda + Salon Sayisi":
                        current.setNumberOfRooms(s);
                    case "Brut / Net M2":
                        current.setPropertySize(s);
                    case "Bulundugu Kat":
                        current.setFloor(s);
                    case "Bina Yasi":
                        current.setAgeOfBuilding(s);
                    case "Isinma Tipi":
                        current.setHeatingType(s);
                    case "Kat Sayisi":
                        current.setTotalFloors(s);
                    case "Krediye Uygunluk":
                        current.setCreaditAvailability(s);
                    case "Esya Durumu":
                        current.setFurnishStatus(s);
                    case "Banyo Sayisi":
                        current.setTotalBathrooms(s);
                    case "Yapi Tipi":
                        current.setBuildingType(s);
                    case "Yapinin Durumu":
                        current.setCondition(s);
                    case "Kullanim Durumu":
                        current.setUsageCondition(s);
                    case "Tapu Durumu":
                        current.setDeed(s);
                    case "Aidat":
                        current.setFee(s);
                    case "Takas":
                        current.setSwap(s);
                    case "Cephe":
                        current.setFront(s);
                    case "Kira Getirisi":
                        current.setRentIncome(s);
                    case "Yakit Tipi":
                        current.setFuelType(s);
                    case "Yetkili Ofis":
                        current.setOffice(s);
                }
                ppq.insert(current);


            }

        }

        //System.out.println(ppq.getHeap()[0].getCondition());


    }

    public static void main(String[] args) {
        readAndBuilt();
    }
}
