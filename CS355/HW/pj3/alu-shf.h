// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
// WRITTEN BY OTHER STUDENTS - Joseph Barbati
/* ===================================================================
   Skeleton file for CS355 pj3: 16 bit ALU and shifter
   =================================================================== */

void Mux4(const SD &coord, const Signal &i, const Signal &c, const Signal &out);

void ALU1(const SD &coord, const Signal &a, const Signal &b, const Signal &c,
          const Signal &c_in, const Signal &s, const Signal &c_out);

void Mux4(const SD &coord, const Signal &i, const Signal &c, const Signal &out)
{
    Module( coord, "Mux4", (i, c), out );

    Signal out_0, out_1, out_2, out_3, not_c0, not_c1;

    Not( SD(coord,"ba"), c[0], not_c1 ); // c1
    Not( SD(coord,"ca"), c[1], not_c0 ); // c0

    And( SD(coord,"ab"), (i[0], not_c1, not_c0), out_0 ); //00
    And( SD(coord,"bb"), (i[1], not_c1,   c[1]), out_1 ); //01
    And( SD(coord,"cb"), (i[2],   c[0], not_c0), out_2 ); //10
    And( SD(coord,"db"), (i[3],   c[0],   c[1]), out_3 ); //11

    Or( SD(coord,"bb-cb"), (out_0, out_1, out_2, out_3), out );
}

void ALU1(const SD &coord, const Signal &a, const Signal &b, const Signal &c,
          const Signal &c_in, const Signal &s, const Signal &c_out)
{
    Module( coord, "ALU-1", (a,b,c,c_in), (s,c_out) );

    Signal out_0, out_1, out_2, out_3;

    Full_Adder( SD(coord,"aa"), a, b, c_in, out_0, c_out ); //00
    And( SD(coord,"ba"), (a,b), out_1 ); //01
    Or( SD(coord,"ca"), (a,Zero), out_2 ); //10
    Not( SD(coord,"da"), a, out_3 ); //11

    Mux4( SD(coord,"bb-cb"), (out_3, out_1, out_2, out_0), c, s);
}

/* --------------------------------------------------------------------
   ALU16( coord, a, b, c, s, N, Z)

     inputs:  a = first  (16 bit) binary number
              b = second (16 bit) binary number
	            c = 2 constrol signals to select the ALU operation

		              c[1] c[0]     Function
                 -----------------------------------
                   0    0       Add (s = a + b)
                   0    1       AND (s = a AND b  bitwise and)
                   1    0       Select a (s = a)
                   1    1       Not a (s = not a)

     outputs: s = 16 bit result of the selected operation
	            N = the negative flag (N=1 is result s is negative)
	            Z = the zero flag (Z=1 if the result s is equal to 0)
   -------------------------------------------------------------------- */
void ALU16(const SD &coord,
           const Signal &a, const Signal &b, const Signal &c, // c[1] c[0]
           const Signal &s, const Signal &N, const Signal &Z)
{
    Module( coord, "ALU-16", (a,b,c), (s,N,Z) );

    /* ----------------------------------------------------------------------
        Write your ALU16 ciruit here

        Make sure you use a component CompName as follows:

            CompName( SD(coord,"aa"),  ...., .... );
                      ^^^^^^^^^^^^^^
                      Use this coordinate for EVERY component (keep "aa")
       ---------------------------------------------------------------------- */
    // Intermediate outputs -- carrouts/carryins
    Signal o0, o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12, o13, o14, o15;
    Signal med;

    ALU1( SD(coord,"aa"), a[0],  b[0],  c, Zero, s[0],  o0 );
    ALU1( SD(coord,"ab"), a[1],  b[1],  c, o0,   s[1],  o1 );
    ALU1( SD(coord,"ac"), a[2],  b[2],  c, o1,   s[2],  o2 );
    ALU1( SD(coord,"ad"), a[3],  b[3],  c, o2,   s[3],  o3 );
    ALU1( SD(coord,"ae"), a[4],  b[4],  c, o3,   s[4],  o4 );
    ALU1( SD(coord,"af"), a[5],  b[5],  c, o4,   s[5],  o5 );
    ALU1( SD(coord,"ag"), a[6],  b[6],  c, o5,   s[6],  o6 );
    ALU1( SD(coord,"ah"), a[7],  b[7],  c, o6,   s[7],  o7 );
    ALU1( SD(coord,"ba"), a[8],  b[8],  c, o7,   s[8],  o8 );
    ALU1( SD(coord,"bb"), a[9],  b[9],  c, o8,   s[9],  o9 );
    ALU1( SD(coord,"bc"), a[10], b[10], c, o9,   s[10], o10 );
    ALU1( SD(coord,"bd"), a[11], b[11], c, o10,  s[11], o11 );
    ALU1( SD(coord,"be"), a[12], b[12], c, o11,  s[12], o12 );
    ALU1( SD(coord,"bf"), a[13], b[13], c, o12,  s[13], o13 );
    ALU1( SD(coord,"bg"), a[14], b[14], c, o13,  s[14], o14 );
    ALU1( SD(coord,"bh"), a[15], b[15], c, o14,  s[15], o15 );

    And( SD(coord,"ch"), (One, s[15]), N);
    Or( SD(coord,"dh"), (s[0]-s[15]), med);
    Not( SD(coord,"di"), med, Z);
}




