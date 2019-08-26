function [ num ] = fibonacci( n )
% FIBONACCI finds the nth fibonacci number
if n == 0
    num = 0;
    return;
elseif n == 1
    num = 1;
    return;
else
    num = fibonacci(n - 1) + fibonacci(n - 2);
end