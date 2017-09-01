// See LICENSE.txt for license details.
package problems

import chisel3._

// Problem:
//
// Implement a shift register with four 8-bit stages.
// Shift should occur on every clock.
//
class VecShiftRegisterSimple extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(8.W))
    val out = Output(UInt(8.W))
  })

  val initValues = Seq.fill(4) { 0.U(8.W) }
  val delays = RegInit(Vec(initValues))

  // Implement below ----------
  delays(0) := io.in
  for(i <- 3 until 0 by -1) {
    delays(i) := delays(i - 1)
  }
  io.out := delays(3)
  // Implement above ----------
}
