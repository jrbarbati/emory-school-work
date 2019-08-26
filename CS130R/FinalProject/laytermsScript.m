%% Layterms
% Usage: layterms('measurement units');

%% Testing Regular Cases
layterms('23 cm^3');
layterms('48 in');
layterms('90 m^2');
layterms('12 tons');
layterms('47 cm^2');
layterms('200 kg');

%% Testing Bug Fixes
layterms('1');
layterms(' fl-oz');
layterms(' m');
layterms('100 ');
layterms('m');
layterms('cm ');

%% Testing Suggestions
layterms('2300000000 m^3');
layterms('2300000000 m');
layterms('2300000000 m^2');
layterms('23000000000 tons');
layterms('2300000000 cm^2');
layterms('2300000000 mg');

%% Testing didYouMean.m
layterms('100 fl oz');
layterms('100 US tons');
layterms('100 milli liters');
layterms('100 kilo meters');
layterms('100 milli meters');
layterms('100 m L');

%% Anything You're Dying To Convert?
layterms('');


