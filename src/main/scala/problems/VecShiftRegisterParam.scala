// See LICENSE.txt for license details.
package problems

import chisel3._

// Problem:
//
// Implement a parametrized simple shift register.
// 'n' is the number of elements in the shift register.
// 'w' is the width of one element.

class VecShiftRegisterParam(val n: Int, val w: Int) extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(w.W))
    val out = Output(UInt(w.W))
  })

  // Implement below ----------
  val initVals = Seq.fill(n) { 0.U(w.W) }
  val delays = RegInit(Vec(initVals))

  for(i <- n - 1 until 0 by -1) {
    delays(i) := delays(i - 1)
  }

  delays(0) := io.in
  io.out := delays(n - 1)
}
// Implement above ----------
