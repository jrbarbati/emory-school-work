#include "Sim.h"

void simnet()
{
	Sig(sw0,1);
	Sig(sw1,1);
	Sig(out,1); // Signal definitions

	Switch("aa", sw0, '0', Zero);
	Switch("ca", sw1, '1', One); // Location, name (Signal), key, Initial-value

	And("bb", (sw0,sw1), out); // Location, inputs, output
	
	Probe("bc", out); // Location, source	
}
