function [ stringRep ] = toString( )
%TOSTRING Generates a string of two random numbers
% Generates two randome nums [10, 30] then converts the nums to strings and
% concatenates the strings and returns the concatenated string.
num1 = randi([10, 30]);
num2 = randi([10, 30]);
string1 = sprintf('%d', num1);
string2 = sprintf('%d', num2);
stringRep = strcat(string1, string2);
