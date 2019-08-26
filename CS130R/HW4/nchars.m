function [ stringRep ] = nchars( chars, num )
%NCHARS creates a string of chars of length num
%Takes the char and generates a string of length num consisting only of
%that char
stringVec = [1:num];
stringVec = char(stringVec);
stringVec([1:num]) = chars;
stringRep = mat2str(stringVec);