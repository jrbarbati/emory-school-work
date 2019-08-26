// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
// WRITTEN BY OTHER STUDENTS - Joseph Barbati

/* ===================================================================
   Skeleton file for CS355 pj4: 4 Phase clock and MPC
   =================================================================== */
/*  ===================================================================
	Circuit to get D1
	=================================================================== */
void C1(const SD &coord, const Signal &R, const Signal &q1, const Signal &q0,
        const Signal &d1)
{
    Module( coord, "C1", (R, q1, q0), d1 );

    Signal not_R, not_q1, not_q0, o1;

    Not( SD(coord, "aa"), R, not_R );
    Xor( SD(coord, "ab"), (q1, q0), o1 );
    And( SD(coord, "ac"), (o1, not_R), d1 );
}

/*  ===================================================================
	Circuit to get D0
	=================================================================== */
void C0(const SD &coord, const Signal &R, const Signal &q1, const Signal &q0,
        const Signal &d0)
{   
    Module( coord, "C0", (R, q1, q0), d0 );

    Signal not_R, not_q1, not_q0, o1, o2, o3;

    Not( SD(coord, "aa"), R, not_R );
    Not( SD(coord, "ca"), q1, not_q1 );
    Not( SD(coord, "ea"), q0, not_q0 );

    And( SD(coord, "bb"), (not_q1, not_q0), o1 );
    And( SD(coord, "db"), (q1, not_q0), o2 );

    Or( SD(coord, "cc"), (o1, o2), o3 );
    And( SD(coord, "cd"), (o3, not_R), d0 );
}   

/* --------------------------------------------------------------------
   Four_Phase_Clock( coord, Reset, Clk, Phase )

     inputs:  Reset = pressing reset will force Four_Phase_Clock()
		      to go to phase 1
              Clk = toggling Clk twice will make Four_Phase_Clock()
		      go to the next phase

              Progression:   Ph1 --> Ph2 --> Ph3 --> Ph4 --+
                              ^                            |
                              |                            |
                              +----------------------------+

     output: Phase = 4 bit array representing the 4 phases

                     Phase[0]   Phase[1]   Phase[2]   Phase[3]
              ==================================================
                Ph1:     1         0          0         0
                Ph2:     0         1          0         0
                Ph3:     0         0          1         0
                Ph4:     0         0          0         1
   -------------------------------------------------------------------- */
void Four_Phase_Clock(const SD &coord,
                      const Signal &Reset, const Signal &Clk,
                      const Signal &Phase)
{
    Module( coord, "4-Ph-Clock", (Clk, Reset), (Phase[0], Phase[1], Phase[2], Phase[3])   );

    /* ----------------------------------------------------------------------
       Write your clock Four_Phase_Clock ciruit here

       Make sure you use a component CompName as follows:

            CompName( SD(coord,"aa"),  ...., .... );
                      ^^^^^^^^^^^^^^
                      Use this coordinate for EVERY component (keep "aa")
       ---------------------------------------------------------------------- */
    Signal d1, d0, q1, q0, not_q0, not_q1;

    C1( SD(coord, "ba"), Reset, q1, q0, d1 );
    Dff( SD(coord, "bb"), (Zero, d1, Clk, Reset), q1 );
    C0( SD(coord, "ca"), Reset, q1, q0, d0 );
    Dff( SD(coord, "cb"), (Zero, d0, Clk, Reset), q0 );


    Not( SD(coord, "da"), q1, not_q1 );
    Not( SD(coord, "db"), q0, not_q0 );

    And( SD(coord, "ac"), (not_q1, not_q0), Phase[0] );
    And( SD(coord, "bc"), (not_q1, q0), Phase[1] );
    And( SD(coord, "cc"), (q1, not_q0), Phase[2] );
    And( SD(coord, "dc"), (q1, q0), Phase[3] );
}


/*  ===================================================================
	8-Bit Adder
	=================================================================== */
void Full_Adder8(const SD &coord, const Signal &b, const Signal &s)
{
	Module( coord, "Full_Adder8", b, s );
	
	Signal out[8];
	
	Full_Adder( SD(coord, "aa"), One , b[0], Zero  , s[0], out[0] );
	Full_Adder( SD(coord, "ab"), Zero, b[1], out[0], s[1], out[1] );
	Full_Adder( SD(coord, "ac"), Zero, b[2], out[1], s[2], out[2] );
	Full_Adder( SD(coord, "ad"), Zero, b[3], out[2], s[3], out[3] );
	Full_Adder( SD(coord, "ba"), Zero, b[4], out[3], s[4], out[4] );
	Full_Adder( SD(coord, "bb"), Zero, b[5], out[4], s[5], out[5] );
	Full_Adder( SD(coord, "bc"), Zero, b[6], out[5], s[6], out[6] );
	Full_Adder( SD(coord, "bd"), Zero, b[7], out[6], s[7], out[7] );
}

