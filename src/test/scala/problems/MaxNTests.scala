// See LICENSE.txt for license details.
package problems

import chisel3.iotesters.PeekPokeTester

// Problem:
//
// Implement test for MaxN using PeekPokeTester
//
class MaxNTests(c: MaxN) extends PeekPokeTester(c) {
  for (i <- 0 until 10) {
    var mx = 0
    for (i <- 0 until c.n) {
      // Implement below ----------
	  val in = rnd.nextInt(1 << c.w)
      poke(c.io.ins(i), in)
	  if(in > mx) { mx = in }
      // Implement above ----------
    }
    step(1)
    // Implement below ----------
    expect(c.io.out, mx)
    // Implement above ----------
  }
}
