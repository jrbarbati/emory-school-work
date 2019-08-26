%Chapter 1
%Exercise 12 
ftemp = 212;
ctemp = ftemp - 320 * (5 / 9);

%Exercise 15
r1 = 60;
r2 = 30;
r3 = 15;
combinedResistance = 1 / ((1/r1) + (1/r2) + (1/r3));

%Exercise 17
%round() rounds up if decimal number is .5 or above and rounds down
%otherwise.
%floor() always rounds down no matter what the decimal place is, for
%example, floor(16.99999999999) is 16.
%Conversely, ceil() always rounds up, for example ceil(16.000000001) is 17.

%Exercise 19
partOne = sqrt(19);
partTwo = 3^12;
partThree = tan(pi);

%Exercise 28
%realmin and realmax

%Exercise 32
containmentTankRadius = 32;
containmentTankCost = (32430 / containmentTankRadius) + 428 * pi *...
    containmentTankRadius;

%Chapter 2
%Exercise 4
vecOne = [-5:1:-1];
vecOneLS = linspace(-5, -1, 5);
vecTwo = [5:2:9];
vecTwoLS = linspace(5, 9, 3);
vecThree = [8:-2:4];
vecThreeLS = linspace(8, 4, 3);

%Exercise 8
mat = [7:10; 12:-2:6];
element = mat(1, 3);
secondRow = mat(2, :);
firstTwoColumns = [mat(:, 1) mat(:, 2)];

%Exercise 19
layerone = zeros(2, 4);
layertwo = zeros(2, 4) + 1;
layerthree = ones(2, 4) * 5;
mat(:,:,1) = layerone;
mat(:,:,2) = layertwo;
mat(:,:,3) = layerthree;

%Exercise 25
vec = [1, .5, .25, .125, 1/16];
sumFirstFive = sum(vec);

%Exercise 38
rainmat = [25 33 29 42; 53 44 40 56; etc];
maxRain = max(max(rainmat));
columnNumber = find(maxRain == max(rainmat));
indexOfMax = find(rainmat == maxRain);
sizeOfRainmat = size(rainmat);
numberOfRows = sizeOfRainmat(1);
districtNumber = indexOfMax - (numberOfRows*(columnNumber - 1));
%maxRain finds the maximum amount of rain that fell in all districs over
%the 4 years.  columnNumber finds the column number in which that maximum 
%lies.  indexOfMax finds the index where the max lies.  sizeOfRainmat finds
%the size of rainmat matrix, and numberOfRows extracts the first index of
%that vector.  Finally, district number takes the index and subtracts the
%numberOfRows multiplied by the columnNumber the max is in minus 1.  It
%does this so it finds the row in which the maximum of the matrix lies, and
%once it finds the row number where the maximum is, that is also the
%district number. (The reason I went through all this trouble is because
%the question asked which district the maximum rain fell, and as far as I
%could tell, there's no function to exract the (r x c) format of a specific
%number.  If that exists, and if it was introduced in this chapter, then I
%missed it).