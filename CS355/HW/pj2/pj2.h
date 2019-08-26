// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
// WRITTEN BY OTHER STUDENTS - Joseph Barbati

/* =============================================================================
   Project 2: skeleton file
   ========================================================================== */

void Multiply4( const SD &coord,
                const Signal &x, const Signal &y, const Signal &m)
{
   Module( coord, "Multiple", (x,y), m);

   /* ==========================================================================
      Write the multiply circuit here....

      When you're done, compile with:

              	cs355sim  pj2-main

      And run it with:

		simex
      ======================================================================= */
    Sig(o, 32); // Various Outputs
    // x[3...0] AND y[0]
    And(SD(coord, "ha"),(x[0],y[0]),m[0]);
    And(SD(coord, "ga"),(x[1],y[0]),o[0]); // o[0] -> x1&y0
    And(SD(coord, "fa"),(x[2],y[0]),o[1]); // o[1] -> x2&y0
    And(SD(coord, "ea"),(x[3],y[0]),o[2]); // o[2] -> x3&y0
    // x[3...0] AND y[1]
    And(SD(coord, "gb"),(x[0],y[1]),o[3]); // o[3] -> x0&y1
    And(SD(coord, "fb"),(x[1],y[1]),o[4]); // o[4] -> x1&y1
    And(SD(coord, "eb"),(x[2],y[1]),o[5]); // o[5] -> x2&y1
    And(SD(coord, "db"),(x[3],y[1]),o[6]); // o[6] -> x3&y1
    // Full Adders
    Full_Adder(SD(coord, "gc"),o[0],o[3],Zero,m[1],o[7]); // o[7] -> carry out
    Full_Adder(SD(coord, "fc"),o[1],o[4],o[7],o[8],o[9]); // o[8] -> sum, o[9] -> carry out
    Full_Adder(SD(coord, "ec"),o[2],o[5],o[9],o[10],o[11]); // o[10] -> sum, o[11] -> carry out
    Full_Adder(SD(coord, "dc"),Zero,o[6],o[11],o[12],o[13]); // o[12] -> sum, o[13] -> carry out
    // x[3...0] AND y[2]
    And(SD(coord, "fd"),(x[0],y[2]),o[14]); // o[14] -> x0&y2
    And(SD(coord, "ed"),(x[1],y[2]),o[15]); // o[15] -> x1&y2
    And(SD(coord, "dd"),(x[2],y[2]),o[16]); // o[16] -> x2&y2
    And(SD(coord, "cd"),(x[3],y[2]),o[17]); // o[17] -> x3&y2
    // Full Adders
    Full_Adder(SD(coord, "fe"),o[8],o[14],Zero,m[2],o[18]); // o[18] -> carry out
    Full_Adder(SD(coord, "ee"),o[10],o[15],o[18],o[19],o[20]); // o[19] -> sum, o[20] -> carry out
    Full_Adder(SD(coord, "de"),o[12],o[16],o[20],o[21],o[22]); // o[21] -> sum, o[22] -> carry out
    Full_Adder(SD(coord, "ce"),o[13],o[17],o[22],o[23],o[24]); // o[23] -> sum, o[24] -> carry out
    // x[3...0] AND y[3]
    And(SD(coord, "ef"),(x[0],y[3]),o[25]); // o[25] -> x0&y2
    And(SD(coord, "df"),(x[1],y[3]),o[26]); // o[26] -> x1&y2
    And(SD(coord, "cf"),(x[2],y[3]),o[27]); // o[27] -> x2&y2
    And(SD(coord, "bf"),(x[3],y[3]),o[28]); // o[28] -> x3&y2
    // Full Adders
    Full_Adder(SD(coord, "eh"),o[19],o[25],Zero,m[3],o[29]); // o[29] -> carry out
    Full_Adder(SD(coord, "dh"),o[21],o[26],o[29],m[4],o[30]); // o[30] -> carry out
    Full_Adder(SD(coord, "ch"),o[23],o[27],o[30],m[5],o[31]); // o[31] -> carry out
    Full_Adder(SD(coord, "bh"),o[24],o[28],o[31],m[6],m[7]);
}
