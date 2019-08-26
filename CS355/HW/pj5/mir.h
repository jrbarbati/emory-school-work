// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
// WRITTEN BY OTHER STUDENTS - Joseph Barbati


/* ==================================================================
 * RomContent[ ] = array of BYTES used to store micro-instructions
 * ================================================================== */

unsigned char RomContent[] = {

     /* ====================================================================

        A micro-instruction is 32 bits or 4 bytes
	Each byte in this byte-array represents 1/4 of a micro-instruction
	Each group of 4 consecutive number forms ONE micro-instruction

        Pj5 TODO:

            Change the first 10 groups of 4 numbers below
   	    and enter the correct micro instruction codes 
        ============================================================ */

     /* ------------------------------------------------------------------
        Meaning of the bits: (to help you set the bits of the micro-instr)

                        ACCAASSM    MRWE  
                        MooLLhhB    ADRn
                        unnUUiiR    R  C                    branch
                        xdd  ff         CCCC    BBBBAAAA    address   
        ------------------------------------------------------------------- */
     /* instr. 0: */  0b00010000, 0b00010001, 0b00001000, 0b00000000, 
     /* instr. 1: */  0b10010001, 0b00010010, 0b00000000, 0b00000000,
     /* instr. 2: */  0b00000000, 0b00010011, 0b01101000, 0b00000000,
     /* instr. 3: */  0b10000001, 0b00010100, 0b10010000, 0b00000000,
     /* instr. 4: */  0b00100000, 0b00010001, 0b00001010, 0b00001111,
     /* instr. 5: */  0b10100001, 0b00010010, 0b00000000, 0b00010000,
     /* instr. 6: */  0b01000000, 0b00010010, 0b01110110, 0b11111111,
     /* instr. 7: */  0b01010100, 0b00010001, 0b00000001, 0b11111111,
     /* instr. 8: */  0b00000100, 0b00010010, 0b10010110, 0b00000000,
     /* instr. 9: */  0b00000100, 0b00010011, 0b10011001, 0b00000000,


     /* You don't need to change the numbers below */
     16, 16, 6, 0,   16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0,
     16, 16, 6, 0,   16, 16, 6, 0,     16, 16, 6, 0,     16, 16, 6, 0
};



void MIR( const SD &coord,
          const Signal & Addr /* 6 bits */, 
          const Signal & mir  /* 32 bits */
        )
{
   Module( coord, "MIR", Addr, mir );

   Rom( SD(coord,"aa"), Addr, mir, 64, 32, RomContent);
}


