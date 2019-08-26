%% Homework 3
%Chapter 5: 1, 4, 8, 23, 28, 35
%Chapter 6: 2, 10, 14, 25 

%Chapter 5
%% Number 1
for i = [1.5:0.2:3.1]
    disp(i);
end

%% Number 4
%beautyofmath.m
beautyofmath

%% Number 8
%prodby2.m
in = input('Please enter a number: ');
answer = prodby2(in);
disp(answer);

%% Number 23
%while x < 10
%   action
%end
%If x is above 10, the action gets skipped altogether.
%Should x be initialized to be 5, x will have to incremented in the loop
%body in order to avoid an infinite loop.

%% Number 28
%averageofelements.m
mat = [1 3 5; 2 4 6];
avg = averageofelements(mat);
disp(avg);
%% Number 35
n=3; 
x=meshgrid(1:n,1:n);
y=x';

%Chapter 6
%% Number 2
%recpol.m
[r, theta] = recpol(1, 1);
fprintf('r: %1.2d \ntheta: %1.2d \n', r, theta);

%% Number 10 
%plotsin.m
x = [1 2 3 4 5];
plotsin(x, 1, 3);

%% Number 14
%Script - classes.m
%Function - classesFunc.m
classes

%% Number 25
%Script - TempConversion.m
%Function - explainTC.m
%Function - minmaxcheck.m
%Function - writeTemps.m
TempConversion
