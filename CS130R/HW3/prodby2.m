function [ product ] = prodby2( n )
%PRODBY2 product of the odd numbers between 1 and n
%   Takes a number n and returns the product of 1 * 3 * 5 * ... * n 
%   (or n - 1 if n is even)
product = 1;
for i = 1:2:n
    product = product * i;
end