/*  ===================================================================
	2x1 Multiplexor
	=================================================================== */
void Mux(const SD &coord, const Signal &a, const Signal &b, const Signal &c,
		 const Signal &o)
{
	Module( coord, "Mux", (a,b,c), o );
	
	Signal not_c, out1, out2;
	
	Not( SD(coord, "aa"), c, not_c );
	
	And( SD(coord, "ab"), (a, not_c), out1 );
	And( SD(coord, "bb"), (b, c), out2 );
	
	Or( SD(coord, "ac-bc"), (out1, out2), o );
}

/*  ===================================================================
	8-Bit 2x1 Multiplexor
	=================================================================== */
void Mux8(const SD &coord, const Signal &a, const Signal &b, const Signal &c,
		  const Signal &o)
{
	Module( coord, "Mux8", (a,b,c), o );
	
	Mux( SD(coord, "aa"), a[0], b[0], c, o[0] );
	Mux( SD(coord, "ab"), a[1], b[1], c, o[1] );
	Mux( SD(coord, "ac"), a[2], b[2], c, o[2] );
	Mux( SD(coord, "ad"), a[3], b[3], c, o[3] );
	Mux( SD(coord, "ba"), a[4], b[4], c, o[4] );
	Mux( SD(coord, "bb"), a[5], b[5], c, o[5] );
	Mux( SD(coord, "bc"), a[6], b[6], c, o[6] );
	Mux( SD(coord, "bd"), a[7], b[7], c, o[7] );
}

/*  ===================================================================
	8-Bit D-FlipFlop
	=================================================================== */
void Dff8(const SD &coord, const Signal &Reset, const Signal &Clk,
		  const Signal &d, const Signal &mpc)
{
	Module( coord, "Dff8", (Reset, Clk, d), mpc );
	Dff( SD(coord, "aa"), (Zero, d[0], Clk, Reset), mpc[0] );
	Dff( SD(coord, "ab"), (Zero, d[1], Clk, Reset), mpc[1] );
	Dff( SD(coord, "ac"), (Zero, d[2], Clk, Reset), mpc[2] );
	Dff( SD(coord, "ad"), (Zero, d[3], Clk, Reset), mpc[3] );
	Dff( SD(coord, "ba"), (Zero, d[4], Clk, Reset), mpc[4] );
	Dff( SD(coord, "bb"), (Zero, d[5], Clk, Reset), mpc[5] );
	Dff( SD(coord, "bc"), (Zero, d[6], Clk, Reset), mpc[6] );
	Dff( SD(coord, "bd"), (Zero, d[7], Clk, Reset), mpc[7] );
}

/* --------------------------------------------------------------------
   MPC_With_Reset( coord, Reset, Clk, Branch, Addr, MPC )

        The MPC is a 8-bit register that is updated with a new value
        when he MPC receives a "Clk" signal

     inputs: Reset = pressing Reset will store 00000000 into the MPC
	     Clk = toggling Clk twice will make the MPC_With_Reset
	           circuit update itself with the next MPC value

             Branch: if Branch = 0, MPC is updated with MPC + 1
                     if Branch = 1, MPC is updated with Addr

             Addr = the branch address - used only when Branch = 1

     output: MPC = 8 bit array representing the address in the MPC
   -------------------------------------------------------------------- */
void MPC_With_Reset(const SD &coord, const Signal &Reset, const Signal &Clk,
              		const Signal &Branch, const Signal &Addr, const Signal &MPC)
{
    Module( coord, "MPC-W-Reset", (Reset, Clk, Branch, Addr), MPC);

    /* ----------------------------------------------------------------------
       Write your MPC_With_Reset ciruit here

       Make sure you use a component CompName as follows:

            CompName( SD(coord,"aa"),  ...., .... );
                      ^^^^^^^^^^^^^^
                      Use this coordinate for EVERY component (keep "aa")
       ---------------------------------------------------------------------- */
    Sig(added, 8);
    Sig(selected, 8);
	Full_Adder8( SD(coord, "aa"), MPC, added );
	Mux8( SD(coord, "ba"), added, Addr, Branch, selected );
	Dff8( SD(coord, "ca"), Reset, Clk, selected, MPC);
}



