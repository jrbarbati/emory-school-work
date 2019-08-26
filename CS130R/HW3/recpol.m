function [ r, theta ] = recpol( x, y )
%RECPOL calculates polar coordinates r and theta 
%   takes in rectangular coordinats and returns the equivalent polar
%   coordinates 
r = sqrt(x^2 + y^2);
theta = atan(y/x);
end

