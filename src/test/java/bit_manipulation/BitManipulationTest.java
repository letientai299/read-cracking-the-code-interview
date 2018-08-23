package bit_manipulation;

import org.junit.jupiter.api.Test;

import static bit_manipulation.BitManipulation.fromBinaryString;
import static bit_manipulation.BitManipulation.turnBits;
import static bit_manipulation.BitManipulation.turnBitsBitShifting;
import static org.assertj.core.api.Assertions.assertThat;

class BitManipulationTest {

  @Test
  public void testTurnBits() throws Exception {
    long n = Long.valueOf("10000000000000000000", 2);
    long m = Long.valueOf("10101", 2);
    long res = turnBits(n, m, 2, 6);
    assertThat(Long.toBinaryString(res)).isEqualTo("10000000000001010100");
  }

  @Test
  public void testTurnBitsBitShifting() throws Exception {
    long n = Long.valueOf("10000000000000000000", 2);
    long m = Long.valueOf("10101", 2);
    long res = turnBitsBitShifting(n, m, 2, 6);
    assertThat(Long.toBinaryString(res)).isEqualTo("10000000000001010100");
  }

  @Test
  void testFromBinaryString_1() {
    String s = "1.1"; // 1.5
    float v = fromBinaryString(s);
    assertThat(v).isEqualTo(1.5f);
  }

  @Test
  void testFromBinaryString_2() {
    String s = "101.101"; // 5.625
    float v = fromBinaryString(s);
    assertThat(v).isEqualTo(5.625f);
  }
}
