/* =============================================================================
                                   Honor Code
    THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
    WRITTEN BY OTHER STUDENTS - Joseph Barbati
   ========================================================================== */

/* ========================================================================
   datapath.h: skeleton project file for CS355

   Use this file to write the DataPath circuit component of Pj6
   ======================================================================== */

void Latch(const SD &coord, const Signal &d, const Signal &q, const Signal &clk)
{
	Module( coord, "Latch", (d, clk), q );

	Signal not_d, s, r, nor_s;

	Not( SD(coord, "ba"), d, not_d );

	And( SD(coord, "ab"), (clk, d),     s );
	And( SD(coord, "bb"), (clk, not_d), r );

	Nor( SD(coord, "ac"), (s, q), nor_s );
	Nor( SD(coord, "bc"), (r, nor_s), q );
}

void Latch16(const SD &coord, const Signal &in, const Signal& clk, 
			 const Signal &out)
{
	Module( coord, "Latch16", (in, clk), out );

	Latch( SD(coord, "aa"), in[0],  out[0],  clk );
	Latch( SD(coord, "ab"), in[1],  out[1],  clk );
	Latch( SD(coord, "ac"), in[2],  out[2],  clk );
	Latch( SD(coord, "ad"), in[3],  out[3],  clk );
	Latch( SD(coord, "ae"), in[4],  out[4],  clk );
	Latch( SD(coord, "af"), in[5],  out[5],  clk );
	Latch( SD(coord, "ag"), in[6],  out[6],  clk );
	Latch( SD(coord, "ah"), in[7],  out[7],  clk );
	Latch( SD(coord, "ba"), in[8],  out[8],  clk );
	Latch( SD(coord, "bb"), in[9],  out[9],  clk );
	Latch( SD(coord, "bc"), in[10], out[10], clk );
	Latch( SD(coord, "bd"), in[11], out[11], clk );
	Latch( SD(coord, "be"), in[12], out[12], clk );
	Latch( SD(coord, "bf"), in[13], out[13], clk );
	Latch( SD(coord, "bg"), in[14], out[14], clk );
	Latch( SD(coord, "bh"), in[15], out[15], clk );
}

void DataPath(const SD &coord,      const Signal &mir,  const Signal &mbr, 
			  const Signal &Phase,  const Signal &Reset,const Signal &R0, 
			  const Signal &R1,     const Signal &R2,   const Signal &R3, 
			  const Signal &R4,     const Signal &R5,   const Signal &R6, 
			  const Signal &R7,     const Signal &R8,   const Signal &R9, 
			  const Signal &R10,    const Signal &R11,  const Signal &R12, 
			  const Signal &R13,    const Signal &R14,  const Signal &R15, 
			  const Signal &ABus,   const Signal &BBus, const Signal &ALatch, 
			  const Signal &BLatch, const Signal &AMux, const Signal &ALU, 
			  const Signal &CBus,   const Signal &N,    const Signal &Z)
{
    Module( coord, "DataPath", (mir, mbr, Phase, Reset), 
    		(R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, 
    		 R15, ABus, BBus, ALatch, BLatch, AMux, ALU, CBus, N, Z) );

    /* ----------------------------------------------------------------------
      Write your DataPath ciruit here

      Make sure you use a component CompName as follows:

            CompName( SD(coord,"aa"),  ...., .... );
                      ^^^^^^^^^^^^^^
                      Use this coordinate for EVERY component (keep "aa")
       ---------------------------------------------------------------------- */
    Sig(d, 16); // Decoder output
    Signal en_dec; // Enable decoder signal
    
    And( SD(coord, "ab"), (Phase[3],mir[20]), en_dec );
    
    Decoder( SD(coord, "aa"), en_dec, (mir[19], mir[18], mir[17], mir[16]),
    		 (d[15],d[14],d[13],d[12],d[11],d[10],d[9],d[8],d[7],d[6],d[5],d[4],
    		 d[3],d[2],d[1],d[0]) ); // RegDecoder
    		 
    ResetableReg16( SD(coord, "bb"), CBus, d[0], Reset, R0 );
    // Reg16(...) did not input the data in the correct phase, but using 
    // ResetableReg16(...) with Zero as Reset (so it never resets) works as it 
    // should (i.e. according to /home/cs355000/Solutions/pj4-Datapath)
    ResetableReg16( SD(coord, "bb"), CBus, d[1], Zero,  R1 );
    ResetableReg16( SD(coord, "bb"), CBus, d[2], Zero,  R2 );
    ResetableReg16( SD(coord, "bb"), CBus, d[3], Zero,  R3 );
    ResetableReg16( SD(coord, "bb"), CBus, d[4], Zero,  R4 );
    Constant16( SD(coord, "bb"), 0, R5 );
    Constant16( SD(coord, "bb"), 1, R6 );
    Constant16( SD(coord, "bb"), -1, R7 );
    ResetableReg16( SD(coord, "bb"), CBus, d[8],  Zero,  R8  );
    ResetableReg16( SD(coord, "bb"), CBus, d[9],  Zero,  R9  );
    ResetableReg16( SD(coord, "bb"), CBus, d[10], Zero,  R10 );
    ResetableReg16( SD(coord, "bb"), CBus, d[11], Zero,  R11 );
    ResetableReg16( SD(coord, "bb"), CBus, d[12], Zero,  R12 );
    ResetableReg16( SD(coord, "bb"), CBus, d[13], Zero,  R13 );
    ResetableReg16( SD(coord, "bb"), CBus, d[14], Zero,  R14 );
    ResetableReg16( SD(coord, "bb"), CBus, d[15], Zero,  R15 );
    
	Mux( SD(coord, "cc"), (mir[11], mir[10], mir[9], mir[8]),
	     (R15,R14,R13,R12,R11,R10,R9,R8,R7,R6,R5,R4,R3,R2,R1,R0), ABus ); //ABusMux
	Mux( SD(coord, "bd"), (mir[15], mir[14], mir[13], mir[12]),
	     (R15,R14,R13,R12,R11,R10,R9,R8,R7,R6,R5,R4,R3,R2,R1,R0), BBus ); //BBusMux

	Latch16( SD(coord, "dc"), ABus, Phase[1], ALatch ); // ALatch
	Latch16( SD(coord, "dd"), BBus, Phase[1], BLatch ); // BLatch

	Mux( SD(coord, "ec"), mir[31], (mbr, ALatch), AMux ); // AMux
	ALU16( SD(coord,"fc-fd"), AMux, BLatch, (mir[28],mir[27]), ALU, N, Z ); // ALU from pj3
	SHIFTER16( SD(coord, "gc-gd"), ALU, (mir[26],mir[25]), CBus ); // Shifter from pj3
}



