// See LICENSE.txt for license details.
package problems

import chisel3._

// Problem:
//
// Implement a loadable shift register with four 4-bit stages using Vec
// Shift occurs if 'shift' is asserted
// Load  occurs if 'load'  is asserted
// Whole state should be replaced with 'ins' when loaded
//
class VecShiftRegister extends Module {
  val io = IO(new Bundle {
    val ins   = Input(Vec(4, UInt(4.W)))
    val load  = Input(Bool())
    val shift = Input(Bool())
    val out   = Output(UInt(4.W))
  })
  // Implement below ----------
  val initVals = Seq.fill(4) { 0.U(4.W) }
  val delays = RegInit(Vec(initVals))

  when(io.load) { 
	  delays := io.ins
  }
  .elsewhen(io.shift) {
	for(i <- 3 until 0 by -1) {
		delays(i) := delays(i - 1)
	}
  }

  io.out := delays(3)
  // Implement above ----------
}
