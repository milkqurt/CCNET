package CCNET;

public class CCNET_MESSAGE {

  private final long polynomial = 0x08408;
  CCNET.CRC crc = new CRC();

  private byte SYNC;
  private byte ADR;
  private byte LNG;
  private byte DATA;
  private long CRC;

  public boolean setMessage(byte[] bytes) {
    CRC = 0;
    long sizeD = bytes.length;
    SYNC = bytes[0];
    ADR = bytes[1];
    LNG = bytes[2];
    DATA = bytes[3];
    for (int i = 0; i < sizeD; i++) {
      CRC ^= bytes[i];
      for (int j = 0; j < 8; j++) {
        if ((CRC & 0x0001) != 0) {
          CRC >>= 1;
          CRC ^= polynomial;

        } else {
          CRC >>= 1;
        }
      }
    }
    System.out.println("SYNC - " + SYNC + "\n" + "ADR - " + ADR + "\n" +
            "LNG - " + LNG + "\n" + "DATA - " + DATA);
    return (CRC == crc.GetCRC(bytes, sizeD));
  }

  public boolean getMessage(byte SYNC, byte ADR, byte LNG, byte DATA) {
    CRC = 0;
    byte[] bytes = {SYNC, ADR, LNG, DATA};
    long sizeD = bytes.length;
    for (int i = 0; i < sizeD; i++) {
      CRC ^= bytes[i];
      System.out.println(bytes[i]);
      for (int j = 0; j < 8; j++) {
        if ((CRC & 0x0001) != 0) {
          CRC >>= 1;
          CRC ^= polynomial;
        } else {
          CRC >>= 1;
        }
      }
    }

    return (CRC == crc.GetCRC(bytes, sizeD));
  }
}
