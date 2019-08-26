// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
// WRITTEN BY OTHER STUDENTS - Joseph Barbati

#include "Sim.h"

void simnet()
{
	// Inputs
	Sig(a, 1);
	Sig(b, 1);
	Sig(c, 1);
	Sig(d, 1);
	Sig(e, 1);
	
	// Outputs
	Sig(x, 1); // 2^2 bit
	Sig(y, 1); // 2^1 bit
	Sig(z, 1); // 2^0 bit

	// Signals
	Signal na, nb, nc, nd, ne;
	Signal x1, x2, x3, x4, x5, x6;
	Signal y1, y2, y3, y4, y5, y6, y7, y8, y9, y10;
	Signal y11, y12, y13, y14, y15, y16, y17, y18, y19, y20;
	Signal z1, z2, z3, z4, z5, z6, z7, z8, z9, z10;
	Signal z11, z12, z13, z14, z15, z16;

	// Switches
	Switch("aa", a, '0', Zero);
	Switch("ca", b, '1', Zero);
	Switch("ea", c, '2', Zero);
	Switch("ga", d, '3', Zero);
	Switch("ia", e, '4', Zero);

	// Negations
	Not("ba", a, na);
	Not("da", b, nb);
	Not("fa", c, nc);
	Not("ha", d, nd);
	Not("ja", e, ne);

	// Outputs
	Probe("cd", x);
	Probe("ed", y);
	Probe("gd", z);

	// And Gates
	// 2^2 bit
	And("cb", (na, b,  c,  d,  e),  x1);
	And("cb", (a,  nb, c,  d,  e),  x2);
	And("cb", (a,  b,  nc, d,  e),  x3);
	And("cb", (a,  b,  c,  nd, e),  x4);
	And("cb", (a,  b,  c,  d,  ne), x5);
	And("cb", (a,  b,  c,  d,  e),  x6);
	// 2^1 Bit
	And("eb", (na, nb, nc, d,  e),  y1);
	And("eb", (na, nb, c,  nd, e),  y2);
	And("eb", (na, nb, c,  d,  ne), y3);
	And("eb", (na, nb, c,  d,  e),  y4);
	And("eb", (na, b,  nc, nd, e),  y5);
	And("eb", (na, b,  nc, d,  ne), y6);
	And("eb", (na, b,  nc, d,  e),  y7);
	And("eb", (na, b,  c,  nd, ne), y8);
	And("eb", (na, b,  c,  nd, e),  y9);
	And("eb", (na, b,  c,  d,  ne), y10);
	And("eb", (a,  nb, nc, nd, e),  y11);
	And("eb", (a,  nb, nc, d,  ne), y12);
	And("eb", (a,  nb, nc, d,  e),  y13);
	And("eb", (a,  nb, c,  nd, ne), y14);
	And("eb", (a,  nb, c,  nd, e),  y15);
	And("eb", (a,  nb, c,  d,  ne), y16);
	And("eb", (a,  b,  nc, nd, ne), y17);
	And("eb", (a,  b,  nc, nd, e),  y18);
	And("eb", (a,  b,  nc, d,  ne), y19);
	And("eb", (a,  b,  c,  nd, ne), y20);
	// 2^0 bit
	And("gb", (na, nb, nc, nd, e),  z1);
	And("gb", (na, nb, nc, d,  ne), z2);
	And("gb", (na, nb, c,  nd, ne), z3);
	And("gb", (na, nb, c,  d,  e),  z4);
	And("gb", (na, b,  nc, nd, ne), z5);
	And("gb", (na, b,  nc, d,  e),  z6);
	And("gb", (na, b,  c,  nd, e),  z7);
	And("gb", (na, b,  c,  d,  ne), z8);
	And("gb", (a,  nb, nc, nd, ne), z9);
	And("gb", (a,  nb, nc, d,  e),  z10);
	And("gb", (a,  nb, c,  nd, e),  z11);
	And("gb", (a,  nb, c,  d,  ne), z12);
	And("gb", (a,  b,  nc, nd, e),  z13);
	And("gb", (a,  b,  nc, d,  ne), z14);
	And("gb", (a,  b,  c,  nd, ne), z15);
	And("gb", (a,  b,  c,  d,  e),  z16);

	// Or Gates
	Or("cc", (x1,x2,x3,x4,x5,x6), x);
	Or("ec", (y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13,y14,y15,y16,y17,y18,y19,y20), y);
	Or("gc", (z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16), z);
}