/* --------------------------------------------------------------------
   SHIFTER16( coord, a, c, s)

     inputs:  a = the (16 bit) input binary number
	          c = 2 constrol signals to select the ALU operation

		          c[1] c[0]     Function
                 ---------------------------------
                   0    0       no shift (s == a)
                   0    1       shift right 1 bit position
                   1    0       shift left 1 bit position
                   1    1       not used (any output is OK)

     outputs: s = the shifted result
   -------------------------------------------------------------------- */

void SHIFTER16(const SD &coord,
               const Signal &a, const Signal &c, // c[1] c[0]
               const Signal &s)
{
    Module( coord, "Shifter-16", (a,c), s );

    /* ----------------------------------------------------------------------
        Write your SHIFTER16 ciruit here

        Make sure you use a component CompName as follows:

            CompName( SD(coord,"aa"),  ...., .... );
                      ^^^^^^^^^^^^^^
                      Use this coordinate for EVERY component (keep "aa")
       ---------------------------------------------------------------------- */
    Mux4( SD(coord,"aa"), (Zero, a[1],  Zero,  a[0]),  c, s[0]  );
    Mux4( SD(coord,"ab"), (Zero, a[2],  a[0],  a[1]),  c, s[1]  );
    Mux4( SD(coord,"ac"), (Zero, a[3],  a[1],  a[2]),  c, s[2]  );
    Mux4( SD(coord,"ad"), (Zero, a[4],  a[2],  a[3]),  c, s[3]  );
    Mux4( SD(coord,"ae"), (Zero, a[5],  a[3],  a[4]),  c, s[4]  );
    Mux4( SD(coord,"af"), (Zero, a[6],  a[4],  a[5]),  c, s[5]  );
    Mux4( SD(coord,"ag"), (Zero, a[7],  a[5],  a[6]),  c, s[6]  );
    Mux4( SD(coord,"ah"), (Zero, a[8],  a[6],  a[7]),  c, s[7]  );
    Mux4( SD(coord,"ba"), (Zero, a[9],  a[7],  a[8]),  c, s[8]  );
    Mux4( SD(coord,"bb"), (Zero, a[10], a[8],  a[9]),  c, s[9]  );
    Mux4( SD(coord,"bc"), (Zero, a[11], a[9],  a[10]), c, s[10] );
    Mux4( SD(coord,"bd"), (Zero, a[12], a[10], a[11]), c, s[11] );
    Mux4( SD(coord,"be"), (Zero, a[13], a[11], a[12]), c, s[12] );
    Mux4( SD(coord,"bf"), (Zero, a[14], a[12], a[13]), c, s[13] );
    Mux4( SD(coord,"bg"), (Zero, a[15], a[13], a[14]), c, s[14] );
    Mux4( SD(coord,"bh"), (Zero, Zero,  a[14], a[15]), c, s[15] );

}
