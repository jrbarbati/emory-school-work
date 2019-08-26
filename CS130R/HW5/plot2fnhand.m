function plot2fnhand( fn1, fn2 )
% PLOT2FNHAND - plots the two input args (functions) from 1 to n
% n is a random int from [4, 10]
limit = randi([4, 10]);
x = [1:limit];
plot(x, fn1(x));
figure
plot(x, fn2(x));
end