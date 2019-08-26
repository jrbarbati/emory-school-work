function [ mat ] = numbers( varargin )
% NUMBERS takes in 2 - 3 args, i, n, and m
% creates an n x n or n x m matrix of all i's
if nargin == 2
    % if there are 2 args, create an n x n matrix of one number
    mat = zeros(varargin{2});
    mat = mat + varargin{1};
elseif nargin == 3
    % if 3 args, create an n x m matrix of one number
    mat = zeros(varargin{2}, varargin{3});
    mat = mat + varargin{1};
else 
    % otherwise, print error message and return empty matrix
    disp('Incorrect number of input args');
    mat = [];
end % ends if
end % ends numbers()