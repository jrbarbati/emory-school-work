function [ min, max ] = minmaxcheck()
%MINMAXCHECK Prompts user for min and max, checks to make sure min is less
%than max
%   
    inputMin = input('Please input a minimum temperature (F): ');
    inputMax = input('Please input a maximum temperature (F): ');
    [min, max] = check(inputMin, inputMax);
end
function [ min, max ] = check(a, b)
%CHECK checks if min is lower than max, switches them if not
if a > b
    temp = a;
    a = b;
    b = temp;
end
min = a;
max = b;
end 