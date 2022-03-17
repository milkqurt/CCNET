package CCNET;

public class CRC {

    private final long polynomial = 0x08408;

    public long GetCRC (byte[] bufData, long sizeData){
        long CRC = 0;
        for (int i = 0; i < sizeData; i++) {
            CRC ^= bufData[i];
            for (int j = 0; j < 8; j++) {
                if ((CRC & 0x0001) != 0) {
                    CRC >>= 1;
                    CRC ^= polynomial;

                } else {
                    CRC >>= 1;
                }
            }
        }
        System.out.println(CRC);
        return CRC;
    }
}

