import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic {

  private File patientFile;
  private int day;
 
    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    // Constructor that takes a String (filename) and chains to the other constructor
    public Clinic(String fileName) {
        // Assuming the file extension is ".csv"
        this(new File(fileName));
    }
    public String nextDay(File f) throws FileNotFoundException {
      day++;
      String output = "";
      Scanner fileScan = new Scanner(f);
      Scanner input  = new Scanner(System.in);

      String line = null;

      while (fileScan.hasNextLine()) {
        line = fileScan.nextLine();
        String[] pInfo = line.split(",");
        String name = pInfo[0];
        String species = pInfo[1];
        String stat = pInfo[2];
        String timeIn = pInfo[3];

        if(!(species.equals("Dog") || species.equals("Cat"))) {
          throw new InvalidPetException();
        }

        System.out.printf("Consultation for %s the %s at %s.\n", name, species, timeIn);
        double health = 0;
        int painLevel = 0;
        boolean validHealth = false;
        boolean validPain = false;

        while (!validHealth) {
          System.out.printf("What is the health of %s?\n", name);
          if (input.hasNextDouble()) {
            health = input.nextDouble();
            validHealth = true;
          } else {
            input.nextLine();
            System.out.println("Please enter a number");
          }
        }

        while (!validPain) {
          System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
          if (input.hasNextInt()) {
            painLevel = input.nextInt();
            validPain = true;
          } else {
            System.out.println("Please enter a number");
          }
        }

        Pet petPatient;
        switch(species) {
          case "Dog":
          petPatient = new Dog(name, health, painLevel, Double.parseDouble(stat));
          break;
          case "Cat":
          petPatient = new Cat(name, health, painLevel, Integer.parseInt(stat));
          break;
          default: 
          throw new InvalidPetException();
        }

        health = petPatient.getHealth();
        painLevel = petPatient.getPainLevel();
        petPatient.speak();
        int treatmentTime = petPatient.treat();
        String timeOut = addTime(timeIn, treatmentTime);
        output += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n", name, species, stat, day, timeIn, timeOut, String.valueOf(health), painLevel);
      }
      fileScan.close();
      input.close();
      return output.trim();
    }

    public String nextDay(String fileName) throws FileNotFoundException {
      return nextDay(new File(fileName));
    }


    private String addTime(String timeIn, int treatmentTime) {
      int m = Integer.parseInt(timeIn.substring(2, 4)) + treatmentTime % 60;
      int h = Integer.parseInt(timeIn.substring(0, 2)) + treatmentTime / 60 + m / 60;
      m = m % 60;
      return String.format("%02d%02d", h, m);
  }

  public boolean addToFile(String patientInfo) {
    String[] p = patientInfo.split(",");
    String name = p[0];
    String update = String.format(",%s,%s,%s,%s,%s", p[3], p[4], p[5], p[6], p[7]);
    String patients = "";
    boolean returningPatient = false;
    try (Scanner pReader = new Scanner(patientFile)) {
        while (pReader.hasNextLine()) {
            String pInfo = pReader.nextLine();
            if (name.equals(pInfo.split(",")[0])) {
                returningPatient = true;
                patients += pInfo + update + "\n";
            } else {
                patients += pInfo + "\n";
            }
        }
    } catch (FileNotFoundException e) {
        return false;
    }
    patients = returningPatient ? patients : patients + patientInfo + "\n";
    try (PrintWriter pWriter = new PrintWriter(patientFile)) {
        pWriter.write(patients);
    } catch (FileNotFoundException e) {
        return false;
    }
    return true;
}
    
  
    public static void main(String[] args) {
    }

}


//     boolean addToFile(String patientInfo)
//         Consumes a string representing a single appointment
//             Eg. In format:
//             [Name],[Species],[DroolRate/MiceCaught],[Day],[EntryTime],[ExitTime],[InitialHealth],[InitialPainLevel]
//         Write info to patientFile
//             If old patient, only the appointment info should be added to the patient file, which includes:
//                 Day #
//                 Time in and time out
//                 Health and pain
//             If new patient, all info should be added to the clinic’s patient file
//             Assume the vet will never see two different pets with the same name
//             See Patients.csv for an example
//         Returns true if the appointment info was successfully written, and false if an error occurs or a checked exception is caught
//         Note (cont’d): Don’t try to read the file and write to it at the same time – this method is intended to rewrite the file.
//     String addTime(String timeIn, int treatmentTime)
//         This method should only be accessible in the Clinic class
//         This method should calculate the time the patient’s appointment ends
//         Return timeOut
//         Remember: timeIn and timeOut should be represented in military time
//         You can assume that timeIn and timeOut will NOT go across multiple days (ex. timeIn = “23:30” and timeOut = “00:30”)
