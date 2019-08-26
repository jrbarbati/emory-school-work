function [ average ] = averageofelements( inputMat )
%AVERAGEOFELEMENTS calculates the average of all elements in a matrix
%   requires matrix as input and calculates the average of all the elements
%   in the matrix
[r, c] = size(inputMat);
sum = 0;
for i = 1:r
    for j = 1:c
        sum = sum + inputMat(i, j);
    end
end
average = sum / numel(inputMat);

end

