import java.util.Random;

/**
 * This class generates random numbers for SSN based on area number, group number, serial number
 */
public class NumberGenerator{
    Random generate = new Random();
    private String areaNumber;
    private String groupNumber;
    private String serialNumber;

    /**
     * Generates area number for the SSN randomly
     * @return
     */
    public String getAreaNumber(){
        return this.areaNumber = String.format("%03d", generate.nextInt(999) +  1);
    }

    /**
     * Generates group number for the SSN randomly
     * @return
     */
    public String getGroupNumber(){
        return this.groupNumber = String.format("%02d", generate.nextInt(100));
    }

    /**
     * Generates serial number for the SSN randomly
     * @return
     */
    public String getSerialNumber(){
        return this.serialNumber = String.format("%04d", generate.nextInt(10000));
    }
}
