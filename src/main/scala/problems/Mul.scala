// See LICENSE.txt for license details.
package problems

import chisel3._
import scala.collection.mutable.ArrayBuffer

// Problem:
//
// Implement a four-by-four multiplier using a look-up table.
//
class Mul extends Module {
  val io = IO(new Bundle {
    val x   = Input(UInt(4.W))
    val y   = Input(UInt(4.W))
    val z   = Output(UInt(8.W))
  })
  val mulsValues = new ArrayBuffer[UInt]()

  // Calculate io.z = io.x * io.y by generating a table of values for mulsValues

  // Implement below ----------
  for(i <- 0 until (1 << 4))
	  for(j <- 0 until (1 << 4))
		  mulsValues +=(i * j).U(8.W)
  val table = Vec(mulsValues)
  io.z := table(io.x << 4.U | io.y)
  // Implement above ----------
}
